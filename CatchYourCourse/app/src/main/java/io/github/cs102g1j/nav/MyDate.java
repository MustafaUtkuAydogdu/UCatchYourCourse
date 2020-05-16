package io.github.cs102g1j.nav;
// Have this comment read and edit regarding it
// https://github.com/MuhammedCanKucukaslan/cs102g1J/commit/77a311b3f2d7345b865a6bcb6e936a5c982d2c1b#commitcomment-39071806
public class MyDate
{
   //properties
   //int day; //Sunday is 1, Saturday is 7. (To be compatible with Calendar Class).
   //int hour; //Write it according to GM + 0 ( Turkey is +3 so subtract 3 from Turkey's time)
   private int startTime;
   private int endTime;

   //constructors
   public MyDate( int day, int hour, int minuteStart, int duration)
   {
      this.startTime = (day - 2) * 1440 + hour * 60 + minuteStart;
      this.endTime = startTime + duration;
   }

   public MyDate(int timeStart, int timeEnd )
   {
      this.startTime = timeStart;
      this.endTime = timeEnd;
   }

   //methods
   public boolean isIncludes( MyDate time)
   {
      if ( startTime <= time.startTime && endTime >= time.endTime)
      {
         return true;
      }
      return false;
   }

   public int getStartTime()
   {
      return  startTime;
   }

   public int getEndTime()
   {
      return  endTime;
   }

}
