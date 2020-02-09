# Java 2D Collison Detection

**A simple class used to detect a collision between any two lines or polygons**

## Installation

To install this collision detection algorithm, just download CollisionDetection.java file.

Don't forget to compile it before using it.

## List of formats of geometrical shapes

* Line: `float[][] = {{x1, y1}, {x2, y2}}`;
* Circle: `float[] = {x, y, r}`;
* Polygon: `float[][] = {{x1, y1}, {x2, y2}, {x3, y3}, ... {xn, yn}}`;

## A list of all functions

* `checkCollisionBetweenLines(float[][] line1, float[][] line2);`
* `checkCollisionBetweenLineAndCircle(float[][] line1, float[] circle);`
* `checkCollisionBetweenPolygons(float[][] polygon1, float[][] polygon2);` **If you want to check if a polygon and a line collide, you just treat a line as a polygon and insert it instead of one of the polygons, and it works**
* `checkCollisionBetweenCircles(float[] circle1, float[] circle2);`
* `checkCollisionBetweenPolygonAndCircle(float[][] polygon, float[] circle);`

## A working example (Example.java)


```
public class Example {

  public static void main(String[] args){

    float [][] polygon1 = {{0, 0}, {100, 100}, {-100, 100}};
    float [][] polygon2 = {{-100, 0}, {0, 200}, {100, -100}};

    CollisionDetection c = new CollisionDetection();
    boolean col = c.checkCollisionBetweenPolygons(polygon1, polygon2);

    System.out.println(col);

  }

}
```

This is a simple program that checks if two triangles are colliding. And they are:

![Two colliding triangles](https://i.imgur.com/NgjUl8D.png)

So the output is: `true`
