package agenda.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import agenda.utils.PeriodicidadeEnum;
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
	
	
	/**
	 * Recupera de um txt ("eventos.txt") os eventos registrados.
	 * @return {@link Vector}< {@link Vector}< Object > >
	 * @throws Exception
	 */
	public Vector<Vector<Object>> getEventos() throws Exception{
		
		Vector<Vector<Object>> lista = new Vector<Vector<Object>>();
		
		try {
			
			File file = new File(DIRETORIO, ARQUIVO);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String linha = bufferedReader.readLine();
			Vector<Object> eventoVector = null;
			while( linha != null) {
				
				eventoVector = new Vector<Object>();
				String[] tokens = linha.split(";");
				
				eventoVector.add(tokens[0]); // Data
				eventoVector.add(tokens[1]); // Descrição do evento
				eventoVector.add(PeriodicidadeEnum.valueOf(tokens[2])); // Periodicidade
				eventoVector.add(tokens[3]); // Email para encaminhar
				eventoVector.add(tokens[4].equals("1") ? "LIGADO" : "DESLIGADO"); // alarme
				
				lista.add(eventoVector);
				linha = bufferedReader.readLine();
			}
			
			bufferedReader.close();
			
		} catch(FileNotFoundException fnfe) {
			
			throw new Exception("Arquivo não encontrado.");
			
		} catch(Exception ex) {
			
			throw new Exception("Problemas de leitura no arquivo de eventos.");
		}
		
		
		return lista;
	}

}
