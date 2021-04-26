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
	int xRojo = 10;
	int yRojo = 400;
	int xVerde = 5;
	int yVerde = 395;
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
		g.setColor(Color.green);
		g.fillOval(xVerde,yVerde,50,50);
		g.setColor(Color.red);
		g.fillOval(xRojo,yRojo,50,50);
	}
	
	public void actualizarRojo(int x, int y)
	{
		this.xRojo = x-25;
		this.yRojo = y-25;
		repaint();
	}
	public void actualizarVerde(int x, int y)
	{
		this.xVerde= x-20;
		this.yVerde = y-20;
		repaint();
	}
}