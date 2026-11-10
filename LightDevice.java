/**
 * This class is implementing the specific steps for the general method turn on and turn off following
 * the behavior of a light. 
 */
public class LightDevice extends BaseDevice {
    LightDevice(String deviceId, String location){
        super(deviceId, location);
    }
    
    @Override 
    protected void performTurnOn(){
        System.out.println("The light is on");
    }

    @Override 
    protected void performTurnOff(){
        System.out.println("The light is off");
    }
}