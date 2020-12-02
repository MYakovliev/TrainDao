package by.epam.train2.model.entity;

import by.epam.train2.model.service.IdGenerator;

import java.util.Objects;

public class Seat {
    private int id;
    private int num;
    private boolean reserved;

    public Seat(int num) {
        id = IdGenerator.generateSeatId();
        setNum(num);
        setReserved(false);
    }

    public Seat(int num, boolean reserved){
        id = IdGenerator.generateSeatId();
        setReserved(reserved);
        setNum(num);
    }

    public int getId() {
        return id;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        if (num <= 0){
            throw new IllegalArgumentException("invalid data");
        }

        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return getId() == seat.getId() &&
                getNum() == seat.getNum() &&
                isReserved() == seat.isReserved();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNum(), isReserved());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Seat{");
        sb.append("id=").append(id);
        sb.append(", num=").append(num);
        sb.append(", reserved=").append(reserved);
        sb.append('}');
        return sb.toString();
    }
}
