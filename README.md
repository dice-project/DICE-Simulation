# DICE-Simulation
Simulation tool for DICE

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
