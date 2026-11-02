public interface SensorObserver<T>{
    void onReading(Sensor<T> source, T value);
}