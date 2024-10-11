import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static figure.Triangle.*;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    // Testes para classificar o triângulo pelos lados

    @Test
    @DisplayName("Testa classificação de Triângulo Equilátero")
    public void testEquilateralTriangle() {
        assertEquals("Triângulo Equilátero", classifyTriangle(3, 3, 3));
    }

    @Test
    @DisplayName("Testa classificação de Triângulo Isósceles com lados A e B iguais")
    public void testIsoscelesTriangle_SidesAandBEqual() {
        assertEquals("Triângulo Isósceles", classifyTriangle(5, 5, 3));
    }

    @Test
    @DisplayName("Testa classificação de Triângulo Isósceles com lados A e C iguais")
    public void testIsoscelesTriangle_SidesAandCEqual() {
        assertEquals("Triângulo Isósceles", classifyTriangle(5, 3, 5));
    }

    @Test
    @DisplayName("Testa classificação de Triângulo Isósceles com lados B e C iguais")
    public void testIsoscelesTriangle_SidesBandCEqual() {
        assertEquals("Triângulo Isósceles", classifyTriangle(3, 5, 5));
    }

    @Test
    @DisplayName("Testa classificação de Triângulo Escaleno")
    public void testScaleneTriangle() {
        assertEquals("Triângulo Escaleno", classifyTriangle(3, 4, 5));
    }

    @Test
    @DisplayName("Testa classificação de Triângulo Escaleno com lados decimais")
    public void testScaleneTriangleWithDecimals() {
        assertEquals("Triângulo Escaleno", classifyTriangle(2.5, 3.5, 4.5));
    }

    @Test
    @DisplayName("Testa classificação com lados inválidos (negativos)")
    public void testInvalidTriangle_NegativeSides() {
        assertEquals("Lados inválidos", classifyTriangle(-1, 2, 3));
    }

    @Test
    @DisplayName("Testa classificação com lados inválidos (zero)")
    public void testInvalidTriangle_ZeroSide() {
        assertEquals("Lados inválidos", classifyTriangle(0, 2, 3));
    }

    @Test
    @DisplayName("Testa classificação com soma de dois lados igual ao terceiro")
    public void testNotATriangle_SumOfSidesEqualToThird() {
        assertEquals("Lados inválidos", classifyTriangle(1, 2, 3));
    }

    @Test
    @DisplayName("Testa classificação com soma de dois lados menor que o terceiro")
    public void testNotATriangle_SumOfTwoSidesLessThanThird() {
        assertEquals("Lados inválidos", classifyTriangle(1, 1, 3));
    }

    @Test
    @DisplayName("Testa classificação com combinação de lados que não formam triângulo")
    public void testNotATriangle_OtherCombination() {
        assertEquals("Lados inválidos", classifyTriangle(5, 1, 1));
    }

    @Test
    @DisplayName("Testa classificação com todos os lados inválidos")
    public void testNotATriangle_AllSidesInvalid() {
        assertEquals("Lados inválidos", classifyTriangle(-1, -1, -1));
    }

    // Testes para calcular a área do triângulo

    @Test
    @DisplayName("Testa cálculo de área para Triângulo Equilátero")
    public void testCalculateArea_EquilateralTriangle() {
        double area = calculateArea(3, 3, 3);
        assertEquals(3.89711, area, 0.0001);
    }

    @Test
    @DisplayName("Testa cálculo de área para Triângulo Isósceles")
    public void testCalculateArea_IsoscelesTriangle() {
        double area = calculateArea(5, 5, 8);
        assertEquals(12.0, area, 0.0001);
    }

    @Test
    @DisplayName("Testa cálculo de área para Triângulo Escaleno")
    public void testCalculateArea_ScaleneTriangle() {
        double area = calculateArea(3, 4, 5);
        assertEquals(6.0, area, 0.0001);
    }

    @Test
    @DisplayName("Testa cálculo de área para Triângulo Escaleno com lados decimais")
    public void testCalculateArea_WithDecimals() {
        double area = calculateArea(2.5, 3.5, 4.5);
        assertEquals(4.353070037341462, area, 0.0001);
    }

    @Test
    @DisplayName("Testa cálculo de área com lados inválidos (negativos)")
    public void testCalculateArea_InvalidSides_Negative() {
        double area = calculateArea(-1, 2, 3);
        assertEquals(-1, area);
    }

    @Test
    @DisplayName("Testa cálculo de área com lados inválidos (zero)")
    public void testCalculateArea_InvalidSides_Zero() {
        double area = calculateArea(0, 2, 3);
        assertEquals(-1, area);
    }

    @Test
    @DisplayName("Testa cálculo de área quando os lados não formam um triângulo")
    public void testCalculateArea_NotATriangle() {
        double area = calculateArea(1, 2, 3);
        assertEquals(-1, area);
    }

    @Test
    @DisplayName("Testa cálculo de área com todos os lados iguais a zero")
    public void testCalculateArea_AllSidesEqualZero() {
        double area = calculateArea(0, 0, 0);
        assertEquals(-1, area);
    }

    // Testes para classificar o triângulo pelos ângulos

    @Test
    @DisplayName("Testa classificação de Triângulo Retângulo")
    public void testClassifyTriangleByAngles_RightAngled() {
        assertEquals("Triângulo Retângulo", classifyTriangleByAngles(3, 4, 5));
        assertEquals("Triângulo Retângulo", classifyTriangleByAngles(5, 12, 13));
    }

    @Test
    @DisplayName("Testa classificação de Triângulo Acutângulo")
    public void testClassifyTriangleByAngles_AcuteAngled() {
        assertEquals("Triângulo Acutângulo", classifyTriangleByAngles(5, 5, 5));
        assertEquals("Triângulo Acutângulo", classifyTriangleByAngles(4, 5, 6));
    }

    @Test
    @DisplayName("Testa classificação de Triângulo Obtusângulo")
    public void testClassifyTriangleByAngles_ObtuseAngled() {
        assertEquals("Triângulo Obtusângulo", classifyTriangleByAngles(3, 5, 7));
        assertEquals("Triângulo Obtusângulo", classifyTriangleByAngles(2, 3, 4));
    }

    @Test
    @DisplayName("Testa classificação de triângulo pelos ângulos com lados que não formam triângulo")
    public void testClassifyTriangleByAngles_InvalidTriangle() {
        assertEquals("Lados inválidos", classifyTriangleByAngles(1, 2, 3));
        assertEquals("Lados inválidos", classifyTriangleByAngles(0, 0, 0));
        assertEquals("Lados inválidos", classifyTriangleByAngles(-1, -1, -1));
    }

    @Test
    @DisplayName("Testa estabilidade numérica na classificação de Triângulo Retângulo")
    public void testClassifyTriangleByAngles_NumericalStability() {
        // Triângulo quase retângulo
        assertEquals("Triângulo Retângulo", classifyTriangleByAngles(1e6, 1e6, sqrt(2) * 1e6));
    }
}
