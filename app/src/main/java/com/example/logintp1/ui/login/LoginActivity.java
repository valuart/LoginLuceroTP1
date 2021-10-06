package com.example.logintp1.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.logintp1.R;
import com.example.logintp1.ui.registro.RegistroActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText email, contraseña;
    private TextView mensaje;
    private Button ingresar, registrar;
    private LoginViewModel lvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);
        inicializar();
        lvm.getError().observe(this, new Observer<String>(){
            @Override
            public void onChanged(String s) {
                    mensaje.setText(s);
                    mensaje.setVisibility(View.VISIBLE);
                    email.setText("");
                    contraseña.setText("");
            }

        });

    }
    public void inicializar(){
        email = findViewById(R.id.etEmail);
        contraseña = findViewById(R.id.etContraseña);
        mensaje = findViewById(R.id.tvMensaje);
        ingresar = findViewById(R.id.btIngresar);
        registrar = findViewById(R.id.btRegistrarse);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("mensaje", "onClick: El email " + email);
                lvm.autenticar(email.getText().toString(),contraseña.getText().toString());
                email.setText("");
                contraseña.setText("");
            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lvm.registrar();
            }
        });

    }
}
