package org.academiadecodigo.world;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by cadet on 28/09/15.
 */
public class Icon {

    private static final int offset = 23;
    private Ellipse circle;
    private Text name;


    public Icon(String name, double x, double y, double diameter) {

        diameter = 100;
        x -= (int) (diameter / 2);
        y -= (int) (diameter / 2 + offset);

        circle = new Ellipse(x, y, diameter, diameter);
        circle.setColor(Color.LIGHT_GRAY);

        this.name = new Text(0,0,name);
    }

    protected int[] getPos() {
        return new int[]{circle.getX(),
                circle.getY()};
    }

    protected int getDiameter() {
        return circle.getWidth();

    }

    protected void showIcon() {
        circle.fill();
        addName();
    }

    protected void hideIcon() {
        circle.delete();

    }
    public void setColor(Color color) {
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

    public void rePos(double x, double y) {
        circle.translate(x,y);

    }

}
