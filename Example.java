public class Example {

  public static void main(String[] args){

    float [][] polygon1 = {{0, 0}, {0, 100}, {100, 100}, {100, 0}};
    float [][] polygon2 = {{50, 5}, {50, 105}, {150, 105}, {150, 5}};

    CollisionDetection c = new CollisionDetection();
    boolean col = c.checkCollisionBetweenPolygons(polygon1, polygon2);

    System.out.println(col);

  }

}
