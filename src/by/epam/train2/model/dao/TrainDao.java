package by.epam.train2.model.dao;

import by.epam.train2.exception.DaoException;
import by.epam.train2.model.entity.PassengerTrain;

import java.util.List;
import java.util.Optional;

public interface TrainDao {
    void add(PassengerTrain train) throws DaoException;

    void set(int index, PassengerTrain train) throws DaoException;

    void remove(PassengerTrain train) throws DaoException;

    void updateTrainDestinationById(int id, String destination) throws DaoException;

    void updateTrainDepartureTimeById(int id, int[] time) throws DaoException;

    Optional<PassengerTrain> findById(int id);

    List<PassengerTrain> finalAll();

    int size();

}
