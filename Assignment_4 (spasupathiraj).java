// File Name: Assignment_4.java
// Author: Saranath Raj Pasupathi Raj 
// Student ID: 6001185214
// Class Number: COSC 5340
// Section Number: 80955
// Semester: Master's in Computer Science, Fourth Semester (Fall 2023) 
// Assignment #: 4
// Date Created: November 29, 2023
// Program Description: 
                    // Design a Java program that employs the concept of inheritance and abstract superclasses 
                    // To compute measurements on both two-dimensional and three-dimensional geometric figures.
                    
import java.util.InputMismatchException;
import java.util.Scanner;

// Abstract base shape class
abstract class Shape 
{
    abstract void readShape(); // Abstract method to read shape-specific characteristics
    abstract void displayShape(); // Abstract method to display shape information
}

// Abstract class for a two-dimensional shape, extending the Shape class
abstract class TwoDimensionalShape extends Shape 
{
    abstract double computeArea(); // Abstract method to compute the area of the 2D shape
    abstract double computePerimeter(); // Abstract method to compute the perimeter of the 2D shape
}

// Abstract class for a three-dimensional shape, extending the Shape class
abstract class ThreeDimensionalShape extends Shape 
{
    abstract double computeVolume(); // Abstract method to compute the volume of the 3D shape
    abstract double computeSurfaceArea(); // Abstract method to compute the surface area of the 3D shape
}

// Concrete class for a circle shape, extending the TwoDimensionalShape class
class Circle extends TwoDimensionalShape {
    // Private field to store the radius of the circle
    private double radius;

    // Override the method to read input for the circle shape
    @Override
    void readShape() {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Flag to check the validity of the input
        boolean validInput = false;

        // Loop until valid input is provided
        while (!validInput) {
            try {
                // Prompt the user to enter the radius
                System.out.print("Enter the Radius of the Circle: ");
                
                // Read the radius from the user
                radius = scanner.nextDouble();

                // Check if the entered radius is positive
                if (radius > 0) {
                    // Set the flag to true if the input is valid
                    validInput = true;
                } else {
                    // Display an error message for invalid input
                    System.out.println("Invalid input. Please enter a positive value for the radius.");
                }
            } catch (InputMismatchException e) {
                // Handle the case where a non-numeric value is entered
                System.out.println("Invalid input. Please enter a numeric value for the radius.");
                
                // Clear the scanner buffer to prevent an infinite loop
                scanner.next();
            }
        }
    }

    // Override method to display information about the circle
    @Override
    void displayShape() {
        // Print the shape name
        System.out.println("Shape: Circle");
        
        // Print the radius of the circle
        System.out.println("Radius: " + radius);
        
        // Print the computed area of the circle
        System.out.println("Area of Circle: " + computeArea());
        
        // Print the computed perimeter of the circle
        System.out.println("Perimeter of Circle: " + computePerimeter());
    }

    // Override method to compute the area of the circle
    @Override
    double computeArea() {
        // Use the formula for the area of a circle: π * radius * radius
        return Math.PI * radius * radius;
    }

    // Override method to compute the perimeter of the circle
    @Override
    double computePerimeter() {
        // Use the formula for the perimeter of a circle: 2 * π * radius
        return 2 * Math.PI * radius;
    }
}

// Concrete class for a square shape, extending the TwoDimensionalShape class
class Square extends TwoDimensionalShape {
    // Private field to store the side length of the square
    private double side;

    // Override the method to read input for the square shape
    @Override
    void readShape() {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Flag to check the validity of the input
        boolean validInput = false;

        // Loop until valid input is provided
        while (!validInput) {
            try {
                // Prompt the user to enter the side length
                System.out.println("Enter the Side of the Square: ");
                
                // Read the side length from the user
                double inputSide = scanner.nextDouble();

                // Validate input
                if (inputSide <= 0) {
                    // Display an error message for invalid input
                    System.out.println("Invalid input. Side must be a positive value.");
                } else {
                    // Set the side length and mark the input as valid
                    side = inputSide;
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                // Handle the case where a non-numeric value is entered
                System.out.println("Invalid input. Please enter a valid number.");
                
                // Consume the invalid input to avoid an infinite loop
                scanner.next();
            }
        }
    }

    // Override method to display information about the square
    @Override
    void displayShape() {
        // Print the shape name
        System.out.println("Shape: Square");
        
        // Print the side length of the square
        System.out.println("Side: " + side);
        
        // Print the computed area of the square
        System.out.println("Area of Square: " + computeArea());
        
        // Print the computed perimeter of the square
        System.out.println("Perimeter of Square: " + computePerimeter());
    }

    // Override method to compute the area of the square
    @Override
    double computeArea() {
        // Use the formula for the area of a square: side * side
        return side * side;
    }

    // Override method to compute the perimeter of the square
    @Override
    double computePerimeter() {
        // Use the formula for the perimeter of a square: 4 * side
        return 4 * side;
    }
}

// Concrete class for a rectangle shape, extending the TwoDimensionalShape class
class Rectangle extends TwoDimensionalShape {
    // Private fields to store the length and width of the rectangle
    private double length;
    private double width;

    // Override the method to read input for the rectangle shape
    @Override
    void readShape() {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Flag to check the validity of the input
        boolean validInput = false;

        // Loop until valid input is provided
        while (!validInput) {
            try {
                // Prompt the user to enter the length
                System.out.println("Enter the Length of the Rectangle: ");
                
                // Read the length from the user
                double inputLength = scanner.nextDouble();

                // Prompt the user to enter the width
                System.out.println("Enter the Width of the Rectangle: ");
                
                // Read the width from the user
                double inputWidth = scanner.nextDouble();

                // Validate inputs
                if (inputLength <= 0 || inputWidth <= 0) {
                    // Display an error message for invalid input
                    System.out.println("Invalid input. Length and width must be positive values.");
                } else {
                    // Set the length, width, and mark the input as valid
                    length = inputLength;
                    width = inputWidth;
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                // Handle the case where a non-numeric value is entered
                System.out.println("Invalid input. Please enter valid numbers.");
                
                // Consume the invalid input to avoid an infinite loop
                scanner.next();
            }
        }
    }

    // Override method to display information about the rectangle
    @Override
    void displayShape() {
        // Print the shape name
        System.out.println("Shape: Rectangle");
        
        // Print the length of the rectangle
        System.out.println("Length: " + length);
        
        // Print the width of the rectangle
        System.out.println("Width: " + width);
        
        // Print the computed area of the rectangle
        System.out.println("Area of Rectangle: " + computeArea());
        
        // Print the computed perimeter of the rectangle
        System.out.println("Perimeter of Rectangle: " + computePerimeter());
    }

    // Override method to compute the area of the rectangle
    @Override
    double computeArea() {
        // Use the formula for the area of a rectangle: length * width
        return length * width;
    }

    // Override method to compute the perimeter of the rectangle
    @Override
    double computePerimeter() {
        // Use the formula for the perimeter of a rectangle: 2 * (length + width)
        return 2 * (length + width);
    }
}

// Concrete class for a sphere class, extending the ThreeDimensionalShape class
class Sphere extends ThreeDimensionalShape {
    // Private field to store the radius of the sphere
    private double radius;

    // Override the method to read input for the sphere shape
    @Override
    void readShape() {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Flag to check the validity of the input
        boolean validInput = false;

        // Loop until valid input is provided
        while (!validInput) {
            try {
                // Prompt the user to enter the radius
                System.out.println("Enter the Radius of the Sphere: ");
                
                // Read the radius from the user
                double inputRadius = scanner.nextDouble();

                // Validate input
                if (inputRadius <= 0) {
                    // Display an error message for invalid input
                    System.out.println("Invalid input. Radius must be a positive value.");
                } else {
                    // Set the radius and mark the input as valid
                    radius = inputRadius;
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                // Handle the case where a non-numeric value is entered
                System.out.println("Invalid input. Please enter a valid number.");
                
                // Consume the invalid input to avoid an infinite loop
                scanner.next();
            }
        }
    }

    // Override method to display information about the sphere
    @Override
    void displayShape() {
        // Print the shape name
        System.out.println("Shape: Sphere");
        
        // Print the radius of the sphere
        System.out.println("Radius: " + radius);
        
        // Print the computed surface area of the sphere
        System.out.println("Surface Area of Sphere: " + computeSurfaceArea());
        
        // Print the computed volume of the sphere
        System.out.println("Volume of Sphere: " + computeVolume());
    }

    // Override method to compute the volume of the sphere
    @Override
    double computeVolume() {
        // Use the formula for the volume of a sphere: (4.0 / 3.0) * π * radius^3
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Override method to compute the surface area of the sphere
    @Override
    double computeSurfaceArea() {
        // Use the formula for the surface area of a sphere: 4 * π * radius^2
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}

// Concrete class for a cube shape, extending the ThreeDimensionalShape class
class Cube extends ThreeDimensionalShape {
    // Private field to store the side length of the cube
    private double side;

    // Override the method to read input for the cube shape
    @Override
    void readShape() {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Flag to check the validity of the input
        boolean validInput = false;

        // Loop until valid input is provided
        while (!validInput) {
            try {
                // Prompt the user to enter the side length
                System.out.println("Enter the Side of the Cube: ");
                
                // Read the side length from the user
                double inputSide = scanner.nextDouble();

                // Validate input
                if (inputSide <= 0) {
                    // Display an error message for invalid input
                    System.out.println("Invalid input. Side must be a positive value.");
                } else {
                    // Set the side length and mark the input as valid
                    side = inputSide;
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                // Handle the case where a non-numeric value is entered
                System.out.println("Invalid input. Please enter a valid number.");
                
                // Consume the invalid input to avoid an infinite loop
                scanner.next();
            }
        }
    }

    // Override method to display information about the cube
    @Override
    void displayShape() {
        // Print the shape name
        System.out.println("Shape: Cube");
        
        // Print the side length of the cube
        System.out.println("Side: " + side);
        
        // Print the computed surface area of the cube
        System.out.println("Surface Area of Cube: " + computeSurfaceArea());
        
        // Print the computed volume of the cube
        System.out.println("Volume of Cube: " + computeVolume());
    }

    // Override method to compute the volume of the cube
    @Override
    double computeVolume() {
        // Use the formula for the volume of a cube: side^3
        return Math.pow(side, 3);
    }

    // Override method to compute the surface area of the cube
    @Override
    double computeSurfaceArea() {
        // Use the formula for the surface area of a cube: 6 * side^2
        return 6 * Math.pow(side, 2);
    }
}

// Concrete class representing a cylinder, extending the ThreeDimensionalShape class
class Cylinder extends ThreeDimensionalShape {
    // Private fields to store the radius and height of the cylinder
    private double radius;
    private double height;

    // Override the method to read input for the cylinder shape
    @Override
    void readShape() {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Flag to check the validity of the input
        boolean validInput = false;

        // Loop until valid input is provided
        while (!validInput) {
            try {
                // Prompt the user to enter the radius
                System.out.println("Enter the Radius of the Cylinder: ");
                
                // Read the radius from the user
                double inputRadius = scanner.nextDouble();

                // Prompt the user to enter the height
                System.out.println("Enter Height of the Cylinder: ");
                
                // Read the height from the user
                double inputHeight = scanner.nextDouble();

                // Validate inputs
                if (inputRadius <= 0 || inputHeight <= 0) {
                    // Display an error message for invalid input
                    System.out.println("Invalid input. Radius and height must be positive values.");
                } else {
                    // Set the radius, height, and mark the input as valid
                    radius = inputRadius;
                    height = inputHeight;
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                // Handle the case where a non-numeric value is entered
                System.out.println("Invalid input. Please enter valid numbers.");
                
                // Consume the invalid input to avoid an infinite loop
                scanner.next();
            }
        }
    }

    // Override method to display information about the cylinder
    @Override
    void displayShape() {
        // Print the shape name
        System.out.println("Shape: Cylinder");
        
        // Print the radius of the cylinder
        System.out.println("Radius: " + radius);
        
        // Print the height of the cylinder
        System.out.println("Height: " + height);
        
        // Print the computed surface area of the cylinder
        System.out.println("Surface Area of Cylinder: " + computeSurfaceArea());
        
        // Print the computed volume of the cylinder
        System.out.println("Volume of Cylinder: " + computeVolume());
    }

    // Override method to compute the volume of the cylinder
    @Override
    double computeVolume() {
        // Use the formula for the volume of a cylinder: π * radius^2 * height
        return Math.PI * Math.pow(radius, 2) * height;
    }

    // Override method to compute the surface area of the cylinder
    @Override
    double computeSurfaceArea() {
        // Use the formula for the surface area of a cylinder: 2 * π * radius * (radius + height)
        return 2 * Math.PI * radius * (radius + height);
    }
}

// Main class containing the program logic
public class Main {
    // Scanner object for user input
    private static final Scanner scanner = new Scanner(System.in);

    // Constants for menu choices
    private static final int CIRCLE = 1;
    private static final int SQUARE = 2;
    private static final int RECTANGLE = 3;
    private static final int CUBE = 4;
    private static final int SPHERE = 5;
    private static final int CYLINDER = 6;

    // Main method where the program execution starts
    public static void main(String[] args) {
        // Loop for asking the user to select a shape
        while (true) {
            displayMenu(); // Display the menu for shape selection
            int choice = getValidChoice(); // Get a valid choice from the user

            // Exit the loop if '0' is entered
            if (choice == 0) {
                System.out.println("Exiting the program. Thank you!");
                break;
            }

            // Get the appropriate shape based on the user's choice
            Shape shape = getShape(choice);

            // Process the selected shape
            if (shape != null) {
                processShape(shape);
            } else {
                System.out.println("Invalid choice. Please select a valid shape.");
            }
        }
    }

    // Display menu with descriptive prompts
    private static void displayMenu() {
        System.out.println("Enter the number corresponding to the shape you want to create:");
        System.out.println("1. Circle\n2. Square\n3. Rectangle\n4. Cube\n5. Sphere\n6. Cylinder\n0. Exit");
    }

    // Method to get a valid choice from the user
    private static int getValidChoice() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                return scanner.nextInt(); // Read and return the user's choice as an integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume invalid input to prevent an infinite loop
            }
        }
    }

    // Method to get the appropriate shape based on the user's choice
    private static Shape getShape(int choice) {
        switch (choice) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            case CUBE:
                return new Cube();
            case SPHERE:
                return new Sphere();
            case CYLINDER:
                return new Cylinder();
            default:
                return null;
        }
    }

    // Method to process the selected shape, displaying its characteristics and measurements
    private static void processShape(Shape shape) {
        shape.readShape(); // Read the specific details of the shape

        // Display overall shape information
        shape.displayShape();
    }
}

