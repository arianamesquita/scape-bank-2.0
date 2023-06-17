package DataBase;

import java.util.List;


public interface InterfaceDAO<T> {
    void criar(T objeto);

    T ler(int id);

    void atualizar(T objeto);

    void deletar(int id);

    List<T> listarTodos();
}




