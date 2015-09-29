package org.academiadecodigo.world;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by cadet on 28/09/15.
 */
public class Person {

    private static final int offset = 23;

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



}
