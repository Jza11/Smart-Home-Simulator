public class MotionObserver implements SensorObserver<Boolean>{
    public void onReading(Sensor<Boolean> source, Boolean value){
        String status = value ? "MOTION DETECTED!" : "No movement";

        System.out.printf("[%s @ %s] %s%n", source.getSensorId(), source.getLocation(), status);
    }
}