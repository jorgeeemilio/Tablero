package es.studium.Tablero;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, MouseListener
{
	Vista vista;
	Modelo modelo;
	int tablero[][] = {{116,425},{222,425},{327,425},{431,425},
			{430,320},{323,320},{224,320},{116,320},
			{116,215},{220,215},{326,215},{435,215},
			{432,115},{325,115},{223,115},{116,115}};
	int saltos[] = {0, 0, 0, 3, 
			0, 0, 0, -6, 
			1, 0, 0, 0, 
			-1, 0, 0, 0};
	int posicionActualRojo = -1;
	int posicionActualVerde = -1;
	int turno = 0; // 0 Rojo, 1 Verde

	public Controlador(Vista v, Modelo m)
	{
		this.vista = v;
		this.modelo = m;
		this.vista.addWindowListener(this);
		this.vista.dlgMensaje.addWindowListener(this);
		this.vista.addMouseListener(this);
	}
	@Override
	public void windowActivated(WindowEvent arg0){}
	@Override
	public void windowClosed(WindowEvent arg0){}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		if(this.vista.dlgMensaje.isActive())
		{
			this.vista.dlgMensaje.setVisible(false);
			// Reiniciar
			posicionActualRojo = -1;
			posicionActualVerde = -1;
			turno = 0;
			this.vista.actualizarRojo(35, 425);
			this.vista.actualizarVerde(25, 415);
		}
		else
		{
			System.exit(0);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0){}

	@Override
	public void windowDeiconified(WindowEvent arg0){}

	@Override
	public void windowIconified(WindowEvent arg0){}

	@Override
	public void windowOpened(WindowEvent arg0){}
	@Override
	public void mouseClicked(MouseEvent evento)
	{
		int x = evento.getX();
		int y = evento.getY();
		if((x>=10)&&(x<=70)&&(y>=200)&&(y<=260))
		{
			int tiradaActual = this.modelo.tirada();
			System.out.println(turno + "-->"+ tiradaActual);
			if(turno == 0)
			{
				posicionActualRojo = posicionActualRojo + tiradaActual;
				if (posicionActualRojo<15)
				{
					posicionActualRojo = posicionActualRojo + saltos[posicionActualRojo];
					this.vista.actualizarRojo(tablero[posicionActualRojo][0], tablero[posicionActualRojo][1]);
				}
				else if(posicionActualRojo == 15)
				{
					posicionActualRojo = posicionActualRojo + saltos[posicionActualRojo];
					this.vista.actualizarRojo(tablero[posicionActualRojo][0], tablero[posicionActualRojo][1]);
					this.vista.lblMensaje.setText("Ganó Rojo");
					this.vista.dlgMensaje.setVisible(true);
				}
				else if(posicionActualRojo > 15)
				{
					posicionActualRojo = 15 -(posicionActualRojo - 15);
					posicionActualRojo = posicionActualRojo + saltos[posicionActualRojo];
					this.vista.actualizarRojo(tablero[posicionActualRojo][0], tablero[posicionActualRojo][1]);
				}
				turno = 1;
			}
			else
			{
				posicionActualVerde = posicionActualVerde + tiradaActual;
				if (posicionActualVerde<15)
				{
					posicionActualVerde = posicionActualVerde+ saltos[posicionActualVerde];
					this.vista.actualizarVerde(tablero[posicionActualVerde][0], tablero[posicionActualVerde][1]);
				}
				else if(posicionActualVerde == 15)
				{
					posicionActualVerde = posicionActualVerde+ saltos[posicionActualVerde];
					this.vista.actualizarVerde(tablero[posicionActualVerde][0], tablero[posicionActualVerde][1]);
					this.vista.lblMensaje.setText("Ganó Verde");
					this.vista.dlgMensaje.setVisible(true);
				}
				else if(posicionActualVerde > 15)
				{
					posicionActualVerde = 15 -(posicionActualVerde - 15);
					posicionActualVerde = posicionActualVerde+ saltos[posicionActualVerde];
					this.vista.actualizarVerde(tablero[posicionActualVerde][0], tablero[posicionActualVerde][1]);
				}
				turno = 0;
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0){}
	@Override
	public void mouseExited(MouseEvent arg0){}
	@Override
	public void mousePressed(MouseEvent arg0){}
	@Override
	public void mouseReleased(MouseEvent arg0){}
}
