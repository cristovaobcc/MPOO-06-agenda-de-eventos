/**
 * 
 */
package agenda.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe com metódos utilitários para a aplicação de Agenda.
 *
 */
public class AgendaUtils {
	
	/**
	 * Devolve uma Date de uma string dataStr.
	 * @param dataStr String
	 * @return Date
	 */
	public static Date getDateFromString(String dataStr) {
		Calendar data = Calendar.getInstance();
		data.set(Calendar.YEAR, Integer.parseInt(dataStr.substring(6, 10)));
		data.set(Calendar.MONTH, Integer.parseInt(dataStr.substring(3,5)));
		data.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataStr.substring(0,2)));
		
		return data.getTime();
	}

}
