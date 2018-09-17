package algoritmosOrdenacao;

public class InsertionSort {

	public static void main(String[] args) {
		
		int vetor[] = new int[10];
		int aux;
		int j;
		
		vetor[0] = 10;
		vetor[1] = 8;
		vetor[2] = 50;
		vetor[3] = 15;
		vetor[4] = 61;
		vetor[5] = 5;
		vetor[6] = 49;
		vetor[7] = 73;
		vetor[8] = 12;
		vetor[9] = 21;

		for (int i=1; i<vetor.length; i++) {

			aux = vetor[i];
			j = i;

			while ((j > 0) && (vetor[j - 1] > aux)) {
				vetor[j] = vetor[j - 1];
				j -= 1;
			}
			
			vetor[j] = aux;

		}
		
		System.out.println("Exibindo o vetor ordenado.");
		
		for (j = 0; j < vetor.length; j++) {// EXIBINDO O VETOR ORDENADO
			System.out.println(vetor[j]);
		}


	}

}
