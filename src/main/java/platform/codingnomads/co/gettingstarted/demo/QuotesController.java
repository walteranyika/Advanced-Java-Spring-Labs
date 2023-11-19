package platform.codingnomads.co.gettingstarted.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuotesController {

    @Autowired
    QuoteService quoteService;

    @GetMapping(path = "/quote")
    public String getQuote(Model model) {
        String quote = quoteService.getRandomQuote();
        model.addAttribute("quote", quote);
        return "getting_started/quote";
    }
}
