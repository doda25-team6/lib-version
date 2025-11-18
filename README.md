# lib-version

**Version-aware Maven library for SMS Checker application (F1 Implementation)**

This library provides version information utilities for the SMS Checker project. It demonstrates how to create and reuse a library with version awareness capabilities.

## Features

- **VersionUtil class** that can be asked for its version
- Version information stored in resource file (not VCS-dependent)
- Thread-safe singleton pattern
- Useful for monitoring and system information display

## F1 Requirements Met

✅ Version-aware Maven library  
✅ VersionUtil class with getVersion() method  
✅ Version parsed from metadata/resource file  
✅ No dependency on version control system  
✅ Used by app service for library reuse demonstration  

## Usage

```java
import com.doda.sms.version.VersionUtil;

// Get version information
VersionUtil versionUtil = VersionUtil.getInstance();
String version = versionUtil.getVersion();
String buildTime = versionUtil.getBuildTime();
String fullInfo = versionUtil.getFullVersionInfo();

System.out.println("Version: " + version);
System.out.println("Build Time: " + buildTime);
System.out.println("Full Info: " + fullInfo);
```

## Building

```bash
mvn clean compile
mvn package
mvn install  # Install to local repository for use by app
```

## Integration

This library is used by the SMS Checker app service to demonstrate library reuse and provide system information for monitoring purposes.
# Test pre-release
