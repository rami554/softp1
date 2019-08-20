package Prac1;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import bl.Agenda;

public class Pantalla extends javax.swing.JFrame {
	 
	private static final long serialVersionUID = 1L;
	public Pantalla() {

	        modelo = new DefaultTableModel();

	        initComponents();

	        this.tblContactos.setModel(modelo);

	        modelo.addColumn("Nombre");
	        modelo.addColumn("Telefono");

	       agenda = new Agenda();
	    }

	    private void initComponents() {

	        jScrollPane1 = new javax.swing.JScrollPane();
	        tblContactos = new javax.swing.JTable();
	        btnAnadir = new javax.swing.JButton();
	        btnModificar = new javax.swing.JButton();
	        btnEliminar = new javax.swing.JButton();
	        txtNombre = new javax.swing.JTextField();
	        txtTelefono = new javax.swing.JTextField();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        btnSalir = new javax.swing.JButton();
	        jMenuBar1 = new javax.swing.JMenuBar();
	        jMenu1 = new javax.swing.JMenu();
	        miImp = new javax.swing.JMenuItem();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        tblContactos.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null},
	                {null, null},
	                {null, null},
	                {null, null}
	            },
	            new String [] {
	                "Title 1", "Title 2"
	            }
	        ));
	        jScrollPane1.setViewportView(tblContactos);

	        btnAnadir.setText("Añadir");
	        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnAnadirActionPerformed(evt);
	            }
	        });
	        
	        btnModificar.setText("Modificar");
	        btnModificar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnModificarActionPerformed(evt);
	            }
	        });
	        btnEliminar.setText("Eliminar");
	        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnEliminarActionPerformed(evt);
	            }
	        });

	        jLabel1.setText("Nombre");

	        jLabel2.setText("Telefono");

	        btnSalir.setText("Salir");
	        
	        btnSalir.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnSalirActionPerformed(evt);
	            }
	        });

	        jMenu1.add(miImp);

	        jMenuBar1.add(jMenu1);

	        setJMenuBar(jMenuBar1);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(27, 27, 27)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(40, 40, 40)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel1)
	                    .addComponent(jLabel2))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(btnAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(txtNombre)
	                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(30, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(51, 51, 51)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel1))
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel2))
	                        .addGap(18, 18, 18)
	                        .addComponent(btnAnadir)
	                        .addGap(26, 26, 26)
	                        .addComponent(btnModificar)
	                        .addGap(31, 31, 31)
	                        .addComponent(btnEliminar)
	                        .addGap(37, 37, 37)
	                        .addComponent(btnSalir)))
	                .addContainerGap(23, Short.MAX_VALUE))
	        );

	        pack();
	    }

	    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
	        System.exit(0);
	    }

	    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {

	        String nombre = this.txtNombre.getText();
	        String telefono = this.txtTelefono.getText();

	        int tel;
	        try {
	         
	            tel = Integer.parseInt(telefono);

	            Contacto c = new Contacto(nombre, tel);

	            agenda.aniadirContacto(c);

	            rellenarTabla();

	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "El telefono debe ser numerico", "Errors", JOptionPane.ERROR_MESSAGE);
	        }
	        txtNombre.setText(null);
	        txtTelefono.setText(null);

	    }

	    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {


	        int fila_seleccionada = this.tblContactos.getSelectedRow();

	        if (fila_seleccionada == -1) {
	            JOptionPane.showMessageDialog(this, "No has seleccionado ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);
	        } else {

	            String nombre = (String) modelo.getValueAt(fila_seleccionada, 0);
	            int tel = (int) modelo.getValueAt(fila_seleccionada, 1);

	            Contacto c = new Contacto(nombre, tel);

	            agenda.eliminarContacto(c);

	            rellenarTabla();

	        }

	    }
	    
	    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
	    	
	    	int fila_seleccionada = this.tblContactos.getSelectedRow();
	        
	    	if (fila_seleccionada == -1) {
	            JOptionPane.showMessageDialog(this, "No has seleccionado ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);
	        } else {
	        	String nombre = (String) modelo.getValueAt(fila_seleccionada, 0);
	            int  tel = (int) modelo.getValueAt(fila_seleccionada, 1);
	            
	            nombre = JOptionPane.showInputDialog(null,"Introduce el nuevo Nombre");
	            tel = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el nuevo telefono"));
	            
	            Contacto c = new Contacto(nombre, tel);
	            agenda.modificarContacto(c, fila_seleccionada);

	            rellenarTabla();

	        }
	    }

	    private void rellenarTabla() {


	        modelo.setRowCount(0);

	        Contacto contactos[] = agenda.getContactos();

	        Object[] fila;
	        for (int i = 0; i < contactos.length; i++) {

	            if (contactos[i] != null) {
	   
	                fila = new Object[2];
	                fila[0] = contactos[i].getNombre();
	                fila[1] = contactos[i].getTelefono();
	             
	                modelo.addRow(fila);
	            }
	        }
	    }

	    public static void main(String args[]) {
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Pantalla().setVisible(true);
	            }
	        });
	    }


	    private DefaultTableModel modelo;
	    private Agenda agenda;
	    
	    private javax.swing.JButton btnAnadir;
	    private javax.swing.JButton btnModificar;
	    private javax.swing.JButton btnEliminar;
	    private javax.swing.JButton btnSalir;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenuBar jMenuBar1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JMenuItem miImp;
	    private javax.swing.JTable tblContactos;
	    private javax.swing.JTextField txtNombre;
	    private javax.swing.JTextField txtTelefono;
}
