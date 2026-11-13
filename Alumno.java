package PROYECTO_DSOO;

public class Alumno extends Persona {
    private String codigo;
    private String carrera;
    private double multas;

    @Override 
    public String getRol() {
        return "Alumno";
    }
}
