package healthcalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.Gender;
import healthcalc.HealthCalcImpl;

public class CalcControlador implements ActionListener{
	
	private HealthCalcImpl modelo;
	private CalcVista vista;
	
	public CalcControlador(HealthCalcImpl modelo, CalcVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("CalcularIW")) {
			try {
				calcularIW();
			} catch (Exception error) {
	        	vista.error(error.getMessage(), vista);
	        }
		}else if (comando.equals("CalcularBMR")) {
			try {
				calcularBMR();
			} catch (Exception error) {
	        	vista.error(error.getMessage(), vista);	 
	        }
		}
	}
	
	private void calcularIW() throws Exception {
		Gender genero = vista.getGenero();
        int altura = vista.getAltura();
        
        float IW = modelo.idealWeight(altura, genero);
        vista.setResIW(IW);        
    }
	
	private void calcularBMR() throws Exception {
		Gender genero = vista.getGenero();
        int altura = vista.getAltura();
        
        int edad = vista.getEdad();
        float peso = vista.getPeso();
        
        float BMR = modelo.basalMetabolicRate(peso, altura, genero, edad);
        vista.setResBMR(BMR); 
    }    
}
