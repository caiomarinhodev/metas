package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import scala.util.control.Exception;

@Entity
public class Meta implements Comparable<Meta> {

	@Id
	@GeneratedValue
	private long id;
	private String nome, descricao;
	private int prioridade;
	private boolean metaAlcancada;
	
	public Meta() {
		
	}
	
	public Meta(String nome, String descricao, int prioridade){
		this.nome = nome;
		this.descricao = descricao;
		this.prioridade =  prioridade;
		this.metaAlcancada = false;
	}

	public long getId(){
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public void marcarMeta(){
		if(this.metaAlcancada){
			this.metaAlcancada =  false;
		} else {
			this.metaAlcancada =  true;
		}		
	}

	public boolean ehMetaAlcancada(){
		return this.metaAlcancada;
	}
	
	@Override
	public int compareTo(Meta meta) {
		if (this.getPrioridade() < meta.getPrioridade()){
			return 1;
		}
		else if (this.getPrioridade() > meta.getPrioridade()) {
			return -1;
		}
		return 0;
	}
}