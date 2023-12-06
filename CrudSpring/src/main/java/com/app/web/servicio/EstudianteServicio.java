package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Estudiante;

/**
 * Interfaz que define las operaciones de servicio para la entidad Estudiante.
 */
public interface EstudianteServicio {

    /**
     * Obtiene una lista de todos los estudiantes.
     *
     * @return Lista de todos los estudiantes.
     */
    public List<Estudiante> listarTodosLosEstudiantes();

    /**
     * Guarda un nuevo estudiante en la base de datos.
     *
     * @param estudiante El estudiante a ser guardado.
     * @return El estudiante guardado.
     */
    public Estudiante guardarEstudiante(Estudiante estudiante);

    /**
     * Obtiene un estudiante por su ID.
     *
     * @param id El ID del estudiante a obtener.
     * @return El estudiante con el ID proporcionado.
     */
    public Estudiante obtenerEstudiantePorId(Long id);

    /**
     * Actualiza la información de un estudiante existente.
     *
     * @param estudiante El estudiante con la información actualizada.
     * @return El estudiante actualizado.
     */
    public Estudiante actualizarEstudiante(Estudiante estudiante);

    /**
     * Elimina un estudiante por su ID.
     *
     * @param id El ID del estudiante a eliminar.
     */
    public void eliminarEstudiante(Long id);

    /**
     * Elimina varios estudiantes por sus IDs.
     *
     * @param ids Lista de IDs de estudiantes a eliminar.
     */
    public void eliminarVariosEstudiantes(List<Long> ids);

    /**
     * Busca estudiantes cuyos nombres, apellidos, correo electronico o número de celular contienen el criterio proporcionado.
     *
     * @param query El criterio de busqueda.
     * @return Una lista de estudiantes que cumplen con el criterio de busqueda.
     */
    public List<Estudiante> buscarEstudiantes(String query);
}
