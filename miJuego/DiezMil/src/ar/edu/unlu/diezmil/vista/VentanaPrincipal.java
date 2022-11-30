package ar.edu.unlu.diezmil.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.ComponentOrientation;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import ar.edu.unlu.diezmil.CaraDado;
import ar.edu.unlu.diezmil.Controller;
import ar.edu.unlu.diezmil.Dado;
import ar.edu.unlu.diezmil.DiezMil;
import ar.edu.unlu.diezmil.Jugador;
import ar.edu.unlu.diezmil.PartidaObserver;
import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class VentanaPrincipal extends JFrame implements PartidaObserver {

	private JFrame frame;
	private DiezMil juego;
	private JTable table;
	private Controller c;
	private JLabel lblDado1;
	private JLabel lblDado2;
	private JLabel lblDado3;
	private JLabel lblDado4;
	private JLabel lblDado5;
	private JButton btnTirarDados;
	private JLabel lblPuntos;
	private JLabel lblTurno;
	private JLabel lblAcumulado;
	private JButton btnIniciarPartida;
	private JButton btnInstrucciones;
	private JButton btnReset;
	private JButton btnSeguir;
	private JButton btnPlantarse;
	/**
	 * Initialize the contents of the frame.
	 * @param controlador 
	 */
	
	

	public VentanaPrincipal(Controller controlador) {
		c = controlador;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() {	
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(0, 102, 51));
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setResizable(false);
		frame.setBounds(0, 0, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JPanel panel_pantallaDeJuego = new JPanel();
				panel_pantallaDeJuego.setBounds(177, 0, 417, 561);
				panel_pantallaDeJuego.setBackground(new Color(255, 255, 255));
				
				JPanel panel_4 = new JPanel();
				panel_4.setBackground(new Color(0, 102, 51));
				panel_4.setBounds(62, 127, 300, 64);
				frame.getContentPane().setLayout(null);
			/*
			 *  Dados	
			 */
				lblDado1 = new JLabel("");
				panel_4.add(lblDado1);
				lblDado1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ar/edu/unlu/diezmil/resources/dadoN.png")));
				lblDado1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
				
				lblDado2 = new JLabel("");
				panel_4.add(lblDado2);
				lblDado2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ar/edu/unlu/diezmil/resources/dadoN.png")));
				lblDado2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
				
				lblDado3 = new JLabel("");
				panel_4.add(lblDado3);
				lblDado3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ar/edu/unlu/diezmil/resources/dadoN.png")));
				lblDado3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
				
				lblDado4 = new JLabel("");
				panel_4.add(lblDado4);
				lblDado4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ar/edu/unlu/diezmil/resources/dadoN.png")));
				lblDado4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
				
				lblDado5 = new JLabel("");
				lblDado5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
				lblDado5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ar/edu/unlu/diezmil/resources/dadoN.png")));
				panel_4.add(lblDado5);
				
				lblPuntos = new JLabel("0");
				lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
				lblPuntos.setBounds(140, 87, 189, 25);
				lblPuntos.setFont(new Font("Roboto", Font.BOLD, 20));
				
				lblTurno = new JLabel("Turno Jugador");
				lblTurno.setBackground(Color.WHITE);
				lblTurno.setHorizontalAlignment(SwingConstants.CENTER);
				lblTurno.setBounds(62, 11, 300, 42);
				lblTurno.setForeground(new Color(0, 0, 0));
				lblTurno.setFont(new Font("Roboto", Font.PLAIN, 20));
				frame.getContentPane().add(panel_pantallaDeJuego);
				panel_pantallaDeJuego.setLayout(null);
				panel_pantallaDeJuego.add(lblPuntos);
				panel_pantallaDeJuego.add(lblTurno);
				panel_pantallaDeJuego.add(panel_4);
				
				btnTirarDados = new JButton("");
				btnTirarDados.setBounds(154, 394, 109, 143);
				panel_pantallaDeJuego.add(btnTirarDados);
				btnTirarDados.setBorder(null);
				btnTirarDados.setEnabled(false);
				btnTirarDados.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ar/edu/unlu/diezmil/resources/cubilete.png")));
				btnTirarDados.setBackground(Color.WHITE);
				btnTirarDados.setForeground(new Color(34, 139, 34));
				
				lblAcumulado = new JLabel("Acumulado");
				lblAcumulado.setHorizontalAlignment(SwingConstants.LEFT);
				lblAcumulado.setForeground(Color.BLACK);
				lblAcumulado.setFont(new Font("Roboto", Font.PLAIN, 20));
				lblAcumulado.setBackground(Color.WHITE);
				lblAcumulado.setBounds(62, 83, 300, 33);
				panel_pantallaDeJuego.add(lblAcumulado);
				
				JSeparator separator_4 = new JSeparator();
				separator_4.setBackground(new Color(0, 0, 0));
				separator_4.setBounds(159, 46, 105, 2);
				panel_pantallaDeJuego.add(separator_4);
				
				
				table = new JTable();
				table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				table.setBounds(604, 48, 170, 176);
				frame.getContentPane().add(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{"Jugador", "Puntaje"},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
					},
					new String[] {
						"Jugador", "Puntaje"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table.getColumnModel().getColumn(0).setMinWidth(20);
				
				JLabel labelPuntos = new JLabel("Tablero de Puntos");
				labelPuntos.setForeground(new Color(245, 255, 250));
				labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
				labelPuntos.setBackground(Color.CYAN);
				labelPuntos.setBounds(604, 0, 170, 41);
				frame.getContentPane().add(labelPuntos);
				labelPuntos.setFont(new Font("Roboto Light", labelPuntos.getFont().getStyle() | Font.BOLD, labelPuntos.getFont().getSize() + 4));
				
				btnIniciarPartida = new JButton("Iniciar Partida");
				btnIniciarPartida.setFont(new Font("Roboto", Font.PLAIN, 11));
				btnIniciarPartida.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnIniciarPartida.setBounds(10, 170, 157, 41);
				frame.getContentPane().add(btnIniciarPartida);
				
				btnInstrucciones = new JButton("Instrucciones");
				btnInstrucciones.setFont(new Font("Roboto", Font.PLAIN, 11));
				btnInstrucciones.setBounds(10, 239, 157, 41);
				frame.getContentPane().add(btnInstrucciones);
				
				btnReset = new JButton("Reiniciar Juego");
				btnReset.setFont(new Font("Roboto", Font.PLAIN, 11));
				btnReset.setBounds(10, 304, 157, 41);
				frame.getContentPane().add(btnReset);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(10, 291, 157, 2);
				frame.getContentPane().add(separator);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(10, 222, 157, 2);
				frame.getContentPane().add(separator_1);
				
				JSeparator separator_2 = new JSeparator();
				separator_2.setBounds(10, 356, 157, 2);
				frame.getContentPane().add(separator_2);
				
				JSeparator separator_3 = new JSeparator();
				separator_3.setBounds(638, 35, 105, 2);
				frame.getContentPane().add(separator_3);
				
				JPanel panel = new JPanel();
				panel.setBounds(604, 235, 170, 123);
				frame.getContentPane().add(panel);
				panel.setLayout(null);
				
				btnSeguir = new JButton("SEGUIR");
				btnSeguir.setBounds(26, 11, 118, 42);
				panel.add(btnSeguir);
				btnSeguir.setForeground(Color.WHITE);
				btnSeguir.setFont(new Font("Roboto", Font.PLAIN, 14));
				btnSeguir.setBorder(null);
				btnSeguir.setEnabled(false);
				btnSeguir.setBackground(new Color(0, 102, 51));
				btnSeguir.setIcon(null);
				
				btnPlantarse = new JButton("PLANTARSE");
				btnPlantarse.setBounds(26, 64, 118, 42);
				panel.add(btnPlantarse);
				btnPlantarse.setForeground(new Color(255, 255, 255));
				btnPlantarse.setFont(new Font("Roboto", Font.PLAIN, 14));
				btnPlantarse.setBorder(null);
				btnPlantarse.setBackground(new Color(0, 102, 51));
				btnPlantarse.setIcon(null);
				btnPlantarse.setEnabled(false);
				
				JSeparator separator_2_1 = new JSeparator();
				separator_2_1.setBounds(10, 157, 157, 2);
				frame.getContentPane().add(separator_2_1);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ar/edu/unlu/diezmil/resources/ElDiezMil-Icon.jpg")));
				lblNewLabel.setBounds(22, 14, 130, 132);
				frame.getContentPane().add(lblNewLabel);
		
				/*
				 * Action Listeners
				 */	
				
				btnPlantarse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnTirarDados.setEnabled(true);
						btnSeguir.setEnabled(false);
						btnPlantarse.setEnabled(false);
						c.terminarTurno(false);
						}
					});
				
				btnSeguir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnTirarDados.setEnabled(true);
						btnSeguir.setEnabled(false);
						btnPlantarse.setEnabled(false);
						}
					});		
				
						       /* Inicia el juego 
								  Y Agrega los jugadores necesarios
								*/
						btnIniciarPartida.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int i = 1;
								c.nuevoJuego();	
								btnTirarDados.setEnabled(true);
							}
						});
						
						btnTirarDados.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JFrame f = new JFrame();
								f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								c.tirar();
							}
						});
						
						btnReset.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								c.reiniciar();	
							}
						});
						
						btnInstrucciones.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Instrucciones f = new Instrucciones();
								f.setVisible(true);
								f.setLocationRelativeTo(null);
							}
						});
						
			frame.setLocationRelativeTo(null);										
			frame.setVisible(true);	
	}
		private void updateIcons(ArrayList<Dado> dadosTirados) {
								int i = 0;
								while  ((i<dadosTirados.size()))  { //pone los iconos
									setIconDados(i+1,dadosTirados.get(i));
									i++;
								}
							}

							private void setIconDados(int numDado, Dado dado) {
								switch (numDado) {
									case 1:
										cambiarIcono(lblDado1,dado.getCara(),dado.isCaraFija());
										break;
									case 2:
										cambiarIcono(lblDado2,dado.getCara(),dado.isCaraFija());
										break;
									case 3:
										cambiarIcono(lblDado3,dado.getCara(),dado.isCaraFija());
										break;
									case 4:
										cambiarIcono(lblDado4,dado.getCara(),dado.isCaraFija());
										break;
									case 5:
										cambiarIcono(lblDado5,dado.getCara(),dado.isCaraFija());
										break;
								}
								
							}
							private void cambiarIcono(JLabel lblDado, CaraDado caraDado, boolean fijo) {
								if (caraDado.ordinal() == 0) {
											lblDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ar/edu/unlu/diezmil/resources/dadoN.png")));}
								else {
										if (fijo){
											lblDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ar/edu/unlu/diezmil/resources/dado"+caraDado.ordinal()+"F.png")));
										}else {
											lblDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ar/edu/unlu/diezmil/resources/dado"+caraDado.ordinal()+".png")));
										}
								}
							}
							
// Notificadores----------------------------------------------------------------------------------------------------------------------------------------------------
							
	@Override
	public void notifyTiro(ArrayList<Dado> tiro) {
		updateIcons(tiro);						
	}
		
	@Override
	public void notifyPuntosTurno(int puntos) {
		JFrame f = new JFrame();
		if (puntos == 0) {
			lblPuntos.setText(""+puntos);
			JOptionPane.showMessageDialog(f," Has Perdido el acumulado");	
			c.terminarTurno(false);
			btnSeguir.setEnabled(false);
			btnPlantarse.setEnabled(false);
			btnTirarDados.setEnabled(true);
		} else {
			lblPuntos.setText(""+puntos);
			btnSeguir.setEnabled(true);
			btnPlantarse.setEnabled(true);
			btnTirarDados.setEnabled(false);
		}
		
	}
	@Override
	public void notifyGuardarPuntaje(int turnoActual, int puntosJugador) {
		table.setValueAt(puntosJugador, turnoActual, 1);
	}
	@Override
	public void notifyTurno(String nombre) {
		lblTurno.setText("Turno de "+nombre);
	}
	@Override
	public void notifyGanador(Jugador jugador) {
			JFrame f = new JFrame();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(f,jugador.getNombre()+" Gano!!!");
			c.terminarTurno(true);
			btnTirarDados.setEnabled(false);
			btnSeguir.setEnabled(false);
			btnPlantarse.setEnabled(false);	
	}
	
	@Override
	public void notifyReset(int cantJ) {
		for (int i = 1;i<=cantJ;i++) {
			table.setValueAt(0, i, 1);
		}
	}
	@Override
	public void notifyJugadorAgregado(String name, int pos, boolean agregado) {
		JFrame f = new JFrame();
		f.setLocationRelativeTo(null);
		if (agregado) {
			JOptionPane.showMessageDialog(f,"Jugador Agregado Correctamente.","Alert",JOptionPane.WARNING_MESSAGE); 
			table.setValueAt(name, pos, 0);
			table.setValueAt(0, pos, 1);
		}else {
			JOptionPane.showMessageDialog(f,"El Jugador no fue agregado\nEl nombre no debe ser vacio y tampoco superar los 8 caracteres","Alert",JOptionPane.WARNING_MESSAGE);
		}
			
	}
	@Override
	public void notifyAddJugador(boolean masDeDos) {
		JFrame f = new JFrame();
		f.setLocationRelativeTo(null);
		if (masDeDos) {
				int input = JOptionPane.showConfirmDialog(null, "Agregar Otro Jugador?");
			    if (input == 0) {
			    	String name = JOptionPane.showInputDialog(f,"Enter Name");
			    	c.addJugador(name);
			    }	
		}else{
			String name = JOptionPane.showInputDialog(f,"Enter Name");
			c.addJugador(name);
		}
	}
}
