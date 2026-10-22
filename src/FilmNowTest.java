import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmNowTest {

    private FilmNow filmNow;

    @BeforeEach
    public void setUp() {
        filmNow = new FilmNow();
    }

    // ==========================================
    // TESTES DE ADIÇÃO DE FILMES
    // ==========================================

    @Test
    public void testAdicionarFilmeComSucesso() {
        String resultado = filmNow.adicionarFilme(1, "Anatomia de uma Queda", 2023, "Cinema");
        assertEquals("Filme Adicionado", resultado);
    }

    @Test
    public void testAdicionarFilmePosicaoInvalida() {
        // Posição abaixo de 1
        assertEquals("Posição Invalida", filmNow.adicionarFilme(0, "Matrix", 1999, "HBO"));
        // Posição acima de 100
        assertEquals("Posição Invalida", filmNow.adicionarFilme(101, "Matrix", 1999, "HBO"));
    }

    @Test
    public void testAdicionarFilmeCamposVazios() {
        // Nome vazio
        assertEquals("Filme inválido", filmNow.adicionarFilme(1, "", 2023, "Cinema"));
        // Local/Streamer vazio
        assertEquals("Filme inválido", filmNow.adicionarFilme(1, "Pobres Criaturas", 2023, ""));
    }

    @Test
    public void testAdicionarFilmeJaAdicionado() {
        filmNow.adicionarFilme(1, "Shrek 2", 2004, "Netflix");
        // Tentando adicionar o mesmo filme (mesmo nome e ano) em outra posição
        String resultado = filmNow.adicionarFilme(2, "Shrek 2", 2004, "Prime Vídeo");
        assertEquals("Filme já Adicionado", resultado);
    }

    @Test
    public void testSubstituirFilmeExistente() {
        filmNow.adicionarFilme(1, "Filme Antigo", 2020, "Netflix");
        // Adicionar um novo filme na mesma posição 1 deve substituir o anterior
        String resultado = filmNow.adicionarFilme(1, "Filme Novo", 2021, "Cinema");
        assertEquals("Filme Adicionado", resultado);
        assertEquals("Filme Novo, 2021\nCinema", filmNow.detalharFilme(1));
    }

    // ==========================================
    // TESTES DE LISTAGEM GERAL
    // ==========================================

    @Test
    public void testListaDeFilmesVazia() {
        String[] lista = filmNow.listaDeFilmes();
        assertEquals(1, lista.length);
        assertEquals("Nenhum Filme Cadastrado", lista[0]);
    }

    @Test
    public void testListaDeFilmesComItens() {
        filmNow.adicionarFilme(1, "Anatomia de uma Queda", 2023, "Cinema");
        String[] lista = filmNow.listaDeFilmes();
        assertEquals(1, lista.length);
        assertEquals("1 - Anatomia de uma Queda", lista[0]);
    }

    // ==========================================
    // TESTES DE DETALHAR FILME
    // ==========================================

    @Test
    public void testDetalharFilmeComSucesso() {
        filmNow.adicionarFilme(1, "Anatomia de uma Queda", 2023, "Cinema");
        String detalhe = filmNow.detalharFilme(1);
        assertEquals("Anatomia de uma Queda, 2023\nCinema", detalhe);
    }

    @Test
    public void testDetalharFilmePosicaoInvalidaOuVazia() {
        // Posição vazia
        assertEquals("Posição Invalida", filmNow.detalharFilme(5));
        // Posição fora do intervalo
        assertEquals("Posição Invalida", filmNow.detalharFilme(0));
        assertEquals("Posição Invalida", filmNow.detalharFilme(105));
    }

    // ==========================================
    // TESTES DA HOTLIST
    // ==========================================

    @Test
    public void testAdicionarHotlistComSucesso() {
        filmNow.adicionarFilme(1, "Duna: Parte 2", 2024, "Cinema");
        String resultado = filmNow.adicionarHotlist(1, 1);
        assertEquals("ADICIONADO À HOTLIST NA POSIÇÃO 1!", resultado);
    }

    @Test
    public void testAdicionarHotlistFilmeNaoAdicionado() {
        // Tentando colocar na hotlist um ID que não possui filme cadastrado
        String resultado = filmNow.adicionarHotlist(10, 1);
        assertEquals("FILME NÃO ADICIONADO NA POSIÇÃO", resultado);
    }

    @Test
    public void testAdicionarHotlistPosicaoInvalida() {
        filmNow.adicionarFilme(1, "Duna: Parte 2", 2024, "Cinema");
        // Posição na hotlist acima de 10 ou abaixo de 1
        assertEquals("Posição Invalida", filmNow.adicionarHotlist(1, 11));
        assertEquals("Posição Invalida", filmNow.adicionarHotlist(1, 0));
    }

    @Test
    public void testAdicionarHotlistFilmeJaAdicionado() {
        filmNow.adicionarFilme(1, "Duna: Parte 2", 2024, "Cinema");
        filmNow.adicionarHotlist(1, 1);

        // Tentar adicionar o mesmo filme novamente na hotlist
        String resultado = filmNow.adicionarHotlist(1, 2);
        assertEquals("FILME JÁ ADICIONADO", resultado);
    }

    @Test
    public void testListaHotVazia() {
        String[] hotList = filmNow.listaHot();
        assertEquals(1, hotList.length);
        assertEquals("Nenhum Filme Cadastrado", hotList[0]);
    }

    @Test
    public void testListaHotComItens() {
        filmNow.adicionarFilme(1, "Shrek 2", 2004, "Netflix");
        filmNow.adicionarHotlist(1, 2);

        String[] hotList = filmNow.listaHot();
        assertEquals(1, hotList.length);
        assertEquals("1 - Shrek 2", hotList[0]);
    }

    @Test
    public void testDetalharFilmeHotComEmoji() {
        filmNow.adicionarFilme(1, "Anatomia de uma Queda", 2023, "Cinema");
        filmNow.adicionarHotlist(1, 1);

        // Quando o filme está na hotlist, o detalhamento deve incluir o emoji de fogo 🔥
        String detalhe = filmNow.detalharFilme(1);
        assertEquals("🔥 Anatomia de uma Queda, 2023\nCinema", detalhe);
    }

    @Test
    public void testRemoverHotListComSucesso() {
        filmNow.adicionarFilme(1, "Toy Story", 1995, "Disney+");
        filmNow.adicionarHotlist(1, 1);

        String resultado = filmNow.removeHotList(1);
        assertEquals("", resultado);
    }
}