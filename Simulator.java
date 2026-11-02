public class Simulator{
    public static void main(String[] args) {
        ReadingStrategy<Double> strategy = new RandomReadingStrategy(21.0, 0.3);
        for (int i = 0; i < 5; i++) {
            System.out.printf("%.2f%n", strategy.next());
        }
    }
}