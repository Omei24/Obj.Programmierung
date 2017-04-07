
public class Dice {
	
	public static void main(String[] args) {
		// TODO test the methods with n = 2,3,4,5,6
		int n = In.readInt("Bitte eine Zahl eingeben: \n");
		
		int[]  array = rollDice(n);
		for(int i = 1; i <= n; i++){
			System.out.print(array[i - 1]+" ");
		}
		for(n = 2; n <= 6; n++){
		System.out.println("\nAnzahl der Versuche:" +bisZumPasch(n));
		}
	}
	
	public static int rollDie() {
		// TODO create a random number from 1 to 6
		int Zahl = (int) (Math.random()*6+1);
		
		return Zahl;
	}
	
	public static int[] rollDice(int n) {
		// TODO create a array with random numbers
		if(n > 0){
			int [] arr = new int [n];
			for (int i = 1; i <= n; i++){
				arr [i - 1] = rollDie();
		}
			return arr;
		}
		else {
			int [] arr = new int [0];
			return arr;
		}
	}
	
	public static int bisZumPasch(int n){
		int Z�hler = 1;
		int[] Pascharray;
		boolean trueorfalse;
		Integer W�rfel1, W�rfelother;
		do{
			Pascharray = rollDice(n);
			W�rfel1 = Pascharray[0];
			trueorfalse = true;
			for(int i = 1; i < n; i++){
				W�rfelother = Pascharray[i];
				if(Pasch(W�rfel1, W�rfelother) == false){
					Z�hler++;
					i = n;
					trueorfalse = false;
				}
			}
		}
		while(trueorfalse == false);
		return Z�hler;
	}
	
	public static boolean Pasch(Integer a, Integer b){
		if(a.equals(b) == true){
			return true;
		}
		else {
			return false;
		}
	}
}
