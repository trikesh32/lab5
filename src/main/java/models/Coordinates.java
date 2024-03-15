package models;

import utils.Validatable;

public class Coordinates implements Validatable {
    private int x; //Максимальное значение поля: 636
    private float y;

    public Coordinates(Integer x, Float y){
        this.x = x;
        this.y = y;
    }

    public boolean check_validity() {
        return x <= 636;
    }
}