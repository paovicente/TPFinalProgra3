package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class VentanaElecciones extends JFrame {

	private JPanel contentPane;
	private JPanel panel_muestraLista;
	private JPanel panel_btnAgregar;
	private JButton btnAgregar;
	private JScrollPane scrollPane;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaElecciones frame = new VentanaElecciones();
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
	public VentanaElecciones() {
		setTitle("Ronda de Elecciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 578);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panel_muestraLista = new JPanel();
		this.contentPane.add(this.panel_muestraLista, BorderLayout.CENTER);
		this.panel_muestraLista.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel_muestraLista.add(this.scrollPane, BorderLayout.CENTER);
		
		this.list = new JList();
		this.scrollPane.setViewportView(this.list);
		
		this.panel_btnAgregar = new JPanel();
		this.panel_btnAgregar.setBackground(SystemColor.inactiveCaption);
		this.contentPane.add(this.panel_btnAgregar, BorderLayout.SOUTH);
		
		this.btnAgregar = new JButton("Agregar");
		this.btnAgregar.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.btnAgregar.setBackground(SystemColor.inactiveCaption);
		this.btnAgregar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		this.panel_btnAgregar.add(this.btnAgregar);
	}

}