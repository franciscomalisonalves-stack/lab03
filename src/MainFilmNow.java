import java.util.Locale;
import java.util.Scanner;

public class MainFilmNow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        final String MENU =
                "A - Adicionar filme ;\n"+
                "M - Mostrar todos ;\n"+
                "D - Detalhar filme;\n"+
                "E - Exibir HotList; \n"+
                "H - Atribuir Hot; \n"+
                "R - Remover Hot;\n" +
                "S - Sair;\n\n" +
                "Opção>";
        final String ADICIONAR_FILME = "A";
        final String MOSTRAR_TODOS = "M";
        final String DETALHAR_FILME = "D";
        final String EXIBIR_HOTLIST = "E";
        final String ATRIBUIR_HOT = "H";
        final String REMOVER_HOT = "R";
        final String SAIR = "S";
        String op;
        FilmNow sistema = new FilmNow();
        do{
            System.out.print(MENU);
            op = sc.nextLine().toUpperCase();
                switch (op){
                    case ADICIONAR_FILME:
                        adicionarFilme(sistema,sc);
                        break;
                    case MOSTRAR_TODOS:
                        listarFilmes(sistema);
                        break;
                    case DETALHAR_FILME:
                        detalharFilme(sistema,sc);
                        break;
                    case EXIBIR_HOTLIST:
                        listarHotList(sistema);
                        break;
                    case ATRIBUIR_HOT:
                        atribuirHot(sistema,sc);
                        break;
                    case REMOVER_HOT:
                        removerHot(sistema,sc);
                        break;
                    case SAIR:
                        break;
                    default:
                        System.out.println("OPÇÂO INVÁLIDA!");
                }
        }while(!op.equals(SAIR));
    }
    private static void adicionarFilme(FilmNow sistema, Scanner sc){
        System.out.print("Posição> ");
        int idFilme = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome> ");
        String nome = sc.nextLine();
        System.out.print("Ano> ");
        int anoLancamento = sc.nextInt();
        sc.nextLine();
        System.out.print("Local> ");
        String streamer = sc.nextLine();
        System.out.println(sistema.adicionarFilme(idFilme, nome.trim(),anoLancamento,streamer.trim())+"\n");
    }

    private static void listarFilmes(FilmNow sistema){
        String [] filmes = sistema.listaDeFilmes();

        for (String filme: filmes){
            System.out.println(filme);
        }
        System.out.println();

    }

    private static void detalharFilme(FilmNow sistema, Scanner sc){
        System.out.print("Posição> ");
        int idFilme = sc.nextInt();
        sc.nextLine();
        System.out.println(sistema.detalharFilme(idFilme)+"\n");
    }

    private static void listarHotList(FilmNow sistema){
        String [] filmes = sistema.listaHot();

        for (String filme: filmes){
            System.out.println(filme);
        }
        System.out.println();

    }

    private static void atribuirHot(FilmNow sistema, Scanner sc){
        System.out.print("Filme> ");
        int idFilme = sc.nextInt();
        System.out.print("Posição> ");
        int posicao = sc.nextInt();
        sc.nextLine();
        System.out.println(sistema.adicionarHotlist(idFilme,posicao)+"\n");
    }
    private static void removerHot(FilmNow sistema, Scanner sc){
        int posicao = sc.nextInt();
        sc.nextLine();
        System.out.println(sistema.removeHotList(posicao));
    }
}