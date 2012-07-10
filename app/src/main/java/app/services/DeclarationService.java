package app.services;

import core.orm.entities.Declaration;
import org.primefaces.model.TreeNode;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 27.06.12
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
public interface DeclarationService {
    public List<Declaration> getDeclarationsForUser (String login);
    public Declaration saveDeclaration (Declaration declartion);
    public Map<Long, Map<Long, List<String[]>>> getDeclarationIndemnityTreeForUser(String login);
    public Map<Declaration, TreeNode> listDeclarationsTreeForUser(String login);
}
