package model;

public class LivingSpace {
    Living[][] grid = new Living[World.WIDTH][World.HEIGHT];

    public LivingSpace() {}

    public void place(Living living, Position position) {
        grid[position.intX()][position.intY()] = living;
    }
    public void remove(Position position) {
        grid[position.intX()][position.intY()] = null;
    }
    public void move(Living living, Position from, Position to) {
        remove(from);
        place(living, to);
    }
    public Living getLiving(Position position) {
        return grid[position.intX()][position.intY()];
    }
}
