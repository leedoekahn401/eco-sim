package model;

public class Herbivore extends Animal implements Prey{
    public Herbivore(Position pos) {
        super(2,pos,100,200,0.6,1,1,2,50);
    }

    public boolean isEdible(Living target){
        return target instanceof Vegetation;
    }

    public void spawn(World world){
        double chance = Math.random();
        if(chance < this.getRepoRate()){
            if(Math.random() < this.getRepoRate()){
                Position target = world.animalSpace.getEmptyAdjacent(this.getPosition());
                if (target != null) {
                    world.addLiving(new Herbivore(target));
                }
            }
        }
    }

}
