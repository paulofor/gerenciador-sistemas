'use strict';

module.exports = function(Dadopassoprocessoentradarel) {

    Dadopassoprocessoentradarel.AtualizaPorPassoProcesso = function (idPassoProcesso, lista, callback) {
        var sqlDelete = "delete from DadoPassoProcessoEntradaRel where passoProcessoJavaId = " + idPassoProcesso;

        var ds = Dadopassoprocessoentradarel.dataSource;
        ds.connector.query(sqlDelete, (err1, result1) => {
        if (err1) {
            callback(err1, null);
            return;
        }
        let conta = 0;
        lista.forEach((rel) => {
            Dadopassoprocessoentradarel.create(rel);
            conta++;
            if (conta==lista.length) {
                callback(null, { 'result': 'ok' });
            }
        });
        });
    };
};
