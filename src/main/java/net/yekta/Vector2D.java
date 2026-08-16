package net.yekta;

public record Vector2D(double x, double y) {

    public static final Vector2D ZERO =  new Vector2D(0, 0);

    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }
    public double magnitudeSQR() {
        return x*x + y*y;
    }
    public Vector2D add(Vector2D other) {
        return new Vector2D(this.x+other.x, this.y+other.y);
    }
    public Vector2D invert(){
        return new Vector2D(-x,-y);
    }
    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x-other.x, this.y-other.y);
    }
    public Vector2D multiply(double scalar) {
        return new Vector2D(x*scalar, y*scalar);
    }
    public Vector2D divide(double scalar) {
        if(scalar==0){return Vector2D.ZERO;}
        return new Vector2D(x/scalar, y/scalar);
    }
    public Vector2D normalize(){
        double mag = magnitude();
        if(mag==0){return Vector2D.ZERO;}
        return new Vector2D(x/mag, y/mag);
    }

    // Use for calculating the difference between position vectors.
    public double distanceFrom(Vector2D other){
       double dx = x-other.x;
       double dy = y-other.y;
       return Math.sqrt(dx*dx + dy*dy);
    }
    public double distanceFromSQR(Vector2D other){
        double dx = x-other.x;
        double dy = y-other.y;
        return dx*dx + dy*dy;
    }


}
