package aula5;

public class Node {
	
	private int elemento;
	private Node next;
	
	public int getElemento() {
		return this.elemento;
	}
	
	public int setElemento (int elemento) {
		return this.elemento = elemento;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	
}
