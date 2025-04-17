package com.seuprojeto.tarefas.service;

import com.seuprojeto.tarefas.model.Tarefa;
import com.seuprojeto.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Override
    public Tarefa criarTarefa(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @Override
    public Tarefa atualizarTarefa(Long id, Tarefa tarefa) {
        Tarefa existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        existente.setNome(tarefa.getNome());
        existente.setDescricao(tarefa.getDescricao());
        existente.setStatus(tarefa.getStatus());
        existente.setObservacoes(tarefa.getObservacoes());
        return repository.save(existente);
    }

    @Override
    public void deletarTarefa(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    @Override
    public Tarefa buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }
}
