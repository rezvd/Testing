import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 1 on 03.04.2018.
 */
public class TriangleTest {
    private double[] right;
    private double[] wrong;
    private double[] rectangular;
    private double[] notRectangular;

    @Before
    public void preparing(){
        right = new double[]{1.23, 2.3, 1.864};
        wrong = new double[]{1.23, 20.3, 1.864};
        rectangular = new double[]{0.4, 0.5, 0.3};
        notRectangular = new double[]{1.23, 2.3, 1.864};
    }

    @Test
    public void testRightTriangle() throws LengthException {
        Triangle triangle = new Triangle(right[0], right[1], right[2]);
        assertNotNull(triangle);
    }

    @Test
    public void testCopyTriangle() throws LengthException {
        Triangle triangle = new Triangle(right[0], right[1], right[2]);
        Triangle copyTriangle = new Triangle(triangle);
        assertEquals(triangle, copyTriangle);
    }

    @Test(expected = LengthException.class)
    public void testWrongTriangle() throws LengthException {
        Triangle triangle = new Triangle(wrong[0], wrong[1], wrong[2]);
        assertNull(triangle);
    }

    @Test
    public void testWrongTriangle1() throws LengthException {
        try {
            Triangle triangle = new Triangle(wrong[0], wrong[1], wrong[2]);
            fail();
        }
        catch(LengthException e){
//            assersthat(e);
        }
    }

    @Test
    public void testRectangularTriangle() throws LengthException {
        Triangle triangle = new Triangle(rectangular[0], rectangular[1], rectangular[2]);
        boolean test = triangle.isRectangular();
        assertTrue(test);
    }

    @Test
    public void testNotRectangularTriangle() throws LengthException {
        Triangle triangle = new Triangle(notRectangular[0], notRectangular[1], notRectangular[2]);
        boolean test = triangle.isRectangular();
        assertFalse(test);
    }
}
