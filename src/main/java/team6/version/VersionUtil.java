package team6.version;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Version utility class for SMS Checker application.
 * Implements F1 requirement: version-aware library that reads version from resource file.
 * Does not depend on version control system (Git tags) as specified.
 */
public class VersionUtil {
    
    private static final String VERSION_PROPERTIES = "version.properties";
    private static final String DEFAULT_VERSION = "1.0.0-UNKNOWN";
    
    private static VersionUtil instance;
    private final String version;
    private final String buildTime;
    
    private VersionUtil() {
        Properties props = loadVersionProperties();
        this.version = props.getProperty("version", DEFAULT_VERSION);
        this.buildTime = props.getProperty("build.time", "unknown");
    }
    
    /**
     * Get the singleton instance of VersionUtil.
     * Thread-safe lazy initialization.
     */
    public static VersionUtil getInstance() {
        if (instance == null) {
            synchronized (VersionUtil.class) {
                if (instance == null) {
                    instance = new VersionUtil();
                }
            }
        }
        return instance;
    }
    
    /**
     * Get the version of this library.
     * @return version string from version.properties resource file
     */
    public String getVersion() {
        return version;
    }
    
    /**
     * Get the build time of this library.
     * @return build time string from version.properties resource file
     */
    public String getBuildTime() {
        return buildTime;
    }
    
    /**
     * Get full version information including build time.
     * Useful for monitoring and system information display.
     * @return formatted version info string
     */
    public String getFullVersionInfo() {
        return String.format("lib-version %s (built: %s)", version, buildTime);
    }
    
    /**
     * Load version properties from the resource file included in the package.
     * This approach ensures version information is available even when
     * the library is reused in different environments.
     */
    private Properties loadVersionProperties() {
        Properties props = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(VERSION_PROPERTIES)) {
            if (is != null) {
                props.load(is);
            } else {
                System.err.println("Warning: " + VERSION_PROPERTIES + " not found in classpath");
            }
        } catch (IOException e) {
            System.err.println("Warning: Could not load " + VERSION_PROPERTIES + ": " + e.getMessage());
        }
        return props;
    }
}