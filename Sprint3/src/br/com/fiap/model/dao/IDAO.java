package br.com.fiap.model.dao;

/**
 * Interface para ser implementada em classes <strong>DAO</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public interface IDAO {
    public String inserir(Object object);
    public String alterar(Object object);
    public String excluir(Object object);
    public String listarUm(Object object);
}
