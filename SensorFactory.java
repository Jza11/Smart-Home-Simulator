public class SensorFactory {
    private SensorFactory() {}
    
    public static Sensor<Double> createTempSensor(String id, String location){
        return new TemperatureSensor(id, location, new RandomReadingStrategy(20.0, 0.3));
    }

    public static Sensor<Boolean> createSmokeDetector(String id, String location){
        return new SmokeDetector(id, location, new ProbStrategy(0.2));
    }

    public static Sensor<Boolean> createDoorSensor(String id, String location){
        return new DoorSensor(id, location, new ProbStrategy(0.1));
    }

    public static Sensor<Boolean> createMotionSensor(String id, String location){
        return new MotionSensor(id, location, new ProbStrategy(0.8));
    }
}