package login_sess;

import javax.swing.*;

public class getset_form_emp {

    String email_emp;
    String nome_emp;
    String senha_emp;
    String estado_emp;
    String cidade_emp;
    String bairro_emp;
    String logradouro_emp;
    ImageIcon perfilIcon;
    int cnpj_emp;

    public ImageIcon getPerfilIcon() {
        return perfilIcon;
    }

    public void setPerfilIcon(ImageIcon perfilIcon) {
        this.perfilIcon = perfilIcon;
    }

    public String getEstado_emp() {
        return estado_emp;
    }

    public void setEstado_emp(String estado_emp) {
        this.estado_emp = estado_emp;
    }

    public String getCidade_emp() {
        return cidade_emp;
    }

    public void setCidade_emp(String cidade_emp) {
        this.cidade_emp = cidade_emp;
    }

    public String getBairro_emp() {
        return bairro_emp;
    }

    public void setBairro_emp(String bairro_emp) {
        this.bairro_emp = bairro_emp;
    }

    public String getLogradouro_emp() {
        return logradouro_emp;
    }

    public void setLogradouro_emp(String logradouro_emp) {
        this.logradouro_emp = logradouro_emp;
    }

    public int getCnpj_emp() {
        return cnpj_emp;
    }

    public void setCnpj_emp(String cnpj_emp) {
        this.cnpj_emp = Integer.parseInt(cnpj_emp);
    }

    public String getNome_emp() {
        return nome_emp;
    }

    public void setNome_emp(String nome_emp) {
        this.nome_emp = nome_emp;
    }

    public String getSenha_emp() {
        return senha_emp;
    }

    public void setSenha_emp(String senha_emp) {
        this.senha_emp = senha_emp;
    }

    public String getEmail() {
        return email_emp;
    }

    public void setEmail(String email) {
        this.email_emp = email;
    }
}
