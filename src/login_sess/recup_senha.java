package login_sess;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

public class recup_senha extends JFrame implements ActionListener {
    /*------------------prox--------------------*/
    public JPanel alter_senha;

    /*------------------voltar--------------------*/
    public JPanel login_empresa, login_cliente, area_menu;

    /*------------------verif_codigo--------------------*/
    public JButton VoltarVC_b, ProxVC_b;
    public JPanel verif_codigo;

    /*------------------recup_senha--------------------*/
    public JButton VoltarRS_b, ProxRS_b;
    public JPanel recuperar_senha;

    public recup_senha(JPanel login_empresa, JPanel login_cliente, JPanel recuperar_senha_g, JPanel verif_codigo_g, JPanel area_menu_g, JPanel alter_senha_g) {
        this.recuperar_senha = recuperar_senha_g;
        this.verif_codigo = verif_codigo_g;
        this.login_empresa = login_empresa;
        this.login_cliente = login_cliente;
        this.area_menu = area_menu_g;
        this.alter_senha = alter_senha_g;

        /*------------------recup_senha--------------------*/
        recuperar_senha.setLayout(null);
        recuperar_senha.setBounds(0,0,420,420);
        recuperar_senha.setVisible(false);

        JLabel texto_0 = new JLabel("Esqueci a Senha");
        texto_0.setBounds(125, 30, 300, 40);
        texto_0.setForeground(new Color(0, 153, 255));
        texto_0.setFont(new Font("Arial", Font.BOLD, 19));
        recuperar_senha.add(texto_0);

        JLabel texto_1 = new JLabel("Esqueci a Senha");
        texto_1.setBounds(126, 31, 300, 40);
        texto_1.setForeground(new Color(0, 0, 0,64));
        texto_1.setFont(new Font("Arial", Font.BOLD, 19));
        recuperar_senha.add(texto_1);

        JLabel texto_2 = new JLabel("Por favor, preencha os campos abaixo.");
        texto_2.setBounds(110, 45, 200, 40);
        texto_2.setForeground(Color.darkGray);
        texto_2.setFont(new Font("Arial", Font.PLAIN, 10));
        recuperar_senha.add(texto_2);

        JLabel texto_3 = new JLabel("EMAIL CADASTRADO");
        texto_3.setBounds(100, 130, 150, 40);
        texto_3.setForeground(Color.darkGray);
        texto_3.setFont(new Font("Arial", Font.BOLD, 14));
        recuperar_senha.add(texto_3);

        JTextField field_0 = new JTextField(17);
        field_0.setBorder(new MatteBorder(1,1,1,1,Color.darkGray));
        recuperar_senha.add(field_0);
        field_0.setBounds(100,160,210,25);

        String texto_4 = "<html><div style='text-align: center;'>Você receberá um email com um código de autenticação<br>para alterar sua senha.</div></html>";
        JLabel texto_4_1 = new JLabel();
        texto_4_1.setText (texto_4);
        texto_4_1.setBounds(65, 185, 300, 40);
        texto_4_1.setForeground(Color.darkGray);
        texto_4_1.setFont(new Font("Arial", Font.PLAIN, 10));
        recuperar_senha.add(texto_4_1);

        VoltarRS_b = new JButton("VOLTAR");
        recuperar_senha.add(VoltarRS_b);
        VoltarRS_b.addActionListener(this);
        VoltarRS_b.setFocusPainted(false);
        VoltarRS_b.setBackground(new Color(84, 186, 255));
        VoltarRS_b.setForeground(Color.white);
        VoltarRS_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        VoltarRS_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        VoltarRS_b.setBounds(10, 330, 100, 40);

        ProxRS_b = new JButton("PRÓXIMO");
        recuperar_senha.add(ProxRS_b);
        ProxRS_b.addActionListener(this);
        ProxRS_b.setFocusPainted(false);
        ProxRS_b.setBackground(new Color(255, 118, 118));
        ProxRS_b.setForeground(Color.white);
        ProxRS_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        ProxRS_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        ProxRS_b.setBounds(295, 330, 100, 40);

        ImageIcon imageBackIcon_0 = new ImageIcon("src/imgs/cadRecup.png");
        Image imageBackIMG_0 = imageBackIcon_0.getImage();
        Image newImgBack_0 = imageBackIMG_0.getScaledInstance(recuperar_senha.getWidth(), recuperar_senha.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageBackIcon_0 = new ImageIcon(newImgBack_0);

        JLabel backIMGLabel_0 = new JLabel("");
        backIMGLabel_0.setIcon(imageBackIcon_0);
        backIMGLabel_0.setBounds(0, 0, recuperar_senha.getWidth(), recuperar_senha.getHeight());
        recuperar_senha.add(backIMGLabel_0);
        backIMGLabel_0.setVisible(true);

        /*------------------verif_codigo--------------------*/
        verif_codigo.setLayout(null);
        verif_codigo.setBounds(0,0,420,420);
        verif_codigo.setVisible(false);

        JLabel texto_5 = new JLabel("Código de verificação");
        texto_5.setBounds(100, 30, 300, 40);
        texto_5.setForeground(new Color(0, 153, 255));
        texto_5.setFont(new Font("Arial", Font.BOLD, 19));
        verif_codigo.add(texto_5);

        JLabel texto_6 = new JLabel("Código de verificação");
        texto_6.setBounds(101, 31, 300, 40);
        texto_6.setForeground(new Color(0, 0, 0,64));
        texto_6.setFont(new Font("Arial", Font.BOLD, 19));
        verif_codigo.add(texto_6);

        JLabel texto_7 = new JLabel("Por favor, preencha os campos abaixo.");
        texto_7.setBounds(110, 47, 200, 40);
        texto_7.setForeground(Color.darkGray);
        texto_7.setFont(new Font("Arial", Font.PLAIN, 10));
        verif_codigo.add(texto_7);

        JLabel texto_8 = new JLabel("CÓDIGO");
        texto_8.setBounds(100, 140, 150, 40);
        texto_8.setForeground(Color.darkGray);
        texto_8.setFont(new Font("Arial", Font.BOLD, 14));
        verif_codigo.add(texto_8);

        JTextField field_1 = new JTextField(17);
        field_1.setBorder(new MatteBorder(1,1,1,1,Color.darkGray));
        verif_codigo.add(field_1);
        field_1.setBounds(100,170,210,25);

        VoltarVC_b = new JButton("VOLTAR");
        verif_codigo.add(VoltarVC_b);
        VoltarVC_b.addActionListener(this);
        VoltarVC_b.setFocusPainted(false);
        VoltarVC_b.setBackground(new Color(84, 186, 255));
        VoltarVC_b.setForeground(Color.white);
        VoltarVC_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        VoltarVC_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        VoltarVC_b.setBounds(10, 330, 100, 40);

        ProxVC_b = new JButton("PRÓXIMO");
        verif_codigo.add(ProxVC_b);
        ProxVC_b.addActionListener(this);
        ProxVC_b.setFocusPainted(false);
        ProxVC_b.setBackground(new Color(255, 118, 118));
        ProxVC_b.setForeground(Color.white);
        ProxVC_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        ProxVC_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        ProxVC_b.setBounds(295, 330, 100, 40);

        ImageIcon imageBackIcon_1 = new ImageIcon("src/imgs/cadRecup.png");
        Image imageBackIMG_1 = imageBackIcon_1.getImage();
        Image newImgBack_1 = imageBackIMG_1.getScaledInstance(verif_codigo.getWidth(), verif_codigo.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageBackIcon_1 = new ImageIcon(newImgBack_1);

        JLabel backIMGLabel_1 = new JLabel("");
        backIMGLabel_1.setIcon(imageBackIcon_1);
        backIMGLabel_1.setBounds(0, 0, verif_codigo.getWidth(), verif_codigo.getHeight());
        verif_codigo.add(backIMGLabel_1);
        backIMGLabel_1.setVisible(true);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == VoltarRS_b){
                area_menu.setVisible(true);
                recuperar_senha.setVisible(false);
        }
        if(e.getSource() == ProxRS_b){
            recuperar_senha.setVisible(false);
            verif_codigo.setVisible(true);
        }
        if(e.getSource() == VoltarVC_b){
            recuperar_senha.setVisible(true);
            verif_codigo.setVisible(false);
        }
        if(e.getSource() == ProxVC_b){
            verif_codigo.setVisible(false);
            alter_senha.setVisible(true);
        }
    }
}
