package one.goranson.triangle;

import one.goranson.triangle.api.InvalidTriangleSideException;
import one.goranson.triangle.api.TriangleService;
import one.goranson.triangle.impl.TriangleServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("This application reads the size of a triangle's");
        System.out.println("sides from the command input and decides");
        System.out.println("the triangle type.");

        final TriangleService triangleService = new TriangleServiceImpl();

        boolean exit = false;

        while(!exit) {

            final Scanner scanner = new Scanner(System.in);
            try {

                System.out.println("==========================================");
                System.out.println("Enter the size of the triangle sides: ");

                System.out.print("Side A: ");
                double sideA = scanner.nextDouble();

                System.out.print("Side B: ");
                double sideB = scanner.nextDouble();

                System.out.print("Side C: ");
                double sideC = scanner.nextDouble();

                System.out.println("Triangle typ is " +triangleService.determineTriangleType(sideA, sideB, sideC));
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again");
                scanner.next();
            } catch (InvalidTriangleSideException e) {
                System.out.println("Wrong input. " +e.getMessage());
            } finally {
                System.out.println("Try again? [y] ");
                String option = scanner.next();
                if(!"y".equals(option)) {
                    exit = true;
                }
            }
        }

    }
}
