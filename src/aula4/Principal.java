package aula4;

public class Principal {

	public static void main(String[] args) {

		List lista = new List();
		
		lista.listar();
		
		lista.inserir(872);
		lista.inserir(123);
		lista.inserir(1597);
		lista.inserir(2);
		
		lista.listar();
		
		while(!lista.isEmpty()) {
			int e = lista.remover();
			System.out.println("Removendo o elemento: " + e);
		}
		
		lista.listar();
		

	}

}
