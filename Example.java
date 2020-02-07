public class Example {

  public static void main(String[] args){

    float [][] polygon1 = {{0, 0}, {100, 100}, {-100, 100}};
    float [][] polygon2 = {{-100, 0}, {0, 200}, {100, -100}};

    CollisionDetection c = new CollisionDetection();
    boolean col = c.checkCollisionBetweenPolygons(polygon1, polygon2);

    System.out.println(col);

  }

}
