package platform.codingnomads.co.ioc.examples.dependencylookup;

public class HelloGreetingsProvider implements GreetingProvider{
    @Override
    public String getGreeting() {
        return "Hello, From Mars";
    }
}
