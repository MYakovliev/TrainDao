package by.epam.train2.model.dao.storage;

import by.epam.train2.exception.DaoException;
import by.epam.train2.model.entity.PassengerTrain;

import java.util.ArrayList;
import java.util.List;

public class TrainWarehouse {
    private static TrainWarehouse instance = new TrainWarehouse();

    private List<PassengerTrain> trains = new ArrayList<>();

    private TrainWarehouse() {
    }

    public static TrainWarehouse getInstance() {
        return instance;
    }

    public void setTrains(List<PassengerTrain> trains) {
        this.trains = new ArrayList<>(trains);
    }

    public List<PassengerTrain> getTrains() {
        return new ArrayList<>(trains);
    }

    public void add(PassengerTrain train) throws DaoException {
        if (trains.contains(train)) {
            throw new DaoException(train + "is already in the list");
        }
        trains.add(train);
    }

    public void set(int index, PassengerTrain train) throws DaoException {
        if (trains.contains(train)) {
            throw new DaoException(train + "is already in the list");
        }
        trains.set(index, train);
    }

    public void remove(PassengerTrain train) throws DaoException {
        if (!trains.contains(train)) {
            throw new DaoException(train + "is already not in the list");
        }
        trains.remove(train);
    }

    public void replace(PassengerTrain train1, PassengerTrain train2) throws DaoException {
        if (!trains.contains(train1)) {
            throw new DaoException(train1 + " not in the list");
        }
        int index = trains.indexOf(train1);
        trains.set(index, train2);
    }

    public PassengerTrain getTrain(int index) throws DaoException {
        if (index < 0 || index >= size()) {
            throw new DaoException("incorrect index:" + index);
        }
        return trains.get(index);
    }

    public int size() {
        return trains.size();
    }
}
