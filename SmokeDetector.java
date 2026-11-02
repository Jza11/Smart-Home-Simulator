public class SmokeDetector extends BaseSensor<Boolean>{
    public SmokeDetector(String id, String location, ReadingStrategy<Boolean> strategy){
        super(id, location, strategy);
    }

    public boolean isSmokeDetected(){
        return getSensorValue();
    }
}