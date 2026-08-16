package net.yekta;

public class CollisionChecker {

    public SimulationLoop subscribedSimulation;

    public final double radiusOfEachBody;

    public boolean twoBodiesCollided(){
        for (Body a: Body.bodies){
            for (Body b: Body.bodies){
                if (a.equals(b)){continue;}
                if(a.position.distanceFrom(b.position) < radiusOfEachBody * 2){return true;} else{continue;}
            }
        }
        return false;
    }

    CollisionChecker(SimulationLoop subscribedSimulation,  double radiusOfEachBody){
        this.subscribedSimulation = subscribedSimulation;
        this.radiusOfEachBody = radiusOfEachBody;
    }

    public void logSingleLine() {
        StringBuilder sb = new StringBuilder();

        // '\r' resets the terminal cursor back to the start of the current line
        sb.append("\r");

        for (int i = 0; i < Body.bodies.size(); i++) {
            Body b = Body.bodies.get(i);
            // Compact format: B1: (12.4, -5.2) | B2: (0.0, 15.1)
            sb.append(String.format("B%d: (%.1f, %.1f)  |  ",
                    i + 1,
                    b.position.x(),
                    b.position.y()));
        }

        // Print WITHOUT System.out.println (no new line character!)
        System.out.print(sb.toString());
    }



}
