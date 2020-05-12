package io.github.cs102g1j.nav;
// Have this comment read and edit regarding it
// https://github.com/MuhammedCanKucukaslan/cs102g1J/commit/77a311b3f2d7345b865a6bcb6e936a5c982d2c1b#commitcomment-39071806
public class MyDate
{
   //properties
   int day; //Sunday is 1, Saturday is 7. (To be compatible with Calendar Class).
   int hour; //Write it according to GM + 0 ( Turkey is +3 so subtract 3 from Turkey's time)
   int timeStart;
   int timeEnd;

   //constructors
   public  MyDate( int day, int hour, int timeStart, int timeEnd)
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
