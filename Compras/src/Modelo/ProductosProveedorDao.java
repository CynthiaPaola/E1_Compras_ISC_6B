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
import javax.swing.JComboBox;

/**
 *
 * @author frank
 */
public class ProductosProveedorDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarProductosProveedor(ProductosProveedor prov) {
        String sql = "INSERT INTO ProductosProveedor(idProveedor,idPresentacion,diasRetardo,precioEstandar,precioUltimaCompra,cantMinPedir,cantMaxPedir) VALUES(?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, prov.getIdproveedor());
            ps.setInt(2, prov.getIdpresentacion());
            ps.setInt(3, prov.getDiasretardo());
            ps.setFloat(4, prov.getPrecioestandar());
            ps.setFloat(5, prov.getPrecioultimacompra());
            ps.setInt(6, prov.getCantminpedir());
            ps.setInt(7, prov.getCantmaxpedir());

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
    public void consultarProveedores(JComboBox ProductosProveedor)//ProductosProveedor cambiar el nombre de la tabla de la llave foranea
    {
        String sql="SELECT idPresentacion FROM ProductosProveedor";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.execute();
            rs=ps.executeQuery();
            while(rs.next())
            {
                ProductosProveedor.addItem(rs.getInt("idPresentacion"));// ProductosProveedor cambiarlo popr el de arriva  que cambiastes primero
            }
        }catch(SQLException e)
        {
            System.out.println(e.toString());
           
        }
    }

    public boolean eliminarProductosProveedor(ProductosProveedor po) {
        String sql = "DELETE FROM ProductosProveedor WHERE idProveedor=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, po.getIdproveedor());
            
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

    public boolean modificarProductosProveedor(ProductosProveedor pro) {
        String sql = "UPDATE ProductosProvedor SET idProveedor=?, diasRetardo=?, precioEstandar=?, precioUltimaCompra=?, cantMinPedor=?, cantMaxPedir=? WHERE idPresentacion=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getIdproveedor());
            ps.setInt(2, pro.getDiasretardo());
            ps.setFloat(3, pro.getPrecioestandar());
            ps.setFloat(4, pro.getPrecioultimacompra());
            ps.setInt(5, pro.getCantminpedir());
            ps.setInt(6, pro.getCantmaxpedir());
            ps.setInt(7, pro.getIdpresentacion());
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

    public ProductosProveedor buscarProductosProveedor(int idPresentacion) {
        ProductosProveedor obc = new ProductosProveedor();
        String sql = "SELECT * FROM ProductosProveedor WHERE idPresentacion=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(idPresentacion, idPresentacion);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductosProveedor po = new ProductosProveedor();
                obc.setIdproveedor(rs.getInt("idProveedor"));
                obc.setIdpresentacion(rs.getInt("idPresentacion"));
                obc.setDiasretardo(rs.getInt("diasRetardo"));
                obc.setPrecioestandar(rs.getFloat("precioEstandar"));
                obc.setPrecioultimacompra(rs.getFloat("precioUltimaCompra"));
                obc.setCantminpedir(rs.getInt("cantMinPedir"));
                obc.setCantmaxpedir(rs.getInt("cantMaxPedir"));

            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return obc;
    }

    public List ListarProductosProveedor() {
        List<ProductosProveedor> ListaPro = new ArrayList();
        String sql = "SELECT * FROM ProductosProveedor WHERE idPresentacion=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductosProveedor po = new ProductosProveedor();
                po.setIdproveedor(rs.getInt("idProveedor"));
                po.setIdpresentacion(rs.getInt("idPresentacion"));
                po.setDiasretardo(rs.getInt("diasRetardo"));
                po.setPrecioestandar(rs.getFloat("precioEstandar"));
                po.setPrecioultimacompra(rs.getFloat("precioUltimaCompra"));
                po.setCantminpedir(rs.getInt("cantMinPedir"));
                po.setCantmaxpedir(rs.getInt("cantMaxPedir"));
                ListaPro.add(po);
            }
        } catch(SQLException e)
            {
                System.out.println(e.toString());
            }
            return ListaPro;
        }

    }
