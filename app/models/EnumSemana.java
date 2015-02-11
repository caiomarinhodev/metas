package models;

public enum EnumSemana {
		
	SEMANA1(0), SEMANA2(1), SEMANA3(2), SEMANA4(3), SEMANA5(4), SEMANA6(5);

	private final int valor;
	
	private EnumSemana(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}		
}
