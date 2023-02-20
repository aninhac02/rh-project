package br.com.rh.service;

import br.com.rh.model.Funcionario;
import br.com.rh.model.ValidacaoReajuste;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento) {
        validacoes.forEach(v -> v.validar(funcionario, aumento));

        BigDecimal novoSalario = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(novoSalario);
    }
}
