package com.algaworks.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.model.LancamentoOld;
import com.algaworks.model.Pessoa;
import com.algaworks.repository.LancamentoRepository;
import com.algaworks.repository.PessoaRepository;
import com.algaworks.service.exception.PessoaInexistenteOuInativaException;
//
//@Service
//public class LancamentoService {
//
//	@Autowired
//	private PessoaRepository pessoaRepository;
//
//	@Autowired
//	private LancamentoRepository lancamentoRepository;
//
//	public LancamentoOld salvar(LancamentoOld lancamento) {
//		validarPessoa(lancamento);
//
//		return lancamentoRepository.save(lancamento);
//	}
//
//	public LancamentoOld atualizar(Long codigo, LancamentoOld lancamento) {
//		LancamentoOld lancamentoSalvo = buscarLancamentoExistente(codigo);
//
//		if (!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
//			validarPessoa(lancamento);
//		}
//
//		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
//
//		return lancamentoRepository.save(lancamentoSalvo);
//	}
//
//	private void validarPessoa(LancamentoOld lancamento) {
//		Optional<Pessoa> pessoaOpt = null;
//
//		if (lancamento.getPessoa().getCodigo() != null) {
//			pessoaOpt = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
//		}
//
//		if(pessoaOpt == null || pessoaOpt.isEmpty() || pessoaOpt.get().isInativo()) {
//			throw new PessoaInexistenteOuInativaException();
//		}
//	}
//
//	private LancamentoOld buscarLancamentoExistente(Long codigo) {
//		Optional<LancamentoOld> lancamentoSalvoOpt = lancamentoRepository.findById(codigo);
//
//		return lancamentoSalvoOpt.orElseThrow(() -> new IllegalArgumentException());
//	}
//}
