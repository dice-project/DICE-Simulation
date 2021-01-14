# Summary of contents

This directory contains test projects. Please note that, as opposed to regular maven where unit tests happen in the `test` phase, in Tycho, unit tests are executed in the `integration-test` phase. In any case, these tests are executed by default.

## es.unizar.disco.simulation.tests

Test plug-in containing unit tests. Please note that tests requiring a GreatSPN instance have been tagged in the group `test.es.unizar.disco.simulation.tests.IntegrationTest` to differentiate them from regular unit tests. This group is excluded by default. See the `integration-tests` profile in the [parent pom.xml](../pom.xml) file.

## Other directories...

... contain test models used by the aforementioned test plug-in.