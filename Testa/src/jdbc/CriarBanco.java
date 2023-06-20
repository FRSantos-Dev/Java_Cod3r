package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco{
    public static void main(String[] args) throws SQLException {

        //final String url = "jdbc:postgresql://CNL-3D114-009.condornaoletal.com.br/atomic";
        //final String usuario = "postgres";
        //final String senha = "admin";

        //Connection conexao = DriverManager.getConnection(url, usuario, senha);
        Connection conexao = FabricaConexao.getConexao();

        System.out.println("Conexão efetuada com sucesso!");

        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE curso_java");

        System.out.println("Banco Criado com sucesso!");
        conexao.close();
    }
}