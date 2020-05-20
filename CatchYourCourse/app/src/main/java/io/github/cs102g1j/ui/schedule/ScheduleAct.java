/**
 * This is the ScheduleAct class.
 * @author Muhammed Can Küçükaslan
 * @author Mustafa Utku Aydoğdu
 * @author Mustafa Yasir Altunhan
 * @author Melis Atun
 */
package io.github.cs102g1j.ui.schedule;

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

public class ScheduleAct extends AppCompatActivity
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

   private EditText dayText;
   private EditText hourText;
   private EditText startMinuteText;
   private EditText durationText;

   private Button saveButton;


   MyLessons exportedList;

   // methods
   // This method is used to start an activity; super is used to call the parent class constructor; setContentView is used to set the xml.
   @Override
   protected void onCreate( Bundle savedInstanceState )
   {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_schedule);


      loadData();



      //createExampleList();

      //setting up the recyclerView screen
      buildRecyclerView();
      //activating the buttons
      setButtons();
   }

   // This method is used to insert an item to the list. Input is taken from the user, and added to the arrayList.
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

   // This method is used to remove an item from the list.
   public void removeItem( int position )
   {
      mExampleList.remove( position );
      mAdapter.notifyItemRemoved( position );
   }

   // This method is used for creating an example list. 
   public void createExampleList()
   {
      mExampleList = new MyLessons();
   }
   
   
   // This method is mainly for building the layout of RecylerView.
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
         
         // This method is for detecting when the user wants to remove an item, and clicks on it. 
         @Override
         public void onDeleteClick( int position )
         {
            removeItem( position );
         }
      } );
   }

   // This method is for setting all the buttons of RecyleView.
   public void setButtons()
   {
      buttonInsert = findViewById( R.id.button_insert );
      saveButton = findViewById( R.id.button_save );
      editTextInsert = findViewById( R.id.edittext_insert );
      editTextRemove = findViewById( R.id.edittext_remove );
      lectureNameText = findViewById( R.id.lectureName );
      buildingNameText = findViewById( R.id.buildingName );
      dayText = findViewById( R.id.dayText );
      hourText = findViewById( R.id.hourText );
      startMinuteText = findViewById( R.id.startMinute );
      durationText = findViewById( R.id.durationText );

      buttonInsert.setOnClickListener( new View.OnClickListener()
      {
      
         // This method is for creating the mExampleList by taking the input from the user.
         @Override
         public void onClick( View v )
         {
            int position = Integer.parseInt( editTextInsert.getText()
                                                           .toString() );
            String lectureName = lectureNameText.getText().toString();
            String buildingName = buildingNameText.getText().toString();

            int day = Integer.parseInt( dayText.getText()
                                                           .toString() );
            int hour = Integer.parseInt( hourText.getText()
                                                       .toString() );
            int startTime = Integer.parseInt( startMinuteText.getText()
                                                      .toString() );
            int duration = Integer.parseInt( durationText.getText()
                                                      .toString() );


            MyDate myDate = new MyDate( day, hour, startTime, duration);
            Building building = Building.getBuilding( buildingNameText.getText()
                                                                      .toString()
                                                                      .toUpperCase() );
            insertItem( position, myDate, building, lectureName );

         }
      } );

      saveButton.setOnClickListener( new View.OnClickListener()
      {
      
         // This method is for creating intent to the list. 
         @Override
         public void onClick( View v )
         {
            saveData();

            Intent intent;
            intent = new Intent( ScheduleAct.this, MainActivity.class );
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
