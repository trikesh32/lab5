package models;

import utils.Validatable;

public class Coordinates implements Validatable {
    private int x; //Максимальное значение поля: 636
    private float y;

    public boolean check_validity(){
        return true;
    }
}