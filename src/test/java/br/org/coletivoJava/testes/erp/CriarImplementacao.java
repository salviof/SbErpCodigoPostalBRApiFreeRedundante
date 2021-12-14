/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivoJava.fw.api.erp.codigoPostal.br.ERPCodigoPostalBR;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.apache.logging.log4j.LogManager;
import org.coletivojava.fw.api.objetoNativo.log.LogPadraoSB;
import org.junit.Test;
import testes.geradorCodigo.erp.GeradorERPImplementacaoContexto;

/**
 *
 * @author desenvolvedor
 */
public class CriarImplementacao {

    @Test
    public void criarImplementaca() {

        try {
            SBCore.configurar(new ConfigCoreApiErpCodigoPostal(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
            new GeradorERPImplementacaoContexto(ERPCodigoPostalBR.API_FREE_REDUNTANTE).salvarEmDiretorioPadraCASO_NAO_EXISTA();
        } catch (Throwable t) {
            LogManager.getLogger(LogPadraoSB.class).error("Erro Criando anotações", t);
        }
    }

}
