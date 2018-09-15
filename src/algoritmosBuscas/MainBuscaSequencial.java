package algoritmosBuscas;

public class MainBuscaSequencial {

	public static void main(String[] args) {
		BuscaSequencialBinaria busca = new BuscaSequencialBinaria();
		
		System.out.println("Utilizando Busca Sequencial:");
		
		System.out.println("Posição do elemento 23: " + busca.buscaSequencial(23));
		System.out.println("Posição do elemento 12: " + busca.buscaSequencial(12));
		System.out.println("Posição do elemento 76: " + busca.buscaSequencial(76));
		System.out.println("Posição do elemento 99: " + busca.buscaSequencial(99));
		
		System.out.print("----------------------------");
		
		System.out.println("\nUtilizando Busca Binária:");
		
		System.out.println("Posição do elemento 23: " + busca.buscaBinaria(23));
		System.out.println("Posição do elemento 12: " + busca.buscaSequencial(12));
		System.out.println("Posição do elemento 76: " + busca.buscaBinaria(76));
		System.out.println("Posição do elemento 99: " + busca.buscaBinaria(99));
		
	}

}
