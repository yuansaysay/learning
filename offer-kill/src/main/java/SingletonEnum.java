import java.io.*;

public enum SingletonEnum {
    INSTANCE;

    private String status;

    SingletonEnum() {
        this.status = "Initialized";
    }

    public String getStatus() {
        return status;
    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
            // 序列化SingletonEnum.INSTANCE
            oos.writeObject(SingletonEnum.INSTANCE);
            System.out.println("SingletonEnum.INSTANCE has been serialized.");
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
            // 反序列化SingletonEnum.INSTANCE
            SingletonEnum instance = (SingletonEnum) ois.readObject();
            System.out.println("Deserialized SingletonEnum status: " + instance.getStatus());
            System.out.println("instance isTrue: " + (instance == SingletonEnum.INSTANCE ? true : false));

        }


    }


}