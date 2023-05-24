'use strict';

module.exports = function(Processojava) {


    Processojava.ListaEntidadeDisponivel = function(idProcesso, callback) {
        let ds = Processojava.dataSource;
        let sql = "select * from " +
            " ( " +
            " select Entidade.* from Entidade " +
            " inner join ProcessoEntidadeEntradaRel on Entidade.id = ProcessoEntidadeEntradaRel.entidadeId " +
            " where ProcessoEntidadeEntradaRel.processoJavaId = "  + idProcesso +
            " union "  +
            " select Entidade.*  from Entidade " +
            " inner join ProcessoEntidadeSaidaRel on Entidade.id = ProcessoEntidadeSaidaRel.entidadeId " +
            " where ProcessoEntidadeSaidaRel.processoJavaId = "  + idProcesso +
            " ) as tab " +
            " order by nome"
        ds.connector.query(sql,callback);
    }


};
