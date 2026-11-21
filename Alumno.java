package PROYECTO_DSOO;

public class Alumno extends Persona implements Reportable{
    private String codigo;
    private String carrera;
    private double multas;

    public Alumno(int id, String nombre, String correo, String codigo,String carrera) {
        super(id,nombre,correo);
        this.codigo=codigo;
        this.carrera=carrera;
        this.multas=0.0;
    }
    @Override 
    public String getRol() {
        return "Alumno";
    }
    public String getCodigo() {
        return codigo;
    }
    public String getCarrera() {
        return carrera;
    }
    public double getMultas() {
        return multas;
    }
    public void agregarMulta(double monto) {
        if (monto>0) {
            this.multas += monto;
        }
    }
    public void pagarMultas() {
        this.multas=0.0;
    }
    public boolean puedeSolicitarPrestamo() {
        return this.multas==0.0;
    }
    @Override 
    public String generarResumen() {
        return codigo+" | "+getNombre()+" ("+carrera+") | Multas S/ "+String.format("%.2f",multas);
    }
}
