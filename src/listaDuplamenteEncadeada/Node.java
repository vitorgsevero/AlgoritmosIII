package listaDuplamenteEncadeada;

public class Node<T>{

	private T elemento;
	private Node anterior;
	private Node proximo;
	
	public Node(T elemento) {
		this.elemento = elemento;
		this.anterior = null;
		this.proximo = null;
	}
	
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	
	public void setAnterior(Node anterior) {
		this.anterior = anterior;
	}
	
	public void setProximo(Node proximo) {
		this.proximo = proximo;
	}
	
	public T getElemento() {
		return this.elemento;
	}
	
	public Node getAnterior() {
		return this.anterior;
	}
	
	public Node getProximo() {
		return this.proximo;
	}
	
	
	
	
}
