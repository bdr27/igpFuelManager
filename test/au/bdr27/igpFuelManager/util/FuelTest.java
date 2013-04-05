/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brendan
 */
public class FuelTest {
    
    public FuelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTotalLaps method, of class Fuel.
     */
    @Test
    public void testGetTotalLaps() {
        System.out.println("getTotalLaps");
        FuelStrategy instance = new FuelStrategy();
        int expResult = 0;
        int result = instance.getTotalLaps();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalLaps method, of class Fuel.
     */
    @Test
    public void testSetTotalLaps() {
        System.out.println("setTotalLaps");
        int totalLaps = 0;
        FuelStrategy instance = new FuelStrategy();
        instance.setTotalLaps(totalLaps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentLap method, of class Fuel.
     */
    @Test
    public void testGetCurrentLap() {
        System.out.println("getCurrentLap");
        FuelStrategy instance = new FuelStrategy();
        int expResult = 0;
        int result = instance.getCurrentLap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentLap method, of class Fuel.
     */
    @Test
    public void testSetCurrentLap() {
        System.out.println("setCurrentLap");
        int currentLap = 0;
        FuelStrategy instance = new FuelStrategy();
        instance.setCurrentLap(currentLap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalStops method, of class Fuel.
     */
    @Test
    public void testGetTotalStops() {
        System.out.println("getTotalStops");
        FuelStrategy instance = new FuelStrategy();
        int expResult = 0;
        int result = instance.getTotalStops();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalStops method, of class Fuel.
     */
    @Test
    public void testSetTotalStops() {
        System.out.println("setTotalStops");
        int totalStops = 0;
        FuelStrategy instance = new FuelStrategy();
        instance.setTotalStops(totalStops);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFuelPerLap method, of class Fuel.
     */
    @Test
    public void testGetFuelPerLap() {
        System.out.println("getFuelPerLap");
        FuelStrategy instance = new FuelStrategy();
        double expResult = 0.0;
        double result = instance.getFuelPerLap();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFuelPerLap method, of class Fuel.
     */
    @Test
    public void testSetFuelPerLap() {
        System.out.println("setFuelPerLap");
        double fuelPerLap = 0.0;
        FuelStrategy instance = new FuelStrategy();
        instance.setFuelPerLap(fuelPerLap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Fuel.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FuelStrategy instance = new FuelStrategy();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}