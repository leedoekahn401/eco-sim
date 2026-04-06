package model;

public abstract class Animal extends Living {
    double speed;
    double direction;
    double repoThresh;
    double metaRate;
    int senseRadius;


    public Animal() {
        super();
    }
    public Animal(Position position){
        super(position);
    }

    public abstract void spawn(World world);

    public abstract Living sense(World world);

    public abstract void update(World world);

    public void eat(World world, Living living){
        this.energy += living.energy*living.energyTrans;
        world.removeLiving(living);
    }

    public void strive(Position dest){
        double dist = Math.sqrt(Math.pow(this.getPosition().getX()-dest.getX(),2)+Math.pow(this.getPosition().getY()-dest.getY(),2));
        if(dist>speed){
            return;
        }
        this.setPosition(dest);
    }

    public void move(){
        double dx = this.speed*Math.cos(this.direction);
        double dy = this.speed*Math.sin(this.direction);
        double px = this.getPosition().getX()+dx;
        double py = this.getPosition().getY()+dy;
        if(px<0||px>=World.WIDTH||py<0||py>=World.HEIGHT){
            return;
        }
        Position pos = new Position(px,py);
        this.position = pos;
    }


}
