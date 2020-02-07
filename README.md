# Java 2D Collison Detection

**A simple class used to detect a collision between any two lines or polygons**

## Installation

To install this collision detection algorithm, just download CollisionDetection.java file.

Don't forget to compile it before using it.

## Lines

Lines have a very simple format. They are a two by two array of coordinates: {{x<sub>1</sub>, x<sub>2</sub>}, {x<sub>2</sub>, y<sub>2</sub>}}.

Example:
`float [][] line = {{0, 0}, {100, 100}}`

To check if two lines collide, you must call `checkCollisionBetweenLines()` method. It takes two lines, so an example would be:
`checkCollisionBetweenLines(line1, line2)`

Function returns `true` (if lines intersect) or `false` (if they don't).

## Polygons

Polygons have a similar format. They are again a 2D array: {{x<sub>1</sub>, y<sub>1</sub>}, {x<sub>2</sub>, y<sub>2</sub>}, {x<sub>3</sub>, y<sub>3</sub>}, ... {x<sub>n</sub>, y<sub>n</sub>}}

Example (a triangle):
`float [][] polygon1 = {{0, 0}, {100, 100}, {-100, 100}}`

To check if two polygons are colliding, you must call `checkCollisionBetweenPolygons()` method

An Example:
`checkCollisionBetweenPolygons(polygon1, polygon2)`

Function returns `true` (if polygons are colliding) or `false` (if they aren't).

**If you want to check if a polygon and a line collide, you just treat a line as a polygon and insert it instead of one of the polygons, and it works**

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
