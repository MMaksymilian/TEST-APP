package app.bean;

import org.primefaces.model.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 02.07.12
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
public class DeclarationData {

    private Long declarationId;
    private TreeNode declarationTree;

    public Long getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(Long declarationId) {
        this.declarationId = declarationId;
    }

    public TreeNode getDeclarationTree() {
        return declarationTree;
    }

    public void setDeclarationTree(TreeNode declarationTree) {
        this.declarationTree = declarationTree;
    }
}
