package com.ciyama.ciyportifliojava.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.ciyama.ciyportifliojava.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedito) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedito);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}
