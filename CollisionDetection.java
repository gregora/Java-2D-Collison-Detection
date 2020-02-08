public class CollisionDetection {

  public static void main(String[] args){

    float [][] line = {{0, 1000}, {200, -1000}};

    float [][] polygon = {{0, 0}, {0, 100}, {100, 100}, {100, 0}};
    float [] circle = {0, 0, 100};
    //System.out.println(checkCollisionBetweenPolygonAndCircle(polygon, circle));
    System.out.println(checkCollisionBetweenLineAndCircle(line, circle));
  }


  public static boolean checkCollisionBetweenPolygonAndCircle(float [][] polygon, float[] circle){
    ///input shold be checkCollisionBetweenPolygonAndCircle({{x1, y1}, {x2, y2}, ... {xn, yn}}, {x, y, radius})

    ///for each side of polygon
    for(int i = 0; i < polygon.length; i ++){

      int iplus1 = i + 1;
      if(iplus1 >= polygon.length){
          iplus1 = 0;
      }

      float [][] polygonSide = {polygon[i], polygon[iplus1]};

      if(checkCollisionBetweenLineAndCircle(polygonSide, circle)){
        return true;
      }

    }

    return false;

  }

  public static boolean checkCollisionBetweenPolygons(float [][] polygon1, float[][] polygon2){
    ///input shold be checkCollisionBetweenPolygons({{x1, y1}, {x2, y2}, ... {xn, yn}}, {{x1, y1}, {x2, y2}, ... {xn, yn}})


    ///for each side of polygon 1
    for(int i1 = 0; i1 < polygon1.length; i1 ++){

      int i1plus1 = i1 + 1;
      if(i1plus1 >= polygon1.length){
          i1plus1 = 0;
      }


      float[][] c1 = {polygon1[i1], polygon1[i1plus1]};

      //for each side of polygon 2
      for (int i2 = 0; i2 < polygon2.length; i2 ++){

        int i2plus1 = i2 + 1;
        if(i2plus1 >= polygon2.length){
            i2plus1 = 0;
        }

        float[][] c2 = {polygon2[i2], polygon2[i2plus1]};

        //check if two sides collide
        if(checkCollisionBetweenLines(c1, c2) == true){
          return true;
        }
      }

    }

    return false;

  }

  public static boolean checkCollisionBetweenLineAndCircle(float[][] line, float[] circle){
    ///input shold be checkCollisionBetweenLineAndCircle({{x1, y1}, {x2, y2}}, {x, y, radius})

    //circle
    float cx = circle[0];
    float cy = circle[1];
    float cr = circle[2]; //radius

    //line
    float x1 = line[0][0];
    float y1 = line[0][1];
    float x2 = line[1][0];
    float y2 = line[1][1];

    //if one of the points is inside circle, return true
    if(Math.sqrt(Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2)) <= cr || Math.sqrt(Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2)) <= cr){
      System.out.println("Found one point  in circle");
      return true;

    }


    //avoid dividing by  0
    if(x1 == x2){
      x2 = x1 + (float) 0.000000001;
    }

    float lk = (y2 - y1) / (x2 - x1); //  k = Δy / Δx
    float ln = y1 - x1 * lk;

    float ck;
    if(lk == 0){
      ck = 1000000000; //if lk == 0, ck is approximately infinity
    }else{
      ck = (float) Math.tan(Math.atan(lk) + Math.PI / 2); //circle radius pointing towards line coeficient (perpendicular to the line)
    }
    float cn = cy - ck * cx;

    float i = (cn - ln) / (lk - ck); // x coordinate of intersection
    float j = lk * i + ln; // y coordinate of intersecton

    if(i >= Math.min(x1, x2) && i <= Math.max(x1, x2)){ //check if intersection is on line

      float dist = (float) Math.sqrt(Math.pow(i - cx, 2) + Math.pow(j - cy, 2)); // distance between intersecton and circle centre

      if(dist <= cr){ // check if intersection point lies within circle

        return true;

      }

    }

    return false;

  }



  public static boolean checkCollisionBetweenLines(float[][] line1, float[][] line2){
    ///input shold be checkCollisionBetweenLines({{x1, y1}, {x2, y2}}, {{x3, y3}, {x4, y4}})

    ///get (x,y) coordinates
    //first line
    float x1 = line1[0][0];
    float y1 = line1[0][1];
    float x2 = line1[1][0];
    float y2 = line1[1][1];

    //second line
    float x3 = line2[0][0];
    float y3 = line2[0][1];
    float x4 = line2[1][0];
    float y4 = line2[1][1];

    //avoid dividing by  0
    if(x1 == x2){
      x2 = x1 + (float) 0.000000001;
    }

    if(x3 == x4){
      x4 = x3 + (float) 0.000000001;
    }

    //get linear equasion info
    float k1 = (y2 - y1) / (x2 - x1); //  k = Δy / Δx
    float k2 = (y4 - y3) / (x4 - x3);

    float n1 = y1 - x1 * k1;
    float n2 = y3 - x3 * k2;



    if(k1 == k2){
      //if two lines are parallel it is considered not collison
      return false;

    }else{

      ///get intersection point
      float i = (n2 - n1) / (k1 - k2);

      //check if x coordinate of intersection point is within limits of both lines
      if(i >= Math.min(x1, x2) && i <= Math.max(x1, x2)){

        if(i >= Math.min(x3, x4) && i <= Math.max(x3, x4)){

          return true;

        }

      }

      return false;
    }

  }


}
