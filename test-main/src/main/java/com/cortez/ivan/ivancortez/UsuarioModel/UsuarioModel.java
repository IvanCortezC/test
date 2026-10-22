package com.cortez.ivan.ivancortez.UsuarioModel;

import com.cortez.ivan.ivancortez.dto.UsuarioDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsuarioModel {

    private final ObservableList<UsuarioDto> usuarios = FXCollections.observableArrayList();

    public ObservableList<UsuarioDto> getUsuarios() { return usuarios; }

    public void agregarUsuario(UsuarioDto usuario) { usuarios.add(usuario); }

    public void eliminarUsuario(UsuarioDto usuario) { usuarios.remove(usuario); }
}
