package io.github.cs102g1j.ui.schedule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScheduleViewModel extends ViewModel
{

    private MutableLiveData<String> mText;

    public ScheduleViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("This is schedule fragment. There will be weekly schedule of the user");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}