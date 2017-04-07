
public class Date {

		private int day;
		private int month;
		private int year;
		
		public Date()
		{
			this.day = 1;
			this.month = 1;
			this.year = 2000;
		}
		public Date(int myDay, int myMonth, int myYear)
		{
			if (isValidDate(day, month, year) == true)
			{
				this.day = day;
				this.month = month;
				this.year = year;
			}
			else
			{
				this.day = 1;
				this.month = 1;
				this.year = 2000;
			}
		}
		public Date(Date other)
		{
			this.day = other.day;
			this.month = other.month;
			this.year= other.year;
		}
		public boolean setDate(int newDay, int newMonth, int newYear)
		{
			if (isValidDate(newDay, newMonth, newYear) == true)
			{
				this.day = newDay;
				this.month = newMonth;
				this.year = newYear;
				return true;
			}
			else
			{
				return false;
			}
		}
		//Datums-Validierer
		public boolean isValidDate(int anyDay, int anyMonth, int anyYear)
		{
			if (anyDay > 0 && anyMonth > 0 && anyYear > 1582) //alles kleiner 0 weg
			{
				if (anyDay < 32 && anyMonth < 13) // alles über Maximalwerten weg
				{
					if (anyMonth == 4 || anyMonth == 6 || anyMonth == 9 || anyMonth == 11) //alle Monate mit 30 Tage
					{
						anyDay = 30;
						return true;
					}
					else if (anyMonth == 1 || anyMonth == 3 || anyMonth == 5 || anyMonth == 7 || anyMonth == 8 ||
							anyMonth == 10 || anyMonth == 12) //alle Monate mit 31 Tage
					{
						anyDay = 31;
						return true;
					}
					else if (isLeapYear(anyYear) == true) //Februar Schaltjahr
					{
						anyMonth = 2;
						anyDay = 29;
						return true;
					}
					else if (isLeapYear(anyYear) == false) // Februar Kein Schaltjahr
					{
						anyMonth = 2;
						anyDay = 28;
						return true;
					}
					return true;
				}
				return true;
			}
			else
			{
				return false;
			}
		}
		//Datum davor
		public boolean isBefore(Date otherDate)
		{
			//Jahr davor oder gleich
			if(year <= otherDate.year)
			{
				//Monat davor oder gleich
				if(month <= otherDate.month)
				{
					//Tag davor oder gleich
					if(day <= otherDate.day)
					{
						return true;
					}
					return true;
				}
				return true;
			}
			//Problemlösung für das "oder gleich"
			else if (year == otherDate.year && month == otherDate.month && day == otherDate.day)
			{
				return false;
			}
			
			else
			{
				return false;
			}
		}
		//Nächster Tag
		public Date nextDay()
		{
			int NextD;
			int NextM;
			int NextY;
			
			NextD = this.day;
			NextM = this.month;
			NextY = this.year;
			
			if (isValidDate(NextD, NextM, NextY) == true)
			{
				NextD = NextD++;
			}
			//Jahreswechsel
			if(NextD < 32 && NextM < 13)
			{
				NextY = NextY++;
			}
				//Monatswechsel Apr, Jun, Sep, Nov
				if(NextD == 30 && (NextM == 4 || NextM == 6 || NextM == 9 || NextM == 11))
				{
					NextM++;
					NextD = 1;
				}
				//Monatswechsel Jan,Mär, Mai, Jul, Aug, Okt, Dez
				if (NextD == 31 && (NextM == 1 || NextM == 3 || NextM == 5 || NextM == 7 || NextM == 8 || NextM == 10
						|| NextM == 12))
				{
					NextM++;
					NextD = 1;
				}
				//Monatswechsel Feb(28)
				if(NextD < 30 &&(isLeapYear(NextY) == false))
				{
					NextM = 3;
					NextD = 1;
				}
				//Monatswechsel Feb(29)
				if(NextD < 30 &&(isLeapYear(NextY) == true))
				{
					NextM = 3;
					NextD = 1;
				}
				
				return new Date (NextD, NextM, NextY);
		}
		public String toString()
		{
			String SDate = "";
			
			if (this.day < 10)
			{
				SDate = SDate + "0" + this.day + ".";
			}
			else 
			{
				SDate = SDate + this.day + ".";
			}
			if (this.month < 10)
			{
				SDate = SDate + "0" + this.month + ".";
			}
			else
			{
				SDate = SDate + this.month + ".";
			}
			
			SDate = SDate + this.year;
			return SDate;
		}
		
		public static boolean isLeapYear(int year)
		{	
			if 
			((year % 4 == 0) && (year % 400 == 0 || year % 100 != 0))
			{
			return true;
			}
			else
			{
			return false;
			}
			}
}