public class MotionSensor extends BaseSensor<Boolean>{
    public MotionSensor(String id, String location, ReadingStrategy<Boolean> strategy){
        super(id, location, strategy);
    }

    public boolean isThereMovement(){
        return getSensorValue();
    }
}