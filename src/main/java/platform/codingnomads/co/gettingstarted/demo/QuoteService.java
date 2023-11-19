package platform.codingnomads.co.gettingstarted.demo;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class QuoteService {
    ArrayList<String> quotes = new ArrayList<>();

    public QuoteService() {
        populateQuotes();
    }

    public String getRandomQuote(){
        Random random= new Random();
        int index =random.nextInt(10);
        return  quotes.get(index);
    }
    private void populateQuotes() {
        quotes.add("The greatest glory in living lies not in never falling, but in rising every time we fall. -Nelson Mandela");
        quotes.add("The way to get started is to quit talking and begin doing. -Walt Disney");
        quotes.add("Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking. -Steve Jobs");
        quotes.add("The future belongs to those who believe in the beauty of their dreams. -Eleanor Roosevelt");
        quotes.add("If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough. -Oprah Winfrey");
        quotes.add("If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success. -James Cameron");
        quotes.add("Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that. -Martin Luther King Jr.");
        quotes.add("Well done is better than well said. -Benjamin Franklin");
        quotes.add("It is during our darkest moments that we must focus to see the light. -Aristotle");
        quotes.add("Do not go where the path may lead, go instead where there is no path and leave a trail. -Ralph Waldo Emerson");
        quotes.add("Many of life's failures are people who did not realize how close they were to success when they gave up. -Thomas A. Edison");
    }
}
