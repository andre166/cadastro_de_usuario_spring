package br.com.devmedia.dao;

import java.util.List;

import br.com.devmedia.domain.Usuario;

public interface UsuarioDao{

    void salvarUsuario(Usuario usuario);
    List<Usuario> recuperar();
    void atualizarUsuario(Usuario usuario);
    void excluirUsuario(long usuarioId);
    

}
