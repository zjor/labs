# Apache CXF & Spring Configuration example


 This is an example project of SOAP web service configuration.
 It exposes two methods:

  - echo(String input)
  - getDate()

 In order to run use command

 	`mvn clean install tomcat7:run-war -Dmaven.tomcat.port=7001`

 WebService description will be available at

 	`http://localhost:7001/cxf-configuration/services/sampleService?wsdl`