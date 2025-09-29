package shapes;

import geometry.Vec2d;

import java.awt.*;
import java.util.ArrayList;

public class DrawableCircle extends Circle implements Drawable {
    private Color color;

    public DrawableCircle(Vec2d p, double radius, Color color) {
        super(p, radius);
        this.color = color;
    }

    public void draw(Graphics2D g) {
        // draw a filled circle centre at position with radius
        g.setColor(color);
        int diameter = (int) radius*2;

        // Ensure top left of circle start at center
        g.fillOval((int) (position.x()-diameter/2), (int) (position.y()-diameter/2), diameter, diameter);
    }
}