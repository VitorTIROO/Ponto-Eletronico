package br.com.ifmt.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitor Santos
 */
@Entity
@Table(name = "roupa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roupa.findAll", query = "SELECT r FROM Roupa r")
    , @NamedQuery(name = "Roupa.findByIdroupa", query = "SELECT r FROM Roupa r WHERE r.idroupa = :idroupa")
    , @NamedQuery(name = "Roupa.findByDescricao", query = "SELECT r FROM Roupa r WHERE r.descricao = :descricao")
    , @NamedQuery(name = "Roupa.findByValor", query = "SELECT r FROM Roupa r WHERE r.valor = :valor")
    , @NamedQuery(name = "Roupa.findByStatus", query = "SELECT r FROM Roupa r WHERE r.status = :status")
    , @NamedQuery(name = "Roupa.findBySetor", query = "SELECT r FROM Roupa r WHERE r.setor = :setor")
    , @NamedQuery(name = "Roupa.findByCor", query = "SELECT r FROM Roupa r WHERE r.cor = :cor")
    , @NamedQuery(name = "Roupa.findByTecido", query = "SELECT r FROM Roupa r WHERE r.tecido = :tecido")
    , @NamedQuery(name = "Roupa.findByTipo", query = "SELECT r FROM Roupa r WHERE r.tipo = :tipo")})
public class Roupa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDROUPA")
    private Integer idroupa;
    @Column(name = "DESCRICAO")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private Double valor;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "SETOR")
    private String setor;
    @Column(name = "COR")
    private String cor;
    @Column(name = "TECIDO")
    private String tecido;
    @Column(name = "TIPO")
    private String tipo;

    public Roupa() {
    }

    public Roupa(Integer idroupa) {
        this.idroupa = idroupa;
    }

    public Integer getIdroupa() {
        return idroupa;
    }

    public void setIdroupa(Integer idroupa) {
        this.idroupa = idroupa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTecido() {
        return tecido;
    }

    public void setTecido(String tecido) {
        this.tecido = tecido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idroupa != null ? idroupa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roupa)) {
            return false;
        }
        Roupa other = (Roupa) object;
        if ((this.idroupa == null && other.idroupa != null) || (this.idroupa != null && !this.idroupa.equals(other.idroupa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifmt.model.Roupa[ idroupa=" + idroupa + " ]";
    }

}//class
