package pilhaDinamica;

public class PilhaDinamica implements IPilha{

	private Node topo;
	
	public PilhaDinamica() {
		topo = null;
	}
	
	public void push(int elemento) {
		Node newNode = new Node();
		newNode.setElemento(elemento);
		newNode.setNext(topo);
		topo = newNode;
		
		
	}
	
	public int pop() {
		int elemento = topo.getElemento();
		topo = topo.getNext();
		return elemento;
	}
	
	public boolean isEmpty() {
		return (topo == null);
	}
	
	
}
