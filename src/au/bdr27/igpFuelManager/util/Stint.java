/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager.util;

/**
 *
 * @author Brendan
 */
public class Stint {
    double fuel;
    double lap;
    
    public Stint(double fuel, double lap){
        this.fuel = fuel;
        this.lap = lap;
    }
    
    public double getFuel(){
        return fuel;
    }
    
    public double getLap(){
        return lap;
    }
    
    @Override
    public String toString()
    {
        return String.format("Fuel:%.2f%nLaps:%.2f%n", fuel, lap);
    }
}
