package bl;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import Prac1.Contacto;

public class Agenda {

    private Contacto[] contactos;

    public Agenda() {
        this.contactos = new Contacto[10];
    }

    public Agenda(int tamanio) {
        this.contactos = new Contacto[tamanio];
        
    }


    public void aniadirContacto(Contacto c) {

        if (existeContacto(c)) { 
            JOptionPane.showMessageDialog(null,"El contacto con ese nombre ya existe");
        } else if (agendaLlena()) { 
            JOptionPane.showMessageDialog(null,"La agenda esta llena, no se pueden meter mas contactos");
        } else {

            boolean encontrado = false;
            for (int i = 0; i < contactos.length && !encontrado; i++) {
                if (contactos[i] == null) {
                    contactos[i] = c;
                    encontrado = true;
                }
            }

            if (encontrado) {
                JOptionPane.showMessageDialog(null,"Se ha a�adido");
            } else {
                JOptionPane.showMessageDialog(null,"No se ha podido a�adir");
            }
        }

    }

    public boolean existeContacto(Contacto c) {

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && c.equals(contactos[i])) {
                return true;
            }
        }
        return false;

    }

    public Contacto[] getContactos() {
        return contactos;
    }
   
    public boolean agendaLlena() {

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                return false;
            }
        }

        return true;

    }

    public void eliminarContacto(Contacto c) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null;
                encontrado = true; 
        }
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null,"Se ha eliminado el contacto");
        } else {
            JOptionPane.showMessageDialog(null,"No se ha eliminado el contacto");

        }

    }
    public void modificarContacto(Contacto c, int fila_seleccionada) {
    	boolean encontrado = false;
    	int a = fila_seleccionada;
    	for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i]==contactos[a]) {
                contactos[i] = c;
                encontrado = true; 
            	}
    	}
    	if (encontrado) {
            JOptionPane.showMessageDialog(null,"Se ha modificado el contacto");
        } else {
            JOptionPane.showMessageDialog(null,"No se ha podido modificar el contacto");
        }
    }
    
    public void exportarContactos(){
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contactos.age"))){;
        
       
            for (int i = 0; i < contactos.length; i++) {
              
                if (contactos[i] != null) {
                  
                    oos.writeObject(contactos[i]);    
                } 
            }
            
           
            JOptionPane.showMessageDialog(null,"Se ha escrito con exito");
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
 public void importarContactos(String fichero) throws IOException, ClassNotFoundException{
        
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))){
            
            Contacto aux;
          
            while(true){
             
                aux = (Contacto)ois.readObject();
                
                
                aniadirContacto(aux);
            }
            
        }catch(EOFException ex){}
        
        
    }
   
}
