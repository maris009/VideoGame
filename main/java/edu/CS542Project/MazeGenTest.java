package edu.CS542Project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static java.lang.Math.abs;

public class MazeGenTest {
    // maze size
    int maze_size;
    // maze
    int [][] maze;

    String [][] MAZE;

    int GRASS = 0;
    int Finish = 2;
    int WALL = 1;

    public MazeGenTest(int size)
    {
        maze_size = size;

        maze = new int[maze_size][maze_size];
        MAZE = new String[maze_size][maze_size];

        for(int i=0;i<maze_size;i++){
            maze[0][i]=WALL;
            maze[i][0]=WALL;
            maze[maze_size-1][i]=WALL;
            maze[i][maze_size-1]=WALL;
        }

        mazeGenerate(1,1, maze_size-2, maze_size-2);

        maze[1][0]=GRASS;
        maze[maze_size-2][maze_size-1]=Finish;

        for(int i=0;i<maze_size;i++){
            for(int j=0;j<maze_size;j++){
                if(maze[i][j]==WALL){
                    MAZE[i][j] = "w";
                }else if(maze[i][j] == GRASS){
                    MAZE[i][j] = "G";
                }else{
                    MAZE[i][j] = "F";
                }
            }
            //System.out.print("\n");
        }

        writeFile();
    }

    public void mazeGenerate(int x1, int y1, int x2, int y2){
        // determine if it can be divided
        if(x2 - x1 < 2 || y2 - y1 < 2)
        {
            return;
        }

        // random pick one point
        Random random = new Random();
        int x = x1 + 1 + abs(random.nextInt()) % (x2 - x1 - 1);
        int y = y1 + 1 + abs(random.nextInt()) % (y2 - y1 - 1);

        // create the wall
        for(int i = x1; i <= x2; i++)
        {
            maze[i][y] = WALL;
        }
        for(int i = y1; i <= y2; i++)
        {
            maze[x][i] = WALL;
        }

        // recursively divided
        mazeGenerate(x1, y1, x-1, y-1);
        mazeGenerate(x+1, y+1, x2, y2);
        mazeGenerate(x+1, y1, x2, y-1);
        mazeGenerate(x1, y+1, x-1, y2);

        // randomly pick three walls
        int [] walls = {0,0,0,0};
        walls[abs(random.nextInt())%4] = 1;

        // randomly break the wall
        for(int i = 0; i < 4; i++)
        {
            if(walls[i] == 0)
            {
                int rx = x;
                int ry = y;

                switch(i){

                    case 0:

                        do {
                              rx = x1 + abs(random.nextInt()) % (x-x1);
                        } while(maze[rx-1][ry] + maze[rx+1][ry] + maze[rx][ry-1] + maze[rx][ry+1] > 2*WALL);
                        break;
                    case 1:

                        do {
                            ry = y + 1 + abs(random.nextInt()) % (y2-y);
                        } while(maze[rx-1][ry] + maze[rx+1][ry] + maze[rx][ry-1] + maze[rx][ry+1] > 2*WALL);
                        break;
                    case 2:

                        do {
                            rx=x+1+ abs(random.nextInt())%(x2-x);
                        } while(maze[rx-1][ry]+maze[rx+1][ry]+maze[rx][ry-1]+maze[rx][ry+1]>2*WALL);
                        break;
                    case 3:

                        do {
                            ry=y1+ abs(random.nextInt())%(y-y1);
                        } while(maze[rx-1][ry]+maze[rx+1][ry]+maze[rx][ry-1]+maze[rx][ry+1]>2*WALL);
                        break;
                    default:
                        break;
                }

                maze[rx][ry] = GRASS;
            }
        }


    }

    public void writeFile()
    {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\map\\map.txt");
            for (int i = 0; i < maze_size; i++) {
                for (int j = 0; j < maze_size; j++) {
                    writer.write(MAZE[j][i]);
                }
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e)
        {
            System.out.println("An error occurred!");
        }
    }

    public static void main( String[] args ) {


        MazeGenTest mazeGenTest = new MazeGenTest(28);//28

    }
}

