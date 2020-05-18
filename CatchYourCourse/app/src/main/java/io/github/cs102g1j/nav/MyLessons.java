package io.github.cs102g1j.nav;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class MyLessons
{
   //properties
   ArrayList<MyLesson> myLessons;

   //constructors
   public MyLessons()
   {
      myLessons = new ArrayList <MyLesson>( );

   }

   //methods
   public void addLesson( MyLesson lesson)
   {
      myLessons.add( lesson );
   }

   public MyLesson getLesson(int index)
   {
      if (index < 0 || index >= myLessons.size())

         return null;

      return myLessons.get(index);
   }

   public MyLesson getNextLesson()
   {
      int indexOfNextLesson;
      if (myLessons.size() == 0 )
         return null;
      else
      {
         Calendar calendar = Calendar.getInstance( TimeZone.getDefault() );
         MyDate currentDate = new MyDate( calendar.get( Calendar.DAY_OF_WEEK ),
                                          calendar.get( Calendar.HOUR_OF_DAY ),
                                          calendar.get( Calendar.MINUTE ),
                                          calendar.get( Calendar.MINUTE )
         );

         double min;
         min = myLessons.get( 0 ).getLectureTime().getStartTime() - currentDate.getStartTime();
          indexOfNextLesson = 0;

         for (int i  = 0; i  < myLessons.size(); i++)
         {
            if (myLessons.get(i).getLectureTime().getStartTime()- currentDate.getStartTime() < min)
            {
               min = myLessons.get( i ).getLectureTime().getStartTime() - currentDate.getStartTime();
               indexOfNextLesson = i;
            }
         }

      }
      return myLessons.get( indexOfNextLesson );
   }

   public int size()
   {
      return myLessons.size();
   }

   public void addTest()
   {
      //  MyLesson( MyDate date, Building building, String lectureName)
      // MyDate( int day, int hour, int minuteStart, int duration)
      addLesson( new MyLesson( new MyDate( 7, 8, 40, 600),
                               Building.BUILDING_EE, "Math 102") );
      addLesson( new MyLesson( new MyDate( 2, 9, 40, 120), Building.BUILDING_V, "CS101: Algorithms and Programming I") );
      addLesson( new MyLesson( new MyDate( 4, 8, 40, 120), Building.BUILDING_EA, "GRA 215 Computer Graphics for Film and Television I") );
      addLesson( new MyLesson( new MyDate( 4, 13, 40, 120), Building.BUILDING_EA, "HART 431 The Archaeology of Cyprus in the Bronze Age") );
      addLesson( new MyLesson( new MyDate( 3, 9, 40, 120), Building.BUILDING_B, "MATH 132 Discrete and Combinatorial Mathematics") );
      addLesson( new MyLesson( new MyDate( 6, 12, 40, 120), Building.BUILDING_S, "POLS 344 Turkish Nationalism :Politics and Ideology") );
      addLesson( new MyLesson( new MyDate( 2, 9, 40, 120), Building.BUILDING_EE, "CS 443 Cloud Computing and Mobile Applications") );
      addLesson( new MyLesson( new MyDate( 5, 9, 40, 120), Building.BUILDING_EE, "CS 453 Application Lifecycle Management") );
      addLesson( new MyLesson( new MyDate( 2, 7, 40, 120), Building.BUILDING_EE, "CS 443 Cloud Computing and Mobile Applications") );
      addLesson( new MyLesson( new MyDate( 4, 13, 40, 120), Building.BUILDING_EA, "POLS 344 Turkish Nationalism :Politics and Ideology") );
      addLesson( new MyLesson( new MyDate( 5, 7, 40, 120), Building.BUILDING_EE, "CS 443 Cloud Computing and Mobile Applications") );
      addLesson( new MyLesson( new MyDate( 5, 12, 40, 120), Building.BUILDING_EE, "GRA 215 Computer Graphics for Film and Television I") );
      addLesson( new MyLesson( new MyDate( 2, 13, 40, 120), Building.BUILDING_EE, "CS 201 Fundamental Structures of Computer Science I") );
      addLesson( new MyLesson( new MyDate( 4, 7, 40, 120), Building.BUILDING_EA, "CS 453 Application Lifecycle Management") );
      addLesson( new MyLesson( new MyDate( 3, 11, 40, 120), Building.BUILDING_B, "CS 453 Application Lifecycle Management") );
      addLesson( new MyLesson( new MyDate( 6, 13, 40, 120), Building.BUILDING_S, "MBG 110 Introduction to Modern Biology") );
      addLesson( new MyLesson( new MyDate( 5, 11, 40, 120), Building.BUILDING_S, "CS101: Algorithms and Programming I") );
      addLesson( new MyLesson( new MyDate( 6, 9, 40, 120), Building.BUILDING_V, "MBG 110 Introduction to Modern Biology") );
      addLesson( new MyLesson( new MyDate( 2, 8, 40, 120), Building.BUILDING_S, "GRA 215 Computer Graphics for Film and Television I") );
      addLesson( new MyLesson( new MyDate( 6, 14, 40, 120), Building.BUILDING_B, "MATH 132 Discrete and Combinatorial Mathematics") );
      addLesson( new MyLesson( new MyDate( 3, 12, 40, 120), Building.BUILDING_S, "ELIT 273 Medieval and Renaissance Literature") );
      addLesson( new MyLesson( new MyDate( 6, 13, 40, 120), Building.BUILDING_EE, "CS101: Algorithms and Programming I") );
      addLesson( new MyLesson( new MyDate( 4, 10, 40, 120), Building.BUILDING_S, "MATH 253 Introduction to Number Theory") );
      addLesson( new MyLesson( new MyDate( 3, 10, 40, 120), Building.BUILDING_EE, "CS 453 Application Lifecycle Management") );
      addLesson( new MyLesson( new MyDate( 4, 8, 40, 120), Building.BUILDING_EE, "EEE 485 Statistical Learning and Data Analytics") );
      addLesson( new MyLesson( new MyDate( 4, 7, 40, 120), Building.BUILDING_EE, "GRA 215 Computer Graphics for Film and Television I") );
      addLesson( new MyLesson( new MyDate( 4, 15, 40, 120), Building.BUILDING_B, "HUM 111 Cultures Civilizations and Ideas I") );
      addLesson( new MyLesson( new MyDate( 3, 12, 40, 120), Building.BUILDING_B, "CS 443 Cloud Computing and Mobile Applications") );
      addLesson( new MyLesson( new MyDate( 4, 14, 40, 120), Building.BUILDING_S, "Eng101: English and Composition I") );
      addLesson( new MyLesson( new MyDate( 2, 14, 40, 120), Building.BUILDING_S, "CS 453 Application Lifecycle Management") );
      addLesson( new MyLesson( new MyDate( 3, 11, 40, 120), Building.BUILDING_V, "CS 453 Application Lifecycle Management") );
      addLesson( new MyLesson( new MyDate( 5, 10, 40, 120), Building.BUILDING_V, "POLS 344 Turkish Nationalism :Politics and Ideology") );
      addLesson( new MyLesson( new MyDate( 5, 14, 40, 120), Building.BUILDING_V, "Eng101: English and Composition I") );
      addLesson( new MyLesson( new MyDate( 5, 14, 40, 120), Building.BUILDING_S, "GRA 215 Computer Graphics for Film and Television I") );
      addLesson( new MyLesson( new MyDate( 4, 14, 40, 120), Building.BUILDING_V, "CS 443 Cloud Computing and Mobile Applications") );
      addLesson( new MyLesson( new MyDate( 5, 9, 40, 120), Building.BUILDING_EA, "CS 453 Application Lifecycle Management") );
      addLesson( new MyLesson( new MyDate( 6, 9, 40, 120), Building.BUILDING_EA, "GRA 215 Computer Graphics for Film and Television I") );
      addLesson( new MyLesson( new MyDate( 4, 14, 40, 120), Building.BUILDING_EE, "MATH 225 Linear Algebra and Differential Equations") );
      addLesson( new MyLesson( new MyDate( 3, 8, 40, 120), Building.BUILDING_B, "CS 453 Application Lifecycle Management") );
      addLesson( new MyLesson( new MyDate( 3, 13, 40, 120), Building.BUILDING_EE, "MATH 132 Discrete and Combinatorial Mathematics") );
      addLesson( new MyLesson( new MyDate( 4, 12, 40, 120), Building.BUILDING_V, "CS 443 Cloud Computing and Mobile Applications") );
      addLesson( new MyLesson( new MyDate( 2, 7, 40, 120), Building.BUILDING_EA, "EEE 485 Statistical Learning and Data Analytics") );
      addLesson( new MyLesson( new MyDate( 4, 14, 40, 120), Building.BUILDING_S, "CS 443 Cloud Computing and Mobile Applications") );
      addLesson( new MyLesson( new MyDate( 3, 10, 40, 120), Building.BUILDING_V, "POLS 344 Turkish Nationalism :Politics and Ideology") );
      addLesson( new MyLesson( new MyDate( 6, 14, 40, 120), Building.BUILDING_EA, "Eng101: English and Composition I") );
      addLesson( new MyLesson( new MyDate( 3, 14, 40, 120), Building.BUILDING_EE, "POLS 344 Turkish Nationalism :Politics and Ideology") );
      addLesson( new MyLesson( new MyDate( 2, 11, 40, 120), Building.BUILDING_B, "HART 431 The Archaeology of Cyprus in the Bronze Age") );
      addLesson( new MyLesson( new MyDate( 2, 12, 40, 120), Building.BUILDING_B, "EEE 485 Statistical Learning and Data Analytics") );
      addLesson( new MyLesson( new MyDate( 5, 7, 40, 120), Building.BUILDING_S, "POLS 344 Turkish Nationalism :Politics and Ideology") );
      addLesson( new MyLesson( new MyDate( 5, 15, 40, 120), Building.BUILDING_EA, "CS 443 Cloud Computing and Mobile Applications") );
      addLesson( new MyLesson( new MyDate( 2, 9, 40, 120), Building.BUILDING_EE, "GRA 215 Computer Graphics for Film and Television I") );


   }
}
