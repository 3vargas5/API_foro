package top.icos.api.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(int id,
                                  @NotBlank
                                  String titulo,
                                  @NotBlank
                                  String mensaje,
                                  @NotBlank
                                  String fecha_creacion,
                                  @NotBlank
                                  Estatus estatus,
                                  @NotBlank
                                  String autor,
                                  @NotBlank
                                  Cursos curso) {

}
