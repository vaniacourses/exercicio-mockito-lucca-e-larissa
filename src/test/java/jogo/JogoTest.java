package jogo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JogoTest {

    private Jogador jogador;
    private Dado dado1;
    private Dado dado2;
    private Jogo jogo;

    @BeforeEach
    void inicializa() {
        jogador = mock(Jogador.class);
        dado1   = mock(Dado.class);
        dado2   = mock(Dado.class);
        jogo    = new Jogo(jogador, dado1, dado2);
    }

    @Test
    void ganhaNoPrimeiroTurnoCom7() {
        when(jogador.lancar(dado1, dado2)).thenReturn(7);
        assertTrue(jogo.jogo());
        verify(jogador, times(1)).lancar(dado1, dado2);
    }

    @Test
    void ganhaNoPrimeiroTurnoCom11() {
        when(jogador.lancar(dado1, dado2)).thenReturn(11);
        assertTrue(jogo.jogo());
        verify(jogador, times(1)).lancar(dado1, dado2);
    }

    @Test
    void perdeNoPrimeiroTurnoCom2() {
        when(jogador.lancar(dado1, dado2)).thenReturn(2);
        assertFalse(jogo.jogo());
        verify(jogador, times(1)).lancar(dado1, dado2);
    }

    @Test
    void perdeNoPrimeiroTurnoCom3() {
        when(jogador.lancar(dado1, dado2)).thenReturn(3);
        assertFalse(jogo.jogo());
        verify(jogador, times(1)).lancar(dado1, dado2);
    }

    @Test
    void perdeNoPrimeiroTurnoCom12() {
        when(jogador.lancar(dado1, dado2)).thenReturn(12);
        assertFalse(jogo.jogo());
        verify(jogador, times(1)).lancar(dado1, dado2);
    }

    @Test
    void ganhaRepetindoPontoNoSegundoTurno() {
        when(jogador.lancar(dado1, dado2))
            .thenReturn(5, 4, 6, 5); // ponto=5, depois repete
        assertTrue(jogo.jogo());
        verify(jogador, times(4)).lancar(dado1, dado2);
    }

    @Test
    void perdeTirando7NoSegundoTurno() {
        when(jogador.lancar(dado1, dado2))
            .thenReturn(6, 8, 7); // ponto=6, depois sai 7
        assertFalse(jogo.jogo());
        verify(jogador, times(3)).lancar(dado1, dado2);
    }
}
