package n2MySQL.DAO;

import java.util.List;

public interface DAO <T,K> {

    public void create (T object);
    public void update(T object);
    public void delete (T object);
    public List<T> readAll();
    T getOne (K id);
}

