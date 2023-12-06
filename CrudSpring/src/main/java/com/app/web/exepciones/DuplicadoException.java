package com.app.web.exepciones;

import org.springframework.dao.DataIntegrityViolationException;

/**
 * Excepcion personalizada para manejar casos de duplicados en la integridad de datos.
 */
public class DuplicadoException extends DataIntegrityViolationException {

    /**
     * Crea una nueva instancia de DuplicadoException con el mensaje de error y la causa.
     *
     * @param msg   El mensaje de error descriptivo.
     * @param cause La causa subyacente que provocó la excepción.
     */
    public DuplicadoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
