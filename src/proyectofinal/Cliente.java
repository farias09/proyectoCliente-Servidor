
package proyectofinal;

import Interfaces.CrudInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cliente extends Persona implements CrudInterface{
    //definicion de atributos
    private String correoElectronico;
    
    public static ArrayList<Cliente> lstClientes = new ArrayList();
    
    //creacion de constructor vacio
    public Cliente() {
    }
    
    //creacion de constructor
    public Cliente(String correoElectronico, int ID, String nombre, int edad) {
        super(ID, nombre, edad);
        this.correoElectronico = correoElectronico;
    }
    
    //creacion de encapsuladores
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }  
    
    public int getId(){
        return super.getID();
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
            
            //ingresar informacion del empleado
            super.setNombre(JOptionPane.showInputDialog
            ("Digite el nombre completo del cliente"));
            
            while(!valorCorrecto){
                try {
                super.setEdad(Integer.parseInt(JOptionPane.showInputDialog
                ("Digite la edad del cliente")));
                valorCorrecto = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog
                (null, "Valor incorrecto");
                }
            }
            
            valorCorrecto = false; //se reinicia el valor del boolean
            
            while(!valorCorrecto){
                try {
                    super.setID(Integer.parseInt(JOptionPane.showInputDialog
                    ("Digite la cedula del cliente")));
                    valorCorrecto = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }
            }
            valorCorrecto = false; //se reinicia el valor del boolean
            
            correoElectronico = JOptionPane.showInputDialog("Digite el correo electronico del cliente");
            
            lstClientes.add(new Cliente(correoElectronico, super.getID(), super.getNombre(), super.getEdad()));
        }
    }

    @Override
    public void modificar() {
        boolean valorCorrecto = false;
        int cedula;
        int opc;
        
        //se solicita la cedula para buscar el empleado
        cedula = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Digite el ID de la persona que quieres modificar en el programa"));
        
        //se recorre el arraylist buscando la cedula de la persona a modificar
        for(int i=0; i<lstClientes.size(); i++){
            if(cedula == lstClientes.get(i).getID()){
                //creamos un mini menu para seleccionar la opcion deseada
                opc = Integer.parseInt(JOptionPane.showInputDialog
                (null, "Ingrese lo que desea hacer\n" 
                + "\n"
                + "1. Editar Cedula\n"
                + "\n"
                + "2. Editar Nombre\n"
                + "\n"
                + "3. Editar edad\n"
                + "\n"
                + "4. Editar Correo Electronico\n"
                + "\n"
                + "5. Salir del sistema\n")); 
                switch(opc){
        //en el caso 1 editamos la cedula            
        case 1:{
            //creamos una variable nueva para almacenar la cedula nueva
            int cedulaNueva = 0;
            
            while(!valorCorrecto){
                //creamos un try catch para evitar que se caiga el programa
                try {
                    cedulaNueva = Integer.parseInt
                    (JOptionPane.showInputDialog("Digite la cedula"));
                    valorCorrecto = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor Incorrecto");
                }
            }            
            //Le devolvemos el valor a false para que siga funcionando a futuro
            valorCorrecto = false;
            
            //guardamos la variable nueva en donde estaba la cedula anterior
            lstClientes.get(i).setID(cedulaNueva);
            consultar();
            break;
                    }
        //en el caso 2 editamos el nombre
        case 2:{
            lstClientes.get(i).setNombre
            (JOptionPane.showInputDialog("Escriba el nombre del empleado"));
            consultar();
            break;
                    }
        //en el caso 3 editamos la edad
        case 3:{
             //creamos una variable nueva para almacenar la cedula nueva
            int edadNueva = 0;
            
            while(!valorCorrecto){
                //creamos un try catch para evitar que se caiga el programa
                try {
                    edadNueva = Integer.parseInt
                    (JOptionPane.showInputDialog("Digite la edad"));
                    valorCorrecto = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor Incorrecto");
                }
            }
            //Le devolvemos el valor a false para que siga funcionando a futuro
            valorCorrecto = false;
            
            //guardamos la variable nueva en donde estaba la edad anterior
            lstClientes.get(i).setEdad(edadNueva);
            consultar();
            break;
                    }
        //en el caso 4 editamos el correo electronico
        case 4:{
            lstClientes.get(i).setCorreoElectronico
            (JOptionPane.showInputDialog("Ingrese el correo electronico del empleado"));
            consultar();
            break;
                    }
        case 5:{
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
        for(Cliente a: lstClientes){
            msj = msj +"\n" + a;
        }//fin del for
        
        JOptionPane.showMessageDialog(null, msj);
        }

    @Override
    public void eliminar() {
        int cedula;
        
        //se solicita la cedula a eliminar
        cedula = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Digite el ID del cliente a eliminar"));
        
        //se recorre el arraylist buscando la cedula a eliminar
        for(int i=0; i<lstClientes.size(); i++){
            if(cedula == lstClientes.get(i).getID()){
                lstClientes.remove(i);    
            }
        }
        }
    }//fin de la clase
