package agenda.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;

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
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.add(table);
		
		

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

}
