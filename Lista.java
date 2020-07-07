import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

class Lista
{
	public static void main(String[] args) 
	{
		Frame ventanilla = new Frame();
	}

	public static class Frame extends JFrame implements ActionListener
	{
		JPanel panel;
		JTextField txtCampoEscribe;
		JTextArea txaAreaInfo;
		JButton btnAgregar;
		JButton btnBorrar;
		JButton btnVacio;
		JButton btnTamano;
		JButton btnObtener;
		ListaEnlazada lista = new ListaEnlazada();
		public static String vacio = "";

		public Frame()
		{
			componentesPaneles();
      		this.add(panel);
      		this.setSize(600,600);
      		this.setVisible(true);
      		this.setTitle("Examen Practico");
      		this.setLocationRelativeTo(null);
      		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      		this.setResizable(false);
      		txaAreaInfo.setText(vacio);
			txaAreaInfo.setEditable(false);
      		btnAgregar.addActionListener(this);
      		btnBorrar.addActionListener(this);
      		btnVacio.addActionListener(this);
      		btnTamano.addActionListener(this);
      		btnObtener.addActionListener(this);
		}

		public void componentesPaneles()
		{
			panel = new JPanel();
      		panel.setLayout(null);
      		panel.setFocusable(true);
      		panel.requestFocusInWindow();
      		panel.setBackground(Color.CYAN);
      		panel.setVisible(true);

      		btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(400, 100, 150, 50); //(x, y, w, h)

			btnBorrar = new JButton("Borrar");
			btnBorrar.setBounds(400, 200, 150, 50); //(x, y, w, h)

			btnVacio = new JButton("Estado Lista");
			btnVacio.setBounds(400, 283, 150, 50); //(x, y, w, h)

			btnTamano = new JButton("Tamano");
			btnTamano.setBounds(400, 366, 150, 50); //(x, y, w, h)

			btnObtener = new JButton("Mostrar");
			btnObtener.setBounds(400, 450, 150, 50); //(x, y, w, h)

			txtCampoEscribe = new JTextField();
			txtCampoEscribe.setBounds(50, 100, 300, 50); //(x, y, w, h)

			txaAreaInfo = new JTextArea();
			txaAreaInfo.setBounds(50, 200, 300, 300); //(x, y, w, h)

			panel.add(txtCampoEscribe);
			panel.add(txaAreaInfo);
			panel.add(btnAgregar);
			panel.add(btnBorrar);
			panel.add(btnVacio);
			panel.add(btnTamano);
			panel.add(btnObtener);
		}

		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == btnAgregar)
			{
				String elemento;
				elemento = txtCampoEscribe.getText();
				lista.addP(elemento);
				vacio = vacio + elemento + " ";
				txaAreaInfo.setText(vacio);
			}
			else if (event.getSource() == btnObtener)
			{
				for(int a=0; a<lista.tamanio(); a++)
				{
					vacio = vacio + "Elemento No." + a + lista.obtener(a)+ " ";
					txaAreaInfo.setText(vacio);
				}
			}
			else if (event.getSource() == btnTamano)
			{
				vacio = vacio + "Tamano de la Lista: " + lista.tamanio() + " ";
				txaAreaInfo.setText(vacio);
			}
			else if (event.getSource() == btnVacio)
			{
				vacio = vacio + "Esta Vacia? " + lista.cabezaVacia() + " ";
				txaAreaInfo.setText(vacio);
			}
			else if (event.getSource() == btnBorrar)
			{
				lista.eliminarP();
			}
		}
	}
}