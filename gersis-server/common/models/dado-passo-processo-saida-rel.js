'use strict';

module.exports = function(Dadopassoprocessosaidarel) {

    Dadopassoprocessosaidarel.AtualizaPorPassoProcessoSaida = function (idPassoProcesso, lista, callback) {
        console.log(lista);
        var sqlDelete = "delete from DadoPassoProcessoSaidaRel where passoProcessoJavaId = " + idPassoProcesso;

        var ds = Dadopassoprocessosaidarel.dataSource;
        ds.connector.query(sqlDelete, (err1, result1) => {
        if (err1) {
            callback(err1, null);
            return;
        }
        let conta = 0;
        lista.forEach((rel) => {
            Dadopassoprocessosaidarel.create(rel);
            conta++;
            if (conta==lista.length) {
                callback(null, { 'result': 'ok' });
            }
        });
        });
    };
};
