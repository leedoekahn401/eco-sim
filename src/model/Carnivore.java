package model;

public class Carnivore extends Animal {
    public Carnivore(Position pos) {
        super('y',3,pos,200,0.4,2,1.3,4,70);
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
            if(world.animalSpace.getLiving(target) == null){
                Carnivore newCarnivore = new Carnivore(target);
                world.addLiving(newCarnivore);
            }
        }
    }
    public Living sense(World world){
        int cX = this.getPosition().intX();
        int cY = this.getPosition().intY();

        int startX = Math.max(0, cX - senseRadius);
        int endX = Math.min(World.WIDTH - 1, cX + senseRadius);
        int startY = Math.max(0, cY - senseRadius);
        int endY = Math.min(World.HEIGHT - 1, cY + senseRadius);

        for(int x = startX; x <= endX; x++){
            for(int y = startY; y <= endY; y++){
                if(cX == x && cY == y){ continue; }
                Position pos = new Position(x,y);
                Living target = world.animalSpace.getLiving(pos);
                if(target == null){ continue; }
                if(target instanceof Herbivore){
                    return target;
                }
            }
        }
        return null;
    }
    public void update(World world){

    }
}
