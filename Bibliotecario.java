package PROYECTO_DSOO;

public class Bibliotecario extends Persona{
    private String turno;
    private String codigoEmp;
    private boolean activo;

    public Bibliotecario(int id, String nombre, String correo, String turno, String codigoEmp) {
        super(id,nombre,correo);
        this.turno=turno;
        this.codigoEmp=codigoEmp;
        this.activo=true;
    }
    @Override 
    public String getRol() {
        return "Bibliotecario";
    }
    public String getTurno() {
        return turno;
    }
    public String getCodigoEmp() {
        return codigoEmp;
    }
    public boolean estaActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo=activo;
    }
}
