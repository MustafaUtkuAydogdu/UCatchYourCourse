package io.github.cs102g1j.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.github.cs102g1j.R;
import io.github.cs102g1j.nav.MyLessons;
/**
 * This fragment is where MyLesson objects are demonstrated as RecyclerView.
 * @author Muhammed Can Küçükaslan
 * @author Melis Atun
 * @author Deniz Özay
 * @see RecyclerView
 * @see io.github.cs102g1j.nav.MyLesson
 * @see io.github.cs102g1j.nav.MyLessons
 */
public class ScheduleMain extends Fragment
{
   private MyLessons myLessons;
   private RecyclerView recyclerView;
   private MyListAdapter adapter;

   @Override
   public View onCreateView( LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState
                           )
   {
      // Inflate the layout for this fragment
      return inflater.inflate( R.layout.schedule_main, container, false );
   }

   public void onViewCreated( @NonNull View view, Bundle savedInstanceState )
   {
      super.onViewCreated( view, savedInstanceState );
      //// initiate MyLesson
      //myLessons = new MyLessons();
      //// add test values
      //myLessons.addTest();
      //
      //// RecyclerView setup
      //recyclerView = view.findViewById( R.id.recyclerView );
      //
      //adapter = new MyListAdapter( myLessons );
      //
      ////      recyclerView.setHasFixedSize(true);
      //recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );
      //recyclerView.setAdapter( adapter );
      //
      // Addition FAB was here, removed!
   }// this is end of METHOD onViewCreated(), I assure myself.
} // this is end of the CLASS, for sure
