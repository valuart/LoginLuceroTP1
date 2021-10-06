package com.example.logintp1.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.logintp1.modelo.Usuario;
import com.example.logintp1.request.ApiClient;
import com.example.logintp1.ui.registro.RegistroActivity;

public class LoginViewModel extends AndroidViewModel {
    private Context context;
    private ApiClient apiClient;
    private MutableLiveData<String> error;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
        apiClient=new ApiClient();
    }

    public MutableLiveData<String> getError() {
        if(error == null){
            error = new MutableLiveData<>();
        }
        return error;
    }

    public void autenticar(String mail, String pass){
        Usuario usuario=apiClient.login(context,mail,pass);
        if (usuario != null){
            error.setValue("");
            Intent intent=new Intent(context, RegistroActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("usuario",usuario);
            context.startActivity(intent);
        }
        else {
            error.setValue("Email o Password incorrecto ");
        }
    }

    public void registrar(){
        Intent intent=new Intent(context, RegistroActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

}
