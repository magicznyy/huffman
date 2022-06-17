public class huffmanNode implements Comparable<huffmanNode>  {

    int id;
    int weight;
    char character;
    huffmanNode leftSon;
    huffmanNode rightSon;

    public huffmanNode(int weight, char character) {
        this.weight = weight;
        this.character = character;
    }

    public huffmanNode(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public huffmanNode getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(huffmanNode leftSon) {
        this.leftSon = leftSon;
    }

    public huffmanNode getRightSon() {
        return rightSon;
    }

    public void setRightSon(huffmanNode rightSon) {
        this.rightSon = rightSon;
    }

    @Override
    public int compareTo(huffmanNode o) {
        return this.getWeight() - o.getWeight();
    }
}
