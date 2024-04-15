package healthcalc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;

public class CalcVista extends JFrame {
	
	private CalcVista vista;

	private static final long serialVersionUID = 1L;
	private JPanel contentPanePrincipal;
	private JTextField tfGenero;
	private JTextField tfAltura;
	private JTextField tfEdad;
	private JTextField tfPeso;
	private JButton btnCalcIW;
	private JButton btnCalcBMR;
	private JLabel lblIW;
	private JLabel lblBMR;


	/**
	 * Create the frame.
	 */
	public CalcVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPanePrincipal = new JPanel();
		contentPanePrincipal.setBackground(new Color(176, 196, 222));
		contentPanePrincipal.setForeground(new Color(176, 196, 222));
		contentPanePrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanePrincipal);
		contentPanePrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setForeground(new Color(176, 196, 222));
		panelNorte.setBackground(new Color(176, 196, 222));
		contentPanePrincipal.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorteSuperior = new JPanel();
		panelNorteSuperior.setBackground(new Color(176, 196, 222));
		panelNorte.add(panelNorteSuperior, BorderLayout.NORTH);
		panelNorteSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorteSupNorte = new JPanel();
		FlowLayout fl_panelNorteSupNorte = (FlowLayout) panelNorteSupNorte.getLayout();
		fl_panelNorteSupNorte.setVgap(20);
		panelNorteSupNorte.setBackground(new Color(176, 196, 222));
		panelNorteSuperior.add(panelNorteSupNorte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("HealthCalc");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		panelNorteSupNorte.add(lblTitulo);
		
		JPanel panelNorteSupSur = new JPanel();
		FlowLayout fl_panelNorteSupSur = (FlowLayout) panelNorteSupSur.getLayout();
		fl_panelNorteSupSur.setVgap(10);
		panelNorteSupSur.setBackground(new Color(176, 196, 222));
		panelNorteSuperior.add(panelNorteSupSur, BorderLayout.CENTER);
		
		JLabel lblIntro = new JLabel("HealthCalc puede calcular el peso ideal y la tasa metabólica basal de una persona.");
		lblIntro.setVerticalAlignment(SwingConstants.TOP);
		lblIntro.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntro.setFont(new Font("Arial", Font.BOLD, 12));
		panelNorteSupSur.add(lblIntro);
		panelNorteSuperior.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelNorteSupNorte, panelNorteSupSur, lblTitulo, lblIntro}));
		
		JPanel panelNorteInferior = new JPanel();
		panelNorteInferior.setBackground(new Color(176, 196, 222));
		panelNorte.add(panelNorteInferior, BorderLayout.SOUTH);
		panelNorteInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panelNorteInferior.add(horizontalStrut);
		
		JPanel panelNorteInfIzq = new JPanel();
		panelNorteInfIzq.setForeground(new Color(100, 149, 237));
		panelNorteInfIzq.setBackground(new Color(240, 248, 255));
		panelNorteInferior.add(panelNorteInfIzq);
		panelNorteInfIzq.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JPanel panelNorteInfIzq2 = new JPanel();
		panelNorteInfIzq2.setBackground(new Color(240, 248, 255));
		panelNorteInfIzq.add(panelNorteInfIzq2);
		panelNorteInfIzq2.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lbl_IntroBMR = new JLabel("Para el peso ideal introducir:                ");
		lbl_IntroBMR.setFont(new Font("Arial", Font.PLAIN, 12));
		panelNorteInfIzq2.add(lbl_IntroBMR);
		
		JPanel panelNorteInfIzq3 = new JPanel();
		panelNorteInfIzq3.setBackground(new Color(240, 248, 255));
		panelNorteInfIzq2.add(panelNorteInfIzq3);
		panelNorteInfIzq3.setLayout(new GridLayout(2, 2, 0, 5));
		
		JLabel lbl_GeneroIW_3_1_1 = new JLabel("- Género");
		lbl_GeneroIW_3_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panelNorteInfIzq3.add(lbl_GeneroIW_3_1_1);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panelNorteInfIzq3.add(horizontalStrut_8);
		
		JLabel lbl_AlturaIW_1_1_1 = new JLabel("- Altura");
		lbl_AlturaIW_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panelNorteInfIzq3.add(lbl_AlturaIW_1_1_1);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panelNorteInfIzq3.add(horizontalStrut_9);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(50);
		panelNorteInferior.add(horizontalStrut_1);
		
		JPanel panelNorteInfDer = new JPanel();
		panelNorteInfDer.setForeground(new Color(0, 0, 0));
		panelNorteInfDer.setBackground(new Color(240, 248, 255));
		panelNorteInferior.add(panelNorteInfDer);
		panelNorteInfDer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JPanel panelNorteInfDer2 = new JPanel();
		panelNorteInfDer2.setBackground(new Color(240, 248, 255));
		panelNorteInfDer.add(panelNorteInfDer2);
		panelNorteInfDer2.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lbl_IntroBMR_1 = new JLabel("Para la tasa metabólica basal introducir:");
		lbl_IntroBMR_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panelNorteInfDer2.add(lbl_IntroBMR_1);
		
		JPanel panelNorteInfDer3 = new JPanel();
		panelNorteInfDer3.setBackground(new Color(240, 248, 255));
		panelNorteInfDer2.add(panelNorteInfDer3);
		panelNorteInfDer3.setLayout(new GridLayout(2, 2, 0, 5));
		
		JLabel lbl_GeneroIW_3_1 = new JLabel("- Género");
		lbl_GeneroIW_3_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panelNorteInfDer3.add(lbl_GeneroIW_3_1);
		
		JLabel lbl_GeneroIW_2_1 = new JLabel("- Edad");
		lbl_GeneroIW_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panelNorteInfDer3.add(lbl_GeneroIW_2_1);
		
		JLabel lbl_AlturaIW_1_1 = new JLabel("- Altura");
		lbl_AlturaIW_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panelNorteInfDer3.add(lbl_AlturaIW_1_1);
		
		JLabel lbl_GeneroIW_1_1 = new JLabel("- Peso");
		lbl_GeneroIW_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panelNorteInfDer3.add(lbl_GeneroIW_1_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(50);
		panelNorteInferior.add(horizontalStrut_2);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(176, 196, 222));
		contentPanePrincipal.add(panelCentro, BorderLayout.CENTER);
		FlowLayout fl_panelCentro = new FlowLayout(FlowLayout.CENTER, 5, 20);
		panelCentro.setLayout(fl_panelCentro);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(130);
		panelCentro.add(horizontalStrut_3);
		
		JPanel panelCentroIzq = new JPanel();
		panelCentroIzq.setBackground(new Color(176, 196, 222));
		panelCentro.add(panelCentroIzq);
		panelCentroIzq.setLayout(new GridLayout(5, 1, 0, 10));
		
		JLabel lblGeneroC = new JLabel("Género:");
		lblGeneroC.setFont(new Font("Arial", Font.BOLD, 14));
		panelCentroIzq.add(lblGeneroC);
		
		JLabel lblAlturaC = new JLabel("Altura:");
		lblAlturaC.setFont(new Font("Arial", Font.BOLD, 14));
		panelCentroIzq.add(lblAlturaC);
		
		JLabel lblEdadC = new JLabel("Edad:");
		lblEdadC.setFont(new Font("Arial", Font.BOLD, 14));
		panelCentroIzq.add(lblEdadC);
		
		JLabel lblPesoC = new JLabel("Peso:");
		lblPesoC.setFont(new Font("Arial", Font.BOLD, 14));
		panelCentroIzq.add(lblPesoC);
		
		Component verticalStrut_1_2 = Box.createVerticalStrut(20);
		panelCentroIzq.add(verticalStrut_1_2);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panelCentro.add(horizontalStrut_4);
		
		JPanel panelCentroCentro = new JPanel();
		panelCentroCentro.setBackground(new Color(176, 196, 222));
		panelCentro.add(panelCentroCentro);
		panelCentroCentro.setLayout(new GridLayout(5, 1, 0, 10));
		
		tfGenero = new JTextField();
		tfGenero.setFont(new Font("Arial", Font.PLAIN, 14));
		tfGenero.setHorizontalAlignment(SwingConstants.CENTER);
		tfGenero.setColumns(10);
		panelCentroCentro.add(tfGenero);
		
		tfAltura = new JTextField();
		tfAltura.setHorizontalAlignment(SwingConstants.CENTER);
		tfAltura.setFont(new Font("Arial", Font.PLAIN, 14));
		tfAltura.setColumns(10);
		panelCentroCentro.add(tfAltura);
		
		tfEdad = new JTextField();
		tfEdad.setHorizontalAlignment(SwingConstants.CENTER);
		tfEdad.setFont(new Font("Arial", Font.PLAIN, 14));
		tfEdad.setColumns(10);
		panelCentroCentro.add(tfEdad);
		
		tfPeso = new JTextField();
		tfPeso.setHorizontalAlignment(SwingConstants.CENTER);
		tfPeso.setFont(new Font("Arial", Font.PLAIN, 14));
		tfPeso.setColumns(10);
		panelCentroCentro.add(tfPeso);
		
		Component horizontalStrut_3_1_1 = Box.createHorizontalStrut(200);
		panelCentroCentro.add(horizontalStrut_3_1_1);
		
		Component horizontalStrut_4_1 = Box.createHorizontalStrut(20);
		panelCentro.add(horizontalStrut_4_1);
		
		JPanel panelCentroDer = new JPanel();
		panelCentroDer.setBackground(new Color(176, 196, 222));
		panelCentro.add(panelCentroDer);
		panelCentroDer.setLayout(new GridLayout(5, 1, 0, 10));
		
		JLabel lblInfoGenero = new JLabel("('w' o 'm')");
		lblInfoGenero.setFont(new Font("Arial", Font.BOLD, 14));
		panelCentroDer.add(lblInfoGenero);
		
		JLabel lblInfoAltura = new JLabel("(entre 140 y 250 cm)");
		lblInfoAltura.setFont(new Font("Arial", Font.BOLD, 14));
		panelCentroDer.add(lblInfoAltura);
		
		JLabel lblInfoEdad = new JLabel("(entre 0 y 120 años)");
		lblInfoEdad.setFont(new Font("Arial", Font.BOLD, 14));
		panelCentroDer.add(lblInfoEdad);
		
		JLabel lblInfoPeso = new JLabel("(en kg)");
		lblInfoPeso.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfoPeso.setFont(new Font("Arial", Font.BOLD, 14));
		panelCentroDer.add(lblInfoPeso);
		
		Component verticalStrut_3_1 = Box.createVerticalStrut(20);
		panelCentroDer.add(verticalStrut_3_1);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(50);
		panelCentro.add(horizontalStrut_5);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(new Color(176, 196, 222));
		contentPanePrincipal.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelSurIzq = new JPanel();
		panelSurIzq.setBackground(new Color(176, 196, 222));
		panelSur.add(panelSurIzq);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(50);
		panelSurIzq.add(horizontalStrut_7);
		
		JPanel panelSurCentro = new JPanel();
		panelSurCentro.setBackground(new Color(176, 196, 222));
		panelSur.add(panelSurCentro);
		panelSurCentro.setLayout(new GridLayout(3, 2, 50, 10));
		
		btnCalcIW = new JButton("Calcular Peso Ideal");
		btnCalcIW.setForeground(Color.BLACK);
		btnCalcIW.setFont(new Font("Arial", Font.BOLD, 14));
		btnCalcIW.setEnabled(true);
		btnCalcIW.setBackground(new Color(240, 248, 255));
		panelSurCentro.add(btnCalcIW);
		
		btnCalcBMR = new JButton("Calcular Tasa Metabolica Basal");
		btnCalcBMR.setForeground(Color.BLACK);
		btnCalcBMR.setFont(new Font("Arial", Font.BOLD, 14));
		btnCalcBMR.setEnabled(true);
		btnCalcBMR.setBackground(SystemColor.menu);
		panelSurCentro.add(btnCalcBMR);
		
		lblIW = new JLabel("");
		lblIW.setOpaque(true);
		lblIW.setHorizontalAlignment(SwingConstants.CENTER);
		lblIW.setFont(new Font("Arial", Font.BOLD, 14));
		lblIW.setBackground(new Color(240, 248, 255));
		panelSurCentro.add(lblIW);
		
		lblBMR = new JLabel("");
		lblBMR.setOpaque(true);
		lblBMR.setHorizontalAlignment(SwingConstants.CENTER);
		lblBMR.setFont(new Font("Arial", Font.BOLD, 14));
		lblBMR.setBackground(new Color(240, 248, 255));
		panelSurCentro.add(lblBMR);
		
		Component verticalStrut_1 = Box.createVerticalStrut(40);
		panelSurCentro.add(verticalStrut_1);
		
		JPanel panelSurDer = new JPanel();
		panelSurDer.setBackground(new Color(176, 196, 222));
		panelSur.add(panelSurDer);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(50);
		panelSurDer.add(horizontalStrut_6);
		
		pack();
		setVisible(true);
	}
	
	
	public char getGenero() {
		String texto = tfGenero.getText().trim();
		boolean mostrarError = false;
		if (!mostrarError && (texto == null || texto.isEmpty())) {
	        error("El campo Género está vacío.", vista);
	        mostrarError = true;
	    }
	    if (!mostrarError && (texto.length()!= 1)) {
	        error("El género es incorrecto.", vista);
	        mostrarError = true;
	    }
	    
	    char genero = texto.charAt(0);
	    return genero;
	}
	
	public int getAltura() {
		String texto = tfAltura.getText().trim();
		if (texto == null || texto.isEmpty()) {
	        error("El campo Altura está vacío.", vista);
	    }
		return Integer.parseInt(texto);
	}
	
	public int getEdad() {
		String texto = tfEdad.getText().trim();
		if (texto == null || texto.isEmpty()) {
	        error("El campo Edad está vacío.", vista);
	    }
		return Integer.parseInt(texto);	
	}
	
	public float getPeso() {
		String texto = tfPeso.getText().trim();
		if (texto == null || texto.isEmpty()) {
	        error("El campo Peso está vacío.", vista);
	    }
		return Float.parseFloat(texto);	
	}
	
	public void setResIW(float res) {
		lblIW.setText("El peso ideal es: " + res);
	}
	
	public void setResBMR(float res) {
		lblBMR.setText("La tasa metabólica basal es: " + res);
	}
	
	public void registrarControlador(ActionListener ctrl) {
		btnCalcIW.addActionListener(ctrl);
		btnCalcIW.setActionCommand("CalcularIW");
		
		btnCalcBMR.addActionListener(ctrl);
		btnCalcBMR.setActionCommand("CalcularBMR");
	}
	
	public void error(String msg, CalcVista vista) {
		JOptionPane.showMessageDialog(vista, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

}
