package es.studium.Tablero;

public class Tablero
{
	public static void main(String[] args)
	{
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		new Controlador(vista, modelo);
	}
}