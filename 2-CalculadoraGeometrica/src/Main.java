import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nEscolha que tipo de figura deseja: ");
            System.out.println("1 - Figuras Planas");
            System.out.println("2 - Figuras Espaciais");
            System.out.println("3 - Sair\n");
            int op = input.nextInt();

            if(op == 1) {
                while (true) {
                    System.out.println("\nEscolha a figura geométrica desejada: ");
                    System.out.println("1 - Quadrado");
                    System.out.println("2 - Triângulo");
                    System.out.println("3 - Retângulo");
                    System.out.println("4 - Hexágono Retangular");
                    System.out.println("5 - Circulo");
                    System.out.println("6 - Voltar\n");
                    int opFP = input.nextInt();

                    if (opFP == 1) {
                        Quadrado q1 = new Quadrado();
                        System.out.println("Digite um valor para o quadrado: ");
                        q1.ladoQuadrado = input.nextDouble();
                        System.out.println("A área do quadrado é: " + q1.areaQuadrado());
                        System.out.println("O perímetro do quadrado é: " + q1.perimetroQuadrado() + "\n");

                    } else if (opFP == 2) {
                        Triangulo t1 = new Triangulo();
                        System.out.println("Digite o valor da base do Triângulo");
                        t1.baseTriangulo = input.nextDouble();
                        System.out.println("Digite o valor da altura do Triângulo");
                        t1.alturaTriangulo = input.nextDouble();
                        System.out.println("A área do triângulo é: " + t1.areaTriangulo());
                        System.out.println("O perímetro do triângulo é: " + t1.perimetroTriangulo() + "\n");

                    } else if (opFP == 3) {
                        Retangulo r1 = new Retangulo();
                        System.out.println("Digite o valor da base do Retângulo");
                        r1.baseRetangulo = input.nextDouble();
                        System.out.println("Digite o valor da altura do Retângulo");
                        r1.alturaRetangulo = input.nextDouble();
                        System.out.println("A área do retângulo é: " + r1.areaRetangulo());
                        System.out.println("O perímetro do retângulo é: " + r1.perimetroRetangulo() + "\n");

                    } else if (opFP == 4) {
                        HexagonoRetangular h1 = new HexagonoRetangular();
                        System.out.println("Digite o valor da base do hexágono retangular: ");
                        h1.baseHexagono = input.nextDouble();
                        System.out.println("Digite o valor da altura do hexágono retangular: ");
                        h1.alturaHexagono = input.nextDouble();
                        System.out.println("A área do hexágono retangular é: " + h1.areaHexagono());
                        System.out.println("O perímetro do hexágono retangular é: " + h1.perimetroHexagono() + "\n");

                    } else if (opFP == 5) {
                        Circulo c1 = new Circulo();
                        System.out.println("Digite o valor do raio do circulo: ");
                        c1.raioCirculo = input.nextDouble();
                        System.out.println("A área do círculo é: " + c1.areaCirculo());
                        System.out.println("O diâmetro do círculo é: " + c1.diametroCirculo());
                        System.out.println("A circunferência do círculo é: " + c1.circunferenciaCirculo() + "\n");
                    } else {
                        break;
                    }
                }
            }

            else if(op == 2){
                while (true) {
                    System.out.println("Escolha a figura geométrica desejada: ");
                    System.out.println("1 - Cubo");
                    System.out.println("2 - Paralelepípedo");
                    System.out.println("3 - Pirâmide de Base Quadrada");
                    System.out.println("4 - Esfera");
                    System.out.println("5 - Cilindro");
                    System.out.println("6 - Cone");
                    System.out.println("7 - Voltar");
                    int opFe = input.nextInt();

                    if(opFe == 1) {
                        Cubo cb1 = new Cubo();
                        System.out.println("Digite o valor da aresta do cubo: ");
                        cb1.arestaCubo = input.nextDouble();
                        System.out.println("A área do cubo é: " + cb1.areaCubo());
                        System.out.println("O volume do cubo é: " + cb1.volumeCubo() + "\n");
                    }

                    else if(opFe == 2){
                        Paralelepipedo p1 = new Paralelepipedo();
                        System.out.println("Digite o valor do comprimento do paralelepípedo: ");
                        p1.compParalelepipedo = input.nextDouble();
                        System.out.println("Digite o valor da largura do paralelepípedo: ");
                        p1.larParalelepipedo = input.nextDouble();
                        System.out.println("Digite o valor da altura do paralelepípedo: ");
                        p1.altParalelepipedo = input.nextDouble();
                        System.out.println("A área do paralelepípedo é: " + p1.areaParalelepipedo());
                        System.out.println("O volume do paralelepípedo é: " + p1.volParalelepipedo() + "\n");
                    }

                    else if(opFe == 3){
                        Piramide pr1  = new Piramide();
                        System.out.println("Digite o valor do lado da base da pirâmide: ");
                        pr1.lbPiramide = input.nextDouble();
                        System.out.println("Digite o valor da altura da pirâmide: ");
                        pr1.altPiramide = input.nextDouble();
                        System.out.println("A área da pirâmide de base quadrada é: " + pr1.areaTPiramide());
                        System.out.println("O volume da pirâmide de base quadrada é: " + pr1.volPiramide() + "\n");
                    }

                    else if(opFe == 4){
                        Esfera e1 = new Esfera();
                        System.out.println("Digite o valor do raio da esfera: ");
                        e1.raioEsfera = input.nextDouble();
                        System.out.println("A área da esfera é: " + e1.areaEsfera());
                        System.out.println("O volume da esfera é: " + e1.volEsfera() + "\n");
                    }

                    else if(opFe == 5){
                        Cilindro cl1 = new Cilindro();
                        System.out.println("Digite o valor do raio do cilindro: ");
                        cl1.raioCilindro = input.nextDouble();
                        System.out.println("Digite o valor da altura do cilindro: ");
                        cl1.altCilindro = input.nextDouble();
                        System.out.println("A área do cilindro é: " + cl1.areaTCilindro());
                        System.out.println("O volume do cilindro é: " + cl1.volCilindro() + "\n");
                    }

                    else if(opFe == 6){
                        Cone cn1 = new Cone();
                        System.out.println("Digite o valor do raio do cone: ");
                        cn1.raioCone = input.nextDouble();
                        System.out.println("Digite o valor da altura do cone: ");
                        cn1.altCone = input.nextDouble();
                        System.out.println("A área do cone é: " + cn1.areaTCone());
                        System.out.println("O volume do cone é: " + cn1.volCone() + "\n");
                    }

                    else{
                        break;
                    }
                }
            }

            else{
                break;
            }
        }
    }
}

