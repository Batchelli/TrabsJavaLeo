import java.util.Scanner;

public class FigurasPlanas {

    Scanner input = new Scanner(System.in);

    public void FigsPlanas(){

        System.out.println("Escolha int opFP = input.nextInt();a figura geométrica desejada: ");
        System.out.println("1 - Quadrado");
        System.out.println("2 - Triângulo");
        System.out.println("3 - Retângulo");
        System.out.println("4 - Hexágono Retangular");
        System.out.println("5 - Circulo");
        System.out.println("6 - Voltar");
        int opFP = input.nextInt();

        switch (opFP) {
            case 1:
                System.out.println("Digite o valor do lado do quadrado: ");
                double ladoQuadrado = input.nextDouble();
                double areaQuadrado = ladoQuadrado * ladoQuadrado;
                double perimetroQuadrado = 4 * ladoQuadrado;
                System.out.println("A área do quadrado é: " + areaQuadrado);
                System.out.println("O perímetro do quadrado é: " + perimetroQuadrado);
                break;

            case 2:
                System.out.println("Digite o valor da base do triângulo: ");
                double baseTriangulo = input.nextDouble();
                System.out.println("Digite o valor da altura do triângulo: ");
                double alturaTriangulo = input.nextDouble();
                double areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
                double perimetroTriangulo = baseTriangulo * 3;
                System.out.println("A área do triângulo é: " + areaTriangulo);
                System.out.println("O perímetro do triângulo é: " + perimetroTriangulo);
                break;

            case 3:
                System.out.println("Digite o valor da base do retângulo: ");
                double baseRetangulo = input.nextDouble();
                System.out.println("Digite o valor da altura do retângulo: ");
                double alturaRetangulo = input.nextDouble();
                double areaRetangulo = baseRetangulo * alturaRetangulo;
                double perimetroRetangulo = (2 * baseRetangulo) + (2 * alturaRetangulo);
                System.out.println("A área do retângulo é: " + areaRetangulo);
                System.out.println("O perímetro do retângulo é: " + perimetroRetangulo);
                break;

            case 4:
                System.out.println("Digite o valor da base do hexágono retangular: ");
                double baseHexagono = input.nextDouble();
                System.out.println("Digite o valor da altura do hexágono retangular: ");
                double alturaHexagono = input.nextDouble();
                double areaHexagono = (baseHexagono * alturaHexagono) / 2 * 6;
                double perimetroHexagono = baseHexagono * 6;
                System.out.println("A área do hexágono retangular é: " + areaHexagono);
                System.out.println("O perímetro do hexágono retangular é: " + perimetroHexagono);
                break;

            case 5:
                System.out.println("Digite o valor do raio do círculo: ");
                double raioCirculo = input.nextDouble();
                double areaCirculo = Math.PI * raioCirculo * raioCirculo;
                double diametroCirculo = 2 * raioCirculo;
                double circunferenciaCirculo = 2 * Math.PI * raioCirculo;
                System.out.println("A área do círculo é: " + areaCirculo);
                System.out.println("O diâmetro do círculo é: " + diametroCirculo);
                System.out.println("A circunferência do círculo é: " + circunferenciaCirculo);
                break;

            default:
                System.out.println("Opção inválida");
        }
    }
}
