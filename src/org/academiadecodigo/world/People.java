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
            rePosNewPerson(person);
        }
        people.add(person);
        person.icon.showIcon();

    }


    public boolean personOnClick(int x, int y) {

        for (Person p : people) {

            if (x > p.icon.getPos()[0]
                    && x < p.icon.getPos()[0] + p.icon.getDiameter()) {
                if (y > p.icon.getPos()[1]
                        && y < p.icon.getPos()[1] + p.icon.getDiameter()) {
                    System.out.println("There's a person here");

                    p.selPerson();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTooClose(Person person) {

        double x = person.icon.getPos()[0];
        double y = person.icon.getPos()[1];
        int diameter = person.icon.getDiameter();

        for (Person p : people) {

            double x2 = p.icon.getPos()[0];
            double y2 = p.icon.getPos()[1];
            double minDist = diameter / 2 + p.icon.getDiameter() / 2;

            double dist = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));

            if (dist < minDist) {
                return true;
            }
        }

        return false;
    }

    private void rePosNewPerson(Person person) {


        int x = person.icon.getPos()[0];
        int y = person.icon.getPos()[1];

        for (Person p : people) {

            double x2 = p.icon.getPos()[0];
            double y2 = p.icon.getPos()[1];
            double minDist = person.icon.getDiameter() / 2 + p.icon.getDiameter() / 2;

            double dist = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));


            if (dist < minDist) {

                double slope = (y2 - y) / (x2 - x);
                double translate = minDist - dist;

                double dx = translate / Math.sqrt(1 + Math.pow(slope, 2));
                double dy;

                if (dx == 0) {
                    dy = translate;
                } else {
                    if (x < x2) {
                        dx = -dx;
                    }
                    dy = dx * slope;
                }

                person.icon.rePos(dx,dy);
            }
        }


    }

}
