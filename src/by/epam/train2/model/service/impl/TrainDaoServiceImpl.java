package by.epam.train2.model.service.impl;

import by.epam.train2.exception.DaoException;
import by.epam.train2.model.dao.impl.TrainDaoImpl;
import by.epam.train2.model.entity.PassengerTrain;
import by.epam.train2.model.service.TrainDaoService;

import java.util.List;
import java.util.Optional;

public class TrainDaoServiceImpl implements TrainDaoService {
    private static TrainDaoImpl trainDao = new TrainDaoImpl();

    @Override
    public void add(PassengerTrain train) throws DaoException {
        trainDao.add(train);
    }

    @Override
    public void set(int index, PassengerTrain train) throws DaoException {
        trainDao.set(index, train);
    }

    @Override
    public void remove(PassengerTrain train) throws DaoException {
        trainDao.remove(train);
    }

    @Override
    public void replace(PassengerTrain train1, PassengerTrain train2) throws DaoException {
        trainDao.replace(train1, train2);
    }

    @Override
    public void updateTrainDestinationById(int id, String destination) throws DaoException {
        trainDao.updateTrainDestinationById(id, destination);
    }

    @Override
    public void updateTrainDepartureTimeById(int id, int[] time) throws DaoException {
        trainDao.updateTrainDepartureTimeById(id, time);
    }

    @Override
    public Optional<PassengerTrain> findById(int id) {
        return trainDao.findById(id);
    }

    @Override
    public List<PassengerTrain> findAll() {
        return trainDao.findAll();
    }

    @Override
    public int size() {
        return trainDao.size();
    }
}
