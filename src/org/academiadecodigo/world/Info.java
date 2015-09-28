package org.academiadecodigo.world;

/**
 * Created by cadet on 28/09/15.
 */
public class Info {

    private String description;
    private String gender;


    public Info() {
        this.description = "There is no description available";
        this.gender = "Unknown";

    }

    public Info(String description, String gender) {
        this.description = description;
        this.gender = gender;
    }



}
