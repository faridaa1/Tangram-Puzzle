package shapes;


import geometry.Vec2d;

import java.util.ArrayList;
import java.util.List;

public class PuzzleModel {
    Tile box;
    final private ArrayList<Tile> tiles;

    public PuzzleModel(Tile box, ArrayList<Tile> tiles) {
        this.box = box;
        this.tiles = tiles;
    }

    public boolean isSolved() {
        // check containment and overlaps
        return countContains() == tiles.size() && countOverlaps() == 0;
    }

    public String getStatusText() {
        return "n Overlaps " + countOverlaps() + " Contains? " +
                countContains() + " Solved? " + isSolved();
    }

    public Tile getTileAt(Vec2d point) {
        // return the 'top' tile that contains the point or null if no tile contains the point
        for (int i = tiles.size()-1; i >= 0; i--) {
            Tile currentTile = tiles.get(i);
            if (tiles.get(i).contains(point)) {
                tiles.remove(currentTile);
                tiles.add(currentTile); // tile rendering last means it's drawn at the top
                return currentTile;
            }
        }
        return null;
    }

    public boolean checkOverlaps(Tile currentShape) {
        // return true if the currentShape overlaps any other shape
        for (Tile t : tiles) {
            if (!t.equals(currentShape) && currentShape.intersects(t)) {
                return true;
            }
        }
        return false;
    }

    public int countOverlaps() {
        // return the number of tiles that overlap at least one other tile
        return (int) tiles.stream().filter(this::checkOverlaps).count();
    }

    public int countContains() {
        // return the number of tiles that are completely contained in the box
        return (int) tiles.stream().filter(tile -> box.contains(tile)).count();
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}

