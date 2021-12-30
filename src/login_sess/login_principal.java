//ListaQI - Implementação das Interfaces
//Aluno: Leonardo Henrique Lima de Souza

package login_sess;

import javax.swing.*;
import java.awt.*;

public class login_principal extends JFrame{
    public Container login_principal_session = getContentPane();

    /*------------------login_menu--------------------*/
    public JPanel area_menu = new JPanel(), login_cliente = new JPanel(), login_empresa = new JPanel();
    login_menu login_menu_obj;

    /*------------------cadastro_form--------------------*/
    public JPanel cadastro_empresa = new JPanel(), cadastro_cliente = new JPanel();
    cadastro_form cadastro_empresa_obj;

    /*------------------recup_senha--------------------*/
    public JPanel recuperar_senha = new JPanel(), verif_codigo = new JPanel();
    recup_senha recup_senha_obj;

    /*------------------alter_senha--------------------*/
    public JPanel alter_senha = new JPanel(), confirm_senha = new JPanel();
    alter_senha alter_senha_obj;

    public login_principal() {

        setTitle("");
        setLayout(null);
        setResizable(false);
        setUndecorated(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(450, 200, 420, 420);
        setVisible(true);

        ImageIcon iconeLabel = new ImageIcon("src/imgs/icone.png");
        setIconImage(iconeLabel.getImage());

        login_menu_obj = new login_menu(area_menu, login_empresa, login_cliente, cadastro_empresa, cadastro_cliente, recuperar_senha, this);
        cadastro_empresa_obj = new cadastro_form(cadastro_empresa, cadastro_cliente, login_empresa, login_cliente, this);
        recup_senha_obj = new recup_senha(login_empresa, login_cliente, recuperar_senha, verif_codigo, area_menu, alter_senha);
        alter_senha_obj = new alter_senha(alter_senha, confirm_senha, area_menu);

        login_principal_session.add(alter_senha);
        login_principal_session.add(confirm_senha);

        login_principal_session.add(recuperar_senha);
        login_principal_session.add(verif_codigo);

        login_principal_session.add(cadastro_empresa);
        login_principal_session.add(cadastro_cliente);

        login_principal_session.add(area_menu);
        login_principal_session.add(login_empresa);
        login_principal_session.add(login_cliente);

        revalidate();
        repaint();

    }
    public static void main(String[] args) {
        login_principal usr_session = new login_principal();
        usr_session.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
