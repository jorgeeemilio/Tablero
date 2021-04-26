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
	int posicionActual = -1;

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
			posicionActual = posicionActual + tiradaActual;
			if (posicionActual<15)
			{
				this.vista.actualizar(tablero[posicionActual][0], tablero[posicionActual][1]);
			}
			else if(posicionActual == 15)
			{
				this.vista.actualizar(tablero[posicionActual][0], tablero[posicionActual][1]);
				this.vista.dlgMensaje.setVisible(true);
				this.vista.removeMouseListener(this);
			}
			else if(posicionActual > 15)
			{
				posicionActual = 15 -(posicionActual - 15);
				this.vista.actualizar(tablero[posicionActual][0], tablero[posicionActual][1]);
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
