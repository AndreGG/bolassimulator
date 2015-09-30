package org.academiadecodigo.world;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by cadet on 28/09/15.
 */
public class World implements KeyboardHandler, MouseHandler {

    private static final int offset = 23;
    private People people;
    private int counter;

    private static boolean needsRePositioning = false;


    public World() {

        people = new People();

        keyListener();
        mouseListener();

        animate();

    }


    public void animate() {
        while(true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            checkForRePositioning();
        }
    }

    public static void needsRePositioning() {
        needsRePositioning = true;
    }

    public void checkForRePositioning() {
        if (needsRePositioning == true) {
            people.rePositionPeople();
        }
    }

    public static void stopRePosition() {
        needsRePositioning = false;
    }

    public void keyListener() {
        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(event);
    }

    public void mouseListener() {
        Mouse m = new Mouse(this);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {


        System.out.println(mouseEvent);

        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY() - offset;

        if (!people.personOnClick(x,y)) {

            Person person = new Person("joe",x,y);
            people.addPerson(person);
        }

    }

}

