package algoritmosOrdenacao;

public class QuickSort {
	
	int vetor[] = { 10, 15, 99, 52, 95, 7, 9};

	public int partition(int inicio, int fim) {

		int ref, up, down, aux;
		ref = vetor[inicio];
		down = inicio;
		up = fim;

		while (down < up) {
			while (vetor[down] <= ref && down < fim) { // verificando se o valor é maior do que a referência
				down++;
			}

			while (vetor[up] > ref) { // encontrando a partir do fim(up) um valor menor do que a referência
				up--;
			}

			if (down < up) {
				aux = vetor[down];
				vetor[down] = vetor[up];
				vetor[up] = aux;
			}
		}

		vetor[inicio] = vetor[up];
		vetor[up] = ref;
		return up;
	}

	public void quickSort(int inicio, int fim) {
		
		int pivo;
		if (inicio > fim) {
			return;
		}

		pivo = partition(inicio, fim);
		quickSort(inicio, pivo - 1);
		quickSort(pivo + 1, fim);
		mostraValor(vetor);

	}

	public void mostraValor(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println("");
	}

}
