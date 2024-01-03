import java.util.Random;

/**
 * The ChatterBot class represents a simple chatbot that responds to user requests.
 */
class ChatterBot {
    // Constants
    static final String REQUEST_PREFIX = "say ";

    // Instance variables
    Random rand = new Random();
    String name;
    String[] repliesToLegalRequest;
    String[] repliesToIllegalRequest;

    /**
     * Constructor for the ChatterBot class.
     *
     * @param name                   The name of the chatbot.
     * @param repliesToLegalRequest  Array of legal request responses.
     * @param repliesToIllegalRequest Array of illegal request responses.
     */
    ChatterBot(String name, String[] repliesToLegalRequest, String[] repliesToIllegalRequest) {
        // Copy legal request responses
        this.repliesToLegalRequest = new String[repliesToLegalRequest.length];
        for (int i = 0; i < repliesToLegalRequest.length; i++)
            this.repliesToLegalRequest[i] = repliesToLegalRequest[i];

        // Copy illegal request responses
        this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
        for (int i = 0; i < repliesToIllegalRequest.length; i++)
            this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];

        // Set the name
        this.name = name;
    }

    /**
     * Gets the name of the ChatterBot.
     *
     * @return The name of the ChatterBot.
     */
    String getName() {
        return this.name;
    }

    /**
     * Generates a response based on the user's statement.
     *
     * @param statement The user's statement.
     * @return The generated response.
     */
    String replyTo(String statement) {
        if (statement.startsWith(REQUEST_PREFIX)) {
            // Legal request response
            String phrase = statement.replaceFirst(REQUEST_PREFIX, "");
            int randomIndex = rand.nextInt(repliesToLegalRequest.length);
            return repliesToLegalRequest[randomIndex].replaceAll("<phrase>", phrase);
        }

        // Illegal request response
        int randomIndex = rand.nextInt(repliesToIllegalRequest.length);
        return repliesToIllegalRequest[randomIndex] + statement;
    }
}
