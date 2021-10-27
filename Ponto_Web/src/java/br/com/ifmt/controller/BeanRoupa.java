package br.com.ifmt.controller;

import br.com.ifmt.dao.InterfaceRoupa;
import br.com.ifmt.dao.RoupaDAO;
import br.com.ifmt.model.Roupa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Vitor Santos
 */
@ManagedBean(name = "ctrlRoupa")
@SessionScoped
public class BeanRoupa {

    public BeanRoupa() {
    }

    public void btLimpar() {
        limpaCampo();
    }

    public void btGravar(ActionEvent ae) {
        Roupa roupa = new Roupa();

        roupa.setCor(getCor());
        roupa.setDescricao(getDescricao());
        roupa.setSetor(getSetor());
        roupa.setStatus(getStatus());
        roupa.setValor(getValor());
        roupa.setTecido(getTecido());
        roupa.setTipo(getTipo());

        roupaDAO.inserirRoupa(roupa);
        mensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
        limpaCampo();
    }

    public void btAtualizar(ActionEvent ae) {
        roupaDAO.atualizaRoupa(roupa);
        mensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro atualizado com sucesso!", ""));
        fechaDialog();

    }//btAtualizar

    public void btRemover(ActionEvent ae) {
        mensagem(new FacesMessage(null, "Botão remover"));
        roupa = (Roupa) (dataModelRoupa.getRowData());
        System.out.println("Descrição: " + roupa.getDescricao()+"\nTipo: "+ roupa.getTipo());
        mensagem(new FacesMessage(null, "Botão remove2"));
        roupaDAO.excluirRoupa(roupa);
        mensagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro removido com sucesso!", ""));
    }//btRemover

    public DataModel btBuscar(ActionEvent ae) {
        List<Roupa> listaCache = new RoupaDAO().buscaRoupa(getNomeColuna());

        dataModelRoupa = new ListDataModel(listaCache);

        return dataModelRoupa;
    }

    private void limpaCampo() {
        setCor("");
        setDescricao("");
        setSetor("");
        setStatus("");
        setValor(0.0);
        setTecido("");
        setTipo(null);
    }

    private void mensagem(FacesMessage fc) {
        FacesContext.getCurrentInstance().addMessage(null, fc);
    }

    public void abreDialog(ActionEvent ae) {

        roupa = (Roupa) (dataModelRoupa.getRowData());
        Map<String, Object> opcoes = new HashMap<String, Object>();

        opcoes.put("modal", true);
        opcoes.put("resizable", false);
        opcoes.put("draggable", false);

        RequestContext.getCurrentInstance().openDialog("editar_roupa", opcoes, null);
    }

    public void fechaDialog() {
        RequestContext.getCurrentInstance().closeDialog(0);
    }

    private InterfaceRoupa roupaDAO = new RoupaDAO();
    private Roupa roupa = new Roupa();
    private DataModel dataModelRoupa;
    private String nomeColuna;
    private String valorPesquisado;
    private String descricao;
    private Double valor;
    private String status;
    private String setor;
    private String cor;
    private String tecido;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public DataModel getDataModelRoupa() {
        List<Roupa> listaprov = new RoupaDAO().listaRoupa();
        dataModelRoupa = new ListDataModel(listaprov);
        return dataModelRoupa;
    }

    public void setDataModelRoupa(DataModel dataModelRoupa) {
        this.dataModelRoupa = dataModelRoupa;
    }

    public String getNomeColuna() {
        return nomeColuna;
    }

    public void setNomeColuna(String nomeColuna) {
        this.nomeColuna = nomeColuna;
    }

    public String getValorPesquisado() {
        return valorPesquisado;
    }

    public void setValorPesquisado(String valorPesquisado) {
        this.valorPesquisado = valorPesquisado;
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

    public Roupa getRoupa() {
        if (roupa == null) {
            roupa = new Roupa();
        }
        return roupa;
    }

    public void setRoupa(Roupa roupa) {
        this.roupa = roupa;
    }

}
