package core.orm.dao;

import core.orm.entities.Declaration;

import java.util.List;

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
    public List<List<String>> getEstateParentTreeForUserAndDeclaration(String login, Long declarationId);
    public List<List<List<String>>> getEstateParentTreeForUser(String login);
    public List<List<String>> getEstateChildTreeForUserAndDeclaration(String login, Long declarationId);
    public List<List<List<String>>> getEstateChildTreeForUser(String login);
}
