package agenda.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * Painel que recebe os dados de novo evento de calendário.
 * 
 */
public class CadastroEventoPanel extends JPanel {
	private JTextField tfDescEvento;
	private JTextField tfDataDoEvento;
	private JTextField tfEncaminharEmail;

	/**
	 * Create the panel.
	 */
	public CadastroEventoPanel() {
		setLayout(null);
		
		JLabel lblDescEvento = new JLabel("Descrição do Evento");
		lblDescEvento.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDescEvento.setBounds(12, 12, 136, 15);
		add(lblDescEvento);
		
		tfDescEvento = new JTextField();
		tfDescEvento.setBounds(12, 27, 403, 20);
		add(tfDescEvento);
		tfDescEvento.setColumns(10);
		
		JLabel lblDataDoEvento = new JLabel("Data do evento");
		lblDataDoEvento.setBounds(12, 64, 115, 15);
		add(lblDataDoEvento);
		
		tfDataDoEvento = new JTextField();
		tfDataDoEvento.setBounds(160, 59, 114, 20);
		add(tfDataDoEvento);
		tfDataDoEvento.setColumns(10);
		
		JLabel lblEncaminharEmail = new JLabel("Encaminhar e-mail");
		lblEncaminharEmail.setBounds(12, 98, 136, 15);
		add(lblEncaminharEmail);
		
		tfEncaminharEmail = new JTextField();
		tfEncaminharEmail.setBounds(160, 93, 255, 20);
		add(tfEncaminharEmail);
		tfEncaminharEmail.setColumns(10);

	}
}
