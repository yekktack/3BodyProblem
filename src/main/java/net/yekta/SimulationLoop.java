package net.yekta;

public class SimulationLoop {

    public static final double G = 6.67430e-11;




    Body a = new Body(5,0);
    Body b = new Body(0,5);
    Body c = new Body(5,5);

    public static final int TPS = 180;
    public static final double dt = 1/(double)TPS;

    public void begin(){

    }
}
