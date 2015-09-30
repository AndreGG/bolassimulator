package org.academiadecodigo.graphics;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;


public class Circle extends Ellipse {

    private int cx;
    private int cy;
    private int radius;


    public Circle(int x, int y, int radius) {
        super(x, y, radius * 2, radius * 2);

        cx = x;
        cy = y;
        this.radius = radius;

        super.translate(-radius,-radius);
    }

    public int getCX() {
        return cx;
    }

    public int getCY() {
        return cy;
  }

    public int getRadius() {
        return radius;
    }

    public void move(double dx, double dy) {
        super.translate(dx,dy);

        cx = super.getX() + radius;
        cy = super.getY() + radius;
    }

    public boolean contains(int x, int y) {

        double dist = Math.sqrt(Math.pow(cy - y,2) + Math.pow(cx - x,2));

        if (dist > radius) {
            return false;
        } else {
            return true;
        }
    }
}
