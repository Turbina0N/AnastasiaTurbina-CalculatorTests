package hw1;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;

public class TestCalculator {
    protected static Calculator calc;
    protected static final double TOLERANCE = 0.1;

    @BeforeAll
    public static void setUp() {
        calc = new Calculator();
    }
}
