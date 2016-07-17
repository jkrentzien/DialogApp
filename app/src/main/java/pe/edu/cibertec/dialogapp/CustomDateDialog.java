package pe.edu.cibertec.dialogapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.location.GpsStatus;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Android-SAB-PM on 16/07/2016.
 */
public class CustomDateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    interface ListenerOyente {
        public void setearFechar(String fecha);
    }

    ListenerOyente listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calender = Calendar.getInstance();
        int ano = calender.get(Calendar.YEAR);
        int mes = calender.get(Calendar.MONTH);
        int day = calender.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this,ano,mes,day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Log.d("PICKER","date: "+year+" "+monthOfYear+" "+dayOfMonth);


        listener.setearFechar(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener=(ListenerOyente) activity;
    }
}
