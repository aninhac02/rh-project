package br.com.rh.service;

import br.com.rh.exception.ValidacaoException;
import br.com.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class ReajusteService {

    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento) {
       BigDecimal salario = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
        BigDecimal novoSalario = salario.add(aumento);
        funcionario.atualizarSalario(novoSalario);
    }
}
