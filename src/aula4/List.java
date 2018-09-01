package aula4;

public class List {
	
	private Node inicio;
	
	public List() { //criando a lista vazia
		this.inicio = null;
	}
	
	public void inserir(int elemento) { 
		Node newNode = new Node();
		newNode.setElemento(elemento); //inserir o elemento no no
		newNode.setNext(null); //depois dela nao vem ninguem
		
		if(inicio==null) { //vai ser a primeira insercao
			this.inicio = newNode;
		}else { //ja foi inserido dados na lista
			
			Node aux;
			aux = inicio;
			
			while(aux.getNext()!=null) { //enquanto tiver alguem 
				aux = aux.getNext(); //o elemento passa a ser o proximo
			}
			
			aux.setNext(newNode);
			
		}
		
	}
	
	public int remover() {
		 
		Node aux = inicio;
		int elemento = aux.getElemento();
		inicio = aux.getNext();
		
		return elemento;
		
	}
	
	public void listar() {
		
		if (this.inicio==null) {
			System.out.println("Lista vazia.");
		}else {
			Node aux = inicio;
			while(aux!=null) {
				System.out.println("Elemento:" + aux.getElemento());
				aux = aux.getNext();
			}
		}
	}
	
	public boolean isEmpty() {
		return this.inicio==null;
	}

}
