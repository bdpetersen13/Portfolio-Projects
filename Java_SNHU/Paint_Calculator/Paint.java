import java.util.Scanner;
import java.math.*;

public class Paint2 {
	public static void main(String[] args) {
		
		//Initializing wallHeight, wallWidth, wallArea, gallonsPaintNeeded, and cansNeeded
		Scanner scnr = new Scanner(System.in);
		double wallHeight = 0.0;
		double wallWidth = 0.0;
		double wallArea = 0.0;
		double gallonsPaintNeeded = 0.0;
		double cansNeeded = 0.0;
		
		//Giving squarefeetPerGallon and gallonsPerCan their finial double
		final double squareFeetPerGallon = 350.0;
		final double gallonsPerCan = 1.0;
		
		//Obtaining the height of the wall
		System.out.println("Enter wall height (feet): ");
		wallHeight = scnr.nextDouble();
		
		//Obtaining the width of the wall
		System.out.println("Enter wall width (feet): ");
		wallWidth = scnr.nextDouble();
		
		//Finding the wall area from the obtained height and width
		wallArea = wallWidth * wallHeight;
		System.out.println("Wall area: " + wallArea + " square feet");
		
		//Finding how many gallons of paint is needed
		gallonsPaintNeeded = wallArea / squareFeetPerGallon;
		System.out.println("Paint needeed: " + gallonsPaintNeeded + " gallons");
		
		//Math.ceil rounds to the nearest integer
		cansNeeded = Math.ceil(gallonsPaintNeeded / gallonsPerCan);
		System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");
		System.out.println("Cans needed: " + cansNeeded + "can(s)");
		
	}
}