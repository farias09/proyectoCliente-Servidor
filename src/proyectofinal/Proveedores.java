
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
        boolean valorCorrecto = true;
        int cedula;
        int opc;
        
        //se solicita el ID para buscar el proveedor
        cedula = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Digite el ID deL proveedor que quieres modificar en el programa"));
        
        for(int i=0; i<lstProveedores.size(); i++){
            if(cedula == lstProveedores.get(i).getIDProveedor()){
                //creamos un mini menu para seleccionar la opcion deseada
                opc = Integer.parseInt(JOptionPane.showInputDialog
                (null, "Ingrese lo que desea hacer\n" 
                + "\n"
                + "1. Editar Cedula\n"
                + "\n"
                + "2. Editar Nombre\n"
                + "\n"
                + "3. Salir del sistema\n")); 
                switch(opc){
        //en el caso 1 editamos la cedula            
        case 1:{
           //creamos una variable nueva para almacenar la cedula nueva
            int cedulaNueva = 0;
            
            while(!valorCorrecto){
                //creamos un try catch para evitar que se caiga el programa
                try {
                    cedulaNueva = Integer.parseInt
                    (JOptionPane.showInputDialog("Digite el ID"));
                    valorCorrecto = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor Incorrecto");
                }
            }            
            //Le devolvemos el valor a false para que siga funcionando a futuro
            valorCorrecto = false;
            
            //guardamos la variable nueva en donde estaba la cedula anterior
            lstProveedores.get(i).setIDProveedor(cedulaNueva);
            consultar();
            break;
            }
        //en el caso 2 editamos el nombre
        case 2:{
            lstProveedores.get(i).setNombreProveedor
            (JOptionPane.showInputDialog("Escriba el nombre del empleado"));
            consultar();
            break;
            }
        case 3:{
            System.exit(0);
                    }
        default:{
            JOptionPane.showMessageDialog(null,
                    "Opcion no valida");
            }
                }
            }
        }
    }

    @Override
    public void consultar() {
        String msj = "";
        for(Proveedores a: lstProveedores){
            msj = msj +"\n" + a;
        }//fin del for
        
        JOptionPane.showMessageDialog(null, msj);
    }

    @Override
    public void eliminar() {
        int cedula;
        
        //se solicita la cedula a eliminar
        cedula = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Digite el ID de la persona a eliminar"));
        
        //se recorre el arraylist buscando la cedula a eliminar
        for(int i=0; i<lstProveedores.size(); i++){
            if(cedula == lstProveedores.get(i).getIDProveedor()){
                lstProveedores.remove(i);    
            }
        }   
    }
} //fin de la clase
