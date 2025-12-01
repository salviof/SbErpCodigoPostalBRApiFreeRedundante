package br.org.coletivoJava.fw.erp.implementacao.codigopostalbr;

import br.org.coletivoJava.fw.api.erp.codigoPostal.br.ItfCodigoPostalBR;
import java.util.List;
import br.org.coletivoJava.fw.api.erp.codigopostalbr.CodigoPostalBRApiFreeReduntante;
import br.org.coletivoJava.fw.api.erp.codigopostalbr.InfoRespostaCepWebService;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.cep.ComoLocal;
import javax.inject.Inject;

@CodigoPostalBRApiFreeReduntante
public class CodigoPostalBRApiFreeReduntanteimpl implements ItfCodigoPostalBR {

    @Inject
    private ItfCodigoPostalBR teste;

    @Override
    public boolean isCepExiste(String s) {
        if (UtilCRCCEPViaCep.cepExiste(s)) {
            return true;
        } else {
            return UtilCRCCEPRepublicaVirtual.cepExiste(s);
        }
    }

    @Override
    public List cepsPorEndereco(java.lang.String s) {
        return null;
    }

    @Override
    public boolean configuraEndereco(String s, ComoLocal itfLocal) {
        if (!UtilCRCCEPViaCep.configuraEndereco(s, itfLocal)) {

            return UtilCRCCEPRepublicaVirtual.configuraEndereco(s, itfLocal);
        } else {
            return true;
        }
    }

    @Override
    public boolean configurarPosicaoGeogafica(ComoLocal itfLocal) {
        return false;
    }

    @Override
    public boolean contribuirCadastroNovoEndereco(
            com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.cep.ComoLocal itfLocal) {
        return false;
    }

    @Override
    public InfoRespostaCepWebService getInfoRespostaWebService(String cep) {
        throw new UnsupportedOperationException("O METODO AINDA N\u00c3O FOI IMPLEMENTADO.");
    }
}
