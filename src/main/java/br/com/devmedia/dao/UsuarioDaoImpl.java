package br.com.devmedia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.devmedia.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void salvarUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public void atualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void excluirUsuario(long usuarioId) {
		em.remove(em.getReference(Usuario.class, usuarioId));
		
	}

	@Override
	public List<Usuario> recuperar() {
		return em.createQuery("select u from Usuario u", Usuario.class).getResultList();
	
	}
	
	

}
