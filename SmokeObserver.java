public class SmokeObserver implements SensorObserver<Boolean>{
    public void onReading(Sensor<Boolean> source, Boolean value){
        String status = value ? "SMOKE DETECTED!" : "clear";

        System.out.printf("[%s @ %s] %s%n", source.getSensorId(), source.getLocation(), status);
    }
}