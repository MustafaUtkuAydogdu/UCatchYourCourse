/**
*This is the ScheduleActivity class.
*@author Muhammed Can Küçükaslan
*@author Melis Atun
*@author Deniz Özay
*/
package io.github.cs102g1j.schedule;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.cs102g1j.R;
import io.github.cs102g1j.nav.MyLessons;

public class ScheduleActivity extends AppCompatActivity
{
   private AppBarConfiguration mAppBarConfiguration;
   private NavController navController;

   @Override
   protected void onCreate( Bundle savedInstanceState )
   {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_schedule );
      Toolbar toolbar = findViewById( R.id.toolbar );
      setSupportActionBar( toolbar );

      // Navigation bar
      DrawerLayout drawer = findViewById( R.id.drawer_layout );
      NavigationView navigationView = findViewById( R.id.nav_view );

      // Only Schedule main is top destination, scheduleAdd is a helper user interface
      mAppBarConfiguration = new AppBarConfiguration.Builder( R.id.scheduleMain ).setDrawerLayout( drawer ).build();
      navController = Navigation.findNavController( this, R.id.nav_host_fragment_schedule );
      NavigationUI.setupActionBarWithNavController( this, navController, mAppBarConfiguration );
      NavigationUI.setupWithNavController( navigationView, navController );
   }
}
