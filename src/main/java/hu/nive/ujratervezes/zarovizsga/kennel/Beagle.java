package hu.nive.ujratervezes.zarovizsga.kennel;

import hu.nive.ujratervezes.zarovizsga.kennel.Dog;

public class Beagle extends Dog {

    public Beagle(String name) {
        super(name);

    }

    @Override
    public void feed() {
        super.setHappiness(getHappiness() + 2);
    }

    @Override
    public void play(int hours) {
        super.setHappiness(getHappiness() + hours * 2);
    }
}
