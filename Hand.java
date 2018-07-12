/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */
public class Hand 
{
    //Global Variables
   public int pairAccount = 0;
   public int tripleAccount = 0;
   public int pair_holder;
   public int pairPosition;
   public int pairPosition2;
   public int pair2_holder;
   public int pair2Position;
   public int pair2Position2;
   public int triple_holder;
   public int triplePosition;
   public int triplePosition2;
   public int extraPair_holder;
   public int extraPair_holder2;
   public int triple_holder2;
   public int tripleAccount2 = 0;
   public int pairAccount2 = 0;
   public int tripleCheck = 0;
   public int fullHouse = 0;
   public int highestCardCheck = 0;

   private Card[] hand;   // The cards in the hand.
   private int count; 
   
   /**
    * Create a hand that is initially empty.
    */
   public Hand() { 
      hand = new Card[5];
      count = 0;
   }
   
   /**
    * Remove all cards from the hand, leaving it empty.
    */
   public void clear() {
      for(int i=0 ; i<hand.length; i++){ hand[i] = null; }
      count = 0;
   }
   
   /**
    * Add a card to the hand.  It is added at the end of the current hand.
    * @param c the non-null card to be added.
    * @throws NullPointerException if the parameter c is null.
    */
   public void addCard(Card c) {
      
      for(int i=0 ; i<hand.length; i++){ 
        if (hand[i] == null){
            hand[i] = c;
            count = count + 1;
            break;
        }
     }

      
   }
   
   /**
    * Remove a card from the hand, if present.
    * @param c the card to be removed.  If c is null or if the card is not in 
    * the hand, then nothing is done.
    */
   public void removeCard(Card c) {

       	  for(int i=0 ; i<hand.length; i++)
       	  { 
    	    if (hand[i]!=null && hand[i].equals(c))
    	    {
    	      hand[i] = null;
    	      count = count-1;
    	    }
    	  


       	  }
   }
   
   /**
    * Remove the card in a specified position from the hand.
    * @param position the position of the card that is to be removed, where
    * positions are starting from zero.
    * @throws IllegalArgumentException if the position does not exist in
    * the hand, that is if the position is less than 0 or greater than
    * or equal to the number of cards in the hand.
    */
   public void removeCard(int position) 
   {

	   if (position < 0 || position >= hand.length)
	         throw new IllegalArgumentException("Position does not exist in hand: "
	               + position);
	      hand[position] = null;
	      count --;
	}	

   /**
    * Returns the number of cards in the hand.
    */
   public int getCardCount() {
      return count;
   }
   
   /**
    * Gets the card in a specified position in the hand.  (Note that this card
    * is not removed from the hand!)
    * @param position the position of the card that is to be returned
    * @throws IllegalArgumentException if position does not exist in the hand
    */
   public Card getCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
       return hand[position];
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same suit are
    * grouped together, and within a suit the cards are sorted by value.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortBySuit() {
      int size = count;
      int nonnull = 0;
      int index = 0;
      
      Card[] newHand = new Card[5];
      while (size > 0) {
         if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
         
         for (int i = nonnull+1; i < hand.length; i++) {
            Card c1 = hand[i];
            if (c1 != null){
                if ( c1.getSuit() < c.getSuit() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
                    pos = i;
                    c = c1;
                }
            }
         }
         hand[pos] = null;
         size = size - 1;
         newHand[index++] = c;
         nonnull = 0;
      }
      hand = newHand;
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same value are
    * grouped together.  Cards with the same value are sorted by suit.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortByValue() {
      int size = count;
      int nonnull = 0;
      int index = 0;
      
      Card[] newHand = new Card[5];
      while (size > 0) {
         if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
         
         for (int i = nonnull+1; i < hand.length; i++) {
            
            Card c1 = hand[i];
            if (c1 != null){
                if ( c1.getValue() < c.getValue() ||
                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
                    pos = i;
                    c = c1;
                }
            }
         }
         hand[pos] = null;
         size = size - 1;
         newHand[index++] = c;
         nonnull = 0;
      }
      hand = newHand;
   }
   
   public void printHand(){
       for(int i=0; i<hand.length; i++){
           if (hand[i] != null){
               System.out.println(hand[i]);
           }
       }
       System.out.println();
   }

    /******************************** Implement your methods here ****************************************/

    //Determines The amount of pairs in the deck
   public int numPairs()
   {
       // Variables
       int count;
       int pairs = 0;
       int stopper = 0; //To stop
       int secondStop = 0; //To stop

       for(int i = 0; i < hand.length; i++) {
           count = 0;
           for (int j = 0; j < hand.length; j++) {
               //Checks to see if there is a duplicate value
               if (hand[i].getValueAsString() == hand[j].getValueAsString()) {
                   //System.out.println(hand[i] + " , " + hand[j]);
                   count++;  //Increments count
                   //System.out.println(count);
               }
           }
           //System.out.println(count);

           //Found the same triplet twice
           if (count == 3 && stopper >= 1) {
               continue;
           }
           else if(count == 3 && tripleAccount != 0)
           {
               pairs++;
               stopper++;
               triple_holder2 = hand[i].getValue();
               triplePosition2 = i;
               tripleAccount2++;
           }

           //Found a triplet
           else if (count == 3 && tripleAccount == 0)
           //Checks to see if there was a triplet found, then there is a chance of anoth
           {
               pairs++;
               stopper++;
               tripleAccount++;
               triple_holder = hand[i].getValue();
               triplePosition = i;
           }
           //Found a pair againer double
           else if (count == 2 && secondStop == 1 && stopper == 0 && pairAccount != 1) {
               //Does check for possible double
               //Checks if the values are the same, if so not a possible pair
               if (extraPair_holder == hand[i].getValue()) {
                   continue;
               }
               //Is a pair
               else {
                   extraPair_holder2 = hand[i].getValue();
                   pair2Position2 = i;
                   pairs++;
                   pairAccount2++;
               }
           }
           else if (count == 2 && secondStop == 1 && stopper == 0 && pairAccount == 1) {
               //Does check for possible double
               //Checks if the values are the same, if so not a possible pair
               if (pair_holder == hand[i].getValue()) {
                   continue;
               }
               //Is a pair
               else {
                   pair2_holder = hand[i].getValue();
                   pair2Position = i;
                   pairs++;
                   pairAccount++;
               }
           }
           else if (count == 2 && secondStop == 1 && stopper > 0)
           {
               continue;
           }
           else if(count == 2 && pairAccount != 0)
           {
               pairs++;
               secondStop++;
               extraPair_holder = hand[i].getValue();
               pairPosition2 = i;
           }
           else if (count == 2 && pairAccount == 0) {
               pairs++;
               secondStop++;
               pairAccount++;
               pair_holder = hand[i].getValue();
               pairPosition = i;
           }

       }
       return pairs;
   }
   
 //Returns true if this hand has 3 cards 
   //that are of the same value
   public boolean hasTriplet()
   {
       if(tripleCheck == 0) {
        if (tripleAccount == 1) {
            tripleCheck++;
            return true;
        }
        else
        {
            tripleCheck++;
            return false;
        }
    }
       else if(tripleCheck != 0)
    {
        if (tripleAccount2 == 1) {
            return true;
        }
        else
        {
            return false;
        }
    }
       return false;
   }
   
 //Returns true if this hand has all cards that are of the
   //same suit
   public boolean hasFlush()
   {
       int j = 0;
       for(int i = 0; j < hand.length; j++)
       {
           if(hand[i].getSuitAsString() != hand[j].getSuitAsString())
           {
               return false;
           }
       }
       return true;
   }
   
 //Returns true if this hand has 5 consecutive 
   //cards of any suit

   public boolean hasStraight()
   {
       //Sorts the hand by value
       this.sortByValue();
       //Traverses through the hand to see if the numbers are consecutive
       for(int i = 0; i < hand.length-1; i++)
       {
           if(((1)+hand[i].getValue()) != hand[i+1].getValue())
           {
               return false;
           } 
       }
       return true;
   }
   
 //Returns true if this hand has a
   //triplet and a pair of different //values
    //Uses global variables as checks for both pairs and triplets are in the deck
   public boolean hasFullHouse() {
       if (fullHouse == 0) {
           if (tripleAccount == 1 && pairAccount == 1) {
               fullHouse++;
               return true;
           } else {//If checks fails
               fullHouse++;
               return false;
           }
       }
       else{
           if (tripleAccount2 == 1 && pairAccount2 == 1)
           {
               return true;
           } else {//If checks fails
               return false;
           }
       }
   }
 //Returns true if this hand has 4 cards that are of the 
   //same value
   public boolean hasFourOfAKind()
   {
       int max;
       boolean fourKind = false;

       for(int i = 0; i < hand.length; i++)
       {
           max = 0;
           for(int j = 0; j < hand.length; j++)
           {
               if( hand[i].getValueAsString() == hand[j].getValueAsString() )
               {
                   max++;
                   //System.out.println(max);
               } 
           }
             if(max == 4)
             {
                 fourKind = true;
                 break;
             }
       }
       return fourKind;
   }
   

 //Returns the card with the highest value in the hand.
   //When there is
 //more than one highest value card,
   //you may return any one of them

 public Card highestValue() 
 {
     //Sorts the hand
     this.sortByValue();
     //Last index of the hand should be the highest value card
     return this.getCard(4);
 }  

 
//Returns the highest valued Card 
 //of any pair or triplet found, null if
//none. When values are equal, you may return either

public Card highestDuplicate()
{
    //When both pair and triplet are found
    if(highestCardCheck == 0)
    {
        if (pairAccount == 1 && triple_holder == 1) {
            //When pair and triplet are the same values
            if (pair_holder == triple_holder) {
                highestCardCheck++;
                return this.getCard(pairPosition);
            }
            //when pair has the greater value
            else if (pair_holder > triple_holder) {
                highestCardCheck++;
                return this.getCard(pairPosition);
            }
            //When triplet has the greater vaule
            else {
                highestCardCheck++;
                return this.getCard(triplePosition);
            }
        } else if (pairAccount == 1 && tripleAccount == 0) {
            highestCardCheck++;
            return this.getCard(pairPosition);
        }
        //When there are 2 pairs
        else if (pairAccount == 2) {
            if (pair_holder > pair2_holder) {
                highestCardCheck++;
                return this.getCard(pairPosition);
            } else {
                highestCardCheck++;
                return this.getCard(pair2Position);
            }
        }
        else{
            highestCardCheck++;
            return null;
        }
    }
    else
    {
        if (pairAccount2 == 1 && triple_holder2 == 1) {
            //When pair and triplet are the same values
            if (extraPair_holder == triple_holder2) {
                return this.getCard(pairPosition2);
            }
            //when pair has the greater value
            else if (extraPair_holder > triple_holder2) {
                return this.getCard(pairPosition2);
            }
            //When triplet has the greater vaule
            else {
                return this.getCard(triplePosition2);
            }
        } else if (pairAccount2 == 1 && tripleAccount2 == 0) {
            return this.getCard(pairPosition2);
        }
        //When there are 2 pairs
        else if (pairAccount2 == 2) {
            if (extraPair_holder > extraPair_holder2) {
                return this.getCard(pairPosition2);
            } else {
                return this.getCard(pair2Position2);
            }
        }
        else{
            return null;
        }
    }
}
    //Returns -1 if the instance hand loses to the parameter hand, 0 if
    // the hands are equal, and +1 if the instance hand wins over the
    // parameter hand. Hint: you might want to use some of the methods
    // above

    public int compareTo(Hand h)
    {
    //Checks
    int num = h.numPairs();
    boolean triple = h.hasTriplet();
    boolean flush = h.hasFlush();
    boolean straight = h.hasStraight();
    boolean full = h.hasFullHouse();
    boolean four = h.hasFourOfAKind();
    h.highestValue();
    h.highestDuplicate();

    if(this.hasFourOfAKind() == true && four == false)
    {
        return 1;
    }
    else if(this.hasFourOfAKind() == false && four == true)
    {
        return -1;
    }
    else if(this.hasFourOfAKind() == true  && four == true)
    {
        if(this.highestValue().getValue() > h.highestValue().getValue())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    else if(this.hasFourOfAKind() == false && four == false)
    {
        if(this.hasFullHouse() == true && full == false)
        {
            return 1;
        }
        else if(this.hasFullHouse() == false && full == true)
        {
            return -1;
        }
        else if(this.hasFullHouse() == true  && full == true)
        {
            if(this.highestDuplicate().getValue() > h.highestDuplicate().getValue())
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
        else if(this.hasFullHouse() == false && full == false)
        {
            if(this.hasFlush() == true && flush == false)
            {
                return 1;
            }
            else if(this.hasFlush() == false && flush == true)
            {
                return -1;
            }
            else if(this.hasFlush() == true  && flush == true)
            {
                if(this.highestValue().getValue() > h.highestValue().getValue())
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            else if(this.hasFlush() == false && flush == false)
            {
                if(this.hasStraight() == true && straight == false)
                {
                    return 1;
                }
                else if(this.hasStraight() == false && straight == true)
                {
                    return -1;
                }
                else if(this.hasStraight() == true  && straight == true)
                {
                    if(this.highestValue().getValue() > h.highestValue().getValue())
                    {
                        return 1;
                    }
                    else
                    {
                        return -1;
                    }
                }
                else if(this.hasStraight() == false && straight == false)
                {
                    if(this.hasTriplet() == true && triple == false)
                    {
                        return 1;
                    }
                    else if(this.hasTriplet() == false && triple == true)
                    {
                        return -1;
                    }
                    else if(this.hasTriplet() == true  && triple == true)
                    {
                        if(this.highestDuplicate().getValue() > h.highestDuplicate().getValue())
                        {
                            return 1;
                        }
                        else
                        {
                            return -1;
                        }
                    }
                    else if(this.hasTriplet() == false && triple == false)
                    {
                        if(this.numPairs() > num)
                        {
                            return 1;
                        }
                        else if(this.numPairs() < num)
                        {
                            return -1;
                        }
                        else if (this.numPairs() == num)
                        {
                            if(this.highestValue().getValue() > h.highestValue().getValue())
                            {
                                return 1;
                            }
                            else if(this.highestValue().getValue() < h.highestValue().getValue())
                            {
                                return -1;
                            }
                        }
                    }
                }
            }
        }
    }
    return 1;
    }
}