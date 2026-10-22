package com.cortez.ivan.ivancortez.UsuarioDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsuarioDao {
    // como se llama el archivo
    public static final String NOMBRE_ARCHIVO = "usuarios.json";


    // carpeta

    private final Path archivo;

    public UsuarioDao() {
        String directorioUsuario = System.getProperty("user.dir");
        this.archivo = Paths.get(directorioUsuario, NOMBRE_ARCHIVO);
        System.out.println(this.archivo);
    }

    // guardar algo

    public String guardarNombre(String nombre) throws IOException {
        String resultado ="";
        if (!Files.exists(this.archivo)) {
            return "";
        }
        try {
            Files.writeString(this.archivo, nombre);
        } catch (IOException e) {
            System.out.println("No se pudo guardar el nombre: " + nombre);
        }

        try {
            resultado = Files.readString(this.archivo);
        } catch (IOException e) {
            System.out.println("No se pudo leer el nombre: " + nombre);
        }
        return resultado;
    }

    public String leerNombre() {
        String resultado ="";
        if(!Files.exists(this.archivo)) {
            return "";

        }
        try {
            resultado = Files.readString(this.archivo);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }
        return resultado;
    }
}
