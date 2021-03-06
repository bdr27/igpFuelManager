/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager;

import au.bdr27.igpFuelManager.util.FuelStrategy;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Brendan
 */
public class MainCLI {
    
    private static final boolean USERCHOICE = false;
    private static final String menu = "Which option do you want to do\n"
            + "\t1. Enter Fuel Per Lap\n"
            + "\t2. Enter Laps\n"
            + "\t3. Enter Current Lap\n"
            + "\t4. Enter Stops\n"
            + "\t5. (Q)uit\n"
            + "Option: ";

    public static void main(String[] args) {
        FuelStrategy fuel = new FuelStrategy();
        if (USERCHOICE) {
            String choice = "";
            Scanner scanner = new Scanner(System.in);
            System.out.print(menu);
            choice = scanner.nextLine().toLowerCase();
            while (!choice.equals("q")) {
                switch (choice) {
                    case "1":
                        System.out.print("Please enter fuel per lap: ");
                        fuel.setFuelPerLap(scanner.nextDouble());
                        break;
                    case "2":
                        System.out.print("Please enter total laps: ");
                        fuel.setTotalLaps(scanner.nextInt());
                        break;
                    case "3":
                        System.out.print("Please enter current lap: ");
                        fuel.setCurrentLap(scanner.nextInt());
                        break;
                    case "4":
                        System.out.print("Please enter total fuel stops: ");
                        fuel.setTotalStops(scanner.nextInt());
                        break;
                    default:
                        System.out.println("Error invalid option");
                }
                scanner.nextLine();
                System.out.print(menu);
                choice = scanner.nextLine().toLowerCase();
            }
        }else{
            //Random number will be used for testing purposes
            fuel.setFuelPerLap(3.9);
            fuel.setTotalLaps(28);
            fuel.setTotalStops(1);
            fuel.calcFuelToGo();
            fuel.calcTotalFuel();
            fuel.calcEvenStint();
            fuel.calcEvenStints();
            ArrayList<Integer> testLaps = new ArrayList<>();
            testLaps.add(23);
            testLaps.add(50);
            fuel.calcCustomStints(testLaps);
        }
        System.out.println(fuel.getAverageFuelStops().toString());
        System.out.println(fuel.toString());
        
    }
}
