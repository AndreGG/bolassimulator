package org.academiadecodigo.world;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by cadet on 28/09/15.
 */
public class Person {

    private String name;
    private Info info;
    Icon icon;


    public Person(String name, double x, double y) {
        this.name = name;
        //this.info = new Info();
        icon = new Icon(name, x, y, 100);
    }


    public String getName() {
        return name;
    }

    public Info getInfo() {
        return info;
    }

    public void selPerson() {
        icon.setColor(Color.GREEN);
    }

    public int getRadius() {
        return icon.circle.getRadius();
    }

    public int[] getPos() {
        return icon.getPos();
    }

    public void showIcon() {
        icon.showIcon();
    }


    public void rePos(double dx, double dy) {
        icon.rePos(dx,dy);
    }
    public boolean contains(double x, double y) {
        return icon.circle.contains((int)x,(int)y);
    }



}
