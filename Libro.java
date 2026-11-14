package PROYECTO_DSOO;

public class Libro extends Material{
    private String autor;
    private String isbn;
    private int ejemplares;

    public Libro(String codigo, String titulo, String autor, String isbn, int ejemplares) {
        super(codigo,titulo);
        this.autor=autor;
        this.isbn=isbn;
        this.ejemplares=ejemplares;
        this.disponible=ejemplares > 0;
    }
    @Override 
    public void prestar() {
        if(ejemplares>0) {
            ejemplares--;
            this.disponible=ejemplares>0;
        }
    }
    @Override
    public void devolver() {
        ejemplares++;
        this.disponible=true;
    }
    @Override
    public int getDias() {
        return 7;
    }
    public String getAutor() {
        return autor;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getEjemplares() {
        return ejemplares;
    }
    @Override 
    public String generarResumen() {
        return super.generarResumen()+" | Libro-Autor: "+autor+" | ISBN: "+isbn+" | Ejemplares: "+ejemplares+
        " | Plazo: "+getDias()+" dias";
    }
}
