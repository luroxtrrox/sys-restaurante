package org.sysRestaurante.model;

import org.sysRestaurante.dao.SessionDao;
import org.sysRestaurante.dao.TableDao;
import org.sysRestaurante.util.DBConnection;
import org.sysRestaurante.util.ExceptionHandler;
import org.sysRestaurante.util.LoggerHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Management {

    private static final Logger LOGGER = LoggerHandler.getGenericConsoleHandler(Management.class.getName());

    public static void newTable(int idTable) throws SQLException {
        String query = "INSERT INTO mesa (id_mesa, id_categoria_mesa) VALUES(?, ?)";
        PreparedStatement ps;

        Connection con = DBConnection.getConnection();
        ps = Objects.requireNonNull(con).prepareStatement(query);
        ps.setInt(1, idTable);
        ps.setInt(2, 1);
        ps.executeUpdate();

        ps.close();
        con.close();
        LOGGER.info("Table successfully added.");
    }

    public static void closeTable(int idTable) {
        String query = "UPDATE mesa SET id_categoria_mesa = ? WHERE id_mesa = ?";
        PreparedStatement ps;

        try {
            Connection con = DBConnection.getConnection();
            ps = Objects.requireNonNull(con).prepareStatement(query);
            ps.setInt(1, 1);
            ps.setInt(2, idTable);
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            ExceptionHandler.incrementGlobalExceptionsCount();
            ex.printStackTrace();
        }
    }

    public static List<TableDao> getTables() {
        String query = "SELECT * FROM mesa";
        List<TableDao> tables = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            Connection con = DBConnection.getConnection();
            ps = Objects.requireNonNull(con).prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                TableDao table = new TableDao();
                table.setIdTable(rs.getInt("id_mesa"));
                table.setStatus(rs.getInt("id_categoria_mesa"));
                tables.add(table);
            }

            ps.close();
            rs.close();
            con.close();
            return tables;
        } catch (SQLException ex) {
            ExceptionHandler.incrementGlobalExceptionsCount();
            ex.printStackTrace();
        }
        return null;
    }

    public static void changeTableStatus(int idTable, int type) {
        String query = "UPDATE mesa SET id_categoria_mesa = ? WHERE id_mesa = ?";
        PreparedStatement ps;

        try {
            Connection con = DBConnection.getConnection();
            ps = Objects.requireNonNull(con).prepareStatement(query);
            ps.setInt(1, type);
            ps.setInt(2, idTable);
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static List<TableDao> getBusyTables() {
        String query = "SELECT * FROM mesa WHERE id_categoria_mesa = ? OR id_categoria_mesa = ?";
        List<TableDao> tables = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            Connection con = DBConnection.getConnection();
            ps = Objects.requireNonNull(con).prepareStatement(query);
            ps.setInt(1, 2);
            ps.setInt(2, 3);
            rs = ps.executeQuery();

            while (rs.next()) {
                TableDao table = new TableDao();
                table.setIdTable(rs.getInt("id_mesa"));
                table.setStatus(rs.getInt("id_categoria_mesa"));
                table.setStatus(1);
                tables.add(table);
            }

            ps.close();
            rs.close();
            con.close();
            return tables;
        } catch (SQLException ex) {
            ExceptionHandler.incrementGlobalExceptionsCount();
            ex.printStackTrace();
        }
        return null;
    }

    public static void deleteTable(int idTable) {
        String query = "DELETE FROM mesa WHERE id_mesa = ?";
        PreparedStatement ps;

        try {
            Connection con = DBConnection.getConnection();
            ps = Objects.requireNonNull(con).prepareStatement(query);
            ps.setInt(1, idTable);
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            LOGGER.severe("Error trying to delete a table.");
            ExceptionHandler.incrementGlobalExceptionsCount();
            ex.printStackTrace();
        }
    }

    public static SessionDao getBusinessInfo() {
        String query = "SELECT business_name, cnpj, phone, address FROM metadata";
        PreparedStatement ps;
        ResultSet rs;

        try {
            SessionDao businessInfo = new SessionDao();
            Connection con = DBConnection.getConnection();
            ps = Objects.requireNonNull(con).prepareStatement(query);
            rs = ps.executeQuery();


            while (rs.next()) {
                businessInfo.setBusinessName(rs.getString("business_name"));
                businessInfo.setBusinessCNPJ(rs.getString("cnpj"));
                businessInfo.setBusinessAddress(rs.getString("address"));
                businessInfo.setBusinessPhone(rs.getString("phone"));
            }

            ps.close();
            rs.close();
            con.close();

            return businessInfo;
        } catch (SQLException ex) {
            LOGGER.severe("Error trying to get info about business.");
            ExceptionHandler.incrementGlobalExceptionsCount();
            ex.printStackTrace();
        }

        return null;
    }

    public static void setMetadata(int id) {
        String query = "INSERT INTO metadata (id) VALUES(?)";
        PreparedStatement ps;

        try {
            Connection con = DBConnection.getConnection();
            ps = Objects.requireNonNull(con).prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            LOGGER.severe("Could not set metadata");
        }
    }
}