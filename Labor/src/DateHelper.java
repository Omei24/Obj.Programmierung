
public class DateHelper {

	public static void main(String[] args) {
		
		int year;
		int year2;
		int month;
		for (year = 1900; year <= 2000; year++){
			
			System.out.println(year+ "Ist ein Schaltjahr " + isLeapYear(year));
		}
		for (year2 = 2016; year2 <= 2017; year2++){
			for (month = 1; month <= 12; month++){
				System.out.println("Der " +month+"te Monat im Jahr " +year2+ " hat " +numberOfDays(month, year2)+ " Tage. 0 Tage bedeutet Error!!!!");
			}
		}
		
	}
	
		
		public static boolean isLeapYear(int year){
			
			if (year >= 1 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {	// teilbar durch 4 und nicht durch 100 oder 400 teilbar
				return true;
			} 
			else {	// ansonsten
				return false;
			}
	}

		public static int numberOfDays(int month, int year){
			if(year < 1){
				return 0;
			}
			else{
				switch (month){
					case 1 : return 31;
					case 2 : if (isLeapYear(year) == true){
								return 29;
							}
							else{
								return 28;
							}
					case 3 : return 31;
					case 4 : return 30;
					case 5 : return 31;
					case 6 : return 30;
					case 7 : return 31;
					case 8 : return 31;
					case 9 : return 30;
					case 10 : return 31;
					case 11 : return 30;
					case 12 : return 31;
					default : return 0;
				}
			}
		}
}
