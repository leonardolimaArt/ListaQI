package clt_sess;

import dao.sysProduDAO;
import emp_sess.getset_comboBox_prod;
import emp_sess.getset_venda_prdo;
import login_sess.getset_form_clt;

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

public class clt_produtos extends JFrame implements ActionListener{
    public JButton Atualizar_b, Atualizar_edt_b, Adicionar_b, Voltar_edt_b, Atualizar_nv_b, Voltar_nv_b, Exc_nv_b, Demo_b;
    public JPanel clt_prod, clt_edt_produ, clt_nova_produ;

    float acumul_prc, ult_prc, prc_atual, acumul, ult_qtd, qtd_atual;
    float acumul_prc_2, ult_prc_2, prc_atual_2, acumul_2, ult_qtd_2, qtd_atual_2;
    float acumul_prc_3, ult_prc_3, prc_atual_3, acumul_3, ult_qtd_3, qtd_atual_3;

    JLabel texto_1, texto_2, texto_5, texto_6, texto_9, texto_10, texto_4;
    JTable tabela, tabela_2, tabela_3;
    DefaultTableModel dtm, dtm_2, dtm_3;
    JScrollPane scrollPane, scrollPane_2, scrollPane_3;

    JTextField field_0, field_1;
    getset_form_clt usr_obj;
    final JFrame CadOK = new JFrame();
    public clt_produtos(JPanel clt_prod_g, JPanel clt_edt_produ_g, JPanel clt_nv_produ_g, getset_form_clt usr) {
        this.clt_prod = clt_prod_g;
        this.clt_edt_produ = clt_edt_produ_g;
        this.clt_nova_produ = clt_nv_produ_g;
        this.usr_obj = usr;

        clt_prod.setLayout(null);
        clt_prod.setVisible(false);
        clt_prod.setBackground(Color.white);
        clt_prod.setBounds(0, 28, 924, 480);

        JLabel texto_0 = new JLabel("Sua lista de produtos, ");
        texto_0.setBounds(60, 15, 180, 40);
        texto_0.setForeground(Color.black);
        texto_0.setFont(new Font("Arial", Font.BOLD, 16));
        clt_prod.add(texto_0);

        JLabel texto_0_1 = new JLabel(" "+usr_obj.getNome_clt());
        texto_0_1.setBounds(230, 15, 180, 40);
        texto_0_1.setForeground(Color.black);
        texto_0_1.setFont(new Font("Arial", Font.ITALIC, 16));
        clt_prod.add(texto_0_1);

        String[] columnNames = {"Lista", "Preço Total - R$", "Total Produtos", "Excluir"};

        tabela = new JTable();
        dtm = new DefaultTableModel(0, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return column == 3;
            }
        };
        dtm.setColumnIdentifiers(columnNames);
        tabela.setModel(dtm);

        atzlListaClt();

        tabela.setPreferredScrollableViewportSize(new Dimension(500, 50));
        tabela.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(60,70,790,330);
        scrollPane.setVisible(true);
        scrollPane.setViewportBorder(null);

        clt_prod.add(scrollPane);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));
        tabela.getTableHeader().setPreferredSize(new Dimension(70,30));
        tabela.getColumnModel().getColumn(0).setPreferredWidth(300);
        tabela.setRowHeight(30);
        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setForeground(Color.white);
        tabela.getTableHeader().setBackground(new Color(44,44,44));

        TableColumn excluir_column = tabela.getColumnModel().getColumn(3);
        JComboBox<String> comboBox_excluir = new JComboBox<>();
        comboBox_excluir.addItem("Sim");
        comboBox_excluir.addItem("Não");
        excluir_column.setCellEditor(new DefaultCellEditor(comboBox_excluir));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        tabela.setDefaultRenderer(Object.class, centerRenderer);

        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                org_list_prdo();
            }
        });

        tabela.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                Point point = mouseEvent.getPoint();
                int row = tabela.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && tabela.getSelectedRow() != -1) {

                    sysProduDAO ListaEdit = new sysProduDAO();
                    System.out.println(row);
                    int num_lista = ListaEdit.codListaTable((String)tabela.getModel().getValueAt(row, 0), usr_obj.getCodigo_clt());

                    clt_edt_produ.setVisible(true);
                    clt_prod.setVisible(false);
                    field_1.setText((String)tabela.getModel().getValueAt(row, 0));

                    texto_4.setText("Lista Nº " + num_lista);

                    atzListaEdit(num_lista);
                    org_prdo_edt();
                }
            }
        });

        Atualizar_b = new JButton("Atualizar");
        Atualizar_b.addActionListener(this);
        Atualizar_b.setFocusPainted(false);
        Atualizar_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Atualizar_b.setBackground(new Color(255,118,118));
        Atualizar_b.setForeground(Color.white);
        clt_prod.add(Atualizar_b);
        Atualizar_b.setBounds(803,405,95,40);

        Adicionar_b = new JButton("Nova Lista");
        Adicionar_b.addActionListener(this);
        Adicionar_b.setFocusPainted(false);
        Adicionar_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Adicionar_b.setBackground(new Color(84, 186, 255));
        Adicionar_b.setForeground(Color.white);
        clt_prod.add(Adicionar_b);
        Adicionar_b.setBounds(698,405,95,40);

        texto_1 = new JLabel("Quantidade Total: ");
        texto_1.setBounds(60, 405, 180, 40);
        texto_1.setForeground(Color.black);
        texto_1.setFont(new Font("Arial", Font.BOLD, 12));
        clt_prod.add(texto_1);

        texto_2 = new JLabel("Preço Total: R$");
        texto_2.setBounds(250, 405, 180, 40);
        texto_2.setForeground(Color.black);
        texto_2.setFont(new Font("Arial", Font.BOLD, 12));
        clt_prod.add(texto_2);

        /*-------------------------------clt_edt_prod-------------------------------*/
        clt_edt_produ.setLayout(null);
        clt_edt_produ.setVisible(false);
        clt_edt_produ.setBackground(Color.white);
        clt_edt_produ.setBounds(0, 28, 924, 480);

        JLabel texto_3 = new JLabel("Nome da lista:");
        texto_3.setBounds(60, 5, 180, 40);
        texto_3.setForeground(Color.black);
        texto_3.setFont(new Font("Arial", Font.BOLD, 14));
        clt_edt_produ.add(texto_3);

        field_1 = new JTextField(17);
        field_1.setBorder(new MatteBorder(0,0,1,0,Color.black));
        clt_edt_produ.add(field_1);
        field_1.setBounds(60,35,277,20);

        texto_4 = new JLabel("Nº");
        texto_4.setBounds(698, 15, 180, 40);
        texto_4.setForeground(Color.black);
        texto_4.setFont(new Font("Arial", Font.PLAIN, 16));
        clt_edt_produ.add(texto_4);

        String[] columnNames_edt = {"Produto", "Descrição", "Preço - R$", "Quantidade", "Excluir"};



        tabela_2 = new JTable();
        dtm_2 = new DefaultTableModel(0, 0);
        dtm_2.setColumnIdentifiers(columnNames_edt);
        tabela_2.setModel(dtm_2);

        tabela_2.setPreferredScrollableViewportSize(new Dimension(500, 50));
        tabela_2.setFillsViewportHeight(true);
        scrollPane_2 = new JScrollPane(tabela_2);
        scrollPane_2.setBounds(60,70,790,330);
        scrollPane_2.setVisible(true);
        scrollPane_2.setViewportBorder(null);

        clt_edt_produ.add(scrollPane_2);
        tabela_2.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));
        tabela_2.getTableHeader().setPreferredSize(new Dimension(70,30));
        tabela_2.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabela_2.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabela_2.setRowHeight(30);
        tabela_2.setShowVerticalLines(false);
        tabela_2.getTableHeader().setOpaque(false);
        tabela_2.getTableHeader().setForeground(Color.white);
        tabela_2.getTableHeader().setBackground(new Color(44,44,44));

        TableColumn produto_column = tabela_2.getColumnModel().getColumn(0);
        JComboBox<String> comboBox_produto = new JComboBox<>();
        sysProduDAO prodDAO_0 = new sysProduDAO();

        for(getset_comboBox_prdoClt p_0: prodDAO_0.read_clt()){
            comboBox_produto.addItem(p_0.getNome());
        }
        produto_column.setCellEditor(new DefaultCellEditor(comboBox_produto));

        TableColumn excluir_column_2 = tabela_2.getColumnModel().getColumn(4);
        JComboBox<String> comboBox_excluir_2 = new JComboBox<>();
        comboBox_excluir_2.addItem("Sim");
        comboBox_excluir_2.addItem("Não");
        excluir_column_2.setCellEditor(new DefaultCellEditor(comboBox_excluir_2));

        DefaultTableCellRenderer centerRenderer_2 = new DefaultTableCellRenderer();
        centerRenderer_2.setHorizontalAlignment( SwingConstants.CENTER );
        tabela_2.setDefaultRenderer(Object.class, centerRenderer_2);

        dtm_2.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(dtm_2.getRowCount() != 0) {
                    org_prdo_edt();
                }
            }
        });
        dtm_2.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                org_prdo_nv();

                if(e.getColumn() == 0) {
                    sysProduDAO rowatz = new sysProduDAO();
                    getset_venda_prdo atzprod;

                    int row = e.getFirstRow();

                    atzprod = rowatz.codProduString_clt((String) tabela_2.getModel().getValueAt(row, 0));
                    tabela_2.getModel().setValueAt(rowatz.nomeProd_clt(atzprod.getCodigo()), row, 1);
                    tabela_2.getModel().setValueAt(String.valueOf(atzprod.getPreco()).replace(".", ","), row, 2);

                }
            }
        });

        Atualizar_edt_b = new JButton("Atualizar");
        Atualizar_edt_b.addActionListener(this);
        Atualizar_edt_b.setFocusPainted(false);
        Atualizar_edt_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Atualizar_edt_b.setBackground(new Color(255,118,118));
        Atualizar_edt_b.setForeground(Color.white);
        clt_edt_produ.add(Atualizar_edt_b);
        Atualizar_edt_b.setBounds(803,405,95,40);

        Voltar_edt_b = new JButton("Voltar");
        Voltar_edt_b.addActionListener(this);
        Voltar_edt_b.setFocusPainted(false);
        Voltar_edt_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Voltar_edt_b.setBackground(new Color(84, 186, 255));
        Voltar_edt_b.setForeground(Color.white);
        clt_edt_produ.add(Voltar_edt_b);
        Voltar_edt_b.setBounds(698,405,95,40);

        texto_5 = new JLabel("Quantidade Total: ");
        texto_5.setBounds(60, 405, 180, 40);
        texto_5.setForeground(Color.black);
        texto_5.setFont(new Font("Arial", Font.BOLD, 12));
        clt_edt_produ.add(texto_5);

        texto_6 = new JLabel("Preço Total: R$");
        texto_6.setBounds(250, 405, 180, 40);
        texto_6.setForeground(Color.black);
        texto_6.setFont(new Font("Arial", Font.BOLD, 12));
        clt_edt_produ.add(texto_6);

        /*-------------------------------clt_nova_prod-------------------------------*/
        clt_nova_produ.setLayout(null);
        clt_nova_produ.setVisible(false);
        clt_nova_produ.setBackground(Color.white);
        clt_nova_produ.setBounds(0, 28, 924, 480);

        JLabel texto_7 = new JLabel("Nome da nova lista:");
        texto_7.setBounds(60, 5, 180, 40);
        texto_7.setForeground(Color.black);
        texto_7.setFont(new Font("Arial", Font.BOLD, 14));
        clt_nova_produ.add(texto_7);

        field_0 = new JTextField(17);
        field_0.setBorder(new MatteBorder(0,0,1,0,Color.black));
        clt_nova_produ.add(field_0);
        field_0.setBounds(60,35,277,20);

        String[] columnNames_nv = {"Produto", "Descrição", "Preço - R$", "Quantidade", "Excluir"};

        tabela_3 = new JTable();
        dtm_3 = new DefaultTableModel(0, 0);
        dtm_3.setColumnIdentifiers(columnNames_nv);
        tabela_3.setModel(dtm_3);

        tabela_3.setPreferredScrollableViewportSize(new Dimension(500, 50));
        tabela_3.setFillsViewportHeight(true);
        scrollPane_3 = new JScrollPane(tabela_3);
        scrollPane_3.setBounds(60,70,790,330);
        scrollPane_3.setVisible(true);
        scrollPane_3.setViewportBorder(null);

        clt_nova_produ.add(scrollPane_3);
        tabela_3.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));
        tabela_3.getTableHeader().setPreferredSize(new Dimension(70,30));
        tabela_3.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabela_3.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabela_3.setRowHeight(30);
        tabela_3.setShowVerticalLines(false);
        tabela_3.getTableHeader().setOpaque(false);
        tabela_3.getTableHeader().setForeground(Color.white);
        tabela_3.getTableHeader().setBackground(new Color(44,44,44));
        dtm_3.addRow(new Object[]{"Selecione o produto", "Descrição", "0,00", "0", "Não"});

        TableColumn produto_column_2 = tabela_3.getColumnModel().getColumn(0);
        JComboBox<String> comboBox_produto_2 = new JComboBox<>();
        sysProduDAO prodDAO = new sysProduDAO();

        for(getset_comboBox_prdoClt p: prodDAO.read_clt()){
            comboBox_produto_2.addItem(p.getNome());
        }

        produto_column_2.setCellEditor(new DefaultCellEditor(comboBox_produto_2));

        TableColumn excluir_column_3 = tabela_3.getColumnModel().getColumn(4);
        JComboBox<String> comboBox_excluir_3 = new JComboBox<>();
        comboBox_excluir_3.addItem("Sim");
        comboBox_excluir_3.addItem("Não");
        excluir_column_3.setCellEditor(new DefaultCellEditor(comboBox_excluir_3));

        DefaultTableCellRenderer centerRenderer_3 = new DefaultTableCellRenderer();
        centerRenderer_3.setHorizontalAlignment( SwingConstants.CENTER );
        tabela_3.setDefaultRenderer(Object.class, centerRenderer_3);


        dtm_3.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                org_prdo_nv();

                if(e.getColumn() == 0) {
                    sysProduDAO rowatz = new sysProduDAO();
                    getset_venda_prdo atzprod;

                    int row = e.getFirstRow();

                    atzprod = rowatz.codProduString_clt((String) tabela_3.getModel().getValueAt(row, 0));
                    tabela_3.getModel().setValueAt(rowatz.nomeProd_clt(atzprod.getCodigo()), row, 1);
                    tabela_3.getModel().setValueAt(String.valueOf(atzprod.getPreco()).replace(".", ","), row, 2);

                }
            }
        });


        Atualizar_nv_b = new JButton("Criar");
        Atualizar_nv_b.addActionListener(this);
        Atualizar_nv_b.setFocusPainted(false);
        Atualizar_nv_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Atualizar_nv_b.setBackground(new Color(255,118,118));
        Atualizar_nv_b.setForeground(Color.white);
        clt_nova_produ.add(Atualizar_nv_b);
        Atualizar_nv_b.setBounds(803,405,95,40);

        Exc_nv_b = new JButton("Excluir");
        Exc_nv_b.addActionListener(this);
        Exc_nv_b.setFocusPainted(false);
        Exc_nv_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Exc_nv_b.setBackground(new Color(255,118,118));
        Exc_nv_b.setForeground(Color.white);
        clt_nova_produ.add(Exc_nv_b);
        Exc_nv_b.setBounds(698,405,95,40);

        Voltar_nv_b = new JButton("Voltar");
        Voltar_nv_b.addActionListener(this);
        Voltar_nv_b.setFocusPainted(false);
        Voltar_nv_b.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        Voltar_nv_b.setBackground(new Color(255,118,118));
        Voltar_nv_b.setForeground(Color.white);
        clt_nova_produ.add(Voltar_nv_b);
        Voltar_nv_b.setBounds(593,405,95,40);

        texto_9 = new JLabel("Quantidade Total: ");
        texto_9.setBounds(60, 405, 180, 40);
        texto_9.setForeground(Color.black);
        texto_9.setFont(new Font("Arial", Font.BOLD, 12));
        clt_nova_produ.add(texto_9);

        texto_10 = new JLabel("Preço Total: R$");
        texto_10.setBounds(250, 405, 180, 40);
        texto_10.setForeground(Color.black);
        texto_10.setFont(new Font("Arial", Font.BOLD, 12));
        clt_nova_produ.add(texto_10);

        org_list_prdo();

        //org_prdo_edt();
        org_prdo_nv();
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        int j = tabela.getRowCount();
        int j_3 = tabela_3.getRowCount();
        if (e.getSource() == Atualizar_nv_b) {
            if(field_0.getDocument().getLength() > 5 && tabela_3.getModel().getValueAt(0, 0) != "Selecione o produto") {
                sysProduDAO prodNV_sess = new sysProduDAO();
                getset_lista_prod_clt prodNv = new getset_lista_prod_clt();

                prodNv.setNome(field_0.getText());
                prodNv.setCodigo(usr_obj.getCodigo_clt());
                prodNv.setQtdeTotalProdutos(qtd_atual_3);
                prodNv.setPrecoTotal(prc_atual_3);
                prodNV_sess.insert_lista_prd_clt(prodNv);

                for (int i = 0; i < j_3; i++) {
                    if (tabela_3.getModel().getValueAt(i, 0) != "Selecione o produto") {
                        getset_listaprod_prdo_clt listaprdoNv = new getset_listaprod_prdo_clt();
                        listaprdoNv.setNumero(prodNV_sess.codLista_clt());
                        listaprdoNv.setCodigo(prodNV_sess.codProduINT_clt((String) tabela_3.getModel().getValueAt(i, 0)));
                        listaprdoNv.setQtde(Integer.parseInt((String) tabela_3.getModel().getValueAt(i, 3)));
                        listaprdoNv.setCnpj(prodNV_sess.cnpjProduINT_clt((String) tabela_3.getModel().getValueAt(i, 0)));
                        prodNV_sess.insert_listaprd_prod_clt(listaprdoNv);
                    }
                }
                clt_nova_produ.setVisible(false);
                clt_prod.setVisible(true);
                atzlListaClt();
            }else{
                JOptionPane.showMessageDialog(CadOK,"Por favor, inclua um nome com mais de 5 caracteres para a lista e inclua pelo menos um produto.", "Verifique os campos", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == Adicionar_b) {
            clt_nova_produ.setVisible(true);
            clt_prod.setVisible(false);
            int j_5 = tabela_3.getRowCount();
            field_0.setText("");
            for (int i = 0; i < j_5; i++) {
                if (tabela_3.getModel().getValueAt(i, 0) != "Selecione o produto") {
                    ((DefaultTableModel) tabela_3.getModel()).removeRow(i);
                    j_5 = tabela_3.getRowCount();
                    i = i-1;
                }
            }
        }
        if (e.getSource() == Atualizar_b) {
            j = tabela.getRowCount();
            for (int i = 0; i < j; i++) {
                if (tabela.getModel().getValueAt(i, 3) == "Sim") {
                    ((DefaultTableModel) tabela.getModel()).removeRow(i);
                    j = tabela.getRowCount();
                    i = i-1;
                }
            }
        }
        if (e.getSource() == Atualizar_edt_b) {
            j = tabela_2.getRowCount();
            if(tabela_2.getModel().getValueAt(j-1, 4) == "Sim") {
                dtm_2.addRow(new Object[]{"Selecione o produto", "Descrição", "0,00", "0", "Não"});
            }
            for (int i = 0; i < j; i++) {
                if (tabela_2.getModel().getValueAt(i, 4) == "Sim") {
                    ((DefaultTableModel) tabela_2.getModel()).removeRow(i);
                    j = tabela_2.getRowCount();
                    i = i-1;
                }
            }
        }
        if (e.getSource() == Voltar_edt_b) {
            clt_edt_produ.setVisible(false);
            clt_prod.setVisible(true);
        }
        if (e.getSource() == Voltar_nv_b) {
            clt_nova_produ.setVisible(false);
            clt_prod.setVisible(true);
        }

        if (e.getSource() == Exc_nv_b) {
            j = tabela_3.getRowCount();
            if(tabela_3.getModel().getValueAt(j-1, 4) == "Sim") {
                dtm_3.addRow(new Object[]{"Selecione o produto", "Descrição", "0,00", "0", "Não"});
            }
            for (int i = 0; i < j; i++) {
                if (tabela_3.getModel().getValueAt(i, 4) == "Sim") {
                    ((DefaultTableModel) tabela_3.getModel()).removeRow(i);
                    j = tabela_3.getRowCount();
                    i = i-1;
                }
            }
        }
    }
    public void org_list_prdo(){
        int j = tabela.getRowCount();
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
            String str_valor = ((String) tabela.getModel().getValueAt(i, 1)).replaceAll(",", ".");
            acumul_prc += Float.parseFloat(str_valor);
            prc_atual = acumul_prc;
        }
        acumul_prc = 0;
        if (prc_atual != ult_prc) {
            texto_2.setText("Preço Total: R$" + String.valueOf(prc_atual));
            ult_prc = prc_atual;
        }
    }
    public void org_prdo_edt(){
        int j = tabela_2.getRowCount();
        /*if (tabela_2.getModel().getValueAt(j - 1, 0) != "Selecione o produto") {
            dtm_2.addRow(new Object[]{"Selecione o produto", "Descrição", "0,00", "0", "Não"});
        }*/
        for (int i = 0; i < j; i++) {
            String str_qtd = ((String) tabela_2.getModel().getValueAt(i, 3)).replaceAll(",", ".");
            acumul_2 += Float.parseFloat(str_qtd);
            qtd_atual_2 = acumul_2;
        }
        acumul_2 = 0;
        if (qtd_atual_2 != ult_qtd_2) {
            texto_5.setText("Quantidade Total: " + String.valueOf(qtd_atual_2));
            ult_qtd_2 = qtd_atual_2;
        }
        for (int i = 0; i < j; i++) {
            String str_valor = ((String) tabela_2.getModel().getValueAt(i, 2)).replaceAll(",", ".");
            String str_qtd = ((String) tabela_2.getModel().getValueAt(i, 3)).replaceAll(",", ".");
            acumul_prc_2 += Float.parseFloat(str_valor) * Float.parseFloat(str_qtd);
            prc_atual_2 = acumul_prc_2;
        }
        acumul_prc_2 = 0;
        if (prc_atual_2 != ult_prc_2) {
            texto_6.setText("Preço Total: R$" + String.valueOf(prc_atual_2));
            ult_prc_2 = prc_atual_2;
        }
    }
    public void org_prdo_nv(){
        int j = tabela_3.getRowCount();
        if (tabela_3.getModel().getValueAt(j - 1, 0) != "Selecione o produto") {
            dtm_3.addRow(new Object[]{"Selecione o produto", "Descrição", "0,00", "0", "Não"});
        }
        for (int i = 0; i < j; i++) {
            String str_qtd = ((String) tabela_3.getModel().getValueAt(i, 3)).replaceAll(",", ".");
            acumul_3 += Float.parseFloat(str_qtd);
            qtd_atual_3 = acumul_3;
        }
        acumul_3 = 0;
        if (qtd_atual_3 != ult_qtd_3) {
            texto_9.setText("Quantidade Total: " + String.valueOf(qtd_atual_3));
            ult_qtd_3 = qtd_atual_3;
        }
        for (int i = 0; i < j; i++) {
            String str_valor = ((String) tabela_3.getModel().getValueAt(i, 2)).replaceAll(",", ".");
            String str_qtd = ((String) tabela_3.getModel().getValueAt(i, 3)).replaceAll(",", ".");
            acumul_prc_3 += Float.parseFloat(str_valor) * Float.parseFloat(str_qtd);
            prc_atual_3 = acumul_prc_3;
        }
        acumul_prc_3 = 0;
        if (prc_atual_3 != ult_prc_3) {
            texto_10.setText("Preço Total: R$" + String.valueOf(prc_atual_3));
            ult_prc_3 = prc_atual_3;
        }
    }
    public void atzlListaClt(){
        dtm.setRowCount(0);
        sysProduDAO prod_listaDAO = new sysProduDAO();
        for(getset_lista_prod_clt p: prod_listaDAO.prod_venda_clt(usr_obj)){
            dtm.addRow(new Object[] {p.getNome(), String.valueOf(p.getPrecoTotal()), String.valueOf(p.getQtdeTotalProdutos()), "Não"});
        }
    }
    public void atzListaEdit(int num_lista){
        dtm_2.setRowCount(0);
        sysProduDAO listaEdit_sess = new sysProduDAO();
        for(getset_listaprod_prdo_clt listaEdit: listaEdit_sess.lerListaProduto(num_lista)){
            getset_venda_prdo prodVend;
            prodVend = listaEdit_sess.codProduString_clt(listaEdit_sess.nomeProdVenda(listaEdit.getCnpj(), listaEdit.getCodigo()));
            dtm_2.addRow(new Object[] {listaEdit_sess.nomeProdVenda(listaEdit.getCnpj(), listaEdit.getCodigo()), listaEdit_sess.nomeProd_clt(listaEdit.getCodigo()), String.valueOf(prodVend.getPreco()), String.valueOf(listaEdit.getQtde()), "Não"});
        }
    }
}

