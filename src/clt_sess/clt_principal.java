//ListaQI - Implementação das Interfaces
//Aluno: Leonardo Henrique Lima de Souza

package clt_sess;

import login_sess.getset_form_clt;
import login_sess.getset_form_emp;
import login_sess.login_principal;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

public class clt_principal extends JFrame implements ActionListener {

    public Container clt_principal_session = getContentPane();

    JButton MeuPerfil_b, MeusProdutos_b, Logout_b;

    JPanel clt_perfil = new JPanel();
    clt_perfil clt_perfil_obj;

    JPanel clt_produtos = new JPanel(), clt_edt_produ = new JPanel(), clt_nv_produ = new JPanel();
    clt_produtos clt_produtos_obj;

    login_principal login_principal_obj;
    final JFrame CadOK = new JFrame();
    public clt_principal(login_principal login, getset_form_clt usr){

        this.login_principal_obj = login;

        setTitle("");
        setLayout(null);
        setResizable(false);
        setUndecorated(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(225, 100, 924, 520);
        clt_principal_session.setBackground(new Color(44,44,44));
        setVisible(false);

        ImageIcon iconeLabel = new ImageIcon("src/imgs/icone.png");
        setIconImage(iconeLabel.getImage());

        clt_perfil_obj = new clt_perfil(clt_perfil, usr);
        clt_produtos_obj = new clt_produtos(clt_produtos, clt_edt_produ, clt_nv_produ, usr);

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

        clt_principal_session.add(MeuPerfil_b);
        clt_principal_session.add(MeusProdutos_b);
        clt_principal_session.add(Logout_b);
        clt_principal_session.add(clt_perfil);

        clt_principal_session.add(clt_produtos);
        clt_principal_session.add(clt_edt_produ);
        clt_principal_session.add(clt_nv_produ);
        clt_principal_session.setVisible(true);

        revalidate();
        repaint();
        JOptionPane.showMessageDialog(CadOK,"O módulo Cliente está em construção, algumas funcionalidades estão indisponíveis ou não funcionam corretamente.", "Atenção", JOptionPane.WARNING_MESSAGE);
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == MeuPerfil_b) {
            MeuPerfil_b.setBackground(Color.white);
            MeuPerfil_b.setForeground(new Color(84,186,255));
            MeusProdutos_b.setBackground(new Color(44,44,44));
            MeusProdutos_b.setForeground(Color.white);
            clt_produtos.setVisible(false);
            clt_edt_produ.setVisible(false);
            clt_nv_produ.setVisible(false);
            clt_perfil.setVisible(true);
        }
        if (e.getSource() == MeusProdutos_b) {
            MeuPerfil_b.setBackground(new Color(44, 44, 44));
            MeuPerfil_b.setForeground(Color.white);
            MeusProdutos_b.setBackground(Color.white);
            MeusProdutos_b.setForeground(new Color(84,186,255));
            clt_perfil.setVisible(false);
            clt_edt_produ.setVisible(false);
            clt_nv_produ.setVisible(false);
            clt_produtos.setVisible(true);
        }
        if (e.getSource() == Logout_b) {
            login_principal_obj.setLocation(450,200);
            login_principal_obj.setVisible(true);
            dispose();
        }
    }
}

