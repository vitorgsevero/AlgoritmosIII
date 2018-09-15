package algoritmosBuscas;

public class BuscaSequencialBinaria {

	private int valores[] = { 11, 12, 23, 27, 33, 43, 56, 76, 87, 97};

	public int buscaSequencial(int valor) { //normalmente possui maior nro de iteracoes que a binaria, a menos que o elemento procurado seja um dos primeiros
		int posicao;
		for(posicao=0; posicao<valores.length; posicao++) {
			if(valor == valores[posicao]) {
				return posicao; //retorna a posicao do elemento	
			}
			
		}
		return -1; //caso a posicao seja invalida (elemento nao encontrado)
	}
	
	public int buscaBinaria(int valor) {//normalmente possui menor nro de iteracoes que a sequencial, a menos que o elemento procurado seja um dos primeiros
		int meio;
		int inicio=0;
		int fim = valores.length-1; //ultima posicao, nao tamanho
		
		while(inicio<=fim) {
			meio = (inicio+fim)/2;
			if(valor==valores[meio]) {
				return meio;
			}else {
				if(valor>valores[meio]) {
					inicio = meio+1;
				}else {
					fim = meio-1;
				}
			}
		}
		return -1;
	}
	
	

}
