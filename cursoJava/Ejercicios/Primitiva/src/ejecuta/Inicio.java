package ejecuta;

import java.util.Random;
import java.util.Scanner;

public class Inicio {

 public static final long PREMIO=1727262;//;1.727.262 euros
 public static void main(String[] args)
 {
	  Scanner sc=new Scanner(System.in);
	  byte[] miNumero=new byte[6];
	  String seguir="x";
	  
	  System.out.printf("SIMULADOR DE LOTERIA PRIMITIVA\n"  );
	  System.out.printf("El premio promedio segun la wikipedia es de %d€\n" , PREMIO );
	  calculoProbabilistico();
	  
	  miNumero=solicitarNumero(sc);
	  System.out.println("Has comprado el numero " + mostrarNumero(miNumero));
	
	  do
	  {
		   pruebaAciertoAleatoria(miNumero,100000000); //hasta 100 millones de intentos
		   System.out.println("\n¿Quieres volver a probar si la suerte te sonrie:) ? (s/n)");
		   seguir="x";
		   while(((!seguir.startsWith("s")) && (!seguir.startsWith("n")))) {
			   seguir=sc.nextLine().toLowerCase();
			   if((!seguir.startsWith("s")) && (!seguir.startsWith("n"))) System.out.println("Respuesta no valida\n Introduce s o n: ");
		   }
	  } while (seguir.startsWith("s"));
	  System.out.println("Bye!");
	  sc.close();
	  

 }
 public static byte[] solicitarNumero(Scanner sc)
 {

		  byte numerox=0;
		  boolean numeroValido=true;
		  boolean noesta=false;
		  byte[] numeroIntroducido=new byte[6];
		  System.out.println("Vamos a elegir nuestro numero de la loteria primitiva: ");
		  for(int x=0; x<6;)
		  {
			  do {
				  numeroValido=true;
				  System.out.println(mostrarNumero(numeroIntroducido));
				  System.out.println("Indica un nuevo numero entre 1 y 49: ");
				  try
				  {
				    numerox=Byte.parseByte(sc.nextLine());
				   
				  } catch(Exception ex)
				  {
					  numerox=0;
				  }
				  if(numerox<1 ||numerox>49)
				  {
					  numeroValido=false;
					  System.out.println("Numero no valido!");
				  }
				  if(numeroValido)
				  {
					  noesta=true;
					  for(int y=0;y<=x&&noesta;y++)
					  {
						  if(numeroIntroducido[y]==numerox) noesta=false;		  	  
					  }
					  
					  if(noesta) 
						  numeroIntroducido[x++]=numerox;
					  else
						  System.out.println("Este numero está ya seleccionado!");
				  }
			  
			  }while(numeroValido==false || noesta==false);
				  	  
		  }
		  ordenarArray(numeroIntroducido);
		  return numeroIntroducido;
 }
 public static byte[] generarNumero()
 {
		  Random aleat=new Random();
		  byte numerox=0;
		  boolean noesta=false;
		  byte[] numeroAzar=new byte[6];
		  for(int x=0; x<6;)
		  {
			  numerox=(byte)aleat.nextInt(1, 50);
			  noesta=true;
			  for(int y=0;y<=x&&noesta;y++)
			  {
				  if(numeroAzar[x]==numerox) noesta=false;		  	  
			  }
			  
			  if(noesta) 
				  numeroAzar[x++]=numerox;
				  	  
		  }
		  ordenarArray(numeroAzar);
		  return numeroAzar;
 }
 public static void ordenarArray(byte[] numero)
 {
	 byte intermedio=0;
	 for(int x=0;x<numero.length;x++)
	 {
		 for(int y=0;y<x;y++)
		    if(numero[x]<numero[y])
		    {
		    	intermedio=numero[x];
		    	numero[x]=numero[y];
		    	numero[y]=intermedio;
		    }
	 }
	 
 }
 public static String mostrarNumero(byte[] numero)
 {
	String res= (numero[0]==(byte)0)?"_-":numero[0] + "-" ;
           res+=(numero[1]==(byte)0)?"_-":numero[1] + "-" ;
           res+=(numero[2]==(byte)0)?"_-":numero[2] + "-" ;
           res+=(numero[3]==(byte)0)?"_-":numero[3] + "-" ;
           res+=(numero[4]==(byte)0)?"_-":numero[4] + "-" ;
           res+=(numero[5]==(byte)0)?"_":numero[5] ;
           return res;
 }
 public static void pruebaAciertoAleatoria(byte[] numero, long maxIntentos)
 {
		  boolean continuar=true; 
		  long intentos=0;
		  System.out.println("\nPrueba aleatoria hasta obtener el numero comprado o agotar el numero maximo de intentos. Espera unos segundos...");
		  while(continuar&&intentos<maxIntentos)
		  {
			 if(coincide(generarNumero(), numero))
			 {
				 continuar=false;		 
			 }
			 intentos++;
		  }
		  if(continuar==false) 
		  {
				System.out.println("Lo consegui comprando " + intentos + " numeros de primitiva");
				System.out.println("Si cada jugada cuesta 1€ " + (intentos>PREMIO? "has perdido ":"he ganado ") + Math.abs(intentos-PREMIO) + "€");
		  }
		  else
		  {
				System.out.println("Ni a la de " + intentos + " numeros de primitiva has obtenido el premio");
				System.out.println("Si cada jugada cuesta 1€ he perdido " + maxIntentos + "€");
		  }
 }
 public static boolean coincide(byte[] a1, byte[] a2)
 {
	 	for(int x=0;x<6;x++)
	     	if(a1[x]!=a2[x]) return false;
	 	return true;
 }
 public static void calculoProbabilistico()
 {
	 long resultado=0;
	 resultado=(49L*48*47*46*45*44)/(6*5*4*3*2*1);
	 System.out.println("La probabilidad de dar con los cinco numeros es de: 1 de cada " + resultado);
 }
}
