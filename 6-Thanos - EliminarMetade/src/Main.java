import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[]args){
        Random random = new Random();
        ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

        listaDeUsuarios.add(new Usuario("Allana"));
        listaDeUsuarios.add(new Usuario("Angelo"));
        listaDeUsuarios.add(new Usuario("Caio"));
        listaDeUsuarios.add(new Usuario("Cadu"));
        listaDeUsuarios.add(new Usuario("Diego Alencar"));
        listaDeUsuarios.add(new Usuario("Diego Castan"));
        listaDeUsuarios.add(new Usuario("Eduarda"));
        listaDeUsuarios.add(new Usuario("Esther"));
        listaDeUsuarios.add(new Usuario("Felipe"));
        listaDeUsuarios.add(new Usuario("Bona"));
        listaDeUsuarios.add(new Usuario("Radaeli"));
        listaDeUsuarios.add(new Usuario("Fiuza"));
        listaDeUsuarios.add(new Usuario("Giovana"));
        listaDeUsuarios.add(new Usuario("Henrique"));
        listaDeUsuarios.add(new Usuario("Julia"));
        listaDeUsuarios.add(new Usuario("Laura"));
        listaDeUsuarios.add(new Usuario("Lucas"));
        listaDeUsuarios.add(new Usuario("Nicole"));

        ArrayList<String> listadeNomes= new ArrayList<>();
        for (Usuario usuario: listaDeUsuarios) {
            listadeNomes.add(usuario.nome);
        }
        System.out.println(listadeNomes);

        for (int i = 0; i < listadeNomes.size(); i++) {
            int delet = random.nextInt(18);
            listadeNomes.remove(delet/2);
            System.out.println(delet);
        }
        System.out.println(listadeNomes);
    }
}
