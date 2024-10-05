// import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class RecipeManagerUi {
    // Create the components for the UI
    private JFrame frame;
    private JPanel panel;
    private JButton addButton;
    private JButton saveButton;
    private JList<Recipe> recipeList;

    // Create the UI
    public void RecipeManagerUI() {
        frame = new JFrame("Recipe Manager");
        panel = new JPanel();
        addButton = new JButton("Add Recipe");
        saveButton = new JButton("Save Recipe");
        recipeList = new JList<>();

        // Set up the layout and add components
        panel.add(addButton);
        panel.add(saveButton);
        panel.add(new JScrollPane(recipeList));
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Add action listener to the button

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt the user for a new recipe name, ingrediants, instructions, and category
                String name = JOptionPane.showInputDialog(frame, "Enter the recipe name:");
                String ingredients = JOptionPane.showInputDialog(frame, "Enter the ingredients (separated by commas):");
                String instructions = JOptionPane.showInputDialog(frame, "Enter the instructions:");
                String category = JOptionPane.showInputDialog(frame, "Enter the category:");

                // Split the ingredients string into a list
                ArrayList<String> ingredientList = new ArrayList<>();
                for (String ingredient : ingredients.split(",")) {
                    ingredientList.add(ingredient.trim());
                }

                // Create a new recipe with the user input
                Recipe recipe = new Recipe(name, ingredientList, instructions, category);

                // Add the recipe to the list without removing the existing recipes
                List<Recipe> recipes = new ArrayList<>();
                for (int i = 0; i < recipeList.getModel().getSize(); i++) {
                    recipes.add(recipeList.getModel().getElementAt(i));
                }
                recipes.add(recipe);
                recipeList.setListData(recipes.toArray(new Recipe[0]));

            }
        });
        // Save the added recipes to a text file.
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the list of recipes from the JList.
                List<Recipe> recipes = new ArrayList<>();
                for (int i = 0; i < recipeList.getModel().getSize(); i++) {
                    recipes.add(recipeList.getModel().getElementAt(i));
                }
                // Prompt the user for the file name to save the recipes to.
                String name = JOptionPane.showInputDialog(frame, "What file would you like to save the recipes to?");
                // Write the recipes to the file.
                ReadWrite.writeToFile(name, recipes);

                // Display a message to the user
                JOptionPane.showMessageDialog(frame, "Recipes saved successfully!");

            }
        });
    
    }

}
