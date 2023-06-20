package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexão{
    public static void main(String[] args) throws SQLException {
        
        final String url = "jdbc:postgresql://CNL-3D114-009.condornaoletal.com.br/curso_java";
        final String usuario = "postgres";
        final String senha = "admin";

        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        System.out.println("Conexão efetuada com sucesso!");


        conexao.close();
    }
}