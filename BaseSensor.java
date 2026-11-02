import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class BaseSensor<T> implements Sensor<T>{

    private final String sensorId;
    private final String location; 
    private final ReadingStrategy<T> readStrategy;
    private final List<SensorObserver<T>> observers = new CopyOnWriteArrayList<>();

    private volatile boolean active = true;

    private volatile T latestValue;

    protected BaseSensor(String sensorId, String location, ReadingStrategy<T> strategy){
        this.sensorId = Objects.requireNonNull(sensorId, "sensorId");
        this.location = Objects.requireNonNull(location, "location");
        this.readStrategy = Objects.requireNonNull(strategy, "strategy");
        this.latestValue = readStrategy.next();
    }

    /**
     * 
     *  Return the ID of the sensor
     */
    public String getSensorId(){
        return sensorId;
    }
    
    /**
     * 
     * Return the location where the sensor is installed
    */
    public String getLocation(){
        return location;
    }

    /**
     *  Verify if the sensor is active or not 
    */
    public boolean isActive(){
        return active;
    }

     /**
     *  Activate the sensor  
    */
    public void activate(){
        active = true;
    }

    /**
     *  Deactivate the sensor  
    */
    public void deactivate(){
        active = false; 
    }


    /**
     *  Update the reading of the sensor
     * 
     */
    public void update(){
        if (!active) return;

        T value = readStrategy.next();
        latestValue = value;
        notifyObservers(value);
    }

    private void notifyObservers(T value){
        for (SensorObserver<T> listener : observers){
            listener.onReading(this, value);
        }
    }

    /**
     * 
     * Get the most recent reading of the sensor
     */
    public T getSensorValue() {
        return latestValue;
    }

    /**
     * Attach an observer to this sensor
     */
   public void attachObserver(SensorObserver<T> listener){
        observers.add(listener);
   }

     /**
     * Detach an observer to this sensor
     */
   public void detachObserver(SensorObserver<T> listener){
        observers.remove(listener);
   }

   public String toString(){
        return getClass().getSimpleName() + "[" + sensorId + " @ " + location + "]";
   }
}