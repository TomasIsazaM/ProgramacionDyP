package com.trabajoHilos;

import java.util.ArrayList;

//Hilos
public class Proceso extends Thread{
	
	int[][] tablero;
	int aciertos = 0;
	
	public Proceso() {
		super();
		
	}

	public void run(Barcos barcos) {
	}
	
	public void asignarValores(int [][] tab) {
		tablero = tab;
	}
	
	public String buscarBarco(int barcoX, int barcoY) {
		
		int acerto = tablero[barcoY][barcoX];
		//String mensaje = "";
				
		if(acerto == 1) {
			boolean repetido = false;
			
			if(App.intentos >= 1) {
				repetido = App.validarAgregadoLista(barcoX, barcoY);
			}
			
			if(!repetido) {
				Aciertos aciertoTemporal = new Aciertos();
				aciertoTemporal.setPosicionX(barcoX);
				aciertoTemporal.setPosicionY(barcoY);
								
				App.pasoPorReferecia(aciertoTemporal);
				
				return("Acerto a un barco");
			}
			if (repetido) {
				
				return("Ya habias acertado a este barco");
				
			
			}
			
		}
				
		return ("No acerto a ningun barco");
	}	
	
	

}
