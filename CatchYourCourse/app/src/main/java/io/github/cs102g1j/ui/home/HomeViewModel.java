package io.github.cs102g1j.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.github.cs102g1j.R;

public class HomeViewModel extends ViewModel
{

   private MutableLiveData< String > mText;

   public HomeViewModel()
   {
      mText = new MutableLiveData<>();
      mText.setValue( "HomeViewModel: WHY DO WE EVEN NEED IT?");
   }

   public LiveData< String > getText()
   {
      return mText;
   }
}