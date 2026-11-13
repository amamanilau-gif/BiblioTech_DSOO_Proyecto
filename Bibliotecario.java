package PROYECTO_DSOO;

public class Bibliotecario extends Persona{
    private String turno;
    private String codigoEmp;
    private boolean activo;

    @Override 
    public String getRol() {
        return "Bibliotecario";
    }
}
