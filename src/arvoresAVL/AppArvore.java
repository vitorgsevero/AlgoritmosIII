package arvoresAVL;

import java.util.Scanner;

public class AppArvore {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		ArvoreAVL arvore = new ArvoreAVL(new Elemento(ler.nextInt()));
		arvore.calcularBalanceamento();
		arvore = arvore.verificaBalanceamento();
		System.out.println(arvore.printArvore(0));

		while(true) {
			arvore = arvore.inserir(new Elemento(ler.nextInt()));
			arvore.calcularBalanceamento();
			arvore = arvore.verificaBalanceamento();
			System.out.println(arvore.printArvore(0));
		}
		
		
	}

}
