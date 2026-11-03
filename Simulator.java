public class Simulator{
    public static void main(String[] args) {
        System.out.println("Temperature Sensor");
        Sensor<Double> temp = SensorFactory.createTempSensor("T1", "Living Room");
        temp.attachObserver(new ConsoleObserver());

        for (int i = 0; i < 5; i++) {
            temp.update();
        }

        System.out.println("Smoke Detector");
        Sensor<Boolean> smoke = SensorFactory.createSmokeDetector("S1", "Kitchen");
        smoke.attachObserver(new SmokeObserver());

        for (int i = 0; i<5; i++){
            smoke.update();
        }
    }
}
