package com.chiragji.docuconverter.utils;

import java.util.Objects;

public abstract class TextUtils {
    public static boolean isEmpty(CharSequence data) {
        return Objects.isNull(data) || data.toString().trim().isEmpty();
    }
}
