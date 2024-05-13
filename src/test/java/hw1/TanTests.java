package hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TanTests extends TestCalculator {

    // Проверка, что тангенс приближается к бесконечности при определенных углах
    @ParameterizedTest
    @ValueSource(doubles = {1.57, 4.71}) // Углы около π/2 и 3π/2, где cos равен 0
    void testTangentApproachingInfinity(double angle) {
        double computedValue = calc.tg(angle);
        assertEquals(Double.POSITIVE_INFINITY, computedValue, TOLERANCE, "Тангенс должен стремиться к бесконечности.");
    }

    // Тестирование значения тангенса для выбранных углов
    @ParameterizedTest
    @CsvSource({
            "0, 0",      // Тангенс 0 радиан
            "0.58, 0.5", // Тангенс приближенно для 0.5 радиан
            "1.00, 0.78",// Тангенс для π/4 радиан
            "1.74, 1.05" // Тангенс приближенно для 1.05 радиан
    })
    void verifyTangentValuesForSpecificAngles(double expectedOutcome, double angleInRadians) {
        double result = calc.tg(angleInRadians);
        assertEquals(expectedOutcome, result, TOLERANCE, "Рассчитанное значение тангенса не соответствует ожидаемому.");
    }

}
