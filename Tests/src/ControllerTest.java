import controller.Controller;
import core.toy.Toys;
import org.junit.Assert;
import org.junit.Test;

public class ControllerTest {
    private Controller<Toys> controller;

    private void Setup() {
        controller = new Controller<Toys>("1.json","2.json");
    }

    @Test
    public void Controller_test(){
        Setup();

        Assert.assertNotNull(controller);
    }

    @Test
    public void Controller_run_test(){
        Setup();

        controller.run();

        Assert.assertNotNull(controller);
    }
}
