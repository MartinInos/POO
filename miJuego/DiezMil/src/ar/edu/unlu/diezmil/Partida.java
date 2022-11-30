package ar.edu.unlu.diezmil;

import java.util.ArrayList;

import ar.edu.unlu.diezmil.vista.VentanaPrincipal;

public class Partida implements Observable<PartidaObserver>{

// Atributos  
	
	private Cubilete cubilete;
	private int turnoActual;
	private int ptsAcumTurno;
	private final int PMAX = 10000;
	private ArrayList<Jugador> jugadores;
	private ArrayList<PartidaObserver> observers;

// Metodo Constructor
	public Partida() {
		observers = new ArrayList<PartidaObserver>();
		nuevaPartida();
	}
// Metodos
	
	public ArrayList<Dado>  tirar() {	
		notifyObserversTiro(this.cubilete.arrojarDados());
		return this.cubilete.getDados();
	}
	public int getAcumuladoTurno() {
		return this.ptsAcumTurno;
	}
	public void nuevaPartida() {
		this.cubilete = new Cubilete();
		this.turnoActual = 1;
		this.ptsAcumTurno = 0;
		jugadores = new ArrayList<Jugador>();
		notifyObserversAgregarJugadores(jugadores.size());
	}
	public int contarPuntos(ArrayList<Dado> tiro) {
		int puntos = 0;
		for (int i=0;i<tiro.size();i++) {
			if (!tiro.get(i).isCaraFija()) {
				if (tiro.get(i).getCara().ordinal() == 1) {
					 puntos+= 100;
		
				} else if (tiro.get(i).getCara().ordinal() == 5)			
					 puntos+= 50;
					
	 		}
		}	
		if (contarRepDados(tiro,CaraDado.UNO) == 5) {
			puntos = 10000;
			jugadores.get(turnoActual-1).sumarPuntos(puntos);
			notifyObserversGanador(jugadores.get(turnoActual-1));
			}
			else if (contarRepDados(tiro,CaraDado.UNO) >= 3) {
				puntos+=700;
			}
			else if (contarRepDados(tiro,CaraDado.DOS) >= 3) {
				puntos+=200;
				this.cubilete.fijarRepetidos(CaraDado.DOS);
			}			
			else if (contarRepDados(tiro,CaraDado.TRES) >= 3) {
				puntos+=300;
				this.cubilete.fijarRepetidos(CaraDado.TRES);
			}			
			else if (contarRepDados(tiro,CaraDado.CUATRO) >= 3) {
				puntos+=400;
				this.cubilete.fijarRepetidos(CaraDado.CUATRO);
			}			
			else if (contarRepDados(tiro,CaraDado.CINCO) >= 3) {
				puntos+=350;
			}			
			else if (contarRepDados(tiro,CaraDado.SEIS) >= 3) {
				puntos+=600;
				this.cubilete.fijarRepetidos(CaraDado.SEIS);
			}else if (hayEscalera()) {
				puntos = 500;
				this.cubilete.fijarTodos();
			}
		if ((puntos != 0) && (jugadores.get(turnoActual-1).getPuntaje()+ptsAcumTurno+puntos <= PMAX)) {
			this.ptsAcumTurno+= puntos;
			this.cubilete.apartarDado(CaraDado.UNO);
			this.cubilete.apartarDado(CaraDado.CINCO);
			notifyObserversTiro(tiro);
			notifyObserversPuntos(ptsAcumTurno);
			if (jugadores.get(turnoActual-1).getPuntaje()+this.ptsAcumTurno == PMAX) {
				jugadores.get(turnoActual-1).sumarPuntos(ptsAcumTurno);
				notifyObserversGanador(jugadores.get(turnoActual-1));
			}
		}else {
			this.ptsAcumTurno = 0;
			notifyObserversTiro(tiro);
			notifyObserversPuntos(ptsAcumTurno);
		}
		return ptsAcumTurno;
	}

	private int contarRepDados(ArrayList<Dado> tiro, CaraDado cara) {
		int cont = 0, i=0;
		while (i<tiro.size()) {
			if(tiro.get(i).getCara() == cara && !tiro.get(i).isCaraFija()) {
				cont++;
			}
			i++;
		}
	return cont;
	}
	private boolean hayEscalera() {
		return ((contarRepDados(cubilete.getDados(), CaraDado.UNO) == 1 && contarRepDados(cubilete.getDados(),CaraDado.DOS) == 1 && contarRepDados(cubilete.getDados(),CaraDado.TRES) == 1 && contarRepDados(cubilete.getDados(),CaraDado.CUATRO) == 1 && contarRepDados(cubilete.getDados(),CaraDado.CINCO) == 1) || (contarRepDados(cubilete.getDados(),CaraDado.SEIS) == 1 && contarRepDados(cubilete.getDados(),CaraDado.DOS) == 1 && contarRepDados(cubilete.getDados(),CaraDado.TRES) == 1 && contarRepDados(cubilete.getDados(),CaraDado.CUATRO) == 1 && contarRepDados(cubilete.getDados(),CaraDado.CINCO) == 1));	
	}
	public Cubilete getCubilete() {
		return cubilete;
	}
	public void finTurno(boolean b) {
		if (isSumable(ptsAcumTurno,jugadores.get(turnoActual-1))) {
			jugadores.get(turnoActual-1).sumarPuntos(ptsAcumTurno);	
		}
		notifyObserversGuardarPuntaje(turnoActual,jugadores.get(turnoActual-1).getPuntaje());	
		this.ptsAcumTurno = 0;
		this.cubilete = new Cubilete();
		if (turnoActual == jugadores.size()) {
			turnoActual = 1;
		}else turnoActual++;
		if (!b){
		notifyObserversTurno(jugadores.get(turnoActual-1));
		notifyObserversTiro(cubilete.getDados());
		}	
	}
	public int getTurnoActual() {
		return this.turnoActual;
	}
	private boolean isSumable(int nuevosPuntos, Jugador j) {
		return (j.getPuntaje() + nuevosPuntos <= PMAX && nuevosPuntos != 0); 
	}
	public void addObserver(VentanaPrincipal v1) {
		observers.add(v1);	
	}
	public boolean agregarJugador(String nombreJ) {
		if (nombreJ.length() != 0 && !SeRepite(nombreJ)) {
			Jugador j = new Jugador(nombreJ);
			jugadores.add(j);	
			notifyObserversAgregado(nombreJ,jugadores.size(),true);
			notifyObserversTurno(jugadores.get(turnoActual-1));
			notifyObserversAgregarJugadores(jugadores.size());
			return true;
		}
		else
			return false;
	}
	private boolean SeRepite(String nombreJ) {
		boolean seRepite = false;
		int i = 0;
		while (!seRepite && i<jugadores.size()) {
			seRepite = (jugadores.get(i).getNombre().equals(nombreJ));
			i++;
		}
		return seRepite;
	}
	public int getPuntosTurno() {
		return this.ptsAcumTurno;
	}
	public void resetPartida() {
		this.ptsAcumTurno = 0;
		int i = 0;
		while (i < jugadores.size()) {
			jugadores.get(i).resetPuntaje();
			i++;
		}
		this.turnoActual = 1;
		this.cubilete = new Cubilete();
		notifyObserversReiniciar(jugadores.size());
	}
	
	
	
	// Notificadores----------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void notifyObserversPuntos(int mostrarPuntosTiro) {
		for (PartidaObserver o : observers) {
			o.notifyPuntosTurno(mostrarPuntosTiro);
		}
		
	}
	private void notifyObserversReiniciar(int cantJ) {
		for (PartidaObserver o : observers) {
			o.notifyReset(cantJ);
		}
		
	}
	private void notifyObserversTiro(ArrayList<Dado> tiro) {
		for (PartidaObserver o : observers) {
			o.notifyTiro(tiro);
		}
		
	}
	private void notifyObserversAgregado(String name, int pos, boolean agregado) {
		for (PartidaObserver o : observers) {
			o.notifyJugadorAgregado(name,pos,agregado);
		}
	}
	private void notifyObserversGuardarPuntaje(int turnoActual, int ptsAcumTurno) {
		for (PartidaObserver o : observers) {
			o.notifyGuardarPuntaje(turnoActual,ptsAcumTurno);
		}	
	}
	@Override
	public void removeObserver(PartidaObserver obs) {
		observers.remove(obs);
	}
	@Override
	public void addObserver(PartidaObserver obs) {
		observers.add(obs);	
	}
	private void notifyObserversTurno(Jugador jugador) {
		for (PartidaObserver o : observers) {
			o.notifyTurno(jugador.getNombre());
		}	
	}
	private void notifyObserversGanador(Jugador jugador) {
		for (PartidaObserver o : observers) {
			o.notifyGanador(jugador);
		}	
	}
	private void notifyObserversAgregarJugadores(int cantJ) {
		for (PartidaObserver o : observers) {
			o.notifyAddJugador(cantJ>=2);
		}	
	}
	


	
}
