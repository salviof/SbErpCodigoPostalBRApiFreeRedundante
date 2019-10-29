package br.org.coletivoJava.fw.erp.implementacao.codigopostalbr;

import br.org.coletivoJava.fw.api.erp.codigoPostal.br.ItfCodigoPostalBR;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.cep.ItfLocal;
import br.org.coletivoJava.fw.api.erp.codigopostalbr.CodigoPostalBRApiFreeReduntante;
import br.org.coletivoJava.fw.api.erp.codigopostalbr.InfoRespostaCepWebService;
import javax.inject.Inject;

@CodigoPostalBRApiFreeReduntante
public class CodigoPostalBRApiFreeReduntanteimpl implements ItfCodigoPostalBR {

    @Inject
    private ItfCodigoPostalBR teste;

    @Override
    public boolean isCepExiste(String s) {
        return UtilSBCoreCEPViaCep.cepExiste(s);
    }

    @Override
    public List cepsPorEndereco(java.lang.String s) {
        return null;
    }

    @Override
    public boolean configuraEndereco(String s, ItfLocal itfLocal) {
        if (!UtilSBCoreCEPViaCep.configuraEndereco(s, itfLocal)) {

            return UtilSBCoreCEPRepublicaVirtual.configuraEndereco(s, itfLocal);
        } else {
            return true;
        }
    }

    @Override
    public boolean configurarPosicaoGeogafica(ItfLocal itfLocal) {
        return false;
    }

    @Override
    public boolean contribuirCadastroNovoEndereco(
            com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.cep.ItfLocal itfLocal) {
        return false;
    }

    @Override
    public InfoRespostaCepWebService getInfoRespostaWebService(String cep) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }
}
