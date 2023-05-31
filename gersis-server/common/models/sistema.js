'use strict';

module.exports = function(Sistema) {

    Sistema.ObtemParaGerarJava = function(idSistema,callback) {
        let filtro = {
            'where' : {'id' : idSistema},
            'include' : [   
                { 'relation' : 'entidades' , 'scope' : {
                    'include' : ['atributoEntidades']
                }},
                { 'relation' : 'processoJavas' , 'scope' : {
                    'include' : ['passoProcessoJavas']
                }}
            ]
        }
        Sistema.findOne(filtro,callback);
    }
};
