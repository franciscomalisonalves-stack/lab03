public class FilmNow {
    private Filme[] listaFilmes = new Filme[100];
    private Filme[] listaHots = new Filme[10];

    public String adicionarFilme(int idFilme, String nome, int anoLancamento, String streamer) {
        if(nome.equals("")|| streamer.equals("")){
            return "Filme inválido";
        }
        if (idFilme > 100 || idFilme < 1){
            return "Posição Invalida";
        }
        if(filmeJaAdicionado(filme)){
            return "Filme já Adicionao";
        }

    }
}
