package core.orm.dao;

import core.orm.entities.Declaration;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 27.06.12
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 */
public interface DeclarationDAO {
    public List<Declaration> getDeclarationsForUser (String login);
    public Declaration saveDeclaration (Declaration declaration);
//    TODO można ew. zmienić na drzewko
//    Można było użyć ewentualnie connect by
    public List<Object[]> getEstateParentTreeForUser(String login);
    public List<Object[]>  getEstateChildTreeForUser(String login);
}
