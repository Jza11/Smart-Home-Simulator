public interface Sensor<T> {
    
    /**
     * 
     *  Return the ID of the sensor
     */
    String getSensorId(); 
    
    /**
     * 
     * Return the location where the sensor is installed
    */
    String getLocation();

    /**
     *  Verify if the sensor is active or not 
    */
    boolean isActive();
     /**
     *  Activate the sensor  
    */
    void activate();

    /**
     *  Deactivate the sensor  
    */
    void deactivate();


    /**
     *  Update the reading of the sensor
     * 
     */
    void update();

    /**
     * 
     * Get the most recent reading of the sensor
     */
    T getSensorValue();

    /**
     * Attach an observer to this sensor
     */
   void attachObserver(SensorObserver<T> listener);

     /**
     * Detach an observer to this sensor
     */
   void detachObserver(SensorObserver<T> listener);
}