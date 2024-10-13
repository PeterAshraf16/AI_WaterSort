package code;

public class Node {
    private String state; // Current state of the puzzle
    private Node parent;  // Parent node in the search tree
    private String action; // Action taken to reach this node
    private int pathCost; // Cost to reach this node
    private int depth;    // Depth of the node (for DFS/IDS)

    // Constructor
    public Node(String state, Node parent, String action, int pathCost, int depth) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.pathCost = pathCost;
        this.depth = depth;
    }

    // Getters and Setters
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPathCost() {
        return pathCost;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
    
}
