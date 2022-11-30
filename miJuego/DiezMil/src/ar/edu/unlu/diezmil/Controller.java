package ar.edu.unlu.diezmil;

public class Controller {
	
	private Partida juego;

	public Controller(Partida juego) {
		this.juego = juego;
	}
	
	public void tirar() {
		juego.contarPuntos(juego.tirar());	
	}
	public void addJugador(String nombreJ) {
		juego.agregarJugador(nombreJ);
	}
	public void nuevoJuego() {
		juego.nuevaPartida();
	}
	public void terminarTurno(boolean b) {
		juego.finTurno(b);
	}

	public void reiniciar() {
		juego.resetPartida();
	}
}
