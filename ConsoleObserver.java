public class ConsoleObserver implements SensorObserver<Double>{
    public void onReading(Sensor<Double> source, Double value){
        System.out.printf("[%s @ %s] %1f%n", source.getSensorId(), source.getLocation(), value);
    }
}