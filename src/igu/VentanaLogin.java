package igu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class VentanaLogin extends JFrame implements KeyListener {

	private JPanel contentPane;
	private JPanel panel_TituloImagen;
	private JPanel panelLoginRegistro;
	private JPanel panelDatos;
	private JPanel panelBotones;
	private JLabel labelNombreUsuario;
	private JLabel labelContrase�a;
	private JPanel panel_NombreUsuario;
	private JPanel panel_inputNombreUsuario;
	private JPanel panel_Contrase�a;
	private JPanel panel_inputContrase�a;
	private JPanel panel_InputCentrado;
	private JTextField inputNombreUsuario;
	private JPanel panel_InputContrase�aCentrado;
	private JButton btnIniciarSesion;
	private JPanel panelBotonRegistro;
	private JPanel panelBotonIniciarSesion;
	private JPanel panel_Title;
	private JPanel panel_Foto;
	private JLabel lblAgenciaDeEmpleo;
	private JLabel labelFoto;
	private JButton btnRegistrarse;
	private JPasswordField passwordField;
	private ActionListener actionlistener;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setTitle("Agencia de Empleo ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 479);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.BLACK);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.panel_TituloImagen = new JPanel();
		this.panel_TituloImagen.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		this.contentPane.add(this.panel_TituloImagen);
		this.panel_TituloImagen.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_Title = new JPanel();
		this.panel_Title.setBackground(SystemColor.inactiveCaption);
		this.panel_Title.setPreferredSize(new Dimension(30, 30));
		this.panel_TituloImagen.add(this.panel_Title);
		this.panel_Title.setLayout(new GridLayout(1, 1, 0, 0));
		
		this.lblAgenciaDeEmpleo = new JLabel("Agencia de Empleo \"Grupo 3\"");
		this.lblAgenciaDeEmpleo.setBackground(SystemColor.inactiveCaption);
		this.lblAgenciaDeEmpleo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblAgenciaDeEmpleo.setFont(new Font("Century Gothic", Font.BOLD, 24));
		this.panel_Title.add(this.lblAgenciaDeEmpleo);
		
		this.panel_Foto = new JPanel();
		this.panel_Foto.setBackground(SystemColor.inactiveCaption);
		this.panel_TituloImagen.add(this.panel_Foto);
		this.panel_Foto.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.labelFoto = new JLabel("");
		this.labelFoto.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelFoto.setIcon(new ImageIcon("C:\\Users\\Gamer\\Downloads\\TP_G3\\img\\agencia_sm.png"));
		this.panel_Foto.add(this.labelFoto);
		
		this.panelLoginRegistro = new JPanel();
		this.panelLoginRegistro.setBorder(null);
		this.contentPane.add(this.panelLoginRegistro);
		this.panelLoginRegistro.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panelDatos = new JPanel();
		this.panelDatos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		this.panelLoginRegistro.add(this.panelDatos);
		this.panelDatos.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.panel_NombreUsuario = new JPanel();
		this.panel_NombreUsuario.setBackground(SystemColor.inactiveCaption);
		this.panel_NombreUsuario.setBorder(null);
		this.panelDatos.add(this.panel_NombreUsuario);
		this.panel_NombreUsuario.setLayout(new GridLayout(1, 1, 0, 0));
		
		this.labelNombreUsuario = new JLabel("Nombre Usuario");
		this.labelNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelNombreUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		this.panel_NombreUsuario.add(this.labelNombreUsuario);
		
		this.panel_inputNombreUsuario = new JPanel();
		this.panel_inputNombreUsuario.setMaximumSize(new Dimension(50, 50));
		this.panel_inputNombreUsuario.setForeground(Color.WHITE);
		this.panel_inputNombreUsuario.setBorder(null);
		this.panel_inputNombreUsuario.setPreferredSize(new Dimension(20, 20));
		this.panelDatos.add(this.panel_inputNombreUsuario);
		this.panel_inputNombreUsuario.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_InputCentrado = new JPanel();
		this.panel_InputCentrado.setBackground(SystemColor.inactiveCaption);
		this.panel_inputNombreUsuario.add(this.panel_InputCentrado);
		this.panel_InputCentrado.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
		
		this.inputNombreUsuario = new JTextField();
		this.inputNombreUsuario.addKeyListener(this);
		this.inputNombreUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		this.inputNombreUsuario.setMargin(new Insets(2, 0, 2, 0));
		this.inputNombreUsuario.setColumns(10);
		this.panel_InputCentrado.add(this.inputNombreUsuario);
		
		this.panel_Contrase�a = new JPanel();
		this.panel_Contrase�a.setBackground(SystemColor.inactiveCaption);
		this.panel_Contrase�a.setBorder(null);
		this.panelDatos.add(this.panel_Contrase�a);
		this.panel_Contrase�a.setLayout(new GridLayout(1, 1, 0, 0));
		
		this.labelContrase�a = new JLabel("Contrase\u00F1a");
		this.labelContrase�a.setBackground(Color.WHITE);
		this.labelContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelContrase�a.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		this.panel_Contrase�a.add(this.labelContrase�a);
		
		this.panel_inputContrase�a = new JPanel();
		this.panel_inputContrase�a.setBorder(null);
		this.panelDatos.add(this.panel_inputContrase�a);
		this.panel_inputContrase�a.setLayout(new GridLayout(1, 1, 0, 0));
		
		this.panel_InputContrase�aCentrado = new JPanel();
		this.panel_InputContrase�aCentrado.setBackground(SystemColor.inactiveCaption);
		FlowLayout flowLayout = (FlowLayout) this.panel_InputContrase�aCentrado.getLayout();
		flowLayout.setHgap(0);
		flowLayout.setVgap(40);
		this.panel_inputContrase�a.add(this.panel_InputContrase�aCentrado);
		
		this.passwordField = new JPasswordField();
		this.passwordField.setPreferredSize(new Dimension(135, 25));
		this.passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		this.panel_InputContrase�aCentrado.add(this.passwordField);
		
		this.panelBotones = new JPanel();
		this.panelBotones.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		this.panelLoginRegistro.add(this.panelBotones);
		this.panelBotones.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panelBotonRegistro = new JPanel();
		this.panelBotonRegistro.setBackground(SystemColor.inactiveCaption);
		FlowLayout flowLayout_1 = (FlowLayout) this.panelBotonRegistro.getLayout();
		flowLayout_1.setVgap(35);
		this.panelBotones.add(this.panelBotonRegistro);
		
		this.btnRegistrarse = new JButton("Registrarse");
		this.btnRegistrarse.setEnabled(false);
		this.btnRegistrarse.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.panelBotonRegistro.add(this.btnRegistrarse);
		
		this.panelBotonIniciarSesion = new JPanel();
		this.panelBotonIniciarSesion.setBackground(SystemColor.inactiveCaption);
		FlowLayout flowLayout_2 = (FlowLayout) this.panelBotonIniciarSesion.getLayout();
		flowLayout_2.setVgap(35);
		this.panelBotones.add(this.panelBotonIniciarSesion);
		
		this.btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		this.btnIniciarSesion.setEnabled(false);
		this.btnIniciarSesion.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.panelBotonIniciarSesion.add(this.btnIniciarSesion);
	}

	public void actionPerformed(ActionEvent e) {
	}
	

	public ActionListener getActionlistener() {
		return actionlistener;
	}

	public void setActionlistener(ActionListener actionlistener) {
		this.btnIniciarSesion.addActionListener(actionlistener);
		this.btnRegistrarse.addActionListener(actionlistener);
		this.actionlistener = actionlistener;
	}

	public JTextField getInputNombreUsuario() {
		return inputNombreUsuario;
	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	     if (this.inputNombreUsuario.getText().length()>0 && this.passwordField.getText().length()>0) {
	         this.btnIniciarSesion.setEnabled(true);
	         this.btnRegistrarse.setEnabled(true);
	     }else {
	         this.btnIniciarSesion.setEnabled(false);
	         this.btnRegistrarse.setEnabled(false);
	     }
	}
	public void keyTyped(KeyEvent e) {
	}
}