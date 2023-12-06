package com.app.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot para el CRUD.
 */
@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner {

    /**
     * Punto de entrada principal para la aplicación Spring Boot.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(CrudSpringBootApplication.class, args);
    }

    /**
     * Método de ejecución principal para la aplicación Spring Boot.
     *
     * @param args Los argumentos de la línea de comandos.
     * @throws Exception Excepción que puede ser lanzada durante la ejecución.
     */
    @Override
    public void run(String... args) throws Exception {
        // Lógica de inicialización o configuración adicional puede ser añadida aquí.
    }
}
