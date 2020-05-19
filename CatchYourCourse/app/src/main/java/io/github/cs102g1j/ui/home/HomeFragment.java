package io.github.cs102g1j.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import io.github.cs102g1j.R;
import io.github.cs102g1j.nav.MapsActivity;
import io.github.cs102g1j.nav.MyLessons;
import io.github.cs102g1j.schedule.MyListAdapter;
import io.github.cs102g1j.schedule.ScheduleMain;

public class HomeFragment extends Fragment
{
   // private HomeViewModel homeViewModel;
   private MyLessons myLessons;
   private RecyclerView recyclerView;
   private MyListAdapter adapter;

   public View onCreateView( @NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState
                           )
   {
      //homeViewModel = ViewModelProviders.of( this ).get( HomeViewModel.class );
      View root = inflater.inflate( R.layout.fragment_home, container, false );

      // initiate MyLesson
      myLessons = new MyLessons();
      // add test values
      myLessons.addTest();

      // RecyclerView setup
      recyclerView = root.findViewById( R.id.recyclerView );
      adapter = new MyListAdapter( myLessons );
      //recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );
      recyclerView.setAdapter( adapter );

      root.findViewById( R.id.home_play )
          .setOnClickListener( new View.OnClickListener()
          {
             @Override
             public void onClick( View view )
             {
                Intent intent = new Intent( getContext(), MapsActivity.class );
                startActivity( intent );
            /*
            NavHostFragment.findNavController( HomeFragment.this )
                           .navigate( R.id.action_scheduleMain_to_scheduleAdd );*/
             }
          } );

      root.findViewById( R.id.home_pokedex )
          .setOnClickListener( new View.OnClickListener()
          {
             @Override
             public void onClick( View view )
             {
                Snackbar snackbar = Snackbar.make( view,
                                                   "Pokedex screen is coming soon",
                                                   Snackbar.LENGTH_SHORT
                                                 );
                snackbar.show();
             }
          } );

      root.findViewById( R.id.home_bag )
          .setOnClickListener( new View.OnClickListener()
          {
             @Override
             public void onClick( View view )
             {
                Snackbar snackbar = Snackbar.make( view,
                                                   "Pokemon bag screen is coming soon",
                                                   Snackbar.LENGTH_SHORT
                                                 );
                snackbar.show();
             }
          } );

      root.findViewById( R.id.home_item )
          .setOnClickListener( new View.OnClickListener()
          {
             @Override
             public void onClick( View view )
             {
                Snackbar snackbar = Snackbar.make( view,
                                                   "Items screen coming soon",
                                                   Snackbar.LENGTH_SHORT
                                                 );
                snackbar.show();
             }
          } );
      return root;
   }
}
