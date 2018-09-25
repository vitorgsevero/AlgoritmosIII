package hash;

public class MapaHash {

	private Registro valores[];

	public MapaHash() {
		valores = new Registro[100];
	}

	public void put(Registro registro) {

		int posicao = registro.hashCode();

		if (valores[posicao] == null) { // caso a posição esteja vazia, o registro é inserido
			valores[posicao] = registro;
			System.out.println("Posição vazia, novo registro");
		} else { // senão
			System.out.println("Colisão encontrada...");
			Registro reg = valores[posicao];
			// para tratar o primeiro elemento
			if (reg.getKey() == registro.getKey()) { // caso o registro que desejo inserir já exista
				reg.setValue(registro.getValue()); // mudo apenas o valor
				System.out.println("Primeiro Registro existente - atualizando...");
				return;
			}
			// se o registro está no meio da lista
			while (reg.getProximo() != null) {
				if (reg.getKey() == registro.getKey()) { // caso o registro que desejo inserir já exista
					reg.setValue(registro.getValue()); // mudo apenas o valor
					System.out.println("Meio da lista - Registro existente - atualizando...");
					return;
				}
					reg = reg.getProximo();
			}
			// se o registro é o último da lista
				if (reg.getKey() == registro.getKey()) {
					reg.setValue(registro.getValue());
					System.out.println("Último - Registro existente - atualizando...");
					return;
				}

				reg.setProximo(registro); // coloquei o novo registro na última posição
				System.out.println("Novo registro!");

		}
	}

	public Registro get(int key) {
		Registro r = new Registro();
		r.setKey(key);
		int posicao = r.hashCode();
		Registro resultado = valores[posicao];
		if (resultado != null && resultado.getKey() == key) { // retorna o resultado caso seja o que está sendo procurado
			return resultado;
		} else { // caso não seja o procurado
			while (resultado != null) { // enquanto tiver registros
				resultado = resultado.getProximo(); // avanço para o próximo
				if (resultado != null && resultado.getKey() == key) { // pergunto se agora é o registro desejado
					return resultado; // caso seja, o registro é retornado... caso não seja, retorna para o while e
										// avança o próximo mais uma vez
				}
			}
		}
		return null;
	}

}
