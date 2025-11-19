#!/usr/bin/env bash
set -euo pipefail

PROJECT_VERSION="$(mvn -q -Dexpression=project.version -DforceStdout help:evaluate)"
BUILD_TIME="$(date -u +"%Y-%m-%dT%H:%M:%SZ")"

cat > src/main/resources/version.properties <<EOF
# Version information for lib-version library
# This file is included in the package and parsed at runtime
# F1 requirement: version stored in resource file, not from VCS
version=${PROJECT_VERSION}
build.time=${BUILD_TIME}
artifact.name=lib-version
artifact.description=SMS Checker Version Library
EOF

echo "Updated version.properties to version=${PROJECT_VERSION}, build.time=${BUILD_TIME}"
