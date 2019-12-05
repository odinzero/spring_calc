package com.calc.ui.elements.actions;

import com.calc.base.IActionListener;
import com.calc.parser.util;
import java.awt.event.ActionEvent;

public class action_sqrt extends actionCommon {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (getAction_ce_c().isTurnOnCalc()) {

            Number n = util.parseNumber(result.getText());

            result.setText(util.getSqrt(n));
        }
    }

}
