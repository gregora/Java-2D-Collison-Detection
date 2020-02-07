# Java 2D Collison Detection

** A simple class used to detect a collision between any two lines or polygons**

## Installation

To install this collision detection algorithm, just download CollisionDetection.java file.

Don't forget to compile it before using it.

## Lines

Lines have a very simple format. They are a two by two array of coordinates: {{x1, x2}, {x2, y2}}.

Example:
`float [][] line = {{0, 0}, {100, 100}}`

To check if two lines collide, you must call `checkCollisionBetweenLines()` method. It takes two lines, so an example would be:
`checkCollisionBetweenLines(line1, line2)`

## Polygons

Polygons have a similar format. They are again a 2D array: {{x1, y1}, {x2, y2}, {x3, y3}, ... {xn, yn}}

Example (a triangle):
`float [][] polygon1 = {{0, 0}, {100, 100}, {-100, 100}}`

To check if two polygons are colliding, you must call `checkCollisionBetweenPolygons()` method

An Example:
`checkCollisionBetweenPolygons(polygon1, polygon2)`

** If you want to check if a polygon and a line collide, you just treat a line as a polygon and insert it instead of one of the polygons, and it works **

## A working example (Example.java)


`public class Example {

  public static void main(String[] args){

    float [][] polygon1 = {{0, 0}, {100, 100}, {-100, 100}};
    float [][] polygon2 = {{-100, 0}, {0, 200}, {100, -100}};

    CollisionDetection c = new CollisionDetection();
    boolean col = c.checkCollisionBetweenPolygons(polygon1, polygon2);

    System.out.println(col);

  }

}`

This is a simple program that checks if two triangles are colliding. And they are:

![Two colliding triangles](https://imgur.com/a/ia47SUP)

So the output is: `true`
