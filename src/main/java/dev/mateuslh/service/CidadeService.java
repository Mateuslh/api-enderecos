package dev.mateuslh.service;

import dev.mateuslh.Exception.EntidadeNaoEncontradaException;
import dev.mateuslh.model.Cidade;
import dev.mateuslh.repository.CidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private ModelMapper modelMapper;

    public Cidade findById(Long id) {
        return cidadeRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(Cidade.class));
    }

    public Page<Cidade> findAll(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public Cidade update(Long id, Cidade cidade) {
        Cidade cidadeAtual = cidadeService.findById(id);
        modelMapper.map(cidade, cidadeAtual);
        return cidadeService.save(cidadeAtual);
    }

    public void deleteById(Long id) {
        cidadeService.findById(id);
        cidadeRepository.deleteById(id);
    }
}
