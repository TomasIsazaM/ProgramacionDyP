package com.trabajoHilos;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;


//Sockets
public class Conector {

	ServerSocket server;
	Socket socket;
	int puerto = 9000;
	DataOutputStream salida;
	BufferedReader entrada;
	
	public void iniciar() {
	  try{
	       server = new ServerSocket(puerto);
	       socket = new Socket();
	       socket = server.accept();
	       entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	       String mensaje = entrada.readLine();
	       System.out.println(mensaje);
	       salida = new DataOutputStream(socket.getOutputStream());
	       
	       ResultadoSocket infoJugador = App.informacionSocket();
	       
	       JOptionPane.showMessageDialog(null,"El jugador realizo "+infoJugador.getAciertos()+ " aciertos \n"+
	    		   			"El jugador realizo "+(infoJugador.getIntentos()-1)+ " intentos \n"+
	    		   			"Al jugador le faltaron "+infoJugador.getRestantes()+ " aciertos \n");
	       
	       salida.writeUTF("El jugador realizo "+infoJugador.getAciertos()+ " aciertos \n"+
				   			"El jugador realizo "+(infoJugador.getIntentos()-1)+ " intentos \n"+
				   			"Al jugador le faltaron "+infoJugador.getRestantes()+ " aciertos \n");
	     //  socket.close();
	   }catch(Exception e){};
	}  
	
	
}
