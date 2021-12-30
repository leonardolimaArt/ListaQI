package login_sess;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

public class alter_senha extends JFrame implements ActionListener {
    /*------------------prox--------------------*/
    public JPanel area_menu;
    /*------------------alter_senha--------------------*/
    public JButton Alterar_b;
    public JPanel alter_senha;
    /*------------------confirm_senha--------------------*/
    public JButton ProxCS_b;
    public JPanel confirm_senha;

    public alter_senha(JPanel alter_senha, JPanel confirm_senha, JPanel area_menu) {
        this.alter_senha = alter_senha;
        this.confirm_senha = confirm_senha;
        this.area_menu = area_menu;

        /*------------------alter_senha--------------------*/
        alter_senha.setLayout(null);
        alter_senha.setBounds(0,0,420,420);
        alter_senha.setVisible(false);

        JLabel texto_0 = new JLabel("Alteração de Senha");
        texto_0.setBounds(110, 30, 300, 40);
        texto_0.setForeground(new Color(0, 153, 255));
        texto_0.setFont(new Font("Arial", Font.BOLD, 19));
        alter_senha.add(texto_0);

        JLabel texto_1 = new JLabel("Alteração de Senha");
        texto_1.setBounds(111, 31, 300, 40);
        texto_1.setForeground(new Color(0, 0, 0,64));
        texto_1.setFont(new Font("Arial", Font.BOLD, 19));
        alter_senha.add(texto_1);

        JLabel texto_2 = new JLabel("Por favor, preencha os campos abaixo.");
        texto_2.setBounds(110, 47, 200, 40);
        texto_2.setForeground(Color.darkGray);
        texto_2.setFont(new Font("Arial", Font.PLAIN, 10));
        alter_senha.add(texto_2);

        JLabel texto_3 = new JLabel("Nova senha");
        texto_3.setBounds(160, 100, 150, 40);
        texto_3.setForeground(Color.darkGray);
        texto_3.setFont(new Font("Arial", Font.PLAIN, 14));
        alter_senha.add(texto_3);

        JTextField field_0 = new JTextField(17);
        field_0.setBorder(new MatteBorder(0,0,1,0,Color.darkGray));
        alter_senha.add(field_0);
        field_0.setBounds(115,135,170,25);

        String  texto_4  = "<html>◯ Um caracter especial (*/-!%...)<br>◯ Uma letra maúiscula<br>◯ Uma letra minúscula<br>◯ Um número<br>◯ 7 ou mais caracteres</html>";
        JLabel texto_4_1 = new JLabel();
        texto_4_1.setText (texto_4);
        texto_4_1.setBounds(125, 145, 170, 135);
        texto_4_1.setForeground(Color.darkGray);
        texto_4_1.setFont(new Font("Arial", Font.PLAIN, 11));
        alter_senha.add(texto_4_1);

        Alterar_b = new JButton("ALTERAR");
        alter_senha.add(Alterar_b);
        Alterar_b.addActionListener(this);
        Alterar_b.setFocusPainted(false);
        Alterar_b.setBackground(new Color(255, 118, 118));
        Alterar_b.setForeground(Color.white);
        Alterar_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        Alterar_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Alterar_b.setBounds(295, 330, 100, 40);

        ImageIcon imageBackIcon_0 = new ImageIcon("src/imgs/cadRecup.png");
        Image imageBackIMG_0 = imageBackIcon_0.getImage();
        Image newImgBack_0 = imageBackIMG_0.getScaledInstance(alter_senha.getWidth(), alter_senha.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageBackIcon_0 = new ImageIcon(newImgBack_0);

        JLabel backIMGLabel_0 = new JLabel("");
        backIMGLabel_0.setIcon(imageBackIcon_0);
        backIMGLabel_0.setBounds(0, 0, alter_senha.getWidth(), alter_senha.getHeight());
        alter_senha.add(backIMGLabel_0);
        backIMGLabel_0.setVisible(true);

        /*------------------confirm_senha--------------------*/
        confirm_senha.setLayout(null);
        confirm_senha.setBounds(0,0,420,420);
        confirm_senha.setVisible(false);

        JLabel texto_5 = new JLabel("Senha alterada com sucesso!");
        texto_5.setBounds(65, 145, 300, 40);
        texto_5.setForeground(new Color(0, 153, 255));
        texto_5.setFont(new Font("Arial", Font.BOLD, 19));
        confirm_senha.add(texto_5);

        JLabel texto_6 = new JLabel("Senha alterada com sucesso!");
        texto_6.setBounds(66, 146, 300, 40);
        texto_6.setForeground(new Color(0, 0, 0,64));
        texto_6.setFont(new Font("Arial", Font.BOLD, 19));
        confirm_senha.add(texto_6);

        JLabel texto_7 = new JLabel("Você pode prosseguir para a tela de login");
        texto_7.setBounds(100, 160, 220, 40);
        texto_7.setForeground(Color.darkGray);
        texto_7.setFont(new Font("Arial", Font.PLAIN, 10));
        confirm_senha.add(texto_7);

        ProxCS_b = new JButton("PRÓXIMO");
        confirm_senha.add(ProxCS_b);
        ProxCS_b.addActionListener(this);
        ProxCS_b.setFocusPainted(false);
        ProxCS_b.setBackground(new Color(255, 118, 118));
        ProxCS_b.setForeground(Color.white);
        ProxCS_b.setFont(new Font("Open Sans Light", Font.BOLD, 14));
        ProxCS_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        ProxCS_b.setBounds(295, 330, 100, 40);

        ImageIcon imageBackIcon_1 = new ImageIcon("src/imgs/cadRecup.png");
        Image imageBackIMG_1 = imageBackIcon_1.getImage();
        Image newImgBack_1 = imageBackIMG_1.getScaledInstance(confirm_senha.getWidth(), confirm_senha.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageBackIcon_1 = new ImageIcon(newImgBack_1);

        JLabel backIMGLabel_1 = new JLabel("");
        backIMGLabel_1.setIcon(imageBackIcon_1);
        backIMGLabel_1.setBounds(0, 0, confirm_senha.getWidth(), confirm_senha.getHeight());
        confirm_senha.add(backIMGLabel_1);
        backIMGLabel_1.setVisible(true);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == Alterar_b){
            alter_senha.setVisible(false);
            confirm_senha.setVisible(true);
        }
        if(e.getSource() == ProxCS_b){
            confirm_senha.setVisible(false);
            area_menu.setVisible(true);
        }
    }
}
