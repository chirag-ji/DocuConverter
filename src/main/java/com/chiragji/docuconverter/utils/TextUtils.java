package com.chiragji.docuconverter.utils;

import java.util.Objects;

public interface TextUtils {
    static boolean isEmpty(CharSequence data) {
        return Objects.isNull(data) || data.toString().trim().isEmpty();
    }
}
