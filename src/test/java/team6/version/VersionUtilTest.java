package team6.version;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for VersionUtil - F1 implementation verification
 */
public class VersionUtilTest {

    @Test
    public void testGetInstance() {
        VersionUtil instance1 = VersionUtil.getInstance();
        VersionUtil instance2 = VersionUtil.getInstance();
        
        assertNotNull(instance1);
        assertSame(instance1, instance2, "getInstance should return the same instance (singleton)");
    }

    @Test
    public void testGetVersion() {
        VersionUtil versionUtil = VersionUtil.getInstance();
        String version = versionUtil.getVersion();
        
        assertNotNull(version);
        assertFalse(version.isEmpty());
        assertTrue(version.matches("\\d+\\.\\d+\\.\\d+.*"), "Version should follow semantic versioning pattern");
    }

    @Test
    public void testGetBuildTime() {
        VersionUtil versionUtil = VersionUtil.getInstance();
        String buildTime = versionUtil.getBuildTime();
        
        assertNotNull(buildTime);
        assertFalse(buildTime.isEmpty());
    }

    @Test
    public void testGetFullVersionInfo() {
        VersionUtil versionUtil = VersionUtil.getInstance();
        String fullInfo = versionUtil.getFullVersionInfo();
        
        assertNotNull(fullInfo);
        assertFalse(fullInfo.isEmpty());
        assertTrue(fullInfo.contains("lib-version"));
        assertTrue(fullInfo.contains(versionUtil.getVersion()));
        assertTrue(fullInfo.contains(versionUtil.getBuildTime()));
    }
}