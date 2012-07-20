package app.services;

import core.orm.entities.DeclarationRecord;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public interface DeclarationRecordService {

    public List<DeclarationRecord> listMainDeclarations();
}
