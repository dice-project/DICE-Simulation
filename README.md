# DICE-Simulation
Simulation tool for DICE.

# The Simulation Tool in action

A demonstration video can be found at https://www.youtube.com/watch?v=lZX6IoHgHc0

# Requirements

In order to execute simulations, the DICE Simulation Tool requires an installation of GreatSPN running on a Linux server and accessible via SSH.
Fortunately, we provide a Docker image to execute GreatSPN, which can be executed in any of the supported platforms (Linux, Windows and MacOSX).

See https://docs.docker.com/get-docker/ for the Docker installation instructions.

Once you have Docker up and running in your system, simply start a docker image by running (you may need to execute docker commands as root using `sudo`):

```
docker run --rm --publish 2222:22 --env SSH_USERNAME=user --env SSH_USERPASS=password --name greatspn abelgomez/greatspn 
```

After that, a docker container called `greatspn`, with GreatSPN, will be accessible via SSH on `localhost`, on port `2222`, using the user `user` and the password `password`.
See https://github.com/abelgomez/greatspn.docker for more details.

Hint: use `docker ps` to check which docker containers are running, and `docker stop greatspn` to stop the docker container created above.
The `greatspn` container will be automatically deleted after stopping it (see the `--rm`parameter).

# Compatibility between Eclipse versions and the DICE Simulation Tools

DICE Simulation Tool version | Eclipse version name                                                                         | Eclipse version number | Minimum Java Version | Supported platforms                             |
:---------------------------:|:--------------------------------------------------------------------------------------------:|:----------------------:|:--------------------:|:-----------------------------------------------:|
v0.1.x                       | [Eclipse Mars](https://archive.eclipse.org/eclipse/downloads/drops4/R-4.5-201506032000/)     | 4.5                    | Java 7               | Windows, Linux, MacOS X (all 32 bits & 64 bits) |
v0.2.x                       | [Eclipse Mars](https://archive.eclipse.org/eclipse/downloads/drops4/R-4.5-201506032000/)     | 4.5                    | Java 7               | Windows, Linux, MacOS X (all 32 bits & 64 bits) |
v0.3.x                       | [Eclipse Neon](https://archive.eclipse.org/eclipse/downloads/drops4/R-4.6-201606061100/)     | 4.6                    | Java 8               | Windows, Linux, MacOS X (all 32 bits & 64 bits) |
v0.4.x                       | [Eclipse Neon](https://archive.eclipse.org/eclipse/downloads/drops4/R-4.6-201606061100/)     | 4.6                    | Java 8               | Windows, Linux, MacOS X (all 32 bits & 64 bits) |
v0.5.x                       | [Eclipse Neon](https://archive.eclipse.org/eclipse/downloads/drops4/R-4.6-201606061100/)     | 4.6                    | Java 8               | Windows, Linux, MacOS X (all 32 bits & 64 bits) |
v0.6.x                       | [Eclipse Neon](https://archive.eclipse.org/eclipse/downloads/drops4/R-4.6-201606061100/)     | 4.6                    | Java 8               | Windows, Linux, MacOS X (all 32 bits & 64 bits) |
v0.7.x                       | [Eclipse 2020-12](https://archive.eclipse.org/eclipse/downloads/drops4/R-4.18-202012021800/) | 4.18                   | Java 11              | Windows, Linux, MacOS X (64 bits only)          |

# Installing the Simulation Tools

In Eclipse, go to `Help -> Install New Software...` and use http://dice-project.github.io/DICE-Simulation/updates as the URL for the update site.

## Archived Updates Sites

* http://dice-project.github.io/DICE-Simulation/updates/0.1
* http://dice-project.github.io/DICE-Simulation/updates/0.2
* http://dice-project.github.io/DICE-Simulation/updates/0.3.3
* http://dice-project.github.io/DICE-Simulation/updates/0.3.4
* http://dice-project.github.io/DICE-Simulation/updates/0.3.5
* http://dice-project.github.io/DICE-Simulation/updates/0.4.0
* http://dice-project.github.io/DICE-Simulation/updates/0.4.1
* http://dice-project.github.io/DICE-Simulation/updates/0.4.2
* http://dice-project.github.io/DICE-Simulation/updates/0.5.0
* http://dice-project.github.io/DICE-Simulation/updates/0.5.1
* http://dice-project.github.io/DICE-Simulation/updates/0.5.2
* http://dice-project.github.io/DICE-Simulation/updates/0.6.0
* http://dice-project.github.io/DICE-Simulation/updates/0.6.1
* http://dice-project.github.io/DICE-Simulation/updates/0.6.2
* http://dice-project.github.io/DICE-Simulation/updates/0.6.3
* http://dice-project.github.io/DICE-Simulation/updates/0.6.4
* http://dice-project.github.io/DICE-Simulation/updates/0.6.5
* http://dice-project.github.io/DICE-Simulation/updates/0.7.0

# Building the Simulation Tool

To build the plugins and create an update site, simply execute:

```
mvn clean verify
```

The build process also includes test. Some of them, however, require a running GreatSPN instance. Tests requiring GreatSPN are disabled by default.
Remember that you can use Docker. In such a case, first launch the GreatSPN instance as explained above, and then you can directly ask for the execution of the integration tests by running:

```
mvn clean verify -Pintegration-tests
```

If you changed any of the above configuration to run GreatSPN, you can update the connection data used for the tests by editing the file [tests/es.unizar.disco.simulation.tests/src/test/resources/config.properties](tests/es.unizar.disco.simulation.tests/src/test/resources/config.properties).

In order to prepare a new release, it is necessary to change the version of all plugins, features, and pom.xml files at a time. To do this, simply execute (where x.x.x must be replaced by the desired version number):

```
mvn clean tycho-versions:set-version -DnewVersion=x.x.x-SNAPSHOT
```




# Summary of contents

## es.unizar.disco.core  

This project contains the *Core plug-in*.

The *Core plug-in* provides some utility clases for I/O, together with the shared logging capabilities. 

## es.unizar.disco.core.ui

This project contains the *Core UI plug-in*.

The *Core UI plug-in* provides UI components that are shared across the different plug-ins contained in this repository, such as file selection dialogs.

## es.unizar.disco.pnconfig

This project contains the implementation of the *Configuration Model* as an EMF plug-in.

## es.unizar.disco.pnml.m2m

This project implements the M2M tranformation from UML to PNML using QVTo. 

## es.unizar.disco.pnextensions

This project provides some utilities to handle some extensions in PNML models.

The PNML standard does not provide support for timed and stochastic petri nets.

Thus, this plug-in provides the utility methods to handle this information by using the *ToolSpecifics* tags provided by the PNML standard. 

## es.unizar.disco.pnml.m2t

This project contains the Acceleo transformation to convert a DICE-annotated PNML file to a set GreatSPN files. 

## es.unizar.disco.simulation.greatspn.ssh

This project contains the OSGi component that controls a remote GreatSPN instance by using SSH commands.

## es.unizar.disco.simulation

This project contains the core component that executes a simulation by orchestrating the interactions among all the previous components.

## es.unizar.disco.simulation.ui

This project contains the UI contributions that allow the users to invoke a simulation within the Eclipse GUI.

## es.unizar.disco.ssh

This project provides a simple extension point contribution to access a remote host by issuing the connection data using a local file.

## com.hierynomus.sshj

This project contains the *sshj - SSHv2 library for Java* as an OSGi-friendly bundle.

This module is required by ```es.unizar.disco.simulation.greatspn.ssh``` to access a remote *GreatSPN* instance using SSH/SFTP.
