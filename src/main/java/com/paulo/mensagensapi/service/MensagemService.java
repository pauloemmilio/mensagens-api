package com.paulo.mensagensapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.paulo.mensagensapi.model.Mensagem;
import com.paulo.mensagensapi.repository.MensagemRepository;

@Service
public class MensagemService {

	@Autowired private MensagemRepository mensagemRepository;

	public Mensagem salvar(Mensagem mensagem) {
		return mensagemRepository.save(mensagem);
	}

	public List<Mensagem> listar() {
		return mensagemRepository.findAll();
	}

	public Mensagem buscarPorId(Long id) {
		return mensagemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensagem não encontrada."));
	}

	public void deletarPorId(Long id) {
		mensagemRepository.deleteById(id);
	}

	public Mensagem editar(Mensagem mensagem, Long id) {
		Mensagem mensagemPersistida = this.buscarPorId(id);
		mensagemPersistida.setTexto(mensagem.getTexto());
		return mensagemRepository.save(mensagemPersistida);
	}
	
}
