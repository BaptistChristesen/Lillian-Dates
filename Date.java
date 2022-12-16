public class Date
{
  protected int year;
  protected int month;
  protected int day;
  public static final int MINYEAR = 1583;

  // Constructor
  public Date(int newMonth, int newDay, int newYear)
  {
    month = newMonth;
    day = newDay;
    year = newYear;
   }

  // Observers
  public int getYear()
  {
    return year;
  }

  public int getMonth()
  {
    return month;
  }

  public int getDay()
  {
    return day;
  }
    //Valid mwthod location
    public boolean valid(){
        boolean valid = false;
        //min year check
        if(year < 1583){
            return false;
        }
        //12 month only check
        if (month > 12){
            return false;
        }
        //30 day check
        if (month == 4 && day > 30 || month == 11 && day > 30){
            return false;
        }
        //leap year check
        if (month == 2 && year % 4 == 0){
            if (year%100 == 0){
                if (!((year/100)%4 == 0)){
                    return false;
                }
                else if (day > 29){
                    return false;
                }
            }
            else if(day > 29){
                    return false;
                }
        }
        else if (day > 28){
            return false;
        }
        //return value
        return true;
    }
  public int lilian()
  {
    // Returns the Lilian Day Number of this date.
    // Precondition: This Date is a valid date after 10/14/1582.
    //
    // Computes the number of days between 1/1/0 and this date as if no calendar
    // reforms took place, then subtracts 578,100 so that October 15, 1582 is day 1. 
    
    final int subDays = 578100;  // number of calculated days from 1/1/0 to 10/14/1582

    int numDays = 0;

    // Add days in years.
    numDays = year * 365;

    // Add days in the months.
    if (month <= 2) 
      numDays = numDays + (month - 1) * 31;
    else 
      numDays = numDays + ((month - 1) * 31) - ((4 * (month-1) + 27) / 10);

    // Add days in the days.
    numDays = numDays + day;

    // Take care of leap years.
    numDays = numDays + (year / 4) - (year / 100) + (year / 400);

    // Handle special case of leap year but not yet leap day.
    if (month < 3) 
    {
        if ((year % 4) == 0)   numDays = numDays - 1;
        if ((year % 100) == 0) numDays = numDays + 1;
        if ((year % 400) == 0) numDays = numDays - 1;
      }

    // Subtract extra days up to 10/14/1582.
    numDays = numDays - subDays;
    return numDays;
  }

  public String toString()
  // Returns this date as a String.
  {
    String ms = "";
    if (month == 1){ms = "January";}
    if (month == 2){ms = "February";}
    if (month == 3){ms = "March";}
    if (month == 4){ms = "April";}
    if (month == 5){ms = "May";}
    if (month == 6){ms = "June";}
    if (month == 7){ms = "July";}
    if (month == 8){ms = "August";}
    if (month == 9){ms = "September";}
    if (month == 10){ms = "October";}
    if (month == 11){ms = "November";}
    if (month == 12){ms = "December";}
    if (month > 12){
        month -= 12;
    }
    return(ms + " " + day + ", " + year);
  }

  public Date inverseLilian(int lilian)
  {
    int temp = ((lilian + 139444) * 100) / 3652425;
    int days = temp + lilian + 139444 - (temp / 4);
    temp  = days * 100 / 36525;
    if((days * 100) % 36525 == 0)
        temp -= 1;
    days = days - (temp * 36525 / 100);
    int years = temp + 1201;
            
    // account for leap year
    int leapDay = 0;
    if (years % 4 == 0)   leapDay ++;
    if (years % 100 == 0) leapDay --;
    if (years % 400 == 0) leapDay ++;
            
    if (days > leapDay + 59) days += (2 - leapDay);
    int months = (((days + 91) * 100) / 3055);
    days = (days + 91) - ((months * 3055) / 100);
    months -= 2;
            
    return new Date(months,days,years);
  }
  public void increment(){
      
  }

}
 