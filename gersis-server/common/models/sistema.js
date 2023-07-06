'use strict';

module.exports = function(Sistema) {


    Sistema.ObtemParaGerarNode = function(idSistema, callback) {
        Sistema.ObtemParaGerarJava(idSistema,callback);
    }

    Sistema.ObtemParaGerarJava = function(idSistema,callback) {
        let filtro = {
            'where' : {'id' : idSistema},
            'include' : [   
                { 'relation' : 'entidades' , 'scope' : {
                    'include' : [
                        'atributoEntidades' , 
                        { 'relation' : 'relacionamentos1' , 'scope' : {'include' : 'entidade1'}}, 
                        { 'relation' : 'relacionamentosN' , 'scope' : {'include' : 'entidadeN'}},
                        { 'relation' : 'metodoServers' , 'scope' : {'include' : [
                            {'relation' : 'parametroMetodoServers', 'scope' : {'order' : 'posicao'} }
                        ]}}
                    ]
                }},
                { 'relation' : 'processoJavas' , 'scope' : {
                    'include' : [
                        { 'relation' : 'passoProcessoJavas' , 'scope' : {'include' : [
                            { 'relation' : 'metodoServer' , 'scope' : {'include':['entidade',{'relation' : 'parametroMetodoServers', 'scope' : {'order' : 'posicao'} }]}},
                            { 'relation' : 'dadoPassoEntrada' , 'scope' : 
                                {'include':{'relation' : 'dadoProcesso' , 'scope' : {'include' : 'tipoEntidade'}} }},
                            { 'relation' : 'dadoPassoSaida' , 'scope' : 
                                {'include':{'relation':'dadoProcesso' , 'scope' : {'include' : 'tipoEntidade'}} }}
                        ]}}, 
                        { 'relation' : 'dadoProcessos' , 'scope' : {'include' : 'tipoEntidade'}}
                    ]
                }}
            ]
        }
        Sistema.findOne(filtro,callback);
    }
};
