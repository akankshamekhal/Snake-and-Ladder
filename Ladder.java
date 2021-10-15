package snake;
import java.io.*; 

public class Ladder
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader myInput2 = new BufferedReader (new InputStreamReader (System.in));
        
        System.out.println ("\t\t\t\t\t\tWelcome To Snakes And Ladders\n\n");
        System.out.println ("\t\t\t\t\t\t\tInstructions:");
        System.out.println ("\t\t\t This program will simulate a regular snakes and ladders game, where you will be");
        System.out.println ("\t\t\t facing the computer. You and the computer start at square 1, and the first one to");
        System.out.println ("\t\t\t square 100 wins, however, there will be preset squares which will be the snakes or ladders.");
        System.out.println ("\t\t\t Once you land on top of a snake you go down a few squares, and move up if you land");
        System.out.println ("\t\t\t\t\t\t on the bottom of a ladder. Good Luck and Have FUN!!!");
         int counter= 100,iteration=-1; 
        System.out.println ("-----------------------------------------------------Game Board-----------------------------------------------------");
        
       
        while (counter > 0){// start while
            if (counter%10 == 0 && counter != 100){
                if(iteration==-1)
                {
                    
                    counter-=9;
                    iteration=1;
                }
                else
                {
                    System.out.print(counter+"\t");
                    counter-=10;
                    iteration=-1;  
                }
                if(counter!=0)
                System.out.print("\n" + counter + "\t"); 
            }
            else
            System.out.print(counter + "\t"); 
            counter+=iteration; 
        }// end while
        System.out.println();
        System.out.println ("-------------------------------------------------------------------------------------------");
        String sGame = "y"; 
        System.out.print ("Do you want to play? Y or N     >  "); 
        sGame = myInput2.readLine (); 
        System.out.print ("\n\n\n\n\n\n");
       
        while (sGame.equals ("y") || sGame.equals ("Y"))
        {
            sGame = startGame(sGame); // give startGame a variable to work with
        }
        System.out.println ("\n\n\n\n\t\t\t\t\t\tSEE YA!!");
        } 
    
    public static String startGame (String start) throws IOException // Recieves data from the main method
    {// start startGame method
        
        BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));
        
        
        int userPosition = 1; 
        int compPosition = 1;
        int diceRoll = 0; 
        int diceRoll2 = 0;
        int userRoll = 1; 
        int compRoll = 1;
        String playAgain = "y"; 
         int snakesLaddersArray [] = new int [6]; 
       
        snakesLaddersArray [0] = 54;
        snakesLaddersArray [1] = 90;
        snakesLaddersArray [2] = 99;
        snakesLaddersArray [3] = 9;
        snakesLaddersArray [4] = 40;
        snakesLaddersArray [5] = 67;
      while (playAgain.equals ("y") || playAgain.equals ("Y"))
        {
            userRoll =  getDice(diceRoll, diceRoll2);
            compRoll =  getDice(diceRoll, diceRoll2); 
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println ("\t\t\t\t\t------------------------------------------");
            System.out.println ("\t\t\t\t\t|\tYou Rolled a " + userRoll + "\t\t|"); // print the roll the user got
            System.out.println ("\t\t\t\t\t|\tThe Computer Rolled a " + compRoll + "\t|"); // print the roll the computer got
            System.out.println ("\t\t\t\t\t------------------------------------------");
             userPosition = userPosition + userRoll;
            
            compPosition = compPosition + compRoll;
    
            userPosition = getP(userPosition, userRoll, snakesLaddersArray);
            
            compPosition = compgetP(compPosition, compRoll, snakesLaddersArray, userPosition);
            
            System.out.println("\t\t\t*****************************************************************");
            System.out.println ("\t\t\t*\t\tYou are currently on square " + userPosition + "\t\t\t*"); 
            System.out.println ("\t\t\t*\t\tThe Computer is currently on square " + compPosition + "\t\t*");
            System.out.println("\t\t\t*****************************************************************");
            
            
            if (userPosition == 100 || compPosition == 100)
            {
                userPosition = 1;
                compPosition = 1;
              
                System.out.print ("Do you want to play? Y or N     >  ");
                playAgain = myInput.readLine ();
                System.out.print ("\n\n\n\n\n\n\n\n\n\n\n\n");
            }
            else
            {
                // asks the user if we wants to continue playing
                System.out.print ("Do you want to play? Y or N     >  ");
                playAgain = myInput.readLine ();
                }
        }
        
        return playAgain; 
        }
    public static int getDice (int diceRoll, int diceRoll2)
    {
        diceRoll = (int)(Math.random()*6 )+1 ; //creates dice roll number 1
        diceRoll2 = (int)(Math.random()*6 )+1 ; //creates dice roll number 2
        int move = diceRoll + diceRoll2;
        return move; 
    }
    public static int getP (int userPosition, int userRoll, int snakesLaddersArray []) throws IOException // recieves two parameter from startGame
    {
        if(userPosition == snakesLaddersArray[0]) //if position equals snake 1
        {
            userPosition = 19; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[1]) //if position equals snake 2
        {
            userPosition = 48; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
            
        }
        else if (userPosition == snakesLaddersArray[2]) //if position equals snake 3
        {
            userPosition = 77; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[3]) //if position equals ladder 1
        {
            userPosition = 34; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
            
        }
        else if (userPosition == snakesLaddersArray[4]) //if position equals ladder 2
        {
            userPosition = 64; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
            
        }
        else if (userPosition == snakesLaddersArray[5]) //if position equals ladder 3
        {
            
           userPosition = 86; // set new position
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
        }
        
        if (userPosition < 0 || userPosition > 112) 
        {
            System.out.println ("An error has occured please reset the game!!!!!!");
        }
        
        else if (userPosition > 100) 
        {
            userPosition = userPosition - userRoll; 
            System.out.println ("OHHH You cant jump, you must land on a 100");
            
        }
        else if (userPosition == 100)
        {
            System.out.println ("YOU WON, GOOD JOB!!!"); // print out that the user won
            
        }
      return userPosition; 
    }
  public static int compgetP (int compPosition, int compRoll, int snakesLaddersArray [], int userPosition) throws IOException
    {
        
        if(compPosition == snakesLaddersArray[0])
        {
            compPosition = 19;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
            }
        else if (compPosition == snakesLaddersArray[1])
        {
            compPosition = 48;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
          }
        else if (compPosition == snakesLaddersArray[2])
        {
            compPosition = 77;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (compPosition == snakesLaddersArray[3])
        {
            compPosition = 34;
            System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
        }
        else if (compPosition == snakesLaddersArray[4])
        {
            compPosition = 64;
            System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
            
        }
        else if (compPosition == snakesLaddersArray[5])
        {
            compPosition = 86;
            System.out.println ("Computer Got TO A Ladder, HE WENT UP!!!");
        }
      if (compPosition < 0 || compPosition > 112) //  ERROR TRAP to catch any unwanted system errors that may occur by chance
        {
            System.out.println ("An error has occured for the computer, please reset the game!!!!!!");
        }
        
        else if (compPosition > 100) // checks if computers's location if greater then a 100
        {
            compPosition = compPosition - compRoll; // get old position
            System.out.println ("THE COMPUTER CAN'T JUMP!!! He must land on a 100"); // give message that the computer cant jump
            
        }
        else if (compPosition == 100 && userPosition != 100)
        {
            System.out.println ("THE COMPUTER WON, YOU FAILED!!!"); // print out that the computer won
            
        }
         return compPosition;  
    } 
}
