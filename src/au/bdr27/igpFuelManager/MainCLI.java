/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager;

import au.bdr27.igpFuelManager.util.Fuel;
import java.util.Scanner;

/**
 *
 * @author Brendan
 */
public class MainCLI {

    static String menu = "Which option do you want to do\n"
            + "\t1. Enter Fuel Per Lap\n"
            + "\t2. Enter Laps\n"
            + "\t3. Enter Current Lap\n"
            + "\t4. Enter Stops\n"
            + "\t5. (Q)uit\n"
            + "Option: ";

    public static void main(String[] args) {
        Fuel fuel = new Fuel();
        String choice = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print(menu);
        choice = scanner.nextLine().toLowerCase();
        while (!choice.equals("q")) {
            switch(choice){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
            }
            System.out.print(menu);
            choice = scanner.nextLine().toLowerCase();
        }
        //
    }
}
