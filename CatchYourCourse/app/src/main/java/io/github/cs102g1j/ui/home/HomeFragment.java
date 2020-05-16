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

import io.github.cs102g1j.R;
import io.github.cs102g1j.nav.MapsActivity;
import io.github.cs102g1j.schedule.ScheduleMain;

public class HomeFragment extends Fragment
{

   private HomeViewModel homeViewModel;

   public View onCreateView( @NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState
                           )
   {
      homeViewModel = ViewModelProviders.of( this ).get( HomeViewModel.class );
      View root = inflater.inflate( R.layout.fragment_home, container, false );
      final TextView textView = root.findViewById( R.id.homeTop );
      homeViewModel.getText().observe( getViewLifecycleOwner(), new Observer< String >()
      {
         @Override
         public void onChanged( @Nullable String s )
         {
            textView.setText( s );
         }
      } );

      // There is much to discover
      /*
      Button button = (Button) findViewById(R.id.home_play);
      button.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
            Toast
         }
      });
      */
      root.findViewById( R.id.home_play ).setOnClickListener( new View.OnClickListener()
      {
         @Override
         public void onClick( View view )
         {
            Intent intent = new Intent( getContext(), MapsActivity.class);
            startActivity(intent);
            /*
            NavHostFragment.findNavController( HomeFragment.this )
                           .navigate( R.id.action_scheduleMain_to_scheduleAdd );*/
         }
      } );
      return root;
   }
}
