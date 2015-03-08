package things;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class PhysicalObject2D
{
    private double  x, y, mass, xV, yV;
    private double xA = 0, yA = 0;
    private long lastUpdate, elapsed;
    private Map<String,double[]> accelerations = new TreeMap<String,double[]>();
    
    //*****************************Initialization methods*******************************
    public PhysicalObject2D(long startTime, double X, double Y, double xIV, double yIV, double Mass)
    {
        x = X;
        y = Y;
        xV = xIV;
        yV = yIV;
        mass = Mass;
        lastUpdate = startTime;
    }
    
    //*********************************Update Methods***********************************
    /**
     * This method updates the various status attributes of the PhysicalObject2D based on
     * what has occurred between the time of the last call and now
     * <p>
     * calls the updateAcceleration() method
     * The xV and yV velocities are changed by the current accelerations multiplied
     * by the elapsed time since the last update
     * <p>
     * The x and y positions are updated based on the velocities of the 
     * PhysicalObject2D and the elapsed time
     * 
     * @param now the time it is now
     */
    public void update(long now)
    {
        updateTime(now);
        updateAcceleration();
        
        xV += xA*elapsed;
        yV += yA*elapsed;
        
        x += xV*elapsed;
        y += yV*elapsed;
    }
    
    /**
     * Sets the elapsed time as the difference between lastUpdate and now
     * Sets the lastUpdate to now
     * 
     * @param now
     */
    private void updateTime(long now)
    {
        elapsed = (lastUpdate-now);
        lastUpdate = now;
    }
    
    /**
     * The xA and yA acceleration values are summed up from the various accelerations acting
     * on the PhysicalObject2D at this moment in time
     */
    public void updateAcceleration()
    {
        xA = 0;
        yA = 0;
        double[] entryAccel;
        
        for (Entry<String, double[]> entry : accelerations.entrySet())
        {
            entryAccel = entry.getValue();
            xA += entryAccel[0];
            yA += entryAccel[1];
        }
    }
    
    //*******************************Force Modifying Methods******************************
    /**
     * places the force as the value of the key name into the forces TreeMap
     * 
     * @param name name of force
     * @param acceleration int[] of length 2 that contains x and y acceleration values
     */
    public void addForce(String name, double[] acceleration)
    {
        accelerations.put(name, acceleration);
    }
    
    /**
     * removes the specified force from the forces TreeMap
     **/
    public void removeForce(String name)
    {
        accelerations.remove(name);
    }

    //*****************************get Methods********************************
    /**
     * @return The x value of this PhysicalObject
     */
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public double getMass()
    {
        return mass;
    }
}

