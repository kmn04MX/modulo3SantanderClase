package org.bedu.jse2.demo.reactive.ejemplo3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class E3ControllerTest {

    private static final List<String> NOMBRES = Arrays.asList("Romo Pérez, Juan", "Sánchez García, Diana", "Rodríguez Soto, Sebastian");

    @Test
    @DisplayName("Ejercicio 3")
    void testTransformacion() {
        E3Controller controller = new E3Controller();

        controller.nombresUsuarios()
                .subscribe(nombre -> assertThat(NOMBRES.contains(nombre)).isTrue());
    }

    @Test
    @DisplayName("Reto 3")
    void reto3() {
        String NOMBRE_QUERY = "Dia";
        String NOMBRE_COMPLETO = "Diana Sánchez García";
        String TELEFONO = "5550000002";

        E3Controller controller = new E3Controller();
        controller.buscarPorNombre(NOMBRE_QUERY)
                .subscribe(a -> {
                    assertThat(a.getNombreCompleto()).isEqualTo(NOMBRE_COMPLETO);
                    assertThat(a.getTelefono()).isEqualTo(TELEFONO);
                });
    }

}