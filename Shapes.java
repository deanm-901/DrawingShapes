public class Shapes {
    static Turtle turt = new Turtle(0.0,0.0);

    static int timesTurned = 0;

    public static void drawLines(float[][] pos, double scale, double x, double y) {
        for (int i=0;i<pos.length;i+=2) {
            turt.up();
            turt.setPosition(pos[i][0]*scale+x, pos[i][1]*scale+y);
            turt.down();
            turt.setPosition(pos[i+1][0]*scale+x, pos[i+1][1]*scale+y);
        }
    }

    public static void drawTaskNum(int num, double scale, double x, double y) {
        turt.penColor(new java.awt.Color(0,0,0));
        /// task ///
        //-t-
        drawLines(new float[][]{
            new float[] {-1,1},
            new float[] {1,1},
            new float[] {0,1},
            new float[] {0,-1},
        }, scale, x, y);
        //-a-
        drawLines(new float[][]{
            new float[] {-1,-1},
            new float[] {0,1},
            new float[] {0,1},
            new float[] {1,-1},
            new float[] {-1,0},
            new float[] {1,0},
        }, scale, x+scale*2+10, y);
        //-s-
        drawLines(new float[][]{
            new float[] {1,1},
            new float[] {-1,0.5f},
            new float[] {-1,0.5f},
            new float[] {1,-0.5f},
            new float[] {1,-0.5f},
            new float[] {-1,-1},
        }, scale, x+scale*4+20, y);
        //-k-
        drawLines(new float[][]{
            new float[] {-1,1},
            new float[] {-1,-1},
            new float[] {-1,0},
            new float[] {1,1},
            new float[] {-1,0},
            new float[] {1,-1},
        }, scale, x+scale*6+30, y);

        //-number-
        float[][] one = new float[][] {
            new float[] {-1,0.5f},
            new float[] {0,1},
            new float[] {0,1},
            new float[] {0,-1},
            new float[] {-1,-1},
            new float[] {1,-1},
        };
        float[][] two = new float[][] {
            new float[] {-1,0.5f},
            new float[] {-1,1},
            new float[] {-1,1},
            new float[] {1,1},
            new float[] {1,1},
            new float[] {-1,-1},
            new float[] {-1,-1},
            new float[] {1,-1},
        };
        float[][] three = new float[][] {
            new float[] {-1,1},
            new float[] {1,1},
            new float[] {1,1},
            new float[] {-1,0},
            new float[] {-1,0},
            new float[] {1,-1},
            new float[] {1,-1},
            new float[] {-1,-1},
        };
        float[][] four = new float[][] {
            new float[] {-1,1},
            new float[] {-1,0},
            new float[] {-1,0},
            new float[] {1,0},
            new float[] {1,1},
            new float[] {1,-1},
        };
        float[][] five = new float[][] {
            new float[] {1,1},
            new float[] {-1,1},
            new float[] {-1,1},
            new float[] {-1,0},
            new float[] {-1,0},
            new float[] {1,0},
            new float[] {1,0},
            new float[] {1,-1},
            new float[] {1,-1},
            new float[] {-1,-1},
        };

        switch (num) {
            case 1:
                drawLines(one, scale, x+scale*10+50, y);
                break;
            case 2:
                drawLines(two, scale, x+scale*10+50, y);
                break;
            case 3:
                drawLines(three, scale, x+scale*10+50, y);
                break;
            case 4:
                drawLines(four, scale, x+scale*10+50, y);
                break;
            case 5:
                drawLines(five, scale, x+scale*10+50, y);
                break;
            default:
                break;
        }
    }

    public static void drawPolygon(int sides, double size, double x, double y, java.awt.Color penColor) {
        if (sides < 3) {
            System.err.println("Sides must be greater than 3!");
            return;
        }

        double angAmm = (3.14159265*2)/sides;

        turt.penColor(penColor);
        turt.up();
        turt.setPosition(size+x, y);
        turt.down();
        timesTurned++;

        for(int i=1;i<sides+1;i++) {
            double a = angAmm*i;
            timesTurned++;

            turt.setPosition(size*Math.cos(a)+x, size*Math.sin(a)+y);
        }
    }

    public static void main(String[] args) {
        turt.speed(10);

        // Task 1: Draw a regular shape
        drawTaskNum(1, 10, -200, 220);
        drawPolygon(6,20,-200,180, new java.awt.Color(0,0,0));

        // Task 2: Draw a regular shape many times
        drawTaskNum(2, 10, -200, 130);
        for(int i=0;i<9;i++) {
            drawPolygon(i+3,20,i*40 - 200,90, new java.awt.Color(255, i*255/9, 64));
        }

        // Task 3: How many times does Turtle turn!
        drawTaskNum(3, 10, -200, 40);
        timesTurned = 0;
        for(int i=0;i<9;i++) {
            drawPolygon(9-i+3,20,i*40 - 200,-10, new java.awt.Color(64, i*255/9, 255));
        }
        System.out.println("Turt has turned "+timesTurned+" times!");

        // Extension 1:


        // Extension 2:
        drawTaskNum(4, 10, -200, -50);
        for(int i=0;i<9;i++) {
            drawPolygon((int)(Math.random()*7)+3,40*Math.random(),i*40 - 200,-110, new java.awt.Color(255, 64, i*255/9));
        }

    }
}
