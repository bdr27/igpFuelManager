/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager.GUI;
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
import sun.security.util.Debug;

/**
 *
 * @author Brendan
 */
public class MainPanel extends JPanel implements ActionListener{
    private JLabel author = new JLabel("By Brendan Russo");
    private JButton btnHome = new JButton("Home");
    private JButton btnEvenStints = new JButton("Even Stints");
    private JButton btnCustomStints = new JButton("Custom Stints");
    private JPanel homePanel = new JPanel();
    private EvenStintsPanel evenStintsPanel = new EvenStintsPanel();
    private JPanel navPanel = new JPanel();
    
    public MainPanel()
    {
        //Sets up the panel
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new BorderLayout());
        this.add(author, BorderLayout.SOUTH);
        
        //Set up the nav panel
        setUpNavPanel();    
        evenStintsPanel.setVisible(false);
        this.add(evenStintsPanel, BorderLayout.CENTER);
        
    }
    private void setUpNavPanel(){
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
        if(e.getActionCommand().equals(btnHome.getActionCommand()))
        {
            System.out.println("Home");
            evenStintsPanel.goAway();
        }else if(e.getActionCommand().equals(btnEvenStints.getActionCommand())){
            System.out.println("Even Stints");
            evenStintsPanel.goTo();
        }else if(e.getActionCommand().equals(btnCustomStints.getActionCommand())){
            System.out.println("Custom stints");
        }else{
            System.out.println("Not yet implemented");
        }
    }
}
