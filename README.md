# Java API to Watson services

This project provides a clean Java API to Watson. Behind the scenes uses JAX-RS 2 Client API to talk to Watson service. "Plug and play" in Bluemix using Liberty Profile - the CDI bean reads configurations automatically.

The library is in its early stages, only Questions and Answers API is added, but other stuff should be rather mechanical to add.

Dependencies:

 * DeltaSpike
 * JAX-RS 2 (Available in Liberty and Bluemix as beta feature). The Demo project packages with suitable liberty server.xml for easy deployment.

To run the example in Bluemix, install the api library, and then build the demo project.

    mvn clean install
    cd example-project
    mvn install
    cf set-env <your-watson-demo-server> IBM_LIBERTY_BETA true
    cf push <your-watson-demo-server> -p target/liberty-bluemix/liberty
