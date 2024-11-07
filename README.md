# Clock Component Project for Interface Development (ComponenteRelojBean)

This project demonstrates the use of a custom Java Swing clock component, `ComponenteRelojBean`, built as part of an educational exercise for interface development. The clock component (`ComponenteRelojBean`) is designed to function as a JavaBean, providing a visual real-time clock display and an alarm feature that notifies the user when the specified time is reached. 

## Project Overview

The project is composed of:
- **ComponenteRelojBean**: A Java Swing component that extends `JLabel` to display a live clock with an optional alarm.
- **DefinirAlarmaEvent**: A custom event that triggers when the alarm is reached.
- **Solucion_DI03**: The main application window, which integrates the clock component and provides a user interface for setting the alarm and receiving notifications.

## Key Features

- **Real-time Clock Display**: The `ComponenteRelojBean` displays the current time, updated every second.
- **Configurable Time Format**: Users can toggle between 12-hour (AM/PM) and 24-hour formats.
- **Alarm Notification**: Users can set an alarm for a specific hour and minute. When the alarm time is reached, a notification pops up.
- **Event-Driven Alarm Handling**: The alarm triggers an event that the main application listens to, allowing for custom handling of alarm notifications.

## Project Structure

- **`Reloj.ComponenteRelojBean`**: This component encapsulates the logic for displaying and formatting time, as well as handling the alarm functionality.
    - `setTwentyFour(boolean)`: Enables or disables 24-hour time format.
    - `setAlarm(boolean)`: Activates or deactivates the alarm.
    - `setHour(int)` and `setMinute(int)`: Set the hour and minute for the alarm.
    - `addDefinirAlarmaListener(DefinirAlarmaListener)`: Adds an alarm listener to capture the alarm event.

- **`Reloj.DefinirAlarmaEvent`**: A custom event that represents the alarm trigger. It is used by `ComponenteRelojBean` to notify listeners when the alarm time is reached.

- **`Solucion.Solucion_DI03`**: The main application class that integrates `ComponenteRelojBean` and listens for alarm events to display a pop-up message when the alarm is triggered.

## How to Use

1. **Clock Component Display**: The `ComponenteRelojBean` automatically updates every second to display the current time.
2. **Alarm Setup**:
    - Use `setHour(int)` and `setMinute(int)` to define the alarm time.
    - Enable the alarm using `setAlarm(true)`.
3. **Alarm Notification**:
    - When the current time matches the alarm time, an `DefinirAlarmaEvent` is triggered.
    - The `Solucion_DI03` application listens for this event and displays a dialog box to notify the user.

## Code Highlights

### `ComponenteRelojBean`

The `ComponenteRelojBean` class is a JavaBean component that displays the current time and manages the alarm functionality. The component uses a `javax.swing.Timer` to update the time every second and checks if the alarm conditions are met.

### `DefinirAlarmaEvent`

This class is a simple custom event extending `EventObject`. It is used to represent the moment when the alarm time is reached.

### `Solucion_DI03`

This class is a GUI application that uses `ComponenteRelojBean`. It listens for alarm events and displays a notification dialog using `JOptionPane` when the alarm goes off.

## Prerequisites

- Java Development Kit (JDK) 8 or later
- A compatible IDE for Java (e.g., NetBeans, Eclipse, IntelliJ IDEA)
- Basic knowledge of Java Swing and event-driven programming

## Educational Objectives

This project is designed to reinforce:
- Understanding of JavaBeans and Swing components.
- Event handling and custom event creation in Java.
- GUI application design using Swing components and JavaFX (if further integration is desired).
- Interaction between UI components and back-end logic.

## Future Extensions

As a formative project, this implementation can be extended with additional features:
- **User Interface for Alarm Setup**: A panel with input fields to allow the user to set the alarm directly from the UI.
- **Multiple Alarm Support**: Extend the functionality to handle multiple alarms with individual notifications.
- **Date-Based Alarms**: Enable setting alarms for specific dates and times.
- **Enhanced Styling**: Apply custom styling to improve the visual aesthetics of the clock component.