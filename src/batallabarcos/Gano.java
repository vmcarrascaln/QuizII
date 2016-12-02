/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batallabarcos;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author victor carrascal
 */
public class Gano extends Thread {
    JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JButton aceptar = new JButton("Aceptar");
	public void crearGano() {
		frame.setBounds(20, 20, 400	, 180);
		label.setBounds(105, 15, 250, 50);
		frame.getContentPane().add(label);
		aceptar.setBounds(150, 90, 100, 30);
		frame.getContentPane().add(aceptar);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}
	public void run() {
		this.crearGano();
	}
}
