package hash;

import java.util.Scanner;

public class HashMain {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		String texto;
		int chave;
		int continua = 0;

		MapaHash mapa = new MapaHash();

		Registro r;

		do {
			System.out.println("Informe uma chave para inserir: ");
			texto = ler.next();
			chave = Integer.parseInt(texto);
			System.out.println("Informe um valor para inserir: ");
			texto = ler.next();

			r = new Registro(chave, texto);
			mapa.put(r); // inserindo o novo registrado informado

			System.out.println("Deseja continuar? 1 - Sim / 0 - Não");
			continua = Integer.parseInt(ler.next());

		} while (continua != 0);

		System.out.println("----------------");

		do {

			System.out.println("Informe uma chave para buscar: ");
			chave = Integer.parseInt(ler.next());
			if (chave != -1) {
				r = mapa.get(chave);
				if (r != null) {
					System.out.println("Registro encontrado: " + r.getValue());
				} else {
					System.out.println("Não existe!");
				}
			}

		} while (chave != -1 || chave !=0);

	}

}
