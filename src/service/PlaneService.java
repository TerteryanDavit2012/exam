package service;

import model.Plane;

import java.io.IOException;

public class PlaneService {

    // Task 1
    public void printPlane(Plane plane) throws IOException {
        String content = "Model: " + plane.getModel() + "\n" +
                "Country: " + plane.getCountry() + "\n" +
                "Year: " + plane.getYear() + "\n" +
                "Hours: " + plane.getHours() + "\n" +
                "Military: " + plane.isMilitary() + "\n" +
                "Weight: " + plane.getWeigth() + " KG\n" +
                "Wingspan: " + plane.getWingspan() + "\n" +
                "Top speed: " + plane.getTopSpeed() + " km/h\n" +
                "Seats: " + plane.getSeats() + "\n" +
                "Cost: $" + plane.getCost();

        System.out.println(content);
        FileService.writeFile("printPlane.txt", content + "\n\n");
    }

    // Task 2
    public void printMilitaryInfo(Plane plane) throws IOException {
        String content;

        if (plane.isMilitary()) {
            content = "Cost: $" + plane.getCost() + "\n" +
                    "Top speed: " + plane.getTopSpeed() + " km/h";
        } else {
            content = "Model: " + plane.getModel() + "\n" +
                    "Country: " + plane.getCountry();
        }

        System.out.println(content);
        FileService.writeFile("printMilitaryInfo.txt", content + "\n");
    }

    // Task 3
    public Plane newerPlane(Plane plane1, Plane plane2) throws IOException {
        Plane newer;

        if (plane1.getYear() >= plane2.getYear()) {
            newer = plane1;
        } else {
            newer = plane2;
        }

        System.out.println("Newer plane: " + newer.getModel());
        FileService.writeFile("newerPlane.txt", newer.toString() + "\n");

        return newer;
    }

    // Task 4
    public String biggerWingspan(Plane plane1, Plane plane2) throws IOException {
        String result;

        if (plane1.getWingspan() > plane2.getWingspan()) {
            result = plane1.getModel();
        } else {
            result = plane2.getModel();
        }

        System.out.println("Bigger wingspan: " + result);
        FileService.writeFile("biggerWingspan.txt", result + "\n");

        return result;
    }

    // Task 5
    public void smallestSeats(Plane plane1, Plane plane2, Plane plane3)
            throws IOException {

        Plane smallest = plane1;

        if (plane2.getSeats() < smallest.getSeats()) {
            smallest = plane2;
        }

        if (plane3.getSeats() < smallest.getSeats()) {
            smallest = plane3;
        }

        System.out.println("Country: " + smallest.getCountry());
        FileService.writeFile("smallestSeats.txt",
                "Country: " + smallest.getCountry() + "\n");
    }

    // Task 6
    public void printNotMilitary(Plane[] planes) throws IOException {

        for (Plane plane : planes) {
            if (!plane.isMilitary()) {
                System.out.println(plane);
                FileService.writeFile("printNotMilitary.txt",
                        plane.toString() + "\n");
            }
        }
    }

    // Task 7
    public void printMilitaryMoreThan100Hours(Plane[] planes)
            throws IOException {

        for (Plane plane : planes) {
            if (plane.isMilitary() && plane.getHours() > 100) {
                System.out.println(plane);
                FileService.writeFile("printMilitaryMoreThan100Hours.txt",
                        plane.toString() + "\n");
            }
        }
    }

    // Task 8
    public Plane minimalWeight(Plane[] planes) throws IOException {

        if (planes.length == 0) {
            System.out.println("No planes available");
            return null;
        }

        Plane smallest = planes[0];

        for (Plane plane : planes) {
            if (plane.getWeigth() < smallest.getWeigth()) {
                smallest = plane;
            }
        }

        System.out.println("Lightest plane: " + smallest.getModel());
        FileService.writeFile("minimalWeight.txt", smallest.toString() + "\n");

        return smallest;
    }

    // Task 9
    public Plane minimalMilitaryCost(Plane[] planes) throws IOException {

        Plane cheapest = null;

        for (Plane plane : planes) {
            if (plane.isMilitary()) {
                if (cheapest == null ||
                        plane.getCost() < cheapest.getCost()) {
                    cheapest = plane;
                }
            }
        }

        if (cheapest != null) {
            System.out.println("Cheapest military plane: " + cheapest.getModel());
            FileService.writeFile("minimalMilitaryCost.txt",
                    cheapest.toString() + "\n");
        } else {
            System.out.println("No military planes found");
            FileService.writeFile("minimalMilitaryCost.txt",
                    "No military planes found\n");
        }

        return cheapest;
    }

    // Task 10
    public void sortByYear(Plane[] planes) throws IOException {

        for (int i = 0; i < planes.length - 1; i++) {
            for (int j = 0; j < planes.length - 1 - i; j++) {

                if (planes[j].getYear() > planes[j + 1].getYear()) {

                    Plane temp = planes[j];
                    planes[j] = planes[j + 1];
                    planes[j + 1] = temp;
                }
            }
        }

        for (Plane plane : planes) {
            String content = plane.getModel() + " - " + plane.getYear();

            System.out.println(content);
            FileService.writeFile("sortByYear.txt", content + "\n");
        }
    }
}