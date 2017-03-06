package view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import controller.Controller;
import view.menu.OperationsMenu;
import view.menu.GetDiscountableMenu;
import view.menu.GetLotsMenu;
import view.menu.ScanMenu;

/**
 * Implementation of View interface.
 *
 */

public class ViewImpl extends JFrame implements View {

    /**
     * 
     */

    private static final long serialVersionUID = -2914580357647719433L;
    private final Controller controller;
    private final JMenuBar menuBar = new JMenuBar();
    private final GetLotsMenu getLots;
    private final GetDiscountableMenu getDiscountable;
    private final JMenu operations;
    private ScanMenu scan;
    private JTextArea textArea;

    /**
     * 
     * @param cont
     *            controller
     */
    public ViewImpl(final Controller cont) {
        this.controller = cont;
        this.operations = new OperationsMenu(this, controller);
        this.getDiscountable = new GetDiscountableMenu(this, this.controller);
        this.getLots = new GetLotsMenu(this, controller);
        this.scan = new ScanMenu(controller);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("SuperSmarket");
        this.menuBar.add(this.getLots);
        this.menuBar.add(this.getDiscountable);
        this.menuBar.add(this.operations);
        this.menuBar.add(this.scan);
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.textArea.setSize(dim);
        final JScrollPane jsp = new JScrollPane(this.textArea);
        jsp.setAutoscrolls(true);
        this.add(jsp);
        this.getContentPane().add(menuBar, BorderLayout.NORTH);
        this.getContentPane().add(jsp);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 1);
        this.setLocation((dim.width - this.getSize().width) / 2, (dim.height - this.getSize().height) / 2);
        this.setVisible(true);
    }

    /**
     * 
     */
    public void update() {
        try {
            SwingUtilities.invokeAndWait(() -> JOptionPane.showMessageDialog(new JFrame(), "I has been notified"));
        } catch (InvocationTargetException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param text
     *            text
     */
    public void setTextInArea(final String text) {
        this.textArea.setText(text);
    }
}
