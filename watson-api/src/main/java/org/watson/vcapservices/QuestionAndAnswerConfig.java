package org.watson.vcapservices;


public class QuestionAndAnswerConfig {

    private String name;
    private String label;
    private String plan;
    private Credentials credentials;

    /**
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return The label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return The plan
     */
    public String getPlan() {
        return plan;
    }

    /**
     *
     * @param plan The plan
     */
    public void setPlan(String plan) {
        this.plan = plan;
    }

    /**
     *
     * @return The credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     *
     * @param credentials The credentials
     */
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

}
