import java.util.HashMap;
import java.util.Map;

//Subject class of proxy.
public interface HeavyObject {
    void processHeavyData();
}

//Virtual proxy using Lazy init.
class HeavyObjectProxy implements HeavyObject {
    private static HeavyObject heavyObjectWrappe;

    @Override
    public void processHeavyData() {
        heavyObjectWrappe = heavyObjectWrappe==null? new HeavyObjectImpl(): heavyObjectWrappe;
        System.out.println("Processed.");
    }
}

//Heavy object implementation
class HeavyObjectImpl implements HeavyObject {
    private Map<String, Integer> heavyData = new HashMap<>();

    public HeavyObjectImpl() {
        processHeavyData();
    }

    //Processing some expensive operation
    @Override
    public void processHeavyData() {
        System.out.println("Loading heavy data..");
        for(int i=0; i<1000; i++) {
            heavyData.put(Integer.toString(i), i);
        }
    }

    public Map<String, Integer> getHeavyData() {
        return heavyData;
    }
}
