package com.seuprojeto.tarefas.service;

import com.seuprojeto.tarefas.model.Tarefa;

import java.util.List;

public interface TarefaService {
    Tarefa criarTarefa(Tarefa tarefa);
    Tarefa atualizarTarefa(Long id, Tarefa tarefa);
    void deletarTarefa(Long id);
    List<Tarefa> listarTarefas();
    Tarefa buscarPorId(Long id);
}
