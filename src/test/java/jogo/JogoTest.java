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
        Jogador jogador = mock(Jogador.class);
        Dado dado1   = mock(Dado.class);
        Dado dado2   = mock(Dado.class);
        Jogo jogo = new Jogo(jogador, dado1, dado2);
    }

    @Test
    void ganhaNoPrimeiroTurnoCom7() {
        when(jogador.lancar((Dado.class), (Dado.class))).thenReturn(7);
        assertTrue(jogo.jogo());
        verify(jogador, times(1)).lancar(dado1, dado2);
    }

    @Test
    void ganhaNoPrimeiroTurnoCom11() {
        when(jogador.lancar((Dado.class), (Dado.class))).thenReturn(11);
        assertTrue(jogo.jogo());
        verify(jogador, times(1)).lancar(dado1, dado2);
    }

    @Test
    void perdeNoPrimeiroTurnoCom2() {
        when(jogador.lancar((Dado.class), (Dado.class))).thenReturn(2);
        assertFalse(jogo.jogo());
        verify(jogador, times(1)).lancar(dado1, dado2);
    }

    @Test
    void perdeNoPrimeiroTurnoCom3() {
        when(jogador.lancar((Dado.class), (Dado.class))).thenReturn(3);
        assertFalse(jogo.jogo());
        verify(jogador, times(1)).lancar(dado1, dado2);
    }

    @Test
    void perdeNoPrimeiroTurnoCom12() {
        when(jogador.lancar((Dado.class), (Dado.class))).thenReturn(12);
        assertFalse(jogo.jogo());
        verify(jogador, times(1)).lancar(dado1, dado2);
    }

}
