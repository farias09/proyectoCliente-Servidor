
package proyectofinal;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.*;

public class Proveedores implements CrudInterface{
    //definicion de atributos
    private String nombreProveedor;
    private int IDProveedor;

    //creamos un arraylist para los proveedores
    public static ArrayList<Proveedores> lstProveedores = new ArrayList<>();

    public Proveedores(){        
    }

    //creacion del constructor
    public Proveedores(String nombreProveedor, int IDProveedor){
        this.nombreProveedor = nombreProveedor;
        this.IDProveedor = IDProveedor;
    }

    //creacion de los encapsuladores
        public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public static ArrayList<Proveedores> getLstProveedores() {
        return lstProveedores;
    }

    public int getIDProveedor() {
        return IDProveedor;
    }

    public void setIDProveedor(int IDProveedor) {
        this.IDProveedor = IDProveedor;
    }
    
     @Override
    public String toString() {
        return "Nombre del Proveedor: " + nombreProveedor + ", ID del Proveedor: " + IDProveedor;
    }

    @Override
    public void registrar() {
         //Se crea un boolean que nos ayudara al try catch
        boolean valorCorrecto = false;
        
        while(true){
            String salir = JOptionPane.showInputDialog
        ("Digite SALIR para terminar - otra cosa para seguir").toUpperCase();
            
            if("SALIR".equals(salir)){
                //quebrar el ciclo
                break;
            }//fin del if; 
        }
        
        nombreProveedor = JOptionPane.showInputDialog("Escriba el nombre del proveedor");
        
        while(!valorCorrecto){
                try {
                    IDProveedor = (Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del proveedor")));
                    valorCorrecto = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }
            }
        
        valorCorrecto = false;
        
        lstProveedores.add(new Proveedores(nombreProveedor, IDProveedor));
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
