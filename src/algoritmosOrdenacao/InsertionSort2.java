package algoritmosOrdenacao;

public class InsertionSort2 {

	public static void main(String[] args) {

		int elemento, i, j;

		int vetor[] = { 10, 35, 27, 99, 55, 78, 12, 5, 66, 3 };

		for (i = 1; i < vetor.length; i++) { // iteracao recebe o elemento da vez e vou pegar os elementos maiores
			elemento = vetor[i];
			for (j = i - 1; j >= 0 && vetor[j] > elemento; j--) {
				vetor[j + 1] = vetor[j];
			}
			vetor[j + 1] = elemento;

			System.out.println("\n   Iteração   " + i);
			mostraValor(vetor);
		}
		
	}
	
	private static void mostraValor(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println("");
	}
	
	

}
