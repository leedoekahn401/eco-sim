package model;

public abstract class Animal extends Living {
    double speed;
    double metaRate;
    int senseRadius;
    double repoThresh;

    protected double direction;


    public Animal() {
        super();
    }
    public Animal(Position position){
        super(position);
    }
    public Animal(char color, double size, Position position, double energy, double repoRate, double speed, double metaRate, int senseRadius, double repoThresh) {
        super(color, size, position, energy, repoRate);
        this.speed=speed;
        this.metaRate=metaRate;
        this.senseRadius=senseRadius;
        this.repoThresh=repoThresh;
    }


    public abstract Living sense(World world);

    public void eat(World world, Living living){
        this.energy += living.energy*living.energyTrans;
        world.removeLiving(living);
    }

    public void moveToward(Position dest, World world){
        double dist = Math.sqrt(Math.pow(this.getPosition().getX()-dest.getX(),2)+Math.pow(this.getPosition().getY()-dest.getY(),2));
        Position curPos = this.getPosition();
        if(dist>speed){
            double ratio = speed / dist;
            Position nextPos = new Position(
                    this.getPosition().getX() + ratio * (dest.getX() - this.getPosition().getX()),
                    this.getPosition().getY() + ratio * (dest.getY() - this.getPosition().getY())
            );
            this.setPosition(curPos);
            world.animalSpace.move(this,curPos,nextPos);

        }else{
            this.setPosition(dest);
            world.animalSpace.move(this,curPos,dest);
        }

    }

    public void move(World world){
        Position curPos = this.getPosition();
        double dx = this.speed * Math.cos(this.direction);
        double dy = this.speed * Math.sin(this.direction);
        double px = curPos.getX() + dx;
        double py = curPos.getY() + dy;

        if (px < 0 || px >= World.WIDTH || py < 0 || py >= World.HEIGHT) return;

        Position nextPos = new Position(px, py);
        this.setPosition(nextPos);
        world.animalSpace.move(this, curPos, nextPos);
    }
}