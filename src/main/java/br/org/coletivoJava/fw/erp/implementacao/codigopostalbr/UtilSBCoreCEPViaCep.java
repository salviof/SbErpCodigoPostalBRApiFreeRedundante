/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.fw.erp.implementacao.codigopostalbr;

import br.org.coletivoJava.fw.api.erp.codigopostalbr.InfoRespostaCepWebService;
import br.org.coletivoJava.fw.api.erp.codigopostalbr.UtilSbCoreCepAbs;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreClienteRest;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreStringValidador;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.cep.ItfLocal;
import org.json.simple.JSONObject;

/**
 *
 * @author desenvolvedorninja01
 * @since 21/10/2019
 * @version 1.0
 */
public class UtilSBCoreCEPViaCep extends UtilSbCoreCepAbs {

    /**
     *
     * Configura rua, cidade, estado, nome do local, a partir de um CEP
     *
     * @param cep cep utilizado em uma pesquisa
     * @param pLocal O local onde o endereço será configurado
     * @return True se encontrar o CEP, false se não encontrar
     */
    public static boolean configuraEndereco(String cep, ItfLocal pLocal) {

        if (UtilSBCoreStringValidador.isNuloOuEmbranco(cep)) {
            return false;
        }
        if (!cep.replace("-", "").matches("\\d{8}")) {
            return false;
        }
        cep = cep.replace("-", "");
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        try {
            JSONObject resposta = UtilSBCoreClienteRest.getObjetoJsonPorUrl(url);

            System.out.println(resposta.toJSONString());
            if (resposta.get("erro") != null) {
                boolean erro = (boolean) resposta.get("erro");
                if (erro) {
                    return false;
                }
            }
            String uf = (String) resposta.get("uf");
            String logradouro = (String) resposta.get("logradouro");
            String bairro = (String) resposta.get("bairro");
            String cidade = (String) resposta.get("localidade");
            InfoRespostaCepWebService resp = new InfoRespostaCepWebService(uf, cidade, bairro, logradouro);
            return resp.applicarDados(pLocal);
        } catch (Throwable t) {
            return false;
        }

    }

    public static boolean cepExiste(String cep) {
        if (UtilSBCoreStringValidador.isNuloOuEmbranco(cep)) {
            return false;
        }
        if (!cep.replace("-", "").matches("\\d{8}")) {
            return false;
        }
        cep = cep.replace("-", "");
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        try {
            JSONObject resposta = UtilSBCoreClienteRest.getObjetoJsonPorUrl(url);
            System.out.println(resposta.toJSONString());
            if (resposta.get("erro") == null) {
                return true;
            }
            boolean erro = (boolean) resposta.get("erro");
            return !erro;
        } catch (Throwable t) {
            return false;
        }
    }

}
