package model;

public class Carnivore extends Animal {
    public Carnivore(Position pos) {
        super(3,pos,150,300,0.6,1,1,2,50);
    }

    public boolean isEdible(Living target){
        return target instanceof Prey;
    }

    public void spawn(World world) {
        double chance = Math.random();
        if(chance < this.getRepoRate()&&this.energy>this.repoThresh){
            if(Math.random() < this.getRepoRate()){
                Position target = world.animalSpace.getEmptyAdjacent(this.getPosition());
                if (target != null) {
                    world.addLiving(new Carnivore(target));
                }
            }
        }
    }
}
