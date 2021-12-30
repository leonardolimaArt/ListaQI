//ListaQI - Implementação das Interfaces
//Aluno: Leonardo Henrique Lima de Souza

package emp_sess;

import login_sess.getset_form_emp;
import login_sess.login_principal;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

public class emp_principal extends JFrame implements ActionListener {

    public Container emp_principal_session = getContentPane();
    JButton MeuPerfil_b, MeusProdutos_b, Logout_b;

    JPanel emp_perfil = new JPanel();
    emp_perfil emp_perfil_obj;

    JPanel emp_produtos = new JPanel();
    emp_produtos emp_produtos_obj;

    login_principal login_principal_obj;

    public emp_principal(login_principal login, getset_form_emp usr){

        this.login_principal_obj = login;

        setTitle("ListaQI - Empresa: "+usr.getNome_emp());
        //setTitle("");
        setLayout(null);
        setResizable(false);
        setUndecorated(false);
        setBounds(225, 100, 924, 520);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        emp_principal_session.setBackground(new Color(44,44,44));
        setVisible(false);

        ImageIcon iconeLabel = new ImageIcon("src/imgs/icone.png");
        setIconImage(iconeLabel.getImage());

        emp_perfil_obj = new emp_perfil(emp_perfil, usr);
        emp_produtos_obj = new emp_produtos(emp_produtos, usr);

        MeuPerfil_b = new JButton("Meu Perfil");
        MeuPerfil_b.addActionListener(this);
        MeuPerfil_b.setFocusPainted(false);
        MeuPerfil_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        MeuPerfil_b.setBackground(Color.white);
        MeuPerfil_b.setForeground(new Color(84,186,255));
        MeuPerfil_b.setBounds(8,0,170,28);

        MeusProdutos_b = new JButton("Meus Produtos");
        MeusProdutos_b.addActionListener(this);
        MeusProdutos_b.setFocusPainted(false);
        MeusProdutos_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        MeusProdutos_b.setBackground(new Color(44,44,44));
        MeusProdutos_b.setForeground(Color.white);
        MeusProdutos_b.setBounds(187,0,170,28);

        Logout_b = new JButton("Logout");
        Logout_b.addActionListener(this);
        Logout_b.setFocusPainted(false);
        Logout_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Logout_b.setBackground(new Color(44,44,44));
        Logout_b.setForeground(Color.white);
        Logout_b.setBounds(745,0,170,28);

        emp_principal_session.add(MeuPerfil_b);
        emp_principal_session.add(MeusProdutos_b);
        emp_principal_session.add(Logout_b);
        emp_principal_session.add(emp_perfil);
        emp_principal_session.add(emp_produtos);
        emp_principal_session.setVisible(true);

        revalidate();
        repaint();
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == MeuPerfil_b) {
            MeuPerfil_b.setBackground(Color.white);
            MeuPerfil_b.setForeground(new Color(84,186,255));
            MeusProdutos_b.setBackground(new Color(44,44,44));
            MeusProdutos_b.setForeground(Color.white);
            emp_perfil.setVisible(true);
            emp_produtos.setVisible(false);
        }
        if (e.getSource() == MeusProdutos_b) {
            MeuPerfil_b.setBackground(new Color(44, 44, 44));
            MeuPerfil_b.setForeground(Color.white);
            MeusProdutos_b.setBackground(Color.white);
            MeusProdutos_b.setForeground(new Color(84,186,255));
            emp_perfil.setVisible(false);
            emp_produtos.setVisible(true);
        }
        if (e.getSource() == Logout_b) {
            login_principal_obj.setLocation(450,200);
            login_principal_obj.setVisible(true);
            dispose();
        }
    }
}

