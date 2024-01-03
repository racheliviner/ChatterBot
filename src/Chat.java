import java.util.Scanner;

/**
 * The Chat class demonstrates a conversation between two ChatterBot instances.
 */
class Chat {
    public static void main(String[] args) {
        // Define illegal and legal replies for each ChatterBot
        String[] illegalReply_bot1 = { "I dont want to say ", "say I should say " };
        String[] illegalReply_bot2 = { "I will not say ", "say say " };
        String[] legalReply_bot1 = {"You want me to say <phrase>, do you? alright: <phrase>",""};
        String[] legalReply_bot2 = {"Fine! I will say ","okay, here goes: <phrase>"};

        // Create an array of ChatterBots
        ChatterBot[] bots = new ChatterBot[2];
        bots[0] = new ChatterBot("bot 1", legalReply_bot1, illegalReply_bot1);
        bots[1] = new ChatterBot("bot 2", legalReply_bot2, illegalReply_bot2);

        // Initialize a Scanner for user input
        Scanner in = new Scanner(System.in);

        // Start the conversation
        System.out.println("Hey you! Ready for a chat? Fire away with anything on your mind, and let's dive into the world of conversation!");
        String statement = in.nextLine();
        System.out.println("you: " + statement);

        // Continue the conversation in a loop
        while (true) {
            for (ChatterBot bot : bots) {
                statement = bot.replyTo(statement);
                System.out.print(bot.getName() + ": " + statement);
                in.nextLine(); // Wait for user input to continue the conversation
            }
        }
    }
}
