package hash;

public class MapaHash {

	private Registro valores[];

	public MapaHash() {
		valores = new Registro[100];
	}

	public void put(Registro registro) {

		int posicao = registro.hashCode();

		if (valores[posicao] == null) { // caso a posi��o esteja vazia, o registro � inserido
			valores[posicao] = registro;
			System.out.println("Posi��o vazia, novo registro");
		} else { // sen�o
			System.out.println("Colis�o encontrada...");
			Registro reg = valores[posicao];
			// para tratar o primeiro elemento
			if (reg.getKey() == registro.getKey()) { // caso o registro que desejo inserir j� exista
				reg.setValue(registro.getValue()); // mudo apenas o valor
				System.out.println("Primeiro Registro existente - atualizando...");
				return;
			}
			// se o registro est� no meio da lista
			while (reg.getProximo() != null) {
				if (reg.getKey() == registro.getKey()) { // caso o registro que desejo inserir j� exista
					reg.setValue(registro.getValue()); // mudo apenas o valor
					System.out.println("Meio da lista - Registro existente - atualizando...");
					return;
				}
					reg = reg.getProximo();
			}
			// se o registro � o �ltimo da lista
				if (reg.getKey() == registro.getKey()) {
					reg.setValue(registro.getValue());
					System.out.println("�ltimo - Registro existente - atualizando...");
					return;
				}

				reg.setProximo(registro); // coloquei o novo registro na �ltima posi��o
				System.out.println("Novo registro!");

		}
	}

	public Registro get(int key) {
		Registro r = new Registro();
		r.setKey(key);
		int posicao = r.hashCode();
		Registro resultado = valores[posicao];
		if (resultado != null && resultado.getKey() == key) { // retorna o resultado caso seja o que est� sendo procurado
			return resultado;
		} else { // caso n�o seja o procurado
			while (resultado != null) { // enquanto tiver registros
				resultado = resultado.getProximo(); // avan�o para o pr�ximo
				if (resultado != null && resultado.getKey() == key) { // pergunto se agora � o registro desejado
					return resultado; // caso seja, o registro � retornado... caso n�o seja, retorna para o while e
										// avan�a o pr�ximo mais uma vez
				}
			}
		}
		return null;
	}

}
