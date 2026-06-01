public class PosIllegal extends IndexOutOfBoundsException{
    public PosIllegal(){}
    public PosIllegal(String msg){
        System.out.println(msg);
    }
}