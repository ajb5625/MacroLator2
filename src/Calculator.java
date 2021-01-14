import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Calculator {

    public static Node takeUI() {
        String name = "";
        int age = 0;
        String height = "";
        int weight = 0;
        String gender = "";
        int gen = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! Welcome to the Macrolator!");
        System.out.println("\nPlease enter your name: ");
        name = sc.nextLine();
        System.out.println("Hello " + name + "! Please enter your age: ");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter an integer.");
            System.out.println("Please enter your age: ");
            sc.nextLine();
        }
        age = sc.nextInt();
        System.out.println("Please select a gender: \n1 for Male\n2 for Female");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter either 1 or 2.");
            System.out.println("Please select a gender: \n1 for Male\n2 for Female");
            sc.nextLine();
        }
        gen = sc.nextInt();
        if (gen == 1) {
            gender = "Male";
        }
        else if (gen == 2) {
            gender = "Female";
        }
        System.out.println("Please enter your weight: ");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter your weight as an integer.");
            sc.nextLine();
        }
        weight = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter your height in the format (feet,inches)");
//        while (sc.next().matches("\\s,\\s\\s")) {
//            System.out.println("Please enter your height in the format 'feet,inches'");
//            sc.nextLine();
//        }
        height = sc.nextLine();
        String[] fi = height.split(",");
//        int i = 0;
//        while (!sc.hasNextInt() && Integer.parseInt(fi[1]) > 11) {
//            System.out.println("Please enter a number between 0 and 11 for inches");
//            i = sc.nextInt();
//        }
//        fi[1] = Integer.toString(i);
        System.out.println("Please enter your activity level : \n1 for Sedentary\n2 for Lightly active\n3 for Moderately Active\n4 for Very Active\n5 for Extra Active");
        int choice = 0;
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a number 1 through 4");
            sc.nextLine();
        }
        choice = sc.nextInt();
        while (choice <0 || choice > 4) {
            System.out.println("Please enter your choice between 1 and 4.");
            choice = sc.nextInt();
        }
        double active = 0;
        switch (choice) {
            case 1:
                active = 1.2;
            break;

            case 2:
                active = 1.375;
            break;

            case 3:
                active = 1.55;
            break;

            case 4:
                active = 1.725;
            break;

            case 5:
                active = 1.9;
            break;
        }
        sc.nextLine();
        System.out.println("Lastly, please enter a password: ");
        String password = sc.nextLine();
        Node user = new Node(name, age, active, weight, gender, Integer.parseInt(fi[0]), Integer.parseInt(fi[1]), password);
        printUser(user);
        return user;
    }

    public static void printUser(Node user) {
        System.out.println("Name: " + user.name);
        System.out.println("Gender: " + user.gender);
        System.out.println("Age: " + user.age);
        System.out.println("Weight: " + user.weight);
        System.out.println("Height: " + user.feet + " feet " + user.inches + " inches");
        System.out.println("Activity Coefficient: " + user.activity);
    }

    public static void calculate(Node x) {
        if (x.gender.equals("Male")) {
            x.bmr = 66.4730 + (13.7516 * (x.weight * .453592)) + (5.0033 * (((x.feet * 12) + x.inches) * 2.54) - (6.7550 * x.age));
            x.calorie = x.bmr * x.activity;
        }
        else {

        }
        System.out.println("Your basal metabolic rate is " + (int)x.bmr);
        System.out.println("Your calorie expenditure is " + (int)x.calorie);
        x.remainingCalories = x.calorie;
    }

    public static Node login(List users) {
        int allowed = 0;
        int namecheck = 0;
        String name = "";
        String password = "";
        Scanner sc = new Scanner(System.in);
        Node toR = null;
        System.out.println("First enter your name");
        name = sc.nextLine();
        Node temp = users.head;
        while (temp != null) {
            if (name.equals(temp.name)) {
                namecheck = 1;
                break;
            }
            temp = temp.next;
        }
        if (namecheck == 1) {
            System.out.println("Now, please enter your password: ");
            password = sc.nextLine();
            if (password.equals(temp.password)) {
                toR = temp;
            } else {
                System.out.println("Your password was incorrect.");
            }
        }
        return toR;
    }

    public static void bmi (Node found) {
        double bmi = (703 * found.weight) / (Math.pow(((found.feet * 12) + found.inches), 2));
        found.bmi = bmi;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Your bmi is " + df.format(bmi));
        if (bmi < 15) {
            System.out.println("You are very severely underweight");
        }
        else if (bmi >= 15 && bmi < 16) {
            System.out.println("You are severely underweight");
        }
        else if (bmi >= 16 && bmi < 18.5) {
            System.out.println("You are underweight.");
        }
        else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("You are a healthy, normal weight.");
        }
        else if (bmi >= 25 && bmi < 30) {
            System.out.println("You are overweight.");
        }
        else if (bmi >= 30 && bmi < 35) {
            System.out.println("You are moderately obese (Obese Class I)");
        }
        else if (bmi >= 35 && bmi < 40) {
            System.out.println("You are severely obese (Obese Class II)");
        }
        else if (bmi >= 40 && bmi < 45) {
            System.out.println("You are very severely obese (Obese Class III)");
        }
        else if (bmi >= 45 && bmi < 50) {
            System.out.println("You are morbidly obese (Obese Class IV)");
        }
        else if (bmi >= 50 && bmi < 60) {
            System.out.println("You are super obese (Obese Class V)");
        }
        else if (bmi >= 60) {
            System.out.println("You are hyper obese (Obese Class VI)");
        }
    }

    public static void bulkcut (Node found) {
        int bulk1 = (int)found.calorie + 500;
        int bulkhalf = (int)found.calorie + 250;
        int cut1 = (int)found.calorie - 500;
        int cuthalf = (int)found.calorie - 250;
        System.out.println("To gain 1 pound per week, you should eat " + bulk1 + " calories per day.");
        System.out.println("To gain 1/2 pound per week, you should eat " + bulkhalf + " calories per day.");
        System.out.println("To lose 1 pound per week, you should eat " + cut1 + " calories per day.");
        System.out.println("To lose 1/2 pound per week, you should eat " + cuthalf + " calories per day.");
    }

    public static void foodJournal (Node found) {
        Scanner f = new Scanner(System.in);
        Food temp = new Food(0,0,0,0,"");
        if (found.food[0] != null) {
            System.out.println("Today you have eaten - ");
            for (int i = 0; i < found.food.length; i++) {
                if (found.food[i] != null) {
                    System.out.println(found.food[i].name + " Calories - " + found.food[i].calories + "\nProtein - " + found.food[i].protein + " Carbs - " + found.food[i].carbs + " Fats - " + found.food[i].fats);
                }
                else {
                    break;
                }
            }
        }
        while (true) {
            System.out.println("Please enter the food you ate and the calories in the format 'foodName,caloriesNumber,protein,carbs,fats', or type 'end' to stop entering food.");
            String toP = f.nextLine();
            if (toP.equals("end")) {
                break;
            }
            String[] x = toP.split(",");
            Food toInsert = new Food(Integer.parseInt(x[1]), Integer.parseInt(x[2]), Integer.parseInt(x[3]), Integer.parseInt(x[4]), x[0]);
            for (int j = 0; j < found.food.length; j++) {
                if (found.food[j] == null) {
                    found.food[j] = toInsert;
                    break;
                }
            }
            found.remainingCalories -= Integer.parseInt(x[1]);
            found.remainingProtein -= Integer.parseInt(x[2]);
            found.remainingCarbs -= Integer.parseInt(x[3]);
            found.remainingFat -= Integer.parseInt(x[4]);
            System.out.println("You have " + (int) found.remainingCalories + " calories remaining. You still need " + found.remainingProtein + " grams of protein, " + found.remainingCarbs + " grams of carbs, and " + found.remainingFat + " grams of fat.");
        }
    }

    public static void macros (Node found) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your desired macro ratios in the format\nprotein%carbs%fats");
        String input = sc.nextLine();
        String [] macros = input.split("%");
        double protein = (Double.parseDouble(macros[0]) / 100) * found.calorie;
        double carbs = (Double.parseDouble(macros[1]) / 100) * found.calorie;
        double fat = (Double.parseDouble(macros[2]) / 100) * found.calorie;
        int gprotein = (int)protein / 4;
        int gcarbs = (int)carbs / 4;
        int gfat = (int)fat / 9;
        found.protein = gprotein;
        found.carbs = gcarbs;
        found.fats = gfat;
        found.remainingProtein = found.protein;
        found.remainingCarbs = found.carbs;
        found.remainingFat = found.fats;
        System.out.println("Given your percentages, you should aim for " + gprotein + " grams of protein, " +
                gcarbs + " grams of carbohydrates, and " + gfat + " grams of fat per day" );
    }

    public static void maxes(Node found) {
        Scanner lifts = new Scanner(System.in);
        String exercise = "";
        String r = "";
        System.out.println("Please enter the exercise you maxed, or type search to find historic maxes.");
        exercise = lifts.nextLine();
        if (exercise.equals("search")) {
            System.out.println("Please enter the exercise you want to search in the same format you entered it.");
            exercise = lifts.nextLine();
            for (int i = 0; i < found.lifts.length; i++) {
                if (found.lifts[i].exercise.equals(exercise)) {
                    if (found.lifts[i].reps == 1) {
                        r = "rep";
                    }
                    else {
                        r = "reps";
                    }
                    System.out.println("When it comes to " + exercise + ", your best was " + found.lifts[i].weight + " for " + found.lifts[i].reps + " " + r + ".");
                    break;
                }
            }
        }
        else {
            System.out.println("Please enter the weight you lifted");
            int weight = lifts.nextInt();
            System.out.println("Please enter the number of reps");
            int reps = lifts.nextInt();
            double max = 0.0;
            if (reps == 1) {
                max = weight;
            }
            else {
                max = weight * (1 + (reps / 30.0));
            }
            int x = (int)max;
            System.out.println("Your " + exercise + " max is " + x + " pounds.");
            Lift toInsert = new Lift(exercise, reps, weight);
            for (int i = 0; i < found.lifts.length; i++) {
                if (found.lifts[i] == null) {
                    found.lifts[i] = toInsert;
                    break;
                }
                else {
                    break;
                }
            }
        }
    }

    public static void edit(Node found) {
        Scanner edit = new Scanner(System.in);
        String tochange = "";
        int x = 0;
        while (true) {
            System.out.println();
            System.out.println("Please enter the aspect you would like to change or exit to quit.");
            System.out.println("name\nage\nfeet\ninches\nweight\ngender\nactivity level");
            tochange = edit.nextLine();
            if (tochange.equals("exit")) {
                return;
            }
            else {
                if (tochange.equals("name")) {
                    System.out.println("Please enter the new name");
                    tochange = edit.nextLine();
                    found.name = tochange;
                }
                else if (tochange.equals("age")) {
                    System.out.println("Please enter the new age");
                    x = edit.nextInt();
                    found.age = x;
                }
                else if (tochange.equals("feet")) {
                    System.out.println("Please enter the new feet");
                    x = edit.nextInt();
                    found.feet = x;
                }
                else if (tochange.equals("inches")) {
                    System.out.println("Please enter the new inches");
                    x = edit.nextInt();
                    found.inches = x;
                }
                else if (tochange.equals("weight")) {
                    System.out.println("Please enter your new weight");
                    x = edit.nextInt();
                    found.weight = x;
                }
                else if (tochange.equals("gender")) {
                    System.out.println("Please enter your new gender :) lol");
                    tochange = edit.nextLine();
                    if (tochange.equals("male") || tochange.equals("Male")) {
                        found.gender = "Male";
                    }
                    else if (tochange.equals("female") || tochange.equals("Female")) {
                        found.gender = "Female";
                    }
                }
                else if (tochange.equals("activity level")) {
                    System.out.println("Please enter your activity level : \n1 for Sedentary\n2 for Lightly active\n3 for Moderately Active\n4 for Very Active\n5 for Extra Active");
                    int choice = 0;
                    choice = edit.nextInt();
                    double active = 0;
                    switch (choice) {
                        case 1:
                            active = 1.2;
                            break;

                        case 2:
                            active = 1.375;
                            break;

                        case 3:
                            active = 1.55;
                            break;

                        case 4:
                            active = 1.725;
                            break;

                        case 5:
                            active = 1.9;
                            break;
                    }
                }
            }
        }
    }

    public static Admin newAdmin() {
        Scanner admin = new Scanner(System.in);
        System.out.println("Admin candidate, enter the correct code");
        int x = admin.nextInt();;
        if (x == 1234) {
            admin.nextLine();
            String username = "";
            String password = "";
            System.out.println("New admin, enter your username.");
            username = admin.nextLine();
            System.out.println("Admin, please enter your password");
            password = admin.nextLine();
            System.out.println("Congratulations, you can now use the admin functions.");
            Admin toR = new Admin(username, password);
            return toR;
        }
        else {
            return null;
        }
    }

    public static void adminFunctions(Admin a, List users) {
        Scanner ad = new Scanner(System.in);
        String username = "";
        String password = "";
        System.out.println("Admin, enter your username.");
        username = ad.nextLine();
        if (username.equals(a.username)) {
            System.out.println("Admin, please enter your password.");
            password = ad.nextLine();
            if (password.equals(a.password)) {
                int choice = 0;
                int e = 0;
                while (true) {
                    if (e == 1) {
                        return;
                    }
                    System.out.println("Hello " + a.username + ", what would you like to do today?");
                    System.out.println("1. Print users names and passwords");
                    System.out.println("2. Remove a user from the list");
                    System.out.println("3. Clear the list");
                    System.out.println("4. Exit");
                    choice = ad.nextInt();
                    switch (choice) {
                        case 1:
                            printList(users);
                            break;
                        case 2:
                            System.out.println("Enter the users name:");
                            ad.nextLine();
                            String name = ad.nextLine();
                            users.remove(users, name);
                            break;
                        case 3:
                            users.head = null;
                            System.out.println("List was cleared.");
                            break;
                        case 4:
                            e = 1;
                            break;
                    }
                }
            }
            else {
                System.out.println("Wrong password");
            }
        }
        else {
            System.out.println("The admin is not on file.");
        }



    }

    public static void printList(List users) {
        Node temp = users.head;
        while (temp != null) {
            System.out.println("Username : " + temp.name + " Password : " + temp.password);
            temp = temp.next;
        }
    }



    public static void main(String[] args) {
        List users = new List();
        Scanner sc = new Scanner(System.in);
        Admin x = null;
        int choice = 0;
        int end = 0;
        int login = 0;
        Node found = null;
        while (true) {
            if (end == 1) {
                break;
            }
            System.out.println();
            System.out.println("Welcome to the Macrolator!");
            System.out.println("1. Add user");
            System.out.println("2 view profile");
            System.out.println("3 what's my bmi?");
            System.out.println("4 Bulking and cutting calories");
            System.out.println("5 Calculate macros");
            System.out.println("6 food journal");
            System.out.println("7 1-rep maxes");
            System.out.println("8 edit profile");
            System.out.println("9 new admin");
            System.out.println("10 admin functions");
            System.out.println("11 exit");
            System.out.println();
            choice = sc.nextInt();
            switch (choice) {

                case 1:
                    Node L = takeUI();
                    users.prepend(L);
                    calculate(L);
                    System.out.println();
                    break;
                case 2:
                    if (found == null) {
                        found = login(users);
                    }
                    if (found != null) {
                        printUser(found);
                    }
                break;
                case 3:
                    if (found == null) {
                        found = login(users);
                    }
                    if (found != null) {
                        bmi(found);
                    }
                break;
                case 4:
                    if (found == null) {
                        found = login(users);
                    }
                    if (found != null) {
                        bulkcut(found);
                    }
                break;
                case 5:
                    if (found == null) {
                        found = login(users);
                    }
                    if (found != null) {
                        macros(found);
                    }
                break;
                case 6:
                    if (found == null) {
                        found = login(users);
                    }
                    if (found != null) {
                        foodJournal(found);
                    }

                break;
                case 7:
                    if (found == null) {
                        found = login(users);
                    }
                    if (found != null) {
                        maxes(found);
                    }
                break;
                case 8:
                    if (found == null) {
                        found = login(users);
                    }
                    if (found != null) {
                        edit(found);
                    }
                break;
                case 9:
                    x = newAdmin();
                break;
                case 10:
                    if (x != null) {
                        adminFunctions(x, users);
                    }
                break;
                case 11:
                    end = 1;
                break;
            }
            choice = 0;
        }


    }
}
