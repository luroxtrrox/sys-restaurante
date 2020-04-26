package org.sysRestaurante.applet;

import org.sysRestaurante.dao.CashierDao;
import org.sysRestaurante.dao.ComandaDao;
import org.sysRestaurante.dao.OrderDao;
import org.sysRestaurante.dao.ProductDao;
import org.sysRestaurante.dao.SessionDao;
import org.sysRestaurante.dao.UserDao;
import org.sysRestaurante.gui.AppController;
import org.sysRestaurante.gui.CashierController;
import org.sysRestaurante.gui.CashierPOSController;
import org.sysRestaurante.gui.ComandaPOSController;
import org.sysRestaurante.gui.DashboardController;
import org.sysRestaurante.gui.LoginController;
import org.sysRestaurante.gui.MainGUIController;
import org.sysRestaurante.gui.ManageComandaController;
import org.sysRestaurante.gui.POS;

import java.util.ArrayList;

public class AppFactory {
    private static UserDao userDao;
    private static AppController appController;
    private static DashboardController dashboardController;
    private static LoginController loginController;
    private static CashierDao cashierDao;
    private static OrderDao orderDao;
    private static SessionDao sessionDao;
    private static ComandaDao comandaDao;
    private static MainGUIController mainController;
    private static CashierController cashierController;
    private static CashierPOSController cashierPOSController;
    private static ArrayList<ProductDao> selectedProducts;
    private static ManageComandaController manageComandaController;
    private static ComandaPOSController comandaPOSController;
    private static POS pos;

    public static SessionDao getSessionDao() {
        return sessionDao;
    }

    public static void setSessionDao(SessionDao sessionDao) {
        AppFactory.sessionDao = sessionDao;
    }

    public static ComandaDao getComandaDao() {
        return comandaDao;
    }

    public static void setComandaDao(ComandaDao comandaDao) {
        AppFactory.comandaDao = comandaDao;
    }

    public static POS getPos() {
        return pos;
    }

    public static void setPos(POS pos) {
        AppFactory.pos = pos;
    }

    public static ManageComandaController getManageComandaController() {
        return manageComandaController;
    }

    public static void setManageComandaController(ManageComandaController manageComandaController) {
        AppFactory.manageComandaController = manageComandaController;
    }

    public static OrderDao getOrderDao() {
        return orderDao;
    }

    public static void setOrderDao(OrderDao orderDao) {
        AppFactory.orderDao = orderDao;
    }

    public static ArrayList<ProductDao> getSelectedProducts() {
        return selectedProducts;
    }

    public static void setSelectedProducts(ArrayList<ProductDao> selectedProducts) {
        AppFactory.selectedProducts = selectedProducts;
    }

    public static CashierPOSController getCashierPOSController() {
        return cashierPOSController;
    }

    public static void setCashierPOSController(CashierPOSController cashierPOSController) {
        AppFactory.cashierPOSController = cashierPOSController;
    }

    public static CashierController getCashierController() {
        return cashierController;
    }

    public static void setCashierController(CashierController cashierController) {
        AppFactory.cashierController = cashierController;
    }

    public static MainGUIController getMainController() {
        return mainController;
    }

    public static void setMainController(MainGUIController mainController) {
        AppFactory.mainController = mainController;
    }

    public static void setLoginController(LoginController loginController) {
        AppFactory.loginController = loginController;
    }

    public static DashboardController getDashboardController() {
        return dashboardController;
    }

    public static void setDashboardController(DashboardController dashboardController) {
        AppFactory.dashboardController = dashboardController;
    }

    public static CashierDao getCashierDao() {
        return cashierDao;
    }

    public static void setCashierDao(CashierDao cashierDao) {
        AppFactory.cashierDao = cashierDao;
    }

    public static LoginController getLoginController() {
        return loginController;
    }

    public static UserDao getUserDao() {
        return userDao;
    }

    public static void setUserDao(UserDao userDao) {
        AppFactory.userDao = userDao;
    }

    public static AppController getAppController() {
        return appController;
    }

    public static void setAppController(AppController appController) {
        AppFactory.appController = appController;
    }

    public static void setComandaPOSController(ComandaPOSController comandaPOSController) {
        AppFactory.comandaPOSController = comandaPOSController;
    }

    public static ComandaPOSController getComandaPOSController() {
        return comandaPOSController;
    }
}
