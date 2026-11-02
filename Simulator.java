public class Simulator{
    public static void main(String[] args) {
        System.out.println("Temperature Sensor");
        Sensor<Double> temp = new TemperatureSensor("T1", "Living Room", new RandomReadingStrategy(21.0, 0.3));
        temp.attachObserver(new ConsoleObserver());

        for (int i = 0; i < 5; i++) {
            temp.update();
        }

        System.out.println("Smoke Detector");
        Sensor<Boolean> smoke = new SmokeDetector("S1", "Kitchen", new ProbStrategy(0.1));
        smoke.attachObserver(new SmokeObserver());

        for (int i = 0; i<5; i++){
            smoke.update();
        }
    }
}