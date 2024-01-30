import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    /**
     * Test for default constructor with a string rep of "0".
     */
    @Test
    public void constructorTestDefault() {
        NaturalNumber n = this.constructorTest();
        assertEquals("0", n.toString());
    }

    /**
     * Test for int constructor with a specific string rep value equal to an int
     * value.
     */
    @Test
    public void constructorTestInt() {
        int value = 123;
        NaturalNumber n = this.constructorTest(value);
        assertEquals(String.valueOf(value), n.toString());
    }

    /**
     * Test for string constructor with a specific string rep value equal to an
     * input string value.
     */
    @Test
    public void constructorTestString() {
        String value = "123";
        NaturalNumber n = this.constructorTest(value);
        assertEquals(value, n.toString());
    }

    /**
     * Test for natural number constructor that checks if the natural number
     * object has an equal string rep value.
     */
    @Test
    public void constructorTestNaturalNumber() {
        NaturalNumber value = new NaturalNumber3(123);
        NaturalNumber n = this.constructorTest(value);
        assertEquals("123", n.toString());
    }

    /**
     * Test for multiplyBy10 that checks if the natural number object has an
     * equal string rep value.
     */
    @Test
    public void multiplyBy10Test() {
        NaturalNumber n = this.constructorTest(123);
        n.multiplyBy10(2);
        assertEquals("12300", n.toString());
    }

    /**
     * Test for divideBy10 using simple multi-digit numbers.
     */
    @Test
    public void divideBy10Test() {
        NaturalNumber n = new NaturalNumber3(123);
        assertEquals(3, n.divideBy10());
        assertEquals("12", n.toString());
    }

    /**
     * Test for isZero with an empty rep.
     */
    @Test
    public void testIsZeroWithEmptyRep() {
        NaturalNumber n = new NaturalNumber3();
        assertTrue(n.isZero());
    }

    /**
     * Test for isZero with a string parameter set to a value of "0".
     */
    @Test
    public void testIsZeroWithZeroRep() {
        NaturalNumber n = new NaturalNumber3("0");
        assertTrue(n.isZero());
    }

    /**
     * Test for isZero with a string parameter set to a nonzero value.
     */
    @Test
    public void testIsZeroWithNonZeroRep() {
        NaturalNumber n = new NaturalNumber3("123");
        assertFalse(n.isZero());
    }

    /**
     * Test for isZero with a nonzero natural number rep.
     */
    @Test
    public void testIsZeroWithNonZeroNN() {
        NaturalNumber n = new NaturalNumber3(1);
        assertFalse(n.isZero());
    }

    /**
     * Test for isZero with a natural number rep of zero.
     */
    @Test
    public void testIsZeroWithZeroNN() {
        NaturalNumber n = new NaturalNumber3();
        NaturalNumber n1 = new NaturalNumber3(n);
        assertTrue(n1.isZero());
    }
}
