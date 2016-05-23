package com.tarea2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private String nombre, fecha, telefono, email, descripcion;
    private TextView tvnombre, tvfecha, tvtelefono, tvemail, tvdescripcion;
    private Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre = getIntent().getStringExtra("nombre");
        fecha = getIntent().getStringExtra("fecha");
        telefono = getIntent().getStringExtra("telefono");
        email = getIntent().getStringExtra("email");
        descripcion = getIntent().getStringExtra("descripcion");

        tvnombre = (TextView) findViewById(R.id.tvnombre);
        tvfecha = (TextView) findViewById(R.id.tvfecha);
        tvtelefono = (TextView) findViewById(R.id.tvtelefono);
        tvemail = (TextView) findViewById(R.id.tvemail);
        tvdescripcion = (TextView) findViewById(R.id.tvdescripcion);

        tvnombre.setText(nombre);
        tvfecha.setText(fecha);
        tvtelefono.setText(telefono);
        tvemail.setText(email);
        tvdescripcion.setText(descripcion);


        editar = (Button) findViewById(R.id.button2);

        editar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity = new Intent(Main2Activity.this, MainActivity.class);
                activity.putExtra("nombre", tvnombre.getText().toString());
                activity.putExtra("fecha", tvfecha.getText().toString());
                activity.putExtra("telefono", tvtelefono.getText().toString());
                activity.putExtra("email", tvemail.getText().toString());
                activity.putExtra("descripcion", tvdescripcion.getText().toString());
                startActivity(activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });

    }
}
