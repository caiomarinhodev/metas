package controllers;

import models.EnumSemana;
import models.Meta;
import models.OrganizadorDeSemanas;
import models.dao.GenericDAO;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;

public class Application extends Controller {

	private static OrganizadorDeSemanas organizador = new OrganizadorDeSemanas();
	private static GenericDAO dao = new GenericDAO();
	
	@Transactional
    public static Result index() {
        return ok(views.html.index.render(organizador.getSemanas()));
    }

	@Transactional
    public static Result criarMeta(){
    	
    	DynamicForm form = Form.form().bindFromRequest();
    	
    	String nome = form.get("nome");
    	String descricao = form.get("descricao");
    	int prioridade = Integer.parseInt(form.get("prioridade"));
    	String semana = (String) form.get("semana");
    	
    	Meta meta = new Meta(nome, descricao, prioridade);
    	salvaObjeto(meta);
    	
    	organizador.criarMeta(meta, getEnumSemana(semana));  
    	
    	return index();
    } 

    @Transactional
	public static Result marcarMetaAlcancada(String nomeMeta){    	
    	for(int i = 0; i < organizador.getNumSemanas(); i++){
    		for(int j = 0; j < organizador.getSemanas().get(i).numeroDeMetasNaSemana(); j++ ){
    			if(nomeMeta.equals(organizador.getSemanas().get(i).getMetas().get(j).getNome())){
    				organizador.getSemanas().get(i).getMetas().get(j).marcarMeta();				
    			}
    		}    		
    	}
    	return index();
    }
    
	@Transactional
    public static Result deletarMeta(String nomeMeta){
    	
    	for(int i = 0; i < organizador.getNumSemanas(); i++){
    		for(int j = 0; j < organizador.getSemanas().get(i).numeroDeMetasNaSemana(); j++ ){
    			if(nomeMeta.equals(organizador.getSemanas().get(i).getMetas().get(j).getNome())){
    				organizador.getSemanas().get(i).getMetas().remove(j);				
    			}
    		}    		
    	}    	
    	return index();    	
    }
    
    @Transactional
	protected static void salvaObjeto(Object obj) {
		dao.persist(obj);
		dao.merge(obj);
		dao.flush();
	}
    
    private static EnumSemana getEnumSemana(String semana) {
		if(semana.equals("Semana 1")){
			return EnumSemana.SEMANA1;			
		} else if(semana.equals("Semana 2")){
			return EnumSemana.SEMANA2;
		} else if (semana.equals("Semana 3")) {
			return EnumSemana.SEMANA3;			
		} else if (semana.equals("Semana 4")) {
			return EnumSemana.SEMANA4;			
		} else if (semana.equals("Semana 5")) {
			return EnumSemana.SEMANA5;			
		} else if (semana.equals("Semana 6")) {
			return EnumSemana.SEMANA6;			
		}
		return null;
	}
}