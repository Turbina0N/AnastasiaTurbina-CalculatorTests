package hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TestSinus extends TestCalculator {

    // Проверки корректности вычисления синуса углов с заданной точностью
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0.48, 0.5",
            "0.765, 0.75",
            "0.89, 1",
            "1, 1.57",
            "0, 3.14",
            "-0.99, 4.71"
    })
    void testCorrectnessOfSinusCalculation(double expectedOutcome, double angleInRadians) {
        double result = calc.sin(angleInRadians);
        assertEquals(expectedOutcome, result, TOLERANCE, "Вычисленное значение синуса не соответствует ожидаемому.");
    }


    // Проверка симметричности функции синуса для отрицательных и положительных углов
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0.5, -0.5",
            "0.75, -0.75",
            "1, -1",
            "1.57, -1.57",
            "3.14, -3.14",
            "4.71, -4.71"
    })
    void testSinusFunctionSymmetry(double positiveAngle, double negativeAngle) {
        double sinPositive = calc.sin(positiveAngle);
        double sinNegative = calc.sin(negativeAngle);
        assertEquals(-sinPositive, sinNegative, TOLERANCE, "Синус отрицательного угла не равен отрицательному значению синуса соответствующего положительного угла.");
    }


    // Проверка инвариантности функции синуса при добавлении 2π к углу
    @ParameterizedTest
    @CsvSource({"0", "1.047", "2.094", "3.142", "4.189", "5.236"}) // 0 rad, π/3 rad, 2π/3 rad, π rad, 4π/3 rad, 5π/3 rad
    void testSinusFunctionPeriodicity(double angle) {
        double expected = calc.sin(angle);
        double actual = calc.sin(angle + 2 * Math.PI);
        assertEquals(expected, actual, TOLERANCE, "Синус угла не остаётся неизменным после добавления 2π.");
    }

}
