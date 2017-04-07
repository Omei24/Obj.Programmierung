
public class ControlStructures {
	
	public static void main (String[] args){
		
		System.out.println("Ergebnis: " + sum(29,13));
		int c = In.readInt("Bitte eine Zahl eingeben: ");
		System.out.println("Ihre Eingabe in Kubik ist: " +  calcCubicNumber(c));
		int d = In.readInt("Preis eingeben: ");
		System.out.println("Ohne Mehrwertsteuer kostet es: " +  calcMwSt(d));
		
	}
	
	public static int sum(int a, int b){
		
		return a + b;	// Der return Wert ist ein Integer. 
						// Die Übergabeparameter heißen a und b und sind auch Integer Variablen.
	}
	
	public static int calcCubicNumber(int c){
		
		return c * c * c;
	}
	
	public static double calcMwSt(int d){
		
		return d * 0.81;
	}
}
