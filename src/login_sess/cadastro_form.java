package login_sess;

import clt_sess.clt_principal;
import dao.sysDAO;
import emp_sess.emp_principal;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class cadastro_form extends JFrame implements ActionListener {
    clt_principal clt_principal_obj;
    emp_principal emp_principal_obj;
    login_principal login_principal_obj;
    public String email_usr, cnpj_usr, nome_usr, senha_usr;

    /*------------------retornar--------------------*/
    public JPanel login_empresa;
    public JPanel login_cliente;

    /*------------------cadastro_empresa--------------------*/
    public JButton VoltarE_b, EntrarE_b;
    public JPanel cadastro_empresa;
    public JLabel texto_11;

    public JTextField field_6_email, field_0_cnpj, field_1_nome_emp, field_2_senha;
    final JFrame CadOK = new JFrame();
    public final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%&*()_+=|<>?{}~-]).+$");

    /*------------------cadastro_cliente--------------------*/
    public JButton VoltarC_b, EntrarC_b;
    public JPanel cadastro_cliente;
    public JTextField field_3_clt_email, field_4_clt_nome, field_5_clt_senha;

    public cadastro_form(JPanel login_principal_emp, JPanel login_principal_clt, JPanel login_empresa, JPanel login_cliente, login_principal login_principal_g) {
        this.cadastro_empresa = login_principal_emp;
        this.cadastro_cliente = login_principal_clt;
        this.login_empresa = login_empresa;
        this.login_cliente = login_cliente;
        this.login_principal_obj = login_principal_g;

        /*------------------cadastro_empresa--------------------*/
        cadastro_empresa.setLayout(null);
        cadastro_empresa.setBounds(0,0,420,420);
        cadastro_empresa.setVisible(false);

        JLabel texto_0 = new JLabel("Vamos cadastrar sua Empresa!");
        texto_0.setBounds(60, 10, 300, 40);
        texto_0.setForeground(new Color(0, 153, 255));
        texto_0.setFont(new Font("Arial", Font.BOLD, 19));
        cadastro_empresa.add(texto_0);

        JLabel texto_1 = new JLabel("Vamos cadastrar sua Empresa!");
        texto_1.setBounds(61, 11, 300, 40);
        texto_1.setForeground(new Color(0, 0, 0,64));
        texto_1.setFont(new Font("Arial", Font.BOLD, 19));
        cadastro_empresa.add(texto_1);

        JLabel texto_2 = new JLabel("Por favor, preencha os campos abaixo.");
        texto_2.setBounds(110, 25, 200, 40);
        texto_2.setForeground(Color.darkGray);
        texto_2.setFont(new Font("Arial", Font.PLAIN, 10));
        cadastro_empresa.add(texto_2);

        JLabel texto_3 = new JLabel("CNPJ");
        texto_3.setBounds(100, 120, 150, 40);
        texto_3.setForeground(Color.darkGray);
        texto_3.setFont(new Font("Arial", Font.BOLD, 14));
        cadastro_empresa.add(texto_3);

        field_0_cnpj = new JTextField(17);
        field_0_cnpj.setBorder(new MatteBorder(1,1,1,1,Color.darkGray));
        cadastro_empresa.add(field_0_cnpj);
        field_0_cnpj.setBounds(100,150,210,25);

        JLabel texto_5 = new JLabel("NOME DA EMPRESA");
        texto_5.setBounds(100, 180, 150, 40);
        texto_5.setForeground(Color.darkGray);
        texto_5.setFont(new Font("Arial", Font.BOLD, 14));
        cadastro_empresa.add(texto_5);

        field_1_nome_emp = new JTextField(17);
        field_1_nome_emp.setBorder(new MatteBorder(1,1,1,1,Color.darkGray));
        cadastro_empresa.add(field_1_nome_emp);
        field_1_nome_emp.setBounds(100,210,210,25);

        JLabel texto_6 = new JLabel("SENHA");
        texto_6.setBounds(100, 240, 150, 40);
        texto_6.setForeground(Color.darkGray);
        texto_6.setFont(new Font("Arial", Font.BOLD, 14));
        cadastro_empresa.add(texto_6);

        JLabel texto_7 = new JLabel("Use números, letras e símbolos para a senha.");
        texto_7.setBounds(155, 240, 160, 40);
        texto_7.setForeground(Color.darkGray);
        texto_7.setFont(new Font("Arial", Font.ITALIC, 8));
        cadastro_empresa.add(texto_7);

        field_2_senha = new JTextField(17);
        field_2_senha.setBorder(new MatteBorder(1,1,1,1,Color.darkGray));
        cadastro_empresa.add(field_2_senha);
        field_2_senha.setBounds(100,270,210,25);

        field_6_email = new JTextField(17);
        field_6_email.setBorder(new MatteBorder(1,1,1,1,Color.darkGray));
        cadastro_empresa.add(field_6_email);
        field_6_email.setBounds(100,90,210,25);

        JLabel texto_16 = new JLabel("EMAIL");
        texto_16.setBounds(100, 60, 150, 40);
        texto_16.setForeground(Color.darkGray);
        texto_16.setFont(new Font("Arial", Font.BOLD, 14));
        cadastro_empresa.add(texto_16);

        JLabel texto_4 = new JLabel("Seu Email vai ser usado como login único.");
        texto_4.setBounds(155, 60, 150, 40);
        texto_4.setForeground(Color.darkGray);
        texto_4.setFont(new Font("Arial", Font.ITALIC, 8));
        cadastro_empresa.add(texto_4);

        VoltarE_b = new JButton("VOLTAR");
        cadastro_empresa.add(VoltarE_b);
        VoltarE_b.addActionListener(this);
        VoltarE_b.setFocusPainted(false);
        VoltarE_b.setBackground(new Color(84, 186, 255));
        VoltarE_b.setForeground(Color.white);
        VoltarE_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        VoltarE_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        VoltarE_b.setBounds(10, 330, 100, 40);

        EntrarE_b = new JButton("CADASTRAR");
        cadastro_empresa.add(EntrarE_b);
        EntrarE_b.addActionListener(this);
        EntrarE_b.setFocusPainted(false);
        EntrarE_b.setBackground(new Color(255, 118, 118));
        EntrarE_b.setForeground(Color.white);
        EntrarE_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        EntrarE_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        EntrarE_b.setBounds(295, 330, 100, 40);

        ImageIcon imageBackIcon_0 = new ImageIcon("src/imgs/cadEmp.png");
        Image imageBackIMG_0 = imageBackIcon_0.getImage();
        Image newImgBack_0 = imageBackIMG_0.getScaledInstance(cadastro_empresa.getWidth(), cadastro_empresa.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageBackIcon_0 = new ImageIcon(newImgBack_0);

        JLabel backIMGLabel_0 = new JLabel("");
        backIMGLabel_0.setIcon(imageBackIcon_0);
        backIMGLabel_0.setBounds(0, 0, cadastro_empresa.getWidth(), cadastro_empresa.getHeight());
        cadastro_empresa.add(backIMGLabel_0);
        backIMGLabel_0.setVisible(true);

        /*------------------cadastro_cliente--------------------*/
        cadastro_cliente.setLayout(null);
        cadastro_cliente.setBounds(0,0,420,420);
        cadastro_cliente.setVisible(false);

        JLabel texto_8 = new JLabel("Vamos fazer seu Cadastro!");
        texto_8.setBounds(80, 30, 300, 40);
        texto_8.setForeground(new Color(0, 153, 255));
        texto_8.setFont(new Font("Arial", Font.BOLD, 19));
        cadastro_cliente.add(texto_8);

        JLabel texto_9 = new JLabel("Vamos fazer seu Cadastro!");
        texto_9.setBounds(81, 31, 300, 40);
        texto_9.setForeground(new Color(0, 0, 0,64));
        texto_9.setFont(new Font("Arial", Font.BOLD, 19));
        cadastro_cliente.add(texto_9);

        JLabel texto_10 = new JLabel("Por favor, preencha os campos abaixo.");
        texto_10.setBounds(110, 45, 200, 40);
        texto_10.setForeground(Color.darkGray);
        texto_10.setFont(new Font("Arial", Font.PLAIN, 10));
        cadastro_cliente.add(texto_10);

        texto_11 = new JLabel("EMAIL");
        texto_11.setBounds(100, 100, 150, 40);
        texto_11.setForeground(Color.darkGray);
        texto_11.setFont(new Font("Arial", Font.BOLD, 14));
        cadastro_cliente.add(texto_11);

        JLabel texto_12 = new JLabel("Seu email vai ser usado como login único.");
        texto_12.setBounds(155, 100, 150, 40);
        texto_12.setForeground(Color.darkGray);
        texto_12.setFont(new Font("Arial", Font.ITALIC, 8));
        cadastro_cliente.add(texto_12);

        field_3_clt_email = new JTextField(17);
        field_3_clt_email.setBorder(new MatteBorder(1,1,1,1,Color.darkGray));
        cadastro_cliente.add(field_3_clt_email);
        field_3_clt_email.setBounds(100,130,210,25);

        JLabel texto_13 = new JLabel("NOME");
        texto_13.setBounds(100, 160, 150, 40);
        texto_13.setForeground(Color.darkGray);
        texto_13.setFont(new Font("Arial", Font.BOLD, 14));
        cadastro_cliente.add(texto_13);

        field_4_clt_nome = new JTextField(17);
        field_4_clt_nome.setBorder(new MatteBorder(1,1,1,1,Color.darkGray));
        cadastro_cliente.add(field_4_clt_nome);
        field_4_clt_nome.setBounds(100,190,210,25);

        JLabel texto_14 = new JLabel("SENHA");
        texto_14.setBounds(100, 220, 150, 40);
        texto_14.setForeground(Color.darkGray);
        texto_14.setFont(new Font("Arial", Font.BOLD, 14));
        cadastro_cliente.add(texto_14);

        JLabel texto_15 = new JLabel("Use números, letras e símbolos para a senha.");
        texto_15.setBounds(155, 220, 160, 40);
        texto_15.setForeground(Color.darkGray);
        texto_15.setFont(new Font("Arial", Font.ITALIC, 8));
        cadastro_cliente.add(texto_15);

        field_5_clt_senha = new JTextField(17);
        field_5_clt_senha.setBorder(new MatteBorder(1,1,1,1,Color.darkGray));
        cadastro_cliente.add(field_5_clt_senha);
        field_5_clt_senha.setBounds(100,250,210,25);

        VoltarC_b = new JButton("VOLTAR");
        cadastro_cliente.add(VoltarC_b);
        VoltarC_b.addActionListener(this);
        VoltarC_b.setFocusPainted(false);
        VoltarC_b.setBackground(new Color(84, 186, 255));
        VoltarC_b.setForeground(Color.white);
        VoltarC_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        VoltarC_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        VoltarC_b.setBounds(10, 330, 100, 40);

        EntrarC_b = new JButton("CADASTRAR");
        cadastro_cliente.add(EntrarC_b);
        EntrarC_b.addActionListener(this);
        EntrarC_b.setFocusPainted(false);
        EntrarC_b.setBackground(new Color(255, 118, 118));
        EntrarC_b.setForeground(Color.white);
        EntrarC_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        EntrarC_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        EntrarC_b.setBounds(295, 330, 100, 40);

        ImageIcon imageBackIcon_1 = new ImageIcon("src/imgs/cadClt.png");
        Image imageBackIMG_1 = imageBackIcon_1.getImage();
        Image newImgBack_1 = imageBackIMG_1.getScaledInstance(cadastro_cliente.getWidth(), cadastro_cliente.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageBackIcon_1 = new ImageIcon(newImgBack_1);

        JLabel backIMGLabel_1 = new JLabel("");
        backIMGLabel_1.setIcon(imageBackIcon_1);
        backIMGLabel_1.setBounds(0, 0, cadastro_cliente.getWidth(), cadastro_cliente.getHeight());
        cadastro_cliente.add(backIMGLabel_1);
        backIMGLabel_1.setVisible(true);
    }
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == VoltarE_b){
            cadastro_empresa.setVisible(false);
            login_empresa.setVisible(true);
        }
        if(e.getSource() == EntrarE_b){

            if(field_6_email.getText().equals("") || field_0_cnpj.getText().equals("") || field_1_nome_emp.getText().equals("") || field_2_senha.getText().equals("")){
                JOptionPane.showMessageDialog(CadOK,"Por favor, verifique os campos em branco!", "Verifique os campos", JOptionPane.WARNING_MESSAGE);
            }
            else if(field_0_cnpj.getDocument().getLength() < 2 /*|| field_0_cnpj.getDocument().getLength() < 2*/ || field_0_cnpj.getText().matches("[0-9]+") == false){
                JOptionPane.showMessageDialog(CadOK,"Verifique o CNPJ, ele é composto por 14 digitos.", "Verifique os campos", JOptionPane.WARNING_MESSAGE);
            }else if(field_2_senha.getDocument().getLength() < 7 || textPattern.matcher(field_2_senha.getText()).matches() == false){
                JOptionPane.showMessageDialog(CadOK,"A senha deve ser composta por: Letra maiúscula, minúscula, caractere especial, número e ser maior que 6 caracteres", "Verifique os campos", JOptionPane.WARNING_MESSAGE);
            }else{
                sysDAO sysDAO_sess = new sysDAO();
                getset_form_emp cadFormEmp_sess = new getset_form_emp();

                email_usr = field_6_email.getText();
                cnpj_usr = field_0_cnpj.getText();
                nome_usr = field_1_nome_emp.getText();
                senha_usr = field_2_senha.getText();

                cadFormEmp_sess.setEmail(email_usr);
                cadFormEmp_sess.setCnpj_emp(cnpj_usr);
                cadFormEmp_sess.setNome_emp(nome_usr);
                cadFormEmp_sess.setSenha_emp(senha_usr);

                if(sysDAO_sess.save(cadFormEmp_sess) == true){
                    field_6_email.setText("");
                    field_0_cnpj.setText("");
                    field_1_nome_emp.setText("");
                    field_2_senha.setText("");
                    JOptionPane.showMessageDialog(CadOK,"Cadastro realizado! Agora você pode fazer login!", "Cadastro realizado!", JOptionPane.INFORMATION_MESSAGE);
                    cadastro_empresa.setVisible(false);
                    login_empresa.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(CadOK,"Usuário já cadastrado no sistema! Tente um CNPJ ou E-mail diferente.", "Cadastro não realizado!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        if(e.getSource() == VoltarC_b){
            cadastro_cliente.setVisible(false);
            login_cliente.setVisible(true);
        }
        if(e.getSource() == EntrarC_b){
            if(field_3_clt_email.getText().equals("") || field_4_clt_nome.getText().equals("") || field_5_clt_senha.getText().equals("")){
                JOptionPane.showMessageDialog(CadOK,"Por favor, verifique os campos em branco!", "Verifique os campos", JOptionPane.WARNING_MESSAGE);
            }else if(field_5_clt_senha.getDocument().getLength() < 7 || textPattern.matcher(field_5_clt_senha.getText()).matches() == false){
                JOptionPane.showMessageDialog(CadOK,"A senha deve ser composta por: Letra maiúscula, minúscula, caractere especial, número e ser maior que 6 caracteres", "Verifique os campos", JOptionPane.WARNING_MESSAGE);
            }else{
                sysDAO sysDAO_sess = new sysDAO();
                getset_form_clt cadFormClt_sess = new getset_form_clt();

                email_usr = field_3_clt_email.getText();
                nome_usr = field_4_clt_nome.getText();
                senha_usr = field_5_clt_senha.getText();

                cadFormClt_sess.setEmail_clt(email_usr);
                cadFormClt_sess.setNome_clt(nome_usr);
                cadFormClt_sess.setSenha_clt(senha_usr);

                if(sysDAO_sess.cad_cliente(cadFormClt_sess) == true){
                    field_3_clt_email.setText("");
                    field_4_clt_nome.setText("");
                    field_5_clt_senha.setText("");
                    JOptionPane.showMessageDialog(CadOK,"Cadastro realizado! Agora você pode fazer login!", "Cadastro realizado!", JOptionPane.INFORMATION_MESSAGE);
                    cadastro_cliente.setVisible(false);
                    login_cliente.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(CadOK,"Usuário já cadastrado no sistema! Tente um E-mail diferente.", "Cadastro não realizado!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
