/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr27.igpFuelManager.GUI;

import au.bdr27.igpFuelManager.util.Debug;
import au.bdr27.igpFuelManager.util.FuelStrategy;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Brendan
 */
public class EvenStintsPanel extends JPanel implements ActionListener {
    private boolean DEBUG = Debug.value;
    private JPanel acceptCancelPanel = new JPanel();
    private JPanel stintInfoPanel = new JPanel();
    private JLabel lblStops = new JLabel("Total Stops: ");
    private JLabel lblFuel = new JLabel("Fuel Per Lap: ");
    private JLabel lblLaps = new JLabel("Total Laps: ");
    private JLabel lblCurrentLap = new JLabel("Current Lap: ");
    private JTextField txtCurrentLap = new JTextField("0");
    private JTextField txtStops = new JTextField();
    private JTextField txtFuel = new JTextField();
    private JTextField txtLaps = new JTextField();
    private JTextArea txtStintInfo = new JTextArea();
    private JButton btnClear = new JButton("Clear");
    private JButton btnGo = new JButton("Go");

    public EvenStintsPanel() {
        this.setLayout(new BorderLayout());
        stintInfoPanel.setLayout(new GridLayout(0, 2));

        stintInfoPanel.add(lblCurrentLap);
        stintInfoPanel.add(txtCurrentLap);
        stintInfoPanel.add(lblLaps);
        stintInfoPanel.add(txtLaps);
        stintInfoPanel.add(lblStops);
        stintInfoPanel.add(txtStops);
        stintInfoPanel.add(lblFuel);
        stintInfoPanel.add(txtFuel);

        //Aligns text to the right
        lblStops.setHorizontalAlignment(JLabel.RIGHT);
        lblFuel.setHorizontalAlignment(JLabel.RIGHT);
        lblLaps.setHorizontalAlignment(JLabel.RIGHT);
        lblCurrentLap.setHorizontalAlignment(JLabel.RIGHT);

        //Accept cancel buttons
        acceptCancelPanel.setLayout(new FlowLayout());
        acceptCancelPanel.add(btnClear);
        acceptCancelPanel.add(btnGo);
        txtStintInfo.setEnabled(false);

        this.add(txtStintInfo, BorderLayout.CENTER);
        this.add(stintInfoPanel, BorderLayout.PAGE_START);
        this.add(acceptCancelPanel, BorderLayout.PAGE_END);
    }

    /*
     * Set's the panel to be visable and adds focus to the panel. Also enables
     * the action lister for the JButtons on this panel
     */
    public void goTo() {
        this.setVisible(true);
        this.setFocusable(true);
        btnClear.addActionListener(this);
        btnGo.addActionListener(this);
    }

    /*
     * Sets the panel to not be visable and removes the focus. Also disables
     * the action listeners for this panels buttons
     */
    public void goAway() {
        this.setVisible(false);
        this.setFocusable(false);
        btnClear.removeActionListener(this);
        btnGo.removeActionListener(this);
    }

    private void clearAllTextBackground() {
        txtStops.setBackground(Color.WHITE);
        txtFuel.setBackground(Color.WHITE);
        txtLaps.setBackground(Color.WHITE);
        txtCurrentLap.setBackground(Color.WHITE);
    }

    private void clearAllText() {
        txtCurrentLap.setText("0");
        txtStops.setText("");
        txtFuel.setText("");
        txtLaps.setText("");
        txtStintInfo.setText("");
    }

    private boolean validInput() {

        //Checks each input
        if (checkTextFieldForInt(txtCurrentLap) & checkTextFieldForDouble(txtFuel)
                & checkTextFieldForInt(txtLaps) & checkTextFieldForInt(txtStops)) {
            return true;
        }
        return false;
    }

    private boolean checkTextFieldForDouble(JTextField textField) {
        boolean valid = true;
        textField.setText(textField.getText().trim());
        try {
            double x = Double.parseDouble(textField.getText());
            if (x < 0) {
                valid = false;
            }
        } catch (NumberFormatException nf) {
            valid = false;
        }
        if (!valid) {
            invalidTextField(textField);
        }

        return valid;
    }

    private boolean checkTextFieldForInt(JTextField textField) {
        boolean valid = true;
        textField.setText(textField.getText().trim());
        //Checks if it is an int and is greater then 0
        try {
            int x = Integer.parseInt(textField.getText());
            if (x < 0) {
                valid = false;
            }
        } catch (NumberFormatException nf) {
            valid = false;
        }

        //Set's background to red
        if (!valid) {
            invalidTextField(textField);
        }
        return valid;

    }

    private void invalidTextField(JTextField textField) {
        textField.setBackground(Color.red);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clearAllTextBackground();
        if (e.getActionCommand().equals(btnClear.getActionCommand())) {
            clearAllText();
        } else if (e.getActionCommand().equals(btnGo.getActionCommand())) {
            if (validInput()) {
                FuelStrategy fuel = new FuelStrategy();
                fuel.setFuelPerLap(Double.parseDouble(txtFuel.getText()));
                fuel.setTotalLaps(Integer.parseInt(txtLaps.getText()));
                fuel.setTotalStops(Integer.parseInt(txtStops.getText()));
                fuel.setCurrentLap(Integer.parseInt(txtCurrentLap.getText()));
                fuel.calcEvenStints();
                txtStintInfo.setText(fuel.printStints());
                if (DEBUG) {
                    System.out.println("Success");
                }
            } else {
                if (DEBUG) {
                    System.out.println("Failed");
                }
            }
        }
    }
}
