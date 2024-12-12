# I. Project Overview

  The Sustainability Tracker is a Java-based program designed to help households monitor their environmental footprint by tracking energy consumption, water usage, and waste generation. The program calculates a sustainability score based on the tracked data, encouraging users to adopt eco-friendly practices.

---

# II. OOP Principles

- **Encapsulation**

  Each resource tracker (Energy, Water, Waste) is represented as a class with private fields (e.g., `electricityUsage`, `waterUsage`) that can only be accessed or modified through public getter and setter methods.
This protects the integrity of the data and ensures validation rules (e.g., non-negative values) are enforced.

- **Inheritance**

  The Tracker class serves as an abstract base class for `EnergyTracker`, `WaterTracker`, and `WasteTracker`. These specialized classes inherit common properties (e.g., `householdName`) and methods while adding their unique attributes and behaviors.

- **Polymorphism**

  The program uses the `displayReport()` method, which is defined in the Tracker class and overridden in its subclasses. This allows a common interface for displaying reports, while the behavior varies depending on the tracker type.

- **Abstraction**

  The Tracker class is abstract, meaning it cannot be instantiated directly. Instead, it provides a blueprint for specific trackers, emphasizing the essential details and hiding implementation complexities.

---

# III. Details of the Chosen SDG and Its Integration into the Project

- **Sustainable Development Goal 12: Responsible Consumption and Production**

  Encouraging households to monitor and optimize their energy and water usage. Highlighting the environmental impact of waste generation through a sustainability score. Raising awareness about resource efficiency and sustainable living. By providing reports and scores, the Green Home Tracker helps users make informed decisions that contribute to reducing their ecological footprint.

---------------------------------------------------------------------------------------------------------------------------------------------------------

# IV. Instructions for Running the Program

- **Prerequisites**

  Java Development Kit (JDK): Ensure you have JDK 17 or later installed.

  IDE/Text Editor: Use an IDE like BlueJ, or a text editor like VS Code with Java extensions.

  Terminal: Required to compile and run the program.

- **Steps to Run**

  Download the Source Code: `SustainabilityTracker.java`

- **Compile the Program**

  Open your terminal/command prompt, navigate to the directory containing the file, and run:

- **Run the Program**

  Follow the On-Screen Instructions:

  1. Set the household name.
  2. Add trackers for energy, water, and waste.
  3. View individual reports or calculate the sustainability score.
  4. Exit when finished.

# Sample Execution Flow

          --------------------------------------
     	          SUSTAINABILITY TRACKER
          --------------------------------------
     
          1. Set Household Name
          2. Add Energy Tracker
          3. Add Water Tracker
          4. Add Waste Tracker
          5. Display All Reports
          6. Calculate Sustainability Score
          7. Exit
          Choose an option:


# Additional Notes 

* Input validation ensures only valid data is accepted.

* The program exits when option 7 is chosen.
