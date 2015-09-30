package org.academiadecodigo.world;

import org.academiadecodigo.graphics.Circle;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by cadet on 28/09/15.
 */
public class Icon {

    Circle circle;
    Text name;


    public Icon(String name, double x, double y, double radius) {

        radius = 50;

        circle = new Circle((int)x, (int)y, (int)radius);
        circle.setColor(Color.LIGHT_GRAY);

        this.name = new Text(0,0,name);
    }

    public void rePos(double dx, double dy) {


        for (int i = 1; i < 100; i++) {
            circle.move(dx/100,dy/100);
            name.translate(dx/100,dy/100);

        }

    }

    protected int[] getPos() {
        return new int[]{circle.getCX(),
                circle.getCY()};
    }

    protected void showIcon() {
        circle.fill();
        addName();
    }

    protected void hideIcon() {
        circle.delete();

    }

    protected void setColor(Color color) {
        circle.setColor(color);
    }

    private void addName() {

        centerText();
        name.draw();
    }

    private void centerText() {

        int iconX = circle.getX() + circle.getWidth() / 2;
        int iconY = circle.getY() + circle.getHeight() / 2;

        int x = iconX - name.getWidth()/2;
        int y = iconY - name.getHeight()/2;

        name.translate(x - name.getX(), y - name.getY());
    }

}
