
public class Player 
{
	
	
    //initialize your fields in the constructor
	private  double tot_balance;
	private double tot_bet;
	
	

	private Hand hand;
	
    public Player(double balance)
    {
    	tot_balance = balance;
    	tot_bet = 0;
  
    	hand = new Hand();
    }



    public void deal(Card c)
    {
    	hand.addCard(c);
    

    }



    //Returns an array of Cards that the Player wishes to discard.

    //The game engine will call deal() on this player for each card

    //that exists in the return value. MS2 Instructions: Print the hand to

    //the terminal using System.out.println and ask the user which cards

    //they would like to discard. The user will first the number of cards they

    //wish to discard, followed by the indices, one at a time, of

    //the card(s) they would like to discard,

    //Return an array with the appropriate Card objects

    //that have been discarded, and remove the Card objects from this

    //player's hand. Use IO.readInt() for all inputs. In cases of error

    //re-ask the user for input.

    //

    // Example call to discard():

    //

    // This is your hand:

    // 0: Ace of Hearts

    // 1: 2 of Diamonds

    // 2: 5 of Hearts

    // 3: Jack of Spades

    // 4: Ace of Clubs

    // How many cards would you like to discard?

    // 2

    // 1

    // 2

    //

    // The resultant array will contain the 2 of Diamonds and the 5 of hearts in that order

    // This player's hand will now only have 3 cards

    public Card[] discard()
    {	
    	
    	//Prints the Hand
    	int counter = 0;
    	for(int i = 0; i < 5; i++)
    	{ 
    		System.out.println(counter + " : " + hand.getCard(i));
    		counter++;
    	}
    	System.out.println();

    	//Ask For Users Input
    	System.out.println("How many cards will you like to discard?");
    	int discardNum = IO.readInt();
    	
    	//If User Input Is Greater Than The Amount Of Card In The Deck
    	while(discardNum > 5) //Repeats till user inputs a valid number
    	{
    		`	System.out.println("Error! Invalid Discard Amouunt, Please Enter A Vaild Amount.");
    		discardNum = IO.readInt();
    	}
    	
    	Card[] disposed = new Card[discardNum];
    	int[] holder = {-97654, -97654, -97654, -97654,-97654};
    	int op = 0;
    	for(int j = 0; j < discardNum; j++)
    	{
    		
    		System.out.println("Pick a card");
    		int index = IO.readInt();
    		
    		while(index >= 5)
    		{
    			System.out.println("Invalid, please pick again!");
    			index = IO.readInt();
    		}
    		if(op != 0)
    		{
    			boolean check = false;
    			while(check == false)
    			{
    				for(int k = 0; k < 5; k++)
    				{
    					if(index == holder[k])
    					{
    						break;
    					}
    					else if(k == 4 && index != holder[k])
    					{
    						check = true;
    					}
    				}
    				if(check == false)
    				{
    				System.out.println("Invalid! Pick a different index");
    				index = IO.readInt();
    				}
    			}
    		}
    		disposed[j] = hand.getCard(index);
    		holder[j] = index;
    		op++;
    	}
    	
    return disposed;
    
    	
    	
    	
    	
    
    }



    //Returns the amount that this player would like to wager, returns

    //-1.0 to fold hand. Any non zero wager should immediately be deducted

    //from this player's balance. This player's balance can never be below

    // 0 at any time. This player's wager must be >= to the parameter min

    // MS2 Instructions: Show the user the minimum bet via the terminal

    //(System.out.println), and ask the user for their wager. Use

    //IO.readDouble() for input. In cases of error re-ask the user for

    //input.

    //

    // Example call to wager()

    //

    // How much do you want to wager?

    // 200

    //

    // This will result in this player's balance reduced by 200

    

    public double wager(double min)
    {
    	
    	//ya foofoo codee
    	/*
    	double amount = 0.0;
    	System.out.println("How much do you care to wager: ");
    	amount = IO.readDouble();
    	tot_bet = amount;
    	tot_balance = tot_balance - amount;
    	
    	
    	
    	if(tot_balance <= min)
    	{
    		System.out.println("Your balance is negative, you lost");
    		return -1;
    	}

    	return min;
		*/
    	
    	
    	//My elite code that doesnt subrtact 
    	
    	double WagerAmount = 0; // initialize wager amount 

    	System.out.println("The minimum bet is " + min);

    	    System.out.println("How much you want to wager?");
    	WagerAmount = IO.readDouble();

    	// Balance can never be below 0
    	if (tot_balance <= 0) {
    	System.out.println("Balance is less than or equal to 0, enter another amount for your wager");
    	WagerAmount = IO.readDouble(); }

    	// if balance is less than minimum bet, the player loses
    	if (tot_balance < min){
    	this.winnings(0); } 

    	// players wager must be >= to the parameter min, they can bet
    	if (tot_balance >= min)
    	{

    	// Any non zero wager is immediately deducted from players balance
    	if (WagerAmount >= min)
    	{
    	tot_balance =  tot_balance - WagerAmount;
    	tot_bet = WagerAmount;
    	
    	
    	}
    	// if wager is a negative number
    	if(WagerAmount < -1.0){
    	System.out.println("Wager cannot be a negative number, enter another wager amount");
    	WagerAmount =IO.readDouble(); 
    	}

    	while (WagerAmount > tot_balance){
    	System.out.println("Your wager amount is more than your balance, enter another amount");
    	WagerAmount = IO.readDouble(); 
    	}

    	// returns -1.0 to fold hand
    	if (WagerAmount == -1.0) {
    	this.winnings(0);
    	}

    	if(WagerAmount < min && WagerAmount !=-1){
    	System.out.println("Your wager amount is less than the minimum, please enter another amount");
    	WagerAmount= IO.readDouble(); 
    	}
    	}
    	return WagerAmount;
    	
    	
    	
    	
    	
    	
    
    }



    //Returns this player's hand

    public Hand showHand()
    {
    	return hand;
        

    }



    //Returns this player's current balance

    public double getBalance()
    {
    	return tot_balance;
        

    }



    //Increase player's balance by the amount specified in the parameter,

    //then reset player's hand in preparation for next round. Amount will

    //be 0 if player has lost hand

    public void winnings(double amount)
    {
    	if(amount != 0)
    	{
    	tot_balance =  amount + tot_bet;
    	hand.clear();
    	}
    	else
    	{
    		tot_balance = tot_balance + amount;
        	hand.clear();
    	}
    }

}
