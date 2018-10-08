package arvoreBinaria;

public class AppArvore {

	public static void main(String[] args) {
		
		Arvore arvore = new Arvore(new Elemento(10));
		
		arvore.inserir(new Elemento(5));
		arvore.inserir(new Elemento(1));
		arvore.inserir(new Elemento(8));
		arvore.inserir(new Elemento(15));
		arvore.inserir(new Elemento(12));
		arvore.inserir(new Elemento(18));
		
		System.out.println("O elemento 5 "+ ( arvore.busca(5) ? " existe": "não existe"));
		System.out.println("O elemento 12 "+ ( arvore.busca(12) ? " existe": "não existe"));
		System.out.println("O elemento 18 "+ ( arvore.busca(18) ? " existe": "não existe"));
		System.out.println("O elemento 34 "+ ( arvore.busca(34) ? " existe": "não existe"));

		arvore.imprimirPreOrdem();	
		System.out.println("");
		arvore.imprimirInOrdem();
		System.out.println("");
		arvore.imprimirPosOrdem();
	}

}
