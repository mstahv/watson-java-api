# Java APIs for Watson

This is a sample application for Java APIs built for Watson APIs provided in
Bluemix. Source code for both API library and this example is available via in 
[GitHub](https://github.com/mstahv/watson-java-api).

To use these yourself, create services in Bluemix console and assign them to
your Liberty server. In you inject service classes with CDI, they can 
automatically read your credentials from CloundFoundry environment variables.

If you want to test locally, you can just copy the credentials to your
"src/main/resources/META-INF/apache-deltaspike.properties" file, e.g.:

    VCAP_SERVICES={ "question_and_answer": ...}
 




