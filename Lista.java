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
		JPanel panelPass;
		JTextField txtCampoEscribe;
		JPasswordField passwordPlace;
		JTextArea txaAreaInfo;
		JButton btnAgregar;
		JButton btnBorrar;
		JButton btnVacio;
		JButton btnTamano;
		JButton btnObtener;
		JButton btnIngresar;
        JLabel lbl1;
		JLabel portada; 
		JLabel password;
		JLabel error;
		BufferedImage bfimage;
        BufferedImage bfimage2;
        JOptionPane optionPane;
        JDialog dialog;

		ListaEnlazada lista = new ListaEnlazada();
		public static String vacio = "";

		public Frame()
		{
			componentesPaneles();
      		this.add(panel);
      		this.add(panelPass);
      		this.setSize(600,600);
      		this.setVisible(true);
      		this.setTitle("Examen Practico");
      		this.setLocationRelativeTo(null);
      		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      		this.setResizable(false);
      		txaAreaInfo.setText(vacio);
			txaAreaInfo.setEditable(false);
			btnIngresar.addActionListener(this);
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
      		panel.setVisible(false);

      		panelPass = new JPanel();
      		panelPass.setLayout(null);
      		panelPass.setFocusable(true);
      		panelPass.requestFocusInWindow();
      		panelPass.setBackground(Color.CYAN);
      		panelPass.setVisible(true);
            
            //Panel sistema interno
      		try{
			bfimage = ImageIO.read(new File("./images/fondo.jpg"));	
			portada = new JLabel(new ImageIcon(bfimage));
			portada.setBounds(0,0,600,600);


      		btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(400, 100, 150, 50); //(x, y, w, h)
			//btnAgregar.setOpaque(false);

			btnBorrar = new JButton("Borrar");
			btnBorrar.setBounds(400, 200, 150, 50); //(x, y, w, h)
			//btnBorrar.setOpaque(false);

			btnVacio = new JButton("Estado Lista");
			btnVacio.setBounds(400, 283, 150, 50); //(x, y, w, h)
			//btnVacio.setOpaque(false);

			btnTamano = new JButton("Tamano");
			btnTamano.setBounds(400, 366, 150, 50); //(x, y, w, h)
			//btnTamano.setOpaque(false);

			btnObtener = new JButton("Mostrar");
			btnObtener.setBounds(400, 450, 150, 50); //(x, y, w, h)
			//btnObtener.setOpaque(false);

			txtCampoEscribe = new JTextField();
			txtCampoEscribe.setBounds(50, 100, 300, 50); //(x, y, w, h)
			//txtCampoEscribe.setOpaque(false);

			txaAreaInfo = new JTextArea();
			txaAreaInfo.setBounds(50, 200, 300, 300); //(x, y, w, h)
			//txaAreaInfo.setOpaque(false);
			}catch(Exception e){
			 JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado :(");
			}
             
            panel.add(portada);
			panel.add(txtCampoEscribe);
			panel.add(txaAreaInfo);
			panel.add(btnAgregar);
			panel.add(btnBorrar);
			panel.add(btnVacio);
			panel.add(btnTamano);
			panel.add(btnObtener);

            //Panel de ingresa contrasena
            try{
            bfimage2 = ImageIO.read(new File("./images/fondo.jpg"));	
			password = new JLabel(new ImageIcon(bfimage));
			password.setBounds(0,0,600,600); 
			password.setOpaque(true);

			lbl1 = new JLabel("Ingresa password");//ListaEnlazada
			lbl1.setBounds(185,200,250,40);
            lbl1.setForeground(Color.RED);
            lbl1.setFont(new Font("Times New Roman",0,30));
            lbl1.setOpaque(false);
            
            passwordPlace = new JPasswordField();
            passwordPlace.setBounds(165,250,250,40);
            passwordPlace.setFont(new Font("Times New Roman",0,30));
            passwordPlace.setOpaque(true);

            btnIngresar = new JButton(">");
            btnIngresar.setBounds(415,250,60,40);
            btnIngresar.setOpaque(true);
            btnIngresar.setBackground(Color.GREEN);
            btnIngresar.setFont(new Font("Times New Roman",0,30));
            btnIngresar.setOpaque(true);

            error = new JLabel("password incorrecto");
            error.setBounds(0,0,250,40);
            error.setForeground(Color.RED);
            error.setFont(new Font("Times New Roman",0,30));
            }catch(Exception e){

            }
            
            panelPass.add(btnIngresar);
            panelPass.add(passwordPlace);
            panelPass.add(lbl1);
            panelPass.add(password);
          }

		public void actionPerformed(ActionEvent event)
		{

			if (event.getSource() == btnIngresar) {
				String contrasena = "ListaEnlazada";
				if (String.valueOf(passwordPlace.getPassword()).equals(contrasena)) {
					panel.setVisible(true);
					panelPass.setVisible(false);
					this.add(panelPass);
					this.add(panel);

				}else if (String.valueOf(passwordPlace.getPassword()) != contrasena) {

				 optionPane = new JOptionPane("No mires sino quieres saber o_o!!", JOptionPane.ERROR_MESSAGE);    
                 dialog = optionPane.createDialog("password incorrecto");
                 dialog.setAlwaysOnTop(true);
                 dialog.setVisible(true);
				}
			}
			if (event.getSource() == btnAgregar)
			{
				String elemento;
				elemento = txtCampoEscribe.getText();
				lista.addP(elemento);
				vacio = vacio + elemento +'\n';
				txaAreaInfo.setText(vacio);
			}
			else if (event.getSource() == btnObtener)
			{
				for(int a=0; a<lista.tamanio(); a++)
				{
					vacio = vacio + "Elemento No. " + a +" "+ lista.obtener(a)+ '\n';
					txaAreaInfo.setText(vacio);
				}
			}
			else if (event.getSource() == btnTamano)
			{
				vacio = vacio + "Tamano de la Lista: " + lista.tamanio() + '\n';
				txaAreaInfo.setText(vacio);
			}
			else if (event.getSource() == btnVacio)
			{
				vacio = vacio + "Esta Vacia? " + lista.cabezaVacia() + '\n';
				txaAreaInfo.setText(vacio);
			}
			else if (event.getSource() == btnBorrar)
			{
				lista.eliminarP();
			}
		}
	}
}