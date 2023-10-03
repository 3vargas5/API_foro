package top.icos.api.topico;

public record DatosListadoTopico(int id, String titulo, String mensaje, String fecha_creacion, Estatus estatus, String autor, Cursos curso) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_creacion(),topico.getEstatus(),topico.getAutor(),topico.getCurso());
    }
}
