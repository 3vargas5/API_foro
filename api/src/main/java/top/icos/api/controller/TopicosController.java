package top.icos.api.controller;

import java.util.Collections;
import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.icos.api.topico.DatosActualizarTopico;
import top.icos.api.topico.DatosRegistroTopico;
import top.icos.api.topico.Topico;
import top.icos.api.topico.TopicoRepository;
import java.util.Optional;



@RestController
@RequestMapping("/topicos")
public class TopicosController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrar_topico(@RequestBody DatosRegistroTopico datosRegistroTopico){
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    @GetMapping
    public List<Topico> listadoTopicos(){
        return topicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Topico> verTopico(@PathVariable int id){
        return topicoRepository.findAllById(Collections.singleton(id));
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }

    @DeleteMapping("/{id}")
    public void eliminarTopico(@PathVariable int id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }

}
