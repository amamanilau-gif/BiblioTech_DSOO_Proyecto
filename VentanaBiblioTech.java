package PROYECTO_DSOO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaBiblioTech extends JFrame {

    private Biblioteca biblioteca;
    private JRadioButton rbLibro, rbRevista;
    private JTextField txtCodMat, txtTituloMat, txtAutorNum, txtIsbnMes, txtEjempAnio;
    private JButton btnAgregarMat;
    private JRadioButton rbAlumno, rbBibliotecario;
    private JTextField txtIdUsr, txtNombreUsr, txtCorreoUsr, txtCodUsr;
    private JComboBox<String> cbCarrera, cbTurno;
    private JCheckBox chkActivo;
    private JButton btnAgregarUsr, btnPagarMulta;
    private JTextField txtCodAluPrest, txtCodMatPrest, txtDiasRetraso;
    private JButton btnPrestar, btnDevolver;
    private JTextArea areaSalida;
    private JButton btnVerCatalogo, btnVerAlumnos, btnVerPrestamos;

    public VentanaBiblioTech() {
        biblioteca = new Biblioteca();
        setTitle("BiblioTech");
        setSize(900, 620);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        createContents();
        mostrarCatalogo();
        setVisible(true);
    }
    
    private void createContents() {
        Listener listener = new Listener();
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNorte.setBackground(new Color(27, 54, 93));
        JLabel titulo = new JLabel("SISTEMA DE BIBLIOTECA - BIBLIOTECH");
        titulo.setForeground(Color.WHITE);
        panelNorte.add(titulo);
        add(panelNorte, BorderLayout.NORTH);
        JPanel panelOeste = new JPanel(new GridLayout(3, 1, 5, 5));
        JPanel panelMat = new JPanel(new GridLayout(0, 2, 3, 3));
        rbLibro = new JRadioButton("Libro", true);
        rbRevista = new JRadioButton("Revista");
        ButtonGroup grupoMat = new ButtonGroup();
        grupoMat.add(rbLibro);
        grupoMat.add(rbRevista);
        JPanel pRadioMat = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pRadioMat.add(rbLibro);
        pRadioMat.add(rbRevista);
        txtCodMat = new JTextField(10);
        txtTituloMat = new JTextField(10);
        txtAutorNum = new JTextField(10);
        txtIsbnMes = new JTextField(10);
        txtEjempAnio = new JTextField(10);
        btnAgregarMat = new JButton("Registrar Material");
        btnAgregarMat.addActionListener(listener);
        panelMat.add(new JLabel("Tipo:"));
        panelMat.add(pRadioMat);
        panelMat.add(new JLabel("Código:"));
        panelMat.add(txtCodMat);
        panelMat.add(new JLabel("Título:"));
        panelMat.add(txtTituloMat);
        panelMat.add(new JLabel("Autor / Número:"));
        panelMat.add(txtAutorNum);
        panelMat.add(new JLabel("ISBN / Mes:"));
        panelMat.add(txtIsbnMes);
        panelMat.add(new JLabel("Ejemplares / Año:"));
        panelMat.add(txtEjempAnio);
        panelMat.add(new JLabel(""));
        panelMat.add(btnAgregarMat);
        JPanel panelUsr = new JPanel(new GridLayout(0, 2, 3, 3));
        rbAlumno = new JRadioButton("Alumno", true);
        rbBibliotecario = new JRadioButton("Bibliotecario");
        ButtonGroup grupoUsr = new ButtonGroup();
        grupoUsr.add(rbAlumno);
        grupoUsr.add(rbBibliotecario);
        JPanel pRadioUsr = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pRadioUsr.add(rbAlumno);
        pRadioUsr.add(rbBibliotecario);
        txtIdUsr = new JTextField(10);
        txtNombreUsr = new JTextField(10);
        txtCorreoUsr = new JTextField(10);
        txtCodUsr = new JTextField(10);
        String[] carreras = {"Sistemas", "Computación", "Electrónica", "Industrial"};
        cbCarrera = new JComboBox<>(carreras);
        String[] turnos = {"Mañana", "Tarde", "Noche"};
        cbTurno = new JComboBox<>(turnos);
        chkActivo = new JCheckBox("Activo", true);
        btnAgregarUsr = new JButton("Registrar");
        btnPagarMulta = new JButton("Pagar Multa");
        btnAgregarUsr.addActionListener(listener);
        btnPagarMulta.addActionListener(listener);
        JPanel pBotonesUsr = new JPanel(new GridLayout(1, 2, 2, 0));
        pBotonesUsr.add(btnAgregarUsr);
        pBotonesUsr.add(btnPagarMulta);
        panelUsr.add(new JLabel("Rol:"));
        panelUsr.add(pRadioUsr);
        panelUsr.add(new JLabel("ID:"));
        panelUsr.add(txtIdUsr);
        panelUsr.add(new JLabel("Nombre:"));
        panelUsr.add(txtNombreUsr);
        panelUsr.add(new JLabel("Correo:"));
        panelUsr.add(txtCorreoUsr);
        panelUsr.add(new JLabel("Código:"));
        panelUsr.add(txtCodUsr);
        panelUsr.add(new JLabel("Carrera:"));
        panelUsr.add(cbCarrera);
        panelUsr.add(new JLabel("Turno:"));
        panelUsr.add(cbTurno);
        panelUsr.add(chkActivo);
        panelUsr.add(pBotonesUsr);
        JPanel panelPrest = new JPanel(new GridLayout(0, 2, 3, 3));
        txtCodAluPrest = new JTextField(10);
        txtCodMatPrest = new JTextField(10);
        txtDiasRetraso = new JTextField("0", 10);
        btnPrestar = new JButton("Prestar");
        btnDevolver = new JButton("Devolver");
        btnPrestar.addActionListener(listener);
        btnDevolver.addActionListener(listener);
        panelPrest.add(new JLabel("Código Alumno:"));
        panelPrest.add(txtCodAluPrest);
        panelPrest.add(new JLabel("Código Material:"));
        panelPrest.add(txtCodMatPrest);
        panelPrest.add(new JLabel("Días retraso:"));
        panelPrest.add(txtDiasRetraso);
        panelPrest.add(btnPrestar);
        panelPrest.add(btnDevolver);
        panelOeste.add(panelMat);
        panelOeste.add(panelUsr);
        panelOeste.add(panelPrest);
        add(panelOeste, BorderLayout.WEST);
        JPanel panelCentro = new JPanel(new BorderLayout(5, 5));
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnVerCatalogo = new JButton("Catálogo");
        btnVerAlumnos = new JButton("Alumnos");
        btnVerPrestamos = new JButton("Préstamos");
        btnVerCatalogo.addActionListener(listener);
        btnVerAlumnos.addActionListener(listener);
        btnVerPrestamos.addActionListener(listener);
        panelBotones.add(btnVerCatalogo);
        panelBotones.add(btnVerAlumnos);
        panelBotones.add(btnVerPrestamos);
        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        areaSalida.setLineWrap(true);
        areaSalida.setWrapStyleWord(true);
        panelCentro.add(panelBotones, BorderLayout.NORTH);
        panelCentro.add(areaSalida, BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);
    }

    private void mostrarCatalogo() {
        String texto = "CATÁLOGO DE MATERIALES\n\n";
        for (Material m : biblioteca.getMateriales()) {
            texto += m.generarResumen() + "\n";
        }
        areaSalida.setText(texto);
    }

    private void mostrarAlumnos() {
        String texto = "ALUMNOS REGISTRADOS\n\n";
        for (Alumno a : biblioteca.getAlumnos()) {
            texto += a.generarResumen() + "\n";
        }
        areaSalida.setText(texto);
    }

    private void mostrarPrestamos() {
        String texto = "HISTORIAL DE PRÉSTAMOS\n\n";
        for (Prestamo p : biblioteca.getPrestamos()) {
            texto += p.generarResumen() + "\n";
        }
        areaSalida.setText(texto);
    }

    private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnAgregarMat) {
                String cod = txtCodMat.getText();
                String tit = txtTituloMat.getText();
                if (rbLibro.isSelected()) {
                    int ejemp = Integer.parseInt(txtEjempAnio.getText());
                    biblioteca.agregarMaterial(new Libro(cod, tit, txtAutorNum.getText(), txtIsbnMes.getText(), ejemp));
                } else {
                    int num = Integer.parseInt(txtAutorNum.getText());
                    int anio = Integer.parseInt(txtEjempAnio.getText());
                    biblioteca.agregarMaterial(new Revista(cod, tit, num, txtIsbnMes.getText(), anio));
                }
                mostrarCatalogo();
                JOptionPane.showMessageDialog(null, "Material registrado.");
            } else if (e.getSource() == btnAgregarUsr) {
                int id = Integer.parseInt(txtIdUsr.getText());
                String nom = txtNombreUsr.getText();
                String cor = txtCorreoUsr.getText();
                String cod = txtCodUsr.getText();
                if (rbAlumno.isSelected()) {
                    String carrera = (String) cbCarrera.getSelectedItem();
                    biblioteca.agregarAlumno(new Alumno(id, nom, cor, cod, carrera));
                    mostrarAlumnos();
                } else {
                    String turno = (String) cbTurno.getSelectedItem();
                    Bibliotecario b = new Bibliotecario(id, nom, cor, turno, cod);
                    b.setActivo(chkActivo.isSelected());
                    biblioteca.registrarBibliotecario(b);
                }
                JOptionPane.showMessageDialog(null, "Usuario registrado.");
            } else if (e.getSource() == btnPagarMulta) {
                Alumno a = biblioteca.buscarAlumno(txtCodUsr.getText());
                if (a != null) {
                    a.pagarMultas();
                    mostrarAlumnos();
                    JOptionPane.showMessageDialog(null, "Multas pagadas.");
                } else {
                    JOptionPane.showMessageDialog(null, "Alumno no encontrado.");
                }
            } else if (e.getSource() == btnPrestar) {
                Alumno a = biblioteca.buscarAlumno(txtCodAluPrest.getText());
                Material m = biblioteca.buscarMaterialPorCodigo(txtCodMatPrest.getText());
                Prestamo p = biblioteca.registrarPrestamo(a, m);
                if (p != null) {
                    mostrarPrestamos();
                    JOptionPane.showMessageDialog(null, "Préstamo registrado. Vence: " + p.getFechaLimite());
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el préstamo.");
                }
            } else if (e.getSource() == btnDevolver) {
                Prestamo p = biblioteca.buscarPrestamoActivo(txtCodAluPrest.getText(), txtCodMatPrest.getText());
                if (p != null) {
                    int dias = Integer.parseInt(txtDiasRetraso.getText());
                    double multa;
                    if (dias > 0) {
                        p.registrarDevolucion(p.getFechaLimite().plusDays(dias));
                        multa = p.getMulta();
                    } else {
                        multa = biblioteca.registrarDevolucion(p);
                    }
                    mostrarPrestamos();
                    JOptionPane.showMessageDialog(null, "Devuelto. Multa: S/ " + multa);
                } else {
                    JOptionPane.showMessageDialog(null, "Préstamo no encontrado.");
                }
            } else if (e.getSource() == btnVerCatalogo) {
                mostrarCatalogo();
            } else if (e.getSource() == btnVerAlumnos) {
                mostrarAlumnos();
            } else if (e.getSource() == btnVerPrestamos) {
                mostrarPrestamos();
            }
        }
    }

    public static void main(String[] args) {
        new VentanaBiblioTech();
    }
}