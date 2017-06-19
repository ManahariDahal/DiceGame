// Name: Manahari Dahal     Date Assigned: 16 March 2017

// Course: CSCI 2003 42733  Date Due: 23 March 2017

// Instructor: Ms. Greer
//
// File name: DiceGame
//
// Program Description: This program recreates a dice game called “Run for it!”. The goal of the game is to roll
//                      numbers that can be arranged into sequences of numbers that start with one (ex: 1, 2 or 1, 2, 3, etc.).


import java.util.Scanner;        // importing Scanner object to allow user to input
import java.util.Random;         // importing random class to generate random numbers
   
public class DiceGame            // main class
{  
   public static void main(String[] args)
   {  
    
      int scorePlayer1 = 0;      // scorePlayer1 variable is initialized
      int scorePlayer2 = 0;      // scorePlayer2 variable is initialized
      int player1 = 1;             // player1 variable is initialized
      int player2 = 2;             // player2 variable is initialized
      String enter = "";         // enter variabale is stored to an empty string
      String casual = "";        // casuak variabale is stored to an empty string
      boolean start = true;      // start is referred to boolean value of true
      
      
      
      // Importing Scanner object to allow user to input a data
      Scanner in = new Scanner(System.in);
      Random generator = new Random(); // generator object is used to generate random numbers
      
      
      // Displaying user's desired layout
      System.out.print("Run For It! - A Dice Game\n\n");
      System.out.print("Rules\n");
      System.out.print("=====\n");
      
      System.out.println("1. 2 players take turns rolling 6 dice.\n");
      System.out.println("2. Get points if roll contains one or more sequences.\n");
      System.out.println("    1. Sequence must start from 1 and not skip any numbers.\n");
      System.out.println("    2. Get 5 points for each number in the sequence(s).");
      
      System.out.println("\n3. Get no points if roll contains no sequences.\n");
      System.out.println("4. First player to get to 100 points wins.");
      System.out.println("\n=======================================");
      
       
      // using if-elseif statement to check among the two players who have scored 100 points first  
      do {
         if (scorePlayer1 >= 100 || scorePlayer2 >= 100){
            
            if (scorePlayer2 >= 100)
            {
               System.out.println("\n            Player 2 wins!         ");
               System.out.println("\n=======================================");  // printing message when player2 wins
            }
            
            else
            {
               System.out.println("\n            Player 1 wins!         ");
               System.out.println("\n=======================================");  // printing message when player1 wins
            }
           
            break; // loop is terminated
         }
         casual = "";
         
         
         // using for statement for the game to be played alternatively by player1 and player2
         for (int x = 0; x < 6; x++) {         
            casual += generator.nextInt(6) + 1;  
         }
            if (player2 == 1)
            {
               player2 = 2;
            }
            else           // alternating play between two players
            {
               player2 = 1;
            }  
            
                
        System.out.print("\nPlayer "+ player2 +" - Enter R to roll: "); /* printing message when the players play and assigning to
                                                                           their player name i.e player1 and player2 */
        enter = in.nextLine(); // allowing for input
        System.out.print("\nRoll: ");    // displaying roll
         
         // using for statement to find the sequence 
         for (int y = 0; y < casual.length(); y++)
         {
            System.out.print(casual.charAt(y) + " ");
         }
         
         //printing new line
         System.out.println("\n");
                  
           
      // variables are initialized with int and string and boolean
      int uno = 0;
      int curb = 1; 
      boolean banner = false;  //setting banner to boolean value of false
      String word = casual;
      String sequence = "";
      
      int numero = word.length();
      //using for statement to determine if the random numbers have sequence or not
      for (int i = 0; i < numero; i++){
         if (("" +word.charAt(i)).equals("1") ) // starts from the number 1 and starts looking for other numbers
         {
            uno += 1;
         }
      }      
      
      // displays sequence of numbers less than or equal to 6
      for (int j = 0; j < uno; j++){
         curb = 1;
         
         do{
            numero = word.length(); // returns the length of numero
                        
            for (int i = 0; i < numero; i++){  
               
               banner = false; // checks if the breaking point is 1 or not
               
               // checks if the roll has sequence starting from 1 and adds the total if it does
               if (("" + word.charAt(i)).equals("" + curb)){
               
                  sequence += curb;
                  banner = true;
                  curb += 1; 
                                                 
                  word = word.substring(0, i) + word.substring(i + 1, word.length());

                  break; // loop is terminated                   
               }
            }
         }         
         while (word.length() != 0 && banner); 
         sequence += "e"; // adds the score to sequence     
      }

         
      // variables are initialized
      int zoo = 0; 
      int score = 0;  
      int no = 0;   
      String ep = sequence;
      zoo = ep.indexOf('e'); //returns the index within this string of the first occurrence of the specified character(e) or -1
      String kane = "";
      
      // start has boolean value of true
      start = true;
      boolean p = false;   // the Boolean object corresponding to the primitive value false  
           
      while (zoo != -1)
      {  
         if (zoo == 0 && start)
         {
                        
            start = false; // the Boolean object corresponding to the primitive value false
            
            break; // terminates the loop
         }
         
         else if (zoo == 0)
         {
            break; //terminates the loop
         }
         
         kane = ""; // kane has empty value
         
         kane += ep.substring(0, zoo); // it checks the index from 0 upto the position of zoo
         
         // if length is greater than zoo then ep adds it's length
         if ((zoo + 1) < ep.length())
         {
            ep = ep.substring(zoo + 1, ep.length());         
         }
         
         else // or else it returns empty value
         { 
            ep = "";
         }
         
         if (kane.indexOf("2") != -1) // checks if the index of the number occurs
         {  
            no += 1;
            
            // printing sequence number layout
            System.out.println("Sequence " + no + ": " + kane); // prints the sequence number
            
            p = true; // the Boolean object corresponding to the primitive value true
            
            
            score += kane.length() * 5; // 10 score is added if the sequence is 12, 15 is added if it is 123 and so on
         } 
         
         zoo = ep.indexOf("e");  //returns the index within this string of the first occurrence of the specified character or -1     
         
      }
     
      if ( player2 == 1 )
      {
         // if player1 has sequence then it adds points to his total
         scorePlayer1 += score;  
      }
      
      else
      {
         // if player2 has sequence then it adds points to his total
         scorePlayer2 += score;
      }
      if (!p)
      {
         System.out.println("No Sequence!");  // if the code has no sequence then it returns this statement
      }
      
      
      // printing user's desired layout
      System.out.println( "\nPlayer 1 score: " + scorePlayer1);      
      System.out.println( "Player 2 score: " + scorePlayer2 + "\n");
      System.out.println("=======================================");
         
      } 
      while( enter.equals("R") ); // when user enters 'R' then the code is processed    
      
   }  
} 