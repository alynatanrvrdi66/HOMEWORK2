import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, ArrayList<SWSystem>> systems = SWSystemData.getAllSystems();
        ArrayList<SWSystem> webSystems = systems.get("Web");
        SWSystem shopSphere = webSystems.get(0);
        ArrayList<QualityDimension> dims = shopSphere.getDimensions();

        dims.get(0).getCriteria().get(0).setMeasuredValue(94);
        dims.get(0).getCriteria().get(1).setMeasuredValue(91);

        dims.get(1).getCriteria().get(0).setMeasuredValue(99.2);
        dims.get(1).getCriteria().get(1).setMeasuredValue(2.1);

        dims.get(2).getCriteria().get(0).setMeasuredValue(220);
        dims.get(2).getCriteria().get(1).setMeasuredValue(38);

        dims.get(3).getCriteria().get(0).setMeasuredValue(72);
        dims.get(3).getCriteria().get(1).setMeasuredValue(8.5);

        shopSphere.printReport();
    }

}
