package com.chiragji.docuconverter.enums;

import com.itextpdf.text.Rectangle;

/**
 * This enum defines major available sizes for document
 *
 * @author Chirag Gupta (chirag-ji)
 */
public enum PageSize {

    LETTER(com.itextpdf.text.PageSize.LETTER),
    NOTE(com.itextpdf.text.PageSize.NOTE),
    LEGAL(com.itextpdf.text.PageSize.LEGAL),
    TABLOID(com.itextpdf.text.PageSize.TABLOID),
    EXECUTIVE(com.itextpdf.text.PageSize.EXECUTIVE),
    POSTCARD(com.itextpdf.text.PageSize.POSTCARD),
    A0(com.itextpdf.text.PageSize.A0),
    A1(com.itextpdf.text.PageSize.A1),
    A2(com.itextpdf.text.PageSize.A2),
    A3(com.itextpdf.text.PageSize.A3),
    A4(com.itextpdf.text.PageSize.A4),
    A5(com.itextpdf.text.PageSize.A5),
    A6(com.itextpdf.text.PageSize.A6),
    A7(com.itextpdf.text.PageSize.A7),
    A8(com.itextpdf.text.PageSize.A8),
    A9(com.itextpdf.text.PageSize.A9),
    A10(com.itextpdf.text.PageSize.A10),
    B0(com.itextpdf.text.PageSize.B0),
    B1(com.itextpdf.text.PageSize.B1),
    B2(com.itextpdf.text.PageSize.B2),
    B3(com.itextpdf.text.PageSize.B3),
    B4(com.itextpdf.text.PageSize.B4),
    B5(com.itextpdf.text.PageSize.B5),
    B6(com.itextpdf.text.PageSize.B6),
    B7(com.itextpdf.text.PageSize.B7),
    B8(com.itextpdf.text.PageSize.B8),
    B9(com.itextpdf.text.PageSize.B9),
    B10(com.itextpdf.text.PageSize.B10),
    ARCH_E(com.itextpdf.text.PageSize.ARCH_E),
    ARCH_D(com.itextpdf.text.PageSize.ARCH_D),
    ARCH_C(com.itextpdf.text.PageSize.ARCH_C),
    ARCH_B(com.itextpdf.text.PageSize.ARCH_B),
    ARCH_A(com.itextpdf.text.PageSize.ARCH_A),
    FLSA(com.itextpdf.text.PageSize.FLSA),
    FLSE(com.itextpdf.text.PageSize.FLSE),
    HALFLETTER(com.itextpdf.text.PageSize.HALFLETTER),
    _11X17(com.itextpdf.text.PageSize._11X17),
    ID_1(com.itextpdf.text.PageSize.ID_1),
    ID_2(com.itextpdf.text.PageSize.ID_2),
    ID_3(com.itextpdf.text.PageSize.ID_3),
    LEDGER(com.itextpdf.text.PageSize.LEDGER),
    CROWN_QUARTO(com.itextpdf.text.PageSize.CROWN_QUARTO),
    LARGE_CROWN_QUARTO(com.itextpdf.text.PageSize.LARGE_CROWN_QUARTO),
    DEMY_QUARTO(com.itextpdf.text.PageSize.DEMY_QUARTO),
    ROYAL_QUARTO(com.itextpdf.text.PageSize.ROYAL_QUARTO),
    CROWN_OCTAVO(com.itextpdf.text.PageSize.CROWN_OCTAVO),
    LARGE_CROWN_OCTAVO(com.itextpdf.text.PageSize.LARGE_CROWN_OCTAVO),
    DEMY_OCTAVO(com.itextpdf.text.PageSize.DEMY_OCTAVO),
    ROYAL_OCTAVO(com.itextpdf.text.PageSize.ROYAL_OCTAVO),
    SMALL_PAPERBACK(com.itextpdf.text.PageSize.SMALL_PAPERBACK),
    PENGUIN_SMALL_PAPERBACK(com.itextpdf.text.PageSize.PENGUIN_SMALL_PAPERBACK),
    PENGUIN_LARGE_PAPERBACK(com.itextpdf.text.PageSize.PENGUIN_LARGE_PAPERBACK),
    A4_LANDSCAPE(com.itextpdf.text.PageSize.A4_LANDSCAPE);

    private final Rectangle pageDimension;

    PageSize(Rectangle dimension) {
        this.pageDimension = dimension;
    }

    public Rectangle getPageDimension() {
        return pageDimension;
    }
}
