package n2exerciciSQL.DAO;

import n2exerciciSQL.beans.Flower;
import n2exerciciSQL.beans.Product;

import java.util.List;

public interface DAO <T,K> {

    public void create (T object);
    public void update(T object);
    public void delete (T object);
    public List<T> read();
    T getOne (K id);
}

