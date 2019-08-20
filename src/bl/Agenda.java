package bl;

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
                JOptionPane.showMessageDialog(null,"Se ha añadido");
            } else {
                JOptionPane.showMessageDialog(null,"No se ha podido añadir");
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
   
}
