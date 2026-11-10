public class LockStateStrategy implements ReadingStrategy<Boolean>{

    // Door Device or only the actual lock
    private final DoorLockDevice doorLock;

    // Constructor of the class 
    public LockStateStrategy(DoorLockDevice doorLock){
        this.doorLock = doorLock;
    }

    // Return the value read from the device 
    public Boolean next(){
        return doorLock.isLocked();
    }

}