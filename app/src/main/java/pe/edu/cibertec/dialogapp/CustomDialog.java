package pe.edu.cibertec.dialogapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Android-SAB-PM on 16/07/2016.
 */
public class CustomDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.custom_dialog,null);
        builder.setView(view);
        builder.setPositiveButton("VOLVER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity().getApplicationContext(),"SUPER",Toast.LENGTH_LONG).show();
            }
        });


        return builder.create();
    }
}
