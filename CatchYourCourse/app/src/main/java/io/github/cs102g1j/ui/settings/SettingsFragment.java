package io.github.cs102g1j.ui.settings;
// Have this read https://github.com/codepath/android_guides/wiki/Settings-with-PreferenceFragment
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import io.github.cs102g1j.R;

public class SettingsFragment extends PreferenceFragmentCompat
{
   private ListPreference mListPreference;

   @Override
   public void onCreatePreferences( Bundle savedInstanceState, String rootKey )
   {
      setPreferencesFromResource( R.xml.root_preferences, rootKey );
   }

   @SuppressLint( "ResourceType" )
   @Override
   public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

      mListPreference = (ListPreference)  getPreferenceManager().findPreference( "preference_key" );
      mListPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
         @Override
         public boolean onPreferenceChange(Preference preference, Object newValue) {
            // your code here
            return false;
         }
      } );

      return inflater.inflate(R.xml.root_preferences, container, false);
   }
}
