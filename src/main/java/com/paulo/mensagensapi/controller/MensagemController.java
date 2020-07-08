package com.paulo.mensagensapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.mensagensapi.model.Mensagem;
import com.paulo.mensagensapi.service.MensagemService;

@CrossOrigin("*")
@RestController
@RequestMapping("/mensagens")
public class MensagemController {

	@Autowired private MensagemService mensagemService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Mensagem salvar(@Valid @RequestBody Mensagem mensagem) {
		return mensagemService.salvar(mensagem);
	}
	
	@GetMapping
	public List<Mensagem> listar(){
		return mensagemService.listar();
	}
	
	@GetMapping("/{id}")
	public Mensagem buscarPorId(@PathVariable Long id) {
		return mensagemService.buscarPorId(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{id}")
	public void deletarPorId(@PathVariable Long id) {
		mensagemService.deletarPorId(id);
	}
	
	@PutMapping("/{id}")
	public Mensagem editar(@PathVariable Long id, @RequestBody @Valid Mensagem mensagem) {
		return mensagemService.editar(mensagem, id);
	}
}
