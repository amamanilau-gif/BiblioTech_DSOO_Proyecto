package PROYECTO_DSOO;

public abstract class Material implements Prestable, Reportable{
    protected String codigo;
    protected String titulo;
    protected boolean disponible;

    public Material(String codigo, String titulo) {
        this.codigo=codigo;
        this.titulo=titulo;
        this.disponible=true;
    }

    @Override 
    public void prestar(){ 
        this.disponible=false;
    }
    @Override
    public void devolver() {
        this.disponible=true;
    }
    @Override
    public boolean esDisponible() {
        return disponible;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public abstract int getDias();
    @Override
    public String generarResumen() {
        String estado;
        if(disponible) {
            estado="disponible";
        } else {
            estado="No disponible";
        }
    return codigo+" | "+titulo+" ("+estado+")";
    }
}

