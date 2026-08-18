package net.yekta;


public class SimulationLoop {
    // a.k.a the physics engine.


    // Constants and variables
    // The universal constant of gravitation
    public static final double G = 1.0; // I mean it's generally 6.67430e-11 but I am not dealing with astronomical masses here.
    public static final int TPS = 180;
    public static final double dt = 1/(double)TPS;
    public static final double radiusOfEachBody = 1;



    // Collision Checker
    CollisionChecker collisionChecker = new CollisionChecker(this, radiusOfEachBody);

    // Bodies
    Body a = new Body(50,0);
    Body b = new Body(0,50);
    Body c = new Body(50,50);

    // Main loop
    public void begin(){

        long t1 = System.nanoTime();
        double accumulator = 0.0;
        long t2;
        boolean bussin = true;

        while(bussin){

            t2 = System.nanoTime();

            double frameTime = (double) (t2 - t1) /1_000_000_000;

            t1 = t2;

            if(frameTime > 0.25) frameTime = 0.25;

            accumulator  += frameTime;

            while(accumulator >= dt) {
                tickPhysics();
                accumulator -= dt;
            }

            // bobRoss.draw();
            collisionChecker.logSingleLine();

            // Letting the CPU take a breath for 1 millisecond.
            takeABreath();

            if (collisionChecker.twoBodiesCollided())
            {bussin = false;
                System.out.println("Two Bodies Collided!");
            }

        }
    }

    // Physics methods
    public double magnitudeOfGravityBetween(Body a, Body b) {
        double m = b.mass;
        double M = a.mass;
        double rsquared = a.position.distanceFromSQR(b.position);
        if(rsquared == 0) {return 0;}
        return G*M*m/rsquared;
    }

    public void applyForce(Body b, Vector2D force) {
        b.netForce = b.netForce.add(force);
    }

    public void gravitateATowardsB (Body a, Body b) {
        Vector2D unitVector = b.position.subtract(a.position).normalize();
        double forceMultiplier = magnitudeOfGravityBetween(a, b);
        a.netForce = a.netForce.add(unitVector.multiply(forceMultiplier));
    }

    public void moveBody(Body b){
        b.position = b.position.add(b.velocity.multiply(dt));
    }

    public void accelerateBody(Body b){
        Vector2D acceleration = b.getNetForce().divide(b.mass);
        b.velocity = b.velocity.add(acceleration.multiply(dt));
    }

    public void resetForce(Body b){
        b.netForce = Vector2D.ZERO;
    }

    public void resetAllForces(){
        Body.bodies.forEach(this::resetForce);
    }
    public void tickPhysics(){

        resetAllForces();

        for (Body a: Body.bodies) {
            for(Body b: Body.bodies) {
                if(a.equals(b)) continue;
                gravitateATowardsB(a, b);
            }
        }
        for (Body b: Body.bodies) {
            accelerateBody(b);
            moveBody(b);
        }
    }
    public void takeABreath(){
        try{Thread.sleep(1);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
