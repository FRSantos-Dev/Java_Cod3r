package jdbc;

public class DAOTeste {

    public static void main(String[] args) {

        DAO dao = new DAO();

        String insert = "INSERT INTO pessoas (nome) VALUES (?)";
        System.out.println(dao.incluir(insert, "João"));
        System.out.println(dao.incluir(insert, "Maria"));
        System.out.println(dao.incluir(insert, "José"));

        dao.close();
    }
}
