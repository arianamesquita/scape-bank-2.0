package DataBase;

import java.sql.SQLException;
import java.util.List;


public interface InterfaceDAO<T> {
    void criar(T objeto) throws SQLException;

    T ler(int id);

    void atualizar(T objeto);

    void deletar(int id);

    List<T> listarTodos();
}




