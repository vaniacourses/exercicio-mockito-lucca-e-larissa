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

}
