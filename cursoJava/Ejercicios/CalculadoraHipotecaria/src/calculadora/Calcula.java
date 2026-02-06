package calculadora;
import java.util.Scanner;

public class Calcula {

	public static final boolean REDONDEAR=true;
	// Obtiente una tabla de amortizacion basada en el sistema frances
	public static void main(String[] args)
	{
		
		
		Scanner sc = new Scanner(System.in);
		double capitalInicial = 0;
		double tipoInteres = 0;
    	int plazoAnyos = 0;

		// variables intermedias
		int numCuotas = 0;
		double tipoInteresMensual = 0;

		// resultados
		double mensualidad;
		double totalPagado;

		capitalInicial = pideDouble(sc, "Capital inicial");

		tipoInteres = pideDouble(sc, "Tipo de interes");

		plazoAnyos = pideEntero(sc, "Plazo en años");

		numCuotas = 12 * plazoAnyos;

		tipoInteresMensual = tipoInteres / 12 / 100;

		mensualidad = truncarDoble(calculoMatematico(tipoInteresMensual, capitalInicial, numCuotas),2,REDONDEAR);

		System.out.printf("La cuota mensual asciende a: %.2f €\n", mensualidad);

		System.out.printf("El importe total pagado es de : %.2f €\n", totalPagado = numCuotas * mensualidad);
		
		MostrarTablaAmortizacion(tipoInteresMensual, capitalInicial, numCuotas, mensualidad);

	
	}
	private static double calculoMatematico(double tipoInteresMensual, double capitalInicial, int numCuotas)
	{
		return (capitalInicial * tipoInteresMensual) / (1 - Math.pow((1 + tipoInteresMensual), -numCuotas));
	}
	
	
	private static void MostrarTablaAmortizacion(double tipoInteresMensual, double capitalInicial, int numCuotas,
			double cuota)
	{

		double pendiente = capitalInicial;
		double interes = tipoInteresMensual * pendiente;
		double amortizado = cuota - interes;

		System.out.printf(" x\tcuota\tinteres\tamortizado\tpendiente\n");
		for (int x = 0; x < numCuotas; x++)

		{

			interes = tipoInteresMensual * pendiente;
			amortizado = cuota - interes;
			pendiente -= amortizado;
			
			System.out.printf("%2d\t%.2f\t%.2f\t%.2f\t\t%.2f\n", x+1, cuota, interes, amortizado, pendiente);

		}

	}
	
	public static int pideEntero(Scanner sc, String nombreVariable)
	{

		int valor = 0;

		System.out.println("Introduce " + nombreVariable + ": ");

		try

		{

			valor = sc.nextInt();

			if (valor < 0)
				throw new NumberFormatException("Numeros negativos no admitidos");

			return valor;

		} catch (Exception ex)

		{

			System.out.println("Dato erroneo. Vuelve a introducir " + nombreVariable + ": ");

			sc.nextLine();

			return pideEntero(sc, nombreVariable);

		}

	}
	
	public static double pideDouble(Scanner sc, String nombreVariable)
	{

		double valor = 0;

		System.out.println("Introduce " + nombreVariable + ": - decimales separados con ,: ");

		try

		{

			valor = sc.nextDouble();

			if (valor < 0)
				throw new NumberFormatException("Numeros negativos no admitidos");

			return truncarDoble(valor,2,REDONDEAR);

		} catch (Exception ex)

		{

			System.out.println("Dato erroneo. Vuelve a introducir la nota: ");
			sc.nextLine();
			return pideDouble(sc, nombreVariable);
		}
	
    }	
			
	private static double truncarDoble(double valor, int precision, boolean redondear)
	{
			int factor=1;
			for(int x=0;x<precision;x++)
			{
				factor*=10;
			}
			valor*=factor;	
			if(!redondear)
			{
			
			  return ((int)valor)/factor;
			
			}
			else
			{
			   return Math.round(valor)/ factor;
			}
	}
	
	
}