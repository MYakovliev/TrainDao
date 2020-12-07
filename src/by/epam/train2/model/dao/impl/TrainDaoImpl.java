package by.epam.train2.model.dao.impl;

import by.epam.train2.exception.DaoException;
import by.epam.train2.model.dao.TrainDao;
import by.epam.train2.model.dao.storage.TrainWarehouse;
import by.epam.train2.model.entity.PassengerTrain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class TrainDaoImpl implements TrainDao {
    private static final Logger logger = LogManager.getLogger();
    private static TrainWarehouse instance = TrainWarehouse.getInstance();

    @Override
    public void add(PassengerTrain train) throws DaoException {
        instance.add(train);
    }

    @Override
    public void set(int index, PassengerTrain train) throws DaoException {
        if (index < 0 || index > instance.size()) {
            throw new DaoException("invalid index to set element:" + index);
        }
        instance.set(index, train);
    }

    @Override
    public void remove(PassengerTrain train) throws DaoException {
        instance.remove(train);
    }

    @Override
    public void replace(PassengerTrain train1, PassengerTrain train2) throws DaoException {
        instance.replace(train1, train2);
    }

    @Override
    public void clear() {
        instance.clear();
    }

    @Override
    public void updateTrainDestinationById(int id, String destination) throws DaoException {
        Optional<PassengerTrain> oldTrain = findById(id);
        if (!oldTrain.isPresent()) {
            throw new DaoException("There's no train with id:" + id);
        }
        PassengerTrain newTrain = oldTrain.get().clone();
        newTrain.setDestination(destination);
        instance.replace(oldTrain.get(), newTrain);
    }

    @Override
    public void updateTrainDepartureTimeById(int id, int[] time) throws DaoException {
        Optional<PassengerTrain> oldTrain = findById(id);
        if (!oldTrain.isPresent()) {
            throw new DaoException("There's no train with id:" + id);
        }
        PassengerTrain newTrain = oldTrain.get().clone();
        newTrain.setDepartureTime(time[0], time[1]);
        instance.replace(oldTrain.get(), newTrain);
    }

    @Override
    public Optional<PassengerTrain> findById(int id) {
        List<PassengerTrain> trains = findAll();
        Optional<PassengerTrain> result = Optional.empty();
        for (PassengerTrain train : trains) {
            if (train.getId() == id) {
                result = Optional.of(train);
            }
        }
        return result;
    }

    @Override
    public List<PassengerTrain> findAll() {
        return instance.getTrains();
    }

    @Override
    public int size() {
        return instance.size();
    }
}
