/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package Reloj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.EventListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * A custom clock component bean that extends JLabel to display the current
 * time.
 * It supports both 24-hour and 12-hour formats and includes an alarm feature.
 * When the alarm is activated and the time matches the set alarm time, a
 * listener event is triggered.
 * 
 * The clock updates every second using a javax.swing.Timer.
 * 
 * <p>
 * This bean includes properties for:
 * <ul>
 * <li>Time format: 24-hour or 12-hour</li>
 * <li>Alarm activation</li>
 * <li>Alarm hour and minute settings</li>
 * </ul>
 * </p>
 * 
 * @author rafa
 */
public class ComponenteRelojBean extends JLabel implements Serializable, ActionListener {

    // Indicates if the time should be displayed in 24-hour format
    public boolean twentyFour;

    // Flag to enable or disable the alarm
    public boolean alarm;

    // The minute value for the alarm time
    public int minute_alarm;

    // The hour value for the alarm time
    public int hour_alarm;

    // Timer to update the clock display every second
    private final Timer t;

    // Holds the current system time
    private LocalTime horaActual;

    // Formatter for displaying the time
    private DateTimeFormatter formatter;

    // Listener for alarm events
    private DefinirAlarmaListener receptor;

    /**
     * Constructor for ComponenteRelojBean, initializes the timer, formats the
     * current time,
     * and starts the timer for continuous updates.
     */
    public ComponenteRelojBean() {
        this.t = new Timer(1000, (ActionListener) this); // Timer updates every 1 second
        this.twentyFour = false; // Default to 12-hour format
        this.alarm = false; // Alarm off by default
        this.horaActual = LocalTime.now(); // Initialize with the current time
        this.formatter = DateTimeFormatter.ofPattern("hh:mm:ss a"); // Default to 12-hour format
        String horaFormateada = horaActual.format(formatter);
        setText(horaFormateada); // Set initial time display on the label
        this.t.start(); // Start the timer
    }

    /**
     * Checks if the clock is in 24-hour format.
     * 
     * @return true if 24-hour format, false if 12-hour format.
     */
    public Boolean isTwentyFour() {
        return twentyFour;
    }

    /**
     * Sets the clock display to 24-hour or 12-hour format.
     * 
     * @param twentyFour true for 24-hour format, false for 12-hour format.
     */
    public void setTwentyFour(boolean twentyFour) {
        this.twentyFour = twentyFour;
    }

    /**
     * Checks if the alarm is currently enabled.
     * 
     * @return true if the alarm is enabled, false otherwise.
     */
    public Boolean isAlarm() {
        return alarm;
    }

    /**
     * Enables or disables the alarm.
     * 
     * @param alarm true to enable the alarm, false to disable it.
     */
    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }

    /**
     * Gets the hour set for the alarm.
     * 
     * @return the hour value for the alarm.
     */
    public int getHour() {
        return hour_alarm;
    }

    /**
     * Sets the hour for the alarm.
     * 
     * @param hour the hour value for the alarm.
     */
    public void setHour(int hour) {
        this.hour_alarm = hour;
    }

    /**
     * Gets the minute set for the alarm.
     * 
     * @return the minute value for the alarm.
     */
    public int getMinute() {
        return minute_alarm;
    }

    /**
     * Sets the minute for the alarm.
     * 
     * @param minute the minute value for the alarm.
     */
    public void setMinute(int minute) {
        this.minute_alarm = minute;
    }

    /**
     * Handles timer action events to update the time display and check for the
     * alarm.
     * If the alarm is enabled and the current time matches the alarm time, the
     * alarm event is triggered.
     * 
     * @param e ActionEvent triggered by the timer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        formatHour(formatter); // Update the time display
        repaint(); // Refresh the label to show the updated time
        // Check if the alarm should go off
        if (alarm && horaActual.getHour() == hour_alarm && horaActual.getMinute() == minute_alarm) {
            receptor.capturarAlarma(new DefinirAlarmaEvent(this)); // Trigger the alarm event
        }
    }

    /**
     * Updates the time format based on the current time format setting (12-hour or
     * 24-hour).
     * 
     * @param formatter The DateTimeFormatter used to format the time display.
     */
    public void formatHour(DateTimeFormatter formatter) {
        this.horaActual = LocalTime.now(); // Get the current time
        // Update the formatter based on 12-hour or 24-hour format setting
        this.formatter = twentyFour ? DateTimeFormatter.ofPattern("HH:mm:ss")
                : DateTimeFormatter.ofPattern("hh:mm:ss a");
        String horaFormateada = horaActual.format(formatter); // Format the current time
        setText(horaFormateada); // Display the formatted time
    }

    /**
     * Registers an alarm listener to capture alarm events.
     * 
     * @param receptor the alarm listener to register.
     */
    public void addDefinirAlarmaListener(DefinirAlarmaListener receptor) {
        this.receptor = receptor;
    }

    /**
     * Unregisters the current alarm listener.
     */
    public void removeDefinirAlarmalistener() {
        this.receptor = null;
    }

    /**
     * Listener interface for handling alarm events.
     */
    public interface DefinirAlarmaListener extends EventListener {

        /**
         * Method invoked when the alarm is triggered.
         * 
         * @param ev the alarm event.
         */
        public void capturarAlarma(DefinirAlarmaEvent ev);
    }
}
