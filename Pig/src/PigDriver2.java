
import java.util.*;
public class PigDriver2 
{
	
	public static void main(String [] args)
	{
		User player = new User();
		User computer = new User();
		PairOfDice dice = new PairOfDice();
		Scanner scan = new Scanner(System.in);
		
		
		// start game loop
		while(player.getScore() < 100 || computer.getScore() < 100)
		{
			
			String choice = "";
			char command = '0';
			//int score = player.getScore();
			int score = 0;
			// start player loop
			while( command != 'p' || command != 'q')
			{
				
				System.out.println("Select (p) for pass or (r) for roll");
				choice = scan.next().toLowerCase();
				command = choice.charAt(0);
				if(command == 'r' )
				{
					
					score += dice.roll();
					System.out.println(dice.toString());
					System.out.println(score + player.getScore());
					
					if(dice.getDie1FaceValue() == 1 
							&& dice.getDie2FaceValue() == 1)
					{
						player.resetScore();
						score = 0;
						choice = "p";
						System.out.println("you rolled two 1s");
						command = 'p';
					}
					if(dice.getDie1FaceValue() == 1 
							|| dice.getDie2FaceValue() == 1)
					{
						score = 0;
						choice = "p";
						System.out.println("you rolled a one");
						command = 'p';
					}
				}
				if(command == 'p')
				{
					player.addScore(score);
					System.out.println("Your score is " + player.getScore());
					System.out.println("------------------------------------");
					score = 0;
				}
				else 
				{
					//do nothing
				}
				
				if (score + player.getScore() >= 100 )
				{
					
					player.setIsWinner();
					System.out.println("Player Wins!");
					command = 'q';
				}
				
					if(command == 'q' || command == 'p')
					{
						break;
					}
			}
				
			
			if(command != 'q')
			{
				//score = computer.getScore();
				score = 0;
				choice = "";
				command ='0';
			}
			
			//Start Computer
				while(command != 'p' || command != 'q')
				{
					if(command == 'q')
					{
						break;
					}
					score += dice.roll();
					System.out.println(dice.toString());
					System.out.println(score + computer.getScore());
					
					if(dice.getDie1FaceValue() == 1 
							&& dice.getDie2FaceValue() == 1)
					{
						computer.resetScore();
						score = 0;
						choice = "p";
						System.out.println("the computer rolled two 1's");
						command = 'p';
					}
					else if(dice.getDie1FaceValue() == 1 
							|| dice.getDie2FaceValue() == 1)
					{
						score = 0;
						choice = "p";
						System.out.println("the computer rolled a 1");
						command = 'p';
					}
					else if(score >= 20 )
					{
						choice = "p";
						System.out.println("the computer passed");
						command = 'p';
					}
					
					
					if( command == 'p')
						{
							computer.addScore(score);
							System.out.println("Computer score is " 
							+ computer.getScore());
							System.out.println("----------------------------");
							score = 0;
						}
				
					if(computer.getScore() + score >= 100 )
					{
						
						System.out.println("Computer Wins!");
						computer.setIsWinner();
						command = 'q';
					}
					if(command == 'q' || command == 'p')
					{
						break;
					}
				// end computer loop
				}
				
			if(command == 'q')
			{
				break;
			}
		//end main game loop	
		}
	// end main method	
	}
//end class	
}
