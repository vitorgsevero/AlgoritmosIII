package aula5;
public class Pilha implements IPilha {
	
	private int valores[];
	private int topo;
	
	
	public Pilha(){ // Construtor
		
		this.valores = new int[10];
		this.topo = -1; 
		
	}
	
	public void push(int elemento){ // Empilhar
		
		this.topo++; //Avança uma posição para que a anterior seja ocupada pelo elemento
		this.valores[topo] = elemento;
			
	}
	
	public boolean isEmpty(){ // Verifica se está vazia
		
		return (this.topo == -1);
		
	}
	
	public boolean isFull(){ // Verifica se está cheia
		
		return (this.topo == 9);
	}
	
	public int pop(){ // Desempilhar
		
		int elemento = valores[topo];
		topo--;
		return elemento;
		
		
	}
	
	
	
}