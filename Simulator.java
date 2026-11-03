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
        Sensor<Boolean> mainDoor = SensorFactory.createDoorSensor("D1", "Entrance Door");
        mainDoor.attachObserver(new DoorObserver());

        for (int i = 0; i<5; i++){
            mainDoor.update();
        }

        System.out.println("Motion Detector");
        Sensor<Boolean> livingRoomMovement = SensorFactory.createMotionSensor("M1", "Living Room");
        livingRoomMovement.attachObserver(new MotionObserver());

        for (int i = 0; i<5; i++){
            livingRoomMovement.update();
        }
    }
}
