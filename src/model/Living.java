package model;
public abstract class Living {
    double size;
    Position position;
    double energy;
    double maxEnergy;
    double energyTrans = 0.1;
    double repoRate;


    public Living(){
    }
    public Living(Position position){
        this.position = position;
    }

    public Living(double size, Position position, double energy, double maxEnergy,double repoRate) {
        this.size=size;
        this.energy = energy;
        this.position = position;
        this.repoRate = repoRate;
    }

    public void setEnergyTrans(double energyTrans){
        this.energyTrans = energyTrans;
    }
    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public double getEnergyTrans() {
        return energyTrans;
    }

    public double getRepoRate() {
        return repoRate;
    }

    public void setRepoRate(double rate){
        this.repoRate = rate;
    }
    public Position getPosition() {
        return position;
    }

    public abstract void spawn(World world);
    public abstract void update(World world);

}
