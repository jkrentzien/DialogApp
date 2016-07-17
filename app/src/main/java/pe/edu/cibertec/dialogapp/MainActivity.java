package pe.edu.cibertec.dialogapp;

import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CustomDateDialog.ListenerOyente, CustomTimeDialog.TimeListener{

    boolean[] selected = {true,false,true};
    TextView text;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.dateText);
        time = (TextView)findViewById(R.id.timeText);
    }

    public void abrirDialogo(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("TITULO");
        builder.setMessage("Voy a Aprobar el Curso");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"SI",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"NO",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("MAYBE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"SO_SO",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();

    }

    public void abrirDialogo2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("TITULO2");
        //builder.setMessage("OTRO dialogo");
        String[] opciones = getResources().getStringArray(R.array.opciones);
        builder.setSingleChoiceItems(opciones, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Single: "+which,Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    public void abrirDialogo3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("TITULO3");
        String[] opciones = getResources().getStringArray(R.array.opciones);

        builder.setMultiChoiceItems(opciones, selected, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                selected[which] = isChecked;
                Toast.makeText(getApplicationContext(),"Multi: "+which+" val: "+isChecked,Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"SI",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"NO",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    public void abrirCustom(View view) {

        DialogFragment dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager(),"custom");

    }

    public void openDatePicker(View view) {

        DialogFragment fragment = new CustomDateDialog();
        fragment.show(getSupportFragmentManager(),"calendar");

    }

    @Override
    public void setearFechar(String fecha) {
        text.setText(fecha);
    }

    public void openTimePicker(View view) {
        DialogFragment fragment = new CustomTimeDialog();
        fragment.show(getSupportFragmentManager(),"time");
    }

    @Override
    public void setTime(int hour, int minute) {
        time.setText(""+hour+":"+minute);
    }
}
