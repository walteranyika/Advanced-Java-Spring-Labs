package platform.codingnomads.co.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {
    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;

    public String createAwesomeSoftware() {
        return MessageFormat.format("This awesome Software has been created using " +
                        "\nIDE {0}:{1}, \nJDK {2}:{3}, \nFramework {4}:{5}",
                ide.getName(), ide.getVersion(),
                jdk.getName(), jdk.getVersion(),
                framework.getName(), framework.getVersion());
    }
}
