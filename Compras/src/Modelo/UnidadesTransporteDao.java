/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony
 */
public class UnidadesTransporteDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarUnidadesTransporte(UnidadesTransporte tr) {
        String sql = "INSERT INTO UnidadesTransporte (placas,marca,modelo,anio,capacidad,tipo) VALUES(?,?,?,?,?,?)";
        try {
            con = (Connection) cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tr.getPlacas());
            ps.setString(2, tr.getMarca());
            ps.setString(3, tr.getModelo());
            ps.setInt(4, tr.getAnio());
            ps.setInt(5, tr.getCapacidad());
            ps.setString(6, tr.getTipo());
            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "algo no esta bien");
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public List ListarTransporte() {
        List<UnidadesTransporte> ListaTr = new ArrayList();
        String sql = "SELECT * FROM UnidadesTransporte";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UnidadesTransporte tra = new UnidadesTransporte();
                tra.setId(rs.getInt("idUnidadTransporte"));
                tra.setPlacas(rs.getString("placas"));
                tra.setMarca(rs.getString("marca"));
                tra.setModelo(rs.getString("modelo"));
                tra.setAnio(rs.getInt("anio"));
                tra.setCapacidad(rs.getInt("capacidad"));
                tra.setTipo(rs.getString("tipo"));
                ListaTr.add(tra);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaTr;

    }

    public boolean EliminarUnidadesTransporte(int id) {
        String sql = "DELETE FROM UnidadesTransporte WHERE idUnidadTransporte=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean ModificarUnidadesTransporte(UnidadesTransporte tr) {
        String sql = "UPDATE UnidadesTransporte SET placas=?,marca=?,modelo=?,anio=?,capacidad=?,tipo=? WHERE idUnidadTransporte=?";
        try {
            ps.setString(1, tr.getPlacas());
            ps.setString(2, tr.getMarca());
            ps.setString(3, tr.getModelo());
            ps.setInt(4, tr.getAnio());
            ps.setInt(5, tr.getCapacidad());
            ps.setString(6, tr.getTipo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}

