In order to execute the tests, file in src/tests/resources/config.properties has to be edited, having the fields
`host`, `port`, `username` and `password`a correct configuration.

`host`, `port`, `username` and `password`a correct configuration.

Also a file in `src/tests/resources/secure.preferences.properties` should exist 

The pom.xml in configuration project includes a part related to the tests. So far, the $HOME or %USERPROFILE% should be change depending on executing the tests in Windows or Linux.
