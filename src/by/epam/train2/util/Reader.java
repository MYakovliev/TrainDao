package by.epam.train2.util;

import by.epam.train2.model.entity.PassengerTrain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    private static Logger logger = LogManager.getLogger();

    public List<PassengerTrain> makeTrainList(File file) {
        List<PassengerTrain> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String trainFields = scanner.nextLine();
                String[] trainFieldsArray  = trainFields.split(" ");
                String destination = trainFieldsArray[0];
                int departureHour = Integer.parseInt(trainFieldsArray[1]);
                int departureMinute = Integer.parseInt(trainFieldsArray[2]);
                int staffAmount = Integer.parseInt(trainFieldsArray[3]);
                int carriageCount = Integer.parseInt(trainFieldsArray[4]);
                PassengerTrain train = new PassengerTrain(destination, departureHour, departureMinute, staffAmount, carriageCount);
                result.add(train);
            }
        } catch (FileNotFoundException e) {
            logger.error(e);
        }
        return result;
    }
}
