package code;

import java.util.List;

public abstract class GenericSearch {
    public abstract String solve(String initialState, String strategy, boolean visualize);

    protected Node genericSearchProblem(String initialState, String strategy) {
        // Implement general search algorithm that can handle different strategies
        return null;
    }
    public abstract Boolean goalTest(Node node);
    public abstract List<Node> getSuccessors(Node node);


    
    // Utility methods for managing the frontier, explored set, and expanding nodes
}