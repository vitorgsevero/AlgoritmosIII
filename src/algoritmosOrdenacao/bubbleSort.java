package algoritmosOrdenacao;

public class bubbleSort {

	public static void main(String[] args) {

		int vet[] = new int[10];
		int aux = 0;

		vet[0] = 10;
		vet[1] = 8;
		vet[2] = 50;
		vet[3] = 15;
		vet[4] = 61;
		vet[5] = 5;
		vet[6] = 49;
		vet[7] = 73;
		vet[8] = 12;
		vet[9] = 21;
		
		System.out.println("Exibindo o vetor desordenado.");

		for (int j = 0; j < vet.length; j++) {// EXIBINDO O VETOR DESORDENADO
			System.out.println(vet[j]);
		}

		for (int i = 0; i < vet.length; i++) { // BUBBLE SORT PARA ORDENAR O VETOR POR TAMANHO NA ORDEM CRESCENTE
			for (int j = 0; j < vet.length - 1; j++) {
				if (vet[j] > vet[j + 1]) {
					aux = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = aux;
				}
			}
		}

		System.out.println("Exibindo o vetor ordenado.");
		
		for (int j = 0; j < vet.length; j++) {// EXIBINDO O VETOR ORDENADO
			System.out.println(vet[j]);
		}

	}
}