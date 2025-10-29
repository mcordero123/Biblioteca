package cl.colegioelbelloto.biblioteca.services;

import cl.colegioelbelloto.biblioteca.model.Libro;
import cl.colegioelbelloto.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;

    public  Libro saveLibro(Libro libro){
        libroRepository.save(libro);
        return libro;
    }

    public List<Libro> AllLibros(){
        return libroRepository.findAll();
    }

    public void deleteLibro(Long idLibro){
        libroRepository.deleteById(idLibro);
    }

    public Libro findByIdLibro(Long id){
        return libroRepository.findById(id).orElse(null);
    }

    public Libro updateLibro(Long idLibro, Libro libroActualizado){
        return libroRepository.findById(idLibro)
                .map(libroExistente -> {
                    libroExistente.setTitulo(libroActualizado.getTitulo());
                    libroExistente.setAutor(libroActualizado.getAutor());
                    libroExistente.setIsbn(libroActualizado.getIsbn());
                    libroExistente.setAnioPublicacion(libroActualizado.getAnioPublicacion());
                    libroExistente.setStock(libroActualizado.getStock());
                    libroExistente.setTitulo(libroActualizado.getTitulo());
                    return libroRepository.save(libroExistente);
                })
                .orElse(null);
    }
}
