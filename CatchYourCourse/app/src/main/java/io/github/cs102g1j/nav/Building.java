package io.github.cs102g1j.nav;

import android.location.Location;

public class Building
{
   //constants locations
   public final static Building BUILDING_EE = new Building(39.872094, 32.750913,"BUILDING_EE");
   public final static Building BUILDING_EA = new Building(39.871195, 32.750058,"BUILDING_EA");
   public final static Building BUILDING_S = new Building(39.867909, 32.748267,"BUILDING_S");
   public final static Building BUILDING_B = new Building(39.868667, 32.748309,"BUILDING_B");
   public final static Building BUILDING_V = new Building(39.867379025065425, 32.75014751011084,"BUILDING_V");


   //properties
   String nameOfBuilding;
   double latitudeOfBuilding;
   double longitudeOfBuilding;



   //constructors
   public Building( double longitude, double latitude, String name)
   {
      nameOfBuilding = name;
      latitudeOfBuilding = latitude;
      longitudeOfBuilding = longitude;

   }

   public Building ( Building building)
   {
      nameOfBuilding = building.getNameOfBuilding();
      latitudeOfBuilding = building.getLatitudeOfBuilding();
      longitudeOfBuilding = building.getLongitudeOfBuilding();

   }

   //methods
   public String getNameOfBuilding()
   {
      return nameOfBuilding;
   }

   public double getLatitudeOfBuilding()
   {
      return latitudeOfBuilding;
   }

   public double getLongitudeOfBuilding()
   {
      return longitudeOfBuilding;
   }

   public double setLatitudeOfBuilding( double latitude)
   {
      latitudeOfBuilding = latitude;
      return latitude;
   }

   public double setLongitudeOfBuilding( double longtitude)
   {
      longitudeOfBuilding = longtitude;
      return longtitude;
   }

   private double getDistance( Location currentLocation ) 
   {
      double theta = longitudeOfBuilding - currentLocation.getLongitude();
      double dist = Math.sin( deg2rad( latitudeOfBuilding))
                    * Math.sin( deg2rad( currentLocation.getLatitude()))
                    + Math.cos( deg2rad( latitudeOfBuilding))
                      * Math.cos( deg2rad( currentLocation.getLatitude()))
                      * Math.cos( deg2rad( theta));
      dist = Math.acos( dist);
      dist = rad2deg( dist);
      dist = dist * 60 * 1.1515;
      return ( dist);
   }


   private double deg2rad( double deg) 
   {
      return ( deg * Math.PI / 180.0);
   }

   private double rad2deg( double rad)
   {
      return ( rad * 180.0 / Math.PI);
   }

   public boolean isNearer( double meter, Location currentLocation)
   {
      if ( getDistance( currentLocation) <= meter / 1000)
      {
         return true;
      }
      else
         return false;
   }
   @Override
   public String toString()
   {
      return nameOfBuilding;
   }
}
