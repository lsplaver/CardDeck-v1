package cardDeck;

import java.util.ArrayList;

public class CardDeckApp
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		// create array list
		ArrayList<String> deck = new ArrayList<String>(52);
		deck = getDeck();
		
		// display the created deck
		System.out.println("DECK");
		displayCards(deck);
		
		// shuffle deck
		shuffleDeck(deck);
		
		// display the shuffled deck
		System.out.println("SHUFFLED DECK");
		displayCards(deck);
		
		// string for continuing loop
		String cont = "y";
		
		// loop for dealing hands
		while (cont.equalsIgnoreCase("y"))
		{
			// get a hand size
			int handSize = Console.getInt("Please enter a hand size: ");

			while (!(handSize >= 0 && handSize <= deck.size()))
			{
				handSize = Console.getInt("Please enter a value between 0 and " + deck.size() + ": ");
			}
			
			// display hand size
			System.out.println("HAND OF " + handSize + " CARDS");
			
			
			// create hand from deck
			var hand = new ArrayList<String>();
			hand = dealCards(deck, handSize);
			
			// display the created hand
			displayCards(hand);
			
			System.out.println("REMAINING CARDS IN DECK");
			System.out.println(deck.size());
			
			cont = Console.getString("Press 'Y' to continue: ");
			
			if (cont.equalsIgnoreCase("y"))
			{
				// reset deck if deck size = 0
				if (deck.size() == 0)
				{
					deck = getDeck();

					// display the created deck
					System.out.println("DECK");
					displayCards(deck);
				
					// shuffle deck
					shuffleDeck(deck);
				
					// display the shuffled deck
					System.out.println("SHUFFLED DECK");
					displayCards(deck);
				}
			}
		}
	}

	// deal hand
	private static ArrayList<String> dealCards(ArrayList<String> deck, int handSize) {
		// TODO Auto-generated method stub
		var hand = new ArrayList<String>(handSize);
		
		for (int x = 0; x < handSize; x++)
		{
			hand.add(deck.get(0));
			deck.remove(0);
		}
		return hand;
	}

	// shuffle deck
	private static void shuffleDeck(ArrayList<String> deck) {
		// TODO Auto-generated method stub
		for (int x = 0; x < deck.size(); x++)
		{
			String saveCard = deck.get(x);
			int randomIndex = (int) (Math.random() * deck.size() - 1);
			deck.set(x, deck.get(randomIndex));
			deck.set(randomIndex, saveCard);
		}
	}
	
	// display cards
	private static void displayCards(ArrayList<String> decks) {
		// TODO Auto-generated method stub
		int x = 0;
		for (String deck : decks)
		{
			if (x < (decks.size() - 1))
			{
				System.out.print(deck + " | ");
				x++;
			}
			else
			{
				System.out.println(deck);
			}
		}
	}

	// create new deck
	private static ArrayList<String> getDeck() {
		// TODO Auto-generated method stub
		// create arrays holding suits and cards
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		
		// create arraylist of the deck
		var deck = new ArrayList<String>(52);
		for (String suit : suits)
		{
			for (String card : cards)
			{
				deck.add(card + " of " + suit);
			}
		}
		
		return deck;
	}
}
