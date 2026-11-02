import java.util.Random;

public class RandomReadingStrategy implements ReadingStrategy<Double>{

    // Variables of the class 
    // Current value
    private double current;

    // Maximum change per reading, the implementation change the current by 
    // +MaxChange or -MaxChange
    private final double maxChange;

    // Generate the random value that decides if its going to be plus or minus maxChange
    private final Random random = new Random();

    // Constructor of the class
    public RandomReadingStrategy(double start, double maxChange){
        this.current = start;
        this.maxChange = maxChange;
    }

    // Get the value by using the random changes. 
    public Double next(){
        double change = (random.nextDouble() * 2 - 1);
        current += change;
        return current; 
    }
}