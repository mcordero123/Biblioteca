package cl.colegioelbelloto.biblioteca.controller;


import cl.colegioelbelloto.biblioteca.model.Libro;

import cl.colegioelbelloto.biblioteca.services.GoogleBooksService;
import cl.colegioelbelloto.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    LibroService libroService;
    @Autowired
    GoogleBooksService googleBooksService;


    @GetMapping("/buscar")
    public String buscarPorIsbn(@RequestParam String isbn, Model model){
        Libro libro = googleBooksService.buscarPorIsbn(isbn);
        if (libro == null){
            model.addAttribute("No se encontró información para el ISBN: " + isbn);
            model.addAttribute(new Libro());
        }else{
            model.addAttribute("libro", libro);
        }
        return "libro_form";
    }

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

    // localhost:8080/libros/eliminar/1
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id, Model model){
        libroService.deleteLibro(id);
        return "redirect:/libros/lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model){
        Libro libro = libroService.findByIdLibro(id);
        model.addAttribute("libro", libro);
        return "libro_form";

    }

    @PostMapping
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute Libro libro){
        libroService.updateLibro(id, libro);
        return "redirect:/libros/lista";
    }
}

