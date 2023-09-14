'use strict';

module.exports = function(Pythonmetodosaida) {

    Pythonmetodosaida.AtualizaPorProcessoSaida = function (idProcesso, lista, callback) {
        //var sqlQuantidade = "update GrupoAcao " +
        //" set quantidade = (select count(*) from RelGrupoAcao where GrupoAcao.id = RelGrupoAcao.grupoAcaoId) ";
        //console.log(lista);
        var sqlDelete = "delete from PythonMetodoSaida where processoPythonId = " + idProcesso;

        var ds = Pythonmetodosaida.dataSource;
        ds.connector.query(sqlDelete, (err1, result1) => {
        //console.log('Retorno 1: ', result1, " - Erro: ",)
        if (err1) {
            callback(err1, null);
            return;
        }
        let conta = 0;
        lista.forEach((rel) => {
            Pythonmetodosaida.create(rel);
            conta++;
            if (conta==lista.length) {
                callback(null, { 'result': 'ok' });
            }
        });
        });
    }
};
