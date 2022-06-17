import java.util.*;

public class main {

    static public HashMap<String,Integer> getCharWeight(String phrase, HashMap<String,Integer> characters){
        int temp;
        String c2str;
        for ( char c: phrase.toCharArray()) {
            c = Character.toLowerCase(c);
            c2str = String.valueOf(c);

            if(characters.containsKey(c2str)){
               temp =  characters.get(c2str);
               temp++;
               characters.put(String.valueOf(c2str),temp);
            }
            else {
                characters.put(String.valueOf(c2str),1);
            }
        }
        return characters;
    }


    public static ArrayList<huffmanNode> createNodes(HashMap<String,Integer> characters){
        ArrayList<huffmanNode> huffmanNodes = new ArrayList<huffmanNode>();

       characters.forEach((k, v) -> {
           huffmanNode node = new huffmanNode(v,k.charAt(0));
           huffmanNodes.add(node);
       });


        return huffmanNodes;
    }


    static public ArrayList<huffmanNode> sortNodesByWeight(ArrayList<huffmanNode> nodesList){


        Collections.sort(nodesList);

        return nodesList;
    }


    static public ArrayList<huffmanNode> createTree(ArrayList<huffmanNode> sortedNodesList){

        ArrayList<huffmanNode> huffmanTree = new ArrayList<>();

        while(sortedNodesList.isEmpty()==false){

            huffmanNode z = new huffmanNode(0);
            z.setLeftSon(sortedNodesList.get(0));
            z.setRightSon(sortedNodesList.get(1));
            z.setWeight(z.rightSon.getWeight()+z.leftSon.getWeight());
            huffmanTree.add(z);
            huffmanTree.add(sortedNodesList.get(0));
            huffmanTree.add(sortedNodesList.get(1));

            sortedNodesList.remove(0);

            if(sortedNodesList.size()==1)
                break;
            sortedNodesList.remove(0);

            sortedNodesList.add(z);
            sortedNodesList = sortNodesByWeight(sortedNodesList);
        }

            huffmanTree.remove(huffmanTree.size()-1);

        return huffmanTree;
    }



    public static void main(String[] args) {

        String phrase = "bcaadddccacacac";

        ArrayList<huffmanNode> sortedNodesList = new ArrayList<>();
        ArrayList<huffmanNode> huffmanTree = new ArrayList<>();
        HashMap<String,Integer> characters = new HashMap<String,Integer>();

        characters = getCharWeight(phrase,characters);

        sortedNodesList = sortNodesByWeight(createNodes(characters));

       huffmanTree = createTree(sortedNodesList);

       for(int i=0;i<huffmanTree.size();i++)
           if(huffmanTree.get(i).getRightSon()!=null)
               System.out.println(" waga: " + huffmanTree.get(i).getWeight() + " waga lewy:  " + huffmanTree.get(i).getLeftSon().getWeight() + " waga prawy: " + huffmanTree.get(i).getRightSon().getWeight());
           else
               System.out.println(" waga : " + huffmanTree.get(i).getWeight() + " " + huffmanTree.get(i).getCharacter());
    }
}
