package core.orm.dao;

import core.orm.entities.DeclarationRecordChild;
import core.orm.entities.estate.DictEstate;
import core.orm.entities.estate.DictEstateChild;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 06.07.12
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public interface DictEstateDAO extends BaseDAO<DictEstate> {

    List<DictEstate> listDictEstateParent();

//    List<DictEstateChild> listDictIndemnityChildren(DictEstate dictIndemnity);

    void updateChild(DictEstateChild dictChildRecord);

    List<DeclarationRecordChild> listDeclarationChildrendContainingEstate(DictEstate dictEstate);
}
