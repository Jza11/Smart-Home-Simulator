import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Objects;
import java.util.List;

// Base class for each device. It toogles the device between on and off. 
public abstract class BaseDevice implements Device {
    
    private final String deviceId;
    private final String location;
    private boolean on; 
    private final List<DeviceObserver> observers = new CopyOnWriteArrayList<>();

    protected BaseDevice(String deviceId, String location) {
        this.deviceId = Objects.requireNonNull(deviceId, "deviceId");
        this.location = Objects.requireNonNull(location, "location");
        on = false;
    }


    /**
     * 
     * Retrieve the id of the Device
     */
    public String getDeviceId(){
        return deviceId;
    }

    /**
     *  Retrieve the location where the device is located
     */
    public String getLocation() {
        return location;
    }

    /**
     * 
     * Method to turn on the device, It notifies the observers abd set the on variable to true
     * The concrete performturnon method will be implemented inside subclasses, but the subclass will use
     * the general turn on method
     */
    public final void turnOn() {
        if (on) return;
        performTurnOn();
        on = true;
        notifyObservers();
    }

    /**
     * 
     * Method to turn off the device. It notifies the observers and set the on variable to false
     * The concrete performturnoff method will be implemented inside subclasses, but the subclass will use
     * the general turn off method
     */
    public final void turnOff() {
        if (!on) return;
        performTurnOff();
        on = false; 
        notifyObservers();
    }

     /**
     * 
     * Method to check if the device is on
     */
    public Boolean isOn() {
        return on; 
    }

    /**
     * 
     * Notify change in state from the device to objects 
     */
    private void notifyObservers(){
        for (DeviceObserver listener : observers){
            listener.onStatusChange(this, on);
        }
    }

    /**
    * Attach an observer to this device
    */
   public void attachObserver(DeviceObserver listener){
        observers.add(listener);
   }

     /**
     * Detach an observer from this device
     */
   public void detachObserver(DeviceObserver listener){
        observers.remove(listener);
   }

   public String toString(){
        return getClass().getSimpleName() + "[" + deviceId + " @ " + location + "]";
   }


    /**
     * 
     * Step methods that need to be implemented by subclasses to allow a specific behavior. 
     */
    protected abstract void performTurnOn();
    protected abstract void performTurnOff();
}