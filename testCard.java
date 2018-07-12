
public class testCard 
{
	public static void main(String args[])
	{
		System.out.println("Welcome to Poker");
		
		//Makes hand
		Hand hand = new Hand();
		Hand h = new Hand();

		
		Card card1 = new Card(2,3);
		Card card2 = new Card(13,3);
		Card card3 = new Card(9,3);
		Card card4 = new Card(10,3);
		Card card5 = new Card(5,3);
		
				

		hand.addCard(card1);
		hand.addCard(card2);
		hand.addCard(card3);
		hand.addCard(card4);
		hand.addCard(card5);
		
		
		
		Card card1a = new Card(2,3);
		Card card2a = new Card(13,3);
		Card card3a = new Card(9,3);
		Card card4a = new Card(10,3);
		Card card5a = new Card(5,3);
		
				

		h.addCard(card1a);
		h.addCard(card2a);
		h.addCard(card3a);
		h.addCard(card4a);
		h.addCard(card5a);

		
		hand.printHand();
		
		System.out.println("Number of pairs in this hand is " + hand.numPairs());
		
		if(hand.hasTriplet() == true)
		{
			System.out.println("The hand contains a triplet");
		}else {
			System.out.println("This hand does not contains a triplet");
		}
		//System.out.println(hand.hasTriplet());
		
		
		
		
		System.out.println("Has Flush: " +  hand.hasFlush());
		
//Has straight
		System.out.println("Has straight: " + hand.hasStraight());
		
		
		System.out.println("Has Full House: "  + hand.hasFullHouse());
		
		
		System.out.println("Has 4 of a kind: " + hand.hasFourOfAKind());
	
		System.out.println("The highest value is: " + hand.highestValue());
		
	}
	
	

}
