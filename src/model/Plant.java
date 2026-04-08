package model;


public class Plant extends Living implements Vegetation{

    public Plant(Position position) {
        super(1,position,50,100,0.2);
    }

    public void spawn(World world) {
        double chance = Math.random();
        if(chance < this.getRepoRate()){
            if(Math.random() < this.getRepoRate()){
                Position target = world.plantSpace.getEmptyAdjacent(this.getPosition());
                if (target != null) {
                    world.addLiving(new Plant(target));
                }
            }
        }
    }
    public void update(World world) {
        spawn(world);
    }
}
