public class Simulator{
    public static void main(String[] args) {
        Sensor<Double> temp = new TemperatureSensor("T1", "Living Room", new RandomReadingStrategy(21.0, 0.3));
        temp.attachObserver(new ConsoleObserver());

        for (int i = 0; i < 5; i++) {
            temp.update();
        }
    }
}