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