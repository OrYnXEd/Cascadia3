public class CascadiaGame {
    public static void main(String[] args) {
        // ...

        while (gameOn) {
            // ...

            // Add a case to handle spending nature tokens
            case "spend":
                System.out.println("Enter 'select' to select any wildlife and habitat token, or 'wipe' to wipe any number of wildlife tokens.");
                String action = scanner.nextLine().toLowerCase();
                game.spendNatureToken(currentPlayer, action);
                break;
        }

        game.calculateAndDisplayScores();
        System.out.println("Thanks for playing Cascadia!");
    }
}
