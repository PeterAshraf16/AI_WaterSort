package code;

import java.util.ArrayList;
import java.util.List;

public class WaterSortSearch extends GenericSearch {
    
    
    static Node globalNode;
    
    
    @Override
    public String solve(String initialState, String strategy, boolean visualize) {
        // Parse the initial state, run the selected search strategy, return the solution
        return "NOSOLUTion";
    }
        
        

    public Boolean goalTest(Node node){
        globalNode=node;
        String state=node.getState();
        String[] split=state.split(";");
        int n=Integer.parseInt(split[0]);
        int k=Integer.parseInt(split[1]);
        
        for(int i=2;i<n+2;i++){
            String[] bottle=split[i].split(",");
            for(int j=0;j<k-1;j++){
                if(!(bottle[j].equals(bottle[j+1]))){
                    return false;
                }
            }
        }
        return true;
    }


    public List<Node> getSuccessors(Node node) {
        globalNode=node;
        List<Node> successors = new ArrayList<Node>();
        String state = node.getState();
        String[] bottles = state.split(";");
        int numberOfBottles = Integer.parseInt(bottles[0]);
        int numberOfColors = Integer.parseInt(bottles[1]);
        for (int i = 2; i < numberOfBottles + 2; i++) {
            String[] currentbottle = bottles[i].split(",");
            for (int j = 2; j < numberOfBottles + 2; j++) {
                if (i != j) {
                    // Check if we can pour from bottle i to bottle j
                    // If yes, create a new state and add it to the successors
                    String[] targetBottle = bottles[j].split(",");
                    if(pour(i,j)){
                        String newState = "";
                        newState += numberOfBottles + ";" + numberOfColors + ";";
                        int index = 0;
                        for(int m = 0;m<currentbottle.length;m++){
                            if(!currentbottle[m].equals("e")){
                                index = m;
                                break;
                            }
                        }
                        for(int k=2;k<numberOfBottles+2;k++){
                            if(k==i){
                                // String result = String.join(",", currentbottle);
                                // result = 'e' + result.substring(1);
                                // newState += result;

                                String result = "";
                                boolean flag = false;
                                for(int l = 0; l < currentbottle.length; l++){
                                    if(l == index){
                                        flag = true;
                                        result = result  + "e";
                                    }
                                    else{
                                        result = result + currentbottle[l];
                                    }
                                }
                            }
                            else if(k==j){
                                String result = "";
                                boolean flag = false;
                                for(int l = targetBottle.length - 1; l >= 0; l--){
                                    if(targetBottle[l].equals("e") && !flag){
                                        flag = true;
                                        result = currentbottle[index] + result;
                                    }
                                    else{
                                        result = targetBottle[l] + result;
                                    }
                                }
                            }
                            else{
                                newState += bottles[k];
                            }
                            if(k!=numberOfBottles+1){
                                newState += ";";
                            }
                        
                        }
                        Node newNode = new Node(newState, node, "Pour from bottle " + i + " to bottle " + j, node.getPathCost() + 1, node.getDepth() + 1);
                        successors.add(newNode);

                    }
                    
                
                }
            }
        
        }
        return successors;
    }


    public boolean pour(int from, int to) {
        // Implement the pour action from bottle 'from' to bottle 'to'
        String state=globalNode.getState();
        String[] split=state.split(";");
        int k=Integer.parseInt(split[1]);
        String[] bottleFrom=split[from+2].split(",");
        String[] bottleTo=split[to+2].split(","); 
        String topFrom="";
        String topTo="";
        if(!bottleTo[0].equals("e")) return false;
        if(bottleFrom[k-1].equals("e")) return false;
        if(bottleTo[k-1].equals("e")) return true;
        for(int i=0;i<k;i++){
            if(bottleFrom[i].equals("e"))continue;
            else{
                topFrom=bottleFrom[i];
                break;
            }
        }
        
        for(int i=0;i<k;i++){
            if(bottleTo[i].equals("e"))continue;
            else{
                topTo=bottleTo[i];
                break;
            }
        }
          
        if(topFrom.equals(topTo))return true;
        else return false;
        
    }
    
    
    // Additional methods to handle bottle states and apply actions like pour
}
