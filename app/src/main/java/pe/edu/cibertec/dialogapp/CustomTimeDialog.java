package pe.edu.cibertec.dialogapp;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Android-SAB-PM on 16/07/2016.
 */
    public class CustomTimeDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    interface TimeListener {
        public void setTime(int hour,int minute);
    }

    TimeListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (TimeListener) activity;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int min= cal.get(Calendar.MINUTE);
        //int sec = cal.get(Calendar.SECOND);
        return new TimePickerDialog(getActivity(),this,hour,min, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        listener.setTime(hourOfDay,minute);
    }
}
