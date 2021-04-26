package es.studium.Tablero;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

public class Vista extends Frame
{
	private static final long serialVersionUID = 1L;
	Toolkit herramientas;
	Image tablero, dado;
	int x = 10;
	int y = 400;
	Dialog dlgMensaje = new Dialog(this, "Mensaje", true);
	Label lblMensaje = new Label("Fin");
	
	public Vista()
	{
		herramientas = getToolkit();
		tablero = herramientas.getImage("fondo.jpg");
		dado = herramientas.getImage("dado.jpg");
		this.setTitle("Tablero");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		dlgMensaje.setLayout(new FlowLayout());
		dlgMensaje.setSize(100,100);
		dlgMensaje.setLocationRelativeTo(null);
		dlgMensaje.setResizable(false);
		dlgMensaje.add(lblMensaje);
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(tablero, 70, 60, this);
		g.drawImage(dado, 10, 200, this);
		g.setColor(Color.red);
		g.fillOval(x,y,50,50);
	}
	
	public void actualizar(int x, int y)
	{
		this.x = x-25;
		this.y = y-25;
		repaint();
	}
}