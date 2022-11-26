package ar.edu.unlu.diezmil.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Instrucciones extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Instrucciones() {
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Reglas Generales", null, panel1, null);
		
		JPanel panelComoJugar = new JPanel();
		panelComoJugar.setBackground(Color.LIGHT_GRAY);
		
		JTextPane txtpnParaSumarPuntos = new JTextPane();
		txtpnParaSumarPuntos.setText("Para sumar puntos cada jugador o jugadora deberá obtener durante su turno diferentes combinaciones. Para iniciar el juego se determina quien inicia las rondas de partidas y el orden de los jugadores.\r\n\r\nEn cada turno los jugadores empiezan lanzando los cinco dados, si se obtienen números unos, cincos, tres números iguales de cualquier valor o una escalera se podrá seguir jugando o plantarse y sumar los puntos. Si no se obtiene ninguna de las combinaciones mencionadas anteriormente, se pierde el turno y el jugador no suma puntos.\r\n\r\nTabla de Puntos\r\n\r\n  50 puntos con cada número 5\r\n  100 puntos con cada número 1\r\n  200 puntos con tres números 2\r\n  300 puntos con tres números 3\r\n  400 puntos con tres números 4\r\n  500 puntos con tres números 5\r\n  500 puntos con escalera (1,2,3,4,5 o 2,3,4,5,6 o 3,4,5,6,1)\r\n  1000 puntos con tres números 1\r\n  10000 puntos con cinco números 1 en un solo tiro");
		txtpnParaSumarPuntos.setEditable(false);
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpnParaSumarPuntos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
						.addComponent(panelComoJugar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelComoJugar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnParaSumarPuntos, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Como Jugar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_panelComoJugar = new GroupLayout(panelComoJugar);
		gl_panelComoJugar.setHorizontalGroup(
			gl_panelComoJugar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelComoJugar.createSequentialGroup()
					.addGap(95)
					.addComponent(lblNewLabel)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_panelComoJugar.setVerticalGroup(
			gl_panelComoJugar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelComoJugar.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelComoJugar.setLayout(gl_panelComoJugar);
		panel1.setLayout(gl_panel1);
	}
}
