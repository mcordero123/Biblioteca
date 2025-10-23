package cl.colegioelbelloto.biblioteca.controller;


import cl.colegioelbelloto.biblioteca.model.Libro;

import cl.colegioelbelloto.biblioteca.services.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    LibroServiceImpl libroService;
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro, Model model){
        try {
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
}
