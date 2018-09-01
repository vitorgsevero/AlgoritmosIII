package aula6;

public class MyApp {

	public static void main(String[] args) {
		
		ListaDuplaCircular lista = new ListaDuplaCircular();
		

		lista.insereNoInicio(1);
		lista.insereNoInicio(2);
		lista.insereNoFim(10);
		lista.insereNoFim(100);
		
		lista.exibirNaOrdem();
		
		System.out.println("Removendo o último elemento");
		
		lista.removeNoFim();
		
		lista.exibirNaOrdem();
		
		System.out.println("Removendo o primeiro elemento");
		
		lista.removeNoInicio();
		
		lista.exibirNaOrdem();
		

		
	}

}
