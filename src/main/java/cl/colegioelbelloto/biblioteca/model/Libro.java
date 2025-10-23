package cl.colegioelbelloto.biblioteca.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    @NonNull
    private String titulo;
    @NonNull
    private String autor;
    @NonNull
    @Column(unique = true) // para que no se repitan
    private String isbn;
    private String anioPublicacion;
    private int stock;

    public Libro(Long idLibro, @NonNull String titulo, @NonNull String autor, @NonNull String isbn, String anioPublicacion, int stock) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.stock = stock;
    }

    public Libro() {

    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public @NonNull String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NonNull String titulo) {
        this.titulo = titulo;
    }

    public @NonNull String getAutor() {
        return autor;
    }

    public void setAutor(@NonNull String autor) {
        this.autor = autor;
    }

    public @NonNull String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NonNull String isbn) {
        this.isbn = isbn;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
