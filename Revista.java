package PROYECTO_DSOO;

public class Revista extends Material{
    private int numero;
    private String mes;
    private int anio;

    public Revista(String codigo, String titulo, int numero, String mes, int anio) {
        super(codigo,titulo);
        this.numero=numero;
        this.mes=mes;
        this.anio=anio;
    }
    @Override 
    public int getDias() {
        return 3;
    }
    public int getnumero() {
        return numero;
    }
    public String getMes() {
        return mes;
    }
    public int getAnio() {
        return anio;
    }
    @Override 
    public String generarResumen() {
        return super.generarResumen()+" | Revista N.° "+numero+ " ("+mes+" "+anio+
        ") | Plazo: "+getDias()+" dias";
    }
}
