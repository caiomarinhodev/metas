package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class OrganizadorDeSemanas {
	
	
	@Id
	@GeneratedValue
	private long id;	
	@ManyToMany
	private List<Semana> semanas;
	private final int NUM_SEMANAS = 6;
	
	public OrganizadorDeSemanas(){		
		semanas = new ArrayList<Semana>(NUM_SEMANAS);
		for(int i = 0; i < NUM_SEMANAS; i++){
			semanas.add(new Semana("Semana " + (i+1)));
		}		
	}	

	public int getNumSemanas() {
		return NUM_SEMANAS;
	}

	public void criarMeta(Meta meta, EnumSemana semana){		
		semanas.get(semana.getValor()).addMeta(meta);		
	}
	
	public List<Semana> getSemanas(){
		return semanas;		
	}
}