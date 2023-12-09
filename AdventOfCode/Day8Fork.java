public class Day8Fork {
    private String left;
    private String right;

    public Day8Fork(String left, String right){
        this.left  =  left;
        this.right = right;
    }
    public String left(){
        return this.left;
    }
    public String right(){
        return this.right;
    }
    public String toString(){
        return String.format("L: %s, R: %s",this.left,this.right);
    }
}
