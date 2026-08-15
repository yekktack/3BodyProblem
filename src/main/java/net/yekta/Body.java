package net.yekta;

public class Body {

    private static int number = 0;
    public int index;

    public final double mass;

    public Vector2D position;
    public Vector2D velocity;
    public Vector2D netForce;


    public Body(double x, double y, double mass){

        this.mass = mass;

       // Assigns a new index to each object.
        number++;
        this.index = Body.number;

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
