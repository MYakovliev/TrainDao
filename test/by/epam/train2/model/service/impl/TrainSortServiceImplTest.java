package by.epam.train2.model.service.impl;

import by.epam.train2.model.dao.storage.TrainWarehouse;
import by.epam.train2.model.entity.PassengerTrain;
import by.epam.train2.model.service.TrainSortService;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class TrainSortServiceImplTest {
    PassengerTrain train1 = new PassengerTrain("Moscow", 12, 10, 14, 20);
    PassengerTrain train2 = new PassengerTrain("Minsk", 23, 15, 16, 20);
    PassengerTrain train3 = new PassengerTrain("Poltava", 7, 46, 17, 20);
    PassengerTrain train4 = new PassengerTrain("Kapushkino", 2, 55, 7, 25);
    PassengerTrain train5 = new PassengerTrain("Lipetevo", 3, 56, 9, 14);
    List<PassengerTrain> trains = new ArrayList<>(Arrays.asList(train1, train2, train3, train4, train5));
    TrainSortService trainSortService = new TrainSortServiceImpl();
    TrainWarehouse instance = TrainWarehouse.getInstance();

    @Test
    public void testSortTrainsByDestination() {
        instance.setTrains(trains);
        List<PassengerTrain> expected = new ArrayList<>(Arrays.asList(train4, train5, train2, train1, train3));
        trainSortService.sortTrainsByDestination();
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortTrainsById() {
        instance.setTrains(trains);
        List<PassengerTrain> expected = new ArrayList<>(Arrays.asList(train1, train2, train3, train4, train5));
        trainSortService.sortTrainsById();
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortTrainsByDepartureTime() {
        instance.setTrains(trains);
        List<PassengerTrain> expected = new ArrayList<>(Arrays.asList(train4, train5, train3, train1, train2));
        trainSortService.sortTrainsByDepartureTime();
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testTestSortTrainsByDestination() {
        instance.setTrains(trains);
        List<PassengerTrain> expected = new ArrayList<>(Arrays.asList(train3, train1, train2, train5, train4));
        trainSortService.sortTrainsByDestination(true);
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testTestSortTrainsById() {
        instance.setTrains(trains);
        List<PassengerTrain> expected = new ArrayList<>(Arrays.asList(train5, train4, train3, train2, train1));
        trainSortService.sortTrainsById(true);
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testTestSortTrainsByDepartureTime() {
        instance.setTrains(trains);
        List<PassengerTrain> expected = new ArrayList<>(Arrays.asList(train2, train1, train3, train5, train4));
        trainSortService.sortTrainsByDepartureTime(true);
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testReverse() {
        instance.setTrains(trains);
        List<PassengerTrain> expected = new ArrayList<>(Arrays.asList(train5, train4, train3, train2, train1));
        trainSortService.reverse();
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }
}