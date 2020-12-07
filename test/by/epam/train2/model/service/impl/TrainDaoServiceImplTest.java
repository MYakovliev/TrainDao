package by.epam.train2.model.service.impl;

import by.epam.train2.exception.DaoException;
import by.epam.train2.model.dao.storage.TrainWarehouse;
import by.epam.train2.model.entity.PassengerTrain;
import by.epam.train2.model.service.TrainDaoService;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TrainDaoServiceImplTest {
    PassengerTrain train1 = new PassengerTrain("Moscow", 12, 10, 14, 20);
    PassengerTrain train2 = new PassengerTrain("Minsk", 23, 15, 16, 20);
    PassengerTrain train3 = new PassengerTrain("Poltava", 7, 46, 17, 20);
    PassengerTrain train4 = new PassengerTrain("Kapushkino", 2, 55, 7, 25);
    PassengerTrain train5 = new PassengerTrain("Lipetevo", 3, 56, 9, 14);

    TrainDaoService trainDaoService = new TrainDaoServiceImpl();
    TrainWarehouse instance = TrainWarehouse.getInstance();

    @Test
    public void testAdd() {
        List<PassengerTrain> expected = new ArrayList<>();
        expected.add(train1);
        instance.setTrains(expected);
        expected.add(train3);
        try {
            trainDaoService.add(train3);
        } catch (DaoException e) {
            fail(e.getMessage());
        }
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testSet() {
        List<PassengerTrain> expected = new ArrayList<>();
        expected.add(train1);
        expected.add(train3);
        instance.setTrains(expected);
        try {
            trainDaoService.set(0, train4);
            expected.set(0, train4);
        } catch (DaoException e) {
            fail(e.getMessage());
        }
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testRemove() {
        List<PassengerTrain> expected = new ArrayList<>();
        expected.add(train1);
        expected.add(train3);
        instance.setTrains(expected);
        try {
            trainDaoService.remove(train3);
            expected.remove(train3);
        } catch (DaoException e) {
            fail(e.getMessage());
        }
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testUpdateTrainDestinationById() {
        List<PassengerTrain> expected = new ArrayList<>();
        expected.add(train3);
        expected.add(train1);
        instance.setTrains(expected);
        train1.setDestination("dest");
        try {
            trainDaoService.updateTrainDestinationById(train1.getId(), "dest");

        } catch (DaoException e) {
            fail(e.getMessage());
        }
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testUpdateTrainDepartureTimeById() {
        List<PassengerTrain> expected = new ArrayList<>();
        expected.add(train3);
        expected.add(train1);
        instance.setTrains(expected);
        train1.setDepartureTime(11, 00);
        try {
            trainDaoService.updateTrainDepartureTimeById(train1.getId(), new int[]{11, 00});

        } catch (DaoException e) {
            fail(e.getMessage());
        }
        List<PassengerTrain> actual = instance.getTrains();
        assertEquals(actual, expected);
    }

    @Test
    public void testFindById() {
        List<PassengerTrain> trains = new ArrayList<>();
        trains.add(train1);
        instance.setTrains(trains);
        PassengerTrain actual = trainDaoService.findById(train1.getId()).get();
        PassengerTrain expected = train1;
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAll() {
        List<PassengerTrain> expected = new ArrayList<>();
        expected.add(train1);
        expected.add(train2);
        expected.add(train5);
        instance.setTrains(expected);
        List<PassengerTrain> actual = trainDaoService.findAll();
        assertEquals(actual, expected);
    }

    @Test
    public void testSize() {
        int expected = 3;
        List<PassengerTrain> trains = new ArrayList<>();
        trains.add(train1);
        trains.add(train2);
        trains.add(train5);
        instance.setTrains(trains);
        int actual = trainDaoService.size();
        assertEquals(actual, expected);
    }
}