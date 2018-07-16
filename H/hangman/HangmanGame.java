package hangman;

public class HangmanGame
{

	private String secretWord;
	private char[] dashes;
	private int lives; 
	
	//constructor
	//sets secretWord
	//creates and initialises dashes with correct no of dashes
	//sets lives to default value 8
	public HangmanGame(String wordIn)
	{
		secretWord = wordIn;
		dashes = new char[secretWord.length()];
		fillDashes();
		lives = 8;  //default
	}
   
	//rename this
	//checks if letter guessed is in secretword
	//if it is - puts letter in correct location in dashes[]
	//else lose a life
	public void guessLetter(char letterIn)
	{
		boolean found = false;
		for(int i = 0; i<secretWord.length(); i++)
		{
			if(letterIn == secretWord.charAt(i)){
				dashes[i] = letterIn;
				found = true;
			}	
		}
		if(!found)
			lives--;
	
	}
	
	//returns true when game over - correct word guessed or 0 lives left
	//otherwise returns false
	public boolean gameOver()
	{
		if(secretWord.equalsIgnoreCase(showDashes()) || lives == 0)
			return true;
		else 
			return false;
			
		//return secretWord.equalsIgnoreCase(showDashes()) || lives == 0;

	}
	
	//returns the secretword
	public String showSecretWord()
	{
		return secretWord;
	}
	
	//method to show the chars in dashes - 
	//returns a string made up of either dashes or correct letter
	public String showDashes()
	{
		String s ="";
		for(int i = 0; i< dashes.length; i++)
			s +=dashes[i];
		
		return s;
	}
	
	//method initialises  dashes[] with dashes at start of game
	public void fillDashes()
	{
		for(int i = 0; i< dashes.length; i++)
		dashes[i]='-';		
	}
	
	//returns the num of lives left
	public int getLives()
	{
		return lives;
	}
	
	//sets the number of lives
	public void setLives(int livesIn)
	{
		lives = livesIn;
	}
}