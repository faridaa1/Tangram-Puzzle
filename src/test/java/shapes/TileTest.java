package shapes;

import geometry.Vec2d;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TileTest {
    @Test
    void testContainsTile() {
        ArrayList<Vec2d> outerPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(0, 0), new Vec2d(0, 10), new Vec2d(10, 10), new Vec2d(10, 0)
        ));
        ArrayList<Vec2d> innerPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(2, 2), new Vec2d(2, 8), new Vec2d(8, 8), new Vec2d(8, 2)
        ));
        ArrayList<Vec2d> overlappingPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(5, 5), new Vec2d(5, 12), new Vec2d(12, 12), new Vec2d(12, 5)
        ));

        Tile t1 = new Tile(new Vec2d(0,0), outerPolygon, Color.BLACK);
        Tile t2 = new Tile(new Vec2d(0,0), innerPolygon, Color.RED);
        Tile t3 = new Tile(new Vec2d(5,10), overlappingPolygon, Color.GREEN);

        assertTrue(t1.contains(t2));
        assertFalse(t1.contains(t3));
    }

    @Test
    void testIntersects() {
        ArrayList<Vec2d> square = new ArrayList<>(Arrays.asList(
                new Vec2d(0, 0), new Vec2d(0, 2), new Vec2d(2, 2), new Vec2d(2, 0)
        ));
        ArrayList<Vec2d> intersectingSquare = new ArrayList<>(Arrays.asList(
                new Vec2d(1, 1), new Vec2d(1, 3), new Vec2d(3, 3), new Vec2d(3, 1)
        ));
        ArrayList<Vec2d> nonIntersectingSquare = new ArrayList<>(Arrays.asList(
                new Vec2d(3, 3), new Vec2d(3, 5), new Vec2d(5, 5), new Vec2d(5, 3)
        ));

        Tile t1 = new Tile(new Vec2d(0,0), square, Color.BLACK);
        Tile t2 = new Tile(new Vec2d(1,1), intersectingSquare, Color.RED);
        Tile t3 = new Tile(new Vec2d(3,3), nonIntersectingSquare, Color.GREEN);

        assertTrue(t1.intersects(t2));
        assertFalse(t1.intersects(t3));
    }

    @Test
    void testContainsPoint() {
        ArrayList<Vec2d> polygon = new ArrayList<>(Arrays.asList(
                new Vec2d(0, 0), new Vec2d(0, 5), new Vec2d(5, 5), new Vec2d(5, 0)
        ));

        Vec2d pointInside = new Vec2d(2, 2);
        Vec2d pointOutside = new Vec2d(6, 6);

        Tile t1 = new Tile(new Vec2d(0,0), polygon, Color.BLACK);

        assertTrue(t1.contains(pointInside));
        assertFalse(t1.contains(pointOutside));
    }

}