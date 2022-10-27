package ar.edu.unlu.diezmil;

import java.util.ArrayList;

import ar.edu.unlu.diezmil.vista.VentanaPrincipal;

public class Cubilete {
	
	private ArrayList<Dado> dados;
	private int dadosFijos;
	private final int DADOS = 5;
	
	public Cubilete() {
		this.dados = new ArrayList<Dado>();
		int i = 0;
		while (i < DADOS) {
			Dado d = new Dado();
			dados.add(d);
			i++;
		}
		dadosFijos = 0;
	}
	public int getFijos() {
		return this.dadosFijos;
	}
	public ArrayList<Dado> arrojarDados() {
		if (todosFijos()) {
			desfijarDados();
		}
		for (int i=0;i<dados.size();i++) {
			dados.get(i).arrojarse();
		}
		return dados;
	}
	public ArrayList<Dado> getDados(){
		return dados;
	}
	public void fijarRepetidos(CaraDado cara) {
		int i = 0, cont = 0;
		while (i<dados.size() && cont < 3) {
			if(dados.get(i).getCara() == cara && !dados.get(i).isCaraFija()) {
					dados.get(i).fijarCara();
					dadosFijos++;
					cont++;
				}
			i++;
			}
		}
	
	public void desfijarDados() {
		int i = 0;
		while (i < dados.size()) {
			dados.get(i).desFijar();	
			i++;
		}
	}
	public void fijarTodos() {
		int i = 0;
		while (i < dados.size()) {
			dados.get(i).fijarCara();	
			i++;
		}
	}
	public boolean todosFijos() {
		int i = 0;
		boolean fijosT = true;
		while (i < dados.size() && fijosT) {
			fijosT = dados.get(i).isCaraFija();
			i++;
		}
		return fijosT;
	}
	public void apartar(CaraDado cara) {
		int i=0;
		while (i<dados.size()) {
			if (dados.get(i).getCara() == cara) {
				dados.get(i).fijarCara();
			}
			i++;
		}
	
	}

	

}
