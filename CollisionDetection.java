public class CollisionDetection {

  public static void main(String[] args){

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



  public static boolean checkCollisionBetweenLines(float[][] coords1, float[][] coords2){
    ///input shold be checkCollisionBetweenLines({{x1, y1}, {x2, y2}}, {{x3, y3}, {x4, y4}})

    ///get (x,y) coordinates
    //first line
    float x1 = coords1[0][0];
    float y1 = coords1[0][1];
    float x2 = coords1[1][0];
    float y2 = coords1[1][1];

    //second line
    float x3 = coords2[0][0];
    float y3 = coords2[0][1];
    float x4 = coords2[1][0];
    float y4 = coords2[1][1];

    //avoid dividing by  0
    if(x1 == x2){
      x2 = x1 + (float) 0.000001;
    }

    if(x3 == x4){
      x4 = x3 + (float) 0.000001;
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
      if(i > Math.min(x1, x2) && i < Math.max(x1, x2)){

        if(i > Math.min(x3, x4) && i < Math.max(x3, x4)){

          return true;

        }

      }

      return false;
    }

  }


}
