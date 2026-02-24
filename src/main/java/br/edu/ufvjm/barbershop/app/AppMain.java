package br.edu.ufvjm.barbershop.app;

import br.edu.ufvjm.barbershop.service.BarbershopSystem;
import br.edu.ufvjm.barbershop.view.LoginFrame;

import javax.swing.SwingUtilities;

public class AppMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BarbershopSystem system = new BarbershopSystem();
            LoginFrame loginFrame = new LoginFrame(system);
            loginFrame.setVisible(true);
        });
    }
}