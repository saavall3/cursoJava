package clases;

public class Cafetera {

	private int capacidadTotal;
	private int capacidadRestante;
	private int volumenTaza;
	private int volumenVaso;
	private boolean encendida;
	
	
	public void setCapacidadTotal(int capacidadTotal) {
		this.capacidadTotal = capacidadTotal;
	}
	public void setCapacidadRestante(int capacidadRestante) throws CafeteraException {
		if(capacidadRestante > capacidadTotal) {
			throw new CafeteraException("La capacidad restante no puede ser mayor que la capacidad total.");
		} else {
			this.capacidadRestante = capacidadRestante;
		}

	}
	public void setVolumenTaza(int volumenTaza) {
		this.volumenTaza = volumenTaza;
	}
	public void setVolumenVaso(int volumenVaso) {
		this.volumenVaso = volumenVaso;
	}
	public int getCapacidadTotal() {
		return capacidadTotal;
	}
	public int getCapacidadRestante() {
		return capacidadRestante;
	}
	public int getVolumenTaza() {
		return volumenTaza;
	}
	public int getVolumenVaso() {
		return volumenVaso;
	}
	public boolean isEncendida() {
		return encendida;
	}
	public String encender() {
		if(encendida) {
			return "La cafetera ya está encendida.";
		}
		encendida = true;
		return "La cafetera está encendida.";
	}
	public String apagar() {
		if(!encendida) {
			return "La cafetera ya está apagada.";
		}
		encendida = false;
		return "La cafetera está apagada.";
	}
	public Cafetera(int capacidadTotal, int capacidadRestante, int volumenTaza, int volumenVaso)throws CafeteraException {
		setCapacidadTotal(capacidadTotal);
		setCapacidadRestante(capacidadRestante);
		setVolumenTaza(volumenTaza);
		setVolumenVaso(volumenVaso);
	}
	public String servirTaza() throws CafeteraException {
		if(!encendida) {
			throw new CafeteraException("La cafetera está apagada. Enciéndala para servir café.");
		}
		if (capacidadRestante >= volumenTaza) {
			capacidadRestante -= volumenTaza;
			return "Se ha servido una taza de café.";
		} else {
			throw new CafeteraException("No hay suficiente café para servir una taza.\nLlene la cafetera para poder servir una taza.");
		}
	}
	public String servirVaso() throws CafeteraException {
		if(!encendida) {
			throw new CafeteraException("La cafetera está apagada. Enciéndala para servir café.");
		}
		if (capacidadRestante >= volumenVaso) {
			capacidadRestante -= volumenVaso;
			return "Se ha servido un vaso de café.";
		} else {
			throw new CafeteraException("No hay suficiente café para servir un vaso.");
		}
	}	
	public String rellenar() {
		if(capacidadRestante == capacidadTotal) {
			return "La cafetera ya está llena.";
		}
		try
		{
		  setCapacidadRestante(capacidadTotal);
		} 
		catch (CafeteraException e) {
		}
		return "La cafetera ha sido llenada.";
	}
	public String vaciar() {
		if(capacidadRestante == 0) {
			return "La cafetera ya está vacía.";
		}
		try
		{
		  setCapacidadRestante(0);
		} 
		catch (CafeteraException e) {
		}
		return "La cafetera ha sido vaciada.";
	}
	public String mostrarCapacidad() {
		if(capacidadRestante == 0) {
			return "La cafetera está vacía.";
		}
		if(capacidadRestante == capacidadTotal) {
			return "La cafetera está llena.";
		}
		return "La capacidad restante de café es: " + capacidadRestante + " ml.";
	}
}
