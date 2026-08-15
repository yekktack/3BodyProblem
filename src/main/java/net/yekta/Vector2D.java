package net.yekta;

public record Vector2D(double x, double y) {

    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }
    public double magnitudeSquared() {
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
        if(scalar==0){return new Vector2D(0,0);}
        return new Vector2D(x/scalar, y/scalar);
    }
    public Vector2D normalize(){
        double mag = magnitude();
        if(mag==0){return new Vector2D(0,0);}
        return new Vector2D(x/mag, y/mag);
    }

}
