package io.github.cs102g1j;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import io.github.cs102g1j.ar.ARActivity;
import io.github.cs102g1j.nav.MapsActivity;

public class MainActivity extends AppCompatActivity
{

   private AppBarConfiguration mAppBarConfiguration;

   @Override
   /**
    * initialize the Main activity, its toolbar, DrawerLayour,
    * Fragment Navigation functions.
    */
   protected void onCreate( Bundle savedInstanceState )
   {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_main );
      Toolbar toolbar = findViewById( R.id.toolbar );
      setSupportActionBar( toolbar );
      DrawerLayout drawer = findViewById( R.id.drawer_layout );
      NavigationView navigationView = findViewById( R.id.nav_view );
      // Passing menu ID as a set of Ids that
      // menu should be considered as top level destinations.
      // Only scheduleAdd is not considered as top level destination
      // There is "three line" shaped button at the left corner of toolbar in top level destinations
      // while there is a "return" button at the left corner of toolbar in other destinations
      mAppBarConfiguration = new AppBarConfiguration.Builder( R.id.nav_home,
                                                              R.id.scheduleMain,
                                                              R.id.mapsActivity,
                                                              R.id.sceneform_ar_scene_view
      ).setDrawerLayout( drawer ).build();
      NavController navController = Navigation.findNavController( this,
                                                                  R.id.nav_host_fragment
                                                                );
      NavigationUI.setupActionBarWithNavController( this,
                                                    navController,
                                                    mAppBarConfiguration
                                                  );
      NavigationUI.setupWithNavController( navigationView, navController );
   }

   @Override
   public boolean onCreateOptionsMenu( Menu menu )
   {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate( R.menu.main, menu );
      return true;
   }

   @Override
   /**
    * Initializes the buttons on the toolbar ( such
    */
   public boolean onOptionsItemSelected( MenuItem item )
   {
      Intent intent;
      switch ( item.getItemId() )
      {
         case R.id.action_settings:
            intent = new Intent( this, ARActivity.class );
            startActivity( intent );
            return true;
         case R.id.action_find:
            intent = new Intent( this, MapsActivity.class );
            startActivity( intent );
            return true;
      }
      return super.onOptionsItemSelected( item );
   }

   @Override
   public boolean onSupportNavigateUp()
   {
      NavController navController = Navigation.findNavController( this,
                                                                  R.id.nav_host_fragment
                                                                );
      return NavigationUI.navigateUp( navController, mAppBarConfiguration ) ||
             super.onSupportNavigateUp();
   }
} // End of the class, if you don't think so go this link https://web.archive.org/web/20200309045607/https://pbs.twimg.com/media/ESpDAfOUUAAShrE.jpg
