package 多叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/3/30 上午10:19
 */
public class TreeNode {
    private String name;
    private TreeNode parent;
    private List<TreeNode> children = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
