package things;

/**
 * Contains methods that return example Thing objects
 */
public class ExampleThings {
	/**
	 * Creates an example thing at 0,0 with 0,0 initial velocities
	 * mass of 50 and radius 20
	 * 
	 * @return a Thing named "Central_Mass"
	 */
	public static Thing getCentralMass() {
		return new Thing("Central_Mass", 0, 0, 0, 0, 50, 20);
	}
	
	/**
	 * Creates an example thing at 0,200 with 60,00 initial velocities
	 * mass of 10 and radius 5
	 * 
	 * @return a Thing named "Orbiting_Body"
	 */
	public static Thing getOrbitingBody() {
		return new Thing("Orbiting_Body", 0, 200, 60, 0, 10, 5);
	}
	
	/**
	 * crates a thing at 0,200 with no initial velocities
	 * 
	 * @return a Thing named "South_Thing"
	 */
	public static Thing getSouthThing() {
		return new Thing("South_Thing", 0, 200, 0, 0, 10, 5);
	}
	
	/**
	 * crates a thing at 0,-200 with no initial velocities
	 * 
	 * @return a Thing named "North_Thing"
	 */
	public static Thing getNorthThing() {
		return new Thing("North_Thing", 0, -200, 0, 0, 10, 5);
	}
}
