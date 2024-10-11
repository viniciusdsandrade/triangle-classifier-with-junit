package figure;

import static java.lang.Math.*;

public class Triangle {

    /**
     * Classifica o tipo de triângulo com base nos comprimentos dos seus lados.
     *
     * @param a Comprimento do lado a
     * @param b Comprimento do lado b
     * @param c Comprimento do lado c
     * @return Uma string indicando o tipo de triângulo
     */
    public static String classifyTriangle(double a, double b, double c) {
        // Verifica se os lados são válidos
        if (!isValidTriangle(a, b, c)) return "Lados inválidos"; // Lados inválidos ou não formam um triângulo

        // Verifica se é um triângulo equilátero
        if (a == b && b == c) return "Triângulo Equilátero";

        // Verifica se é um triângulo isósceles
        if (a == b || a == c || b == c) return "Triângulo Isósceles";

        // Se nenhuma das condições acima for atendida, é um triângulo escaleno
        return "Triângulo Escaleno";
    }

    /**
     * Classifica o triângulo em relação aos seus ângulos.
     *
     * @param a Comprimento do lado a
     * @param b Comprimento do lado b
     * @param c Comprimento do lado c
     * @return Uma string indicando o tipo de ângulo do triângulo
     */
    public static String classifyTriangleByAngles(double a, double b, double c) {
        // Verifica se os lados formam um triângulo válido
        if (!isValidTriangle(a, b, c)) return "Lados inválidos"; // Lados inválidos ou não formam um triângulo

        // Calcula os ângulos usando a Lei dos Cossenos
        double angleA = calculateAngle(b, c, a);
        double angleB = calculateAngle(a, c, b);
        double angleC = calculateAngle(a, b, c);

        // Verifica se algum ângulo é reto (90 graus)
        if (isApproximatelyEqual(angleA, 90) ||
            isApproximatelyEqual(angleB, 90) ||
            isApproximatelyEqual(angleC, 90)) {
            return "Triângulo Retângulo";
        }

        // Verifica se algum ângulo é obtuso (> 90 graus)
        if (angleA > 90 || angleB > 90 || angleC > 90) return "Triângulo Obtusângulo";

        // Se todos os ângulos são agudos (< 90 graus)
        return "Triângulo Acutângulo";
    }

    /**
     * Calcula a área de um triângulo usando a fórmula de Heron.
     *
     * @param a Comprimento do lado a
     * @param b Comprimento do lado b
     * @param c Comprimento do lado c
     * @return A área do triângulo, ou −1 se os lados forem inválidos ou não formarem um triângulo
     */
    public static double calculateArea(double a, double b, double c) {
        // Verifica se os lados formam um triângulo válido
        if (!isValidTriangle(a, b, c)) return -1; // Lados inválidos ou não formam um triângulo

        // Calcula o semiperímetro
        double s = (a + b + c) / 2;

        // Calcula a área usando a fórmula de Heron
        double areaSquared = s * (s - a) * (s - b) * (s - c);

        // Verifica se a área é válida
        if (areaSquared <= 0) return -1; // Área inválida

        return sqrt(areaSquared);
    }

    // Métodos auxiliares
    /**
     * Verifica se três lados podem formar um triângulo válido.
     *
     * @param a Lado a
     * @param b Lado b
     * @param c Lado c
     * @return true se for um triângulo válido, false caso contrário
     */
    private static boolean isValidTriangle(double a, double b, double c) {
        // Verifica se os lados são positivos
        if (a <= 0 || b <= 0 || c <= 0) return false;

        // Verifica a desigualdade triangular
        return a + b > c && a + c > b && b + c > a;
    }

    /**
     * Calcula o ângulo oposto ao lado c usando a Lei dos Cossenos.
     *
     * @param a Lado a
     * @param b Lado b
     * @param c Lado c (lado oposto ao ângulo que queremos calcular)
     * @return O ângulo em graus
     */
    private static double calculateAngle(double a, double b, double c) {
        // Lei dos Cossenos: c^2 = a^2 + b^2 - 2ab * cos(C)
        // Portanto, cos(C) = (a^2 + b^2 - c^2) / (2ab)
        double numerator = a * a + b * b - c * c;
        double denominator = 2 * a * b;
        double cosAngle = numerator / denominator;

        // Limita o valor de cosAngle para o intervalo [-1, 1] devido a possíveis imprecisões numéricas
        cosAngle = min(1.0, max(-1.0, cosAngle));

        // Calcula o ângulo em graus
        return toDegrees(Math.acos(cosAngle));
    }

    /**
     * Compara dois valores double considerando uma tolerância para lidar com imprecisões numéricas.
     *
     * @param a Primeiro valor
     * @param b Segundo valor
     * @return true se os valores forem aproximadamente iguais, false caso contrário
     */
    private static boolean isApproximatelyEqual(double a, double b) {
        double tolerance = 1e-6;
        return abs(a - b) < tolerance;
    }
}
