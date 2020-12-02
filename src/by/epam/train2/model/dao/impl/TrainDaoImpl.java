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
    private static final TrainWarehouse INSTANCE = TrainWarehouse.getInstance();

    @Override
    public void add(PassengerTrain train) throws DaoException {
        INSTANCE.add(train);
    }

    @Override
    public void set(int index, PassengerTrain train) throws DaoException {
        if (index < 0 || index > INSTANCE.size()) {
            throw new DaoException("invalid index to set element:" + index);
        }

    }

    @Override
    public void remove(PassengerTrain train) throws DaoException {
        INSTANCE.remove(train);
    }

    @Override
    public void updateTrainDestinationById(int id, String destination) throws DaoException {
        Optional<PassengerTrain> oldTrain = findById(id);
        if (!oldTrain.isPresent()) {
            throw new DaoException("There's no train with id:" + id);
        }
        PassengerTrain newTrain = oldTrain.get().clone();
        newTrain.setDestination(destination);
        INSTANCE.replace(oldTrain.get(), newTrain);
    }

    @Override
    public void updateTrainDepartureTimeById(int id, int[] time) throws DaoException {
        Optional<PassengerTrain> oldTrain = findById(id);
        if (!oldTrain.isPresent()) {
            throw new DaoException("There's no train with id:" + id);
        }
        PassengerTrain newTrain = oldTrain.get().clone();
        newTrain.setDepartureTime(time[0], time[1]);
        INSTANCE.replace(oldTrain.get(), newTrain);
    }

    @Override
    public Optional<PassengerTrain> findById(int id) {
        List<PassengerTrain> trains = finalAll();
        Optional<PassengerTrain> result = Optional.empty();
        for (PassengerTrain train : trains) {
            if (train.getId() == id) {
                result = Optional.of(train);
            }
        }
        return result;
    }

    @Override
    public List<PassengerTrain> finalAll() {
        return INSTANCE.getTrains();
    }

    @Override
    public int size(){
        return INSTANCE.size();
    }
}
