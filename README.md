# Java API to Watson services

This project provides a clean Java API to Watson. Behind the scenes uses JAX-RS 2 Client API to talk to Watson service. "Plug and play" in Bluemix using Liberty Profile - the CDI bean reads configurations automatically.

The library so far contains service classes for Watson APIs:

 * Question and Answer
 * Text to Speech
 * Visual Recognition

Adding other APIs should be really simple based on the available examples. If you intend to contribute a new features, [jsonschema2pojo.org](http://www.jsonschema2pojo.org) service may be handy to create Pojos from JSON response/request examples. Then just send me the pull requests!

If you prefer developing the library locally, create a example-project/src/main/resources/META-INF/apache-deltaspike.properties file and "steal" the credentials from your bluemix servers VCAP_SERVICES environment variable to it:

    VCAP_SERVICES={ "text_to_speech": .....}

The CDI services will then use those credentials if nothing is found from ENV and they work well for local development.

Dependencies:

 * DeltaSpike
 * JAX-RS 2 (Available in Liberty and Bluemix as beta feature). The Demo project packages with suitable liberty server.xml for easy deployment.)

To run the example in Bluemix first create a Liberty runtume. Then install the api library locally to allow building the example and then build the war project and cf push the right *directory* to Bluemix. CLI commands:

    mvn clean install
    cd example-project
    mvn install
    cf set-env <your-watson-demo-server> IBM_LIBERTY_BETA true
    cf push <your-watson-demo-server> -p target/liberty-bluemix/liberty

