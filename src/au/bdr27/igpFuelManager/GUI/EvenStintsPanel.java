/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Brendan
 */
public class EvenStintsPanel extends JPanel{
    private JPanel acceptCancelPanel = new JPanel();
    private JPanel stintInfoPanel = new JPanel();
    private JLabel lblStops = new JLabel("Total Stops");
    private JLabel lblFuel = new JLabel("Fuel Per Lap: ");
    private JLabel lblLaps = new JLabel("Total Laps: ");
    
    private JTextField txtStops = new JTextField();
    private JTextField txtFuel = new JTextField();
    private JTextField txtLaps = new JTextField();
    
    private JButton btnClear = new JButton("Clear");
    private JButton btnGo = new JButton("Go");
    
    public EvenStintsPanel(){
        this.setLayout(new BorderLayout());
        stintInfoPanel.setLayout(new GridLayout(0,1));
        
        //Change to use grid and flow.
        stintInfoPanel.add(lblStops);
        stintInfoPanel.add(txtStops);
        stintInfoPanel.add(lblFuel);
        stintInfoPanel.add(txtFuel);
        stintInfoPanel.add(lblLaps);
        stintInfoPanel.add(txtLaps);
        
        //Accept cancel buttons
        acceptCancelPanel.setLayout(new FlowLayout());
        acceptCancelPanel.add(btnClear);
        acceptCancelPanel.add(btnGo);
        
        this.add(stintInfoPanel, BorderLayout.CENTER);
        this.add(acceptCancelPanel, BorderLayout.SOUTH);
    }

    void goTo() {
        this.setVisible(true);
        this.setFocusable(true);
    }

    void goAway() {
        this.setVisible(false);
        this.setFocusable(false);
    }
}
