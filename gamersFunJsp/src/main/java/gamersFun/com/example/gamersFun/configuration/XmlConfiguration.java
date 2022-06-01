package gamersFun.com.example.gamersFun.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:applicationsContext.xml"})
public class XmlConfiguration {
}
