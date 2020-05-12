package io.github.cs102g1j.nav;


import android.location.Location;

import java.text.ParseException;

import io.github.cs102g1j.nav.Building;

public class MyClasses
{
   //constants
   public final String MATH_102 = "MATH_102";
   public final String CS_102 =   "CS_102";
   public final String ENG_102 = "ENG_102";
   public final String MATH_132 = "MATH_132";
   public final String TURK_102 = "TURK_102";



   //properties
   String lectureName;
   Building lectureBuilding;
   MyDate lectureTime;


   //constructors
   public MyClasses( MyDate date, Building building, String lectureName)
   {
      lectureTime = date;
      lectureBuilding = building;
      this.lectureName = lectureName;

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

   /* WE CAN CHANGE THİS THE WAY BY ADDİNG SOME LOCATİON FEATURES OR GETTİNG CURRENT LOCATİON FROM LOCATİON CLASS.
   public boolean isNow( Location currentLocation) throws ParseException {
      if (lectureBuilding.isNearer(10,currentLocation) && lectureTime.isNow())
         return true;
      else return false;

   }
   *
    */





}
