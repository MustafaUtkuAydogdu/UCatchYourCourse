package io.github.cs102g1j.nav;

public class MyDate
{
   //properties
   int day; //Sunday is 1, Saturday is 7. (To be compatible with Calendar Class).
   int hour; //Write it according to GM + 0 ( Turkey is +3 so subtract 3 from Turkey's time)
   int timeStart;
   int timeEnd;

   //constructors
   public  MyDate( int day,int hour, int timeStart,int timeEnd)
   {
      this.day = day;
      this.timeStart = timeStart;
      this.timeEnd = timeEnd;
      this.hour = hour;
   }

   //methods
   public boolean isIncludes( MyDate time)
   {
      if ( time.day == day && time.timeStart >= timeStart && time.timeEnd <= timeEnd && hour == time.hour)
      {
         return true;
      }
      return false;
   }

}
