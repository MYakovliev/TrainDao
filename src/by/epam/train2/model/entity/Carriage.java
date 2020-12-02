package by.epam.train2.model.entity;

import by.epam.train2.model.service.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Carriage {
    private int id;
    private int num;
    private int seatsNumber;
    private List<Seat> seats;
    private CarriageTypes type;

    public Carriage(int num, CarriageTypes type) {
        id = IdGenerator.generateCarriageId();
        setNum(num);
        setType(type);
        refreshSeats();
    }

    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    public void refreshSeats() {
        seats = new ArrayList<>();
        for (int i = 0; i < seatsNumber; i++) {
            seats.add(new Seat(i + 1));
        }
    }

    public CarriageTypes getType() {
        return type;
    }

    public void setType(CarriageTypes type) {
        this.type = type;
        switch (type) {
            case ECONOM:
                seatsNumber = 54;
                break;
            case BUSINESS:
                seatsNumber = 36;
                break;
            default:
                throw new IllegalArgumentException("unknown Carriage type");

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carriage carriage = (Carriage) o;
        return getId() == carriage.getId() &&
                getNum() == carriage.getNum() &&
                seatsNumber == carriage.seatsNumber &&
                getSeats().equals(carriage.getSeats()) &&
                getType() == carriage.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNum(), seatsNumber, getSeats(), getType());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carriage{");
        sb.append("id=").append(id);
        sb.append(", num=").append(num);
        sb.append(", seatsNumber=").append(seatsNumber);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }

}
