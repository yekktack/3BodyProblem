package net.yekta;

import java.util.ArrayList;

public class Body {

    public static int numberOfBodies = 0;
    public int index;

    public static ArrayList<Body> bodies = new ArrayList<Body>();

    public final double mass;

    public Vector2D position;
    public Vector2D velocity;
    public Vector2D netForce;

    public Vector2D getNetForce() {
        return netForce;
    }



    public Body(double x, double y, double mass){

        bodies.add(this);
        this.mass = mass;

       // Assigns a new index to each object.
        numberOfBodies++;
        this.index = Body.numberOfBodies;

        this.position = new Vector2D(x,y);
        this.velocity = Vector2D.ZERO;
        this.netForce = Vector2D.ZERO;
    }

    public Body(double x, double y){
        this(x,y,10);
    }

    public double distanceFrom(Body other){
        return this.position.distanceFrom(other.position);
    }
    public double distanceFromSQR(Body other){
        return this.position.distanceFromSQR(other.position);
    }



}
