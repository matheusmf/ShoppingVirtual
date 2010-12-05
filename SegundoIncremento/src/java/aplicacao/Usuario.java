/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacao;

import controladoresJpa.UsuarioJpaController;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Raul Lermen
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_usuario")
    private int id;
    private String email;
    private String senha;
    private String telefone;
    private String celular;
    @OneToOne
    private Pessoa pessoa;
    @OneToOne
    private Endereco endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplicacao.Usuario[id=" + id + "]";
    }

    public static void main(String[] args) throws Exception{
        UsuarioJpaController usuarioJpa = new UsuarioJpaController();

        ShoppingVirtual.getInstancia().cadastraUsuario("raul@msn.com", "123", "3345", "8878", "Raul", "021", "31/03", "M", "rua 1", "2", "vilas", "Lauro", "bahia", "cep", "brasil");

        //Usuario usuario = usuarioJpa.findUsuario(1);

        //ShoppingVirtual.getInstancia().editaUsuario(usuario, "matheus@msn.com", "123", "3345", "8878", "Matheus", "021", "31/03", "M", "rua 1", 2, "vilas", "Lauro", "bahia", "cep", "brasil");
    }


}
