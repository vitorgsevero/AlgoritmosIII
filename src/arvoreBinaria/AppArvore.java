package arvoreBinaria;

public class AppArvore {

	public static void main(String[] args) {
		
		Arvore arvore = new Arvore(new Elemento(10));
		Elemento elemento = new Elemento(0);
				
		arvore.inserir(new Elemento(20));
		arvore.inserir(new Elemento(10));
		arvore.inserir(new Elemento(5));
		arvore.inserir(new Elemento(2));
		arvore.inserir(new Elemento(8));
		arvore.inserir(new Elemento(15));
		arvore.inserir(new Elemento(12));
		arvore.inserir(new Elemento(18));
		arvore.inserir(new Elemento(30));
		arvore.inserir(new Elemento(25));
		arvore.inserir(new Elemento(22));
		arvore.inserir(new Elemento(28));
		arvore.inserir(new Elemento(35));
		arvore.inserir(new Elemento(32));
		arvore.inserir(new Elemento(38));
		
		
		arvore.imprimirInOrdem();
		System.out.println("");
		
		elemento.setValor(38);
		arvore = arvore.remover(elemento);
		System.out.println("Nova árvore:");
		arvore.imprimirInOrdem();
		System.out.println("");
		
		elemento.setValor(35);
		arvore = arvore.remover(elemento);
		System.out.println("Nova árvore:");
		arvore.imprimirInOrdem();
		System.out.println("");
	

		elemento.setValor(20);
		arvore = arvore.remover(elemento);
		System.out.println("Nova árvore:");
		arvore.imprimirInOrdem();
		System.out.println("");
		
	}

}
