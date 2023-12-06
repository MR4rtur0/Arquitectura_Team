package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Estudiante;
import com.app.web.exepciones.DuplicadoException;
import com.app.web.repositorio.EstudianteRepositorio;

/**
 * Implementacion del servicio para gestionar operaciones relacionadas con la entidad Estudiante.
 */
@Service
public class EstudianteServicioImpl implements EstudianteServicio {

    @Autowired
    private EstudianteRepositorio repositorio;

    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        return repositorio.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        try {
            verificarDuplicados(estudiante);
            return repositorio.save(estudiante);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicadoException("Error de integridad de datos: " + e.getMessage(), e);
        }
    }

    /**
     * Verifica la existencia de duplicados en la base de datos antes de guardar un estudiante.
     *
     * @param estudiante El estudiante a verificar.
     */
    private void verificarDuplicados(Estudiante estudiante) {
        Long celularExistente = repositorio.existeCelular(estudiante.getCelular());
        Long emailExistente = repositorio.existeEmail(estudiante.getEmail());

        if ((celularExistente != null && !celularExistente.equals(estudiante.getId())) ||
                (emailExistente != null && !emailExistente.equals(estudiante.getId()))) {
            throw new DataIntegrityViolationException("Duplicado encontrado en número de celular o correo electrónico");
        }
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public void eliminarVariosEstudiantes(List<Long> ids) {
        for (Long id : ids) {
            repositorio.deleteById(id);
        }
    }

    @Override
    public List<Estudiante> buscarEstudiantes(String query) {
        return repositorio.buscarPorCriterio(query); // Este mtoedo deberá ser implementado en tu repositorio
    }
}
