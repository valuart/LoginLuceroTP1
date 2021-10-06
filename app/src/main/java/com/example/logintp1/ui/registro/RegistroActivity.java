package com.example.logintp1.ui.registro;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.logintp1.R;
import com.example.logintp1.modelo.Usuario;

public class RegistroActivity extends AppCompatActivity {
    private RegistroViewModel rvm;
    private EditText dni, apellido, nombre, correo, pass;
    private TextView msj;
    private Button guardar;
    private Usuario usuarioActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Usuario usuarioActual = (Usuario) getIntent().getSerializableExtra("usuario");
        rvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroViewModel.class);
        inicializar();
        rvm.getMensaje().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                msj.setText(s);
                msj.setVisibility(View.VISIBLE);

            }
        });
        rvm.getUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                    dni.setText(usuario.getDni()+"");
                    apellido.setText(usuario.getApellido());
                    nombre.setText(usuario.getNombre());
                    correo.setText(usuario.getEmail());
                    pass.setText(usuario.getContrasenia());
                }
            });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvm.registrar(Long.valueOf(dni.getText().toString()), apellido.getText().toString(), nombre.getText().toString(), correo.getText().toString(), pass.getText().toString(),usuarioActual);
            }
        });
             rvm.mostrar(usuarioActual);

        }
    public void inicializar(){
        dni = findViewById(R.id.etDni);
        apellido = findViewById(R.id.etApellido);
        nombre = findViewById(R.id.etNombre);
        correo = findViewById(R.id.etCorreo);
        pass = findViewById(R.id.etPass);
        guardar = findViewById(R.id.btGuardar);
        msj = findViewById(R.id.tvMsj);


    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        System.exit(0);
    }


}
