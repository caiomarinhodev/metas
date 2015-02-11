package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Semana {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@OneToMany
	private List<Meta> metas;
	
	public Semana() {
		metas = new ArrayList<Meta>();	
	}
	
	public Semana(String nome){
		this();
		this.nome = nome;
	}
	
	public boolean isEmpty(){
		if(metas.size() > 0){
			return false;
		}	
		return true;
	}

	public String getNome() {
		return nome;
	}

	public List<Meta> getMetas() {
		return metas;
	}
	
	public int numeroDeMetasNaSemana(){
		return metas.size();
	}
	
	public int numeroDeMetasAlcancadas(){
		int count = 0;
		for(int i = 0; i < metas.size(); i++){
			if(metas.get(i).ehMetaAlcancada()){
				count ++;
			}
		}
		return count;
	}
	
	public int numeroDeMetasNaoAlcancadas(){
		return metas.size() - numeroDeMetasAlcancadas();
	}
	
	public void addMeta(Meta meta){
		metas.add(meta);
		Collections.sort(this.getMetas());
	}
}
