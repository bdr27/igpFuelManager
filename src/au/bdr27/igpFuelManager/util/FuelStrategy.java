/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager.util;

import java.util.ArrayList;

/**
 *
 * @author Brendan
 */
public class FuelStrategy {

    private final boolean DEBUG = Debug.value;
    private int totalLaps;
    private int currentLap = 0;
    private int totalStints;
    private int totalStops;
    private double fuelToGo;
    private double fuelPerLap;
    private double totalFuel;
    private Stint averageFuelStops;
    private ArrayList<Stint> stints;

    public FuelStrategy() {
    }

    public void calcFuelToGo() {
        fuelToGo = fuelPerLap * (totalLaps - currentLap);
    }

    public int getTotalLaps() {
        return totalLaps;
    }

    public void setTotalLaps(int totalLaps) {
        this.totalLaps = totalLaps;
    }

    public void setTotalStops(int totalStops) {
        this.totalStops = totalStops++;
        this.totalStints = totalStops;
    }

    public int getTotalStops() {
        return totalStops;
    }

    public int getCurrentLap() {
        return currentLap;
    }

    public void setCurrentLap(int currentLap) {
        if (currentLap > 0) {
            currentLap--;
        }
        this.currentLap = currentLap;
    }

    public void calcTotalFuel() {
        totalFuel = totalLaps * fuelPerLap;
    }

    public void calcEvenStint() {
        calcTotalFuel();
        averageFuelStops = new Stint(totalFuel / totalStints, totalLaps / totalStints);
    }

    public Stint getAverageFuelStops() {
        return averageFuelStops;
    }

    public void calcCustomStints(ArrayList<Integer> stopLaps) {
        calcTotalFuel();
        stints = new ArrayList<>();

        for (int stopLap : stopLaps) {
            if (DEBUG) {
                System.out.println("Stop Laps: " + stopLap);
            }
            Stint stint = new Stint(stopLap * fuelPerLap, stopLap);
            stints.add(stint);
        }
    }
    public ArrayList<Stint> getStints(){
        return stints;
    }

    public void calcEvenStints() {
        calcTotalFuel();
        stints = new ArrayList<>();
        int lapsToGo = totalLaps - currentLap;
        double lapsPerStint = lapsToGo / totalStints;
        int extraLaps = lapsToGo % totalStints;
        if (DEBUG) {
            System.out.println("extra laps: " + extraLaps);
        }
        for (int i = 0; i < totalStints; i++) {
            int laps = (int) lapsPerStint;
            if (extraLaps > i) {
                laps++;
            }
            double fuel = laps * fuelPerLap;
            if (DEBUG) {
                System.out.printf("fuel: %.2f, laps: %d%n", fuel, laps);
            }
            Stint stint = new Stint(fuel, laps);
            stints.add(stint);
        }
    }

    public double getFuelPerLap() {
        return fuelPerLap;
    }

    public void setFuelPerLap(double fuelPerLap) {
        this.fuelPerLap = fuelPerLap;
    }

    public String printStints() {
        String message = "";
        for (int i = 0; i < stints.size(); i++) {
            message += String.format("\tStint: %d ", i + 1);
            message += stints.get(i).printStint();
            message += '\n';
        }
        return message;
    }

    @Override
    public String toString() {
        return String.format("Current lap: %d%nTotal laps: %d%nTotal stops: "
                + "%d%nFuel per lap: %.2f%nTotal Fuel: %.2f%n"
                + "Fuel To Go: %.2f%n", currentLap + 1, totalLaps, totalStops,
                fuelPerLap, totalFuel, fuelToGo);
    }
}