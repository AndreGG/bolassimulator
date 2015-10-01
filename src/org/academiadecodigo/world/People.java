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
        person.showIcon();
        World.needsRePositioning();

    }


    public boolean personOnClick(int x, int y) {

        for (Person p : people) {
            if (p.contains(x, y)) {
                p.selPerson();
                World.stopRePosition();
                return true;
            }
        }
        return false;
    }

    public void rePositionPeople() {

        for (Person p1 : people) {

            for (Person p2 : people) {

                if (p1 != p2) {
                    double x1 = p1.getPos()[0];
                    double x2 = p2.getPos()[0];
                    double y1 = p1.getPos()[1];
                    double y2 = p2.getPos()[1];

                    double minDist = p1.getRadius() + p2.getRadius();
                    double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

                    if (dist < minDist) {

                        double slope = (y2 - y1) / (x2 - x1);
                        double translate = minDist - dist;
                        double dx = translate / Math.sqrt(1 + Math.pow(slope, 2));
                        double dy;

                        if (dx == 0) {
                            dy = translate;
                        } else {
                            if (x1 > x2) {
                                dx = -dx;
                            }
                            dy = dx * slope;
                        }

                        p2.rePos(dx/2, dy/2);
                        p1.rePos(-dx/2,-dy/2);
                        rePositionPeople();

                    }
                }
            }
        }

        World.stopRePosition();
    }
}

