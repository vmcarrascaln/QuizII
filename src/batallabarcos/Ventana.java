/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batallabarcos;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author victor carrascal
 */
public class Ventana extends Thread {
    Barco batallabarco = new Barco();
	JFrame frame;
	JButton [][] botones = new JButton[7][7];
	JButton [][] botones2 = new JButton[7][7];
	JButton vaciar = new JButton("RESET");
	JButton salir = new JButton("SALIR");
	JButton completar = new JButton();
	JButton cambiarJ = new JButton("CAMBIAR JUGADORES");
	JButton maquina = new JButton("1 PLAYER");
	JButton dosPlayers = new JButton("2 PLAYERS");
	JLabel mensajeBarcos = new JLabel("SELECCIONE CANTIDAD");
	JLabel mensajeBarcos2 = new JLabel("DE JUGADORES");
	JLabel mensajeBarcos3 = new JLabel();
	JLabel mensajeBarcos4 = new JLabel();
	JLabel jugador1 = new JLabel();
	JLabel jugador2 = new JLabel();
	JLabel j1 = new JLabel();
	Timer timer = new Timer();
	final JLabel imagenF1 = new JLabel();
	final JLabel imagenF2 = new JLabel();
	JLabel j2 = new JLabel();
	JButton turno1 = new JButton("SU TURNO");
	JButton turno2 = new JButton("SU TURNO");
	Barco batallaBarco2 = new Barco();
	private int uno;
	private int dos;
	public void crearGUI() {
		frame = new JFrame("Batalla Naval");
		frame.setLayout(null);
		frame.setBounds(0, 0, 990, 650);
		JLabel imagen = new JLabel();
		imagenF1.setBounds(0, 0, 350,350);
		imagenF2.setBounds(635, 0, 350, 350);
		imagenF2.setIcon(new ImageIcon(getClass(). getResource("fondo.jpg")));
		imagenF1.setIcon(new ImageIcon(getClass(). getResource("fondo.jpg")));
		imagen.setIcon(new ImageIcon(getClass(). getResource("batalla1.jpg"))); 
	    imagen.setBounds(0,0,990,650); 
		mensajeBarcos.setForeground(Color.white);
		mensajeBarcos2.setForeground(Color.white);
		mensajeBarcos3.setForeground(Color.white);
		mensajeBarcos4.setForeground(Color.white);
		jugador1.setForeground(Color.white);
		jugador2.setForeground(Color.white);
		mensajeBarcos.setBounds(390, 10, 300, 20);
		mensajeBarcos2.setBounds(390,30, 300, 20);
		mensajeBarcos3.setBounds(735, 560, 300, 10);
		mensajeBarcos4.setBounds(100, 560, 300, 10);
		jugador1.setBounds(100, 530, 300, 20);
		jugador2.setBounds(735, 530, 300, 20);
		turno1.setBounds(100, 400, 150,25);
		turno2.setBounds(735, 400, 150,25);
		turno1.setForeground(Color.black);
		turno2.setForeground(Color.black);
		turno1.setEnabled(false);
		turno2.setEnabled(false);
		frame.getContentPane().add(imagenF2);
		frame.getContentPane().add(imagenF1);
		frame.getContentPane().add(mensajeBarcos3);
		frame.getContentPane().add(mensajeBarcos);
		frame.getContentPane().add(mensajeBarcos2);
		frame.getContentPane().add(mensajeBarcos4);
		frame.getContentPane().add(jugador1);
		frame.getContentPane().add(jugador2);
		frame.getContentPane().add(turno1);
		frame.getContentPane().add(turno2);
		char[] s = new char[7];
		for (int i = 0; i < 7; i++) {
			s[i] = (char) ('A' + i );
			JLabel letras1 = new JLabel();
			JLabel letras2 = new JLabel();
			JLabel numeros = new JLabel();
			JLabel numeros2 = new JLabel();
			numeros2.setForeground(Color.white);
			numeros.setForeground(Color.white);
			letras1.setForeground(Color.white);
			letras2.setForeground(Color.white);
			numeros2.setBounds(650 + (50*i),360 , 10, 10);
			numeros.setBounds(22+(50*i),360,10,10);
			letras1.setBounds(355, 10 + (50 * i), 50, 50);
			letras2.setBounds(620, 10 + (50 * i), 50, 50);
			String s1 = String.valueOf(i);
			numeros.setText(s1);
			numeros2.setText(s1);
			s1 = String.valueOf(s[i]);
			letras1.setText(s1);
			letras2.setText(s1);
			frame.getContentPane().add(numeros2);
			frame.getContentPane().add(numeros);
			frame.getContentPane().add(letras1);
			frame.getContentPane().add(letras2);
			for(int j = 0; j < 7; j++) {
				JButton tmp = new JButton();
				JButton tmp2 = new JButton();
				tmp.setBounds(50*j,50*i,50, 50);
				tmp2.setBounds(635 + j*50,i*50, 50, 50);
				botones2[i][j] = tmp2;
				botones[i][j] = tmp;
				frame.getContentPane().add(botones[i][j]);
				frame.getContentPane().add(botones2[i][j]);
				botones[i][j].setIcon(new ImageIcon(getClass(). getResource("mar.jpg")));
				botones2[i][j].setIcon(new ImageIcon(getClass(). getResource("mar.jpg")));
				final int aux = i;
				final int aux2 = j;
 				botones[i][j].addActionListener(new java.awt.event.ActionListener(){
					public void actionPerformed (java.awt.event.ActionEvent  evt) {
						if (BatallaBarcos.marc(aux, aux2) == false && BatallaBarcos.probar(aux, aux2)) {	
							botones[aux][aux2].setIcon(new ImageIcon(getClass(). getResource("fuego.jpg")));
						}
						else if (BatallaBarcos.marc(aux, aux2) == false)
							botones[aux][aux2].setEnabled(false);
						int cant =BatallaBarcos.getBarcos();
						String s = String.valueOf(cant);
						
						mensajeBarcos4.setText("LE QUEDAN " + s + " BARCOS.");
						if (BatallaBarcos.getBarcos() == 0) {
							final Gano g = new Gano();
		 					g.start();
		 					g.frame.setTitle("Ganó!!!");
		 					g.label.setText("Felicitaciones!!! "+j1.getText()+" ha ganado.");
		 					g.aceptar.addActionListener(new java.awt.event.ActionListener(){
		 						public void actionPerformed (java.awt.event.ActionEvent  evt) {
		 							g.frame.dispose();
		 						}
		 					});
		 					for (int p = 0; p < 7; p++) {
		 						for(int r = 0; r < 7; r++) {
		 							if(!BatallaBarcos.marc(p, r))
		 								botones[p][r].setEnabled(false);
		 							if(!BatallaBarcos.marc(p, r))
		 								botones2[p][r].setEnabled(false);
		 						}
		 					}
		 					
		 				}
						else {
							if (BatallaBarcos.marc(aux, aux2) && !turno2.isEnabled()) {
								turno1.setEnabled(true);
								turno1.setBackground(Color.red);
								turno2.setEnabled(false);
								turno2.setBackground(null);
							}
							else {
								if(BatallaBarcos.marc2(aux, aux2)) {
									turno2.setEnabled(true);
									turno2.setBackground(Color.red);
									turno1.setEnabled(false);
									turno1.setBackground(null);
								}
								if(!maquina.isEnabled()) {
									boolean bandera = true;
									do {
										Random gen = new Random();
										Random gen2 = new Random();
										int num1 = gen.nextInt(7);
										int num2 = gen2.nextInt(7);
										uno = num1;
										dos = num2;
										if (BatallaBarcos.marc2(num1, num2)==false) {
											timer.schedule(new RemindTask(), 1500);
											bandera = false;
											if (BatallaBarcos.marc(num1, num2)) {
												bandera = true;
											}
										}	
									}while (bandera == true);
								}
								else{ 	
									for (int p = 0; p < 7; p++) {
				 						for(int r = 0; r < 7; r++) {
				 							if (!BatallaBarcos.marc(p, r))
				 								botones[p][r].setEnabled(false);
				 							if (BatallaBarcos.marc2(p, r) && !BatallaBarcos.marc(p, r))
				 								botones2[p][r].setEnabled(false);
				 							else
				 								botones2[p][r].setEnabled(true);
				 						}
				 					}
								}
							}
						}
					}
				});
 				botones2[i][j].addActionListener(new java.awt.event.ActionListener(){
					public void actionPerformed (java.awt.event.ActionEvent  evt) {
						if (BatallaBarcos.marc(aux, aux2)== false && BatallaBarcos.probar(aux, aux2)) {
							botones2[aux][aux2].setIcon(new ImageIcon(getClass(). getResource("fuego.jpg")));
						}
						else if (BatallaBarcos.marc(aux, aux2) == false)
							botones2[aux][aux2].setEnabled(false);
						int cant = BatallaBarcos.getBarcos();
						String s = String.valueOf(cant);
						
						mensajeBarcos3.setText("LE QUEDAN " + s + " BARCOS.");
						if (BatallaBarcos.getBarcos() == 0) {
							final Gano g = new Gano();
		 					g.start();
		 					if (maquina.isEnabled()) {
		 						g.frame.setTitle("Ganó!!!");
		 						g.label.setText("Felicitaciones!!! "+ j2.getText()+ " ha ganado.");
		 					}
		 					else {
		 						g.frame.setTitle("Perdiste");
		 						g.label.setText("Has Perdido, intenta de nuevo.");
		 					}
		 					g.aceptar.addActionListener(new java.awt.event.ActionListener(){
		 						public void actionPerformed (java.awt.event.ActionEvent  evt) {
		 							g.frame.dispose();
		 						}
		 					});
		 					for (int p = 0; p < 7; p++) {
		 						for(int r = 0; r < 7; r++) {
		 							if(!BatallaBarcos.marc(p, r))
		 								botones[p][r].setEnabled(false);
		 							if(!BatallaBarcos.marc(p, r))
		 								botones2[p][r].setEnabled(false);
		 						}
		 					}
		 				}
						else {
							
							if (BatallaBarcos.marc(aux, aux2) && !turno1.isEnabled()) {
								turno2.setEnabled(true);
								turno2.setBackground(Color.red);
								turno1.setEnabled(false);
								turno1.setBackground(null);
							}
							else {
								if(BatallaBarcos.marc2(aux, aux2)) {
									turno1.setEnabled(true);
									turno1.setBackground(Color.red);
									turno2.setEnabled(false);
									turno2.setBackground(null);
								}
								if (maquina.isEnabled()) {
									for (int p = 0; p < 7; p++) {
				 						for(int r = 0; r < 7; r++) {
				 							if (!BatallaBarcos.marc(p, r))
				 								botones2[p][r].setEnabled(false);
				 							if (BatallaBarcos.marc2(p, r) && !BatallaBarcos.marc(p, r))
				 								botones[p][r].setEnabled(false);
				 							else
				 								botones[p][r].setEnabled(true);
				 						}
				 					}
								}
							}
						}
						
					}
				});
 				botones[i][j].setEnabled(false);
				frame.getContentPane().add(botones[i][j]);
				botones[i][j].setVisible(true);
 				botones2[i][j].setEnabled(false);
				frame.getContentPane().add(botones2[i][j]);
				botones2[i][j].setVisible(true);
			}
		}
		salir.setBounds(390, 340, 200, 30);
		salir.setForeground(Color.white);
		salir.setBackground(Color.black);
		completar.setBounds(440, 150, 100, 100);
		dosPlayers.setBounds(390, 110, 200, 30);
		maquina.setBounds(390, 70, 200, 30);
		completar.setIcon(new ImageIcon(getClass(). getResource("Start1.jpg")));
		completar.setPressedIcon(new ImageIcon(getClass(). getResource("start3.jpg")));
		completar.setEnabled(false);
		frame.getContentPane().add(completar);
		frame.getContentPane().add(maquina);
		frame.getContentPane().add(dosPlayers);
		vaciar.setBounds(390, 260, 200, 30);
		vaciar.setForeground(Color.white);
		vaciar.setBackground(Color.black);
		dosPlayers.setForeground(Color.white);
		dosPlayers.setBackground(Color.black);
		maquina.setForeground(Color.white);
		maquina.setBackground(Color.black);
		cambiarJ.setBounds(390, 300, 200, 30);
		cambiarJ.setForeground(Color.white);
		cambiarJ.setBackground(Color.black);
		cambiarJ.setEnabled(false);
		frame.getContentPane().add(salir);
		frame.getContentPane().add(cambiarJ);
		frame.getContentPane().add(vaciar);
		maquina.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				maquina.setEnabled(false);
				cambiarJ.setEnabled(true);
				dosPlayers.setVisible(false);
				jugador2.setText("JUGADOR 2 : Computer" );
				mensajeBarcos.setText("PRESIONE 'START'");
				mensajeBarcos2.setText("PARA COMENZAR EL JUEGO.");
			}
		});	
		dosPlayers.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				completar.setEnabled(true);
				maquina.setVisible(false);
				dosPlayers.setEnabled(false);
				cambiarJ.setEnabled(true);
			}
		});	
		completar.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				if(!maquina.isEnabled()) {
					turno1.setEnabled(true);
					turno1.setBackground(Color.red);
					turno2.setEnabled(false);
					turno2.setBackground(null);
				}
				else {
					Random gen = new Random();
					int num1 = gen.nextInt(2)+1;
					if (num1 == 1) {
						turno1.setEnabled(true);
						turno1.setBackground(Color.red);
						turno2.setEnabled(false);
						turno2.setBackground(null);
					}
					else {
						turno2.setEnabled(true);
						turno2.setBackground(Color.red);
						turno1.setEnabled(false);
						turno1.setBackground(null);
					}
				}
				imagenF1.setBounds(0, 0, 0, 0);
				imagenF2.setBounds(0, 0, 0, 0);
				imagenF1.removeAll();
				imagenF2.removeAll();
				for (int i = 0; i < 7; i++) {
					for(int j = 0; j < 7; j++) {
						botones[i][j].setVisible(true);
						botones2[i][j].setVisible(true);
						if (turno2.isEnabled()) {
							botones2[i][j].setEnabled(true);
							botones[i][j].setEnabled(false);
						}
						if (turno1.isEnabled()) {
							botones[i][j].setEnabled(true);
							if (!maquina.isEnabled())
								botones2[i][j].setEnabled(true);
							else
								botones2[i][j].setEnabled(false);
						}
						botones[i][j].setIcon(new ImageIcon(getClass(). getResource("mar.jpg")));
						botones2[i][j].setIcon(new ImageIcon(getClass(). getResource("mar.jpg")));
					}
				}
				BatallaBarcos.completar();
				BatallaBarcos.completar();
				int cant = BatallaBarcos.getBarcos();
				int cant2 = BatallaBarcos.getBarcos();
				String s = String.valueOf(cant);
				String s2 = String.valueOf(cant2);
				mensajeBarcos.setText(null);
				mensajeBarcos2.setText(null);
				mensajeBarcos3.setText("LE QUEDAN " + s + " BARCOS.");
				mensajeBarcos4.setText("LE QUEDAN " + s2 + " BARCOS.");
			}
		});
		vaciar.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				for (int i = 0; i < 7; i++) {
					for(int j = 0; j < 7; j++) {
						botones[i][j].setVisible(false);
						botones2[i][j].setVisible(false);	
						botones[i][j].setEnabled(false);
						botones[i][j].setIcon(new ImageIcon(getClass(). getResource("mar.jpg")));
						botones2[i][j].setEnabled(false);
						botones2[i][j].setIcon(new ImageIcon(getClass(). getResource("mar.jpg")));
					}
				}
				imagenF2.setIcon(new ImageIcon(getClass(). getResource("fondo.jpg")));
				imagenF1.setIcon(new ImageIcon(getClass(). getResource("fondo.jpg")));
				imagenF1.setBounds(0, 0, 350,350);
				imagenF2.setBounds(635, 0, 350, 350);
				completar.setEnabled(false);
				maquina.setEnabled(true);
				dosPlayers.setVisible(true);
				maquina.setVisible(true);
				dosPlayers.setEnabled(true);
				BatallaBarcos.vaciar();
				
			}
		});
		frame.add(imagen); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public class RemindTask extends TimerTask {
	    public void run() {
	    	botones2[uno][dos].doClick();
	    }
	}
	public void run() {
		this.crearGUI();
		
	}
}
