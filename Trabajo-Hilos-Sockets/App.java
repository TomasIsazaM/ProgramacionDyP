package com.trabajoHilos;
import java.util.ArrayList;
import java.util.Scanner;

	
	static Scanner leer = new Scanner (System.in);
    static int barco1,barco2,barco3,barco11,barco22,barco33;
	static ArrayList<Aciertos> listaAciertos = new ArrayList<Aciertos>();
	static int intentos = 0;
	

	
    public static void main( String[] args ) throws InterruptedException{
     	   
    	Matriz matriz = new Matriz();
		//Barcos barcos = matriz.generarBarcos();
		int[][] tablero = matriz.generarBarcos();
				
	    while(intentos <= 15) {
			System. out.println("Ingresa tu coordenada X:");
			int barcoX = leer.nextInt();
	        System. out.println("Ingresa tu coordenada Y:");
	        int barcoY = leer.nextInt();
				
	        Thread hilo = new Proceso();
			Thread hilo2 = new Proceso();
			Thread hilo3 = new Proceso();
			hilo.start();
			hilo2.start();
			hilo3.start();
			
			Proceso proceso = new Proceso();
			proceso.asignarValores(tablero);
			String mensaje = proceso.buscarBarco(barcoX, barcoY);
			intentos++;
			
			if(validarEstadoJuego()) {
				System.out.println("Has ganado el juego");
				break;
			}
			
			
			
			System.out.println(mensaje);
			
	    }
		if (intentos>15) {
			
			System.out.println("Has perdido");	
		}
	    
	    
	    

		Conector con = new Conector();
    	con.iniciar();
		
    }
    
    public static void pasoPorReferecia(Aciertos acierto) {
    	listaAciertos.add(acierto);
    }
    
    public static boolean validarEstadoJuego() {
    	if(listaAciertos.size() == 9) {
    		return true;
    	}    	
    	return false;
    }
    
    public static boolean validarAgregadoLista(int barcoX, int barcoY) {
    	
    	boolean existe = false;
    	
    	for(int i = 1; i <= listaAciertos.size(); i++) {
    		
    		Aciertos temp = listaAciertos.get(i-1);
    		existe = temp.getPosicionX() == barcoX && temp.getPosicionY() == barcoY ? true : existe;
    		
    	}
    	return existe;
    }
    
    public static ResultadoSocket informacionSocket() {
    	
    	ResultadoSocket info = new ResultadoSocket();
    	
    	info.setIntentos(intentos);
    	info.setAciertos(listaAciertos.size());
    	info.setRestantes(-listaAciertos.size()+15);
    	
    	return info;
    }


