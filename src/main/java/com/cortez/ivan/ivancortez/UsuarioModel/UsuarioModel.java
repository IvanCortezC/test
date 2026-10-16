package com.cortez.ivan.ivancortez.UsuarioModel;

import com.cortez.ivan.ivancortez.dto.UsuarioDto;

import java.util.ArrayList;

public class UsuarioModel {
    private final ArrayList<UsuarioDto> usuarios = new ArrayList<>();

    public ArrayList<UsuarioDto> getUsuarios() { return usuarios;}

    public void agregarUsuario(UsuarioDto usuario) { usuarios.add(usuario); }

    public void eliminarUsuario(UsuarioDto usuario) { usuarios.remove(usuario); }
}
