package net.yekta;

public class Body {

    public static int number=0;
    public int index;

    public Body(){
        number++;
        this.index = Body.number;
    }



}
