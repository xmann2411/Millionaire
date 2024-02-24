package hr.algebra.java2.milionare.jndi;

public enum JNDIConfigurationKey {

    RMI_SERVER_PORT("rmi.port"),
    RANDOM_PORT("random.port"),

    GAME_SERVER_PORT("game.server.port"),
    GAME_SERVER_IP("game.server.ip");

    private final String configurationKey;
    JNDIConfigurationKey(String configurationKey) {
        this.configurationKey = configurationKey;
    }
    public String getConfigurationKey(){ return configurationKey; }
}
