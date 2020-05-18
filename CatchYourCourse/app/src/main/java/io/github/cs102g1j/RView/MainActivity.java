package io.github.cs102g1j.RView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
   private ArrayList< ExampleItem > mExampleList;
   private RecyclerView mRecyclerView;
   private io.github.cs102g1j.RView.ExampleAdapter mAdapter;
   private RecyclerView.LayoutManager mLayoutManager;
   private Button buttonInsert;
   private EditText editTextInsert;
   private EditText editTextRemove;
   private EditText lectureNameText;
   private EditText buildingNameText;

   private Button saveButton;

   @Override
   protected void onCreate( Bundle savedInstanceState )
   {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_main );

      loadData();

      //   createExampleList();

      buildRecyclerView();
      setButtons();
   }

   public void insertItem( int position, String lectureName, String buildingName
                         )
   {
      mExampleList.add( position,
                        new ExampleItem( R.drawable.bilkent,
                                         "Lecture : " + lectureName,
                                         "Building Name " + buildingName
                        )
                      );
      mAdapter.notifyItemInserted( position );
   }

   public void removeItem( int position )
   {
      mExampleList.remove( position );
      mAdapter.notifyItemRemoved( position );
   }

   public void changeItem( int position, String text )
   {
      mExampleList.get( position ).changeText1( text );
      mAdapter.notifyItemChanged( position );
   }

   public void createExampleList()
   {
      mExampleList = new ArrayList<>();

   }

   public void buildRecyclerView()
   {
      mRecyclerView = findViewById( R.id.recyclerView );
      // mRecyclerView.setHasFixedSize( true );
      mLayoutManager = new LinearLayoutManager( this );
      mAdapter = new ExampleAdapter( mExampleList );
      mRecyclerView.setLayoutManager( mLayoutManager );
      mRecyclerView.setAdapter( mAdapter );
      mAdapter.setOnItemClickListener( new ExampleAdapter.OnItemClickListener()
      {
         @Override
         public void onItemClick( int position )
         {
            changeItem( position, "Clicked" );
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

            insertItem( position, lectureName, buildingName );
         }
      } );

      saveButton.setOnClickListener( new View.OnClickListener()
      {
         @Override
         public void onClick( View v )
         {
            saveData();
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
      Type type = new TypeToken< ArrayList< ExampleItem > >()
      {
      }.getType();
      mExampleList = gson.fromJson( json, type );
      if ( mExampleList == null )
      {
         mExampleList = new ArrayList<>();
      }
   }
}