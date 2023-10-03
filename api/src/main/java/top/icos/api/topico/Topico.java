package top.icos.api.topico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "Topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String titulo;
    public String mensaje;
    public String fecha_creacion;
    @Enumerated(EnumType.STRING)
    public Estatus estatus;
    public String autor;
    @Enumerated(EnumType.STRING)
    public Cursos curso;


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fecha_creacion = fechaActual.format(formateador);
        this.estatus = datosRegistroTopico.estatus();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.estatus() != null){
            this.estatus = datosActualizarTopico.estatus();
        }
        if(datosActualizarTopico.curso() != null){
            this.curso = datosActualizarTopico.curso();
        }
    }
}
