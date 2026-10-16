package com.cortez.ivan.ivancortez.controllerApp;

import com.cortez.ivan.ivancortez.UsuarioModel.UsuarioModel;
import com.cortez.ivan.ivancortez.dto.UsuarioDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class UsuarioController {

    @FXML private TableView<UsuarioDto> tableUsuarios;
    @FXML private TableColumn<UsuarioDto, Integer> colId;
    @FXML private TableColumn<UsuarioDto, String> colNombre;
    @FXML private TableColumn<UsuarioDto, String> colCorreo;
    @FXML private TableColumn<UsuarioDto, Integer> colNumero;
    @FXML private TableColumn<UsuarioDto, Integer> colEdad;
    @FXML private TableColumn<UsuarioDto, String> colEstado;

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtNumero;
    @FXML private TextField txtEdad;
    @FXML private TextField txtEstado;

    @FXML private Button btnAgregar;
    @FXML private Button btnModificar;
    @FXML private Button btnEliminar;

    private final UsuarioModel usuarioModel = new UsuarioModel();
    private int siguienteId = 1;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoCivil"));

        tableUsuarios.setItems(usuarioModel.getUsuarios());

        tableUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            boolean haySeleccion = seleccionado != null;
            btnModificar.setDisable(!haySeleccion);
            btnEliminar.setDisable(!haySeleccion);
            btnAgregar.setDisable(haySeleccion);

            if (haySeleccion) {
                mostrarUsuario(seleccionado);
            } else {
                limpiarCampos();
            }
        });
    }

    @FXML
    public void handleAgregar(ActionEvent event) {
        UsuarioDto usuario = new UsuarioDto();
        if (!leerFormulario(usuario)) {
            return;
        }
        usuario.setId(siguienteId++);
        usuarioModel.agregarUsuario(usuario);
        limpiarCampos();
    }

    @FXML
    public void handleModificar(ActionEvent event) {
        UsuarioDto seleccionado = tableUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            return;
        }
        if (!leerFormulario(seleccionado)) {
            return;
        }
        tableUsuarios.refresh();
    }

    @FXML
    public void handleEliminar(ActionEvent event) {
        UsuarioDto seleccionado = tableUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            return;
        }
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION,
                "¿Eliminar a " + seleccionado.getNombre() + "?",
                ButtonType.YES, ButtonType.NO);
        confirmacion.setHeaderText(null);
        confirmacion.showAndWait()
                .filter(boton -> boton == ButtonType.YES)
                .ifPresent(boton -> usuarioModel.eliminarUsuario(seleccionado));
    }

    @FXML
    public void handleLimpiar(ActionEvent event) {
        tableUsuarios.getSelectionModel().clearSelection(); // el listener limpia los campos
        limpiarCampos();
    }


    private void mostrarUsuario(UsuarioDto usuario) {
        txtId.setText(String.valueOf(usuario.getId()));
        txtNombre.setText(usuario.getNombre());
        txtCorreo.setText(usuario.getCorreo());
        txtNumero.setText(String.valueOf(usuario.getNumero()));
        txtEdad.setText(String.valueOf(usuario.getEdad()));
        txtEstado.setText(usuario.getEstadoCivil());
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtCorreo.clear();
        txtNumero.clear();
        txtEdad.clear();
        txtEstado.clear();
    }

    private boolean leerFormulario(UsuarioDto destino) {
        String nombre = txtNombre.getText().trim();
        String correo = txtCorreo.getText().trim();
        String estado = txtEstado.getText().trim();

        if (nombre.isEmpty() || correo.isEmpty()) {
            mostrarAlerta("El nombre y el correo son obligatorios");
            return false;
        }

        int numero;
        int edad;
        try {
            numero = Integer.parseInt(txtNumero.getText().trim());
            edad = Integer.parseInt(txtEdad.getText().trim());
        } catch (NumberFormatException e) {
            mostrarAlerta("El número y la edad deben ser números enteros");
            return false;
        }

        destino.setNombre(nombre);
        destino.setCorreo(correo);
        destino.setNumero(numero);
        destino.setEdad(edad);
        destino.setEstadoCivil(estado);
        return true;
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING, mensaje, ButtonType.OK);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }
}