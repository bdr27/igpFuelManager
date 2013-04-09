/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager.GUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Brendan
 */
public class MainPanel extends JPanel{
    public MainPanel()
    {
        this.setPreferredSize(new Dimension(800,600));
        this.setVisible(true);
        this.setFocusable(true);
        this.setBackground(Color.red);
    }
    
}
