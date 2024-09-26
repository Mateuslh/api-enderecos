package dev.mateuslh.service;

import dev.mateuslh.Exception.EntidadeNaoEncontradaException;
import dev.mateuslh.model.Pais;
import dev.mateuslh.repository.PaisRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private PaisService paisService;

    @Autowired
    private ModelMapper modelMapper;

    public Pais findById(Long id) {
        return paisRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(Pais.class));
    }

    public Page<Pais> findAll(Pageable pageable) {
        return paisRepository.findAll(pageable);
    }

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    public Pais update(Long id, Pais pais) {
        Pais paisAtual = paisService.findById(id);
        modelMapper.map(pais, paisAtual);
        return paisService.save(paisAtual);
    }

    public void deleteById(Long id) {
        paisService.findById(id);
        paisRepository.deleteById(id);
    }
}
