package io.github.cs102g1j.nav;


import android.location.Location;

import java.text.ParseException;
import java.util.Calendar;
import java.util.TimeZone;

import io.github.cs102g1j.nav.Building;

public class MyLesson
{
   static final int DISTANCE_20 = 20;
   //properties
   private String lectureName;
   private Building lectureBuilding;
   private MyDate lectureTime;
   private boolean isTimeToAppearPokemon;

   //constructors
   public MyLesson( MyDate date, Building building, String lectureName )
   {
      lectureTime = date;
      lectureBuilding = building;
      this.lectureName = lectureName;
      isTimeToAppearPokemon = false;
   }


   //methods
   public String getLectureName()
   {
      return lectureName;
   }

   public Building getLectureBuilding()
   {
      return lectureBuilding;
   }

   public MyDate getLectureTime()
   {
      return lectureTime;
   }

   public boolean getIsTimeToAppearPokemon() { return isTimeToAppearPokemon; }

   // SHOULD THE SETTERS ALSO RETURN THE  VALUES WE SET
   public void setLectureName( String name)
   {
      lectureName = name;
   }

   public void setLectureBuilding( Building building)
   {
      lectureBuilding = building;

   }

   public void setLectureTime( MyDate date)
   {
      lectureTime = date;
   }



   public boolean isNow( Location currentLocation)
   {
      // getting the current time
      Calendar calendar = Calendar.getInstance( TimeZone.getDefault() );
      MyDate currentDate = new MyDate( calendar.get( Calendar.DAY_OF_WEEK ),
                                       calendar.get( Calendar.HOUR_OF_DAY ),
                                       calendar.get( Calendar.MINUTE ),
                                       calendar.get( Calendar.MINUTE )
      );


      isTimeToAppearPokemon = lectureBuilding.isNearer( DISTANCE_20, currentLocation ) &&
                              lectureTime.isIncludes( currentDate );

      return lectureBuilding.isNearer( DISTANCE_20, currentLocation ) &&



   }

   @Override
   public String toString()
   {
      return lectureName + " at " + lectureBuilding.toString()
             + "\nbetween " + lectureTime.normalize( lectureTime.getStartTime() )
             + " and " + lectureTime.normalize( lectureTime.getEndTime() );
   }
} // END OF the class
