package com.app.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.web.entidad.Estudiante;
import com.app.web.exepciones.DuplicadoException;
import com.app.web.servicio.EstudianteServicio;

/**
 * Controlador para gestionar las operaciones relacionadas con los estudiantes.
 */
@Controller
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio servicio;

    /**
     * Muestra la lista de estudiantes.
     *
     * @param modelo El modelo para la vista.
     * @return El nombre de la vista.
     */
    @GetMapping({"/estudiantes", "/"})
    public String listarEstudiantes(Model modelo) {
        modelo.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());
        return "estudiantes"; // nos retorna al archivo estudiantes
    }

    /**
     * Muestra el formulario para registrar un nuevo estudiante.
     *
     * @param modelo El modelo para la vista.
     * @return El nombre de la vista del formulario de creacion.
     */
    @GetMapping("/estudiantes/nuevo")
    public String mostrarFormularioDeRegistrtarEstudiante(Model modelo) {
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    /**
     * Guarda un nuevo estudiante.
     *
     * @param estudiante El estudiante a guardar.
     * @param model      El modelo para la vista.
     * @return El nombre de la vista a la que redirigir despues de guardar.
     */
    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante, Model model) {
        try {
            servicio.guardarEstudiante(estudiante);
            return "redirect:/estudiantes";
        } catch (DuplicadoException e) {
            model.addAttribute("error", "Duplicado encontrado en número de celular o correo electrónico. Ingresa otros valores por favor.");
            return "crear_estudiante";
        }
    }

    /**
     * Muestra el formulario para editar un estudiante.
     *
     * @param id     El ID del estudiante a editar.
     * @param modelo El modelo para la vista.
     * @return El nombre de la vista del formulario de edición.
     */
    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
        return "editar_estudiante";
    }

    /**
     * Actualiza la información de un estudiante.
     *
     * @param id         El ID del estudiante a actualizar.
     * @param estudiante El estudiante con la información actualizada.
     * @param modelo     El modelo para la vista.
     * @return El nombre de la vista a la que redirigir despues de actualizar.
     */
    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,
                                       Model modelo) {
        Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());
        estudianteExistente.setCelular(estudiante.getCelular());

        servicio.actualizarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }

    /**
     * Elimina un estudiante por ID.
     *
     * @param id El ID del estudiante a eliminar.
     * @return El nombre de la vista a la que redirigir despues de eliminar.
     */
    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        servicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }

    /**
     * Elimina varios estudiantes por sus IDs.
     *
     * @param ids Lista de IDs de estudiantes a eliminar.
     * @return El nombre de la vista a la que redirigir despues de eliminar.
     */
    @PostMapping("/estudiantes/eliminar")
    public String eliminarVariosEstudiantes(@RequestParam("id") List<Long> ids) {
        servicio.eliminarVariosEstudiantes(ids);
        return "redirect:/estudiantes";
    }

    /**
     * Busca estudiantes por un criterio de busqueda.
     *
     * @param query El criterio de busqueda.
     * @param model El modelo para la vista.
     * @return El nombre de la vista que muestra los resultados de la busqueda.
     */
    @GetMapping("/estudiantes/buscar")
    public String buscarEstudiantes(@RequestParam String query, Model model) {
        List<Estudiante> resultadosBusqueda = servicio.buscarEstudiantes(query);
        model.addAttribute("estudiantes", resultadosBusqueda);
        return "estudiantes"; // Reemplaza "estudiantes" con el nombre de tu vista HTML de listado de estudiantes
    }
}
