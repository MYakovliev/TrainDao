package by.epam.train2.model.service.impl;

import by.epam.train2.exception.DaoException;
import by.epam.train2.model.dao.impl.TrainDaoImpl;
import by.epam.train2.model.entity.PassengerTrain;
import by.epam.train2.model.service.TrainSortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class TrainSortServiceImpl implements TrainSortService {
    private static final Logger logger = LogManager.getLogger();
    private static TrainDaoImpl trainDao = new TrainDaoImpl();

    @Override
    public void sortTrainsByDestination() {
        List<PassengerTrain> trains = trainDao.findAll();
        trains.sort(Comparator.comparing(PassengerTrain::getDestination));
        try {
            for (int i = 0; i < trains.size(); i++) {
                trainDao.set(i, trains.get(i));
            }
        } catch (DaoException e) {
            logger.error(e);
        }
    }

    @Override
    public void sortTrainsById() {
        List<PassengerTrain> trains = trainDao.findAll();
        trains.sort(Comparator.comparing(PassengerTrain::getId));
        try {
            for (int i = 0; i < trains.size(); i++) {
                trainDao.set(i, trains.get(i));
            }
        } catch (DaoException e) {
            logger.error(e);
        }
    }

    @Override
    public void sortTrainsByDepartureTime() {
        List<PassengerTrain> trains = trainDao.findAll();
        trains.sort(Comparator.comparing(PassengerTrain::getDepartureHour).thenComparing(PassengerTrain::getDepartureMinute));
        try {
            for (int i = 0; i < trains.size(); i++) {
                trainDao.set(i, trains.get(i));
            }
        } catch (DaoException e) {
            logger.error(e);
        }
    }

    @Override
    public void sortTrainsByDestination(boolean reversed) {
        sortTrainsByDestination();
        if (reversed) {
            reverse();
        }
    }

    @Override
    public void sortTrainsById(boolean reversed) {
        sortTrainsById();
        if (reversed) {
            reverse();
        }
    }

    @Override
    public void sortTrainsByDepartureTime(boolean reversed) {
        sortTrainsByDepartureTime();
        if (reversed) {
            reverse();
        }
    }

    @Override
    public void reverse() {
        try {
            for (int i = 0; i < trainDao.size() / 2; i++) {
                PassengerTrain train = trainDao.findAll().get(i);
                trainDao.set(i, trainDao.findAll().get(trainDao.size() - i - 1));
                trainDao.set(trainDao.size() - i - 1, train);
            }
        } catch (DaoException e) {
            logger.error(e);
        }
    }

}
