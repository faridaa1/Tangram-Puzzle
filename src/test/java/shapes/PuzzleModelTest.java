package shapes;

import geometry.Vec2d;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PuzzleModelTest {

    @Test
    void testIsSolved() {
        PuzzleModel model = new PuzzleModel(TangramBetterTiles.getBox(), TangramBetterTiles.getTiles());
        assertFalse(model.isSolved());

        // After solving the puzzle I made note of their coordinates to add here
        ArrayList<Tile> list = new ArrayList<>();
        // Large Triangle 1 (Magenta, top)
        Tile largeTriangle1 = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(355, 353),
                new Vec2d(755, 353),
                new Vec2d(555, 553)
        )), Color.MAGENTA);

        // Large Triangle 2 (Pink, left)
        Tile largeTriangle2 = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(352, 352),
                new Vec2d(552, 552),
                new Vec2d(352, 752)
        )), Color.PINK);

        // Square (Pale green, bottom centre
        Tile diamond = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(558, 558),
                new Vec2d(658, 658),
                new Vec2d(558, 758),
                new Vec2d(458, 658)
        )), Color.RED);

        // Parallelogram (Yellow, right)
        Tile parallelogram = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(764, 352),
                new Vec2d(764, 552),
                new Vec2d(664, 652),
                new Vec2d(664, 452)
        )), Color.YELLOW);

        // Small Triangle 1 (Cyan, centre-right)
        Tile smallTriangle1 = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(560, 556),
                new Vec2d(660, 656),
                new Vec2d(660, 456)
        )), Color.CYAN);

        // Small Triangle 2 (Yellow, right side of the square)
        Tile smallTriangle2 = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(764, 563),
                new Vec2d(764, 763),
                new Vec2d(564, 763)
        )), Color.ORANGE);

        // Small triangle, green bottom left
        Tile mediumTriangle = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(453, 661),
                new Vec2d(553, 761),
                new Vec2d(353, 761)
        )), Color.GREEN);

        list.add(largeTriangle1);
        list.add(largeTriangle2);
        list.add(diamond);
        list.add(parallelogram);
        list.add(smallTriangle1);
        list.add(smallTriangle2);
        list.add(mediumTriangle);
        PuzzleModel model2 = new PuzzleModel(TangramBetterTiles.getBox(), list);
        assertTrue(model2.isSolved());
    }

    @Test
    void testGetStatusText() {
        PuzzleModel model = new PuzzleModel(TangramBetterTiles.getBox(), TangramBetterTiles.getTiles());
        assertEquals("n Overlaps 7 Contains? 0 Solved? false", model.getStatusText());

        // After solving the puzzle I made note of their coordinates to add here
        ArrayList<Tile> list = new ArrayList<>();
        // Large Triangle 1 (Magenta, top)
        Tile largeTriangle1 = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(355, 353),
                new Vec2d(755, 353),
                new Vec2d(555, 553)
        )), Color.MAGENTA);

        // Large Triangle 2 (Pink, left)
        Tile largeTriangle2 = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(352, 352),
                new Vec2d(552, 552),
                new Vec2d(352, 752)
        )), Color.PINK);

        // Square (Pale green, bottom centre
        Tile diamond = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(558, 558),
                new Vec2d(658, 658),
                new Vec2d(558, 758),
                new Vec2d(458, 658)
        )), Color.RED);

        // Parallelogram (Yellow, right)
        Tile parallelogram = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(764, 352),
                new Vec2d(764, 552),
                new Vec2d(664, 652),
                new Vec2d(664, 452)
        )), Color.YELLOW);

        // Small Triangle 1 (Cyan, centre-right)
        Tile smallTriangle1 = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(560, 556),
                new Vec2d(660, 656),
                new Vec2d(660, 456)
        )), Color.CYAN);

        // Small Triangle 2 (Yellow, right side of the square)
        Tile smallTriangle2 = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(764, 563),
                new Vec2d(764, 763),
                new Vec2d(564, 763)
        )), Color.ORANGE);

        // Small triangle, green bottom left
        Tile mediumTriangle = new Tile(new Vec2d(0, 0), new ArrayList<>(List.of(
                new Vec2d(453, 661),
                new Vec2d(553, 761),
                new Vec2d(353, 761)
        )), Color.GREEN);

        list.add(largeTriangle1);
        list.add(largeTriangle2);
        list.add(diamond);
        list.add(parallelogram);
        list.add(smallTriangle1);
        list.add(smallTriangle2);
        list.add(mediumTriangle);
        PuzzleModel model2 = new PuzzleModel(TangramBetterTiles.getBox(), list);
        assertEquals("n Overlaps 0 Contains? 7 Solved? true", model2.getStatusText());
    }

    @Test
    void testGetTileAt() {
        ArrayList<Vec2d> outerPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(0, 0), new Vec2d(0, 10), new Vec2d(10, 10), new Vec2d(10, 0)
        ));
        ArrayList<Vec2d> innerPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(2, 2), new Vec2d(2, 8), new Vec2d(8, 8), new Vec2d(8, 2)
        ));
        ArrayList<Vec2d> innerPolygon2 = new ArrayList<>(Arrays.asList(
                new Vec2d(3, 3), new Vec2d(3, 7), new Vec2d(7, 7), new Vec2d(7, 3)
        ));
        ArrayList<Vec2d> innerPolygon3 = new ArrayList<>(Arrays.asList(
                new Vec2d(8, 8), new Vec2d(8, 9), new Vec2d(9, 8), new Vec2d(9, 9)
        ));

        Tile t1 = new Tile(new Vec2d(0,0), outerPolygon, Color.BLACK);
        Tile t2 = new Tile(new Vec2d(0,0), innerPolygon, Color.RED);
        Tile t3 = new Tile(new Vec2d(0,0), innerPolygon2, Color.GREEN);
        Tile t4 = new Tile(new Vec2d(0,0), innerPolygon3, Color.GREEN);


        ArrayList<Tile> tiles2 = new ArrayList<>(Arrays.asList(t2, t3, t4));
        PuzzleModel puzzleModel = new PuzzleModel(t1, tiles2);
        assertEquals(puzzleModel.getTileAt(new Vec2d(8.5,8.5)),t4);
        assertEquals(puzzleModel.getTileAt(new Vec2d(3,4)),t3);
        assertNull(puzzleModel.getTileAt(new Vec2d(1000, 1000)));
    }

    @Test
    void testCountOverlaps() {
        ArrayList<Vec2d> overlappingTile1 = new ArrayList<>(Arrays.asList(
                new Vec2d(0, 0), new Vec2d(0, 2), new Vec2d(2, 2), new Vec2d(2, 0)
        ));
        ArrayList<Vec2d> overlappingTile2 = new ArrayList<>(Arrays.asList(
                new Vec2d(1, 1), new Vec2d(1, 3), new Vec2d(3, 3), new Vec2d(3, 1)
        ));
        ArrayList<Vec2d> nonOverlappingTile = new ArrayList<>(Arrays.asList(
                new Vec2d(3, 3), new Vec2d(3, 5), new Vec2d(5, 5), new Vec2d(5, 3)
        ));

        ArrayList<Vec2d> box = new ArrayList<>(Arrays.asList(
                new Vec2d(0, 0), new Vec2d(0, 6), new Vec2d(6, 6), new Vec2d(6, 0)
        ));

        Tile t1 = new Tile(new Vec2d(0,0), overlappingTile1, Color.BLACK);
        Tile t2 = new Tile(new Vec2d(1,1), overlappingTile2, Color.RED);
        Tile t3 = new Tile(new Vec2d(3,3), nonOverlappingTile, Color.GREEN);
        Tile box1 = new Tile(new Vec2d(0,0), box, Color.PINK);

        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(t1);
        tiles.add(t2);
        tiles.add(t3);
        PuzzleModel puzzleModel = new PuzzleModel(box1, tiles);
        assertEquals(2, puzzleModel.countOverlaps());

        ArrayList<Tile> tiles2 = new ArrayList<>();
        tiles.add(t1);
        tiles.add(t3);
        PuzzleModel puzzleModel2 = new PuzzleModel(box1, tiles2);
        assertEquals(0, puzzleModel2.countOverlaps());
    }

    @Test
    void testCheckOverlaps() {
        ArrayList<Vec2d> overlappingTile1 = new ArrayList<>(Arrays.asList(
                new Vec2d(0, 0), new Vec2d(0, 2), new Vec2d(2, 2), new Vec2d(2, 0)
        ));
        ArrayList<Vec2d> overlappingTile2 = new ArrayList<>(Arrays.asList(
                new Vec2d(1, 1), new Vec2d(1, 3), new Vec2d(3, 3), new Vec2d(3, 1)
        ));
        ArrayList<Vec2d> nonOverlappingTile = new ArrayList<>(Arrays.asList(
                new Vec2d(3, 3), new Vec2d(3, 5), new Vec2d(5, 5), new Vec2d(5, 3)
        ));

        ArrayList<Vec2d> box = new ArrayList<>(Arrays.asList(
                new Vec2d(0, 0), new Vec2d(0, 6), new Vec2d(6, 6), new Vec2d(6, 0)
        ));

        Tile t1 = new Tile(new Vec2d(0,0), overlappingTile1, Color.BLACK);
        Tile t2 = new Tile(new Vec2d(1,1), overlappingTile2, Color.RED);
        Tile t3 = new Tile(new Vec2d(3,3), nonOverlappingTile, Color.GREEN);
        Tile box1 = new Tile(new Vec2d(0,0), box, Color.PINK);

        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(t1);
        tiles.add(t2);
        tiles.add(t3);
        PuzzleModel puzzleModel = new PuzzleModel(box1, tiles);
        assertTrue(puzzleModel.checkOverlaps(t1));
        assertFalse(puzzleModel.checkOverlaps(t3));
    }

    @Test
    void testCountContains() {
        ArrayList<Vec2d> outerPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(0, 0), new Vec2d(0, 10), new Vec2d(10, 10), new Vec2d(10, 0)
        ));
        ArrayList<Vec2d> innerPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(2, 2), new Vec2d(2, 8), new Vec2d(8, 8), new Vec2d(8, 2)
        ));
        ArrayList<Vec2d> innerPolygon2 = new ArrayList<>(Arrays.asList(
                new Vec2d(3, 3), new Vec2d(3, 7), new Vec2d(7, 7), new Vec2d(7, 3)
        ));
        ArrayList<Vec2d> overlappingPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(5, 5), new Vec2d(5, 12), new Vec2d(12, 12), new Vec2d(12, 5)
        ));

        Tile t1 = new Tile(new Vec2d(0,0), outerPolygon, Color.BLACK);
        Tile t2 = new Tile(new Vec2d(0,0), innerPolygon, Color.RED);
        Tile t3 = new Tile(new Vec2d(0,0), overlappingPolygon, Color.GREEN);
        Tile t4 = new Tile(new Vec2d(0,0), innerPolygon2, Color.GREEN);

        ArrayList<Tile> tiles = new ArrayList<>(List.of(t3));
        PuzzleModel puzzleModel = new PuzzleModel(t1, tiles);
        assertEquals(0, puzzleModel.countContains());

        ArrayList<Tile> tiles1 = new ArrayList<>(List.of(t2));
        PuzzleModel puzzleModel2 = new PuzzleModel(t1, tiles1);
        assertEquals(1, puzzleModel2.countContains());

        ArrayList<Tile> tiles2 = new ArrayList<>(Arrays.asList(t2, t4));
        PuzzleModel puzzleModel3 = new PuzzleModel(t1, tiles2);
        assertEquals(2, puzzleModel3.countContains());
    }

    @Test
    void testGetTiles(){
        ArrayList<Vec2d> outerPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(0, 0), new Vec2d(0, 10), new Vec2d(10, 10), new Vec2d(10, 0)
        ));
        ArrayList<Vec2d> innerPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(2, 2), new Vec2d(2, 8), new Vec2d(8, 8), new Vec2d(8, 2)
        ));
        ArrayList<Vec2d> innerPolygon2 = new ArrayList<>(Arrays.asList(
                new Vec2d(3, 3), new Vec2d(3, 7), new Vec2d(7, 7), new Vec2d(7, 3)
        ));
        ArrayList<Vec2d> overlappingPolygon = new ArrayList<>(Arrays.asList(
                new Vec2d(5, 5), new Vec2d(5, 12), new Vec2d(12, 12), new Vec2d(12, 5)
        ));

        Tile t1 = new Tile(new Vec2d(0,0), outerPolygon, Color.BLACK);
        Tile t2 = new Tile(new Vec2d(0,0), innerPolygon, Color.RED);
        Tile t3 = new Tile(new Vec2d(0,0), overlappingPolygon, Color.GREEN);
        Tile t4 = new Tile(new Vec2d(0,0), innerPolygon2, Color.GREEN);

        PuzzleModel puzzleModel2 = new PuzzleModel(t1, new ArrayList<>());
        assertEquals(0, puzzleModel2.getTiles().size());

        ArrayList<Tile> tiles2 = new ArrayList<>(Arrays.asList(t2, t3, t4));
        PuzzleModel puzzleModel = new PuzzleModel(t1, tiles2);
        assertEquals(puzzleModel.getTiles(), new ArrayList<>(Arrays.asList(t2, t3, t4)));

    }

}