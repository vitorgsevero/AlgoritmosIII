package arvoreBinaria;

public class Arvore {

	private Elemento elemento;
	private Arvore direita;
	private Arvore esquerda;

	public Arvore() { // criando a arvore vazia
		this.elemento = null;
		this.direita = null;
		this.esquerda = null;
	}

	public Arvore(Elemento elemento) { // adicionando elemento na estrutura
		this.elemento = elemento;
		this.direita = null;
		this.esquerda = null;
		//System.out.println("Criando a arvore com o elemento " + elemento.getValor());
	}

	public boolean isEmpty() {
		return (this.elemento == null);
	}

	
	public void imprimirPreOrdem() {
		if(!isEmpty()) {
			System.out.print(this.elemento.getValor() + " ");
			if(this.esquerda != null) {
				this.esquerda.imprimirPreOrdem();
			}
			if(this.direita != null) {
				this.direita.imprimirPreOrdem();
			}
		}
	}
	
	public void imprimirInOrdem() {
		if(!isEmpty()) {
			if(this.esquerda != null) {
				this.esquerda.imprimirInOrdem();
			}
			System.out.print(this.elemento.getValor() + " ");
			if(this.direita != null) {
				this.direita.imprimirInOrdem();
			}
		}
	}
	
	public void imprimirPosOrdem() {
		if(!isEmpty()) {
			if(this.direita != null) {
				this.direita.imprimirPosOrdem();
			}
			if(this.esquerda != null) {
				this.esquerda.imprimirPosOrdem();
			}
			System.out.print(this.elemento.getValor() + " ");			
		}
	}
	
	
	public void inserir(Elemento novo) {
		if (isEmpty()) { // caso esteja vazia, o novo vai para o elemento que estava vazio
			this.elemento = novo;
		} else {

			Arvore novaArvore = new Arvore(novo); // caso a árvore não estiver vazia, devo criar uma nova arvore

			if (novo.getValor() < this.elemento.getValor()) { // se o meu novo valor for MENOR que o elemento, inserindo
																// na descendencia da ESQUERDA
				if (this.esquerda == null) { // primeira inserção do lado esquerdo
					this.esquerda = novaArvore;
					//System.out.println("Inseri o elemento " + novo.getValor() + " à esquerda de " + this.elemento.getValor());
				} else {
					this.esquerda.inserir(novo);
				}
			}

			else if (novo.getValor() > this.elemento.getValor()) { // inserindo na descendencia DIREITA
				if (this.direita == null) {
					this.direita = novaArvore;
					//System.out.println("Inseri o elemento " + novo.getValor() + " à direita de " + this.elemento.getValor());
				} else {
					this.direita.inserir(novo);
				}
			}
		}

	}
	
	
	public boolean busca(int valor) {
		if(isEmpty()) {
			return false;
		}
		if(this.elemento.getValor() == valor) {
			return true;
		}else{
			if(valor < this.elemento.getValor()) {
				if(this.esquerda == null) {
					return false;
				}else {
					return this.esquerda.busca(valor);
				}
			}
			else if(valor > this.elemento.getValor()) {
				if(this.direita == null) {
					return false;
				}else {
					return this.direita.busca(valor);
				}
			}
			return false;
		}
		
	}
	

	// encapsulamento

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public Arvore getDireita() {
		return direita;
	}

	public void setDireita(Arvore direita) {
		this.direita = direita;
	}

	public Arvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Arvore esquerda) {
		this.esquerda = esquerda;
	}

}
