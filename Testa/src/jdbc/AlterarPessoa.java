package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarPessoa {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o código da pessoa: ");
        int codigo = sc.nextInt();

        String select = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
        String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(select);//criando um statement
        stmt.setInt(1, codigo);//informei um valor para o código
        ResultSet r = stmt.executeQuery();//pesquisei pelo código // ResultSet = "conjunto de resultados"

        if (r.next()){// next = "próximo"
            Pessoa p = new Pessoa(r.getInt(1), r.getString(2));// getInt = "obter inteiro" // getString = "obter string"

            System.out.println("O nome atual é: " + p.getNome());
            sc.nextLine();

            System.out.println("Informe o novo nome: ");
            String novoNome = sc.nextLine();

            stmt.close();//fechando statement anterior
            stmt = conexao.prepareStatement(update);//criando statement
            stmt.setString(1, novoNome);//informei um novo valor para o nome
            stmt.setInt(2, codigo);//informei um valor para o código
            stmt.execute();//executei o statement

            System.out.println("Pessoa alterada com sucesso!");
        } else {
            System.out.println("Não existe pessoa com este código!");
        }

            conexao.close();
            sc.close();
        }

    }

