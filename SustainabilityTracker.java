import java.util.ArrayList;
import java.util.Scanner;

// Parent class
abstract class Tracker {
    protected String householdName;

    public Tracker(String householdName) {
        this.householdName = householdName;
    }

    public abstract void displayReport();
}

class EnergyTracker extends Tracker {
    private double electricityUsage;

    public EnergyTracker(String householdName, double electricityUsage) {
        super(householdName);
        if (electricityUsage < 0) {
            throw new IllegalArgumentException("Electricity usage cannot be negative.");
        }
        this.electricityUsage = electricityUsage;
    }

    public double getElectricityUsage() {
        return electricityUsage;
    }

    public final void setElectricityUsage(double electricityUsage) {
        if (electricityUsage < 0) {
            throw new IllegalArgumentException("Electricity usage cannot be negative.");
        }
        this.electricityUsage = electricityUsage;
    }

    @Override
    public void displayReport(){
        System.out.println("Energy Report for " + householdName + ":");
        System.out.println("Electricity Usage: " + electricityUsage + " kWh");
    }
}

class WaterTracker extends Tracker {
    private double waterUsage;

    public WaterTracker(String householdName, double waterUsage) {
        super(householdName);
        if (waterUsage < 0) {
            throw new IllegalArgumentException("Water usage cannot be negative.");
        }
        this.waterUsage = waterUsage;
    }

    public double getWaterUsage() {
        return waterUsage;
    }

    public final void setWaterUsage(double waterUsage) {
        if (waterUsage < 0) {
            throw new IllegalArgumentException("Water usage cannot be negative.");
        }
        this.waterUsage = waterUsage;
    }

    @Override
    public void displayReport() {
        System.out.println("\nWater Report for " + householdName + ":");
        System.out.println("Water Usage: " + waterUsage + " liters");
    }
}

class WasteTracker extends Tracker {
    private double wasteGenerated;

    public WasteTracker(String householdName, double wasteGenerated) {
        super(householdName);
        if (wasteGenerated < 0) {
            throw new IllegalArgumentException("Waste generated cannot be negative.");
        }
        this.wasteGenerated = wasteGenerated;
    }

    public double getWasteGenerated() {
        return wasteGenerated;
    }

    public final void setWasteGenerated(double wasteGenerated) {
        if (wasteGenerated < 0) {
            throw new IllegalArgumentException("Waste generated cannot be negative.");
        }
        this.wasteGenerated = wasteGenerated;
    }

    @Override
    public void displayReport() {
        System.out.println("\nWaste Report for " + householdName + ":");
        System.out.println("Waste Generated: " + wasteGenerated + " kg");
    }
}

class ScoreCalculator {
    public double calculateScore(double electricityUsage, double waterUsage, double wasteGenerated) {
        return 100 - (electricityUsage * 0.5 + waterUsage * 0.3 + wasteGenerated * 0.2);
    }

    public String calculateGrade(double score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public String getGradeDescription(String grade) {
        switch (grade) {
            case "A":
                return "Excellent sustainability efforts!";
            case "B":
                return "Good sustainability efforts, but there's room for improvement.";
            case "C":
                return "Satisfactory sustainability efforts, but significant improvements are needed.";
            case "D":
                return "Needs significant improvement in sustainability efforts.";
            case "F":
                return "Poor sustainability efforts. Major improvements needed.";
            default:
                return "Invalid grade.";
        }
    }
}

public class SustainabilityTracker {
    public static void main(String[] args) {
        ArrayList<Tracker> trackers = new ArrayList<>();
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        Scanner scanner = new Scanner(System.in);
        String householdName = "";

        while (true) {
            System.out.println("\n--------------------------------------");
            System.out.println("\tSUSTAINABILITY TRACKER");
            System.out.println("--------------------------------------");
            System.out.println("\n1. Set Household Name");
            System.out.println("2. Add Energy Tracker");
            System.out.println("3. Add Water Tracker");
            System.out.println("4. Add Waste Tracker");
            System.out.println("5. Display All Reports");
            System.out.println("6. Calculate Sustainability Score");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter household name: ");
                        householdName = scanner.nextLine();
                        System.out.println("Household name set to: " + householdName);
                        break;

                    case "2":
                        if (householdName.isEmpty()) {
                            System.out.println("Error: You must the household name before adding.");
                        } else {
                            System.out.print("Enter electricity usage (kWh): ");
                            double electricityUsage = Double.parseDouble(scanner.nextLine());
                            trackers.add(new EnergyTracker(householdName, electricityUsage));
                            System.out.println("\nEnergy Tracker added.");
                        }
                        break;

                    case "3":
                        if (householdName.isEmpty()) {
                            System.out.println("Error: You must the household name before adding.");
                        } else {
                            System.out.print("Enter water usage (liters): ");
                            double waterUsage = Double.parseDouble(scanner.nextLine());
                            trackers.add(new WaterTracker(householdName, waterUsage));
                            System.out.println("\nWater Tracker added.");
                        }
                        break;

                    case "4":
                        if (householdName.isEmpty()) {
                            System.out.println("Error: You must the household name before adding.");
                        } else {
                            System.out.print("Enter waste generated (kg): ");
                            double wasteGenerated = Double.parseDouble(scanner.nextLine());
                            trackers.add(new WasteTracker(householdName, wasteGenerated));
                            System.out.println("\nWaste Tracker added.");
                        }
                        break;

                    case "5":
                        if (trackers.isEmpty()) {
                            System.out.println("No trackers added yet. The Energy Tracker, Water Tracker, and Waste Tracker are all empty.");
                        } else {
                            System.out.println("\n-------------------------------");
                            System.out.println("\t R E P O R T");
                            System.out.println("-------------------------------");
                            boolean hasEnergy = false, hasWater = false, hasWaste = false;

                            for (Tracker tracker : trackers) {
                                if (tracker instanceof EnergyTracker) {
                                    hasEnergy = true;
                                } else if (tracker instanceof WaterTracker) {
                                    hasWater = true;
                                } else if (tracker instanceof WasteTracker) {
                                    hasWaste = true;
                                }
                                tracker.displayReport();
                            }

                            if (!hasEnergy) {
                                System.out.println("No data for Energy Tracker.");
                            }
                            if (!hasWater) {
                                System.out.println("No data for Water Tracker.");
                            }
                            if (!hasWaste) {
                                System.out.println("No data for Waste Tracker.");
                            }
                        }
                        break;
                    case "6":
                        double totalElectricity = 0, totalWater = 0, totalWaste = 0;

                        for (Tracker tracker : trackers) {
                            if (tracker instanceof EnergyTracker) {
                                totalElectricity += ((EnergyTracker) tracker).getElectricityUsage();
                            } else if (tracker instanceof WaterTracker) {
                                totalWater += ((WaterTracker) tracker).getWaterUsage();
                            } else if (tracker instanceof WasteTracker) {
                                totalWaste += ((WasteTracker) tracker).getWasteGenerated();
                            }
                        }

                        if (totalElectricity == 0 || totalWater == 0 || totalWaste == 0) {
                            System.out.println("Error: All trackers (Energy, Water, and Waste) must be filled before calculating the score.");
                        } else {
                            double score = scoreCalculator.calculateScore(totalElectricity, totalWater, totalWaste);
                            String grade = scoreCalculator.calculateGrade(score);
                            String gradeDescription = scoreCalculator.getGradeDescription(grade);
                            System.out.println("\nSustainability Score for " + householdName + ": " + score + "/100");
                            System.out.println("Grade: " + grade);
                            System.out.println("Description: " + gradeDescription);
                        }
                        break;

                    case "7":
                        System.out.println("Goodbye! Please come again");
                        scanner.close();
                        return;

                    default:
                        System.out.println("\nInvalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numeric input.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}