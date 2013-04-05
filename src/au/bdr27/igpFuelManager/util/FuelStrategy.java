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
    private double fuelPerLap;
    private ArrayList<Stint> fuelStop;
    
    public FuelStrategy()
    {
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
        this.currentLap = currentLap;
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
        return String.format("current lap: %d, total laps: %d, total stops: %d, fuel per lap: %f", currentLap, totalLaps, totalStops, fuelPerLap);
    }
    
}
