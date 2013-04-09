/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager.GUI;

import javax.swing.JFrame;

/**
 *
 * @author Brendan
 */
public class MainGUI{
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        mainFrame.add(new MainPanel());
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setFocusable(true);
    }
}
