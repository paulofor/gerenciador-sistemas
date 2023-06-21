'use strict';

module.exports = function(Sistema) {

    Sistema.ObtemParaGerarJava = function(idSistema,callback) {
        let filtro = {
            'where' : {'id' : idSistema},
            'include' : [   
                { 'relation' : 'entidades' , 'scope' : {
                    'include' : [
                        'atributoEntidades' , 
                        { 'relation' : 'relacionamentos1' , 'scope' : {'include' : 'entidade1'}}, 
                        { 'relation' : 'relacionamentosN' , 'scope' : {'include' : 'entidadeN'}},
                        { 'relation' : 'metodoServers' , 'scope' : {'include' : ['parametroMetodoServers']}}
                    ]
                }},
                { 'relation' : 'processoJavas' , 'scope' : {
                    'include' : [
                        { 'relation' : 'passoProcessoJavas' , 'scope' : {'include' : [
                            { 'relation' : 'metodoServer' , 'scope' : {'include':'entidade'}},
                            { 'relation' : 'dadoPassoEntrada' , 'scope' : {'include':'dadoProcesso'}},
                            { 'relation' : 'dadoPassoSaida' , 'scope' : {'include':'dadoProcesso'}}
                        ]}}, 
                        { 'relation' : 'dadoProcessos' , 'scope' : {'include' : 'tipoEntidade'}}
                    ]
                }}
            ]
        }
        Sistema.findOne(filtro,callback);
    }
};
