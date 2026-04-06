package model;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class World {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int MAX_ENTITY = WIDTH*HEIGHT;
    public List<Animal> animals = new ArrayList<>();
    public List<Plant> plants = new ArrayList<>();
    public Plant[][] plantMap = new Plant[WIDTH][HEIGHT];
    public Animal[][] animalMap = new Animal[WIDTH][HEIGHT];

    public World() {

    }

    public boolean hasPlant(Position pos){
        return plantMap[pos.intX()][pos.intY()]!=null;
    }

    public void addLiving(Living living) {
        if(living instanceof Plant) {
            if(plants.size() < MAX_ENTITY) {
                plants.add((Plant) living);
                plantMap[living.getPosition().intX()][living.getPosition().intY()] = (Plant) living;
            }
        }else if(living instanceof Animal) {
            if(animals.size() < MAX_ENTITY) {
                animals.add((Animal) living);
                animalMap[living.getPosition().intX()][living.getPosition().intY()] = (Animal) living;
            }
        }
    }
    public void removeLiving(Living living) {
        if(living instanceof Plant) {
            plants.remove(living);
            plantMap[living.getPosition().intX()][living.getPosition().intY()] = null;
        }else if(living instanceof Animal) {
            animals.remove(living);
            animalMap[living.getPosition().intX()][living.getPosition().intY()] = null;
        }
    }

}
