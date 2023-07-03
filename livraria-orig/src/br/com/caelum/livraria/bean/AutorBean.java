package br.com.caelum.livraria.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();
	
	private Integer autorId;
	
	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void carregarAutorPelaId() {
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if(autorId == null) 
		{
			new DAO<Autor>(Autor.class).adiciona(this.autor);
		}
		else {
			new DAO<Autor>(Autor.class).atualiza(autor);
		}
		
		this.autor = new Autor();
		
		return "livro?faces-redirect=true";
	}
	
	
	public void alterar(Autor autor) {
		System.out.println("alterando autor");
		autorId = autor.getId();
		this.autor = autor;
	}
	
	
	public void remover(Autor autor) {
		System.out.println("removendo autor");
		new DAO<Autor>(Autor.class).remove(autor);
	}
}
