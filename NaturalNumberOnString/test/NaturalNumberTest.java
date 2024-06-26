import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;

// merging

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
     * Test for default constructor with a string rep of "".
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
    public void constructorTestNonZeroInt() {
        int value = 123;
        NaturalNumber n = this.constructorTest(value);
        NaturalNumber ref = this.constructorRef(value);
        assertEquals(n, ref);
    }

    /**
     * Test for int constructor with a string rep of "".
     */
    @Test
    public void constructorTestZeroInt() {
        int value = 0;
        NaturalNumber n = this.constructorTest(value);
        NaturalNumber ref = this.constructorRef(value);
        assertEquals(n, ref);
    }

    /**
     * Test for string constructor with a specific string rep value equal to an
     * input string value.
     */
    @Test
    public void constructorTestNonZeroString() {
        String value = "123";
        NaturalNumber n = this.constructorTest(value);
        NaturalNumber ref = this.constructorRef(value);
        assertEquals(n, ref);
    }

    /**
     * Test for string constructor with a specific string rep value equal to "".
     */
    @Test
    public void constructorTestZeroString() {
        String value = "0";
        NaturalNumber n = this.constructorTest(value);
        NaturalNumber ref = this.constructorRef(value);
        assertEquals(n, ref);
    }

    /**
     * Test for natural number constructor that checks if the natural number
     * object has an equal string rep value.
     */
    @Test
    public void constructorTestNaturalNumberWithNonZero() {
        NaturalNumber value = new NaturalNumber3(123);
        NaturalNumber n = this.constructorTest(value);
        NaturalNumber ref = this.constructorRef(value);
        assertEquals(n, ref);
    }

    /**
     * Test for naturalNumber constructor with 0.
     */
    @Test
    public void constructorTestNaturalNumberWithZero() {
        NaturalNumber value = new NaturalNumber3(0);
        NaturalNumber n = this.constructorTest(value);
        NaturalNumber ref = this.constructorRef(value);
        assertEquals(n, ref);
    }

    /**
     * Test for multiplyBy10 that checks if the natural number object has an
     * equal string rep value for an initial multidigit value.
     */
    @Test
    public void multiplyBy10WithNonZeroNNTest() {
        NaturalNumber n = this.constructorTest(123);
        NaturalNumber ref = this.constructorRef(123);
        ref.multiplyBy10(2);
        n.multiplyBy10(2);
        assertEquals(n, ref);
    }

    /**
     * Test for multiplyBy10 that checks if the natural number object has an
     * equal string rep value for a initial value of 0.
     */
    @Test
    public void multiplyBy10NNZeroTest() {
        NaturalNumber n = this.constructorTest(0);
        NaturalNumber ref = this.constructorRef(0);
        n.multiplyBy10(2);
        ref.multiplyBy10(2);
        assertEquals(n, ref);
    }

    /**
     * Test for multiplyBy10 that checks if the natural number object has an
     * equal string rep value with an initial digit value multiplying a zero on.
     */
    @Test
    public void multiplyBy10WithZeroNNTest() {
        NaturalNumber n = this.constructorTest(123);
        NaturalNumber ref = this.constructorRef(123);
        n.multiplyBy10(0);
        ref.multiplyBy10(0);
        assertEquals(n, ref);
    }

    /**
     * Test for divideBy10 using simple multi-digit numbers.
     */
    @Test
    public void divideBy10SimpleTest() {
        NaturalNumber n = this.constructorTest(123);
        NaturalNumber ref = this.constructorRef(123);
        assertEquals(3, n.divideBy10());
        ref.divideBy10();
        assertEquals(n, ref);
    }

    /**
     * Test for divideBy10 with an initial 0.
     */
    @Test
    public void divideBy10InitialZeroTest() {
        NaturalNumber n = this.constructorTest();
        NaturalNumber ref = this.constructorRef();
        assertEquals(0, n.divideBy10());
        ref.divideBy10();
        assertEquals(n, ref);
    }

    /**
     * Test for divideBy10 using an initial single digit number.
     */
    @Test
    public void divideBy10SingleDigitTest() {
        NaturalNumber n = this.constructorTest(5);
        NaturalNumber ref = this.constructorRef(5);
        ref.divideBy10();
        assertEquals(5, n.divideBy10());
        assertEquals(n, ref);
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
