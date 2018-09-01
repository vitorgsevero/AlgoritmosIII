package aula3;

import aula02.Pilha;


public class Fila {

	private int[] valores;
	private int inicio;
	private int fim;
	private int total;
	
	public Fila() { //Construtor
		valores = new int[10];
		this.inicio = 0;
		this.fim = 0;
		this.total = 0;
	}
	
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

	public void inserir(int elemento) {
		
		valores[fim] = elemento; //insere no fim
		fim++; // acrescenta mais uma posicao vazia para que seja o novo fim
		total++; //variavel de controle incrementando	
		
	}
	
	public int remover() {
		
		int elemento = valores[inicio]; //removendo o primeiro a ser inserido
		inicio++; //avanca a posicao para o mais recente que foi inserido
		total--; //variavel de controle decrementando
		
		return elemento;
	}
	
	public void inverterFila() {
		
		Pilha p = new Pilha();
		
	    while(isEmpty()!=true) {
	    	
	    	int elemento;
	    		
	    	elemento = remover();
	    	
	    	p.push(elemento);
	    	
	    }
	    
	    while(isFull()!=true) {
	    	inserir(p.pop());
	    }
		
	}
	
	public boolean isEmpty() {
		return (this.total==0); //retorna a fila na primeira posicao (se esta igual a 0 significa que nada foi inserido no momento)
	}
	
	public boolean isFull() {
		return (this.total==10); //retorna a fila cheia, em sua ultima posicao
	}
	
	
	
	
}
