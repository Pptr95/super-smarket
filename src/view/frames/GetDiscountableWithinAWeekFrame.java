package view.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import model.Lot;
import model.discountstrategies.DiscountStrategyFactoryImpl;
import view.View;
/**
 * 
 *
 */
public class GetDiscountableWithinAWeekFrame extends CustomFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 5926371999570025570L;
/**
 * 
 * @param controller controller
 */
    public GetDiscountableWithinAWeekFrame(final View view, final Controller controller) {
        @SuppressWarnings("unused")
        //to remove when i'll use map
        Map<Lot, Integer> map = controller.getDiscountable(new DiscountStrategyFactoryImpl().expiresWithinAWeek());
        JPanel panel = new JPanel(new FlowLayout());
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //TODO, do the object structure where put the information

        ActionListener al = e -> {
            /*
             * con view non ci faccio ancora nulla, l'ho messa perchè serviva per l'update di SetOnSaleFrame
             * (forse servirà per l'update di questa classe)
             */
            new SetOnSaleFrame(view, controller);
        };

        JButton jb = new JButton("Ok set on sale");
        panel.add(jb, BorderLayout.SOUTH);
        jb.addActionListener(al);
        this.getContentPane().add(panel);
        this.initializeSizeAndLocation();

    }
}
