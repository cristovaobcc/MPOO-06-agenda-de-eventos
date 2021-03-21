package agenda.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;

/**
 * Painel que recebe os dados de novo evento de calendário.
 * 
 */
public class CadastroEventoPanel extends JPanel {
	private JTextField tfDescEvento;
	private JTextField tfDataDoEvento;
	private JTextField tfEncaminharEmail;
	private final ButtonGroup buttonGroupPeriodicidade = new ButtonGroup();
	private ListaEventosPanel listaEventosPanel;


	/**
	 * Create the panel.
	 */
	public CadastroEventoPanel(ListaEventosPanel listaEventosPanel) {
		this.listaEventosPanel = listaEventosPanel;
		
		setLayout(null);
		
		JLabel lblDescEvento = new JLabel("Descrição do Evento");
		lblDescEvento.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDescEvento.setBounds(12, 12, 136, 15);
		add(lblDescEvento);
		
		tfDescEvento = new JTextField();
		tfDescEvento.setBounds(12, 27, 454, 20);
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
		
		JLabel lblPeriodicidadeDoEvento = new JLabel("Periodicidade do evento");
		lblPeriodicidadeDoEvento.setBounds(12, 125, 178, 15);
		add(lblPeriodicidadeDoEvento);
		
		JRadioButton rdbUmaVez = new JRadioButton("Uma vez");
		buttonGroupPeriodicidade.add(rdbUmaVez);
		rdbUmaVez.setBounds(204, 125, 84, 23);
		add(rdbUmaVez);
		
		JRadioButton rdbSemanal = new JRadioButton("Semanal");
		buttonGroupPeriodicidade.add(rdbSemanal);
		rdbSemanal.setBounds(292, 125, 86, 23);
		add(rdbSemanal);
		
		JRadioButton rdbMensal = new JRadioButton("Mensal");
		buttonGroupPeriodicidade.add(rdbMensal);
		rdbMensal.setBounds(382, 125, 84, 23);
		add(rdbMensal);
		
		JCheckBox ckbAlarme = new JCheckBox("Alarme");
		ckbAlarme.setBounds(8, 163, 129, 23);
		add(ckbAlarme);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(160, 162, 117, 25);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(318, 162, 117, 25);
		add(btnLimpar);

	}
}
