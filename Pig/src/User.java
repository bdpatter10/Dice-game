
public class User 
{
	private int score;
	private boolean isWinner;
	
	public User()
	{
		score = 0; 
		isWinner = false;
	}
	
	public boolean getIsWinner()
	{
		return isWinner;
	}
	
	public void setIsWinner()
	{
		isWinner = true;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public void resetScore()
	{
		score = 0;
	}
	
	public void addScore(int add)
	{
		score += add;
	}
	
	public boolean noWinner()
	{
		boolean noWin = true;
		
		if(getScore() >= 100 )
		{
			
			noWin = false;
			System.out.println(noWin);
		}
		
		return noWin;
	}

	

}
