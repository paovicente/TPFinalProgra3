package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.SystemColor;

public class VentanaRegistroEmpleador extends JFrame {

	private JPanel contentPane;
	private JPanel panelLabelRegistroEmpleador;
	private JPanel panel_DatosYBotonEmpleador;
	private JPanel panel_IngresoDatosRegistroEmpleador;
	private JPanel panel_BotonRegistrarse;
	private JLabel Label_Registro_Empleador;
	private JButton buttonRegistrarse;
	private JPanel panel_NombreYPersona;
	private JPanel panel_RubroEmpleador;
	private JPanel panel_NombreEmpleador;
	private JPanel panel_PersonaEmpleador;
	private JLabel Label_NombreEmpleador;
	private JTextField inputNombreEmpleador;
	private JLabel labelPersonaEmpleador;
	private JRadioButton radioButtonJuridica;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel labelRubro;
	private JRadioButton radioButtonSalud;
	private JRadioButton radioButtonComercioLocal;
	private JRadioButton radioButtonComercioInternacional;
	private JPanel panel_InputNombreEmpleador;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JPanel panel_LabelPersona;
	private JPanel panel_LabelRubro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroEmpleador frame = new VentanaRegistroEmpleador();
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
	public VentanaRegistroEmpleador() {
		setTitle("Registro Empleador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 612);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panelLabelRegistroEmpleador = new JPanel();
		this.panelLabelRegistroEmpleador.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		this.contentPane.add(this.panelLabelRegistroEmpleador, BorderLayout.NORTH);
		
		this.Label_Registro_Empleador = new JLabel("Registro Empleador");
		this.Label_Registro_Empleador.setFont(new Font("Century Gothic", Font.BOLD, 24));
		this.panelLabelRegistroEmpleador.add(this.Label_Registro_Empleador);
		
		this.panel_DatosYBotonEmpleador = new JPanel();
		this.contentPane.add(this.panel_DatosYBotonEmpleador, BorderLayout.CENTER);
		this.panel_DatosYBotonEmpleador.setLayout(new BorderLayout(0, 0));
		
		this.panel_IngresoDatosRegistroEmpleador = new JPanel();
		this.panel_IngresoDatosRegistroEmpleador.setBackground(Color.PINK);
		this.panel_DatosYBotonEmpleador.add(this.panel_IngresoDatosRegistroEmpleador, BorderLayout.CENTER);
		this.panel_IngresoDatosRegistroEmpleador.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_NombreYPersona = new JPanel();
		this.panel_NombreYPersona.setBackground(Color.GREEN);
		this.panel_IngresoDatosRegistroEmpleador.add(this.panel_NombreYPersona);
		this.panel_NombreYPersona.setLayout(new BorderLayout(0, 0));
		
		this.panel_NombreEmpleador = new JPanel();
		this.panel_NombreEmpleador.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		this.panel_NombreYPersona.add(this.panel_NombreEmpleador, BorderLayout.NORTH);
		this.panel_NombreEmpleador.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.Label_NombreEmpleador = new JLabel("Nombre o Raz\u00F3n Social");
		this.Label_NombreEmpleador.setFont(new Font("Century Gothic", Font.BOLD, 18));
		this.Label_NombreEmpleador.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_NombreEmpleador.add(this.Label_NombreEmpleador);
		
		this.panel_InputNombreEmpleador = new JPanel();
		this.panel_NombreEmpleador.add(this.panel_InputNombreEmpleador);
		this.panel_InputNombreEmpleador.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.inputNombreEmpleador = new JTextField();
		this.inputNombreEmpleador.setMargin(new Insets(2, 20, 2, 20));
		this.inputNombreEmpleador.setPreferredSize(new Dimension(300, 20));
		this.panel_InputNombreEmpleador.add(this.inputNombreEmpleador);
		this.inputNombreEmpleador.setHorizontalAlignment(SwingConstants.CENTER);
		this.inputNombreEmpleador.setColumns(10);
		
		this.panel_PersonaEmpleador = new JPanel();
		this.panel_PersonaEmpleador.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		this.panel_NombreYPersona.add(this.panel_PersonaEmpleador, BorderLayout.CENTER);
		this.panel_PersonaEmpleador.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panel_LabelPersona = new JPanel();
		this.panel_LabelPersona.setBorder(null);
		this.panel_PersonaEmpleador.add(this.panel_LabelPersona);
		this.panel_LabelPersona.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.labelPersonaEmpleador = new JLabel("\u00BFPersona f\u00EDsica o jur\u00EDdica?");
		this.panel_LabelPersona.add(this.labelPersonaEmpleador);
		this.labelPersonaEmpleador.setFont(new Font("Century Gothic", Font.BOLD, 18));
		this.labelPersonaEmpleador.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.radioButtonJuridica = new JRadioButton("Persona F\u00EDsica");
		buttonGroup.add(this.radioButtonJuridica);
		this.radioButtonJuridica.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.radioButtonJuridica.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_PersonaEmpleador.add(this.radioButtonJuridica);
		
		this.rdbtnNewRadioButton_1 = new JRadioButton("Persona Jur\u00EDdica");
		buttonGroup.add(this.rdbtnNewRadioButton_1);
		this.rdbtnNewRadioButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_PersonaEmpleador.add(this.rdbtnNewRadioButton_1);
		
		this.panel_RubroEmpleador = new JPanel();
		this.panel_RubroEmpleador.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		this.panel_RubroEmpleador.setBackground(Color.LIGHT_GRAY);
		this.panel_IngresoDatosRegistroEmpleador.add(this.panel_RubroEmpleador);
		this.panel_RubroEmpleador.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.panel_LabelRubro = new JPanel();
		this.panel_LabelRubro.setBorder(null);
		this.panel_RubroEmpleador.add(this.panel_LabelRubro);
		this.panel_LabelRubro.setLayout(new BorderLayout(0, 0));
		
		this.labelRubro = new JLabel("Rubro");
		this.panel_LabelRubro.add(this.labelRubro);
		this.labelRubro.setFont(new Font("Century Gothic", Font.BOLD, 18));
		this.labelRubro.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.radioButtonSalud = new JRadioButton("Salud");
		buttonGroup_1.add(this.radioButtonSalud);
		this.radioButtonSalud.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.radioButtonSalud.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_RubroEmpleador.add(this.radioButtonSalud);
		
		this.radioButtonComercioLocal = new JRadioButton("Comercio local");
		buttonGroup_1.add(this.radioButtonComercioLocal);
		this.radioButtonComercioLocal.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.radioButtonComercioLocal.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_RubroEmpleador.add(this.radioButtonComercioLocal);
		
		this.radioButtonComercioInternacional = new JRadioButton("Comercio Internacional");
		buttonGroup_1.add(this.radioButtonComercioInternacional);
		this.radioButtonComercioInternacional.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.radioButtonComercioInternacional.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_RubroEmpleador.add(this.radioButtonComercioInternacional);
		
		this.panel_BotonRegistrarse = new JPanel();
		this.panel_BotonRegistrarse.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		this.panel_BotonRegistrarse.setBackground(SystemColor.menu);
		this.panel_DatosYBotonEmpleador.add(this.panel_BotonRegistrarse, BorderLayout.SOUTH);
		
		this.buttonRegistrarse = new JButton("Registrarse");
		this.buttonRegistrarse.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.panel_BotonRegistrarse.add(this.buttonRegistrarse);
	}

}