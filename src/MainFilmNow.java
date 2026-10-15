import java.util.Scanner;

public class MainFilmNow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        final String MENU = "\n***\n"+
                "A - Adicionar filme ;\n"+
                "M - Mostrar todos ;\n"+
                "D - Detalhar filme;\n"+
                "E - Exibir HotList; \n"+
                "H - Atribuir Hot; \n"+
                "R - Remover Hot;\n" +
                "S - Sair;\n" +
                "\n" +
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
            System.out.println(MENU);
            op = sc.next();
                switch (op){
                    case ADICIONAR_FILME:
                        break;
                    case MOSTRAR_TODOS:
                        break;
                    case DETALHAR_FILME:
                        break;
                    case EXIBIR_HOTLIST:
                        break;
                    case ATRIBUIR_HOT:
                        break;
                    case REMOVER_HOT:
                        break;
                    case SAIR:
                        break;
                    default:
                        System.out.println("OPÇÂO INVÁLIDA!");
                }
        }while(!op.equals(SAIR));
    }
}