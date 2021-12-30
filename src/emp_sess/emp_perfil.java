package emp_sess;

import dao.sysDAO;
import login_sess.getset_form_emp;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.regex.Pattern;

public class emp_perfil extends JFrame implements ActionListener, MouseListener  {

    public JButton Atualizar_b, foto_perfil_b;
    public JPanel MeuPerfil_P;
    ImageIcon tituloSys_2, tituloSys_3, newimgBDIconeFinal;
    emp_principal emp_principal_obj;

    JLabel texto_0_1, texto_11_1, texto_11_2, texto_11_3, texto_11_4, texto_11_5, logoSysIMG_0;

    getset_form_emp usr_obj;
    JTextField field_0, field_1, field_2, field_3, field_4, field_5, field_6;

    String caminho_img = null;

    public final Pattern textoPatternFinalMIN = Pattern.compile("^(?=.*[a-z]).+$");
    public final Pattern textoPatternFinalMAI = Pattern.compile("^(?=.*[A-Z]).+$");
    public final Pattern textoPatternFinalDIG = Pattern.compile("^(?=.*\\d).+$");
    public final Pattern textoPatternFinalESP = Pattern.compile("^(?=.*[!@#$%&*()_+=|<>?{}~-]).+$");

    public final Pattern textoPatternFinal = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%&*()_+=|<>?{}~-]).+$");

    final JFrame CadOK = new JFrame();

    public emp_perfil(JPanel emp_perfil_g, getset_form_emp usr) {
        this.MeuPerfil_P = emp_perfil_g;
        this.usr_obj = usr;

        MeuPerfil_P.setLayout(null);
        MeuPerfil_P.setVisible(true);
        MeuPerfil_P.setBackground(Color.white);
        MeuPerfil_P.setBounds(0, 28, 924, 480);

        JLabel texto_0 = new JLabel("Olá,");
        texto_0.setBounds(150, 50, 180, 40);
        texto_0.setForeground(Color.black);
        texto_0.setFont(new Font("Arial", Font.BOLD, 16));
        MeuPerfil_P.add(texto_0);

        texto_0_1 = new JLabel(" "+usr.getNome_emp());//NOME
        texto_0_1.setBounds(180, 50, 300, 40);
        texto_0_1.setForeground(Color.black);
        texto_0_1.setFont(new Font("Arial", Font.ITALIC, 16));
        MeuPerfil_P.add(texto_0_1);

        JLabel texto_1 = new JLabel("Cnpj: "+String.valueOf(usr.getCnpj_emp()));
        texto_1.setBounds(150, 70, 150, 40);
        texto_1.setForeground(Color.black);
        texto_1.setFont(new Font("Arial", Font.ITALIC, 16));
        MeuPerfil_P.add(texto_1);

        JLabel texto_2 = new JLabel("Nome");
        texto_2.setBounds(35, 155, 150, 40);
        texto_2.setForeground(Color.black);
        texto_2.setFont(new Font("Arial", Font.BOLD, 12));
        MeuPerfil_P.add(texto_2);

        field_0 = new JTextField(17);
        field_0.setBorder(new MatteBorder(0,0,1,0,Color.black));
        field_0.setText(usr.getNome_emp());
        MeuPerfil_P.add(field_0);
        field_0.setBounds(35,180,185,25);

        JLabel texto_3 = new JLabel("Email");
        texto_3.setBounds(255, 155, 150, 40);
        texto_3.setForeground(Color.black);
        texto_3.setFont(new Font("Arial", Font.BOLD, 12));
        MeuPerfil_P.add(texto_3);

        field_1 = new JTextField(17);
        field_1.setBorder(new MatteBorder(0,0,1,0,Color.black));
        field_1.setText(usr.getEmail());
        MeuPerfil_P.add(field_1);
        field_1.setBounds(255,180,185,25);

        JLabel texto_4 = new JLabel("Estado");
        texto_4.setBounds(35, 245, 150, 40);
        texto_4.setForeground(Color.black);
        texto_4.setFont(new Font("Arial", Font.BOLD, 12));
        MeuPerfil_P.add(texto_4);

        field_2 = new JTextField(17);
        field_2.setBorder(new MatteBorder(0,0,1,0,Color.black));
        field_2.setText(usr.getEstado_emp());
        MeuPerfil_P.add(field_2);
        field_2.setBounds(35,270,185,25);

        JLabel texto_5 = new JLabel("Cidade");
        texto_5.setBounds(255, 245, 150, 40);
        texto_5.setForeground(Color.black);
        texto_5.setFont(new Font("Arial", Font.BOLD, 12));
        MeuPerfil_P.add(texto_5);

        field_3 = new JTextField(17);
        field_3.setBorder(new MatteBorder(0,0,1,0,Color.black));
        field_3.setText(usr.getCidade_emp());
        MeuPerfil_P.add(field_3);
        field_3.setBounds(255,270,185,25);

        JLabel texto_6 = new JLabel("Bairro");
        texto_6.setBounds(35, 300, 150, 40);
        texto_6.setForeground(Color.black);
        texto_6.setFont(new Font("Arial", Font.BOLD, 12));
        MeuPerfil_P.add(texto_6);

        field_4 = new JTextField(17);
        field_4.setBorder(new MatteBorder(0,0,1,0,Color.black));
        field_4.setText(usr.getBairro_emp());
        MeuPerfil_P.add(field_4);
        field_4.setBounds(35,325,185,25);

        JLabel texto_7 = new JLabel("Logradouro");
        texto_7.setBounds(255, 300, 150, 40);
        texto_7.setForeground(Color.black);
        texto_7.setFont(new Font("Arial", Font.BOLD, 12));
        MeuPerfil_P.add(texto_7);

        field_5 = new JTextField(17);
        field_5.setBorder(new MatteBorder(0,0,1,0,Color.black));
        field_5.setText(usr.getLogradouro_emp());
        MeuPerfil_P.add(field_5);
        field_5.setBounds(255,330,185,20);

        JLabel texto_8 = new JLabel("Endereço");
        texto_8.setBounds(205, 215, 150, 40);
        texto_8.setForeground(Color.black);
        texto_8.setFont(new Font("Arial", Font.PLAIN, 16));
        MeuPerfil_P.add(texto_8);

        JLabel texto_9 = new JLabel("Dados básicos");
        texto_9.setBounds(180, 125, 150, 40);
        texto_9.setForeground(Color.black);
        texto_9.setFont(new Font("Arial", Font.PLAIN, 16));
        MeuPerfil_P.add(texto_9);

        JLabel texto_10 = new JLabel("Senha");
        texto_10.setBounds(690, 125, 150, 40);
        texto_10.setForeground(Color.black);
        texto_10.setFont(new Font("Arial", Font.PLAIN, 16));
        MeuPerfil_P.add(texto_10);

        field_6 = new JTextField(17);
        field_6.setBorder(new MatteBorder(0,0,1,0,Color.black));
        field_6.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {

            }
            public void removeUpdate(DocumentEvent e) {
                if(textoPatternFinalESP.matcher(field_6.getText()).matches() == true){
                    texto_11_1.setText ("<html>&#10003 Um caracter especial (*/-!%...)</html>");
                }else{
                    texto_11_1.setText ("<html>◯ Um caracter especial (*/-!%...)</html>");
                }
                if(textoPatternFinalMAI.matcher(field_6.getText()).matches() == true){
                    texto_11_2.setText ("<html>&#10003  Uma letra maúiscula</html>");
                }else{
                    texto_11_2.setText ("<html>◯ Uma letra maúiscula</html>");
                }
                if(textoPatternFinalMIN.matcher(field_6.getText()).matches() == true){
                    texto_11_3.setText ("<html>&#10003 Uma letra minúscula</html>");
                }else{
                    texto_11_3.setText ("<html>◯ Uma letra minúscula</html>");
                }
                if(textoPatternFinalDIG.matcher(field_6.getText()).matches() == true){
                    texto_11_4.setText ("<html>&#10003 Um número</html>");
                }else{
                    texto_11_4.setText ("<html>◯ Um número</html>");
                }
                if(field_6.getDocument().getLength() > 6){
                    texto_11_5.setText ("<html>&#10003 7 ou mais caracteres</html>");
                }else{
                    texto_11_5.setText ("<html>◯ 7 ou mais caracteres</html>");
                }
            }
            public void insertUpdate(DocumentEvent e) {
                if(textoPatternFinalESP.matcher(field_6.getText()).matches() == true){
                    texto_11_1.setText ("<html>&#10003 Um caracter especial (*/-!%...)</html>");
                }else{
                    texto_11_1.setText ("<html>◯ Um caracter especial (*/-!%...)</html>");
                }
                if(textoPatternFinalMAI.matcher(field_6.getText()).matches() == true){
                    texto_11_2.setText ("<html>&#10003  Uma letra maúiscula</html>");
                }else{
                    texto_11_2.setText ("<html>◯ Uma letra maúiscula</html>");
                }
                if(textoPatternFinalMIN.matcher(field_6.getText()).matches() == true){
                    texto_11_3.setText ("<html>&#10003 Uma letra minúscula</html>");
                }else{
                    texto_11_3.setText ("<html>◯ Uma letra minúscula</html>");
                }
                if(textoPatternFinalDIG.matcher(field_6.getText()).matches() == true){
                    texto_11_4.setText ("<html>&#10003 Um número</html>");
                }else{
                    texto_11_4.setText ("<html>◯ Um número</html>");
                }
                if(field_6.getDocument().getLength() > 6){
                    texto_11_5.setText ("<html>&#10003 7 ou mais caracteres</html>");
                }else{
                    texto_11_5.setText ("<html>◯ 7 ou mais caracteres</html>");
                }
            }
        });

        MeuPerfil_P.add(field_6);
        field_6.setBounds(620,180,185,25);

        texto_11_1 = new JLabel();
        texto_11_1.setText ("<html>◯ Um caracter especial (*/-!%...)</html>");
        texto_11_1.setBounds(635, 160, 170, 135);
        texto_11_1.setForeground(Color.black);
        texto_11_1.setFont(new Font("Arial", Font.PLAIN, 11));
        MeuPerfil_P.add(texto_11_1);

        texto_11_2 = new JLabel();
        texto_11_2.setText ("<html>◯ Uma letra maúiscula</html>");
        texto_11_2.setBounds(635, 180, 170, 135);
        texto_11_2.setForeground(Color.black);
        texto_11_2.setFont(new Font("Arial", Font.PLAIN, 11));
        MeuPerfil_P.add(texto_11_2);

        texto_11_3 = new JLabel();
        texto_11_3.setText ("<html>◯ Uma letra minúscula</html>");
        texto_11_3.setBounds(635, 200, 170, 135);
        texto_11_3.setForeground(Color.black);
        texto_11_3.setFont(new Font("Arial", Font.PLAIN, 11));
        MeuPerfil_P.add(texto_11_3);

        texto_11_4 = new JLabel();
        texto_11_4.setText ("<html>◯ Um número</html>");
        texto_11_4.setBounds(635, 220, 170, 135);
        texto_11_4.setForeground(Color.black);
        texto_11_4.setFont(new Font("Arial", Font.PLAIN, 11));
        MeuPerfil_P.add(texto_11_4);

        texto_11_5 = new JLabel();
        texto_11_5.setText ("<html>◯ 7 ou mais caracteres</html>");
        texto_11_5.setBounds(635, 240, 170, 135);
        texto_11_5.setForeground(Color.black);
        texto_11_5.setFont(new Font("Arial", Font.PLAIN, 11));
        MeuPerfil_P.add(texto_11_5);


        JLabel texto_12 = new JLabel("Senha");
        texto_12.setBounds(620, 155, 150, 40);
        texto_12.setForeground(Color.black);
        texto_12.setFont(new Font("Arial", Font.BOLD, 12));
        MeuPerfil_P.add(texto_12);

        tituloSys_2 = new ImageIcon("src/imgs/cam.png");
        Image imgTituloSys_2 = tituloSys_2.getImage();
        Image boundsTituloSys_2 = imgTituloSys_2.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
        tituloSys_2 = new ImageIcon(boundsTituloSys_2);

        tituloSys_3 = new ImageIcon("src/imgs/cam2.png");
        Image imgTituloSys_3 = tituloSys_3.getImage();
        Image boundsTituloSys_3 = imgTituloSys_3.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
        tituloSys_3 = new ImageIcon(boundsTituloSys_3);

        ImageIcon tituloSys_0 = new ImageIcon("src/imgs/user_pdra.png");
        Image imgTituloSys_0 = tituloSys_0.getImage();
        Image boundsTituloSys_0 = imgTituloSys_0.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
        tituloSys_0 = new ImageIcon(boundsTituloSys_0);
        logoSysIMG_0 = new JLabel(tituloSys_0);
        MeuPerfil_P.add(logoSysIMG_0);
        logoSysIMG_0.setBounds(40,40,70,70);


        sysDAO perfilPNG = new sysDAO();
        getset_form_emp usrImgobj = usr_obj;

        if(perfilPNG.carrImgPerfil(usrImgobj) != null) {
            usrImgobj = perfilPNG.carrImgPerfil(usrImgobj);
            Image imgBDIcone = usrImgobj.getPerfilIcon().getImage();
            Image boundsImgBDIcone = imgBDIcone.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
            newimgBDIconeFinal = new ImageIcon(boundsImgBDIcone);
            logoSysIMG_0.setIcon(newimgBDIconeFinal);
        }

        ImageIcon tituloSys_1 = new ImageIcon("src/imgs/linha.png");
        Image imgTituloSys_1 = tituloSys_1.getImage();
        Image boundsTituloSys_1 = imgTituloSys_1.getScaledInstance(1, 270, java.awt.Image.SCALE_SMOOTH);
        tituloSys_1 = new ImageIcon(boundsTituloSys_1);
        JLabel logoSysIMG_1 = new JLabel(tituloSys_1);
        MeuPerfil_P.add(logoSysIMG_1);
        logoSysIMG_1.setBounds(530,120,2,270);

        Atualizar_b = new JButton("Atualizar");
        Atualizar_b.addActionListener(this);
        Atualizar_b.setFocusPainted(false);
        Atualizar_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Atualizar_b.setBackground(new Color(255,118,118));
        Atualizar_b.setForeground(Color.white);
        MeuPerfil_P.add(Atualizar_b);
        Atualizar_b.setBounds(803,405,95,40);

        foto_perfil_b = new JButton("");
        foto_perfil_b.addActionListener(this);
        foto_perfil_b.addMouseListener(this);
        foto_perfil_b.setIcon(null);
        foto_perfil_b.setFocusPainted(false);
        foto_perfil_b.setContentAreaFilled(false);
        foto_perfil_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        MeuPerfil_P.add(foto_perfil_b);
        foto_perfil_b.setBounds(40,40,70,70);
        MeuPerfil_P.setComponentZOrder(foto_perfil_b, 1);
        foto_perfil_b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
                fileChooser.addChoosableFileFilter(filter);
                int result = fileChooser.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = fileChooser.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    logoSysIMG_0.setIcon(ResizeImage(path));
                    caminho_img = path;
                }
                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("Sem Arquivo");
                }
            }
        });
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource() == Atualizar_b) {
            sysDAO sysDAO_sess = new sysDAO();

            usr_obj.setNome_emp(field_0.getText());
            usr_obj.setEmail(field_1.getText());
            usr_obj.setEstado_emp(field_2.getText());
            usr_obj.setCidade_emp(field_3.getText());
            usr_obj.setBairro_emp(field_4.getText());
            usr_obj.setLogradouro_emp(field_5.getText());

            sysDAO_sess.saveImgPerfil(usr_obj, caminho_img);
            sysDAO_sess.update(usr_obj);

            texto_0_1.setText(" "+field_0.getText());
            JOptionPane.showMessageDialog(CadOK,"Dados Alterados!.", "Dados Alterados", JOptionPane.INFORMATION_MESSAGE);

            if(textoPatternFinal.matcher(field_6.getText()).matches() == true && field_6.getDocument().getLength() > 6){

                usr_obj.setSenha_emp(field_6.getText());
                sysDAO_sess.updateSenha(usr_obj);

                JOptionPane.showMessageDialog(CadOK,"Senha Alterada.", "Senha Alterada", JOptionPane.INFORMATION_MESSAGE);
                field_6.setText("");

                texto_11_1.setText ("<html>◯ Um caracter especial (*/-!%...)</html>");
                texto_11_2.setText ("<html>◯ Uma letra maúiscula</html>");
                texto_11_3.setText ("<html>◯ Uma letra minúscula</html>");
                texto_11_4.setText ("<html>◯ Um número</html>");
                texto_11_5.setText ("<html>◯ 7 ou mais caracteres</html>");
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == foto_perfil_b) {
            foto_perfil_b.setIcon(tituloSys_2);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == foto_perfil_b) {
            foto_perfil_b.setIcon(null);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == foto_perfil_b) {
            foto_perfil_b.setIcon(tituloSys_3);
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == foto_perfil_b) {
            foto_perfil_b.setIcon(tituloSys_2);
        }
    }
    public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(logoSysIMG_0.getWidth(), logoSysIMG_0.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
}
