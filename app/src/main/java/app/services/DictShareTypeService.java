package app.services;

import core.orm.entities.DictShareType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */
public interface DictShareTypeService {
    List<DictShareType> listDictShareTypes();
}
