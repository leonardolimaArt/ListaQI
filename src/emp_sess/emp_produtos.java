package emp_sess;

import dao.sysProduDAO;
import login_sess.getset_form_emp;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class emp_produtos extends JFrame implements ActionListener {
    public JButton Atualizar_b, Adicionar_b;
    public JPanel MeuPerfil_P;
    float acumul_prc, ult_prc, prc_atual, acumul, ult_qtd, qtd_atual;
    JLabel texto_1, texto_2;
    JTable tabela;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    getset_form_emp usr_obj;
    final JFrame CadOK = new JFrame();
    public emp_produtos(JPanel emp_perfil_g, getset_form_emp usr) {
        this.MeuPerfil_P = emp_perfil_g;
        this.usr_obj = usr;

        MeuPerfil_P.setLayout(null);
        MeuPerfil_P.setVisible(false);
        MeuPerfil_P.setBackground(Color.white);
        MeuPerfil_P.setBounds(0, 28, 924, 480);

        JLabel texto_0 = new JLabel("Sua lista de produtos, ");
        texto_0.setBounds(60, 15, 180, 40);
        texto_0.setForeground(Color.black);
        texto_0.setFont(new Font("Arial", Font.BOLD, 16));
        MeuPerfil_P.add(texto_0);

        JLabel texto_0_1 = new JLabel(" "+usr.getNome_emp());
        texto_0_1.setBounds(230, 15, 300, 40);
        texto_0_1.setForeground(Color.black);
        texto_0_1.setFont(new Font("Arial", Font.ITALIC, 16));
        MeuPerfil_P.add(texto_0_1);



        String[] columnNames = {"Produto", "Drescrição", "Preço - R$", "Quantidade", "Excluir"};

        tabela = new JTable();
        dtm = new DefaultTableModel(0, 0);
        dtm.setColumnIdentifiers(columnNames);
        tabela.setModel(dtm);

        sysProduDAO prod_listaDAO = new sysProduDAO();

        for(getset_venda_prdo p: prod_listaDAO.prod_venda(usr_obj)){
            dtm.addRow(new Object[] {prod_listaDAO.nomeProd(p.getCodigo()), String.valueOf(p.getDescricao()).replace(usr_obj.getNome_emp(),"").replace(String.valueOf(usr_obj.getCnpj_emp()),"").replace(" | ", ""), String.valueOf(p.getPreco()).replace(".", ","), String.valueOf(p.getQtde()), "Não"});
        }

        tabela.setPreferredScrollableViewportSize(new Dimension(500, 50));
        tabela.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(60,70,790,330);
        scrollPane.setVisible(true);
        scrollPane.setViewportBorder(null);

        MeuPerfil_P.add(scrollPane);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));
        tabela.getTableHeader().setPreferredSize(new Dimension(70,30));
        tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabela.setRowHeight(30);
        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setForeground(Color.white);
        tabela.getTableHeader().setBackground(new Color(44,44,44));


        TableColumn produto_column = tabela.getColumnModel().getColumn(0);
        JComboBox<String> comboBox_produto = new JComboBox<>();
        sysProduDAO prodDAO = new sysProduDAO();

        for(getset_comboBox_prod p: prodDAO.read()){
            comboBox_produto.addItem(p.getNome());
        }

        produto_column.setCellEditor(new DefaultCellEditor(comboBox_produto));

        TableColumn excluir_column = tabela.getColumnModel().getColumn(4);
        JComboBox<String> comboBox_excluir = new JComboBox<>();
        comboBox_excluir.addItem("Sim");
        comboBox_excluir.addItem("Não");
        excluir_column.setCellEditor(new DefaultCellEditor(comboBox_excluir));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        tabela.setDefaultRenderer(Object.class, centerRenderer);

        dtm.addRow(new Object[]{"Selecione o produto", "Descrição", "0,00", "0", "Não"});
        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                org();
            }
        });

        Atualizar_b = new JButton("Atualizar");
        Atualizar_b.addActionListener(this);
        Atualizar_b.setFocusPainted(false);
        Atualizar_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Atualizar_b.setBackground(new Color(255,118,118));
        Atualizar_b.setForeground(Color.white);
        MeuPerfil_P.add(Atualizar_b);
        Atualizar_b.setBounds(803,405,95,40);

        texto_1 = new JLabel("Quantidade Total: ");
        texto_1.setBounds(60, 405, 180, 40);
        texto_1.setForeground(Color.black);
        texto_1.setFont(new Font("Arial", Font.BOLD, 12));
        MeuPerfil_P.add(texto_1);

        texto_2 = new JLabel("Preço Total: R$");
        texto_2.setBounds(250, 405, 180, 40);
        texto_2.setForeground(Color.black);
        texto_2.setFont(new Font("Arial", Font.BOLD, 12));
        MeuPerfil_P.add(texto_2);
        org();
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        int j = tabela.getRowCount();
        if (e.getSource() == Atualizar_b) {

            for (int i = 0; i < j; i++) {
                if (tabela.getModel().getValueAt(i, 0) != "Selecione o produto") {
                    sysProduDAO prodAtulz = new sysProduDAO();
                    getset_comboBox_prod prodAtulz_obj = new getset_comboBox_prod();
                    getset_venda_prdo vendaPrdo_obj = new getset_venda_prdo();

                    prodAtulz_obj.setNome((String) tabela.getModel().getValueAt(i, 0));
                    prodAtulz_obj = prodAtulz.codProd(prodAtulz_obj);

                    vendaPrdo_obj.setNome_emp(usr_obj.getNome_emp());
                    vendaPrdo_obj.setCnpj(usr_obj.getCnpj_emp());
                    vendaPrdo_obj.setCodigo(prodAtulz_obj.getCodigo());
                    vendaPrdo_obj.setQtde(Integer.parseInt((String) tabela.getModel().getValueAt(i, 3)));
                    vendaPrdo_obj.setPreco(Double.parseDouble(((String) tabela.getModel().getValueAt(i, 2)).replaceAll(",", ".")));
                    vendaPrdo_obj.setDescricao((String) tabela.getModel().getValueAt(i, 1) + " | " + usr_obj.getNome_emp() + " | " + usr_obj.getCnpj_emp());

                    prodAtulz.insert_lista_prd(vendaPrdo_obj);
                    prodAtulz.updateLista(vendaPrdo_obj);
                    System.out.println(vendaPrdo_obj.getDescricao());
                }
            }

            j = tabela.getRowCount();
            if(tabela.getModel().getValueAt(j-1, 4) == "Sim") {
                dtm.addRow(new Object[]{"Selecione o produto", "Descrição", "0,00", "0", "Não"});
            }
            for (int i = 0; i < j; i++) {
                if (tabela.getModel().getValueAt(i, 4) == "Sim") {

                    int cod;
                    String nomeDel = null;
                    sysProduDAO prodDel = new sysProduDAO();
                    getset_venda_prdo vendaDel_obj = new getset_venda_prdo();

                    nomeDel = (String)tabela.getModel().getValueAt(i, 0);
                    cod = prodDel.codProduString(nomeDel);

                    vendaDel_obj.setCodigo(cod);
                    vendaDel_obj.setCnpj(usr_obj.getCnpj_emp());

                    System.out.println(vendaDel_obj.getCnpj());
                    System.out.println(vendaDel_obj.getCodigo());

                    prodDel.deleteProd(vendaDel_obj);

                    ((DefaultTableModel) tabela.getModel()).removeRow(i);
                    j = tabela.getRowCount();
                    i = i-1;
                }
            }
            JOptionPane.showMessageDialog(CadOK,"Lista de produtos atualizada!", "Lista atualizada!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void org(){
        int j = tabela.getRowCount();
        if (tabela.getModel().getValueAt(j - 1, 0) != "Selecione o produto") {
            dtm.addRow(new Object[]{"Selecione o produto", "Descrição", "0,00", "0", "Não"});
        }
        for (int i = 0; i < j; i++) {
            String str_qtd = ((String) tabela.getModel().getValueAt(i, 2)).replaceAll(",", ".");
            acumul += Float.parseFloat(str_qtd);
            qtd_atual = acumul;
        }
        acumul = 0;
        if (qtd_atual != ult_qtd) {
            texto_1.setText("Quantidade Total: " + String.valueOf(qtd_atual));
            ult_qtd = qtd_atual;
        }
        for (int i = 0; i < j; i++) {
            String str_valor = ((String) tabela.getModel().getValueAt(i, 2)).replaceAll(",",".");
            String str_qtd = ((String) tabela.getModel().getValueAt(i, 3)).replaceAll(",",".");
            acumul_prc += Float.parseFloat(str_valor)*Float.parseFloat(str_qtd);
            prc_atual = acumul_prc;
        }
        acumul_prc = 0;
        if (prc_atual != ult_prc) {
            texto_2.setText("Preço Total: R$" + String.valueOf(prc_atual).replace(".", ","));
            ult_prc = prc_atual;
        }
    }
}

