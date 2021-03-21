package agenda.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import agenda.io.AgendaIO;
import agenda.utils.AgendaUtils;
import agenda.utils.PeriodicidadeEnum;
import agenda.vo.Evento;

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
	private JCheckBox ckbAlarme;
	private JRadioButton rdbUmaVez;
	private JRadioButton rdbSemanal;
	private JRadioButton rdbMensal;
	private JButton btnSalvar;
	private JButton btnLimpar;

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
		
		rdbUmaVez = new JRadioButton("Uma vez");
		buttonGroupPeriodicidade.add(rdbUmaVez);
		rdbUmaVez.setBounds(204, 125, 84, 23);
		add(rdbUmaVez);
		
		rdbSemanal = new JRadioButton("Semanal");
		buttonGroupPeriodicidade.add(rdbSemanal);
		rdbSemanal.setBounds(292, 125, 86, 23);
		add(rdbSemanal);
		
		rdbMensal = new JRadioButton("Mensal");
		buttonGroupPeriodicidade.add(rdbMensal);
		rdbMensal.setBounds(382, 125, 84, 23);
		add(rdbMensal);
		
		ckbAlarme = new JCheckBox("Alarme");
		ckbAlarme.setBounds(8, 163, 129, 23);
		add(ckbAlarme);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(160, 162, 117, 25);
		add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(318, 162, 117, 25);
		add(btnLimpar);
		
		this.cadastraListeners();

	}
	
	/**
	 * Cadastra listeners para os botões salvar e limpar.
	 */
	private void cadastraListeners() {
		this.btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamaCadastroEvento();
				
			}
		});
		
		
		this.btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				
			}
		});
	}
	
	
	private void chamaCadastroEvento() {
		
		AgendaIO agendaIO = new AgendaIO();
		Evento evento = new Evento();
		
		Object[] novaLinha = new Object[5];
		
		String dataString = tfDataDoEvento.getText();
		evento.setDataEvento(AgendaUtils.getDateFromString(dataString));
		evento.setDescEvento(tfDescEvento.getText());
		evento.setAlarme(ckbAlarme.isSelected() ? 1 : 0);
		evento.setEmailEncaminhar(tfEncaminharEmail.getText());
		
		
		novaLinha[0] = tfDataDoEvento.getText();
		novaLinha[1] = tfDescEvento.getText();
		novaLinha[3] = tfEncaminharEmail.getText();
		novaLinha[4] = ckbAlarme.isSelected() ? "LIGADO" : "DESLIGADO";
		
		if(rdbUmaVez.isSelected()) {
			evento.setPeriodicidade(PeriodicidadeEnum.UNICO);
			novaLinha[2] = PeriodicidadeEnum.UNICO;
		} else if (rdbSemanal.isSelected()) {
			evento.setPeriodicidade(PeriodicidadeEnum.SEMANAL);
			novaLinha[2] = PeriodicidadeEnum.SEMANAL;
		} else {
			evento.setPeriodicidade(PeriodicidadeEnum.MENSAL);
			novaLinha[2] = PeriodicidadeEnum.MENSAL;
		}
		
		try {
			agendaIO.gravarEvento(evento);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO", e.getMessage(), JOptionPane.ERROR_MESSAGE);
			
		}
		
		listaEventosPanel.addNewRow(novaLinha);
		limparCampos();
		
	}
	
	/**
	 * Limpa os campos de CadastroEventoPanel.
	 */
	private void limparCampos() {
		tfDataDoEvento.setText("");
		tfDescEvento.setText("");
		ckbAlarme.setSelected(false);
		tfEncaminharEmail.setText("");
		rdbUmaVez.setSelected(true);
	}
}
