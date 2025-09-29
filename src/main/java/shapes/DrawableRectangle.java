package shapes;

import geometry.Vec2d;

import java.awt.*;
import java.util.ArrayList;

public class DrawableRectangle extends Rectangle implements Drawable {
    final private Color color;

    public DrawableRectangle(Vec2d p, double width, double height, Color color) {
        super(p, width, height);
        this.color = color;
    }

    public void draw(Graphics2D g) {
        // draw a filled rectangle with width and height centred at position
        g.setColor(color);

        // Ensure top left of rectangle starts at center
        g.fillRect((int) (position.x()-width/2), (int) (position.y()-height/2), (int) width, (int) height);
    }

}