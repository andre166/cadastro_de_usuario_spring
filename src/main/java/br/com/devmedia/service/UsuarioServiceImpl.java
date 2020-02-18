package br.com.devmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.dao.UsuarioDao;
import br.com.devmedia.domain.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public void salvar(Usuario usuario) {
       usuarioDao.salvarUsuario(usuario);
	}

	@Override
	public void atualizar(Usuario usuario, long usuarioId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(long usuarioId) {
		usuarioDao.excluirUsuario(usuarioId);
		
	}

	@Override
	public List<Usuario> recuperar() {
		return usuarioDao.recuperar();
	}
	
	

}
