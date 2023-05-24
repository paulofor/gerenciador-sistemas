'use strict';

module.exports = function(Passoprocessojava) {


    Passoprocessojava.SobeItem = function(idPasso, callback) {
        let ds = Passoprocessojava.dataSource;
        Passoprocessojava.findById(idPasso, (err,result) => {
            let sql = "update PassoProcessoJava set ordenacao = ordenacao - 1 where ordenacao = " + (result.ordenacao + 1)  +
                "  and processoJavaId = " + result.processoJavaId;
            ds.connector.query(sql, (err,result) => {
             let sql2 = "update PassoProcessoJava set ordenacao = ordenacao + 1 where id = " + idPasso;
             ds.connector.query(sql2,callback);
            })
         })
    }

    Passoprocessojava.DesceItem = function(idPasso, callback) {
        let ds = Passoprocessojava.dataSource;
        Passoprocessojava.findById(idPasso, (err,result) => {
            let sql = "update PassoProcessoJava set ordenacao = ordenacao + 1 where ordenacao = " + (result.ordenacao - 1) +
                "  and processoJavaId = " + result.processoJavaId;
            ds.connector.query(sql, (err,result) => {
            let sql2 = "update PassoProcessoJava set ordenacao = ordenacao - 1 where id = " + idPasso;
            ds.connector.query(sql2,callback);
           })
        })
    }
};
