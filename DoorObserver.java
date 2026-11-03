public class DoorObserver implements SensorObserver<Boolean>{
    public void onReading(Sensor<Boolean> source, Boolean value){
        String status = value ? "Door is currently open!" : "Door is closed";

        System.out.printf("[%s @ %s] %s%n", source.getSensorId(), source.getLocation(), status);
    }
}