package factory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionFactory {
    //nome do usuario
    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/lista-qi";

    public static Connection createConnectionToMySQL() throws Exception{

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Conexao realizada com sucesso!");
            return connection;
        }catch (Exception e){
            e.printStackTrace();
            final JFrame CadOK = new JFrame();
            JOptionPane.showMessageDialog(CadOK,"Leonardo, o banco de dados está desconectado!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        Connection con = createConnectionToMySQL();

        if(con != null){
            con.close();
        }
    }
}