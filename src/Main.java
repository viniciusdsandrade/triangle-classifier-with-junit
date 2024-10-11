import java.util.InputMismatchException;
import java.util.Scanner;

import static figure.Triangle.*;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        double a, b, c, area;

        try (Scanner scanner = new Scanner(in)) {
            System.out.print("Digite o comprimento do lado a: ");
            a = scanner.nextDouble();

            System.out.print("Digite o comprimento do lado b: ");
            b = scanner.nextDouble();

            System.out.print("Digite o comprimento do lado c: ");
            c = scanner.nextDouble();

            String tipoLados = classifyTriangle(a, b, c);
            String tipoAngulos = classifyTriangleByAngles(a, b, c);

            System.out.println("Classificação pelos lados: " + tipoLados);
            System.out.println("Classificação pelos ângulos: " + tipoAngulos);

            area = calculateArea(a, b, c);
            if (area == -1) {
                System.err.println("Não foi possível calcular a área com os lados fornecidos.");
            } else {
                System.out.printf("A área do triângulo é: %.4f\n", area);
            }
        } catch (InputMismatchException e) {
            System.err.println("Entrada inválida. Por favor, insira números válidos.");
        }
    }
}
