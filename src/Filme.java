import java.util.Objects;

public class Filme {
    private final int idFilme;
    private final String nome;
    private final int anoLancamento;
    private final String streamer;
    private boolean isHot = false;

    public Filme(int idFilme, String nome, int anoLancamento, String streamer){
        this.idFilme = idFilme;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.streamer = streamer;
    }

    public void mudarIsHot(boolean isHot){
        this.isHot = isHot;
    }

    public String detalhar(){
        if(isHot){
            return "\uD83D\uDD25 " + nome + ", " + anoLancamento + "\n" + streamer;
        }
        return nome + ", " + anoLancamento + "\n" + streamer;
    }

    @Override
    public String toString(){
        return idFilme + " - " + nome;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Filme outro = (Filme) obj;
        return Objects.equals(this.nome, outro.nome) && Objects.equals(this.anoLancamento, outro.anoLancamento);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nome, anoLancamento);
    }
}
