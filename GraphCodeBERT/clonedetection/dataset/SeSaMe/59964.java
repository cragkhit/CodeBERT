public void saveElement ( DataOutputStream out, Element elem ) throws IOException {
    out.writeShort ( getNameId ( elem.getName() ) );
    out.writeByte ( elem.getType() );
    byte flags = 0;
    if ( elem.omitStart() ) {
        flags |= 0x01;
    }
    if ( elem.omitEnd() ) {
        flags |= 0x02;
    }
    out.writeByte ( flags );
    saveContentModel ( out, elem.getContent() );
    if ( elem.exclusions == null ) {
        out.writeShort ( 0 );
    } else {
        short num = 0;
        for ( int i = 0 ; i < elem.exclusions.size() ; i++ ) {
            if ( elem.exclusions.get ( i ) ) {
                num++;
            }
        }
        out.writeShort ( num );
        for ( int i = 0 ; i < elem.exclusions.size() ; i++ ) {
            if ( elem.exclusions.get ( i ) ) {
                out.writeShort ( getNameId ( getElement ( i ).getName() ) );
            }
        }
    }
    if ( elem.inclusions == null ) {
        out.writeShort ( 0 );
    } else {
        short num = 0;
        for ( int i = 0 ; i < elem.inclusions.size() ; i++ ) {
            if ( elem.inclusions.get ( i ) ) {
                num++;
            }
        }
        out.writeShort ( num );
        for ( int i = 0 ; i < elem.inclusions.size() ; i++ ) {
            if ( elem.inclusions.get ( i ) ) {
                out.writeShort ( getNameId ( getElement ( i ).getName() ) );
            }
        }
    }
    {
        short numAtts = 0;
        for ( AttributeList atts = elem.getAttributes() ; atts != null ; atts = atts.getNext() ) {
            numAtts++;
        }
        out.writeByte ( numAtts );
        for ( AttributeList atts = elem.getAttributes() ; atts != null ; atts = atts.getNext() ) {
            out.writeShort ( getNameId ( atts.getName() ) );
            out.writeByte ( atts.getType() );
            out.writeByte ( atts.getModifier() );
            if ( atts.getValue() == null ) {
                out.writeShort ( -1 );
            } else {
                out.writeShort ( getNameId ( atts.getValue() ) );
            }
            if ( atts.values == null ) {
                out.writeShort ( 0 );
            } else {
                out.writeShort ( ( short ) atts.values.size() );
                for ( int i = 0; i < atts.values.size(); i++ ) {
                    String s = ( String ) atts.values.elementAt ( i );
                    out.writeShort ( getNameId ( s ) );
                }
            }
        }
    }
}
