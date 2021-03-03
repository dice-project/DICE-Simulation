# The *Simplified Posidonia* Case Study

This project includes the model used as an illustrative example in the [Getting 
Started](https://github.com/dice-project/DICE-Simulation/wiki/Getting-Started) 
wiki page.

The model consists of a Deployment Diagram (*Deployment*) and an Activity 
Diagram (*CEPScenario*), properly annotated with the MARTE profile. It is a 
simplified model of the Posidonia case study (see the *1 Posidonia* folder) 
where there is only one performance scenario that models the CEP component 
execution cycle. 


# Model description

Two components of the CEP are involved in this scenario: the *AIS Sentence 
Listener* and the *Stateful Knowledge Session*. The former continuously monitors 
the message queue, and when a new AIS statement occurs, it starts a new execution 
cycle to handle it. In particular, it adds the new AIS statement to the database 
and delegates the rest of the operations to the *Stateful Knowledge Session*. The 
latter component, as a consequence of a new AIS statement added in the 
databases, updates the list of active rules.

An X rule is made up of two parts: the trigger condition and the body. 
Therefore, the *Stateful Knowledge Session* triggers all the rules whose 
condition is satisfied. After the rule activation phase, it decides if it is 
reasonable to execute the activated rules: if so, the second phase begins, that 
is, the firing of all active rules and their management. If it is not reasonable 
to execute the triggered rules, the execution cycle ends. The firing of a rule 
can cause the activation of other rules: therefore, the *Stateful Knowledge 
Session* updates the list of active rules again, that is, it adds to the list, 
each rule Y whose activation condition is satisfied. Finally, the *Stateful 
Knowledge Session* decides whether to publish the identified AIS events in the 
message queue. The second phase ends the execution cycle. 

