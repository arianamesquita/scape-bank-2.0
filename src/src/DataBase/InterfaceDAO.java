package DataBase;

import java.util.List;


public interface InterfaceDAO {
    void criar();

    void ler(int id);

    void atualizar(Object objeto);

    void deletar(int id);

    <E> List<E> listarTodos();
}




