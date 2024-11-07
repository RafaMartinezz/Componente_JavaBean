/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reloj;

import java.util.EventObject;

/**
 * Event class representing an alarm trigger event in the ComponenteRelojBean.
 * This class extends EventObject and is used to encapsulate information
 * about the alarm event when it is fired.
 * 
 * The source of this event is typically an instance of ComponenteRelojBean
 * which checks for an alarm match and creates this event when the time
 * conditions are met.
 * 
 * @see ComponenteRelojBean
 * @see ComponenteRelojBean.DefinirAlarmaListener
 * 
 * @author rafa
 */
public class DefinirAlarmaEvent extends EventObject {

    /**
     * Constructs a new DefinirAlarmaEvent with the specified source object.
     * 
     * @param source The object on which the Event initially occurred.
     *               This is typically the clock component triggering the alarm.
     */
    public DefinirAlarmaEvent(Object source) {
        super(source);
    }
}
