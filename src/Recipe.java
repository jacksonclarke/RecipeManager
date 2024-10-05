import java.util.ArrayList;  // Importing ArrayList class from java.util package.

public class Recipe{ // Class Recipe.
    private String name;
    private ArrayList<String> ingredients;
    private String instructions;
    private String category;

    // Constructor for Recipe class.
    public Recipe(String name, ArrayList<String> ingredients, String instructions, String category){
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
    }
    
    // Getters and setters for the Recipe class.
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<String> getIngredients(){
        return this.ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients){
        this.ingredients = ingredients;
    }

    public String getInstructions(){
        return this.instructions;
    }

    public void setInstructions(String instructions){
        this.instructions = instructions;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    // toString method for Recipe class.
    public String toString(){
        return "Name: " + this.name + " Ingredients: " + this.ingredients + " Instructions: " + this.instructions + " Category: " + this.category + "\n";
    }
}