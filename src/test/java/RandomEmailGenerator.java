import java.util.Random;

    public class RandomEmailGenerator {
        private String[] domains;
        private String[] firstNames;
        private String[] lastNames;
        private Random random;

        public RandomEmailGenerator() {
            domains = new String[]{"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
            firstNames = new String[]{"John", "Mary", "James", "Sarah", "Alex"};
            lastNames = new String[]{"Smith", "Johnson", "Brown", "Davis", "Miller"};
            random = new Random();
        }

        public String generateRandomEmail() {
            String firstName = generateRandomFirstName();
            String lastName = generateRandomLastName();
            String domain = domains[random.nextInt(domains.length)];
            int randomNum = random.nextInt(9000) + 1000;

            return firstName.toLowerCase() + "." + lastName.toLowerCase() +randomNum+ "@" + domain;
        }

        public String generateRandomFirstName() {
            return firstNames[random.nextInt(firstNames.length)];
        }

        public String generateRandomLastName() {
            return lastNames[random.nextInt(lastNames.length)];
        }

        public String generateRandomUsername() {
            String name = firstNames[random.nextInt(firstNames.length)];
            int randomNum = random.nextInt(9000) + 1000; // Generate a 4-digit number

            return name + randomNum;
        }

        public String generateRandomPassword(int length) {
            String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(validChars.length());
                password.append(validChars.charAt(randomIndex));
            }

            return password.toString();
        }
    }



