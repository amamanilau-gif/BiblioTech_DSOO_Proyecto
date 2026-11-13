package PROYECTO_DSOO;

public class Libro extends Material{
    private String autor;
    private String isbn;
    private int ejemplares;

    @Override
    public int getDias() {
        return 0;
    }
}
