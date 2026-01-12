/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.fw.erp.implementacao.codigopostalbr.pepino.postMan;

import br.org.coletivoJava.fw.api.erp.codigoPostal.br.ItfCodigoPostalBR;
import br.org.coletivoJava.fw.api.erp.codigopostalbr.InfoRespostaCepWebService;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.cep.ComoLocal;
import java.util.List;

/**
 *
 * @author desenvolvedorninja01
 * @since 24/10/2019
 * @version 1.0
 */
public class ValidaCEP implements ItfCodigoPostalBR {

    @Override
    public boolean configuraEndereco(String cep, ComoLocal pLocal) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");

    }

    @Override
    public List<String> cepsPorEndereco(String pEndereco) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }

    @Override
    public boolean isCepExiste(String pCep) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");

    }

    @Override
    public boolean configurarPosicaoGeogafica(ComoLocal pLocal) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }

    @Override
    public boolean contribuirCadastroNovoEndereco(ComoLocal pLocal) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }

    @Override
    public InfoRespostaCepWebService getInfoRespostaWebService(String cep) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }

}
