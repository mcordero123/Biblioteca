package cl.colegioelbelloto.biblioteca.controller;


import cl.colegioelbelloto.biblioteca.model.Libro;

import cl.colegioelbelloto.biblioteca.services.GoogleBooksService;
import cl.colegioelbelloto.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    LibroService libroService;
    @Autowired
    GoogleBooksService googleBooksService;
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro, Model model){
        try {
            googleBooksService.buscarPorIsbn(libro.getIsbn());
            libroService.saveLibro(libro);
            model.addAttribute("mensaje", "libro guardado exitosamente");
            model.addAttribute("libro", new Libro());
            return "libro_form";

        }catch (Exception e){
            model.addAttribute("error", "Error al guardar" + e.getMessage());
            return "libro_form";
        }
    }
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("libro", new Libro());
        return "libro_form";
    }
    @GetMapping("/lista")
    public String listarLibros(Model model){
        List<Libro> libros = libroService.AllLibros();
        model.addAttribute("libros", libros);
        return "lista_libros";
    }
}
