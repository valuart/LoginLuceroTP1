package com.example.logintp1.modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
        private Long dni;
        private String apellido;
        private String nombre;
        private String email;
        private String contrasenia;

        public Usuario(long dni, String apellido, String nombre, String email, String contrasenia) {
            this.dni = dni;
            this.apellido = apellido;
            this.nombre = nombre;
            this.email = email;
            this.contrasenia = contrasenia;
        }

        public Usuario() {
        }

        public long getDni() {
            return dni;
        }

        public void setDni(long dni) {
            this.dni = dni;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getContrasenia() {
            return contrasenia;
        }

        public void setContrasenia(String contrasenia) {
            this.contrasenia = contrasenia;
        }

    public String toString(){
        return "Usuario("+
                "dni="+ dni+
                ", apellido='"+apellido+'\''+
                ", nombre='"+nombre+'\''+
                ", email='"+email+'\''+
                ", password='"+contrasenia+'\''+
                ")";
    }
}
