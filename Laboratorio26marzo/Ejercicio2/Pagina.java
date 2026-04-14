package Laboratorio26marzo.Ejercicio2;

public class Pagina {

    private String url;
    private String titulo;

    public Pagina(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
    }

    public String getUrl() { return url; }
    public String getTitulo() { return titulo; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pagina)) return false;
        Pagina otra = (Pagina) obj;
        return this.url.equals(otra.url);
    }

    @Override
    public String toString() {
        return titulo + " (" + url + ")";
    }
}