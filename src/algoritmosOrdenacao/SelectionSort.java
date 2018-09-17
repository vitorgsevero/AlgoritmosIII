package algoritmosOrdenacao;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

	public static void main(String[] args) {
		
	int []vetor = gerarVetor(20);
	System.out.println("Exibindo o vetor com os valores gerados: " + Arrays.toString(vetor));
	selectionSort(vetor);
	System.out.println("Exibindo o vetor ordenado (Selection Sort): " + Arrays.toString(vetor));
	
	}
	
	private static void selectionSort(int[] vetor) {
		for(int i=0; i<vetor.length; i++) {
			int menor = i;
			for(int j = i+1; j<vetor.length; j++) { //busca pelo menor elemento
				if(vetor[j] < vetor[menor]) {
					menor = j;
				}
				trocar(vetor, i, menor);
			}
		}
		
	}
	
	
	private static void trocar(int[] vetor, int i, int menor) {
		int aux = vetor[i];
		vetor[i] = vetor[menor];
		vetor[menor] = aux;
		
	}

	public static int[] gerarVetor(int n){
			int []vetor = new int[n];
			Random geraValor = new Random();
			for(int i=0; i<n; i++) {
				vetor[i] = geraValor.nextInt(100);
			}
			return vetor;
	}


}
