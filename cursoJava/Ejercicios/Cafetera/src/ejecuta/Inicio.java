package ejecuta;

import java.util.Scanner;

import clases.Cafetera;
import clases.CafeteraException;

public class Inicio {
	
	
	public static Cafetera cafetera;
	public static void main(String[] args) {
		
	    Scanner scanner = new Scanner(System.in);
		//Menu de opciones para la cafetera
		int opcion = 0;
		System.out.println("Bienvenido a la Cafetera");
		System.out.println("1. Crear la cafetera");
		System.out.println("2. Encender la cafetera");
		System.out.println("3. Llenar la cafetera");
		System.out.println("4. Vaciar la cafetera");
		System.out.println("5. Servir una taza");
		System.out.println("6. Servir un vaso");
		System.out.println("7. Mostrar cantidad restante de cafe");
		System.out.println("8. Apagar la cafetera");
		System.out.println("9. Destruir la cafetera");
	    System.out.println("10. Salir");
	    

		    do {
			    try
			    {

		    	System.out.println("Ingrese una opcion:");
		    	opcion = scanner.nextInt();
		    	String mensaje="";
				switch (opcion) {
					case 1:
					     cafetera=new Cafetera(1000, 0, 150, 100);
						 System.out.println("Cafetera de un litro creada con exito");
					 break;
					case 2:
						 mensaje=cafetera.encender();
						 System.out.println(mensaje);
						 break;
					case 3:
						mensaje=cafetera.rellenar();
						System.out.println(mensaje);
						break;
					case 4:
						mensaje=cafetera.vaciar();
						System.out.println(mensaje);
						break;
					case 5:
						mensaje=cafetera.servirTaza();
						System.out.println(mensaje);
						break;
					case 6:
						mensaje= cafetera.servirVaso();
						System.out.println(mensaje);
						break;
					case 7:
						mensaje= cafetera.mostrarCapacidad();
						System.out.println(mensaje);
						break;
					case 8:
						 cafetera.apagar();
						 break;
					case 9:
						 cafetera=null;
						 break;

					default:
						System.out.println("Opcion no valida");
						break;
									
				}
			    } catch (CafeteraException e) {
			    	System.out.println(e.getMessage());
			    }
			     catch (Exception e) {
			    	System.out.println(e.getMessage());
			    	System.out.println("Ocurrio un error que no es de cafetera. \nSaliendo...");
			    	return;
			    }
			 } while (opcion != 10);
		    System.out.println("Gracias por usar la Cafetera");
		    

	    scanner.close();

				
	}

}