package fila;

public class Banco {

	public static void main(String[] args) {

	Fila f;
	int aux;
	f = new Fila();
	
	f.inserir(176);
	f.inserir(914);
	f.inserir(12);
	f.inserir(874);
	f.inserir(100);
	f.inserir(0);
	f.inserir(1);
	f.inserir(2);
	f.inserir(4);
	f.inserir(8);
	
	
	
	f.setFim(0);
	f.inverterFila();
	f.setInicio(0);
	
	System.out.println("Bem-vindos ao Banco!");
	
	while(!f.isEmpty()) {
		aux = f.remover();
		System.out.println("Senha a ser atendida: " + aux);
	}
	

		
		
		
		
	}

}
