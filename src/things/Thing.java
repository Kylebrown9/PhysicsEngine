package things;

import java.awt.Color;
import java.util.List;
import java.util.ListIterator;

public  class Thing
{
    private PhysicalObject2D pObject2D;
    public GraphicalObject2D gObject2D;
    private int mass;
    private String name;
    
    public Thing(String name, double x, double y, double xIV, double yIV, int Mass, int Size) {
        mass = Mass;
        pObject2D = new PhysicalObject2D(0,x,y,0,0,mass);
        gObject2D = new GraphicalObject2D((int) x,(int) y,Size, Color.BLUE);
    }
    
    public void update(List<Thing> universe){
        ListIterator<Thing> universeIT = universe.listIterator();
        Thing temp;
        String tempName;
        double[] force;
        
        while(universeIT.hasNext())
        {
            temp = universeIT.next();
            tempName = temp.getName();
            
            if(!tempName.equals(this.name))
            {
                force = calcGravAccel(temp);
                pObject2D.addForce("grav" + tempName, force);
            }
            
        }
        
        pObject2D.update(System.currentTimeMillis());
        gObject2D.setPos((int)pObject2D.getX(), (int)pObject2D.getY());
    }
    
    /**
     * calculates gravitational acceleration of this towards a thing
     * 
     * @param thing the thing pulling this
     * @return the gravitational acceleration
     */
    public double[] calcGravAccel(Thing thing) {
    	PhysicalObject2D tempCore;
        tempCore = thing.getPhysicalObject2D();
        
        double xDist = tempCore.getX()-pObject2D.getX();
        double yDist = tempCore.getY()-pObject2D.getY();
        double xRatio = yDist/(xDist+yDist);
        double yRatio = yDist/(xDist+yDist);
        
        double rSquared = Math.pow(xDist,2)+Math.pow(yDist,2);
        double gravC = .00001;
        double cummulativeAccel = tempCore.getMass()*gravC/rSquared;
        
        double yAccel = yRatio*cummulativeAccel;
        double xAccel = xRatio*cummulativeAccel;
        
        double[] accel = {yAccel,xAccel};
        
        return accel;
    }
    
    /**
     * 
     * @return the PhysicalObject2D of the thing
     */
    public PhysicalObject2D getPhysicalObject2D() {
        return pObject2D;
    }
    
    public GraphicalObject2D getGraphicalObject2D() {
    	return gObject2D;
    }
    
    public String getName(){
        return this.name;
    }
}
