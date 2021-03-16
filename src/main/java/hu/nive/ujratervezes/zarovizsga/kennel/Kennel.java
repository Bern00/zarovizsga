package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog){
        dogs.add(dog);
    }

    public void feedAll(){
        for(Dog d: dogs){
            d.feed();
        }
    }

    public Dog findByName(String name){
        for(Dog d: dogs){
            if(d.getName().equals(name)){
                return d;
            }
        }
        throw new IllegalArgumentException();
    }

    public void playWith(String name, int hours){
        Dog dog = findByName(name);
        dog.play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness){
        List<String> dogNames = new ArrayList<>();
        for(Dog d: dogs){
            if(d.getHappiness() > minHappiness){
                dogNames.add(d.getName());
            }
        }
        return dogNames;
    }

    public List<Dog> getDogs() {
        return dogs;
    }
}
