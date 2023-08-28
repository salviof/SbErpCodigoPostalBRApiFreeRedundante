/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.fw.erp.implementacao.codigopostalbr;

import br.org.coletivoJava.fw.api.erp.codigoPostal.br.ItfCodigoPostalBR;
import br.org.coletivoJava.fw.api.erp.codigopostalbr.InfoRespostaCepWebService;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreClienteRest;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.cep.ItfLocal;
import jakarta.json.JsonObject;
import java.util.List;
import org.json.simple.JSONObject;

/**
 *
 * @author desenvolvedorninja01
 * @since 24/10/2019
 * @version 1.0
 *
 */
public class CodigoPostalBRApiPostMon implements ItfCodigoPostalBR {

    private InfoRespostaCepWebService infoRespostaCepWebService;
    private JsonObject objcep;

    @Override
    public boolean configuraEndereco(String cep, ItfLocal pLocal) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }

    @Override
    public List<String> cepsPorEndereco(String pEndereco) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }

    @Override
    public boolean isCepExiste(String pCep) {

        try {
            objcep = UtilSBCoreClienteRest.getObjetoJsonPorUrl("https://api.postmon.com.br/v1/cep/" + pCep);

            return true;

        } catch (Throwable e) {

            return false;
        }

    }

    @Override
    public boolean configurarPosicaoGeogafica(ItfLocal pLocal) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }

    @Override
    public boolean contribuirCadastroNovoEndereco(ItfLocal pLocal) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }

    @Override
    public InfoRespostaCepWebService getInfoRespostaWebService(String cep) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }

}
