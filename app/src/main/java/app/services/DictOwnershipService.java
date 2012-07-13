package app.services;

import core.orm.entities.DictOwnership;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public interface DictOwnershipService {
    List<DictOwnership> listDictOwnerships();
}
