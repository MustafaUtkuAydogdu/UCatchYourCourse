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
      myLessons = new ArrayList<MyLesson>( );

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
}
