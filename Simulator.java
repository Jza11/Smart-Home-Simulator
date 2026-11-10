public class Simulator{
    public static void main(String[] args) {
        System.out.println("Temperature Sensor");
        Sensor<Double> temp = SensorFactory.createTempSensor("T1", "Living Room");
        temp.attachObserver(new ConsoleObserver());

        for (int i = 0; i < 5; i++) {
            temp.update();
        }

        System.out.println("Smoke Detector");
        Sensor<Boolean> smoke = SensorFactory.createSmokeDetector("S1", "Kitchen");
        smoke.attachObserver(new SmokeObserver());

        for (int i = 0; i<5; i++){
            smoke.update();
        }

        System.out.println("Door Detector");
        Sensor<Boolean> testDoor = SensorFactory.createDoorSensor("D1", "Test Door");
        testDoor.attachObserver(new DoorObserver());

        for (int i = 0; i<5; i++){
            testDoor.update();
        }

        System.out.println("Motion Detector");
        Sensor<Boolean> livingRoomMovement = SensorFactory.createMotionSensor("M1", "Living Room");
        livingRoomMovement.attachObserver(new MotionObserver());

        for (int i = 0; i<5; i++){
            livingRoomMovement.update();
        }

        Device bedroomLight = new LightDevice("L-01", "Bedroom 1");

        Device livingLight = new LightDevice("L-02", "Living Room");

        DeviceObserver lightObs = (device, on) -> 
            System.out.println("Light " + device.getDeviceId() + " at " + device.getLocation() + " is now: " + (on ? "ON" : "OFF"));

        bedroomLight.attachObserver(lightObs);
        livingLight.attachObserver(lightObs);

        bedroomLight.turnOn();
        bedroomLight.turnOn();
        bedroomLight.turnOff();

        livingLight.turnOn();
        livingLight.turnOn();
        livingLight.turnOff();

        DoorLockDevice mainDoorLock = new DoorLockDevice("D-01", "Main Door");

        Sensor<Boolean> sensorEntranceDoor = SensorFactory.createDoorSensor("D2", "Entrance Door", mainDoorLock);
        sensorEntranceDoor.attachObserver(new DoorObserver());

        System.out.println("\nTesting the door and sensor connection \n");

        sensorEntranceDoor.update();
        mainDoorLock.turnOn();
        mainDoorLock.turnOn();
        sensorEntranceDoor.update();
        mainDoorLock.turnOff();
        sensorEntranceDoor.update();
    }
}
