package com.library;

import com.library.controller.MainController;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.library.view.InventoryView;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.SQLException;

/**
 * @author Loverary Team
 * @version 1.0
 */

public class LibraryManagementSystem {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		// Setting the look and feel for the app
        UIManager.setLookAndFeel(new FlatMacDarkLaf());
        java.awt.EventQueue.invokeLater(LibraryManagementSystem::run);
	}

    private static void run() {
        try {
            MainController.setView(new InventoryView());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
