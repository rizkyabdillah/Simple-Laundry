package LIBRARY;

import java.awt.Color;

public class LibColor {
    
    private Color color = new Color(22,160,133);
    private Color foreColor = new Color(26, 188, 156);
    
    public void setColor(Color col) {
        color = col;
    }
    
    public Color getColor() {
        return color;
    }
    
    public Color getHrefColor() {
        return new Color(color.getRGB() + 50);
    }
    
    public Color foreColor() {
        return foreColor;
    }
    
}
