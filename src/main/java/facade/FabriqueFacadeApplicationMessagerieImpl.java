package facade;

public class FabriqueFacadeApplicationMessagerieImpl implements FabriqueFacadeApplicationMessagerie {
    @Override
    public FacadeApplicationMessagerie creer() {
        return new FacadeApplicationMessagerieImpl();
    }
}
