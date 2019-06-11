/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;

import contract.IModel;
import controller.Controller;
import model.Model;
import view.MainView;


/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     * 			throws something
     * @throws InterruptedException
     * 			throws something
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
        final IModel model = new Model(1);
        final MainView bdv = new MainView(model.getMap(), model.getTheCharacter(), model.getMap().getMobileEntities());
        final Controller controller = new Controller(bdv, model);
        bdv.setOrderPerformer(controller);
        controller.play();
    }
}
