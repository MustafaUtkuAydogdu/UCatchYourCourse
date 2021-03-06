package io.github.cs102g1j.nav;
/**
 * This is MyDate class.
 * @author Mustafa Yasir Altunhan.
 * @author Mustafa Utku Aydoğdu
 * @author Muhammed Can Küçükaslan
 * @version 19.05.2020
 */
import android.os.Parcel;
import android.os.Parcelable;

// Have this comment read and edit regarding it
// https://github.com/MuhammedCanKucukaslan/cs102g1J/commit/77a311b3f2d7345b865a6bcb6e936a5c982d2c1b#commitcomment-39071806
public class MyDate implements Parcelable
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

   /*
    * This is the constructor that we recreate/clone our object using the parcels coming from the writeToParcel method.
    * This method will be used in the
    * @param in is the information coming in.
    */
   public MyDate(int timeStart, int timeEnd )
   {
      this.startTime = timeStart;
      this.endTime = timeEnd;
   }

    /*
    * This is the method that we convert the properties of our myDate class to Strings.
    * Later on we will take these information to recreating object from its "parcels". ( in the MyDate( Parcel in) constructor)
    */
   protected MyDate( Parcel in )
   {
      startTime = in.readInt();
      endTime = in.readInt();
   }

   @Override
   public void writeToParcel( Parcel dest, int flags )
   {
      dest.writeInt( startTime );
      dest.writeInt( endTime );
   }

   /**
   * @return returns 0.
   */
   @Override
   public int describeContents()
   {
      return 0;
   }

   // Creating a MyDate object invoking the MyDate( Parcel in) constructor.
   // Also creates an array of MyDate in case of using a MyDate array in program.
   public static final Creator< MyDate > CREATOR = new Creator< MyDate >()
   {
      @Override
      public MyDate createFromParcel( Parcel in )
      {
         return new MyDate( in );
      }

      /**
      * This method creates an array, and has elements that are its size in it.
      */
      @Override
      public MyDate[] newArray( int size )
      {
         return new MyDate[ size ];
      }
   };

   // methods

   /*
   * This is the method that checks whether we are still in a current Lesson.
   * @param time is the MyDate object that is taken as input of current moment of user
   * @return returns true if there is still a lecture going on, false otherwise.
   */
   public boolean isIncludes( MyDate time)
   {
      return startTime <= time.startTime && endTime >= time.endTime;
   }

   /**
   * This method is for getting the startTime.
   */
   public int getStartTime()
   {
      return  startTime;
   }

   /**
   * This method is for getting the endTime.
   */
   public int getEndTime()
   {
      return  endTime;
   }


   /**
    * Gets a indication of time, and transform it to the plain text.
    * @param timeMinutes - minutes passed since the beginning of the week,
    * that is, 00:00 Sunday.
    * @return String demonstration of time, for example if timeMinutes is 320
    * that means 5 hours and 20 minutes after 00.00 Sunday it returns "5:20, Sunday"
    */
   public String normalize( int timeMinutes)
   {
      int minutes;
      int hour;
      int day;
      String dayName;
      dayName = "DAY ERROR";
      minutes = timeMinutes;
      hour = minutes / 60; // an hour is 60 minutes
      day = ( hour / 24 ); // a day is 24 hours

      minutes = minutes % 60;
      hour = hour % 24;
      day = 1 + ( day % 7); // 1 is for alignment
      if ( day == 1)
         dayName = "Sunday";
      else if ( day == 2 )
         dayName = "Monday";
      else if ( day == 3 )
         dayName = "Tuesday";
      else if ( day == 4 )
         dayName = "Wednesday";
      else if ( day == 5 )
         dayName = "Thursday";
      else if ( day == 6 )
         dayName = "Friday";
      else if ( day == 7 )
         dayName = "Saturday";
      return hour + ":" + minutes + ", " + dayName;
   }
}
