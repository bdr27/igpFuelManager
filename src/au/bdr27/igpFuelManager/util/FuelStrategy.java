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

    private final boolean DEBUG = true;
    private int totalLaps;
    private int currentLap = 0;
    private int totalStints;
    private int totalStops;
    private double fuelToGo;
    private double fuelPerLap;
    private double totalFuel;
    private Stint averageFuelStops;
    private ArrayList<Stint> stints = new ArrayList<Stint>();

    public FuelStrategy() {
    }

    public void calcTotalFuel() {
        totalFuel = fuelPerLap * totalLaps;
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
    
    public void setTotalStops(int totalStops){
        this.totalStops = totalStops++;
        this.totalStints = totalStops;
    }
    
    public int getTotalStops(){
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

    private void generateTotalFuel() {
        totalFuel = totalLaps * fuelPerLap;
    }

    public void generateEvenStint() {
        generateTotalFuel();
        averageFuelStops = new Stint(totalFuel / totalStints, totalLaps / totalStints);
    }

    public Stint getAverageFuelStops() {
        return averageFuelStops;
    }

    public void generateEvenStints() {
        generateTotalFuel();

        double lapsPerStint = totalLaps / totalStints;
        int extraLaps = totalLaps % totalStints;
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

    @Override
    public String toString() {
        return String.format("Current lap: %d%nTotal laps: %d%nTotal stops: "
                + "%d%nFuel per lap: %.2f%nTotal Fuel: %.2f%n"
                + "Fuel To Go: %.2f%n", currentLap + 1, totalLaps, totalStops,
                fuelPerLap, totalFuel, fuelToGo);
    }
}