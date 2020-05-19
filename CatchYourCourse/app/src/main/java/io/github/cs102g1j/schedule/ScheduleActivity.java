/**
 * This is the ScheduleActivity class.
 * @author Mustafa Yasir Altunhan
 * @author Mustafa Utku Aydoğdu
 * @author Muhammed Can Küçükaslan
 * @author Giray Akyol
 */
package io.github.cs102g1j.schedule;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

import io.github.cs102g1j.MainActivity;
import io.github.cs102g1j.R;
import io.github.cs102g1j.nav.Building;
import io.github.cs102g1j.nav.MyDate;
import io.github.cs102g1j.nav.MyLesson;
import io.github.cs102g1j.nav.MyLessons;

public class ScheduleActivity extends AppCompatActivity
{
   //properties
   private AppBarConfiguration mAppBarConfiguration;
   private NavController navController;


   private MyLessons mExampleList;
   private RecyclerView mRecyclerView;
   private MyListAdapter mAdapter;
   private RecyclerView.LayoutManager mLayoutManager;
   private Button buttonInsert;
   private EditText editTextInsert;
   private EditText editTextRemove;
   private EditText lectureNameText;
   private EditText buildingNameText;

   private Button saveButton;


   MyLessons exportedList;

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
      mAppBarConfiguration
         = new AppBarConfiguration.Builder( R.id.scheduleMain ).setDrawerLayout(
         drawer ).build();
      navController = Navigation.findNavController( this,
                                                    R.id.nav_host_fragment_schedule
                                                  );
      NavigationUI.setupActionBarWithNavController( this,
                                                    navController,
                                                    mAppBarConfiguration
                                                  );
      NavigationUI.setupWithNavController( navigationView, navController );

      //taking the data stored in the disk
      loadData();

      //createExampleList();

      //setting up the recyclerView screen
      buildRecyclerView();
      //activating the buttons
      setButtons();
   }

   public void insertItem( int position,
                           MyDate myDate,
                           Building building,
                           String lectureName
                         )
   {
      mExampleList.add( position,
                        new MyLesson( myDate, building, lectureName )
                      );
      mAdapter.notifyItemInserted( position );
   }

   public void removeItem( int position )
   {
      mExampleList.remove( position );
      mAdapter.notifyItemRemoved( position );
   }


   public void createExampleList()
   {
      mExampleList = new MyLessons();
   }

   public void buildRecyclerView()
   {
      mRecyclerView = findViewById( R.id.recyclerView );
      mRecyclerView.setHasFixedSize( true );
      mLayoutManager = new LinearLayoutManager( this );
      mAdapter = new MyListAdapter( mExampleList );
      mRecyclerView.setLayoutManager( mLayoutManager );
      mRecyclerView.setAdapter( mAdapter );
      mAdapter.setOnItemClickListener( new MyListAdapter.OnItemClickListener()
      {
         @Override
         public void onItemClick( int position )
         {
            //empty
         }

         @Override
         public void onDeleteClick( int position )
         {
            removeItem( position );
         }
      } );
   }

   public void setButtons()
   {
      buttonInsert = findViewById( R.id.button_insert );
      saveButton = findViewById( R.id.button_save );
      editTextInsert = findViewById( R.id.edittext_insert );
      editTextRemove = findViewById( R.id.edittext_remove );
      lectureNameText = findViewById( R.id.lectureName );
      buildingNameText = findViewById( R.id.buildingName );

      buttonInsert.setOnClickListener( new View.OnClickListener()
      {
         @Override
         public void onClick( View v )
         {
            int position = Integer.parseInt( editTextInsert.getText()
                                                           .toString() );
            String lectureName = lectureNameText.getText().toString();
            String buildingName = buildingNameText.getText().toString();

            MyDate myDate = new MyDate( 2, 8, 40, 120 );
            Building building = Building.getBuilding( buildingNameText.getText()
                                                                      .toString()
                                                                      .toUpperCase() );
            insertItem( position, myDate, building, lectureName );

         }
      } );

      saveButton.setOnClickListener( new View.OnClickListener()
      {
         @Override
         public void onClick( View v )
         {
            saveData();

            Intent intent;
            intent = new Intent( ScheduleActivity.this, MainActivity.class );
            intent.putExtra( "linker", createList( mExampleList ) );
            startActivity( intent );

         }
      } );
   }

   public void saveData()
   {
      SharedPreferences sharedPreferences = getSharedPreferences(
         "shared preferences",
         MODE_PRIVATE
                                                                );
      SharedPreferences.Editor editor = sharedPreferences.edit();
      Gson gson = new Gson();
      String json = gson.toJson( mExampleList );
      editor.putString( "task list", json );
      editor.apply();
      Toast.makeText( this, "Dersleriniz kaydedildi", Toast.LENGTH_LONG )
           .show();

   }

   public void loadData()
   {
      SharedPreferences sharedPreferences = getSharedPreferences(
         "shared preferences",
         MODE_PRIVATE
                                                                );
      Gson gson = new Gson();
      String json = sharedPreferences.getString( "task list", null );
      Type type = new TypeToken< MyLessons >()
      {
      }.getType();
      mExampleList = gson.fromJson( json, type );
      if ( mExampleList == null )
      {
         mExampleList = new MyLessons();
      }
   }

   public MyLessons createList( MyLessons k )
   {
      MyLessons exportList = new MyLessons();

      for ( int i = 0; i < k.size(); i++ )
      {
         exportList.add( k.get( i ) );
      }
      return exportList;
   }
} // end of class
