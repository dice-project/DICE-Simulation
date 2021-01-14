# Summary of contents

This directory contains projects for release engineering.

## es.unizar.disco.simulation.setup (`setup` directory)

Directory containing setup files that can be used by the [Eclipse Installer](https://www.eclipse.org/downloads/packages/installer) to install the DICE Simulation Tool with minimal user interaction.

## es.unizar.disco.simulation.targetplatform (`platform` directory)

Directory with the [target platform definition](https://wiki.eclipse.org/PDE/Target_Definitions). The target platform defines what the DICE Simulation Tool plug-ins an features will be built and launched against. It includes links to all required plug-in dependencies.

## es.unizar.disco.simulation.update (`update` directory)

Directory containing the build files to create a resulting update site that can be used to install the DICE Simulation Tool (basically, a `category.xml`file).

