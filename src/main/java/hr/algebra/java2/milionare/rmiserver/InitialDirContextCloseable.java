package hr.algebra.java2.milionare.rmiserver;

import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class InitialDirContextCloseable extends InitialDirContext implements AutoCloseable {
    public InitialDirContextCloseable(Hashtable<?, ?> environment) throws NamingException {
        super(environment);
    }
}