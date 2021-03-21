package agenda.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import agenda.io.AgendaIO;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Lista os eventos cadastrados no sistema.
 * 
 */
public class ListaEventosPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListaEventosPanel() {
		setLayout(new BorderLayout(0, 0));
		
		table = new JTable(getDataColumns(), getNameColumns());
		JScrollPane scrollPane = new JScrollPane(table);
		//scrollPane.add(table);
		
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	
	/**
	 * Inclui os valores individualmente numa linha na tabela deste ListaEventosPanel.
	 * @param valores Object[]
	 */
	public void addNewRow(Object[] valores) {
		DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
		dtm.addRow(valores);
	}
	
	/**
	 * Devolve um vector com os nomes das colunas.
	 * @return Vector< String >
	 */
	private Vector<String> getNameColumns(){
		Vector<String> nameColumns = new Vector<String>();
		nameColumns.add("Data");
		nameColumns.add("Descrição");
		nameColumns.add("Periodicidade");
		nameColumns.add("E-mail");
		nameColumns.add("Alarme");
		return nameColumns;
	}
	
	/**
	 * Devolve os dados de eventos em arquivo txt.
	 * @return Vector< {@link Vector}< Object> >
	 */
	private Vector<Vector<Object>> getDataColumns(){
		AgendaIO agendaIO = new AgendaIO();
		Vector<Vector<Object>> dataColumns = null;
		
		try {
			dataColumns = agendaIO.getEventos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro", e.getMessage(),
			JOptionPane.ERROR_MESSAGE);
		}
		
		return dataColumns;
	}
	
	
	
}
