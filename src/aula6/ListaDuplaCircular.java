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
			novo.setProximo(inicio); //como est� inserindo no inicio, o pr�ximo do novo elemento inserido ser� o atual inicio 
			inicio.setAnterior(novo); //agora, estamos apontando o novo elemento inserido como o anterior do atual inicio
		}
			inicio = novo; //ap�s isso, o inicio passa a ser o novo elemento inserido
		
	}
	
	public void insereNoFim(T elemento) {
		
		Node novo = new Node(elemento);
		
		if(fim == null) { //Caso a lista esteja vazia, o INICIO recebe o novo elemento inserido
			inicio = novo;
		}else { //senao
			novo.setAnterior(fim); //como est� inserindo no fim, o anterior do novo elemento inserido ser� o atual fim
			fim.setProximo(novo); //agora, estamos apontando o novo elemento inserido como o proximo do atual fim
		}
		
		fim = novo; //ap�s isso, o fim passa a ser o novo elemento inserido
	}
	
	
	public void removeNoInicio(){
		if(inicio == fim){ //Caso a lista tenha apenas um elemento, o inicio e fim (mesmo elemento) passam a ser vazios pois o unico elemento que existia foi removido
			inicio = null;
			fim = null;
		}else{ //senao
			inicio = inicio.getProximo(); //avan�amos o inicio para o proximo elemento
			inicio.setAnterior(null); //para que o inicio anterior seja removido (recebendo null e nao tendo nenhum apontamento o elemento � removido	)
		}
	}
	
	public void removeNoFim() { //Caso a lista tenha apenas um elemento, o inicio e fim (mesmo elemento) passam a ser vazios pois o unico elemento que existia foi removido
		if(inicio == fim) {
			inicio = null;
			fim = null;
		}else { //senao
			fim = fim.getAnterior(); //voltamos o fim para o elemento anterior
			fim.setProximo(null); //para que o pr�ximo elemento(antigo fim) seja null 
		}
	}
	

	
	public boolean isEmpty() {
		return (this.getInicio() == null);
	}
	
	/*public void inserir (int elemento) {
		
		Node novo = new Node();
		novo.setElemento(elemento);
		
		if(isEmpty()) { //Primeira inser��o, caso a lista esteja vazia o inicio e o fim apontam para o primeiro elemento que foi inserido
			novo.setProximo(novo);
			novo.setAnterior(novo);
			this.setInicio(novo);
		}else {
			Node tmp = getInicio();
			while(tmp.getProximo() != getInicio()) { //Condi��o para saber se a lista n�o est� voltando para o in�cio
				tmp = tmp.getProximo(); //Avan�ando para o pr�ximo elemento
			}
			getInicio().setAnterior(novo); 
			tmp.setProximo(novo); //Passando o novo elemento como o pr�ximo
			novo.setAnterior(tmp); //Passando tmp como o anterior do novo elemento
			novo.setProximo(getInicio()); //Passando o inicio para o novo elemento, j� que depois dele n�o tem ningu�m e volta para o in�cio da lista
		}
			
	}*/
	
	public void exibirNaOrdem() {
		
		Node tmp;
		tmp = getInicio();
		
		do{
			System.out.println("Elemento da Lista: " + tmp.getElemento());
			tmp = tmp.getProximo(); //ap�s o elemento ser exibido, passo o pr�ximo para que ele tb seja exibido
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
