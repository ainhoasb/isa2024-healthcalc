package healthcalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.Gender;
import healthcalc.HealthCalcImpl;
import healthcalc.Person;
import healthcalc.PersonImpl;

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

		Person persona = new PersonImpl(altura, genero);
        
        float IW = modelo.idealWeight(persona);
        vista.setResIW(IW);        
    }
	
	private void calcularBMR() throws Exception {
		Gender genero = vista.getGenero();
        int altura = vista.getAltura();
        
        int edad = vista.getEdad();
        float peso = vista.getPeso();

		Person persona = new PersonImpl(peso, altura, genero, edad);
        
        float BMR = modelo.basalMetabolicRate(persona);
        vista.setResBMR(BMR); 
    }    
}
