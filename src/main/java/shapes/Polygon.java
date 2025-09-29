package shapes;


import geometry.Vec2d;

import java.util.ArrayList;

public class Polygon extends MovableShape {
    ArrayList<Vec2d> vertices;

    public Polygon(Vec2d p, ArrayList<Vec2d> vertices) {
        super(p);
        this.vertices = vertices;
    }

    public double area() {
        double area = 0.0;
        for (int i = 0; i < vertices.size(); i++) {
            Vec2d currentVertex = vertices.get(i);
            Vec2d nextVertex = vertices.get((i+1) % vertices.size()); // Wrap around for first vertex
            area += currentVertex.x() * nextVertex.y() - nextVertex.x() * currentVertex.y();
        }
        return Math.abs(area)/2;
    }

    public double perimeter() {
        double perimeter = 0.0;
        for (int i = 0; i < vertices.size(); i++) {
            Vec2d currentVertex = vertices.get(i);
            Vec2d nextVertex = vertices.get((i+1) % vertices.size()); // Wrap around for first vertex
            perimeter += currentVertex.distance(nextVertex);
        }
        return perimeter;
    }
}