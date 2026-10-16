package com.cortez.ivan.ivancortez.controllerApp;

import com.cortez.ivan.ivancortez.UsuarioModel.UsuarioModel;
import com.cortez.ivan.ivancortez.dto.UsuarioDto;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class UsuarioController {

    UsuarioDto usuarioEliminar;
    @FXML
    private TableView tableUsuarios;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colCorreo;

    @FXML
    private TableColumn colNumero;

    @FXML
    private TableColumn colEdad;

    @FXML
    private TableColumn colEstado;

    @FXML
    public TextField txtId;

    @FXML
    public Button btnEliminar;

    private UsuarioModel usuariosModel;
    private ObservableList<UsuarioDto> usuarios;

    private Integer idUsuario = 0;

    @FXML
    public TextField txtNombre;

    @FXML
    public TextField txtCorreo;

    @FXML
    public TextField txtNumero;

    @FXML
    public TextField txtEdad;

    @FXML
    public TextField txtEstado;

    @FXML
    public void initialize() {
    this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    this.colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    this.colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    this.colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
    this.colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

    this.usuarios = FXCollections.observableArrayList();
    this.tableUsuarios.setItems(this.usuarios);
    }


    @FXML
    public void handleAgregar(MouseEvent mouseEvent) {

    }

    @FXML
    public void handleEliminar(MouseEvent mouseEvent) {

    }
    
}
