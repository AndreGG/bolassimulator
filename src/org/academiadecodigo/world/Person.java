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
    private Ellipse icon;


    public Person(String name, double x, double y) {
        this.name = name;
        //this.info = new Info();
        this.icon = makeNewIcon(x, y);

        showIcon();
        addName();

    }


    public String getName() {
        return name;
    }

    public Info getInfo() {
        return info;
    }


    public int[] getXBorder() {
        return new int[]{icon.getX() - icon.getWidth() / 2,
                         icon.getX() + icon.getWidth() + icon.getWidth()/2};

    }

    public int[] getYBorder() {
        return new int[]{icon.getY() - icon.getHeight() / 2 + offset,
                         icon.getY() + icon.getHeight() + icon.getHeight()/2 + offset};
    }


    public void showIcon() {
        icon.fill();
    }

    public void hideIcon() {
        icon.delete();
    }


    private Ellipse makeNewIcon(double x, double y) {

        double diameter = 100;

        x -= (int) (diameter / 2);
        y -= (int) (diameter / 2 + offset);

        Ellipse circle = new Ellipse(x, y, diameter, diameter);
        circle.setColor(Color.LIGHT_GRAY);

        return circle;
    }

    private void addName() {

        double iconX = icon.getX() + icon.getWidth() / 2;
        double iconY = icon.getY() + icon.getHeight() / 2;

        Text nameText = new Text(iconX, iconY, name);
        nameText.translate(-nameText.getWidth() / 2, -nameText.getHeight() / 2);

        nameText.draw();

    }

}
