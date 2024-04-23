package n2exerciciSQL.DAO;

import n2exerciciSQL.beans.Product;

import java.util.List;

public interface DAO <T> {
    public void insert (T object) throws Exception;
    public void modify(T object) throws Exception;
    public void remove (T object) throws Exception;
    public List<T> list() throws Exception;
}

