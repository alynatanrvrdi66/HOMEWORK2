import java.awt.*;
import java.util.ArrayList;

public class SWSystem {
    private String name;
    private String category;
    private String version;
    private ArrayList<QualityDimension> dimensions;

    public SWSystem(String name, String category, String version) {
        this.name = name;
        this.category = category;
        this.version = version;

        this.dimensions = new ArrayList<>();
    }
    public ArrayList<QualityDimension> getDimensions() {
        return dimensions;
    }
    public void addDimension(QualityDimension d){
        dimensions.add(d);
    }
    public double calculateOverallScore(){
        double total = 0;
        double weightSum = 0;

        for(QualityDimension d : dimensions){
            double score = d.calculateDimensionScore();

            total += score * d.getWeight();
            weightSum += d.getWeight();
        }
        double result = total / weightSum;

        result = Math.round(result * 10) / 10.0;

        return result;
    }
    public QualityDimension findWeakestDimension() {
        QualityDimension weakest = null;
        double minScore = Double.MAX_VALUE;

        for(QualityDimension d : dimensions) {

            double score = d.calculateDimensionScore();

            if(score < minScore) {

                minScore = score;
                weakest = d;
            }
        }
        return weakest;
    }
    public void printReport(){
        System.out.println("========================================");
        System.out.println("SOFTWARE QUALITY EVALUATION REPORT (ISO/IEC 25010)");
        System.out.println("System: " + name + " v" + version + " (" + category + ")");
        System.out.println("========================================");

        for(QualityDimension d : dimensions){

            System.out.println();
            System.out.println("--- " + d.getName() + " [" + d.getIsoCode() + "] (Weight: " + d.getWeight() + ") ---");

            for(Criterion c : d.getCriteria()){
                double score = c.calculateScore();
                System.out.println(c.getName() + ": " + c.getMeasuredValue() + " " + c.getUnit() + " -> Score: "
                                   + score + " (" + c.getDirection() + " is better)");
            }

            System.out.println(">> Dimension Score: " + d.calculateDimensionScore() + "/5 [" + d.getQualityLabel() + "]");
        }
        System.out.println();
        System.out.println("========================================");
        double overall = calculateOverallScore();
        System.out.println("OVERALL QUALITY SCORE: " + overall + "/5");
        System.out.println("========================================");

        QualityDimension weakest = findWeakestDimension();

        System.out.println();
        System.out.println("GAP ANALYSIS (ISO/IEC 25010)");
        System.out.println("========================================");
        System.out.println("Weakest Characteristic : " + weakest.getName() + " [" + weakest.getIsoCode() + "]");
        System.out.println("Score: " + weakest.calculateDimensionScore() + "/5  |  Gap: " + weakest.getQualityGap());
        System.out.println("Level: " + weakest.getQualityLabel());
        System.out.println("========================================");
    }
}
