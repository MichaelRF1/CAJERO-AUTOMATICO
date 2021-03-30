package com.senati.eti;

import java.util.ArrayList;

import java.util.Scanner;

import java.util.Random;

import java.text.DecimalFormat;

public class Cajero {
	

	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    DecimalFormat df = new DecimalFormat("#.00");
		    
		    String[] arrCodigo = {"A-123-ABC", "A-456-ADC", "A-789-UTF", "A-777-WWW"};
		    String[] arrContraseña={ "3241", "1425", "4531", "4573"};
		    String[] arrNombre = {"Josef Caballero", "Michael Reques", "Arian Espinoza", "Keyla Rosales"};
		    ArrayList<Float> arrSaldo = new ArrayList<Float>(4);
		    arrSaldo.add(1200f);
		    arrSaldo.add(900f);
		    arrSaldo.add(2700f);
		    arrSaldo.add(3500f);
		    
		    //int[] arSaldo = {1200, 900, 2700, 3500};
		    
		    String cue = "", continuar = "S";
		    String pser = "";
		    int selec = 0;
		    int dni = 0, tr = 0;
		    int dep = 0;
		    int mon = 0;
		    int vou = 0;

		    
		    
		    while (continuar.equals("S") || continuar.equals("s")) {
		    	tr++;
		    	System.out.println("\n---------------------------------");
			    System.out.println("BIENVENIDO(A) A TU BANCA EN LÍNEA");
			    System.out.println("---------------------------------");
			    System.out.println("OPERACIONES CON TARJETA       [1]");
			    System.out.println("OPERACIONES SIN TARJETA       [2]");
			    System.out.println("CUENTAS Y PRESTAMOS           [3]");
			    System.out.println("---------------------------------");
			    System.out.print("ELIJA UNA OPCION: ");
			    selec = sc.nextInt(); //A-456
			    sc.nextLine();
			    
			    
			    
			    if (selec == 1) {
	 
			    	int pos = -1;
			    	
				    
			    	System.out.println("---------------------------------");
	                System.out.println("BIENVENIDO(A) A TU BANCA EN LÍNEA");
					System.out.println("---------------------------------");
					System.out.print("INGRESE NÚMERO DE SU TARJETA: ");
					String codigo = sc.nextLine(); //A-456
					
				    for(int x = 0; x < arrCodigo.length; x++) {
					      if (codigo.equals(arrCodigo[x])) {
					        pos = x;
					        break;
					    }
					    }
					      
					    if (pos == -1) {
					      System.out.println("\n----------------------");
					      System.out.println("NÚMERO DE TARJETA INVALIDO");
					      System.out.println("------------------------");
					    }
					    else {
					      System.out.println("\n---------------------------------");
					      System.out.println("BIENVENIDO(A) A TU BANCA EN LÍNEA");
					      System.out.println("---------------------------------");
					      System.out.println("Número de Tarjeta.........: "+ arrCodigo[pos]);
					      
					      
					      
					      
					      System.out.print("\nINGRESE SU CONTRASEÑA DE 4 DIGITOS: ");
					      String Contraseña = sc.nextLine();
					      
					     
					      int con = -1;
					      
					      for(int x = 0; x < arrContraseña.length; x++) {
					        if (Contraseña.equals(arrContraseña[x])) {
					          con = x;
					          break;
					        }
					          
					        
					      }
					      
					      if (con == -1) {
					        System.out.println("\n---------------------");
					        System.out.println("CONTRASEÑA INCORRECTA");
					        System.out.println("-----------------------");
					      }
					      else {
					    	  int op = 0, n_op = 0;
					    	  float nSaldo = 0;
					          String operacion = "", otra = "S";
					        
					          System.out.println("\n---------------------------------");
					          System.out.println("BIENVENIDO(A) "+ arrNombre[pos]);
					          System.out.println("---------------------------------");
					          System.out.println("Numero de Tarjeta.........: "+ arrCodigo[pos]);
					          
					          while(otra.equals("S") || otra.equals("s")) {
					        	  n_op ++;
					        	  System.out.println("\n--------OPERACIONES--------");
						          System.out.println("1. CONSULTA DE SALDO");
						          System.out.println("2. RETIRO");
						          System.out.println("3. TRANSFERENCIAS");
						          System.out.println("4. DEPÓSITO");
						          System.out.println("5. PAGO DE SERVICIOS");
						          System.out.print("\n¿Qué operación desea realizar?: ");
						          op = sc.nextInt();
						          
						          if (op >= 6) {
							    		 System.out.println("\n<<OPERACION NO VALIDA>>");
							    	 }
				
					        	  switch(op) {	
							        case 1:
							        	operacion = "CONSULTA DE PAGOS";
							        	System.out.println("\n------------------------------");
							        	System.out.println("OPERACIÓN: " + operacion);
							        	System.out.println("------------------------------");
								        System.out.println("SALDO DISPONIBLE: S/. " + arrSaldo.get(pos));
									    
								        break;
								        
							        case 2:
							    	    operacion = "RETIRO";
							    	    float c2 = 0;
							    	    int num_ret = 0;
							    	    String rp = "S";
							    	    System.out.println("\n------------------------------");
						    	        System.out.println("OPERACIÓN: " + operacion);
						    	        System.out.println("------------------------------");
							    	    System.out.print("¿Cuánto desea retirar?: ");
							    	    c2 = sc.nextFloat();
							    	    
							    	    if (c2 <= arrSaldo.get(pos)) {
							    	    	nSaldo = arrSaldo.get(pos) - c2;
							    	    	arrSaldo.remove(pos);
							    	    	arrSaldo.add(pos, nSaldo);
							    	        System.out.println("\nNUEVO SALDO: S/. " + nSaldo);
							    	    }
							    	    else if (c2 > arrSaldo.get(pos))
							    	        System.out.println("NO SE PUEDE REALIZAR LA OPERACIÓN");
							    		
							    	    break;
							    	    
							        case 3:
							    	    operacion = "TRANSFERENCIAS";

							    	    int tipo = 0;
							    	    float ct = 0;
							    	    
							    	    System.out.println("\n------------------------------");
							    	    System.out.println("OPERACIÓN: " + operacion);
							    	    System.out.println("------------------------------");
							    	    
							    	   
							    	    System.out.print("Cantidad a tranferir: ");
						    	    	ct = sc.nextFloat();
						    	    	sc.nextLine();
						    	    	System.out.print("Número de tarjeta a tranferir: ");
						    	    	String nt = sc.nextLine();
							    	   
						    	    	if(ct <= arrSaldo.get(pos)) {
						    	    		nSaldo = arrSaldo.get(pos) - ct;
						    	    	    arrSaldo.remove(pos);
						    	    	    arrSaldo.add(pos, nSaldo);
						    	    	    
						    	    	
						    	    	    System.out.println("\nTARJETA A TRANSFERIR: " + nt);
						    	    	    System.out.println("NUEVO SALDO: S/." + nSaldo);
						    	    	}
							    	    else 
							    	    	System.out.println("\nNO SE PUEDE REALIZAR LA OPERACIÓN");
							    	    
							    	    break;
							    	    
							        case 4:
							    	    operacion = "DEPOSITO";
							    	    float depo = 0;
							    	    
							    	    System.out.println("¿Cuánto desea depositar?: ");
							    	    depo = sc.nextFloat();
							  
							    	    if(depo == 0)
							    	    	System.out.println("NO SE PUEDE REALIZAR LA OPERACIÓN");
							    	    else {
							    	    	nSaldo = depo + arrSaldo.get(pos);
							    	    	arrSaldo.remove(pos);
							    	    	arrSaldo.add(pos, nSaldo);
							    	    	
							    	    	System.out.println("NUEVO SALDO: " + nSaldo);
							    	    }
							    	    
							    	    break;
							    	    
							        case 5:
							        	operacion = "PAGO DE SERVICIOS";
							        	float pagos = 0;
							        	
							        	System.out.println("\n--------PAGO DE SERVICIOS--------");
							        	System.out.print("Servicio a pagar: ");
							    	    pser = sc.nextLine();
							    	    sc.nextLine();
							    	    
							    	    System.out.print("\nMonto a pagar: ");
							    	    pagos = sc.nextFloat();
							    	    sc.nextLine();
							    	    
							    	    if(pagos == 0)
							    	    	System.out.println("NO SE PUEDE REALIZAR LA OPERACIÓN");
							    	    else {
							    	    	nSaldo = arrSaldo.get(pos) - pagos;
							    	    	arrSaldo.remove(pos);
							    	    	arrSaldo.add(pos, nSaldo);
							    	    	System.out.println("\nOPERACIÓN REALIZADA CON EXITO");
							    	    	
							    	    	System.out.println("\n-----------RECIBO-------------");
							    	    	System.out.println("Servico Pagado: " + pser);
							    	    	System.out.println("Monto Facturado: " + pagos);
							    	    	System.out.println("NUEVO SALDO: " + nSaldo);
							    	    }
    
							        	break;
						           }
					        	  
					        	  sc.nextLine();
					        	  
					        	  System.out.print("\n¿Desea realizar otra operación<S/N>?: ");
					        	  otra = sc.nextLine();
					        	  
					          }
						      System.out.println("\n------------------------------");
							  System.out.println("TU BANCO TRABAJA LAS 24 HORAS");
							  System.out.println("------------------------------");
					      }
					  
					    }
			    	
	 	
			    }
			    
			    else if(selec == 2) {
			    	System.out.println("\nINGRESE SU DNI: ");
			    	dni = sc.nextInt();
			    	sc.nextLine();
			    	
			    	System.out.println("DEPOSITO [1]  |<>|  COBRAR DEPOSITO [2]");
			    	dep = sc.nextInt();
			    	sc.nextLine();
			    	
			    	if(dep == 1) {
			    		System.out.print("NUMERO DE CUENTA A DEPOSITAR: ");
			    		cue = sc.nextLine();
			    		sc.nextLine();
			    		
			    		System.out.print("INGRESE EL MONTO EN SOLES: ");
			    		mon = sc.nextInt();
			    		sc.nextLine();
			    		
			    		System.out.println("¡OPERACION REALIZADA CON EXITO!");
			    		System.out.println("\nIMPRIMIR VOUCHER [SI->1] || [NO->2]");
			    		vou = sc.nextInt();
			    		
			    		if (vou == 1) {
			    			System.out.println("-------------VOUCHER-------------");
			    			System.out.println("Cuenta depositada.....: " + cue);
			    			System.out.println("DNI..................: " + dni);
			    			System.out.println("Monto en soles.......: " + mon);
			    			System.out.println("---------------------------------");
			    		}
			    		else
			    			System.out.println("GRACIAS POR SU PREFENRENCIA");
			    		    sc.nextLine();
			    		
			    	}
			    	else
			    		System.out.println("INGRESE SU DNI: ");
			    	    dni = sc.nextInt();
			    	    sc.nextLine();
			    	    
			    	    System.out.print("INGRESE EL MONTO A COBRAR: ");
			    		mon = sc.nextInt();
			    		sc.nextLine();
			    		
			    		System.out.println("¡OPERACION REALIZADA CON EXITO!");
			    		System.out.println("\nIMPRIMIR VOUCHER [SI->1] || [NO->2]");
			    		vou = sc.nextInt();
			    		
			    		if (vou == 1) {
			    			System.out.println("-------------VOUCHER-------------");
			    			System.out.println("Monto de retiro.......: " + mon);
			    			System.out.println("DNI...................: " + dni);
			    			System.out.println("---------------------------------");
			    		}
			    		else
			    			System.out.println("GRACIAS POR SU PREFENRENCIA");
			    		    sc.nextLine();

			    }
			    
			    
			    else if (selec == 3) {
			    	int cla = 0;
				    int tel = 0;
				    int ccp = 0;
				   
				    String nomb = "";
				    String corr = "";
				    String clave = "";
				    
				    clave = "****";
				    
				   
				    Random MiALeatorio = new Random();
				    int n1 = 1+ MiALeatorio.nextInt(9);
				    int n2 = 1+ MiALeatorio.nextInt(9);
				    int n3 = 1+ MiALeatorio.nextInt(9);
				    int n4 = 1+ MiALeatorio.nextInt(9);
				    int n5 = 1+ MiALeatorio.nextInt(9);
				    int n6 = 1+ MiALeatorio.nextInt(9);
				    int n7 = 1+ MiALeatorio.nextInt(9);
				    int n8 = 1+ MiALeatorio.nextInt(9);
				    int n9 = 1+ MiALeatorio.nextInt(9);
				    int n10 = 1+ MiALeatorio.nextInt(9);
				    int n11 = 1+ MiALeatorio.nextInt(9);
				    int n12 = 1+ MiALeatorio.nextInt(9);
				    int n13 = 1+ MiALeatorio.nextInt(9);
				    int n14 = 1+ MiALeatorio.nextInt(9);
				    int n15 = 1+ MiALeatorio.nextInt(9);
				    int n16 = 1+ MiALeatorio.nextInt(9);
				    			    
				    System.out.println("\n|--------------------------------------------------------------------------------------|");
			    	System.out.println("|BIENVENIDO , DESDE ACA PODRA CREAR UNA CUENTA DE AHORROS Y VER SI ACCEDE A UN PRESTAMO|");
			    	System.out.println("|--------------------------------------------------------------------------------------|");
			    	System.out.println("\nCUENTA DE AHORROS [1] \nCUENTA CORRIENTE  [2] \nPEDIR UN PRESTAMO [3]");
			    	ccp = sc.nextInt();
			    	sc.nextLine();
			    	
			    	if (ccp == 1) {
			    		System.out.println("-------CUENTA DE AHORRO------");
			    		
			    		System.out.print("Ingrese su DNI: ");
			    		mon = sc.nextInt();
			    		sc.nextLine();
			    		
			    		System.out.print("Ingrese su nombre: ");
			    		nomb = sc.nextLine();
			    		sc.nextLine();
			    		
			    		System.out.print("Numero de telefono: ");
			    		tel = sc.nextInt();
			    		sc.nextLine();
			    		
			    		System.out.print("Ingrese su correo electronico: ");
			    		corr = sc.nextLine();
			    		sc.nextLine();
			    		
			    		System.out.println("----CUENTA CREADA CON EXITO----");
			    		
			    		System.out.println("\nCambie la clave por seguridad: ");
			    		cla = sc.nextInt();
			    		sc.nextLine();
			    		
			    		System.out.println("\n---------------------------------");	    		
			    		System.out.println("-------------RESUMEN-------------");
			    		System.out.println("Nombre................: " + nomb);
			    		System.out.println("Numero de tarjeta.....: " + n1+n2+n3+n4+"-"+n5+n6+n7+n8+"-"+n9+n10+n11+n12+"-"+n11+n12+n13+n14);
			    		System.out.println("Clave.................: " + clave);
			    		System.out.println("---------------------------------");
			    	
			    	}
			    	
			    	if (ccp == 2) {
			    		System.out.println("-------CUENTA CORRIENTE------");
			    		
			    		System.out.println("Ingrese su DNI: ");
			    		mon = sc.nextInt();
			    		sc.nextLine();
			    		
			    		System.out.println("Ingrese su nombre: ");
			    		nomb = sc.nextLine();
			    		sc.nextLine();
			    		
			    		System.out.println("Numero de telefono: ");
			    		tel = sc.nextInt();
			    		sc.nextLine();
			    		
			    		System.out.print("Ingrese su correo electronico: ");
			    		corr = sc.nextLine();
			    		sc.nextLine();
			    		
			    		System.out.println("----CUENTA CREADA CON EXITO----");
			    		
			    		System.out.println("\nCambie la clave por seguridad: ");
			    		cla = sc.nextInt();
			    		sc.nextLine();
			    		
			    		System.out.println("\n---------------------------------");	    		
			    		System.out.println("-------------RESUMEN-------------");
			    		System.out.println("Nombre................: " + nomb);
			    		System.out.println("Numero de tarjeta.....: " + n1+n2+n3+n4+"-"+n5+n6+n7+n8+"-"+n9+n10+n11+n12+"-"+n11+n12+n13+n14);
			    		System.out.println("Clave.................: " + clave);
			    		System.out.println("---------------------------------");
			    	}
			    	int cuot = 0;
			    	int edad = 0;
			    	int trab = 0;
			    	
			    	if (ccp == 3) {
			    		System.out.println("\n------PLATAFORMA DE PRESTAMOS------");
			    		
			    		System.out.print("Ingrese su edad: ");
			    		edad = sc.nextInt();
			    		sc.nextLine();
			    		
			    		System.out.print("¿Tiene algun trabajo? [SI>1] -- [NO>2] ");
			    		trab = sc.nextInt();
			    		sc.nextLine();

			    		if (edad < 18 && trab == 2) {
			    			System.out.println("LO SENTIMOS NO CUMPLE LOS REQUISITOS MINIMOS :(");
			    			
			    		}
			    		
			    		if (edad < 18 && trab == 1) {
			    			System.out.println("LO SENTIMOS NO CUMPLE LOS REQUISITOS MINIMOS :(");
			    			
			    		}
			    		
			    		else
			    			System.out.println("\n---------------------------------");
			    			System.out.print("Ingrese su nombre: ");
			    		    nomb = sc.nextLine();
			    		    sc.nextLine();
			    		    
			    		    System.out.print("Ingrese su DNI: ");
			    		    dni = sc.nextInt();
			    		    sc.nextLine();
			    		
			    		
			    		    System.out.print("\nNumero de telefono: ");
			    		    tel = sc.nextInt();
			    		    sc.nextLine();
			    		
			    		    System.out.print("Ingrese su correo electronico: ");
			    		    corr = sc.nextLine();
			    		    sc.nextLine();
			    		    
			    		    System.out.print("Monto que solicita: ");
			    		    mon = sc.nextInt();
			    		    sc.nextLine();
			    		    
			    		    System.out.print("Cuotas de pago: ");
			    		    cuot = sc.nextInt();
			    		    sc.nextLine();
			    		    			    		  
			    		    float tpag = (mon*0.15f)+mon;
			    		    float mes = tpag/cuot;
			    		    
			    		   
			    		    System.out.println("---------------------------------");
			    		
			    		    System.out.println("\n--------PRESTAMO REALIZADO CON EXITO--------");
			    		
			    		    System.out.println("\n---------------------------------");	    		
			    		    System.out.println("--------------------RESUMEN-------------------");
			    		    System.out.println("Nombre..................: " + nomb);
			    		    System.out.println("DNI.....................: " + dni);
			    		    System.out.println("Monto prestado..........: " + mon);
			    		    System.out.println("Intereses...............: al 15%");
			    		    System.out.println("Cuotas de pago..........: " + cuot);
			    		    System.out.println("Total a pagar...........: " + tpag);
			    		    System.out.println("Total a pagar por mes...: " + df.format(mes));
			    		    System.out.println("----------------------------------------------");
			    			
			    		
			    		
			    	}
		
			    }
			    else if (selec >= 4)
			    	System.out.println("\nOPCION NO VÁLIDA  [PRESIONE ENTER]");
		    	
			    
			    sc.nextLine();
			    
			    System.out.print("¿Desea continuar [S/N]?: ");
			    continuar = sc.nextLine();
			    if (continuar !="S" || continuar != "s")
			    	System.out.println("\n>>Gracias por su preferencia<<");
		    }
   
	}
}