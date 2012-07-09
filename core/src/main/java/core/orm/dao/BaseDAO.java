package core.orm.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 09.07.12
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public interface BaseDAO<T> {

    /**
     * Zwraca obiekt tej klasy dla której jest zrobione DAO
     *
     * @param id  numer id obiektu
     * @return obiekt z tym id
     */
    public abstract T getById(Long id);
}
