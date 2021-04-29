/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;

import Modelo.ImagenesProductos;
import Modelo.ImagenesProductosDao;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tony
 */
public class Tabla_ProductoVO
{
    ImagenesProductosDao dao = null;
    public void visualizar_ProductoVO(JTable Tableimagenes)
    {
        Tableimagenes.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel()
        {
             @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
         dt.addColumn("idImagen");
        dt.addColumn("nombreImagen");
        
        dt.addColumn("principal");
        
        dt.addColumn("idProducto");
        dt.addColumn("imagen");
        
        
        dao=new ImagenesProductosDao();
        ImagenesProductos vo=new ImagenesProductos();
        ArrayList< ImagenesProductos> list = dao.ListarImagenesProductos();
        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[5];
                vo = list.get(i);
                fila[0] = vo.getIdImagen();
                fila[1] = vo.getNombre();
              
                fila[2] = vo.getPrincipal();
                fila[3] = vo.getIdProducto();
                 try{
                    byte[] bi = vo.getImagen();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[4] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[4] = new JLabel("No imagen");
                }
                 
                
                dt.addRow(fila);
            }
           Tableimagenes.setModel(dt);
            Tableimagenes.setRowHeight(60);
        }
    }
}
