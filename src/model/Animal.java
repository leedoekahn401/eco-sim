package model;

public abstract class Animal extends Living {
    double speed;
    double metabol;
    int senseRadius;
    double repoThresh;

    protected double direction;


    public Animal() {
        super();
    }
    public Animal(Position position){
        super(position);
    }
    public Animal( double size, Position position, double energy, double maxEnergy,double repoRate, double speed, double metabol, int senseRadius, double repoThresh) {
        super(size, position, energy, maxEnergy,repoRate);
        this.speed=speed;
        this.metabol=metabol;
        this.senseRadius=senseRadius;
        this.repoThresh=repoThresh;
    }

    protected abstract boolean isEdible(Living target);

    public Living sense(World world){
        int cX = this.getPosition().intX();
        int cY = this.getPosition().intY();

        int startX = Math.max(0, cX - senseRadius);
        int endX = Math.min(World.WIDTH - 1, cX + senseRadius);
        int startY = Math.max(0, cY - senseRadius);
        int endY = Math.min(World.HEIGHT - 1, cY + senseRadius);
        Position pos = new Position();
        for(int x = startX; x <= endX; x++){
            for(int y = startY; y <= endY; y++){
                if(cX == x && cY == y){ continue; }
                pos.setX(x);
                pos.setY(y);
                Living target = world.animalSpace.getLiving(pos);
                Living target2 = world.plantSpace.getLiving(pos);
                if(isEdible(target)||isEdible(target2)){
                    return target!=null ? target: target2;
                }
            }
        }
        return null;
    }


    public void eat(World world, Living living){
        this.energy += living.energy*living.energyTrans;
        world.removeLiving(living);
    }

    public void hunt(Living living, World world){
        Position dest = new Position(living.getPosition().intX(),living.getPosition().intY());
        double dist = Math.sqrt(Math.pow(this.getPosition().getX()-dest.getX(),2)+Math.pow(this.getPosition().getY()-dest.getY(),2));
        Position curPos = this.getPosition();
        if(dist>speed){
            double ratio = speed / dist;
            Position nextPos = new Position(
                    this.getPosition().getX() + ratio * (dest.getX() - this.getPosition().getX()),
                    this.getPosition().getY() + ratio * (dest.getY() - this.getPosition().getY())
            );
            if(world.animalSpace.getLiving(nextPos) == null){
                return;
            }
            world.animalSpace.move(this,curPos,nextPos);

        }else{
            eat(world,living);
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

        if(world.animalSpace.getLiving(nextPos) == null){
            return;
        }
        this.setPosition(nextPos);
        world.animalSpace.move(this, curPos, nextPos);
    }

    public void update(World world){
        this.energy -= this.metabol*this.maxEnergy;
        if(this.energy<=0){
            world.removeLiving(this);
            return;
        }
        Living target = sense(world);
        if(target != null){
            hunt(target,world);
        }else{
            this.direction = Math.random()*2*Math.PI;
            move(world);
        }
        spawn(world);

    }
}