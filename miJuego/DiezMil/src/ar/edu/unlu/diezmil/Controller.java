package ar.edu.unlu.diezmil;

public class Controller {
	
	private Partida juego;

	public Controller(Partida juego) {
		this.juego = juego;
	}
	
	public void tirar() {
		juego.contarPuntos(juego.tirar());	
	}
	public boolean addJugador(String nombreJ) {
		if (nombreJ.length() > 0 && nombreJ.length() <= 10) {
			juego.agregarJugador(nombreJ);
			return true;
		}
		return false;	
	}
	
	public void nuevoJuego(int cantJugadores) {
		juego.nuevaPartida(cantJugadores);
	}
	public void terminarTurno() {
		juego.nextTurno();
	}

	public void reiniciar() {
	
	}
}
