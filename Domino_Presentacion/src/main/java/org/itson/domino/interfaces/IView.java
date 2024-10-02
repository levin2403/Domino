package org.itson.domino.interfaces;

import java.awt.event.ActionListener;

public interface IView {
    void setVisible(boolean visible);
    void addNextFormButtonListener(ActionListener listener);
}
