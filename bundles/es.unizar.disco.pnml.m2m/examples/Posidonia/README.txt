Posidonia project
=================
This project includes the model used in [1]. The model consists of the following diagrams:
- Component diagram
- Deployment diagram
- Four performance scenarios that rely on the same deployment diagram.
In particular, two scenarios are associated to the Parser component and the other two scenarios are associated to the CEP component.

The Parser scenarios are representing the same behavior but with different views:
- ParserScenario (SD): a Sequence Diagram and 
- ParserScenario (AD): an Activity Diagram

The CEP scenarios are modelled with activity diagrams and represent the CEP behavior at different levels of abstractions:
- CEP scenario (high level view)
- CEPScenario(AD)

The four scenarios together with the Deployment Diagram are properly annotated with the MARTE profile.


Reference:
==========
[1] S. Bernardi, J.L. Domínguez, A. Gómez, C. Joubert, J. Merseguer, D. Perez-Palacin, J.I. Requeno, A. Romeu, 
"A Systematic Approach for Performance Assessment Using Process Mining: An Industrial Research Report", 
Empirical Software Engineering, December 2018, Volume 23, Issue 6, pp. 3394–3441,  DOI:10.1007/s10664-018-9606-9.
