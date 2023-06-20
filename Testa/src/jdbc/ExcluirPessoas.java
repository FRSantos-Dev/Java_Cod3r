package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoas {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o código: ");
        int codigo = sc.nextInt();

        Connection conexao = FabricaConexao.getConexao();
        String delete = " DELETE FROM pessoas Where codigo = ?";

        PreparedStatement stmt = conexao.prepareStatement(delete);
        stmt.setInt(1, codigo);

        int contador = stmt.executeUpdate();

        if (contador > 0){
            System.out.println("Pessoa excluída com sucesso!");
        } else {
            System.out.println("Não houve exclusão!");
        }

        System.out.println("Linhas afetas: " + contador);

        conexao.close();
        sc.close();

    }
}
