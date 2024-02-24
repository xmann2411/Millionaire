package hr.algebra.java2.milionare.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


//JNDI => a technology that creates a context in which some common resources are registered
public final class JNDIHelper {

    private static final String PROVIDER_URL = "file:C:";
    private static final String CONFIGURATION_FILE_NAME = "conf.properties";
    private static final String INITIAL_CONTEXT_FACTORY = "com.sun.jndi.fscontext.RefFSContextFactory";
    public static InitialContext context;



    public static InitialContext getInitialContext() throws NamingException {
        if (context == null) {
            Properties properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            properties.setProperty(Context.PROVIDER_URL, PROVIDER_URL);
            context = new InitialContext(properties);
        }
        return context;
    }

    public static String getConfigurationParameter(String key) throws NamingException, IOException {
        Object configurationFileObject = getInitialContext().lookup(CONFIGURATION_FILE_NAME);
        System.out.println("Configuration File Name: " + configurationFileObject);

        Properties prop = new Properties();
        prop.load(new FileReader(configurationFileObject.toString()));
        return prop.getProperty(key);
    }
}
