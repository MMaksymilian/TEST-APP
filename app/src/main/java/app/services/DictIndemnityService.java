package app.services;

import core.orm.entities.indemnity.DictIndemnity;
import core.orm.entities.indemnity.DictIndemnityChild;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 06.07.12
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public interface DictIndemnityService {

    Map<DictIndemnity, List<DictIndemnityChild>> getAvailableEstates();
    DictIndemnity getDictIndemnityById(Long id);
}
