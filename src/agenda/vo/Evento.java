package agenda.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Representa um evento de agenda e contém seus dados de data, descrição, periodicidade, email para
 * encaminhar e alarme.
 * 
 *
 */
public class Evento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date dataEvento;
	private String descEvento;
	private PeriodicidadeEnum periodicidade;
	private String emailEncaminhar;
	private int alarme;
	
		
	

}
