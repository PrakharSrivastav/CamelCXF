# CamelCXF

This app explains how to consume a webservice using camel-cxf component.

## Workflow for writing camel-cxf soap consumers
- Download/copy wsdl file and put it under resources directory
- in `pom.xml` file change the wsdlOption to set the correct wsdl file
- run maven clean install to generate the code from wsdl file.
- Configure the camel routes 
- Test and Run the application