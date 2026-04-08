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
    public Position getEmptyAdjacent(Position pos) {
        int offsetX = (int)(Math.random() * 3) - 1;
        int offsetY = (int)(Math.random() * 3) - 1;

        if (offsetX == 0 && offsetY == 0) {
            return null;
        }

        int targetX = pos.intX() + offsetX;
        int targetY = pos.intY() + offsetY;

        if (targetX < 0 || targetX >= World.WIDTH || targetY < 0 || targetY >= World.HEIGHT) {
            return null;
        }

        Position target = new Position(targetX, targetY);

        if (this.getLiving(target) == null) {
            return target;
        }

        return null;
    }
}
