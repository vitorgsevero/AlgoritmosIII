package pilhaDinamica;

public class Conversor {

	public static void main(String[] args) {
		
		int numero = 172;
		IPilha p = new PilhaDinamica();

		int resto; 

		// fase 1 = empilhamento dos restos
		while (numero != 0) {
			resto = numero % 2; // pega o resto da divisão desse nro por 2
			p.push(resto); // armazenando na pilha
			numero = numero / 2; // gerando um novo nro, resultado da divsão dele por 2
		}

		// fase 2 = exibição dos restos
		while (!p.isEmpty()) {
			resto = p.pop(); // resto recebendo a pilha sendo desempilhada
			System.out.println(resto);

		}
		System.out.println("Fim do programa!");	
	}

}
