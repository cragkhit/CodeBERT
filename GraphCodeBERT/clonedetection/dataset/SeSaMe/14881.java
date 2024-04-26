public void init() {
    CardLayout cardLayout = new CardLayout();
    JPanel rightStack = new JPanel ( cardLayout );
    String form = "right:max(40dlu;p), 4dlu, 20dlu, 7dlu,right:max(40dlu;p), 4dlu, 80dlu, 7dlu";
    FormLayout rightLayout = new FormLayout ( form, "" );
    DefaultFormBuilder rightBuilder = new DefaultFormBuilder ( rightLayout );
    rightBuilder.setDefaultDialogBorder();
    mControls = getControls();
    for ( PropertyControl control : mControls ) {
        control.layout ( rightBuilder, this );
    }
    rightStack.add ( rightBuilder.getPanel(), "testTab" );
    add ( rightStack, BorderLayout.CENTER );
}
