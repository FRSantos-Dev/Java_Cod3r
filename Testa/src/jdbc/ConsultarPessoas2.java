package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

    public static void main(String[] args) throws SQLException {// SQLException = "exceção de SQL"
        Scanner sc = new Scanner(System.in);

        Connection conexao = FabricaConexao.getConexao();// FabricaConexao is a class from Testa\src\jdbc\FabricaConexao.java
        String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";// LIKE = "parecido com"

        System.out.println("Informe o valor dapesquisa: ");
        String valor = sc.nextLine();// nextLine = "próxima linha"

        PreparedStatement stmt = conexao.prepareStatement(sql);// PreparedStatement = "declaração preparada"
        stmt.setString(1, "%" + valor + "%");//informei um valor
        ResultSet resultado = stmt.executeQuery();// ResultSet = "conjunto de resultados" //pesquisei pelo valor

        List<Pessoa> pessoas = new ArrayList<>();//Obtive a lista das pessoas

        while (resultado.next()) {// next = "próximo"
            int codigo = resultado.getInt("codigo");// getInt = "obter inteiro"
            String nome = resultado.getString("nome");// getString = "obter string"
            pessoas.add(new Pessoa(codigo, nome));// add = "adicionar"
        }

        for (Pessoa p : pessoas) {// Pessoa = "pessoa" // : = "para"
            System.out.println(p.getCodigo() + " ==> " + p.getNome());//mostrei o valor pesquisado
        }

        stmt.close();
        conexao.close();
        sc.close();

    }
}
