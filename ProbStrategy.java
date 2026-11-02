import java.util.Random;

public class ProbStrategy implements ReadingStrategy<Boolean>{
    
    private final double probability; 

    private final Random random = new Random();

    public ProbStrategy(double probability){
        this.probability = probability;
    }

    public Boolean next(){
        return random.nextDouble() < probability;
    }

}