package org.academiadecodigo.world;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

/**
 * Created by cadet on 28/09/15.
 */
public class Icon {

    Ellipse icon;


    public Icon(int x, int y,double diameter) {

        diameter = 100;
        icon = new Ellipse(x, y, diameter, diameter);
        icon.setColor(Color.LIGHT_GRAY);

        showIcon();
    }


    public void showIcon() {
        icon.fill();
    }

    public void hideIcon() {
        icon.delete();
    }
}
