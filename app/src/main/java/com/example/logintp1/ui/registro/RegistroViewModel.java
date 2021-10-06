package com.example.logintp1.ui.registro;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.logintp1.modelo.Usuario;
import com.example.logintp1.request.ApiClient;

public class RegistroViewModel extends AndroidViewModel {
    private MutableLiveData<Usuario> usuario;
    private MutableLiveData<String> mensaje;
    private ApiClient apiClient;
    private Context context;

    public RegistroViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
        apiClient=new ApiClient();
    }

    public MutableLiveData<Usuario> getUsuario() {
        if(usuario == null){
           usuario = new MutableLiveData<>();
        }
        return usuario;
    }

    public MutableLiveData<String> getMensaje() {
        if(mensaje == null){
            mensaje = new MutableLiveData<>();
        }
        return mensaje;
    }
    public void registrar(Long dni, String apellido, String nombre, String email, String pass, Usuario usuarioActual){
        Usuario u=new Usuario(dni,apellido,nombre,email,pass);
        apiClient.guardar(context,u);
        mensaje.setValue(usuarioActual == null? "El usuario se ha generado con exito":"El usuario se genero con exito");
    }

    public void mostrar(Usuario u){
        if(u != null){
            u = apiClient.leer(context);
            usuario.setValue(u);
        }
    }
}
