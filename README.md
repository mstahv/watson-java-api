# JAX-RS 2 based Java API to Watson

This project provides a clean Java API to Watson. Behind the scenes uses JAX-RS 2 Client API to talk to Watson service. "Plug and play" in Bluemix using Liberty Profile - the CDI bean reads configurations automatically.

The library is in its early stages, only Questions and Answers API is added, but other stuff should be rather mechanical to add.

Dependencies:

 * DeltaSpike
 * JAX-RS 2
  * Currently uses direct dependency to RestEasy (jax-rs 2 api in blumix is so far only as beta feature), but should be pretty make it use container provided service. Authentication would need implementation independent solution and dependencies should be declared provided.

See the included Vaadin web app example as a reference usage.

TODO figure out how to get this easily deployed to Bluemix&Liberty (dependency conflict with jax-rs stuff, need to use libertys beta feature and built in jax-rs-2).

