package jogo;

public class Jogo {

	    private final Jogador jogador;
    private final Dado dado1;
    private final Dado dado2;

    // Construtor recebe as dependências (injeção de dependência)
    public Jogo(Jogador jogador, Dado dado1, Dado dado2) {
        this.jogador = jogador;
        this.dado1 = dado1;
        this.dado2 = dado2;
    }
	
	/*
	 * Se for o primeiro turno e a soma das faces dos dados cair 7 ou 11 voc� ganha o jogo;
	 * Se for o primeiro turno e a soma das faces dos dados cair 2, 3 e 12 voc� perde o jogo; 
	 * Se n�o cair nenhum desses valores, o valor � armazenado e passa para o segundo turno;
	 * Se for o segundo turno e a soma das faces dos dados cair 7 novamente, voc� perde o jogo;
	 * Se for o segundo turno, voc� continuando jogando os dados e s� ganha se cair um numero igual ao anterior do primeiro turno;
	 */
	public boolean jogo(){
		
		Jogador jogador = new Jogador();
		Dado dadinho1 = new Dado();
		Dado dadinho2 = new Dado();
		
		int resultado = jogador.lancar(dadinho1, dadinho2);
		
		if(resultado == 7 || resultado == 11) {
			return true;
		}else if(resultado == 2 || resultado == 3 || resultado == 12){
			return false;
		}
		
		int ponto = resultado;
		
		resultado = jogador.lancar(dadinho1, dadinho2);
	
		while(resultado != ponto && resultado != 7){
			resultado = jogador.lancar(dadinho1, dadinho2);
		}
		
		return resultado == ponto;
		
	}
}


package jogo;

public class Jogo {

    private final Jogador jogador;
    private final Dado dado1;
    private final Dado dado2;

    // Construtor recebe as dependências (injeção de dependência)
    public Jogo(Jogador jogador, Dado dado1, Dado dado2) {
        this.jogador = jogador;
        this.dado1 = dado1;
        this.dado2 = dado2;
    }

    public boolean jogo() {
        int resultado = jogador.lancar(dado1, dado2);

        if (resultado == 7 || resultado == 11) {
            return true; // vitória no primeiro turno
        } else if (resultado == 2 || resultado == 3 || resultado == 12) {
            return false; // derrota no primeiro turno
        }

        int ponto = resultado;

        resultado = jogador.lancar(dado1, dado2);

        while (resultado != ponto && resultado != 7) {
            resultado = jogador.lancar(dado1, dado2);
        }

        return resultado == ponto; // ganha se repetir o ponto, perde se sair 7
    }
}
