package agenda.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import agenda.vo.Evento;

/**
 * Classe que grava e lê  Eventos de um arquivo texto. Cada evento é gravado em uma linha.
 * 
 *
 */
public class AgendaIO {
	
	private final String DIRETORIO = ".";
	private final String ARQUIVO = "eventos.txt";
	
	/**
	 * Grava um evento em uma linha do arquivo.
	 * @param evento Evento 
	 * @throws Exception
	 */
	public void gravarEvento(Evento evento) throws Exception{
		
		try {
			
			File file = new File(DIRETORIO, ARQUIVO);
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			writer.write(evento.toString(), 0, evento.toString().length());
			writer.newLine();
			writer.close();
			
		} catch(FileNotFoundException fnfe) {
			
			throw new Exception("Arquivo não encontrado.");
			
		} catch (Exception e) {
			
			throw new Exception("Problemas na gravação do arquivo");
		}
	}

}
