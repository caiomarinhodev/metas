import static org.junit.Assert.*;
import models.EnumSemana;
import models.Meta;
import models.OrganizadorDeSemanas;
import org.junit.Before;
import org.junit.Test;


public class MetasSemanaisTest {
	
	private static final  int NUM_SEMANAS = 6;
	private static OrganizadorDeSemanas organizador;
	private static Meta meta;
	
	@Before
	public void setUp() {
		organizador = new OrganizadorDeSemanas();		
		meta = new Meta("Estudar Métodos", "Prova dia 18", 5);
	}

	@Test
	public void deveIniciarComSeisSemanasVazias() {
		
		assertTrue(organizador.getNumSemanas() == NUM_SEMANAS);	
		
		for(int i = 0; i < NUM_SEMANAS; i++) {
			assertTrue(organizador.getSemanas().get(i).isEmpty());			
		}
	}
	
	@Test
	public void deveAdicionarMetaNasSemanas() {
		
		organizador.criarMeta(new Meta("Lab de SI1", "Completar esta tarefa antes de tudo!", 5), EnumSemana.SEMANA1);
		organizador.criarMeta(new Meta("Estudar ATAL", "Sempre tem miniteste", 5), EnumSemana.SEMANA2);
		organizador.criarMeta(new Meta("Estudar Métodos", "Prova dia 18", 5), EnumSemana.SEMANA3);
		organizador.criarMeta(new Meta("PLP", "Estudar para a prova em grupo", 5), EnumSemana.SEMANA4);
		organizador.criarMeta(new Meta("Viajar", "Com a família! o//", 5), EnumSemana.SEMANA5);
		organizador.criarMeta(new Meta("Correção do Lab 2 de SI1", "", 5), EnumSemana.SEMANA6);
		
		for(int i = 0; i < NUM_SEMANAS; i++) {
			assertFalse(organizador.getSemanas().get(i).isEmpty());			
		}		
	}
	
	@Test
	public void deveConseguirMarcarEDesmarcarMeta() {
		
		assertFalse(meta.ehMetaAlcancada());
		meta.marcarMeta();
		assertTrue(meta.ehMetaAlcancada());
		meta.marcarMeta();
		assertFalse(meta.ehMetaAlcancada());
	}
	
	@Test
	public void deveConseguirExcluirMeta() {
		
		organizador.criarMeta(new Meta("Lab de SI1", "Completar esta tarefa antes de tudo!", 5), EnumSemana.SEMANA1);
		organizador.criarMeta(new Meta("Estudar ATAL", "Sempre tem miniteste", 5), EnumSemana.SEMANA2);
		organizador.criarMeta(new Meta("Estudar Métodos", "Prova dia 18", 5), EnumSemana.SEMANA3);
		organizador.criarMeta(new Meta("PLP", "Estudar para a prova em grupo", 5), EnumSemana.SEMANA4);
		organizador.criarMeta(new Meta("Viajar", "Com a família! o//", 5), EnumSemana.SEMANA5);
		organizador.criarMeta(new Meta("Correção do Lab 2 de SI1", "", 5), EnumSemana.SEMANA6);
	
		for(int i = 0; i < NUM_SEMANAS; i++) {
			organizador.getSemanas().get(i).getMetas().remove(0);
			assertTrue(organizador.getSemanas().get(i).isEmpty());
		}
		
	}
}