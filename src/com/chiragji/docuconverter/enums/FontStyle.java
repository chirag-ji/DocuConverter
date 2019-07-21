package com.chiragji.docuconverter.enums;

import com.itextpdf.text.Font;

/**
 * @author Chirag Gupta (chirag-ji)
 */
public enum FontStyle {
    NORMAL(Font.NORMAL),
    BOLD(Font.BOLD),
    ITALIC(Font.ITALIC),
    UNDERLINE(Font.UNDERLINE),
    STRIKETHRU(Font.STRIKETHRU),
    BOLDITALIC(Font.BOLDITALIC),
    UNDEFINED(Font.UNDEFINED),
    DEFAULTSIZE(Font.DEFAULTSIZE);

    private final int style;

    FontStyle(int style) {
        this.style = style;
    }

    public int getStyle() {
        return style;
    }
}
