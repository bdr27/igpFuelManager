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
    private int totalLaps;
    private int currentLap = 0;
    private int totalStops;
    private double fuelToGo;
    private double fuelPerLap;
    private double totalFuel;
    private double fuelPerStrint;
    private Stint averageFuelStops;
    private ArrayList<Stint> fuelStops;
    
    public FuelStrategy()
    {
    }
    public void calcTotalFuel()
    {
        totalFuel = fuelPerLap * totalLaps;
    }
    public void calcFuelToGo()
    {
        fuelToGo = fuelPerLap * (totalLaps - currentLap);
    }

    public int getTotalLaps() {
        return totalLaps;
    }

    public void setTotalLaps(int totalLaps) {
        this.totalLaps = totalLaps;
    }

    public int getCurrentLap() {
        return currentLap;
    }

    public void setCurrentLap(int currentLap) {
        if(currentLap > 0){
            currentLap--;
        }
        this.currentLap = currentLap;
    }
    public void generateEvenStints() {
        averageFuelStops = new Stint((totalFuel/totalStops), (totalLaps/totalStops));
        System.out.println(averageFuelStops.toString());
    }

    public int getTotalStops() {
        return totalStops;
    }

    public void setTotalStops(int totalStops) {
        this.totalStops = totalStops;
    }

    public double getFuelPerLap() {
        return fuelPerLap;
    }

    public void setFuelPerLap(double fuelPerLap) {
        this.fuelPerLap = fuelPerLap;
    }
    
    @Override
    public String toString()
    {
        return String.format("Current lap: %d%nTotal laps: %d%nTotal stops: "
                + "%d%nFuel per lap: %.2f%nTotal Fuel: %.2f%n"
                + "Fuel To Go: %.2f%n", currentLap + 1, totalLaps, totalStops, 
                fuelPerLap, totalFuel, fuelToGo);
    }
}