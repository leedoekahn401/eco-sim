package model;

public class Position {
    double x;
    double y;

    public Position(){};

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public int intX() {
        return (int)x;
    }
    public int intY() {
        return (int)y;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
}
