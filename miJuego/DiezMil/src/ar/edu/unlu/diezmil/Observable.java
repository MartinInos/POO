package ar.edu.unlu.diezmil;

public interface Observable<T> {
	
	public void addObserver(T obs);
	
	public void removeObserver(T obs);

}
