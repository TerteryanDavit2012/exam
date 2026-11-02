import model.Plane;
import service.FileService;
import service.PlaneService;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class AirportTest {
    public static final String URL = "plane.txt";
    public static void main(String[] args) {
        ArrayList<Plane> planes;
        try {
            planes = convert(FileService.readFile(URL));
        } catch (NoSuchFileException e) {
            System.out.println("File not found: " + URL + " (run the program from the project folder)");
            return;
        } catch (IOException e) {
            System.out.println("Could not read " + URL + ": " + e.getMessage());
            return;
        }
        if (planes.isEmpty()) {
            System.out.println("No valid planes found in " + URL);
            return;
        }
        PlaneService service = new PlaneService();
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter task number (1-10, 0 to exit): ");
                int num;
                try {
                    num = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a whole number.");
                    input.nextLine();
                    continue;
                } catch (NoSuchElementException e) {
                    break;
                }
                if (num == 0) {
                    System.out.println("Program closed.");
                    break;
                }
                if (num >= 1 && num <= 5 && planes.size() < 3) {
                    System.out.println("Tasks 1-5 need at least 3 planes, but only "
                            + planes.size() + " loaded.");
                    continue;
                }
                try {
                    runTask(num, planes, service);
                } catch (IOException e) {
                    System.out.println("Could not write the output file: " + e.getMessage());
                }
            }
        }
    }

    private static ArrayList<Plane> convert(List<String> lines) {
        ArrayList<Plane> result = new ArrayList<>();
        for (String line : lines) {
            if (line == null || line.isBlank()) continue;
            String[] p = line.split(",");
            if (p.length < 10) continue;
            try {
                Plane plane = new Plane();
                plane.setModel(p[0].trim());
                plane.setCountry(p[1].trim());
                plane.setYear(Integer.parseInt(p[2].trim()));
                plane.setHours(Integer.parseInt(p[3].trim()));
                plane.setMilitary(Boolean.parseBoolean(p[4].trim()));
                plane.setWeigth(Double.parseDouble(p[5].trim()));
                plane.setWingspan(Double.parseDouble(p[6].trim()));
                plane.setTopSpeed(Double.parseDouble(p[7].trim()));
                plane.setSeats(Integer.parseInt(p[8].trim()));
                plane.setCost(Double.parseDouble(p[9].trim()));
                result.add(plane);
            } catch (NumberFormatException ignored) {
            }
        }
        return result;
    }

    private static void runTask(int num, ArrayList<Plane> planes,
                                PlaneService service) throws IOException {
        switch (num) {
            case 1:
                service.printPlane(planes.get(0));
                break;
            case 2:
                service.printMilitaryInfo(planes.get(0));
                break;
            case 3:
                service.newerPlane(planes.get(0), planes.get(1));
                break;
            case 4:
                service.biggerWingspan(planes.get(0), planes.get(1));
                break;
            case 5:
                service.smallestSeats(planes.get(0), planes.get(1), planes.get(2));
                break;
            case 6:
                service.printNotMilitary(planes.toArray(new Plane[0]));
                break;
            case 7:
                service.printMilitaryMoreThan100Hours(planes.toArray(new Plane[0]));
                break;
            case 8:
                service.minimalWeight(planes.toArray(new Plane[0]));
                break;
            case 9:
                service.minimalMilitaryCost(planes.toArray(new Plane[0]));
                break;
            case 10:
                service.sortByYear(planes.toArray(new Plane[0]));
                break;
            default:
                System.out.println("Unknown task number");
        }
    }
}