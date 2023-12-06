
package com.app.web.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad que representa a un estudiante.
 */
@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "celular", nullable = false, length = 50, unique = true)
    private Long celular;

    /**
     * Constructor por defecto de la clase Estudiante.
     */
    public Estudiante() {

    }

    /**
     * Constructor de la clase Estudiante con todos los atributos.
     *
     * @param id      El ID del estudiante.
     * @param nombre  El nombre del estudiante.
     * @param apellido El apellido del estudiante.
     * @param email   El correo electrónico del estudiante.
     * @param celular El número de celular del estudiante.
     */
    public Estudiante(Long id, String nombre, String apellido, String email, Long celular) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
    }

    /**
     * Constructor de la clase Estudiante con los atributos obligatorios.
     *
     * @param nombre  El nombre del estudiante.
     * @param apellido El apellido del estudiante.
     * @param email   El correo electrónico del estudiante.
     * @param celular El número de celular del estudiante.
     */
    public Estudiante(String nombre, String apellido, String email, Long celular) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
    }

    /**
     * Obtiene el ID del estudiante.
     *
     * @return El ID del estudiante.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del estudiante.
     *
     * @param id El ID del estudiante.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estudiante.
     *
     * @return El nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante.
     *
     * @param nombre El nombre del estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del estudiante.
     *
     * @return El apellido del estudiante.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del estudiante.
     *
     * @param apellido El apellido del estudiante.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electronico del estudiante.
     *
     * @return El correo electronico del estudiante.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electronico del estudiante.
     *
     * @param email El correo electróonico del estudiante.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el numero de celular del estudiante.
     *
     * @return El numero de celular del estudiante.
     */
    public Long getCelular() {
        return celular;
    }

    /**
     * Establece el numero de celular del estudiante.
     *
     * @param celular El numero de celular del estudiante.
     */
    public void setCelular(Long celular) {
        this.celular = celular;
    }

    /**
     * Representación en cadena del objeto Estudiante.
     *
     * @return Una cadena que representa el objeto Estudiante.
     */
    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", celular=" + celular + "]";
    }
}
