package top.icos.api.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull int id, String titulo, String mensaje, Estatus estatus, Cursos curso) {

}
