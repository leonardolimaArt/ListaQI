package login_sess;

import clt_sess.clt_principal;
import dao.sysDAO;
import emp_sess.emp_principal;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class login_menu extends JFrame implements ActionListener, MouseListener {

    login_principal login_principal_obj;

    public String email_prm;
    public String nome_prm;

    /*------------------cadastro--------------------*/
    public JPanel recuperar_senha;

    /*------------------cadastro--------------------*/
    public JPanel cadastro_empresa;
    public JPanel cadastro_cleinte;

    /*------------------login_menu--------------------*/
    public JButton Cliente_b, Empresa_b;
    public JPanel area_menu;

    /*------------------login_empresa--------------------*/
    public JButton VoltarE_b, CadastrarE_b, EntrarE_b, SenhaE_b;
    public JPanel login_empresa;
    JTextField field_0_cnpj_loginEMP, field_1_senha_loginEMP;
    final JFrame CadOK = new JFrame();

    /*------------------login_cliente--------------------*/
    public JButton VoltarC_b, CadastrarC_b, EntrarC_b, SenhaC_b;
    public JPanel login_cliente;
    JTextField field_3_clt_email, field_4_clt_senha;

    public final Pattern textoPatternFinalDIG = Pattern.compile("[0-9]+");

    public login_menu(JPanel login_principal_menu, JPanel login_principal_emp, JPanel login_principal_clt, JPanel cadastro_empresa, JPanel cadastro_cleinte, JPanel recuperar_senha_g, login_principal login_principal_g) {
        this.area_menu = login_principal_menu;
        this.login_empresa = login_principal_emp;
        this.login_cliente = login_principal_clt;
        this.cadastro_empresa = cadastro_empresa;
        this.cadastro_cleinte = cadastro_cleinte;
        this.recuperar_senha = recuperar_senha_g;
        this.login_principal_obj = login_principal_g;

        /*------------------login_menu--------------------*/
        area_menu.setLayout(null);
        area_menu.setBounds(0,0,420,420);
        area_menu.setVisible(true);

        ImageIcon tituloSys_0 = new ImageIcon("src/imgs/tituloLista.png");
        Image imgTituloSys_0 = tituloSys_0.getImage();
        Image boundsTituloSys_0 = imgTituloSys_0.getScaledInstance(225, 74, java.awt.Image.SCALE_SMOOTH);
        tituloSys_0 = new ImageIcon(boundsTituloSys_0);
        JLabel logoSysIMG_0 = new JLabel(tituloSys_0);
        area_menu.add(logoSysIMG_0);
        logoSysIMG_0.setBounds(90,70,225,74);

        JLabel texto_0 = new JLabel("Escolha o acesso");
        texto_0.setBounds(140, 220, 150, 40);
        texto_0.setForeground(Color.white);
        texto_0.setFont(new Font("Arial", Font.PLAIN, 16));
        area_menu.add(texto_0);

        Cliente_b = new JButton("CLIENTE");
        area_menu.add(Cliente_b);
        Cliente_b.addActionListener(this);
        Cliente_b.setFocusPainted(false);
        Cliente_b.setBackground(new Color(84, 186, 255));
        Cliente_b.setForeground(Color.white);
        Cliente_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        Cliente_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Cliente_b.setBounds(90, 260, 100, 40);

        Empresa_b = new JButton("EMPRESA");
        area_menu.add(Empresa_b);
        Empresa_b.addActionListener(this);
        Empresa_b.setFocusPainted(false);
        Empresa_b.setBackground(new Color(84, 186, 255));
        Empresa_b.setForeground(Color.white);
        Empresa_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        Empresa_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Empresa_b.setBounds(210, 260, 100, 40);

        ImageIcon imageBackIcon_0 = new ImageIcon("src/imgs/back0.jpg");
        Image imageBackIMG_0 = imageBackIcon_0.getImage();
        Image newImgBack_0 = imageBackIMG_0.getScaledInstance(area_menu.getWidth(), area_menu.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageBackIcon_0 = new ImageIcon(newImgBack_0);

        JLabel backIMGLabel_0 = new JLabel("");
        backIMGLabel_0.setIcon(imageBackIcon_0);
        backIMGLabel_0.setBounds(0, 0, area_menu.getWidth(), area_menu.getHeight());
        area_menu.add(backIMGLabel_0);
        backIMGLabel_0.setVisible(true);

        /*------------------login_empresa--------------------*/
        login_empresa.setLayout(null);
        login_empresa.setBounds(0,0,420,420);
        login_empresa.setVisible(false);

        ImageIcon tituloSys_1 = new ImageIcon("src/imgs/tituloEmpresa.png");
        Image imgTituloSys_1 = tituloSys_1.getImage();
        Image boundsTituloSys_1 = imgTituloSys_1.getScaledInstance(225, 74, java.awt.Image.SCALE_SMOOTH);
        tituloSys_1 = new ImageIcon(boundsTituloSys_1);
        JLabel logoSysIMG_1 = new JLabel(tituloSys_1);
        login_empresa.add(logoSysIMG_1);
        logoSysIMG_1.setBounds(90,70,225,74);

        JLabel texto_1 = new JLabel("CNPJ");
        texto_1.setBounds(100, 120, 150, 40);
        texto_1.setForeground(Color.white);
        texto_1.setFont(new Font("Arial", Font.BOLD, 14));
        login_empresa.add(texto_1);

        field_0_cnpj_loginEMP = new JTextField(17);
        field_0_cnpj_loginEMP.setBorder(new MatteBorder(0,0,0,0,Color.white));
        login_empresa.add(field_0_cnpj_loginEMP);
        field_0_cnpj_loginEMP.setBounds(100,150,210,25);

        JLabel texto_2 = new JLabel("SENHA");
        texto_2.setBounds(100, 180, 150, 40);
        texto_2.setForeground(Color.white);
        texto_2.setFont(new Font("Arial", Font.BOLD, 14));
        login_empresa.add(texto_2);

        field_1_senha_loginEMP = new JTextField(17);
        field_1_senha_loginEMP.setBorder(new MatteBorder(0,0,0,0,Color.white));
        login_empresa.add(field_1_senha_loginEMP);
        field_1_senha_loginEMP.setBounds(100,210,210,25);

        VoltarE_b = new JButton("VOLTAR");
        login_empresa.add(VoltarE_b);
        VoltarE_b.addActionListener(this);
        VoltarE_b.setFocusPainted(false);
        VoltarE_b.setBackground(new Color(84, 186, 255));
        VoltarE_b.setForeground(Color.white);
        VoltarE_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        VoltarE_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        VoltarE_b.setBounds(10, 330, 100, 40);

        CadastrarE_b = new JButton("CADASTRAR");
        login_empresa.add(CadastrarE_b);
        CadastrarE_b.addActionListener(this);
        CadastrarE_b.setFocusPainted(false);
        CadastrarE_b.setBackground(new Color(84, 186, 255));
        CadastrarE_b.setForeground(Color.white);
        CadastrarE_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        CadastrarE_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        CadastrarE_b.setBounds(155, 330, 100, 40);

        EntrarE_b = new JButton("ENTRAR");
        login_empresa.add(EntrarE_b);
        EntrarE_b.addActionListener(this);
        EntrarE_b.setFocusPainted(false);
        EntrarE_b.setBackground(new Color(84, 186, 255));
        EntrarE_b.setForeground(Color.white);
        EntrarE_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        EntrarE_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        EntrarE_b.setBounds(295, 330, 100, 40);

        SenhaE_b = new JButton("Esqueceu a senha? Clique Aqui!");
        login_empresa.add(SenhaE_b);
        SenhaE_b.addActionListener(this);
        SenhaE_b.setFocusPainted(false);
        SenhaE_b.setContentAreaFilled(false);
        SenhaE_b.setForeground(Color.white);
        SenhaE_b.setFont(new Font("Open Sans Light", Font.ITALIC, 9));
        SenhaE_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        SenhaE_b.setBounds(100, 235, 150, 15);
        SenhaE_b.addMouseListener(this);

        ImageIcon imageBackIcon_1 = new ImageIcon("src/imgs/back1.jpg");
        Image imageBackIMG_1 = imageBackIcon_1.getImage();
        Image newImgBack_1 = imageBackIMG_1.getScaledInstance(login_empresa.getWidth(), login_empresa.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageBackIcon_1 = new ImageIcon(newImgBack_1);

        JLabel backIMGLabel_1 = new JLabel("");
        backIMGLabel_1.setIcon(imageBackIcon_1);
        backIMGLabel_1.setBounds(0, 0, login_empresa.getWidth(), login_empresa.getHeight());
        login_empresa.add(backIMGLabel_1);
        backIMGLabel_1.setVisible(true);

        /*------------------login_cliente--------------------*/
        login_cliente.setLayout(null);
        login_cliente.setBounds(0,0,420,420);
        login_cliente.setVisible(false);

        ImageIcon tituloSys_2 = new ImageIcon("src/imgs/tituloCliente.png");
        Image imgTituloSys_2 = tituloSys_2.getImage();
        Image boundsTituloSys_2 = imgTituloSys_2.getScaledInstance(225, 74, java.awt.Image.SCALE_SMOOTH);
        tituloSys_2 = new ImageIcon(boundsTituloSys_2);
        JLabel logoSysIMG_2 = new JLabel(tituloSys_2);
        login_cliente.add(logoSysIMG_2);
        logoSysIMG_2.setBounds(90,70,225,74);

        JLabel texto_3 = new JLabel("EMAIL");
        texto_3.setBounds(100, 120, 150, 40);
        texto_3.setForeground(Color.white);
        texto_3.setFont(new Font("Arial", Font.BOLD, 14));
        login_cliente.add(texto_3);

        field_3_clt_email = new JTextField(17);
        field_3_clt_email.setBorder(new MatteBorder(0,0,0,0,Color.white));
        login_cliente.add(field_3_clt_email);
        field_3_clt_email.setBounds(100,150,210,25);

        JLabel texto_4 = new JLabel("SENHA");
        texto_4.setBounds(100, 180, 150, 40);
        texto_4.setForeground(Color.white);
        texto_4.setFont(new Font("Arial", Font.BOLD, 14));
        login_cliente.add(texto_4);

        field_4_clt_senha = new JTextField(17);
        field_4_clt_senha.setBorder(new MatteBorder(0,0,0,0,Color.white));
        login_cliente.add(field_4_clt_senha);
        field_4_clt_senha.setBounds(100,210,210,25);

        VoltarC_b = new JButton("VOLTAR");
        login_cliente.add(VoltarC_b);
        VoltarC_b.addActionListener(this);
        VoltarC_b.setFocusPainted(false);
        VoltarC_b.setBackground(new Color(84, 186, 255));
        VoltarC_b.setForeground(Color.white);
        VoltarC_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        VoltarC_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        VoltarC_b.setBounds(10, 330, 100, 40);

        CadastrarC_b = new JButton("CADASTRAR");
        login_cliente.add(CadastrarC_b);
        CadastrarC_b.addActionListener(this);
        CadastrarC_b.setFocusPainted(false);
        CadastrarC_b.setBackground(new Color(84, 186, 255));
        CadastrarC_b.setForeground(Color.white);
        CadastrarC_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        CadastrarC_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        CadastrarC_b.setBounds(155, 330, 100, 40);

        EntrarC_b = new JButton("ENTRAR");
        login_cliente.add(EntrarC_b);
        EntrarC_b.addActionListener(this);
        EntrarC_b.setFocusPainted(false);
        EntrarC_b.setBackground(new Color(84, 186, 255));
        EntrarC_b.setForeground(Color.white);
        EntrarC_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        EntrarC_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        EntrarC_b.setBounds(295, 330, 100, 40);

        SenhaC_b = new JButton("Esqueceu a senha? Clique Aqui!");
        login_cliente.add(SenhaC_b);
        SenhaC_b.addActionListener(this);
        SenhaC_b.setFocusPainted(false);
        SenhaC_b.setContentAreaFilled(false);
        SenhaC_b.setForeground(Color.white);
        SenhaC_b.setFont(new Font("Open Sans Light", Font.ITALIC, 9));
        SenhaC_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        SenhaC_b.setBounds(100, 235, 150, 15);
        SenhaC_b.addMouseListener(this);

        ImageIcon imageBackIcon_2 = new ImageIcon("src/imgs/back2.jpg");
        Image imageBackIMG_2 = imageBackIcon_2.getImage();
        Image newImgBack_2 = imageBackIMG_2.getScaledInstance(login_empresa.getWidth(), login_empresa.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageBackIcon_2 = new ImageIcon(newImgBack_2);

        JLabel backIMGLabel_2 = new JLabel("");
        backIMGLabel_2.setIcon(imageBackIcon_2);
        backIMGLabel_2.setBounds(0, 0, login_empresa.getWidth(), login_empresa.getHeight());
        login_cliente.add(backIMGLabel_2);
        backIMGLabel_2.setVisible(true);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == Empresa_b){
            login_empresa.setVisible(true);
            area_menu.setVisible(false);
        }
        if(e.getSource() == VoltarE_b){
            login_empresa.setVisible(false);
            area_menu.setVisible(true);
        }
        if(e.getSource() == CadastrarE_b){
            cadastro_empresa.setVisible(true);
            login_empresa.setVisible(false);
        }
        if(e.getSource() == SenhaE_b){
            recuperar_senha.setVisible(true);
            login_empresa.setVisible(false);
        }
        if(e.getSource() == EntrarE_b){
            if(field_0_cnpj_loginEMP.getDocument().getLength() > 0 && field_1_senha_loginEMP.getDocument().getLength() > 0 && textoPatternFinalDIG.matcher(field_0_cnpj_loginEMP.getText()).matches()){

                sysDAO sysDAO_sess = new sysDAO();
                getset_form_emp cadFormEmp_sess = new getset_form_emp();
                cadFormEmp_sess.setCnpj_emp(field_0_cnpj_loginEMP.getText());
                cadFormEmp_sess.setSenha_emp(field_1_senha_loginEMP.getText());

                if(sysDAO_sess.login(cadFormEmp_sess) == false){
                    JOptionPane.showMessageDialog(CadOK,"Usuario Invalido", "Atenção", JOptionPane.WARNING_MESSAGE);
                }else{
                    cadFormEmp_sess = sysDAO_sess.dados_emp(cadFormEmp_sess);
                    field_0_cnpj_loginEMP.setText("");
                    field_1_senha_loginEMP.setText("");
                    emp_principal emp_sess = new emp_principal(login_principal_obj, cadFormEmp_sess);
                    emp_sess.setVisible(true);
                    login_principal_obj.setVisible(false);
                }
            }else{
                JOptionPane.showMessageDialog(CadOK,"Os campos devem ser preenchidos corretamente para logar", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
        }

        /*--------------ActionCliente-----------*/
        if(e.getSource() == Cliente_b){
            login_cliente.setVisible(true);
            area_menu.setVisible(false);
        }
        if(e.getSource() == VoltarC_b){
            login_cliente.setVisible(false);
            area_menu.setVisible(true);
        }
        if(e.getSource() == CadastrarC_b){
            cadastro_cleinte.setVisible(true);
            login_cliente.setVisible(false);
        }
        if(e.getSource() == SenhaC_b){
            recuperar_senha.setVisible(true);
            login_cliente.setVisible(false);
        }

        if(e.getSource() == EntrarC_b){
            if(field_3_clt_email.getDocument().getLength() > 0 && field_4_clt_senha.getDocument().getLength() > 0){

                sysDAO sysDAO_sess = new sysDAO();
                getset_form_clt cadFormClt_sess = new getset_form_clt();
                cadFormClt_sess.setEmail_clt(field_3_clt_email.getText());
                cadFormClt_sess.setSenha_clt(field_4_clt_senha.getText());

                if(sysDAO_sess.login_cliente(cadFormClt_sess) == false){
                    JOptionPane.showMessageDialog(CadOK,"Usuario Invalido", "Atenção", JOptionPane.WARNING_MESSAGE);
                }else{
                    cadFormClt_sess = sysDAO_sess.dados_clt(cadFormClt_sess);
                    field_3_clt_email.setText("");
                    field_4_clt_senha.setText("");
                    clt_principal clt_sess = new clt_principal(login_principal_obj, cadFormClt_sess);
                    clt_sess.setVisible(true);
                    login_principal_obj.setVisible(false);
                }
            }else{
                JOptionPane.showMessageDialog(CadOK,"Os campos devem ser preenchidos corretamente para logar", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == SenhaE_b) {
            SenhaE_b.setForeground(new Color(84, 186, 255));
        }
        if(e.getSource() == SenhaC_b) {
            SenhaC_b.setForeground(new Color(84, 186, 255));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == SenhaE_b) {
            SenhaE_b.setForeground(Color.white);
        }
        if(e.getSource() == SenhaC_b) {
            SenhaC_b.setForeground(Color.white);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

}
