package dev.mateuslh.service;

import dev.mateuslh.Exception.EntidadeNaoEncontradaException;
import dev.mateuslh.model.Estado;
import dev.mateuslh.repository.EstadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private ModelMapper modelMapper;

    public Estado findById(Long id) {
        return estadoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(Estado.class));
    }

    public Page<Estado> findAll(Pageable pageable) {
        return estadoRepository.findAll(pageable);
    }

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado update(Long id, Estado estado) {
        Estado estadoAtual = estadoService.findById(id);
        modelMapper.map(estado, estadoAtual);
        return estadoService.save(estadoAtual);
    }


    public void deleteById(Long id) {
        estadoService.findById(id);
        estadoRepository.deleteById(id);
    }
}
