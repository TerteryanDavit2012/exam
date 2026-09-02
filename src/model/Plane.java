package model;

public class Plane {

    private String model;
    private String country;
    private int year;
    private int hours;
    private boolean military;
    private double weigth;
    private double wingspan;
    private double topSpeed;
    private int seats;
    private double cost;

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1903 && year <= 2021) {
            this.year = year;
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours <= 10000) {
            this.hours = hours;
        }
    }

    public boolean isMilitary() {
        return military;
    }

    public void setMilitary(boolean military) {
        this.military = military;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        if (weigth >= 10000 && weigth <= 160000) {
            this.weigth = weigth;
        }
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        if (wingspan >= 10 && wingspan <= 45) {
            this.wingspan = wingspan;
        }
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        if (topSpeed >= 0) {
            this.topSpeed = topSpeed;
        }
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats >= 0) {
            this.seats = seats;
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost >= 0) {
            this.cost = cost;
        }
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", hours=" + hours +
                ", military=" + military +
                ", weigth=" + weigth +
                ", wingspan=" + wingspan +
                ", topSpeed=" + topSpeed +
                ", seats=" + seats +
                ", cost=" + cost +
                '}';
    }
}

