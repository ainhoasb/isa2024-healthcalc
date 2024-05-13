package healthcalc.gui;

import java.awt.EventQueue;

import healthcalc.HealthCalcImpl;

public class CalcMain {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcImpl modelo = HealthCalcImpl.getInstance();
					CalcVista vista = new CalcVista();
					CalcControlador controlador = new CalcControlador(modelo, vista);
					vista.registrarControlador(controlador);
					//vista.pack();
					//vista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
