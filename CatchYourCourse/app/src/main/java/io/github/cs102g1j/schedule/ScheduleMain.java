package io.github.cs102g1j.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import io.github.cs102g1j.R;

public class ScheduleMain extends Fragment
{

   @Override
   public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
                           )
   {
      // Inflate the layout for this fragment
      return inflater.inflate( R.layout.schedule_main, container, false );
   }

   public void onViewCreated( @NonNull View view, Bundle savedInstanceState )
   {
      super.onViewCreated( view, savedInstanceState );

      view.findViewById( R.id.button_first ).setOnClickListener( new View.OnClickListener()
      {
         @Override
         public void onClick( View view )
         {
            NavHostFragment.findNavController( ScheduleMain.this )
                           .navigate( R.id.action_scheduleMain_to_scheduleAdd );
         }
      } );
   }
}
