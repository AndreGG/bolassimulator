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

        people.add(person);
    }




    public boolean personOnClick(int x, int y) {

        for ( int i = 0; i < people.size(); i++ ) {

            if (x > people.get(i).getXBorder()[0]
                    && x < people.get(i).getXBorder()[1]) {
                if (y > people.get(i).getYBorder()[0]
                        && y < people.get(i).getYBorder()[1]) {
                    System.out.println("There's a person here");

                    System.out.println(x);
                    System.out.println(y);
                    return true;
                }
            }
        }

        return false;
    }


}
