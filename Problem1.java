
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{
   int[] beeperColumns = new int[8];
   int [] sortedColumns = new int[8];
   int column;
   int avenue =0;
    int index = 0;
  
   public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
   public void sortBeepers() {
        runRace();
        printArray(beeperColumns);
        sortColumnsList();
    }
   public void sortColumnsList(){
       for (int index = 0; index<beeperColumns.length-1;index++){
           if (beeperColumns[index]< beeperColumns[index +1]){
               sortedColumns[index] = beeperColumns[index];
            }
       }
    }
   public void runRace() {
            for(int i =0; i < 8; i++) {
            collectBeepers();
        }
    }
   public void collectBeepers(){
       faceEast();
       findABeeperColumn();
       collectColumn();
       returnToFloor();
    }
   public void faceEast(){
        while(!facingEast()){
            turnLeft();
        }
    }
   public void findABeeperColumn(){
            faceEast();
            while(!nextToABeeper() && avenue < 9) {
                move();
                avenue++;
            }
        
    }
   public void collectColumn(){
        turnLeft();
       
        column = 0;
        while (nextToABeeper()){
            if (nextToABeeper()){
                pickBeeper();
                column++;
                move();
            }
            else{
                returnToFloor();
            }
            //index++;
        }
        
        beeperColumns[index] = column;
        index++;
    }
   public void returnToFloor(){
        turnLeft();
        turnLeft();
        while (frontIsClear()){
            move();
        }
        turnLeft();
        if  (frontIsClear()){
            findABeeperColumn();
        }
        else{
            //
        }
    }
    
   public void printArray(int[] arr){
        System.out.println("The array is: ");
        for(int i = 0 ; i< arr.length; i++) {
            System.out.print(arr[i]+ ", ");
        }
        System.out.println();
    }
}

