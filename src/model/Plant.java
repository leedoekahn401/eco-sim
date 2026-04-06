package model;


public class Plant extends Living{

    public Plant(Position position) {
        super('g',1,position,100,0.2);
    }

    public void spawn(World world) {
        double chance = Math.random();
        if(chance < this.getRepoRate()){
            int offsetX = (int)(Math.random() * 3) - 1;
            int offsetY = (int)(Math.random() * 3) - 1;
            if (offsetX == 0 && offsetY == 0) {
                return;
            }
            int targetX = this.getPosition().intX() + offsetX;
            int targetY = this.getPosition().intY() + offsetY;
            if (targetX < 0 || targetX >= World.WIDTH || targetY < 0 || targetY >= World.HEIGHT) {
                return;
            }
            Position target = new Position(targetX, targetY);
            if(world.plantSpace.getLiving(target) == null){
                Position pos = new Position(targetX, targetY);
                Plant newPlant = new Plant(pos);
                world.addLiving(newPlant);
            }


        }
    }
    public void update(World world) {
        spawn(world);
    }
}
