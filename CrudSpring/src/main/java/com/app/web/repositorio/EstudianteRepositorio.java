package com.app.web.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Estudiante;

/**
 * Repositorio que gestiona las operaciones de base de datos para la entidad Estudiante.
 */
@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {

    /**
     * Busca estudiantes cuyos nombres o apellidos contienen el criterio proporcionado.
     *
     * @param query El criterio de busqueda para nombres o apellidos.
     * @return Una lista de estudiantes que cumplen con el criterio de búsqueda.
     */
    @Query("SELECT e FROM Estudiante e WHERE e.nombre LIKE %:query% OR e.apellido LIKE %:query%")
    List<Estudiante> buscarPorCriterio(@Param("query") String query);

    /**
     * Verifica la existencia de un número de celular en la base de datos.
     *
     * @param celular El número de celular a verificar.
     * @return El ID del estudiante si el número de celular existe, o null si no existe.
     */
    @Query("SELECT e.id FROM Estudiante e WHERE e.celular = :celular")
    Long existeCelular(@Param("celular") Long celular);

    /**
     * Verifica la existencia de un correo electrónico en la base de datos.
     *
     * @param email El correo electrónico a verificar.
     * @return El ID del estudiante si el correo electrónico existe, o null si no existe.
     */
    @Query("SELECT e.id FROM Estudiante e WHERE e.email = :email")
    Long existeEmail(@Param("email") String email);

}
