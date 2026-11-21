package PROYECTO_DSOO;
    import java.util.*;
public class Biblioteca {
    private ArrayList<Material> materiales;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Bibliotecario> bibliotecarios;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        this.materiales=new ArrayList<>();
        this.alumnos=new ArrayList<>();
        this.bibliotecarios=new ArrayList<>();
        this.prestamos=new ArrayList<>();
    }
    public void agregarMaterial(Material m) {
        if (m!=null) {
            materiales.add(m);
        }
    }
    public void agregarAlumno(Alumno a) {
        if (a!=null) {
            alumnos.add(a);
        }
    }
    public void registrarBibliotecario(Bibliotecario b) {
        if (b != null) {
            bibliotecarios.add(b);
        }
    }
    public boolean verificarDisponibilidad(Material m) {
        return m!= null && m.esDisponible(); 
    }
    public Material buscarMaterial(String titulo) {
        for(Material m:materiales) {
            if(m.getTitulo().equalsIgnoreCase(titulo.trim())){ 
                return m;
            }
        }
        return null;
    }
    public Material buscarMaterialPorCodigo(String codigo) {
        for(Material m:materiales) {
            if(m.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return m;
            }
        }
        return null;
    }
    public Alumno buscarAlumno(String codigo) {
        for(Alumno a:alumnos) {
            if(a.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return a;
            }
        }
        return null;
    }
    public Prestamo registrarPrestamo(Alumno a, Material m) {
        if (a == null || m == null) {
            System.out.println("Alumno o material no encontrado.");
            return null;
        }
        if (!verificarDisponibilidad(m)) {
            System.out.println("El material '" + m.getTitulo() + "' no tiene ejemplares disponibles.");
            return null;
        }
        if (!a.puedeSolicitarPrestamo()) {
            System.out.println("El alumno tiene multas pendientes (S/ " + a.getMultas() + ").");
            return null;
        }
        m.prestar();
        Prestamo nuevo = new Prestamo(a, m);
        prestamos.add(nuevo);
        return nuevo;
    }
    public double registrarDevolucion(Prestamo p) {
        if(p!=null && p.estaActivo()) {
            p.registrarDevolucion();
            return p.getMulta();
        }
        return 0.0;
    }
    public Prestamo buscarPrestamoActivo(String codigoAlumno,String codigoMaterial) {
        for(Prestamo p:prestamos) {
            if(p.estaActivo()
                && p.getAlumno().getCodigo().equalsIgnoreCase(codigoAlumno.trim())
                && p.getMaterial().getCodigo().equalsIgnoreCase(codigoMaterial.trim())) {
                return p;
            }
        }
        return null;
    }
    public void imprimirReporte(Reportable r) {
        System.out.println(r.generarResumen());
    }
    public ArrayList<Material> getMateriales() {
        return materiales;    
    }
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;    
    }
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;    
    }
    public ArrayList<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }
}

