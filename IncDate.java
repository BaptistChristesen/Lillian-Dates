
/**
 * Write a description of class IncDate here.
 *
 * @author (your name)
 * @version (today's date)
 */
public class IncDate extends Date
{
    public IncDate(int newMonth, int newDay, int newYear){
        super (newMonth, newDay, newYear);
    }
    public void increment(){
        IncDate aDate = new IncDate(day, month, year);
        day++;
        if(!valid()){
            day = 01;
            month++;
            if(!valid()){
                month = 01;
                day = 01;
                year++;
            }
        }
    }
    public void increment(int numDays){
        Date aDate = this.inverseLilian(this.lilian() + numDays);
        day = aDate.getDay();
        month = aDate.getMonth();
        year = aDate.getYear();
    }
}
