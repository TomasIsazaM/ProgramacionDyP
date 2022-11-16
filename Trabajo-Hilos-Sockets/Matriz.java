package com.trabajoHilos;

import java.util.ArrayList;
import java.util.Scanner;

public class Matriz {


    int [][] tablero = new int[8][8];  
    App app = new App();
	
	public void mostrarMatriz() {
		for (int i = 0; i < tablero.length; i++) {
        	 System.out.print("| ");
        	 for (int j = 0 ; j < tablero[i].length; j++) {
        		 System.out.print(tablero[i][j] + " | ");
        	 }
        	 System.out.println("");
         }
		System.out.println("");
	}
	
	public int[][] generarBarcos() {
	
		Barcos barcos = new Barcos();
		
		barcos.setBarco1((int) (Math.random()*tablero.length));
		barcos.setBarco2((int) (Math.random()*tablero.length));
		barcos.setBarco3((int) (Math.random()*tablero.length));
	    
		barcos.setBarco11((int) ((Math.random() * ((4 - 0) + 1)) + 0));
		barcos.setBarco22((int) ((Math.random() * ((4 - 0) + 1)) + 0));
		barcos.setBarco33((int) ((Math.random() * ((4 - 0) + 1)) + 0));
	    
	    if(barcos.getBarco1() != barcos.getBarco2() && barcos.getBarco2() != barcos.getBarco3() && barcos.getBarco1() != barcos.getBarco3()) {
    		tablero[barcos.getBarco1()][barcos.getBarco11()] = 1;
	    	tablero[barcos.getBarco2()][barcos.getBarco22()] = 1;
	    	tablero[barcos.getBarco3()][barcos.getBarco33()] = 1;
	    	
	    	tablero[barcos.getBarco1()][barcos.getBarco11()+1] = 1;
	    	tablero[barcos.getBarco2()][barcos.getBarco22()+1] = 1;
	    	tablero[barcos.getBarco3()][barcos.getBarco33()+1] = 1;
	    	
	    	tablero[barcos.getBarco1()][barcos.getBarco11()+2] = 1;
	    	tablero[barcos.getBarco2()][barcos.getBarco22()+2] = 1;
	    	tablero[barcos.getBarco3()][barcos.getBarco33()+2] = 1;
	    }else{
	    	generarBarcos();
	    }
	    mostrarMatriz();
	    return tablero;
	}	
                              
	
}
