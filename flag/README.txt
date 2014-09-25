Flag Project
Coded by Rafi Long

===

Basic information:

Documentation is in the source headers.

===

How scaling works:

The stars, stripes, and the union all have their width, height, and x and y position declared in relation to the flag height. When the objects are being painted, all of the aforementioned variables are multiplied by the height of the flag. This height is determined by looking at the size of the content pane, and finding which side is smaller in proportion to the other. The height is then derived from the smallest of the width and height of the pane, so the flag components never stretch off the edge of the screen. The whitespace divided by two is added to the x and y position of all of the objects in order to make the flag centered. The width of the content pane is found every time the frame is resized (this is done by putting the invocation in the paint method, which is always called on a resize).

Drawing stars:

Stars can be drawn by using trigonometry. Every star can be drawn with 10 points, which are the 5 outside, and the 5 inside points. If the center of the star is the origin, each of these points are 36 degrees apart. By using trig, you can find the x and y difference from the center, because you know the angle (36), and the radius, which is the diameter of the star divided by 2 (the diameter was given with all of the other measurements). The inner radius is .382 times the larger radius (this number was taken from John B. Hall, his website is mentioned in the comments in the drawStar method). By using cos for the x, and sin for the y, you can very easily determine the point's position in relation to the center of the star. The point itself is found by adding these differences to the coordinates of the center of the star.

===

Errors:

The union is divided into 7 stripes in order to avoid rounding errors. When the union was one rectangle, it could be either be one pixel larger or one pixel smaller than the first 7 stripes. By dividing it into 7 stripes, it is always the same size as the first 7 stripes. However, when the flag is very small, you can see very small gaps between the separate pieces of the union. This could be avoided by drawing the union as 2 pieces, one small piece at the bottom and one big piece, but as the problem only shows up when the flag is small enough that it is impossible to make out the stars, it makes not very much sense to try to fix the problem.
