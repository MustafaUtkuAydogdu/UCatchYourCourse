package io.github.cs102g1j.nav;


import android.location.Location;

import java.text.ParseException;

import io.github.cs102g1j.nav.Building;

public class MyClasses
{
   //constants



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
