# Summary of contents

This directory contains test projects. Please note that, as opposed to regular maven where unit tests happen in the `test` phase, in Tycho, unit tests are executed in the `integration-test` phase. In any case, these tests are executed by default.

## es.unizar.disco.simulation.tests

Test plug-in containing unit tests. Please note that tests requiring a GreatSPN instance have been tagged in the group `test.es.unizar.disco.simulation.tests.IntegrationTest` to differentiate them from regular unit tests. This group is excluded by default. See the `integration-tests` profile in the [parent pom.xml](../pom.xml) file.

The resources are organised in different subfolders according to the properties to inspect. In particular,

1- Files in 'closedWorkload' are used for the definition of a closed workload: 
15777ece-6c9b-46a3-89c5-a23c2edd99ab.def.xmi 
fbd9fa21-dff8-448d-897a-7e51e07dc5f9.inv.xmi 
modelPoseidoniaReliabClosed.uml


2- Files in 'reliabilityPosidonia' are used for the reliability creation tests:
cb745d8a-44f7-46de-9167-7ce0e822f048.def.xmi
cfcac620-a901-4526-b631-097bed907210.inv.xmi
cfcac620-a901-4526-b631-097bed907210.anm.xmi
cfcac620-a901-4526-b631-097bed907210.trc.xmi
modelPoseidoniaReliab.uml


3- Files in 'reliabilityDpimResults' are used for the reliability analysis DPIM tests:
2d8afa5a-618c-465b-8a2a-d4dd2d8789ff.def.xmi
4621530c-a96c-4db8-adbe-ba22ab68d40a.anm.xmi
4621530c-a96c-4db8-adbe-ba22ab68d40a.inv.xmi
4621530c-a96c-4db8-adbe-ba22ab68d40a.res.xmi
4621530c-a96c-4db8-adbe-ba22ab68d40a.trc.xmi
4621530c-a96c-4db8-adbe-ba22ab68d40a.trs.xmi


4- Files in 'reliabilityStorm' are used for the reliability DTSM Storm tests:
#c1bf507a-d629-4b5d-86ee-9dc82f0f0ac6.inv.xmi
#93a71370-1141-4764-aa8e-bb6611def309.def.xmi
6a008097-ebcb-42bf-99ca-05ecd190c14b.inv.xmi
165d07a2-a8a0-4359-83c6-822b40f479cc.def.xmi
wikistatsStorm.uml


5- Files in 'reliabilityHadoop' are used for the reliability DTSM Hadoop tests:
9261cd96-6ea6-4e44-b003-253fe8d4cbb7.inv.xmi
f388179a-3dfc-4567-a002-f786fd9bd813.def.xmi
reliabilityHadoop.uml


6- Files in 'reliabilitySpark' are used for the reliability DTSM Spark tests in local:
86f60c62-46c3-4bdc-940b-408535b5e26b.inv.xmi
c3d6d6a1-6531-43c1-8fa3-f8c3ee0151ab.def.xmi
SparkReliability.uml



## Other directories...

... contain test models used by the aforementioned test plug-in.