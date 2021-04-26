package es.studium.Tablero;

import java.util.Random;

public class Modelo
{
	Random rnd = new Random();
	
	public int tirada()
	{
		return(rnd.nextInt(6)+1);
	}
}
