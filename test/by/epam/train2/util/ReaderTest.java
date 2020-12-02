package by.epam.train2.util;

import by.epam.train2.model.entity.PassengerTrain;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ReaderTest {

    @Test
    public void testMakeTrainList() {
        PassengerTrain train1 = new PassengerTrain("Moscow", 12, 10, 14, 20);
        PassengerTrain train2 = new PassengerTrain("Minsk", 23, 15, 16, 20);
        PassengerTrain train3 = new PassengerTrain("Poltava", 7, 46, 17, 20);
        PassengerTrain train4 = new PassengerTrain("Kapushkino", 2, 55, 7, 25);
        PassengerTrain train5 = new PassengerTrain("Lipetevo", 3, 56, 9, 14);
        List<PassengerTrain> expected = new ArrayList<>();
        expected.add(train1);
        expected.add(train2);
        expected.add(train3);
        expected.add(train4);
        expected.add(train5);
        List<PassengerTrain> actual = new Reader().makeTrainList(new File(".\\data\\data.txt"));
        assertEquals(actual.get(0), expected.get(0));
    }
}