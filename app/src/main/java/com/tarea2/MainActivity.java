package com.tarea2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nombre, fecha, telefono, email, descripcion;
    private TextView mDateDisplay;
    private Button mPickDate, button;
    private int mYear, mMonth, mDay;
    static final int DATE_DIALOG_ID = 0;


    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDateDisplay = (TextView) findViewById(R.id.fecha);
        mPickDate = (Button) findViewById(R.id.bfecha);

        mPickDate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        updateDisplay();
    }



    private void updateDisplay() {
        String dia = String.valueOf(mDay);
        String mes = String.valueOf(mMonth + 1);

        if(contarDigitosFecha(mDay) == 1)
            dia = "0" + dia;
        if(contarDigitosFecha(mMonth + 1) == 1)
            mes = "0" + mes;

        mDateDisplay.setText(
                new StringBuilder()

                        .append(dia).append("-")
                        .append(mes).append("-")
                        .append(mYear).append(" "));



        nombre = (TextInputEditText) findViewById(R.id.nombre);
        fecha = (TextInputEditText) findViewById(R.id.fecha);
        telefono = (TextInputEditText) findViewById(R.id.telefono);
        email = (TextInputEditText) findViewById(R.id.email);
        descripcion = (TextInputEditText) findViewById(R.id.descripcion);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent activity2 = new Intent(MainActivity.this, Main2Activity.class);
                activity2.putExtra("nombre", nombre.getText().toString());
                activity2.putExtra("fecha", fecha.getText().toString());
                activity2.putExtra("telefono", telefono.getText().toString());
                activity2.putExtra("email", email.getText().toString());
                activity2.putExtra("descripcion", descripcion.getText().toString());
                startActivity(activity2);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
        }
        return null;
    }

    public int contarDigitosFecha(int n){

        int c=0;

        while(n>0){
            n=n/10;
            c+=1;
        }

        System.out.println("elro de digitos de es " + c);

        return c;
    }

    @Override
    protected void onResume() {
        super.onResume();

        String nom, fec, tel, mail, des;

        nom = getIntent().getStringExtra("nombre");
        fec = getIntent().getStringExtra("fecha");
        tel = getIntent().getStringExtra("telefono");
        mail = getIntent().getStringExtra("email");
        des = getIntent().getStringExtra("descripcion");

        nombre.setText(nom);
        fecha.setText(fec);
        telefono.setText(tel);
        email.setText(mail);
        descripcion.setText(des);
    }
}
