package dao;

import factory.ConectionFactory;
import login_sess.getset_form_clt;
import login_sess.getset_form_emp;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sysDAO {
    //--------empresa-------//
    public boolean save(getset_form_emp formCadEmp){

        String sql = "INSERT INTO empresa(email, cnpj, nome, senha) VALUES (?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, formCadEmp.getEmail());
            pstm.setInt(2, formCadEmp.getCnpj_emp());
            pstm.setString(3, formCadEmp.getNome_emp());
            pstm.setString(4, formCadEmp.getSenha_emp());

            pstm.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public boolean login(getset_form_emp formCadEmp){

        String sql = "SELECT * FROM empresa WHERE cnpj = ? AND senha = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, formCadEmp.getCnpj_emp());
            pstm.setString(2, formCadEmp.getSenha_emp());

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString("cnpj"));
                System.out.println(rs.getString("senha"));
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }return false;
    }
    public getset_form_emp dados_emp(getset_form_emp formCadEmp){
        String sql = "SELECT * FROM empresa WHERE cnpj = ? AND senha = ?";

        getset_form_emp usr = new getset_form_emp();

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, formCadEmp.getCnpj_emp());
            pstm.setString(2, formCadEmp.getSenha_emp());

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                usr.setCnpj_emp(rs.getString("cnpj"));
                usr.setNome_emp(rs.getString("nome"));
                usr.setEmail(rs.getString("email"));
                usr.setEstado_emp(rs.getString("estado"));
                usr.setCidade_emp(rs.getString("cidade"));
                usr.setBairro_emp(rs.getString("bairro"));
                usr.setLogradouro_emp(rs.getString("logradouro"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return usr;
        }
    }
    public void update(getset_form_emp formCadEmp){

        String sql = "UPDATE empresa SET nome = ?, email = ?, estado = ?, cidade = ?, bairro = ?, logradouro = ? WHERE cnpj = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, formCadEmp.getNome_emp());
            pstm.setString(2, formCadEmp.getEmail());
            pstm.setString(3, formCadEmp.getEstado_emp());
            pstm.setString(4, formCadEmp.getCidade_emp());
            pstm.setString(5, formCadEmp.getBairro_emp());
            pstm.setString(6, formCadEmp.getLogradouro_emp());

            pstm.setInt(7, formCadEmp.getCnpj_emp());

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void updateSenha(getset_form_emp formCadEmp){

        String sql = "UPDATE empresa SET senha = ? WHERE cnpj = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, formCadEmp.getSenha_emp());

            pstm.setInt(2, formCadEmp.getCnpj_emp());

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public boolean saveImgPerfil(getset_form_emp usr_obj, String caminho){

        String sql = "UPDATE empresa SET imagem = ? WHERE cnpj = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            InputStream imgfinal = new FileInputStream(new File(caminho));
            pstm.setBlob(1, imgfinal);
            pstm.setInt(2, usr_obj.getCnpj_emp());
            pstm.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public getset_form_emp carrImgPerfil(getset_form_emp usr_obj){

        String sql = "SELECT imagem FROM empresa WHERE cnpj = ?";

        getset_form_emp usr = new getset_form_emp();

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, usr_obj.getCnpj_emp());
            ResultSet rs = pstm.executeQuery();

            File arquivo = new File ("perfil.png");
            FileOutputStream output = new FileOutputStream(arquivo);

            if (rs.next()) {
                InputStream input = rs.getBinaryStream("imagem");
                byte[] buffer = new byte[1024];
                while (input.read(buffer)>0){
                    output.write(buffer);
                }
                String caminho = arquivo.getAbsolutePath();
                ImageIcon perfilIcon = new ImageIcon(caminho);
                usr.setPerfilIcon(perfilIcon);
            }
            return usr;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    //--------cliente-------//
    public boolean cad_cliente(getset_form_clt formCadClt){

        String sql = "INSERT INTO cliente(email, nome, senha) VALUES (?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, formCadClt.getEmail_clt());
            pstm.setString(2, formCadClt.getNome_clt());
            pstm.setString(3, formCadClt.getSenha_clt());

            pstm.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public boolean login_cliente(getset_form_clt formCadClt){

        String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, formCadClt.getEmail_clt());
            pstm.setString(2, formCadClt.getSenha_clt());

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("senha"));
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }return false;
    }
    public getset_form_clt dados_clt(getset_form_clt formCltEmp){
        String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";

        getset_form_clt usr = new getset_form_clt();

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, formCltEmp.getEmail_clt());
            pstm.setString(2, formCltEmp.getSenha_clt());

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                usr.setCodigo_clt(rs.getInt("codigo"));
                usr.setNome_clt(rs.getString("nome"));
                usr.setEmail_clt(rs.getString("email"));
                usr.setEstado_clt(rs.getString("estado"));
                usr.setCidade_clt(rs.getString("cidade"));
                usr.setBairro_clt(rs.getString("bairro"));
                usr.setLogradouro_clt(rs.getString("logradouro"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return usr;
        }
    }
    public void update_clt(getset_form_clt formCadClt){

        String sql = "UPDATE cliente SET nome = ?, email = ?, estado = ?, cidade = ?, bairro = ?, logradouro = ? WHERE codigo = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, formCadClt.getNome_clt());
            pstm.setString(2, formCadClt.getEmail_clt());
            pstm.setString(3, formCadClt.getEstado_clt());
            pstm.setString(4, formCadClt.getCidade_clt());
            pstm.setString(5, formCadClt.getBairro_clt());
            pstm.setString(6, formCadClt.getLogradouro_clt());

            pstm.setInt(7, formCadClt.getCodigo_clt());

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void updateSenha_clt(getset_form_clt formCadClt){

        String sql = "UPDATE cliente SET senha = ? WHERE codigo = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, formCadClt.getSenha_clt());

            pstm.setInt(2, formCadClt.getCodigo_clt());

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public boolean saveImgPerfil_clt(getset_form_clt usr_obj, String caminho){

        String sql = "UPDATE cliente SET imagem = ? WHERE codigo = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            InputStream imgfinal = new FileInputStream(new File(caminho));
            pstm.setBlob(1, imgfinal);
            pstm.setInt(2, usr_obj.getCodigo_clt());
            pstm.execute();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public getset_form_clt carrImgPerfil_clt(getset_form_clt usr_obj){

        String sql = "SELECT imagem FROM cliente WHERE codigo = ?";

        getset_form_clt usr = new getset_form_clt();

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, usr_obj.getCodigo_clt());
            ResultSet rs = pstm.executeQuery();

            File arquivo = new File ("perfil.png");
            FileOutputStream output = new FileOutputStream(arquivo);

            if (rs.next()) {
                InputStream input = rs.getBinaryStream("imagem");
                byte[] buffer = new byte[1024];
                while (input.read(buffer)>0){
                    output.write(buffer);
                }
                String caminho = arquivo.getAbsolutePath();
                ImageIcon perfilIcon = new ImageIcon(caminho);
                usr.setPerfilIcon_clt(perfilIcon);
            }
            return usr;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}