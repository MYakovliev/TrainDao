package by.epam.train2.model.service;

import by.epam.train2.model.entity.PassengerTrain;

import java.util.List;

public interface TrainSortService {
    void sortTrainsByDestination();

    void sortTrainsById();

    void sortTrainsByDepartureTime();

    void sortTrainsByDestination(boolean reversed);

    void sortTrainsById(boolean reversed);

    void sortTrainsByDepartureTime(boolean reversed);

    void reverse();
}
