import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean rodaDnv = true;

        while (rodaDnv) {
            int soA;
            int soB;
            int vA;
            int vB;

            while (true) {
                try {
                    System.out.println("Digite a posição inicial do Trem A: ");
                    soA = scan.nextInt();
                    if (soA >= 0 && soA <= 10000) {
                        break;
                    } else {
                        System.out.println("Valor inválido, por favor digite um valor entre 0 e 10000!!!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, digite apenas números!!!");
                }
                scan.nextLine();
            }
            while (true) {
                try {
                    System.out.println("Digite a posição inicial do Trem B: ");
                    soB = scan.nextInt();
                    if (soB >= 0 && soB <= 10000) {
                        break;
                    } else {
                        System.out.println("Valor inválido, por favor digite um valor entre 0 e 10000!!!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, digite apenas números!!!");
                }
                scan.nextLine();
            }
            while (true) {
                try {
                    System.out.println("Digite a velocidade do Trem A: ");
                    vA = scan.nextInt();
                    if (vA >= 0 && vA <= 300) {
                        break;
                    } else {
                        System.out.println("Valor inválido, por favor digite uma velocidade entre 0 e 300!!!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, digite apenas números!!!");
                }
                scan.nextLine();
            }
            while (true) {
                try {
                    System.out.println("Digite a velocidade do Trem B: ");
                    vB = scan.nextInt();
                    if (vB >= 0 && vB <= 300) {
                        vB = -vB;  // Defina a velocidade do Trem B como negativa
                        break;
                    } else {
                        System.out.println("Valor inválido, por favor digite uma velocidade entre 0 e 300!!!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, digite apenas números!!!");
                }
                scan.nextLine();
            }

            int t = (soA - soB) / (vB - vA);
            int Sa = soA + vA * t;
            int Sb = soB + vB * t;
            int S = (Sa + Sb) / 2;

            if ( t >= 0) {
                System.out.println("A colisão dos trens acontecera no KM: " + S + ". E ocorrerá após " + (t * 3600) + " segundos!");
                System.out.println("Tempo de colisão: " + (t * 3600));
                System.out.println("Km da Colisão: " + S);
            } else {
                System.out.println("Não houve uma conlisão entr os trens!");
            }
            System.out.println("Deseja executar novamente? (s/n)");
            String resposta = scan.next().toLowerCase();

            while (!resposta.equals("s") && !resposta.equals("n")) {
                System.out.println("Resposta inválida. Por favor, digite 's' para continuar ou 'n' para encerrar.");
                resposta = scan.next();
            }

            if (resposta.equals("n")) {
                System.out.println("Fim do Programa!");
                rodaDnv = false;
            }
        }
    }
}

