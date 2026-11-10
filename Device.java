public interface Device{
    
    /**
     * 
     * Retrieve the id of the Device
     */
    String getDeviceId();

    /**
     *  Retrieve the location where the device is located
     */
    String getLocation();
    
    /**
     * 
     * Method to turn on the device
     */
    void turnOn();

    /**
     * 
     * Method to turn off the device 
     */
    void turnOff();

    /**
     * 
     * Method to check if the device is on
     */
    Boolean isOn();

    /**
     * Attach an observer to this sensor
     */
   void attachObserver(DeviceObserver listener);

    /**
     * Detach an observer to this sensor
     */
   void detachObserver(DeviceObserver listener);

    /**
     * 
     *  Print the object as a string
     */
   String toString();
}