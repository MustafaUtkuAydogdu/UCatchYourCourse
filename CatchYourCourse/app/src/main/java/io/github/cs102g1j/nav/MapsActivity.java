package io.github.cs102g1j.nav;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import io.github.cs102g1j.R;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
 // class MapsActivity'de "MyClasses" arrayList'i property'si
   private GoogleMap mMap;
   LocationManager locationManager;
   LocationListener locationListener;
   LatLng V_BUILDING = new LatLng( 39.867379025065425, 32.75014751011084);
   LatLng EE_BUILDING = new LatLng( 39.8721596623455, 32.75088418742559);
   final MyDate EE_Date = new MyDate( 2, 9, 30, 40);
   final MyDate V_Date = new MyDate( 3, 9, 30, 40);
   boolean isInVBuilding = false;
   boolean isInEEBuilding = false;

   @Override
   public void onRequestPermissionsResult( int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) 
   {
      super.onRequestPermissionsResult( requestCode, permissions, grantResults);
      if ( requestCode == 1)
      {
         if ( grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
         {
            if ( ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            {
               locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
         }
      }
   }

   @Override
   protected void onCreate( Bundle savedInstanceState) 
   {
      super.onCreate( savedInstanceState);
      setContentView( R.layout.activity_maps);
      // Obtain the SupportMapFragment and get notified when the map is ready to be used.
      SupportMapFragment mapFragment = ( SupportMapFragment) getSupportFragmentManager()
                                                               .findFragmentById(R.id.map);
      mapFragment.getMapAsync( this);
      locationManager = ( LocationManager) this.getSystemService( Context.LOCATION_SERVICE);
      locationListener = new LocationListener() 
      {
         @Override
         public void onLocationChanged( Location location) 
         {
            Toast.makeText( MapsActivity.this, location.toString(),Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onStatusChanged( String provider, int status, Bundle extras) 
         {

         }

         @Override
         public void onProviderEnabled( String provider) 
         {

         }

         @Override
         public void onProviderDisabled( String provider) 
         {

         }
      };
      if ( Build.VERSION.SDK_INT < 23)
      {
         locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, locationListener);
      }
      else
      {
         if ( ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
         {
            ActivityCompat.requestPermissions( this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
         }
         else
         {
            locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, locationListener);
         }
      }
   }


   /**
    * Manipulates the map once available.
    * This callback is triggered when the map is ready to be used.
    * This is where we can add markers or lines, add listeners or move the camera. In this case,
    * we just add a marker near Sydney, Australia.
    * If Google Play services is not installed on the device, the user will be prompted to install
    * it inside the SupportMapFragment. This method will only be triggered once the user has
    * installed Google Play services and returned to the app.
    */
   @Override
   public void onMapReady( GoogleMap googleMap) 
   {
      mMap = googleMap;

      locationManager = ( LocationManager) this.getSystemService( Context.LOCATION_SERVICE);
      locationListener = new LocationListener() 
      {
         @Override
         public void onLocationChanged( Location location) 
         {
            mMap.clear();
            LatLng userLocation = new LatLng( location.getLatitude(), location.getLongitude());
            mMap.addMarker( new MarkerOptions().position( userLocation).title( "Your Location"));
            mMap.moveCamera( CameraUpdateFactory.newLatLng( userLocation));

            Calendar calendar = Calendar.getInstance( TimeZone.getDefault());
            MyDate currentDate = new MyDate( calendar.get( Calendar.DAY_OF_WEEK), calendar.get( Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.MINUTE));
            if ( EE_Date.isIncludes( currentDate) && distance( location.getLatitude(), location.getLongitude(), EE_BUILDING.latitude, EE_BUILDING.longitude ) <= 0.015 )
            {
               isInEEBuilding = true;
            }
            else
            {
               isInEEBuilding = false;
            }

            if ( V_Date.isIncludes( currentDate) && distance( location.getLatitude(), location.getLongitude(), V_BUILDING.latitude, V_BUILDING.longitude ) <= 0.015 )
            {
               isInVBuilding = true;
            }
            else
            {
               isInVBuilding = false;
            }
         }

         @Override
         public void onStatusChanged( String provider, int status, Bundle extras) 
         {

         }

         @Override
         public void onProviderEnabled( String provider) 
         {

         }

         @Override
         public void onProviderDisabled( String provider) 
         {

         }
      };
      if ( Build.VERSION.SDK_INT < 23)
      {
         locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
      }
      else
      {
         if (ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
         {
            ActivityCompat.requestPermissions( this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
         }
         else
         {
            locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            Location lastKnownLocation = locationManager.getLastKnownLocation( LocationManager.GPS_PROVIDER);

            mMap.clear();
            LatLng userLocation = new LatLng( lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            mMap.addMarker( new MarkerOptions().position( userLocation).title( "Your Location"));
            mMap.moveCamera( CameraUpdateFactory.newLatLng( userLocation));

         }
      }


   }

   private double distance( double lat1, double lon1, double lat2, double lon2) 
   {
      double theta = lon1 - lon2;
      double dist = Math.sin( deg2rad(lat1))
                    * Math.sin( deg2rad(lat2))
                    + Math.cos( deg2rad(lat1))
                      * Math.cos( deg2rad(lat2))
                      * Math.cos( deg2rad(theta));
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
}
