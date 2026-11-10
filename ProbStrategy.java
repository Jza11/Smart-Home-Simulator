import java.util.Random;

public class ProbStrategy implements ReadingStrategy<Boolean>{
    
    // Probability variable
    private final double probability; 

    // Make a random object 
    private final Random random = new Random();

    // Constructor of the class 
    public ProbStrategy(double probability){
        this.probability = probability;
    }

    // Return true whenever the nextDouble is less than the probability. Else false
    public Boolean next(){
        return random.nextDouble() < probability;
    }

}