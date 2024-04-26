@BeanProperty ( preferred = true, visualUpdate = true, description
                = "The font for the component." )
public void setFont ( Font font ) {
    Font oldFont = getFont();
    super.setFont ( font );
    if ( font != oldFont ) {
        revalidate();
        repaint();
    }
}
