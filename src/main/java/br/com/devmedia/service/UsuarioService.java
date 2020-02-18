package br.com.devmedia.service;

import java.util.List;

import br.com.devmedia.domain.Usuario;

public interface UsuarioService {

    void salvar(Usuario usuario);
    List<Usuario> recuperar();
    void atualizar(Usuario usuario, long usuarioId);
    void excluir(long usuarioId);

}
