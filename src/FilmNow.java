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
        Filme filme = new Filme(idFilme,nome,anoLancamento,streamer);
        if(filmeJaAdicionado(filme, false)){
            return "Filme já Adicionado";
        }
        listaFilmes[idFilme-1] = filme;
        return "Filme Adicionado";
    }

    public String[] listaDeFilmes(){
        int qtdFilmes = 0;
        for(Filme filme: listaFilmes){
            if(filme!= null){ qtdFilmes++;}
        }
        if (qtdFilmes == 0){return new String[]{"Nenhum Filme Cadastrado"};}

        String [] resultado = new String[qtdFilmes];
        int indice = 0;
        for(Filme filme: listaFilmes){
            if(filme != null){
                resultado[indice] = filme.toString();
                indice ++;
            }
        }
        return resultado;
    }

    public  String detalharFilme(int idFilme){
        if (idFilme > 100 || idFilme < 1){return "Posição Invalida";}

        Filme filme = listaFilmes[idFilme-1];

        if (filme == null){return "POSIÇÃO INVÁLIDA!";}
        return filme.detalhar();
    }

    public String [] listaHot(){
        int qtdFilmes = 0;
        for(Filme filme: listaHots){
            if(filme!= null){ qtdFilmes++;}
        }
        if (qtdFilmes == 0){return new String[]{"Nenhum Filme Cadastrado"};}

        String [] resultado = new String[qtdFilmes];
        int indice = 0;
        for(Filme filme: listaHots){
            if(filme != null){
                resultado[indice] = filme.toString();
                indice ++;
            }
        }
        return resultado;
    }

    public String adicionarHotlist(int idFilme ,int posicao){
        if (idFilme > 100 || idFilme < 1 || posicao > 10 || posicao < 1){return "Posição Invalida";}
        if (listaFilmes[idFilme- 1] == null){return "POSIÇÃO FILME INVALIDA";}

        Filme filme = listaFilmes[idFilme - 1];
        if (filmeJaAdicionado(filme, true)){return "FILME JÁ ADICIONADO";}

        if (listaHots[posicao-1] != null){
            listaHots[posicao-1].mudarIsHot(false);
            listaHots[posicao-1] = filme;
        }else{
         listaHots[posicao-1]= filme;
        }

        filme.mudarIsHot(true);

        return "ADICIONADO À HOTLIST NA POSIÇÃO " + posicao + "!";
    }
    public String removeHotList(int posicao){
        if(posicao> 10|| posicao< 1||listaHots[posicao] == null){return "posição inválida adcionada!";}
        listaHots[posicao-1].mudarIsHot(false);
        listaHots[posicao-1] = null;
        return "";
    }
    private boolean filmeJaAdicionado(Filme filme, boolean hotList){
        Filme [] lista;
        if(hotList){
            lista = listaHots;
        }else{
            lista = listaFilmes;
        }

        for (Filme filmesPresente: lista) {
            if (filme.equals(filmesPresente)) {
                return true;
            }
        }
        return false;
    }
}
