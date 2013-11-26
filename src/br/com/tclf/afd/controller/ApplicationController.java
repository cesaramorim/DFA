package br.com.tclf.afd.controller;

import br.com.tclf.afd.model.AFD;
import br.com.tclf.afd.util.MinimizarAFD;
import br.com.tclf.afd.util.Util;
import br.com.tclf.afd.view.GraphicsAFD;
import br.com.tclf.afd.view.WindowMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: KESSILER
 * Date: 02/11/13
 * Time: 01:09
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationController {

    private final String titleWindow = "Trabalho TCLF - Minimização AFD";
    private WindowMain guiApplication;
    private AFD afd;
    private GraphicsAFD graphicsAFD;


    public ApplicationController() throws IOException {
        JMenuBar mainMenuBar = new JMenuBar();
        JMenu menu = new JMenu("Algoritmos");
        mainMenuBar.add(menu);
        JMenuItem menuItemAFD = new JMenuItem("Minimizar AFD");
        menuItemAFD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MinimizarAFD afdMin = new MinimizarAFD();
                boolean afdMinimized = afdMin.minimizar(afd);
                graphicsAFD.setAFD(afd);
                graphicsAFD.redrawAFD();
                try {
                    Util.writeFile("./resources/AFDMinimizado.txt", afd.toString());
                } catch (IOException io) {
                    io.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, afdMinimized ? "AFD minimizado." : "AFD já é mínimo.");
            }
        });
        menu.add(menuItemAFD);
        guiApplication = new WindowMain();
        guiApplication.setTitle(this.titleWindow);
        guiApplication.setJMenuBar(mainMenuBar);
        afd = AFD.fromFile("./resources/AFD.txt");
        graphicsAFD = new GraphicsAFD();
        graphicsAFD.setAFD(afd);
        guiApplication.getContentPane().add(graphicsAFD.drawAFD(), BorderLayout.CENTER);
        guiApplication.pack();
        guiApplication.setVisible(true);
    }
}
