public class DoorSensor extends BaseSensor<Boolean>{
    public DoorSensor(String id, String location, ReadingStrategy<Boolean> strategy){
        super(id, location, strategy);
    }

    public boolean isDoorOpen(){
        return getSensorValue();
    }
}