package chapter2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;


    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void calc() {
        assertEquals(3, stringCalculator.calc("1,2"));
        assertEquals(6, stringCalculator.calc("//-\n1-2-3"));
    }

    @Test
    void calcWhenNumberIsNullEmpty(){
        assertEquals(0, stringCalculator.calc(null));
        assertEquals(0, stringCalculator.calc(""));
    }

    @Test
    void split() {
        String data= "1,2:3";
        String[] result = {"1", "2", "3"};
        assertEquals(result[0], stringCalculator.split(data)[0]);
        assertEquals(result[1], stringCalculator.split(data)[1]);
        assertEquals(result[2], stringCalculator.split(data)[2]);
    }

    @Test
    void customSplit() {
        String data= "//-\n1-2-3";
        String[] result = {"1", "2", "3"};
        assertEquals(result[0], stringCalculator.customSplit(data)[0]);
        assertEquals(result[1], stringCalculator.customSplit(data)[1]);
        assertEquals(result[2], stringCalculator.customSplit(data)[2]);
    }

    @Test
    void sum() {
        String[] dummy = {"1","2"};
        assertEquals(3, stringCalculator.sum(dummy));
    }

    @Test
    void validateWhenIsValidNumber() {
        assertDoesNotThrow( () -> stringCalculator.checkValues(new String[]{"1"}));
    }

    @Test
    void validateWhenIsWrongNumber() {
        Exception exception = assertThrows(
                RuntimeException.class,
                () -> stringCalculator.checkValues(new String[]{"-1"})
        );

        assertEquals("Invalid number", exception.getMessage());
    }

}