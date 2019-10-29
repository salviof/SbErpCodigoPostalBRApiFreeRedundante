# language: pt
@CepPostMan
Funcionalidade: Testar o Cep Postman
  1) Conectar com o servidor postMan via https://api.postmon.com.br/v1/cep/[numeroCep]
  2) Configurar objeto de resposta
  3) implementar interface ItfCodigoPostalBR para postman

  Contexto: Ingração da api com o postman

  Cenario: TesteBasicoConsultaPostMon
    Dado O cep 32667380
    Quando Consulta o webservice postman utilizando https://api.postmon.com.br/v1/cep/
    E gera um objeto InfoRespostaCepWebService utilizando o retorno do webservice
    Então o objeto InfoRespostaCepWebService é configurado com o endereço correto
    Dado Uma Classe implmentando ItfCodigoPostalBR instanciada
    Quando o cep 32667380 e utilizado como parametro no método isCepExiste
    Então o retorno do método é igual a  true
    Quando o cep 30999999 é utilizado como parametro no método isCepExiste
    Então o retorno do método é igual a  false
    Quando o cep 32667380 é utilizado como parametro no método getInfoRespostaWebService
    Então Um objeto InfoRespostaWebService é gerado utilizando ItfCodigoPostalBR com todos os campos configurados uf cidade bairro e logradouro
