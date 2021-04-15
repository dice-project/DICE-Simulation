[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.4694077.svg)](https://doi.org/10.5281/zenodo.4694077)

# The DICE Simulation Tool

The ***DICE Simulation Tool*** is a tool for the performance analysis of software systems, initially developed as part of the toolset provided by the european [DICE project](https://github.com/dice-project).
The tool has been developed for the Eclipse platform, and it can be used as a standalone software, running on top of an standard Eclipse installation; or it can also be integrated with another tools as it is the case of the [DICE IDE](https://github.com/dice-project/DICE-Platform/releases).
For both cases, the  functionalities and software architecture remain the same.

From the end user point of view, **the DICE Simulation Tool provides three main functionalities** that address the quatitative analysis of systems, in particular, performance and reliability:

* **The tool allows the annotation of UML diagrams with system quantitative properties** (e.g., host demands, routing rates or workloads) and metrics. The annotations follow the standard MARTE UML profile, as well as the DAM profile. The UML diagrams considered are activity diagrams, sequence diagrams and deployment diagrams. 

* **The tool allows to compute performance metrics** (response time, throughput and resource utilization) on a UML scenario that represents a system execution. By UML scenario we understand the combination of an activity diagram plus a deployment diagram, or a sequence diagram plus a deployment diagram.

* **The tool allows to compute reliability metrics** (MTTF, availability and reliability) on a UML scenario that represents a system execution.

In addition to the previous main functionalities, the tool also:

* Allows modeling **specific quantitative properties of Apache Hadoop, Spark, Storm and Tez applications**. The [DICE profile](https://github.com/dice-project/DICE-Profiles) provides the annotations for introducing this modelling in UML diagrams. This functionality improves the annotation of UML diagrams for addressing specific big data applications.

* Can perform ***what-if* or *sensitivity* analysis** for performance and reliability metrics. So, the tool allows the user to see multiple output results, i.e. quantitative metrics, in a user-friendly format, as a plot chart. 

* **Transforms a UML scenario into a stochastic Petri net**. The format of the produced Petri net can be analysable (PNML, GreatSPN) or only graphical (DOT). These Petri nets are in fact used by the tool for computing performance metrics, but also they are made available to the user.

Finally, other complementary functionalities of the tool for the end users are:

* The tool allows **tweaking the simulation parameters (accuracy and seed)** for performance analysis. This is because the tool mainly uses the [GreatSPN tool](https://github.com/greatspn/SOURCES) for computing metrics on the Petri nets, thus, the GreatSPN simulation parameters can be configured by our tool throug a user interface.

* The tool allows **stopping long run simulations when doing performance analysis, while useful results are presented**. This is because some simulations may last for long time periods, depending on the parameters used. Our tool offers a simple user interface button to cut these simulations, while the results produced so far are presented. 

* The tool allows **configuring and using simulators installed in remote computers**: the GreatSPN tool can be running anywhere in the world since our tool provides a friendly user interface for remotely configuring and use it. Communication between remote computers and the DICE Simulation Tool happens in through a **secure and encrypted SSH tunnel**.

## See [our wiki](https://github.com/dice-project/DICE-Simulation/wiki/) to learn (among other things) on:

* [The tool requirements](https://github.com/dice-project/DICE-Simulation/wiki/Prerequisites)
* [How to install the tool](https://github.com/dice-project/DICE-Simulation/wiki/Installation)
* [How to build the tool](https://github.com/dice-project/DICE-Simulation/wiki/Building-the-Simulation-Tool)
* [How to configure](https://github.com/dice-project/DICE-Simulation/wiki/First-Steps) and [use the tool](https://github.com/dice-project/DICE-Simulation/wiki/Getting-Started)
* [Our publications and further resources](https://github.com/dice-project/DICE-Simulation/wiki/Publications-and-Additional-Resources)
