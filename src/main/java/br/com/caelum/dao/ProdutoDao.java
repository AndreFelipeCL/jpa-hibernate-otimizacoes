package br.com.caelum.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.caelum.model.Produto;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;

	public List<Produto> getProdutos() {
		return em.createQuery("from Produto", Produto.class).getResultList();
	}

	public Produto getProduto(Integer id) {
		Produto produto = em.find(Produto.class, id);
		return produto;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Produto> getProdutos(String nome, Integer categoriaId, Integer lojaId) {
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);
		
		if(!nome.isEmpty())
			criteria.add(Restrictions.like("nome", "%" + nome + "%"));
		
		if(Objects.nonNull(lojaId))
			criteria.add(Restrictions.like("loja.id", lojaId));
		
		if(Objects.nonNull(categoriaId))
			criteria.setFetchMode("categorias", FetchMode.JOIN).createAlias("categorias", "c").add(Restrictions.like("c.id", categoriaId));
		
		return (List<Produto>) criteria.list();
	}

	public void insere(Produto produto) {
		if (produto.getId() == null)
			em.persist(produto);
		else
			em.merge(produto);
	}

}
