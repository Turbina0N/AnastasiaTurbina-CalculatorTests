package hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TestSumDouble extends TestCalculator {
    // Тестирование граничных значений
    @ParameterizedTest
    @CsvSource({"1.7976931348623157E308, 1.7976931348623157E308, 0.0", "-1.7976931348623157E308, -1.7976931348623157E308, 0.0"})
    void testBoundaryValues(double expected, double a, double b) {
        assertEquals(expected, calc.sum(a, b));
    }

    // Тестирование общей корректности функции сложения
    @ParameterizedTest
    @CsvSource({"23.0, 17.0, 6.0", "-10.0, -8.0, -2.0"})
    void testBasicCorrectness(double expected, double a, double b) {
        assertEquals(expected, calc.sum(a, b));
    }

    // Тестирование изменения знака через ноль
    @ParameterizedTest
    @CsvSource({"1.0, -1.0, 2.0", "-1.0, 1.0, -2.0"})
    void testSignChangeThroughZero(double expected, double a, double b) {
        assertEquals(expected, calc.sum(a, b));
    }
}
