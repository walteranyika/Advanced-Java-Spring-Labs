package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    private final String text = "this is the text that this is all based on.";

    @RequestMapping(path = "/binary", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String returnSomeBinary() {
        StringBuilder binary = new StringBuilder();
        char[] chars = text.toCharArray();

        for(char c: chars) {
            binary.append("   ").append(Integer.toBinaryString(c));
        }
        return binary.toString();
    }

    @RequestMapping(path = "/normal", method = RequestMethod.GET)
    public String returnTheString() {
        return text;
    }


    @RequestMapping(path = "/reverse", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String reverse(){
        char[] resultArray = text.toCharArray();
        StringBuilder builder= new StringBuilder();
        for (int i = resultArray.length-1; i >=0; i--) {
            builder.append(resultArray[i]);
        }
        return builder.toString();
    }
}