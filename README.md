# lib-version

**Version-aware Maven library for SMS Checker application (F1 Implementation)**

This library provides version information utilities for the SMS Checker project. It demonstrates how to create and reuse a library with version awareness capabilities.

## Features

- **VersionUtil class** that can be asked for its version
- Version information stored in resource file (not VCS-dependent)
- Thread-safe singleton pattern
- Useful for monitoring and system information display

## Requirements Met

### F1: Version-Aware Library
✅ Version-aware Maven library  
✅ VersionUtil class with getVersion() method  
✅ Version parsed from metadata/resource file  
✅ No dependency on version control system  
✅ Used by app service for library reuse demonstration

### F2: Library Release
✅ GitHub Actions workflow for automatic packaging  
✅ Automatic versioning from Git tags  
✅ Release to GitHub Packages (Maven registry)  
✅ Automated release notes generation  

## Installation

### From GitHub Packages (F2)

Add this repository configuration to your `pom.xml`:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/doda25-team6/lib-version</url>
  </repository>
</repositories>
```

Add the dependency:

```xml
<dependency>
  <groupId>team6</groupId>
  <artifactId>lib-version</artifactId>
  <version>1.0.0</version>
</dependency>
```

Configure authentication in `~/.m2/settings.xml`:

```xml
<servers>
  <server>
    <id>github</id>
    <username>YOUR_GITHUB_USERNAME</username>
    <password>YOUR_GITHUB_TOKEN</password>
  </server>
</servers>
```

### From Local Repository

```bash
mvn clean install
```

## Usage

```java
import team6.version.VersionUtil;

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

## Releasing (F2)

The library is automatically released to GitHub Packages when you push a version tag:

```bash
# Create and push a version tag
git tag v1.0.0
git push origin v1.0.0
```

The GitHub Actions workflow will:
1. Extract version from the tag
2. Update `pom.xml` version
3. Update `version.properties` with version and build time
4. Build and test the library
5. Publish to GitHub Packages
6. Create a GitHub Release with release notes

### Manual Release

To manually publish to GitHub Packages:

```bash
# Set GitHub token
export GITHUB_TOKEN=your_token_here

# Deploy
mvn deploy
```

## Integration

This library is used by the SMS Checker app service to demonstrate library reuse and provide system information for monitoring purposes.
