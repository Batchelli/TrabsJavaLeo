import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            boolean rodaDnv = true;

            while (rodaDnv) {

                    System.out.print("Digite um número inteiro positivo: ");
                    int numero = scan.nextInt();

                    boolean ehPrimo = primo(numero);

                    if (ehPrimo) {
                        System.out.println(numero + " é um número primo.");
                    } else {
                        System.out.println(numero + " não é um número primo.");
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

        public static boolean primo(int num) {
            if (num <= 1) {
                return false;
            }
            if (num <= 3) {
                return true;
            }
            if (num % 2 == 0 || num % 3 == 0) {
                return false;
            }

            for (int i = 5; i * i <= num; i += 6) {
                if (num % i == 0 || num % (i + 2) == 0) {
                    return false;
                }
            }

            return true;
        }
}