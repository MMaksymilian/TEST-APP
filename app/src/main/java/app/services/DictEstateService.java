package app.services;

import app.exception.service.ChildIsUsedException;
import core.orm.entities.estate.DictEstate;
import core.orm.entities.estate.DictEstateChild;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 06.07.12
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public interface DictEstateService {

    Map<DictEstate, List<DictEstateChild>> getAvailableEstates();

    void updateChild(DictEstateChild selectedRecordChild) throws ChildIsUsedException;

}
