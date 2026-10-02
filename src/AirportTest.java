
import model.Plane;
import service.PlaneService;
import service.FileService;

public class AirportTest {

    public static void main(String[] args) throws Exception {

        Plane Plane = new Plane();
        Plane.setModel("Boeing 747");
        Plane.setCountry("USA");
        Plane.setYear(1969);
        Plane.setHours(5000);
        Plane.setMilitary(false);
        Plane.setWeigth(183500);
        Plane.setWingspan(68.4);
        Plane.setTopSpeed(988);
        Plane.setSeats(416);
        Plane.setCost(418.4);

        Plane Plane1 = new Plane();
        Plane1.setModel("F-22 Raptor");
        Plane1.setCountry("USA");
        Plane1.setYear(2005);
        Plane1.setHours(1200);
        Plane1.setMilitary(true);
        Plane1.setWeigth(19700);
        Plane1.setWingspan(13.56);
        Plane1.setTopSpeed(2414);
        Plane1.setSeats(1);
        Plane1.setCost(150.0);

        Plane Plane2 = new Plane();
        Plane2.setModel("Airbus A380");
        Plane2.setCountry("France");
        Plane2.setYear(2005);
        Plane2.setHours(3000);
        Plane2.setMilitary(false);
        Plane2.setWeigth(277000);
        Plane2.setWingspan(79.75);
        Plane2.setTopSpeed(1020);
        Plane2.setSeats(555);
        Plane2.setCost(445.8);

        Plane Plane3 = new Plane();
        Plane3.setModel("F-35 Lightning II");
        Plane3.setCountry("USA");
        Plane3.setYear(2015);
        Plane3.setHours(250);
        Plane3.setMilitary(true);
        Plane3.setWeigth(13200);
        Plane3.setWingspan(10.7);
        Plane3.setTopSpeed(1930);
        Plane3.setSeats(1);
        Plane3.setCost(80.0);

        Plane[] planes = {Plane, Plane1, Plane2, Plane3};

        PlaneService service = new PlaneService();

        /*
        Scanner sc = new Scanner(System.in);

        boolean isActive = true;

        while (isActive) {

            System.out.println();
            System.out.println("----------------MENU----------------");
            System.out.println("1: choose an option:");
            System.out.println("2: task1");
            System.out.println("3: task2");
            System.out.println("4: task3");
            System.out.println("5: task4");
            System.out.println("6: task5");
            System.out.println("7: task6");
            System.out.println("8: task7");
            System.out.println("9: task8");
            System.out.println("10: task9");
            System.out.println("11: task10");
            System.out.println("12: Exit");
            System.out.println("___________________________________");

            System.out.print("Choose an option: ");

            int menuChoice = sc.nextInt();

            switch (menuChoice) {

                case 1:

                    System.out.println("1: " + Plane.getModel());
                    System.out.println("2: " + Plane1.getModel());
                    System.out.println("3: " + Plane2.getModel());
                    System.out.println("4: " + Plane3.getModel());

                    System.out.print("Choose plane: ");

                    int planeChoice = sc.nextInt();

                    switch (planeChoice) {

                        case 1:
                            Plane = Plane;
                            break;

                        case 2:
                            Plane = Plane1;
                            break;

                        case 3:
                            Plane = Plane2;
                            break;

                        case 4:
                            Plane = Plane3;
                            break;

                        default:
                            System.out.println("No such choice.");
                            break;
                    }

                    System.out.println(
                            "Current plane: " + Plane.getModel()
                    );

                    break;

                case 2:
                    service.printPlane(Plane);
                    break;

                case 3:
                    service.printMilitaryInfo(Plane);
                    break;

                case 4:

                    Plane newer =
                            service.newerPlane(Plane, Plane1);

                    FileService.writeFile(
                            "output.txt",
                            "Newer plane: "
                                    + newer.getModel()
                                    + "\n\n"
                    );

                    break;

                case 5:

                    String biggerWingspan =
                            service.biggerWingspan(Plane, Plane1);

                    FileService.writeFile(
                            "output.txt",
                            "Plane with bigger wingspan: "
                                    + biggerWingspan
                                    + "\n\n"
                    );

                    break;

                case 6:
                    service.smallestSeats(Plane, Plane1, Plane2);
                    break;

                case 7:
                    service.printNotMilitary(planes);
                    break;

                case 8:
                    service.printMilitaryMoreThan100Hours(planes);
                    break;

                case 9:

                    Plane lightest =
                            service.minimalWeight(planes);

                    FileService.writeFile(
                            "output.txt",
                            "Plane with minimal weight: "
                                    + lightest.getModel()
                                    + "\n\n"
                    );

                    break;

                case 10:

                    Plane cheapestMilitary =
                            service.minimalMilitaryCost(planes);

                    if (cheapestMilitary != null) {

                        FileService.writeFile(
                                "output.txt",
                                "Cheapest military plane: "
                                        + cheapestMilitary.getModel()
                                        + "\n\n"
                        );
                    }

                    break;

                case 11:
                    service.sortByYear(planes);
                    break;

                case 12:

                    isActive = false;

                    System.out.println(
                            "Program closed."
                    );

                    break;

                default:
                    System.out.println(
                            "Invalid Input, Please Try Again."
                    );
            }
        }

        sc.close();
        */


        // Tasks run automatically

        // Task 1
        service.printPlane(Plane);

        // Task 2
        service.printMilitaryInfo(Plane);

        // Task 3
        Plane newer = service.newerPlane(Plane, Plane1);

        FileService.writeFile(
                "output.txt",
                "Newer plane: " + newer.getModel() + "\n\n"
        );

        // Task 4
        String biggerWingspan =
                service.biggerWingspan(Plane, Plane1);

        FileService.writeFile(
                "output.txt",
                "Plane with bigger wingspan: "
                        + biggerWingspan + "\n\n"
        );

        // Task 5
        service.smallestSeats(Plane, Plane1, Plane2);

        // Task 6
        service.printNotMilitary(planes);

        // Task 7
        service.printMilitaryMoreThan100Hours(planes);

        // Task 8
        Plane lightest = service.minimalWeight(planes);

        FileService.writeFile(
                "output.txt",
                "Plane with minimal weight: "
                        + lightest.getModel() + "\n\n"
        );

        // Task 9
        Plane cheapestMilitary =
                service.minimalMilitaryCost(planes);

        if (cheapestMilitary != null) {
            FileService.writeFile(
                    "output.txt",
                    "Cheapest military plane: "
                            + cheapestMilitary.getModel() + "\n\n"
            );
        }

        // Task 10
        service.sortByYear(planes);
    }
}

