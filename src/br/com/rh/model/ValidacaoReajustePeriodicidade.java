package br.com.rh.model;

import br.com.rh.exception.ValidacaoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoReajustePeriodicidade implements ValidacaoReajuste{


    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        if (ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual) < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser de no mínimo 6 meses!");
        }
    }
}
