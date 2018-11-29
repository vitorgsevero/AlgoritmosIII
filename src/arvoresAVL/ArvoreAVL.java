package arvoresAVL;

public class ArvoreAVL {

	private Elemento elemento;
	private ArvoreAVL direita;
	private ArvoreAVL esquerda;
	private int balanceamento;

	public ArvoreAVL() { // criando a arvore vazia
		this.elemento = null;
		this.direita = null;
		this.esquerda = null;
		this.balanceamento = 0;
	}

	public ArvoreAVL(Elemento elemento) { // adicionando elemento na estrutura
		this.elemento = elemento;
		this.direita = null;
		this.esquerda = null;
		this.balanceamento = 0;
	}

	// calcular a altura

	public int calcularAltura() {
		if (this.esquerda == null && this.direita == null) {
			return 1;
		} else if (this.esquerda != null && this.direita == null) {
			return 1 + this.esquerda.calcularAltura();
		} else if (this.esquerda == null && this.direita != null) {
			return 1 + this.direita.calcularAltura();
		} else {
			return 1 + Math.max(this.esquerda.calcularAltura(), this.direita.calcularAltura());
		}
	}

	public void calcularBalanceamento() {
		if (this.direita == null && this.esquerda == null) {
			this.balanceamento = 0;
		} else if (this.esquerda == null && this.direita != null) {
			this.balanceamento = this.direita.calcularAltura() - 0;
		} else if (this.esquerda != null && this.direita == null) {
			this.balanceamento = 0 - this.esquerda.calcularAltura();
		} else {
			this.balanceamento = this.direita.calcularAltura() - this.esquerda.calcularAltura();
		}

		if (this.direita != null) this.direita.calcularBalanceamento();
		if (this.esquerda != null) this.esquerda.calcularBalanceamento();
		
	}

	// metodos de verificação e rotacao

	public ArvoreAVL verificaBalanceamento() {
		if (this.balanceamento >= 2 || this.balanceamento <= -2) {
			if (this.balanceamento >= 2) {
				if (this.balanceamento * this.direita.getBalanceamento() > 0) {
					System.out.println("Rotação Simples a Direita");
					return rotacaoSimplesDireita();
				} else {
					System.out.println("Rotação Dupla a Direita");
					return rotacaoDuplaDireita();
				}	
			} else {
				if (this.balanceamento * this.esquerda.getBalanceamento() > 0) {
					System.out.println("Rotação Simples a Esquerda");
					return rotacaoSimplesEsquerda();
				} else {
					System.out.println("Rotação Dupla a Esquerda");
					return rotacaoDuplaEsquerda();
				}
			}
		}
		this.calcularBalanceamento();
		
		if (this.esquerda != null) this.esquerda = this.esquerda.verificaBalanceamento();
		if (this.direita != null) this.direita = this.direita.verificaBalanceamento();
		
		return this;
	}

	public ArvoreAVL rotacaoSimplesDireita() {
		ArvoreAVL filhoDireita;
		ArvoreAVL filhoDoFilho = null;

		filhoDireita = this.getDireita();

		if (this.direita != null) {
			if (this.direita.getEsquerda() != null) { // se o meu filho a direita tem filhos a esquerda
				filhoDoFilho = filhoDireita.getEsquerda();
			}
		}
		filhoDireita.setEsquerda(this);
		this.setDireita(filhoDoFilho);

		return filhoDireita;

	}

	public ArvoreAVL rotacaoDuplaDireita() {
		ArvoreAVL arvore = this;
		ArvoreAVL filhoDireita = this.getDireita();
		ArvoreAVL filhoDoFilho = filhoDireita.getEsquerda();
		ArvoreAVL noInserido = filhoDoFilho.getDireita();

		// parte 01 - alinhando os elementos inseridos

		filhoDireita.setEsquerda(noInserido);
		filhoDoFilho.setDireita(filhoDireita);
		this.setDireita(filhoDoFilho);

		// parte 02 - tornar o filho a direita a nova raiz

		ArvoreAVL novoFilhoDireita = this.getDireita();
		arvore.setDireita(null);
		novoFilhoDireita.setEsquerda(arvore);
		return novoFilhoDireita;
	}

	public ArvoreAVL rotacaoSimplesEsquerda() {
		ArvoreAVL filhoEsquerda;
		ArvoreAVL filhoDoFilho = null;

		filhoEsquerda = this.getEsquerda();

		if (this.esquerda != null) {
			if (this.esquerda.getDireita() != null) { // se o meu filho a esquerda tem filhos a direita
				filhoDoFilho = filhoEsquerda.getDireita();
			}
		}
		filhoEsquerda.setDireita(this);
		this.setEsquerda(filhoDoFilho);

		return filhoEsquerda;
	}

	public ArvoreAVL rotacaoDuplaEsquerda() {
		ArvoreAVL arvore = this;
		ArvoreAVL filhoEsquerda= this.getEsquerda();
		ArvoreAVL filhoDoFilho = filhoEsquerda.getDireita();
		ArvoreAVL noInserido = filhoDoFilho.getEsquerda();

		// parte 01 - alinhando os elementos inseridos

		filhoEsquerda.setDireita(noInserido);
		filhoDoFilho.setEsquerda(filhoEsquerda);
		this.setEsquerda(filhoDoFilho);

		// parte 02 - tornar o filho a esquerda a nova raiz

		ArvoreAVL novoFilhoEsquerda = this.getEsquerda();
		arvore.setEsquerda(null);
		novoFilhoEsquerda.setDireita(arvore);
		return novoFilhoEsquerda;

	}

	// removendo elementos da arvore

	public ArvoreAVL remover(Elemento elemento) {
		// primeiro caso - achei o elemento raiz da arvore
		if (this.elemento.getValor() == elemento.getValor()) {
			// caso mais simples - elemento na folha, sem filhos
			if (this.direita == null && this.esquerda == null) {
				return null;
			} // caso 02 - filhos a esquerda, mas sem filhos a direita
			else {
				if (this.esquerda != null && this.direita == null) {
					return this.esquerda;
				} // caso 03 - filhos a direita, mas sem filhos a esquerda
				else if (this.direita != null && this.esquerda == null) {
					return this.direita;
				} // caso 04 - filhos na direita e esquerda
				else { // utilizando o maior dentro os menores para remover o primeiro elemento da
						// arvore
					ArvoreAVL aux = this.esquerda;
					while (aux.direita != null) { // enquanto tiver filhos na direita
						aux = aux.direita;
					} // trocando os elementos da arvore
					this.elemento = aux.getElemento(); // nó atual recebe o elemento de aux
					aux.setElemento(elemento); // insiro o no folha no fim para que o elemento seja removido
					this.esquerda = esquerda.remover(elemento);
				}
			}

		} else if (elemento.getValor() < this.elemento.getValor()) {
			// passar a responsabilidade para a sub arvore da esquerda
			this.esquerda = this.esquerda.remover(elemento);
		} else if (elemento.getValor() > this.elemento.getValor()) {
			// passar a responsabilidade para a sub arvore da direita
			this.direita = this.direita.remover(elemento);
		}

		return this;
	}

	// isEmpty

	public boolean isEmpty() {
		return (this.elemento == null);
	}

	// imprindo os elementos da arvore em ordem

	public void imprimirPreOrdem() {
		if (!isEmpty()) {
			System.out.print(this.elemento.getValor() + " ");
			if (this.esquerda != null) {
				this.esquerda.imprimirPreOrdem();
			}
			if (this.direita != null) {
				this.direita.imprimirPreOrdem();
			}
		}
	}

	public void imprimirInOrdem() {
		if (!isEmpty()) {
			if (this.esquerda != null) {
				this.esquerda.imprimirInOrdem();
			}
			System.out.print(this.elemento.getValor() + " ");
			if (this.direita != null) {
				this.direita.imprimirInOrdem();
			}
		}
	}

	public void imprimirPosOrdem() {
		if (!isEmpty()) {
			if (this.direita != null) {
				this.direita.imprimirPosOrdem();
			}
			if (this.esquerda != null) {
				this.esquerda.imprimirPosOrdem();
			}
			System.out.print(this.elemento.getValor() + " ");
		}
	}

	// inserindo elemento na arvore

	public ArvoreAVL inserir(Elemento novo) {
		if (isEmpty()) { // caso esteja vazia, o novo vai para o elemento que estava vazio
			this.elemento = novo;
		} else {

			ArvoreAVL novaArvore = new ArvoreAVL(novo); // caso a árvore não estiver vazia, devo criar uma nova arvore

			if (novo.getValor() < this.elemento.getValor()) { // se o meu novo valor for MENOR que o elemento, inserindo
																// na descendencia da ESQUERDA
				if (this.esquerda == null) { // primeira inserção do lado esquerdo
					this.esquerda = novaArvore;
					// System.out.println("Inseri o elemento " + novo.getValor() + " à esquerda de "
					// + this.elemento.getValor());
				} else {
					this.esquerda = this.esquerda.inserir(novo);
				}
			}

			else if (novo.getValor() > this.elemento.getValor()) { // inserindo na descendencia DIREITA
				if (this.direita == null) {
					this.direita = novaArvore;
					// System.out.println("Inseri o elemento " + novo.getValor() + " à direita de "
					// + this.elemento.getValor());
				} else {
					this.direita = this.direita.inserir(novo);
				}
			}
		}
		return this;
	}

	public boolean busca(int valor) {
		if (isEmpty()) {
			return false;
		}
		if (this.elemento.getValor() == valor) {
			return true;
		} else {
			if (valor < this.elemento.getValor()) {
				if (this.esquerda == null) {
					return false;
				} else {
					return this.esquerda.busca(valor);
				}
			} else if (valor > this.elemento.getValor()) {
				if (this.direita == null) {
					return false;
				} else {
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

	public ArvoreAVL getDireita() {
		return direita;
	}

	public void setDireita(ArvoreAVL direita) {
		this.direita = direita;
	}

	public ArvoreAVL getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(ArvoreAVL esquerda) {
		this.esquerda = esquerda;
	}

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}

	// exibindo a arvore balanceada

	public String printArvore(int level) {
		String str = this.toString() + "\n";
		// esquerda
		for (int i = 0; i < level; i++) {
			str += "\t";
		}
		if (this.esquerda != null) {
			str += "+-ESQ: " + this.esquerda.printArvore(level + 1);
		} else {
			str += "+-ESQ: VAZIO";
		}
		str += "\n";
		// direita
		for (int i = 0; i < level; i++) {
			str += "\t";
		}
		if (this.direita != null) {
			str += "+-DIR: " + this.direita.printArvore(level + 1);
		} else {
			str += "+-DIR: VAZIO";
		}
		str += "\n";
		return str;
	}

	public String toString() {
		return "[" + this.elemento.getValor() + "] (" + this.balanceamento + ")";
	}

}
