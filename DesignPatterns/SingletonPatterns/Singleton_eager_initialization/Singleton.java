package Singleton_eager_initialization;

public class Singleton {

    // the private reference to the one and only instance (eager initialization)
    private static final Singleton uniqueInstance = new Singleton();

    // an instance attribute
    private int data = 0;

    /**
     * The Singleton Constructor
     * Note that it is private!
     * No client can instantiate a Singleton object!
     */
    private Singleton() {}

    // Return the one and only instance
    public static Singleton getInstance() {
        return uniqueInstance;
    }

    // Getter and Setter for the data attribute
    public void setData(int myData) {
        data = myData;
    }

    public int getData() {
        return data;
    }
}
