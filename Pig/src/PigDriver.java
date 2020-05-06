import java.util.*;
public class PigDriver 
{
	/* game that allows you to play against a computer in a dice rolling game.
	* each round a player will roll two dice. 
	* if you roll a 1 with both dice then your total score resets to 0.
	* if you roll a single 1 your score from that round is reset.
	* you are given the opportunity to roll (r) or Pass (p) 
	* once you pass your score is saved from a round reset but not from two 1s
	* race to 100 points. 
	* the computer will pass after scoring 25 points.
	*/
	
	public static void main(String [] args)
	{
		User player = new User();
		User computer = new User();
		PairOfDice dice = new PairOfDice();
		Scanner scan = new Scanner(System.in);
		
		
		if(noWinner(player,computer)==false)
		{
			System.out.println("False!");
		}
		while(noWinner(player,computer))
		{
			
			String choice = "";
			char command = '0';
			int score = 0;
			while(choice.compareToIgnoreCase("p") != 0 /*command != 'p'*/)
			{
				System.out.println("Select (p) for pass or (r) for roll");
				choice = scan.next().toLowerCase();
				//command = choice.charAt(0);
				if(/*command == 'r'*/ choice.equalsIgnoreCase("r"))
				{
					score += dice.roll();
					System.out.println(dice.toString());
					System.out.println(score);
					// if both dice are 1 then your total score is set to zero 
					if(dice.getDie1FaceValue() == 1 
							&& dice.getDie2FaceValue() == 1)
					{
						player.resetScore();
						score = 0;
						choice = "p";
						System.out.println("you rolled two 1s");
						//command = 'p';
					}
					// if either die is a one then the score from that round is set to zero
					if(dice.getDie1FaceValue() == 1 
							|| dice.getDie2FaceValue() == 1)
					{
						score = 0;
						choice = "p";
						System.out.println("you rolled a one");
						//command = 'p';
					}
				}
				if(/*command == 'p'*/ choice.equalsIgnoreCase("p"))
				{
					player.addScore(score);
					System.out.println("Your score is " + player.getScore());
				}
				else 
				{
					//do nothing
				}
				
				if (player.getScore() + score >= 100)
				{
					player.addScore(score);
					noWinner(player, computer);
					System.out.println("Player Wins!");
				}
				
			}
				
			
			if(noWinner(player, computer))
			{
				score = 0;
				choice = "";
				command ='0';
			}
			//Start Computer
				while(/* command != 'p'*/ choice.compareToIgnoreCase("p") != 0)
				{
					score += dice.roll();
					System.out.println(dice.toString());
					System.out.println(score);
					
					if(dice.getDie1FaceValue() == 1 
							&& dice.getDie2FaceValue() == 1)
					{
						computer.resetScore();
						score = 0;
						choice = "p";
						System.out.println("the computer rolled two 1's");
						//command = 'p';
					}
					else if(dice.getDie1FaceValue() == 1 
							|| dice.getDie2FaceValue() == 1)
					{
						score = 0;
						choice = "p";
						System.out.println("the computer rolled a 1");
						//command = 'p';
					}
					else if(score >= 20 )
					{
						choice = "p";
						System.out.println("the computer scored 20");
						//command = 'p';
					}
					
					
					if(choice.equalsIgnoreCase("p"))
						{
							computer.addScore(score);
							System.out.println("Computer score is " 
							+ computer.getScore());
							System.out.println("-------------------------------------");

						}
					
					if(computer.getScore() >= 100)
					{
						noWinner(player, computer);
						System.out.println("Computer Wins!");
					}
					
				}
				
			
		}
		
		
			
		
	}
	
	public static boolean noWinner(User player, User computer)
	{
		boolean noWin = true;
		
		if(player.getScore() >= 100 || computer.getScore() >= 100)
		{
			
			noWin = false;
			System.out.println(noWin);
		}
		
		return noWin;
	}
}
