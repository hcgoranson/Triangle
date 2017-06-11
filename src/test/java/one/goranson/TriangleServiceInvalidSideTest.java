package one.goranson;

import one.goranson.triangle.api.InvalidTriangleSideException;
import one.goranson.triangle.api.TriangleService;
import one.goranson.triangle.impl.TriangleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Test some corner cases of invalid triangle sides
 */
@RunWith(Parameterized.class)
public class TriangleServiceInvalidSideTest {

    private TriangleService triangleService;

    @Parameterized.Parameters(name = "Invalid triangle side test | sideA: {0}, sideB: {1}, sideC: {2}")
    public static Iterable<Object[]> data() {
        // Each object in the list is an array of the sides a, b and c
        return Arrays.asList(new Object[][] {
                { 0, 0, 0 },
                { 0, 1, 1 },
                { -1, 1, 1},
                { 1, 0, 1 },
                { -1, 1, 1 },
                { 1, 1, 0 },
                { 1, 1, -1 }
        });
    }

    @Parameterized.Parameter(0)
    public int sideA;

    @Parameterized.Parameter(1)
    public int sideB;

    @Parameterized.Parameter(2)
    public int sideC;


    @Before
    public void setUp() throws Exception {
        this.triangleService = new TriangleServiceImpl();
    }

    @Test(expected = InvalidTriangleSideException.class)
    public void testInvalidTriangleSides() throws InvalidTriangleSideException {
        triangleService.determineTriangleType(sideA, sideB, sideC);
    }

}
