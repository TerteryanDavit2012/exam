package service;

import model.Plane;


public class PlaneService {

    // Task 1
    public void printPlane(Plane plane) {
        System.out.println("Model: " + plane.getModel());
        System.out.println("Country: " + plane.getCountry());
        System.out.println("Year: " + plane.getYear());
        System.out.println("Hours: " + plane.getHours());
        System.out.println("Military: " + plane.isMilitary());
        System.out.println("Weight: " + plane.getWeigth() + " KG");
        System.out.println("Wingspan: " + plane.getWingspan());
        System.out.println("Top speed: " + plane.getTopSpeed() + " km/h");
        System.out.println("Seats: " + plane.getSeats());
        System.out.println("Cost: $" + plane.getCost());
    }

    //Task 2
    public void printMilitaryInfo(Plane plane) {
        if (plane.isMilitary()) {
            System.out.println("Cost: $" + plane.getCost());
            System.out.println("Top speed: " + plane.getTopSpeed() + " km/h");
        } else {
            System.out.println("Model: " + plane.getModel());
            System.out.println("Country: " + plane.getCountry());
        }
    }

    // Task 3
    public Plane newerPlane(Plane plane1, Plane plane2) {
        if (plane1.getYear() >= plane2.getYear()) {
            return plane1;
        } else {
            return plane2;
        }
    }

    // Task4
    public String biggerWingspan(Plane plane1, Plane plane2) {
        if (plane1.getWingspan() > plane2.getWingspan()) {
            return plane1.getModel();
        } else {
            return plane2.getModel();
        }
    }

    // Task 5
    public void smallestSeats(Plane plane1, Plane plane2, Plane plane3) {

        Plane smallest = plane1;

        if (plane2.getSeats() < smallest.getSeats()) {
            smallest = plane2;
        }

        if (plane3.getSeats() < smallest.getSeats()) {
            smallest = plane3;
        }

        System.out.println("Country: " + smallest.getCountry());
    }

    //Task 6
    public void printNotMilitary(Plane[] planes) {
        for (Plane plane : planes) {
            if (!plane.isMilitary()) {
                System.out.println(plane);
            }
        }
    }

    // Task 7
    public void printMilitaryMoreThan100Hours(Plane[] planes) {
        for (Plane plane : planes) {
            if (plane.isMilitary() && plane.getHours() > 100) {
                System.out.println(plane);
            }
        }
    }

    // Task 8
    public Plane minimalWeight(Plane[] planes) {

        Plane smallest = planes[0];

        for (Plane plane : planes) {
            if (plane.getWeigth() <= smallest.getWeigth()) {
                smallest = plane;
            }
        }

        return smallest;
    }

    // Task 9
    public Plane minimalMilitaryCost(Plane[] planes) {

        Plane cheapest = null;

        for (Plane plane : planes) {
            if (plane.isMilitary()) {

                if (cheapest == null || plane.getCost() < cheapest.getCost()) {
                    cheapest = plane;
                }
            }
        }

        return cheapest;
    }

    // Task 10
    public void sortByYear(Plane[] planes) {

        for (int i = 0; i < planes.length - 1; i++) {
            for (int j = 0; j < planes.length - 1 - i; j++) {
                if (planes[j].getYear() > planes[j + 1].getYear()) {
                    Plane mitq = planes[j];
                    planes[j] = planes[j + 1];
                    planes[j + 1] = mitq;
                }
            }
        }

        for (int i = 0; i < planes.length; i++) {
            System.out.println(planes[i]);
        }
    }
}
