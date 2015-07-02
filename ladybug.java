//<pre>
// JAVA SOURCE CODE FOR THE LADYBUG GAME

import java.awt.*;

public class ladybug extends BufferedApplet
{
   public String Copyright_Notice = "LADYBUG GAME. COPYRIGHT 2001 KEN PERLIN";

///// SIZES

   int width=0;                   // THE WIDTH OF THE JAVA APPLET WINDOW
   int w;                         // THE WIDTH OF ONE SQUARE TILE
   Font font = new Font("Helvetica",Font.BOLD, 30); // TEXT FONT FOR MESSAGES

///// COLORS

   int bgR = 160, bgG = 112, bgB = 80; // RED,GREEN,BLUE OF THE BACKGROUND COLOR

   Color bgColor = new Color(bgR,bgG,bgB);    // COLOR FOR UNLIT TILES
   Color darkRed = new Color(160,0,0);        // DARK COLOR FOR LADYBUG BODY
   Color lightRed = new Color(255,200,200);   // HIGHLITE COLOR FOR LADYBUG BODY
   Color lightBlack = new Color(200,200,200); // HILITE COLOR FOR LADYBUG HEAD
   Color eyeColor = new Color(255,255,255);   // LADYBUG'S EYE COLOR
   Color shade[];                             // THE SHADES A TILE CAN HAVE

///// THE STATE OF THE BOARD

   int u=3, v=3;                  // THE LOCATION OF THE CURRENTLY BLANK SQUARE
   int Tile[][] = new int[4][4];  // WHICH TILE IS AT LOCATION U,V
   boolean allVisited = false;    // WHETHER PLAYER HAS WON THE GAME
   long startTime = 0, prevTime;  // CLOCK TIME

///// STATE OF THE LADYBUG

   boolean visited[] = new boolean[15];       // HAS LADYBUG VISITED THIS TILE?

   int mu=0,mv=2;                 // WHICH TILE IS LADYBUG ON (CURRENT TILE)?
   int mk=1;                      // WHICH CURVE OF CURRENT TILE IS LADYBUG ON?
   int nShades=10;                // HOW LONG IT TAKES TO LIGHT UP CURRENT TILE
   int brightness=nShades;        // HOW MUCH CURRENT TILE IS ALREADY LIT UP
   int nSteps=20;                 // TOTAL NUMBER OF STEPS ALONG CURRENT CURVE
   int step=0;                    // HOW FAR LADYBUG IS ALONG CURRENT CURVE
   boolean md = true;             // IS LADYBUG GOING FORWARD OR BACK ON CURVE?

///// ALL THE DATA TO DESCRIBE THE CURVED TRACKS

   /*
     Each tile has 8 "terminals" around its perimeter where curves can
     connect with the outside world (two terminals along each of the four
     sides of the tile).  We number them clockwise from left, as follows:

                             --1--2--
                             0      3
                             |      | 
                             7      4
                             --6--5--
   */

   final int LT = 0; // LEFT   EDGE, TOP    TERMINAL
   final int TL = 1; // TOP    EDGE, LEFT   TERMINAL
   final int TR = 2; // TOP    EDGE, RIGHT  TERMINAL
   final int RT = 3; // RIGHT  EDGE, TOP    TERMINAL
   final int RB = 4; // RIGHT  EDGE, BOTTOM TERMINAL
   final int BR = 5; // BOTTOM EDGE, RIGHT  TERMINAL
   final int BL = 6; // BOTTOM EDGE, LEFT   TERMINAL
   final int LB = 7; // LEFT   EDGE, BOTTOM TERMINAL

   // To get from each of the eight terminals to its opposing terminal:

   // Opposing:  0  1  2  3  4  5  6  7

   int opp[] = { 3, 6, 5, 0, 7, 2, 1, 4 };

   /*
     The Shapes array describes the curve-shapes used make the curved tracks
     on the tiles.  There are six shapes, each of which is specified as a
     set of key points.

     For each curve, we specify two sets of numbers.  The first set of numbers
     specifies the x coordinates of the key points, and the second set of
     numbers specifies the y coordinates of the key points.
   */

   double Shapes[][][] = {
      {{0,.1,.23,.3,.3},      {.3,.3,.23,.1,0}},
      {{0,.3,.6,.7,.7},       {.3,.3,.19,.02,0}},
      {{0,.3,.7,1},           {.3,.3,.3,.3}},
      {{0,.15,.4,.6,.85,1.},  {.3,.3,.42,.58,.7,.7}},
      {{0.,.27,.57,.7,.7},    {.3,.3,.43,.73,1.}},
      {{0,.07,.22,.22,.07,0}, {.3,.3,.45,.55,.7,.7}},
   };

   /*
     Each curve connects one of the eight terminals to one other terminal.
     This means there can be at most 8 x 8 possible curves.

     Actually, there are fewer, since you can't connect a terminal to
     itself inside a tile - only with one of the other seven terminals.

     The Curves array defines the curve used to connect any two terminals.
     That's why it has 8x8 = 64 entries.

     Each entry is made by starting with one of the shapes from the Shapes
     array above, and then doing some combination of flips on that curve
     shape (horizontal, vertical or diagonal).  The first argument to function
     p tells which of the curves to use from the Shapes array; the second
     argument is a bit mask that specifies the combination of flips to do.
   */

   double Curves[][][] = {
   // LT      TL      TR      RT      RB      BR      BL      LB 
      p(0,0), p(0,0), p(1,0), p(2,0), p(3,0), p(4,0), p(1,5), p(5,0), // LT
      p(0,0), p(0,0), p(5,4), p(1,1), p(4,4), p(3,4), p(2,4), p(1,4), // TL

      p(1,0), p(5,4), p(0,0), p(0,1), p(1,6), p(2,6), p(3,6), p(4,6), // TR
      p(2,0), p(1,1), p(0,1), p(0,0), p(5,1), p(1,7), p(4,1), p(3,1), // RT

      p(3,0), p(4,4), p(1,6), p(5,1), p(0,0), p(0,3), p(1,3), p(2,2), // RB
      p(4,0), p(3,4), p(2,6), p(1,7), p(0,3), p(0,0), p(5,5), p(1,2), // BR

      p(1,5), p(2,4), p(3,6), p(4,1), p(1,3), p(5,5), p(0,0), p(0,2), // BL
      p(5,0), p(1,4), p(4,6), p(3,1), p(2,2), p(1,2), p(0,2), p(0,0), // LB
   };

   /*
     The CurveSet array describes the set of curves to draw onto each of the
     fifteen tiles.  There are four values for each entry, because four curves
     are drawn onto each tile.

     Values are specified in base 8 (when you start a number with the "0"
     digit, Java interprets it as base 8).  In effect, the second and third
     digit of each value in CurveSet specifies a row and column into the
     Curves array, which gives the starting and ending terminal for that curve.
   */

   int CurveSet[][] = {

        {001,023,046,057}, // CURVE SET FOR TILE 0
        {001,027,035,046}, // CURVE SET FOR TILE 1, ETC.
        {002,014,037,056},
        {004,012,037,056},
        {001,024,036,057},

        {001,027,036,045},
        {002,015,037,046},
        {006,013,024,057},
        {001,024,037,056},
        {002,013,046,057},

        {002,017,034,056},
        {007,015,026,034},
        {001,027,034,056},
        {002,014,036,057},
        {002,017,035,046},
   };

   /*
     The p function transforms the key points of one of the curve
     shapes described in the Shapes array.  The first argument n, an
     index into the Shapes array, tells which curve shape to use.

     The second argument xform is a bit mask.  The p function flips
     horizontally about the tile center if the 0 bit of xform is set,
     flips vertically about the tile center if the 1 bit of xform is
     set, and flips diagonally about the tile center if the 2 bit of
     xform is set.  By setting various combinations of these three
     bits, you can specify any useful transformation of the original
     curve.
   */

   double[][] p(int n, int xform) {
      boolean flipX  = (xform & 1) != 0;            // FLIP HORIZONTALLY?
      boolean flipY  = (xform & 2) != 0;            // FLIP VERTICALLY?
      boolean swapXY = (xform & 4) != 0;            // FLIP ALONG DIAGONAL?

      double [][] shape = Shapes[n];

      double [] x = new double[shape[0].length];
      double [] y = new double[shape[1].length];

      for (int i = 0 ; i < x.length ; i++)          // IF HORIZONTAL FLIP
        x[i] = flipX ? 1-shape[0][i] : shape[0][i]; //    REVERSE LEFT/RIGHT
      for (int i = 0 ; i < y.length ; i++)          // IF VERTICAL FLIP
        y[i] = flipY ? 1-shape[1][i] : shape[1][i]; //    REVERSE UP/DOWN

      double dst[][] = new double[2][];
      dst[0] = swapXY ? y : x;                      // IF DIAGONAL FLIP
      dst[1] = swapXY ? x : y;                      //    SWAP X AND Y

      return dst;
   }

// RENDER THE ENTIRE GAME EVERY ANIMATION FRAME

   public void render(Graphics g) {

      //////////// THINGS TO DO WHEN FIRST STARTING UP: //////////////////

      if (width == 0) {

         width = bounds().width;  // REMEMBER HOW WIDE THE APPLET WINDOW IS.
         w = width/4;             // ONE TILE IS 1/4 THE WIDTH OF THE WINDOW.

         // PLACE THE 15 TILES IN THEIR INITIAL POSITIONS.

         for (int u = 0 ; u < 4 ; u++)
         for (int v = 0 ; v < 4 ; v++)
           Tile[u][v] = 4*u + v;

         // REMEMBER WHAT TIME WAS ON THE CLOCK WHEN WE STARTED THE PROGRAM.

         startTime = System.currentTimeMillis();

         // MAKE A GRADATION OF SHADES, SO CURRENT TILE CAN LIGHT UP GRADUALLY
         // AFTER THE LADYBUG HAS ENTERED IT.

         shade = new Color[nShades];
         for (int s = 0 ; s < nShades ; s++) {
            double t = 1+.5*s/(nShades-1);
            shade[s] = new Color((int)(t*bgR),(int)(t*bgG),(int)(t*bgB));
         }
      }
      //////////////////////////////////////////////////////////////////

      // FIND OUT HOW MUCH TIME HAS ELAPSED SINCE PROGRAM STARTED RUNNING.

      long time = System.currentTimeMillis() - startTime;
      if (time - prevTime > 30) {       // EVERY 30 MILLISECONDS WE MUST
         step = (step+1) % nSteps;      // MOVE LADYBUG ALONG CURRENT CURVE.
         prevTime = time;
      }

      // DRAW THE BLANK SQUARE

      g.setColor(bgColor);
      g.fill3DRect(u*w,v*w,w,w, false);

      // DRAW THE 15 TILES

      allVisited = true;
      for (int U = 0 ; U < 4 ; U++)     // LOOP OVER ALL SQUARES
      for (int V = 0 ; V < 4 ; V++) {
         if (U==u && V==v)              // EXCEPT FOR THE BLANK SQUARE.
            continue;
          int tile = Tile[U][V];        // WHICH TILE IS AT THIS SQUARE?
         int r = mu==U && mv==V && brightness < nShades
            ? brightness : visited[tile]
            ? nShades-1 : 0;            // WHAT SHADE IS THE TILE?
          drawTile(g, U,V, tile, r);    // DRAW THE TILE.
         if (! visited[tile])           // IF ANY TILE IS STILL UNVISITED,
            allVisited = false;         // THEN PLAYER HAS NOT YET WON.
      }

      // GRADUALLY BRIGHTEN THE TILE CONTAINING THE LADYBUG,

      int tile = Tile[mu][mv];
      brightness = visited[tile] ? brightness+1 : 0;

      // AND REMEMBER THAT THE LADYBUG HAS VISITED THIS TILE.

      visited[tile] = true;

////////////////// FIGURE OUT WHERE THE LADYBUG IS /////////////////

      // WHICH CURVE IS THE LADYBUG ON?

      int c = CurveSet[tile][mk];

      // HOW FAR HAS THE LADYBUG TRAVELED ALONG THE CURVE?

      double t = (double)step / nSteps;
      t = (md ? t : 1-t);
      if (t < .5)
         t = .5*Math.pow(2*t,.5);
      else
         t = 1-.5*Math.pow(2*(1-t),.5);

      // WHAT ARE THE LADYBUG'S (X,Y) COORDINATES ON THE CURVE?

      double X = evalCurve(t, Curves[c][0]);
      double Y = evalCurve(t, Curves[c][1]);

      // WHAT DIRECTION IS THE LADYBUG HEADING?

      double DX = evalCurve(t+(md?.1:-.1), Curves[c][0]) - X;
      double DY = evalCurve(t+(md?.1:-.1), Curves[c][1]) - Y;
      double R = Math.sqrt(DX*DX+DY*DY);
      double dx = DX*8/R;  // HOW MUCH LEFT OR RIGHT THE LADYBUG FACES
      double dy = DY*8/R;  // HOW MUCH UP OR DOWN THE LADYBUG FACES

////////////////////////// DRAW THE LADYBUG /////////////////////////

      // FIND WHERE TO DRAW THE LADYBUG'S BODY, IN PIXEL COORDINATES

      double x = mu*w + w * X;
      double y = mv*w + w * Y;

      // FIND WHERE TO DRAW THE LADYBUG'S HEAD, IN PIXEL COORDINATES

      double hx = x+dx;
      double hy = y+dy;

      // DRAW THE HEAD

      g.setColor(Color.black);
      fillOval(g, hx-6,hy-6,12,12);

      // DRAW THE EYES

      g.setColor(eyeColor);
      fillOval(g, hx+.3*dx+.6*dy-2.5,hy+.3*dy-.6*dx-2.5,5,5);
      fillOval(g, hx+.3*dx-.6*dy-2.5,hy+.3*dy+.6*dx-2.5,5,5);

      // TRIM A LITTLE FROM THE EYES

      g.setColor(Color.black);
      fillOval(g, hx+.3*dx-5.5,hy+.3*dy-5.5,11,11);

      // DRAW THE HILITE ON THE HEAD

      g.setColor(lightBlack);
      fillOval(g, hx+.3*dx-3.5,hy+.3*dy-5.0,3,3);
      fillOval(g, hx+.3*dx-5.0,hy+.3*dy-3.5,3,3);

      // DRAW THE DARK-SHADED PART OF BODY

      g.setColor(darkRed);
      fillOval(g, x-10,y-10,20,20);

      // DRAW THE BODY

      g.setColor(Color.red);
      fillOval(g, x-10,y-10,17,17);

      // DRAW THE LINE THAT RUNS ALONG THE MIDDLE OF THE BACK

      g.setColor(Color.black);
      drawLine(g, x-dx,y-dy,x+dx,y+dy);

      // DRAW THE SPOTS ON THE BACK

      g.setColor(Color.black);
      fillOval(g, x-.6 *dy+.3*dx-2.5,y+.6 *dx+.3*dy-2.5,5,5);
      fillOval(g, x+.6 *dy+.3*dx-2.5,y-.6 *dx+.3*dy-2.5,5,5);
      fillOval(g, x-.35*dy-.5*dx-2  ,y+.35*dx-.5*dy-2  ,4,4);
      fillOval(g, x+.35*dy-.5*dx-2  ,y-.35*dx-.5*dy-2  ,4,4);

      // DRAW THE HILITE ON THE BODY

      g.setColor(lightRed);
      fillOval(g, x-5,y-8,3,3);
      fillOval(g, x-7,y-7,4,4);
      fillOval(g, x-8,y-5,3,3);

/////////////////////////////////////////////////////////////////////

      // CONGRATULATE THE PLAYER IF GAME HAS BEEN WON:

      if (allVisited) {
         g.setFont(font);
         g.setColor(Color.black);                     // DRAW DROP-SHADOW FIRST
         g.drawString("CONGRATULATIONS!", 24, 44);
         g.drawString("YOU'VE SOLVED IT!!!", 24, 84);
         g.setColor(Color.white);                     // THEN DRAW TEXT ITSELF
         g.drawString("CONGRATULATIONS!", 20, 40);
         g.drawString("YOU'VE SOLVED IT!!!", 20, 80);
      }

//// WHEN THE LADYBUG IS TRAVELLING ACROSS AN EDGE, FROM ONE TILE TO THE NEXT:

      if (step >= nSteps-1) {       // IF THE LADYBUG IS DONE TRAVERSING TILE
         int u0=mu,v0=mv;             // REMEMBER WHICH SQUARE WE WERE ON
         int s = S(X,Y);              // FIND NEAREST TERMINAL
          switch (s) {                // JUMP THRU TERMINAL TO NEXT SQUARE
         case LB: case LT: mu--; break;   // THRU LEFT   EDGE
         case RB: case RT: mu++; break;   // THRU RIGHT  EDGE
         case TL: case TR: mv--; break;   // THRU TOP    EDGE
         case BL: case BR: mv++; break;   // THRU BOTTOM EDGE
         }
         s = opp[s];                  // GO TO OPPOSING TERMINAL IN NEW SQUARE.

         // IF THE LADYBUG HAS HIT A WALL OR THE EMPTY SQUARE, THEN

         if (mv < 0 || mv > 3 || mu < 0 || mu > 3 || mu==u && mv==v) {

            // BOUNCE LADYBUG BACK TO ORIGINAL SQUARE AND CURVE

            mu = u0;                             // RESTORE OLD SQUARE
            mv = v0;
            s = opp[s];                          // RESTORE OLD TERMINAL

            for (tile = 0 ; tile < 15 ; tile++)  // UNLIGHT ALL THE TILES
               visited[tile] = false;            // TO RESTART THE GAME.
         }

         // DON'T LET THE LADYBUG GO OFF THE 4x4 BOARD.

         mu = Math.max(0,Math.min(3,mu));
         mv = Math.max(0,Math.min(3,mv));

         // GIVEN SQUARE'S LOCATION, FIND OUT WHICH TILE THE LADYBUG IS NOW ON.

         tile = Tile[mu][mv];

         // WHICH CURVE ON THE NEW TILE CONTAINS THE TERMINAL THROUGH
         // WHICH THE LADYBUG HAS JUST ENTERED?

         int k = 0;
         for ( ; k < CurveSet[tile].length ; k++) {
            c = CurveSet[tile][k];
            X = evalCurve(0, Curves[c][0]);
            Y = evalCurve(0, Curves[c][1]);
            if (S(X,Y) == s) { // IF TERMINAL IS AT START OF THIS CURVE, THEN
               md = true;      // LADYBUG SHOULD GO FORWARD ALONG THE CURVE.
               mk = k;
               break;
            }
            X = evalCurve(1, Curves[c][0]);
            Y = evalCurve(1, Curves[c][1]);
            if (S(X,Y) == s) { // IF TERMINAL IS AT END OF THIS CURVE, THEN
               md = false;     // LADYBUG SHOULD GO BACKWARD ALONG THE CURVE.
               mk = k;
               break;
            }
         }

         // PLACE THE LADYBUG AT THE BEGINNING OF THIS NEXT CURVE.

         c = CurveSet[tile][mk];
         nSteps = Curves[c][0].length * 5;  // FIVE STEPS FOR EVERY KEY POINT
         if (Curves[c][0][1] == .1)
            nSteps -= 10;                   // BUT LESS FOR VERY SHORT CURVE
         step = 0;
      }
   }

/////// ROUTINES TO SUPPORT DRAWING WITH FLOATING POINT ARGUMENTS /////

   void fillOval(Graphics g, double x, double y, double w, double h) {
      g.fillOval((int)x, (int)y, (int)w, (int)h);
   }

   void drawLine(Graphics g, double ax, double ay, double bx, double by) {
      g.drawLine((int)ax, (int)ay, (int)bx, (int)by);
   }

//////////////////////////////////////////////////////////////////////

   /*
     Figure out which terminal the ladybug is near, depending on whether it's
     on the upper left edge, lower right edge, etc.  The S function figures
     this out from looking at where the ladybug is within the square.
   */

   int S(double X,double Y) {
       return X > .5 ? (Y > .5 ? (Y > .7 ? BR : RB) : (Y < .3 ? TR : RT))
                     : (Y > .5 ? (Y > .7 ? BL : LB) : (Y < .3 ? TL : LT));
   }

   // DRAW ONE TILE AND ALL OF ITS CURVED TRACKS.

   void drawTile(Graphics g, int u, int v, int tile, int r) {

      // DRAW THE BASE TILE COLOR

      g.setColor(shade[r]);
      g.fillRect(u*w,v*w, w, w);

      // DRAW THE CURVES

      g.setColor(Color.black);
         for (int k = 0 ; k < CurveSet[tile].length ; k++) {
            double x0 = 0, y0 = 0;
            for (double t = 0 ; t < 1 ; t += .1) {
               int c = CurveSet[tile][k];
               double x1 = u*w + w * evalCurve(t, Curves[c][0]);
               double y1 = v*w + w * evalCurve(t, Curves[c][1]);
               if (t > 0)
                  drawLine(g, x0, y0, x1, y1);
               x0 = x1;
               y0 = y1;
            }
         }

      // DRAW FAKE 3D EDGES, TO MAKE THE TILE LOOK RAISED.

      g.setColor(shade[r].brighter()); // LIGHTER TOP AND LEFT EDGES
      g.fillRect(u*w,v*w,1,w-1);
      g.fillRect(u*w,v*w,w-1,1);
      g.setColor(Color.gray);          // DARKER BOTTOM AND RIGHT EDGES
      g.fillRect(u*w+w-1,v*w,1,w-1);
      g.fillRect(u*w,v*w+w-1,w-1,1);
   }

   // WHEN PLAYER CLICKS ON A TILE, SWAP IT WITH THE BLANK SQUARE IF POSSIBLE.

   public boolean mouseUp(Event e, int x, int y) {

      // WHICH TILE HAS PLAYER CLICKED ON?

      int U = x/w, V = y/w;

      // IF THE CLICKED-ON IS NEXT TO THE BLANK SQUARE:

      if (U >= 0 && U < 4 && V >= 0 && V < 4 && Math.abs(U-u)+Math.abs(V-v)==1) {

         // IF THE LADYBUG IS ON THE CLICKED-ON TILE, MOVE THE LADYBUG.

         if (mu == U && mv == V) {
            mu = u;
            mv = v;
         }

        // SWAP THE CLICKED-ON TILE WITH THE BLANK SQUARE.

         Tile[u][v] = Tile[U][V];
         u = U;
         v = V;
      }
      allVisited = false; // IN CASE PLAYER HAS JUST WON, RESTART THE GAME.
      return true;
   }

///////// THE REST OF THE CODE IS ALL MATH FOR EVALUATING THE CURVES /////////

   // EVALUATE CURVE AT ONE POINT

   double evalCurve(double x, double F[]) {

      int n = F.length;

      // IF NECESSARY, INITIALIZE ARRAY OF PARAMETER VALUES FOR EVALUATING
      // SPLINE CURVES HAVING THIS NUMBER OF KEY POINTS.

      if (T[n] == null) {
         T[n] = new double[n];
         for (int i = 0 ; i < n ; i++)
            T[n][i] = i / (n - 1.);
      }

      return evalCurve(x, T[n], F);
   }

   double T[][] = new double[10][];

   double evalCurve(double x, double T[], double F[]) {
      int n = T.length;
      double y=0;
      if (n == 0)
         y = .5;
      else if (x < T[0])
         y = F[0];
      else if (x >= T[n-1])
         y = F[n-1];
      else
         for (int i=0 ; i < n-1 ; i++)
            if (x >= T[i] && x < T[i+1]) {
               y = hermite(T[i], T[i+1],
                           F[i], F[i+1],
                           s(i,n,T,F), s(i+1,n,T,F),x);
               break;
            }
      return y;
   }

   // COMPUTE SLOPE AT A KEY POINT

   double s(int i, int n, double T[], double F[]) {
      double s = slopeIsZero(i,n,F) ? 0 :
         ((F[i+1]-F[i  ])/(T[i+1]-T[i  ]) * (T[i  ]-T[i-1]) +
          (F[i  ]-F[i-1])/(T[i  ]-T[i-1]) * (T[i+1]-T[i  ]) )
         / (T[i+1]-T[i-1]);

      s = Math.max(-10,Math.min(10,s));
      if (i > 0 && slopeIsZero(i-1,n,F)) {
         double limit = 2*Math.abs((F[i]-F[i-1]) / (T[i]-T[i-1]));
         s = Math.max(-limit, Math.min(limit, s));
      }
      if (i < n-1 && slopeIsZero(i+1,n,F)) {
         double limit = 2*Math.abs((F[i+1]-F[i]) / (T[i+1]-T[i]));
         s = Math.max(-limit, Math.min(limit, s));
      }
      return s;
   }

   // SLOPE IS ZERO AT ENDS OF CURVE AND AT MINIMA AND MAXIMA

   boolean slopeIsZero(int i, int n, double F[]) {
      return i <= 0 || i >= n-1 || (F[i]-F[i-1])*(F[i]-F[i+1]) >= 0;
   }

   // EVALUATE A HERMITE CUBIC AT ONE DOMAIN POINT

   double hermite(double x0,double x1,
                  double y0,double y1, double s0,double s1, double x) {

      double t = (x - x0) / (x1 - x0);
      double tt = t*t, ttt = t*tt;

      return y0 * (1       - 3*tt + 2*ttt)     +
             s0 * (   + t  - 2*tt +   ttt) / 3 +
             s1 * (        -   tt +   ttt) / 3 +
             y1 * (        + 3*tt - 2*ttt)     ;
   }
}
