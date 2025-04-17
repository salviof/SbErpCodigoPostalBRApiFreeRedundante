/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.fw.erp.implementacao.codigopostalbr.pepino.postMan;

import br.org.coletivoJava.fw.api.erp.codigopostalbr.InfoRespostaCepWebService;
import br.org.coletivoJava.fw.erp.implementacao.codigopostalbr.CodigoPostalBRApiPostMon;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreClienteRest;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import jakarta.json.JsonObject;
import java.io.Serializable;
import testesFW.ConfigCoreJunitPadraoDevLib;

/**
 *
 * @author desenvolvedorninja01
 * @since 23/10/2019
 * @version 1.0
 */
public class EtapasPostMan extends org.junit.Assert implements Serializable {

    private String numeroCep;
    private JsonObject objcep;
    private InfoRespostaCepWebService infoRespostaCepWebService;
    private CodigoPostalBRApiPostMon codigoPostalBRApiPostMon;
    private String bairro, cidade, estado, logradouro;
    private Boolean resultadoCepExistePositivo, resultadoCepExisteNegativo;

    @Dado("O cep 32667380")
    public void cenarioSemCampanha() {
        SBCore.configurar(new ConfigCoreJunitPadraoDevLib(), SBCore.ESTADO_APP.PRODUCAO);
        numeroCep = "32667380";
        // assertTrue("Eseperava um retorno tre", false);
    }

    @Quando("Consulta o webservice postman utilizando https://api.postmon.com.br/v1/cep/")
    public void criarumaCampanha() {

        objcep = UtilSBCoreClienteRest.getObjetoJsonPorUrl("https://api.postmon.com.br/v1/cep/" + numeroCep);
        bairro = objcep.getString("bairro");
        cidade = objcep.getString("cidade");
        estado = objcep.getString("estado");
        logradouro = objcep.getString("logradouro");

    }

    @E("gera um objeto InfoRespostaCepWebService utilizando o retorno do webservice")
    public void retornoObjeto() {

        infoRespostaCepWebService = new InfoRespostaCepWebService(estado, cidade, bairro, logradouro);

    }

    @Entao("o objeto InfoRespostaCepWebService é configurado com o endereço correto")
    public void validarValores() {

        assertEquals("Rua retornada incorreta", infoRespostaCepWebService.getLogadouroStr(), "Avenida Rio Madeira");

    }

    @Dado("Uma Classe implmentando ItfCodigoPostalBR instanciada")
    public void istanciarCodigoPostalPostMon() {

        codigoPostalBRApiPostMon = new CodigoPostalBRApiPostMon();
    }

    @Quando("o cep 32667380 e utilizado como parametro no método isCepExiste")
    public void verificaCepExiste() {

        resultadoCepExistePositivo = codigoPostalBRApiPostMon.isCepExiste("32667380");
    }

    @Entao("o retorno do método é igual a  true")
    public void retornoCepExiste() {

        assertTrue("O resultado CepExiste retornou negativo", resultadoCepExistePositivo);
    }

    @Quando("o cep 30999999 é utilizado como parametro no método isCepExiste")
    public void verificaCepNaoExiste() {

        resultadoCepExisteNegativo = codigoPostalBRApiPostMon.isCepExiste("30999999");

    }

    @Entao("o retorno do método é igual a  false")
    public void retornoCepNaoExiste() {
        assertFalse("O resultado CepExiste retornou negativo", resultadoCepExisteNegativo);
    }

}
