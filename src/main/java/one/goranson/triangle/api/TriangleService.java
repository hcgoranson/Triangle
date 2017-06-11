package one.goranson.triangle.api;

public interface TriangleService {

    /**
     * Determines if a triangle with side A, B and C is of type <br>
     * {@link TriangleType#EQUILATERAL}, {@link TriangleType#ISOSCELES} or {@link TriangleType#SCALENE}. <br>
     * @param sideA - size of triangle side A
     * @param sideB - size of triangle side B
     * @param sideC - size of triangle side C
     * @return the {@link TriangleType}
     * @throws InvalidTriangleSideException if any triangle side is invalid
     */
    TriangleType determineTriangleType(double sideA, double sideB, double sideC) throws InvalidTriangleSideException;

}
