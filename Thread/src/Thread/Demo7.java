package Thread;

class Point{


}


//工厂类
class PoiintFactor{
    //该形式的提供的构造方法称为工厂方法
    public static Point makePointByXY(double x,double y){
        Point p = new Point();
        return  p;
    }
    public static Point makePointByRA(double r,double a){
        Point p = new Point();
        return p;
    }
}
public class Demo7 {
    public static void main(String[] args) {
        Point p = PoiintFactor.makePointByXY(10,20);
    }
}
