import java.util.ArrayList;

public class QualityDimension {
    private String name;
    private String isoCode;
    private double weight;
    private ArrayList<Criterion> criteria;

    public QualityDimension(String name,String isoCode,double weight){
        this.name = name;
        this.isoCode = isoCode;
        this.weight = weight;

        this.criteria = new ArrayList<>();
    }

    public void addCriterion(Criterion c){
        criteria.add(c);
    }

    public double calculateDimensionScore() {
        double total = 0;
        double weightSum = 0;
        for(Criterion c : criteria) {
            double score = c.calculateScore();

            total += score * c.getWeight();
            weightSum += c.getWeight();
        }
        double result = total / weightSum;
        result = Math.round(result * 2) / 2.0;

        return result;
    }

    public String getQualityLabel() {
        double score = calculateDimensionScore();

        if(score >= 4.5){
            return "Excellent Quality";
        }
        else if(score >= 3.5) {
            return "Good Quality";
        }
        else if(score >= 2.5) {
            return "Needs Improvement";
        }
        else {
            return "Poor Quality";
        }
    }

    //Getters
    public double getQualityGap() {
        return 5 - calculateDimensionScore();
    }
    public String getName() {
        return name;
    }
    public String getIsoCode() {
        return isoCode;
    }
    public double getWeight() {
        return weight;
    }
    public ArrayList<Criterion> getCriteria() {
        return criteria;
    }

}
