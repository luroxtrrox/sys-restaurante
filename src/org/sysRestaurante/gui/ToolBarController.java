package org.sysRestaurante.gui;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.sysRestaurante.applet.AppFactory;
import org.sysRestaurante.util.Animation;
import org.sysRestaurante.util.ExceptionHandler;
import org.sysRestaurante.util.LoggerHandler;

import java.io.IOException;
import java.util.logging.Logger;

public class ToolBarController extends AppFactory {

    @FXML
    private VBox vBoxMenuPrincipal;
    @FXML
    private ToggleButton toggleMenuPrincipal;
    @FXML
    private ToggleButton toggleGerenciarBalcao;
    @FXML
    private ToggleButton toggleComandas;
    @FXML
    private ToggleButton togglePedidos;
    @FXML
    private ToggleButton toggleHistoricoCaixa;
    @FXML
    private ToggleButton togglePainelCardapio;
    @FXML
    private ToggleGroup menuGroup;
    @FXML
    private ToggleGroup submenuGroup;
    @FXML
    private ToggleButton g2a;
    @FXML
    private ToggleButton g2b;
    @FXML
    private ToggleButton g2c;
    @FXML
    private ToggleButton g2d;
    @FXML
    private ToggleButton g3a;
    @FXML
    private ToggleButton g3b;
    @FXML
    private ToggleButton g3c;
    @FXML
    private ToggleButton g3d;
    @FXML
    private ToggleButton g4a;
    @FXML
    private ToggleButton g4b;
    @FXML
    private ToggleButton g4c;
    @FXML
    private ToggleButton g5a;
    @FXML
    private ToggleButton g5b;
    @FXML
    private ToggleButton g5c;
    @FXML
    private VBox vboxG2;
    @FXML
    private VBox vboxG3;
    @FXML
    private VBox vboxG4;
    @FXML
    private VBox vboxG5;
    @FXML
    private Label userLabel;
    @FXML
    private Label dashboardLinkLabel;

    private static final Logger LOGGER = LoggerHandler.getGenericConsoleHandler(ToolBarController.class.getName());

    public void initialize() {
        this.clearToggleGroup(menuGroup, submenuGroup);
        userLabel.setText("Olá, Saulo");
        dashboardLinkLabel.setText("SysRestaurante | Adminstração");
    }

    public void unfoldSubmenus(VBox box, ToggleButton... toggleSubmenus) {
        if (box.getChildren().isEmpty()) {
            box.getChildren().addAll(toggleSubmenus);
            Animation.fade(box);
        } else {
            hideSubmenus(box);
        }
    }

    public void hideSubmenus(VBox... boxes) {
        for (VBox box : boxes) {
            box.getChildren().clear();
        }
    }

    public void menuPrincipal(ActionEvent event) {
        unfoldSubmenus(
                vBoxMenuPrincipal,
                toggleGerenciarBalcao,
                toggleComandas,
                toggleHistoricoCaixa,
                togglePainelCardapio,
                togglePedidos
        );
    }

    public void selectMenuPrincipal() {
        toggleMenuPrincipal.setSelected(true);
    }

    public void dashboard(MouseEvent event) {
        untoggleGroup(submenuGroup);
        AppFactory.getAppController().loadPage(event, SceneNavigator.DASHBOARD);
    }

    public void submenuGerenciarBalcao(MouseEvent event) {
        if (!toggleGerenciarBalcao.isSelected()) toggleGerenciarBalcao.setSelected(true);
        selectMenuPrincipal();
        AppFactory.getAppController().loadPage(event, SceneNavigator.CASHIER);
    }

    public void submenuComandas() {
        selectMenuPrincipal();
    }

    public void submenuPedidos() {
        selectMenuPrincipal();
    }

    public void submenuHistoricoCaixa() {
        selectMenuPrincipal();
    }

    public void submenuPainelCardapio() {
        selectMenuPrincipal();
    }

    public void menuG2(ActionEvent event) {
        unfoldSubmenus(vboxG2, g2a, g2b, g2c, g2d);
    }

    public void menuG3(ActionEvent event) {
        unfoldSubmenus(vboxG3, g3a, g3b, g3c, g3d);
    }

    public void menuG4(ActionEvent event) {
        unfoldSubmenus(vboxG4, g4a, g4b, g4c);
    }

    public void menuG5(ActionEvent event) {
        unfoldSubmenus(vboxG5, g5a, g5b, g5c);
    }

    public void clearToggleGroup(ToggleGroup... grupoMenu) {
        for (ToggleGroup grupo : grupoMenu)
        {
            grupo.selectedToggleProperty().addListener(
                    (ObservableValue<? extends Toggle> obs, Toggle old, Toggle novo) -> {
                    if (grupo.getSelectedToggle() == null) {
                        grupo.selectToggle(old);
                    }});
        }
    }

    public void untoggleGroup(ToggleGroup group) {
        ToggleButton toggle = new ToggleButton();
        toggle.setToggleGroup(group);
        toggle.setSelected(true);
    }

    public void onLogoutRequest(MouseEvent event) {
        try {
            event.consume();
            AppFactory.setUser(null);
            LOGGER.info("User logged out");
            AppFactory.getLoginController().storeLastSessionDuration();
            MainGUI.restartProgram();
        } catch (IOException e) {
            ExceptionHandler.incrementGlobalExceptionsCount();
            LOGGER.severe("Couldn't log out due to IOException.");
            e.printStackTrace();
        }
    }
}