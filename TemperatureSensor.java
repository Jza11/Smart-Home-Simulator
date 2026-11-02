public class TemperatureSensor extends BaseSensor<Double>{
    public TemperatureSensor(String id, String location, ReadingStrategy<Double> strategy){
        super(id, location, strategy);
    }
}