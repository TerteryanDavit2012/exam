package service;

import model.Plane;

public class PlaneService {

    // Task 1
    public void printPlane(Plane plane) throws Exception {
        FileService.writeFile("output.txt",
                "Model: " + plane.getModel() + "\n" +
                        "Country: " + plane.getCountry() + "\n" +
                        "Year: " + plane.getYear() + "\n" +
                        "Hours: " + plane.getHours() + "\n" +
                        "Military: " + plane.isMilitary() + "\n" +
                        "Weight: " + plane.getWeigth() + " KG\n" +
                        "Wingspan: " + plane.getWingspan() + "\n" +
                        "Top speed: " + plane.getTopSpeed() + " km/h\n" +
                        "Seats: " + plane.getSeats() + "\n" +
                        "Cost: $" + plane.getCost() + "\n\n");
    }

    // Task 2
    public void printMilitaryInfo(Plane plane) throws Exception {
        if (plane.isMilitary()) {

            FileService.writeFile("output.txt",
                    "Cost: $" + plane.getCost() + "\n" +
                            "Top speed: " + plane.getTopSpeed() + " km/h\n\n");

        } else {

            FileService.writeFile("output.txt",
                    "Model: " + plane.getModel() + "\n" +
                            "Country: " + plane.getCountry() + "\n\n");
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

    // Task 4
    public String biggerWingspan(Plane plane1, Plane plane2) {
        if (plane1.getWingspan() > plane2.getWingspan()) {
            return plane1.getModel();
        } else {
            return plane2.getModel();
        }
    }

    // Task 5
    public void smallestSeats(Plane plane1, Plane plane2, Plane plane3)
            throws Exception {

        Plane smallest = plane1;

        if (plane2.getSeats() < smallest.getSeats()) {
            smallest = plane2;
        }

        if (plane3.getSeats() < smallest.getSeats()) {
            smallest = plane3;
        }

        FileService.writeFile("output.txt",
                "Country: " + smallest.getCountry() + "\n\n");
    }

    // Task 6
    public void printNotMilitary(Plane[] planes) throws Exception {

        FileService.writeFile("output.txt",
                "Not military planes:\n");

        for (Plane plane : planes) {

            if (!plane.isMilitary()) {
                FileService.writeFile("output.txt",
                        plane + "\n");
            }
        }

        FileService.writeFile("output.txt", "\n");
    }

    // Task 7
    public void printMilitaryMoreThan100Hours(Plane[] planes)
            throws Exception {

        FileService.writeFile("output.txt",
                "Military planes with more than 100 hours:\n");

        for (Plane plane : planes) {

            if (plane.isMilitary() && plane.getHours() > 100) {
                FileService.writeFile("output.txt",
                        plane + "\n");
            }
        }

        FileService.writeFile("output.txt", "\n");
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

                if (cheapest == null ||
                        plane.getCost() < cheapest.getCost()) {

                    cheapest = plane;
                }
            }
        }

        return cheapest;
    }

    // Task 10
    public void sortByYear(Plane[] planes) throws Exception {

        for (int i = 0; i < planes.length - 1; i++) {

            for (int j = 0; j < planes.length - 1 - i; j++) {

                if (planes[j].getYear() > planes[j + 1].getYear()) {

                    Plane temp = planes[j];
                    planes[j] = planes[j + 1];
                    planes[j + 1] = temp;
                }
            }
        }

        FileService.writeFile("output.txt",
                "Planes sorted by year:\n");

        for (Plane plane : planes) {

            FileService.writeFile("output.txt",
                    plane.getModel() +
                            " - " +
                            plane.getYear() +
                            "\n");
        }

        FileService.writeFile("output.txt", "\n");
    }
}



