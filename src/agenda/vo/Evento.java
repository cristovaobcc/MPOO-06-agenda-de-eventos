package agenda.vo;

import java.io.Serializable;
import java.util.Date;

import agenda.utils.PeriodicidadeEnum;

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
	
	
	public Evento() {}
	
	/**
	 * Cria um objeto Evento.
	 * 
	 * @param dataEvento Date
	 * @param descEvento String
	 * @param periodicidade {@link PeriodicidadeEnum}
	 * @param emailEncaminhar String
	 * @param alarme int
	 */
	public Evento(Date dataEvento, String descEvento, PeriodicidadeEnum periodicidade, String emailEncaminhar,
			int alarme) {
		this.dataEvento = dataEvento;
		this.descEvento = descEvento;
		this.periodicidade = periodicidade;
		this.emailEncaminhar = emailEncaminhar;
		this.alarme = alarme;
	}

	/**
	 * @return the dataEvento
	 */
	public Date getDataEvento() {
		return dataEvento;
	}

	/**
	 * @param dataEvento the dataEvento to set
	 */
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	/**
	 * @return the descEvento
	 */
	public String getDescEvento() {
		return descEvento;
	}

	/**
	 * @param descEvento the descEvento to set
	 */
	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	/**
	 * @return the periodicidade
	 */
	public PeriodicidadeEnum getPeriodicidade() {
		return periodicidade;
	}

	/**
	 * @param periodicidade the periodicidade to set
	 */
	public void setPeriodicidade(PeriodicidadeEnum periodicidade) {
		this.periodicidade = periodicidade;
	}

	/**
	 * @return the emailEncaminhar
	 */
	public String getEmailEncaminhar() {
		return emailEncaminhar;
	}

	/**
	 * @param emailEncaminhar the emailEncaminhar to set
	 */
	public void setEmailEncaminhar(String emailEncaminhar) {
		this.emailEncaminhar = emailEncaminhar;
	}

	/**
	 * @return the alarme
	 */
	public int getAlarme() {
		return alarme;
	}

	/**
	 * @param alarme the alarme to set
	 */
	public void setAlarme(int alarme) {
		this.alarme = alarme;
	}
	
		
	

}
