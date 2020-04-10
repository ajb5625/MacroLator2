public class Node {
    public String name;
    public int age;
    public int feet;
    public int inches;
    public double activity;
    public int weight;
    public Node next;
    public String gender;
    public double bmr;
    public double calorie;
    public double remainingCalories;
    public String password;
    public double bmi;
    public int hasLoggedin;
    public Food[] food;
    public int carbs;
    public int protein;
    public int fats;
    public int remainingProtein;
    public int remainingCarbs;
    public int remainingFat;
    public Lift[] lifts;
    public Node(String name, int age, double activity, int weight, String gender, int feet, int inches, String password) {
        this.name = name;
        this.age = age;
        this.feet = feet;
        this.inches = inches;
        this.activity = activity;
        this.weight = weight;
        this.gender = gender;
        this.next = null;
        this.bmr = 0.0;
        this.calorie = 0.0;
        this.protein = 0;
        this.carbs = 0;
        this.fats = 0;
        this.password = password;
        this.bmi = 0.0;
        this.hasLoggedin = 0;
        this.remainingCalories = this.calorie;
        this.remainingCarbs = this.carbs;
        this.remainingFat = this.fats;
        this.remainingProtein = this.protein;
        this.food = new Food[5];
        this.lifts = new Lift[5];
    }
}
