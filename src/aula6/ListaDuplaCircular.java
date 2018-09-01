package aula6;

public class ListaDuplaCircular<T>{

	private Node inicio;
	private Node fim;
	
	public ListaDuplaCircular() { //Criacao da Lista
		this.setInicio(null);
		this.setFim(null);
	}
	
	
	public void insereNoInicio(T elemento) {
		
		Node novo = new Node(elemento); //Acrescenta um novo node inserindo o elemento
		
		if(inicio == null){ //Caso a lista esteja vazia, o FIM recebe o novo elemento inserido
			fim = novo;
		}else{ //senao
			novo.setProximo(inicio); //como está inserindo no inicio, o próximo do novo elemento inserido será o atual inicio 
			inicio.setAnterior(novo); //agora, estamos apontando o novo elemento inserido como o anterior do atual inicio
		}
			inicio = novo; //após isso, o inicio passa a ser o novo elemento inserido
		
	}
	
	public void insereNoFim(T elemento) {
		
		Node novo = new Node(elemento);
		
		if(fim == null) { //Caso a lista esteja vazia, o INICIO recebe o novo elemento inserido
			inicio = novo;
		}else { //senao
			novo.setAnterior(fim); //como está inserindo no fim, o anterior do novo elemento inserido será o atual fim
			fim.setProximo(novo); //agora, estamos apontando o novo elemento inserido como o proximo do atual fim
		}
		
		fim = novo; //após isso, o fim passa a ser o novo elemento inserido
	}
	
	
	public void removeNoInicio(){
		if(inicio == fim){ //Caso a lista tenha apenas um elemento, o inicio e fim (mesmo elemento) passam a ser vazios pois o unico elemento que existia foi removido
			inicio = null;
			fim = null;
		}else{ //senao
			inicio = inicio.getProximo(); //avançamos o inicio para o proximo elemento
			inicio.setAnterior(null); //para que o inicio anterior seja removido (recebendo null e nao tendo nenhum apontamento o elemento é removido	)
		}
	}
	
	public void removeNoFim() { //Caso a lista tenha apenas um elemento, o inicio e fim (mesmo elemento) passam a ser vazios pois o unico elemento que existia foi removido
		if(inicio == fim) {
			inicio = null;
			fim = null;
		}else { //senao
			fim = fim.getAnterior(); //voltamos o fim para o elemento anterior
			fim.setProximo(null); //para que o próximo elemento(antigo fim) seja null 
		}
	}
	

	
	public boolean isEmpty() {
		return (this.getInicio() == null);
	}
	
	/*public void inserir (int elemento) {
		
		Node novo = new Node();
		novo.setElemento(elemento);
		
		if(isEmpty()) { //Primeira inserção, caso a lista esteja vazia o inicio e o fim apontam para o primeiro elemento que foi inserido
			novo.setProximo(novo);
			novo.setAnterior(novo);
			this.setInicio(novo);
		}else {
			Node tmp = getInicio();
			while(tmp.getProximo() != getInicio()) { //Condição para saber se a lista não está voltando para o início
				tmp = tmp.getProximo(); //Avançando para o próximo elemento
			}
			getInicio().setAnterior(novo); 
			tmp.setProximo(novo); //Passando o novo elemento como o próximo
			novo.setAnterior(tmp); //Passando tmp como o anterior do novo elemento
			novo.setProximo(getInicio()); //Passando o inicio para o novo elemento, já que depois dele não tem ninguém e volta para o início da lista
		}
			
	}*/
	
	public void exibirNaOrdem() {
		
		Node tmp;
		tmp = getInicio();
		
		do{
			System.out.println("Elemento da Lista: " + tmp.getElemento());
			tmp = tmp.getProximo(); //após o elemento ser exibido, passo o próximo para que ele tb seja exibido
		}while(tmp!=null);
	}
	
	public void exibirNaOrdemInversa() {
		
		Node tmp;
		tmp = getInicio();
		
		do {
			System.out.println("Elemento da Lista: " + tmp.getElemento());
			tmp = tmp.getAnterior();
		}while(tmp!=null);
		
		
	}

	//Encapsulamento
	
	private Node getFim() {
		return fim;
	}

	private void setFim(Node fim) {
		this.fim = fim;
	}

	private Node getInicio() {
		return inicio;
	}

	private void setInicio(Node inicio) {
		this.inicio = inicio;
	}

	
}
