@Override
public Sequence<T> next() {
    Sequence<T> sequence = new Sequence<>();
    int[] visitedHops = new int[walkLength];
    Arrays.fill ( visitedHops, -1 );
    int startPosition = position.getAndIncrement();
    int lastId = -1;
    int startPoint = order[startPosition];
    startPosition = startPoint;
    for ( int i = 0; i < walkLength; i++ ) {
        Vertex<T> vertex = sourceGraph.getVertex ( startPosition );
        int currentPosition = startPosition;
        sequence.addElement ( vertex.getValue() );
        visitedHops[i] = vertex.vertexID();
        int cSpread = 0;
        if ( alpha > 0 && lastId != startPoint && lastId != -1 && alpha > rng.nextDouble() ) {
            startPosition = startPoint;
            continue;
        }
        switch ( walkDirection ) {
        case RANDOM:
        case FORWARD_ONLY:
        case FORWARD_UNIQUE:
        case FORWARD_PREFERRED: {
            int[] connections = ArrayUtils.removeElements (
                                    sourceGraph.getConnectedVertexIndices ( vertex.vertexID() ), visitedHops );
            PriorityQueue<Node<T>> queue = new PriorityQueue<> ( Math.max ( 10, connections.length ), new NodeComparator() );
            int start = 0;
            int stop = 0;
            int cnt = 0;
            if ( connections.length > 0 ) {
                for ( int connected : connections ) {
                    Node<T> tNode = new Node<> ( connected, sourceGraph.getConnectedVertices ( connected ).size() );
                    queue.add ( tNode );
                }
                cSpread = spread > connections.length ? connections.length : spread;
                switch ( popularityMode ) {
                case MAXIMUM:
                    start = 0;
                    stop = start + cSpread - 1;
                    break;
                case MINIMUM:
                    start = connections.length - cSpread;
                    stop = connections.length - 1;
                    break;
                case AVERAGE:
                    int mid = connections.length / 2;
                    start = mid - ( cSpread / 2 );
                    stop = mid + ( cSpread / 2 );
                    break;
                }
                cnt = 0;
                List<Node<T>> list = new ArrayList<>();
                double[] weights = new double[cSpread];
                int fcnt = 0;
                while ( !queue.isEmpty() ) {
                    Node<T> node = queue.poll();
                    if ( cnt >= start && cnt <= stop ) {
                        list.add ( node );
                        weights[fcnt] = node.getWeight();
                        fcnt++;
                    }
                    connections[cnt] = node.getVertexId();
                    cnt++;
                }
                int con = -1;
                switch ( spectrum ) {
                case PLAIN: {
                    con = RandomUtils.nextInt ( start, stop + 1 );
                    Vertex<T> nV = sourceGraph.getVertex ( connections[con] );
                    startPosition = nV.vertexID();
                    lastId = vertex.vertexID();
                }
                break;
                case PROPORTIONAL: {
                    double norm[] = MathArrays.normalizeArray ( weights, 1 );
                    double prob = rng.nextDouble();
                    double floor = 0.0;
                    for ( int b = 0; b < weights.length; b++ ) {
                        if ( prob >= floor && prob < floor + norm[b] ) {
                            startPosition = list.get ( b ).getVertexId();
                            lastId = startPosition;
                            break;
                        } else {
                            floor += norm[b];
                        }
                    }
                }
                break;
                }
            } else {
                switch ( noEdgeHandling ) {
                case EXCEPTION_ON_DISCONNECTED:
                    throw new NoEdgesException ( "No more edges at vertex [" + currentPosition + "]" );
                case CUTOFF_ON_DISCONNECTED:
                    i += walkLength;
                    break;
                case SELF_LOOP_ON_DISCONNECTED:
                    startPosition = currentPosition;
                    break;
                case RESTART_ON_DISCONNECTED:
                    startPosition = startPoint;
                    break;
                default:
                    throw new UnsupportedOperationException (
                        "Unsupported noEdgeHandling: [" + noEdgeHandling + "]" );
                }
            }
        }
        break;
        default:
            throw new UnsupportedOperationException ( "Unknown WalkDirection: [" + walkDirection + "]" );
        }
    }
    return sequence;
}
