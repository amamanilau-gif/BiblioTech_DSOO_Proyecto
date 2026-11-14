package PROYECTO_DSOO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo implements Reportable{
    private Alumno alumno;
    private Material material;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private LocalDate fechaDevolucion;
    private double multa;
    private static final double TARIFA_DIARIA=2.50;

    public Prestamo(Alumno alumno, Material material) {
        this.alumno=alumno;
        this.material=material;
        this.fechaPrestamo=LocalDate.now();
        this.fechaLimite=this.fechaPrestamo.plusDays(material.getDias());
        this.fechaDevolucion=null;
        this.multa=0.0;
    }
    public double calcularMulta() {
        LocalDate fechaRef;
        if(fechaDevolucion!=null) {
            fechaRef=fechaDevolucion;
        } else {
            fechaRef=LocalDate.now();
        }
        if (fechaRef.isAfter(fechaLimite)) {
            long diasRetraso=ChronoUnit.DAYS.between(fechaLimite, fechaRef);
            return diasRetraso*TARIFA_DIARIA;
        }
        return 0.0;
    }
    public void registrarDevolucion() {
        registrarDevolucion(LocalDate.now());
    }  
    public void registrarDevolucion(LocalDate fechaReal) {
        this.fechaDevolucion=fechaReal;
        this.multa=calcularMulta();
        if (this.multa>0) {
            this.alumno.agregarMulta(this.multa);
        }
        this.material.devolver();
    }
    public Alumno getAlumno() {
        return alumno;
    }
    public Material getMaterial() {
        return material;
    }
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public LocalDate getFechaLimite() {
        return fechaLimite;
    }
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public double getMulta() {
        return multa;
    }
    public boolean estaActivo() {
        return fechaDevolucion == null;
    }
    @Override 
    public String generarResumen() {
        String estado;
        if(estaActivo()) {
            estado="Activo (Vence: "+fechaLimite+")";
        } else {
            estado="Devuelto ("+fechaDevolucion+")";
        }
        return "Alumno: " + alumno.getNombre() + " | Material: " + material.getTitulo() +
               " | Estado: " + estado + " | Multa: S/ " + String.format("%.2f", multa);
    }
}
