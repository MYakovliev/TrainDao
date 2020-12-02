package by.epam.train2.model.service;

public class IdGenerator {
    private static int trainId = 100000;
    private static int carriageId = 200000;
    private static int seatId = 300000;

    public static int generateTrainId(){
        return ++trainId;
    }

    public static int generateCarriageId(){
        return ++carriageId;
    }

    public static int generateSeatId(){
        return ++seatId;
    }
}
