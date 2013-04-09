/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager.GUI;

import au.bdr27.igpFuelManager.util.CurrentPanelState;
import au.bdr27.igpFuelManager.util.Debug;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Brendan
 */
public class MainPanel extends JPanel implements ActionListener {

    private boolean DEBUG = Debug.value;
    private CurrentPanelState state = CurrentPanelState.EvenStints;
    private JLabel author = new JLabel("By Brendan Russo");
    private JButton btnHome = new JButton("Home");
    private JButton btnEvenStints = new JButton("Even Stints");
    private JButton btnCustomStints = new JButton("Custom Stints");
    private JPanel homePanel = new JPanel();
    private EvenStintsPanel evenStintsPanel = new EvenStintsPanel();
    private JPanel navPanel = new JPanel();

    public MainPanel() {
        //Sets up the panel
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new BorderLayout());
        this.add(author, BorderLayout.SOUTH);

        //Set up the nav panel
        setUpNavPanel();
        evenStintsPanel.goAway();
        this.add(evenStintsPanel, BorderLayout.CENTER);
        evenStintsPanel.goTo();

    }

    private void setUpNavPanel() {
        navPanel.setLayout(new GridLayout(0, 3));

        //Adds the buttons
        navPanel.add(btnHome);
        navPanel.add(btnEvenStints);
        navPanel.add(btnCustomStints);

        //Adds the action listeners
        btnHome.addActionListener(this);
        btnEvenStints.addActionListener(this);
        btnCustomStints.addActionListener(this);

        //Adds nav to the panel
        this.add(navPanel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(btnHome.getActionCommand()) && !state.equals(CurrentPanelState.Home)) {
            state = CurrentPanelState.Home;
            if (DEBUG) {
                System.out.println("Home");
            }
            evenStintsPanel.goAway();
        } else if (e.getActionCommand().equals(btnEvenStints.getActionCommand()) && !state.equals(CurrentPanelState.EvenStints)) {
            state = CurrentPanelState.EvenStints;
            if (DEBUG) {
                System.out.println("Even Stints");
            }
            evenStintsPanel.goTo();
        } else if (e.getActionCommand().equals(btnCustomStints.getActionCommand()) && !state.equals(CurrentPanelState.CustomStints)) {
            state = CurrentPanelState.CustomStints;
            if (DEBUG) {
                System.out.println("Custom stints");
            }
            evenStintsPanel.goAway();
        } else {
            if (DEBUG) {
                System.out.println("Invalid Action");
            }
        }
    }
}
