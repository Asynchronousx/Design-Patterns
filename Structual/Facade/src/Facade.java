import java.util.HashMap;
import java.util.Map;

//Facade interface
public interface Facade {
    Map<String, String> assembleRobot();
}

//Facade concrete class: in this class, we're unifying all the methods the client need to access
//to satisfy his needs. The facade differences from templates because we choose which method should be included,
//and not the template itself.
class BuildRobot implements Facade {
    public Map<String, String> assembleRobot() {
        AssembleLegs.assemble();
        AssembleBody.assemble();
        AssembleArms.assemble();
        AssembleHead.assemble();
        return Assembler.robotParts;
    }
}

//An abstract class that facade use to simplify and unify the methods
abstract class Assembler {
    static Map<String, String> robotParts = new HashMap<>();

    public static Map<String, String> getRobotParts() {
        return robotParts;
    }
}

//Lot of classes that does a bunch of different things. with facade, we're going to unify all those methods
//in one single method.
class AssembleHead extends Assembler {

    public static void assemble() {
        robotParts.put("Head", "X-Ray Super Cool Head");
    }
}

class AssembleArms extends Assembler {

    public static void assemble() {
        robotParts.put("Arms", "Laser Cannon Arms");
    }
}

class AssembleBody extends Assembler {

    public static void assemble() {
        robotParts.put("Body", "Mechatronic Body");
    }
}

class AssembleLegs extends Assembler {

    public static void assemble() {
        robotParts.put("Legs", "Bionic Legs");
    }
}

