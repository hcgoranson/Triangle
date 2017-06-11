package one.goranson;

import one.goranson.triangle.api.InvalidTriangleSideException;
import one.goranson.triangle.api.TriangleService;
import one.goranson.triangle.api.TriangleType;
import one.goranson.triangle.impl.TriangleServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleServiceTest {

    private TriangleService triangleService;

    @Before
    public void setUp() throws Exception {
        this.triangleService = new TriangleServiceImpl();
    }

    @Test
    public void testTriangleTypeIsEquilateral() throws InvalidTriangleSideException {
        TriangleType type = triangleService.determineTriangleType(1,1,1);
        assertEquals("Wrong triangle type", type, TriangleType.EQUILATERAL);
    }

    @Test
    public void testTriangleTypeIsIsosceles() throws InvalidTriangleSideException {
        TriangleType type = triangleService.determineTriangleType(1,1,2);
        assertEquals("Wrong triangle type", type, TriangleType.ISOSCELES);

        type = triangleService.determineTriangleType(2,1,1);
        assertEquals("Wrong triangle type", type, TriangleType.ISOSCELES);

        type = triangleService.determineTriangleType(1,2,1);
        assertEquals("Wrong triangle type", type, TriangleType.ISOSCELES);
    }

    @Test
    public void testTriangleTypeIsScalene() throws InvalidTriangleSideException {
        TriangleType type = triangleService.determineTriangleType(1,2,3);
        assertEquals("Wrong triangle type", type, TriangleType.SCALENE);
    }

}
