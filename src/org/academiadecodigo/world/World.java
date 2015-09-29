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

    private People people;
    private int counter;


    public World() {

        people = new People();

        keyListener();
        mouseListener();

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

        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY();

        System.out.println(mouseEvent);


        if (!people.personOnClick(x,y)) {

            Person person = new Person("joe",x,y);
            people.addPerson(person);
        }

    }

}

