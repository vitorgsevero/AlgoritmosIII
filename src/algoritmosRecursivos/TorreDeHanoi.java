package algoritmosRecursivos;

import java.util.Scanner;

public class TorreDeHanoi {

	// Método que realiza (imprime) o movimento
	// de um disco entre dois pinos
	private static void mover(int pinoOrigem, int pinoDestino) {
		System.out.println("Peça do pino -->   " + pinoOrigem + "   VAI PARA   " + pinoDestino + "   <-- Peça do pino");
	}

	// Método que implementa a recursão
	
	//PINO ORIGEM -> primeiro pino - pino da ponta esquerda
	//PINO DESTINO -> terceiro pino - pino da ponta direita
	//PINO TRABALHO -> pino de trabalho - segundo pino - pino do meio
	
	static void hanoi(int numeroDiscos, int pinoOrigem, int pinoDestino, int pinoTrabalho) {

		if (numeroDiscos > 0) {
			hanoi(numeroDiscos - 1, pinoOrigem, pinoTrabalho, pinoDestino);
			mover(pinoOrigem, pinoDestino);
			hanoi(numeroDiscos - 1, pinoTrabalho, pinoDestino, pinoOrigem);
		}

	}

	// executando o hanoi
	public static void main(String[] args) {

		int numeroDiscos=0; 

		// recebe o número de discos digitado pelo usuário
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o número de discos: ");
		numeroDiscos = scan.nextInt();

		// executa o hanoi!
		TorreDeHanoi.hanoi(numeroDiscos, 1, 3, 2);
	}
}
