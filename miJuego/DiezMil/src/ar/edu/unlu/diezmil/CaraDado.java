package ar.edu.unlu.diezmil;

public enum CaraDado {
		NULL,UNO,DOS,TRES,CUATRO,CINCO,SEIS;
	
	public CaraDado valueAt(int i) {
		CaraDado c = CaraDado.UNO;
		switch (i) {
			case 1 : c =  CaraDado.UNO;
				     break;
			case 2 : c =  CaraDado.DOS;
			         break;
			case 3 : c =  CaraDado.TRES;
			         break;
			case 4 : c =  CaraDado.CUATRO;
			         break;
			case 5 : c =  CaraDado.CINCO;
		         	 break;
			case 6 : c =  CaraDado.SEIS;
		        	 break;	
		}
		return c;
	}
}

