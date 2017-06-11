package one.goranson.triangle.api;


public enum TriangleType {

    /** Triangle with three equal sides */
    EQUILATERAL("Equilateral"),

    /** Triangle with two equal sides */
    ISOSCELES("Isosceles"),

    /** Triangle with no equal sides */
    SCALENE("Scalene");

    private String name;

    TriangleType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
