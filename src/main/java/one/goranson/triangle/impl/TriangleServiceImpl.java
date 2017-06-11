package one.goranson.triangle.impl;

import one.goranson.triangle.api.InvalidTriangleSideException;
import one.goranson.triangle.api.TriangleService;
import one.goranson.triangle.api.TriangleType;

public class TriangleServiceImpl implements TriangleService {
    
    public TriangleType determineTriangleType(double sideA, double sideB, double sideC) throws InvalidTriangleSideException {

        // Validate input arguments
        validateSides(sideA, sideB, sideC);

        if(isEquilateral(sideA, sideB, sideC)) {
            return TriangleType.EQUILATERAL;
        } else if(isIsosceles(sideA, sideB, sideC)) {
            return TriangleType.ISOSCELES;
        }
    
        // The triangle has neither three sides of equal size 
        // nor has it two sides that have equal size.
        // So, no sides are of equal size: triangle must be a Scalene triangle
        return TriangleType.SCALENE;
    }

    private boolean isIsosceles(double sideA, double sideB, double sideC) {
        // An isoceles triangle has two sides that are equal
        if(sideA == sideB || sideB == sideC || sideC == sideA ) {
            return true;
        }
        return false;
    }

    private boolean isEquilateral(double sideA, double sideB, double sideC) {
        // An equilateral triangle has three sides that are equal
        if(sideA == sideB && sideB == sideC) {
            return true;
        }
        return false;
    }

    private void validateSides(double sideA, double sideB, double sideC) throws InvalidTriangleSideException {

        // A side length must greater than zero
        if(sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new InvalidTriangleSideException("A side length must be greater than zero (SideA=" +sideA +", SideB=" +sideB +", SideC=" +sideC+")");
        }
    }
}
