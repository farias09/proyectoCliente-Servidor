
package proyectofinal;

import java.util.ArrayList;

import Interfaces.*;

public class Proveedores implements CrudInterface{
    //definicion de atributos
    private String nombreProveedor;

    //creamos un arraylist para los proveedores
    public static ArrayList<Proveedores> lstProveedores = new ArrayList<>();

    public Proveedores(){        
    }

    //creacion del constructor
    public Proveedores(String nombreProveedor){
        this.nombreProveedor = nombreProveedor;
    }

    //creacion de los encapsuladores
    

    @Override
    public void registrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
