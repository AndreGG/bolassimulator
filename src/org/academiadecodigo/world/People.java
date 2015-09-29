package org.academiadecodigo.world;

import java.util.ArrayList;

/**
 * Created by cadet on 28/09/15.
 */
public class People {

    private ArrayList<Person> people = new ArrayList<>();

    public People() {
    }

    public void addPerson(Person person) {

        if (isTooClose(person)) {

        }
        people.add(person);
        person.icon.showIcon();
    }


    public boolean personOnClick(int x, int y) {

        for ( Person p : people ) {

            if (x > p.icon.getPos()[0]
             && x < p.icon.getPos()[0] + p.icon.getDiameters()[0]) {
                if (y > p.icon.getPos()[1]
                 && y < p.icon.getPos()[1] + p.icon.getDiameters()[1]) {
                    System.out.println("There's a person here");

                    p.selPerson();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTooClose(Person person) {


        return false;
    }


}
