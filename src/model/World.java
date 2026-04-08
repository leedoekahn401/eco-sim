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
    public LivingSpace animalSpace =  new LivingSpace();
    public LivingSpace plantSpace = new LivingSpace();

    public World() {

    }

    public void addLiving(Living living) {
        if(living instanceof Plant) {
            if(plants.size() < MAX_ENTITY) {
                plants.add((Plant) living);
                plantSpace.place(living, living.getPosition());
            }
        }else if(living instanceof Animal) {
            if(animals.size() < MAX_ENTITY) {
                animals.add((Animal) living);
                animalSpace.place(living, living.getPosition());
            }
        }
    }
    public void removeLiving(Living living) {
        if(living instanceof Plant) {
            plants.remove(living);
            plantSpace.remove(living.getPosition());
        }else if(living instanceof Animal) {
            animals.remove(living);
            animalSpace.remove(living.getPosition());
        }
    }

}
