package dao;

import clt_sess.getset_comboBox_prdoClt;
import clt_sess.getset_lista_prod_clt;
import clt_sess.getset_listaprod_prdo_clt;
import emp_sess.getset_comboBox_prod;
import emp_sess.getset_venda_prdo;
import factory.ConectionFactory;
import login_sess.getset_form_clt;
import login_sess.getset_form_emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class sysProduDAO {

    public List<getset_comboBox_prod> ler() {
        String sql = "SELECT * FROM produto";

        Connection conn = null;
        PreparedStatement pstm = null;

        List<getset_comboBox_prod> produtos = new ArrayList<>();

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                getset_comboBox_prod produtoBox = new getset_comboBox_prod();
                produtoBox.setCodigo(rs.getInt("codigo"));
                produtoBox.setNome(rs.getString("nome"));
                produtos.add(produtoBox);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return produtos;
    }

    public List<getset_venda_prdo> prod_venda(getset_form_emp usr_obj){
        String sql = "SELECT * FROM venda WHERE cnpj = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        List<getset_venda_prdo> produtosVendaLista = new ArrayList<>();

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, usr_obj.getCnpj_emp());
            System.out.println( usr_obj.getCnpj_emp());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                getset_venda_prdo produtoVendaObj = new getset_venda_prdo();

                produtoVendaObj.setCnpj( rs.getInt("cnpj"));
                produtoVendaObj.setCodigo(rs.getInt("codigo"));
                produtoVendaObj.setQtde(rs.getInt("qtde"));
                produtoVendaObj.setPreco(rs.getDouble("preco"));
                produtoVendaObj.setDescricao(rs.getString("descricao"));

                produtosVendaLista.add(produtoVendaObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return produtosVendaLista;
    }

    public getset_comboBox_prod codProd(getset_comboBox_prod nomeProd) {
        String sql = "SELECT codigo FROM produto WHERE nome = ?";

        getset_comboBox_prod prodCod = new getset_comboBox_prod();

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, nomeProd.getNome());

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                prodCod.setCodigo(rs.getInt("codigo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return prodCod;
        }
    }

    public boolean insert_lista_prd(getset_venda_prdo venda_sess) {

        String sql = "INSERT INTO venda(cnpj, codigo, qtde, preco, descricao) VALUES (?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, venda_sess.getCnpj());
            pstm.setInt(2, venda_sess.getCodigo());
            pstm.setInt(3, venda_sess.getQtde());
            pstm.setDouble(4, venda_sess.getPreco());
            pstm.setString(5, venda_sess.getDescricao());

            pstm.execute();

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public String nomeProd(int codigo){
        
        String sql = "SELECT nome FROM produto WHERE codigo = ?";

        String prodCod = null;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, codigo);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                prodCod = rs.getString("nome");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return prodCod;
        }
    }

    public boolean deleteProd(getset_venda_prdo prodDel){
        String sql = "DELETE FROM venda WHERE cnpj = ? AND codigo = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, prodDel.getCnpj());
            pstm.setInt(2, prodDel.getCodigo());

            pstm.execute();

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int codProduString(String nome){

        String sql = "SELECT codigo FROM produto WHERE nome = ?";

        int prodCod = 0;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, nome);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                prodCod = rs.getInt("codigo");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return prodCod;
        }
    }

    public boolean updateLista(getset_venda_prdo prodAtlz){
        String sql = "UPDATE venda SET qtde = ?, preco = ?, descricao = ? WHERE cnpj = ? AND codigo = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, prodAtlz.getQtde());
            pstm.setDouble(2, prodAtlz.getPreco());
            pstm.setString(3, prodAtlz.getDescricao());

            pstm.setInt(4, prodAtlz.getCnpj());
            pstm.setInt(5, prodAtlz.getCodigo());

            pstm.execute();

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //--------Cliente--------//
    public List<getset_comboBox_prdoClt> ler_clt() {
        String sql = "SELECT * FROM venda";

        Connection conn = null;
        PreparedStatement pstm = null;

        List<getset_comboBox_prdoClt> produtos = new ArrayList<>();

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                getset_comboBox_prdoClt produtoBox = new getset_comboBox_prdoClt();
                produtoBox.setCodigo(rs.getInt("codigo"));
               // System.out.println(produtoBox.getCodigo());
                produtoBox.setNome(rs.getString("descricao"));
               // System.out.println(produtoBox.getNome());
                produtos.add(produtoBox);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return produtos;
    }

    public List<getset_lista_prod_clt> prod_venda_clt(getset_form_clt usr_obj){
        String sql = "SELECT * FROM lista WHERE codigo = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        List<getset_lista_prod_clt> produtosLista = new ArrayList<>();

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, usr_obj.getCodigo_clt());
            System.out.println(usr_obj.getCodigo_clt());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                getset_lista_prod_clt produtoListaObj = new getset_lista_prod_clt();
                produtoListaObj.setNome(rs.getString("nome"));
                produtoListaObj.setPrecoTotal(rs.getFloat("precoTotal"));
                produtoListaObj.setQtdeTotalProdutos(rs.getFloat("qtdeTotalProdutos"));
                produtosLista.add(produtoListaObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return produtosLista;
    }

    public boolean insert_lista_prd_clt(getset_lista_prod_clt lista_sess) {

        String sql = "INSERT INTO lista(nome, qtdeTotalProdutos, precoTotal, codigo) VALUES (?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, lista_sess.getNome());
            pstm.setFloat(2, lista_sess.getQtdeTotalProdutos());
            pstm.setFloat(3, lista_sess.getPrecoTotal());
            pstm.setInt(4, lista_sess.getCodigo());

            pstm.execute();

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String nomeProd_clt(int codigo){

        String sql = "SELECT nome FROM produto WHERE codigo = ?";

        String prodCod = null;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, codigo);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                prodCod = rs.getString("nome");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return prodCod;
        }
    }

    public boolean deleteLista_clt(int row){
        String sql = "DELETE FROM lista WHERE numero = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, row);

            pstm.execute();

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean deleteProdLista_clt(int row){
        String sql = "DELETE FROM listaproduto WHERE numero = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, row);

            pstm.execute();

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public getset_venda_prdo codProduString_clt(String nome){
        String sql = "SELECT * FROM venda WHERE descricao = ?";

        getset_venda_prdo prod = new getset_venda_prdo();

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, nome);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()){
                prod.setCodigo(rs.getInt("codigo"));
                prod.setCnpj(rs.getInt("cnpj"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return prod;
        }
    }

    public boolean updateLista_clt(int num_lista, int cnpj, int codigo_clt, int qtdr_nv){
        String sql = "UPDATE listaproduto SET qtde = ? WHERE numero = ? AND codigo = ? AND cnpj = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            System.out.println(num_lista);
            System.out.println(cnpj);
            System.out.println(codigo_clt);
            System.out.println(qtdr_nv);


            pstm.setInt(1, qtdr_nv);
            pstm.setInt(2, num_lista);
            pstm.setInt(3, codigo_clt);
            pstm.setInt(4, cnpj);

            pstm.execute();

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public boolean updateNomeLista_clt(String nome_lista, int numero){
        String sql = "UPDATE lista SET nome = ? WHERE numero = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, nome_lista);
            pstm.setInt(2, numero);

            pstm.execute();

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int codLista_clt(){

        String sql = "SELECT numero FROM lista ORDER BY numero DESC LIMIT 1";

        int codLista = 0;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                codLista = rs.getInt("numero");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return codLista;
        }
    }

    public int codProduINT_clt(String nome){
        String sql = "SELECT * FROM venda WHERE descricao = ?";

        int codProd = 0;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, nome);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()){
                codProd = rs.getInt("codigo");
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return codProd;
        }
    }

    public boolean insert_listaprd_prod_clt(getset_listaprod_prdo_clt lista_sess) {

        String sql = "INSERT INTO listaproduto(numero, codigo, qtde, cnpj) VALUES (?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, lista_sess.getNumero());
            pstm.setInt(2, lista_sess.getCodigo());
            pstm.setInt(3, lista_sess.getQtde());
            pstm.setInt(4, lista_sess.getCnpj());

            pstm.execute();

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int codListaTable(String nome, int codigo){
        String sql = "SELECT numero FROM lista WHERE nome = ? AND codigo = ?";

        int codLista = 0;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, nome);
            pstm.setInt(2, codigo);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()){
                codLista = rs.getInt("numero");
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return codLista;
        }
    }

    public List<getset_listaprod_prdo_clt> lerListaProduto(int num_lista) {
        String sql = "SELECT * FROM listaproduto WHERE numero = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        List<getset_listaprod_prdo_clt> ListaProdutos = new ArrayList<>();

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, num_lista);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                getset_listaprod_prdo_clt ListaProdutos_Obj = new getset_listaprod_prdo_clt();
                ListaProdutos_Obj.setNumero(rs.getInt("numero"));
                ListaProdutos_Obj.setCodigo(rs.getInt("codigo"));
                ListaProdutos_Obj.setQtde(rs.getInt("qtde"));
                ListaProdutos_Obj.setCnpj(rs.getInt("cnpj"));
                ListaProdutos.add(ListaProdutos_Obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ListaProdutos;
    }

    public int cnpjProduINT_clt(String nome){
        String sql = "SELECT cnpj FROM venda WHERE descricao = ?";

        int cnpjProd = 0;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, nome);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()){
                cnpjProd = rs.getInt("cnpj");
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cnpjProd;
        }
    }

    public String nomeProdVenda(int cnpj, int codigo){
        String sql = "SELECT descricao FROM venda WHERE cnpj = ? AND codigo = ?";

        String codLista = null;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, cnpj);
            pstm.setInt(2, codigo);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()){
                codLista = rs.getString("descricao");
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return codLista;
        }
    }
}
