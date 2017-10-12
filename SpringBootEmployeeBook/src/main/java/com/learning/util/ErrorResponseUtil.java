package com.learning.util;

import com.learning.enums.CommonEnum;
import com.learning.model.dto.MessageDTO;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * Created by mudassir on 06/02/2017.
 */
public class ErrorResponseUtil {

    public static MessageDTO getApplicableErrorMessage(String defaultMessage) {
        ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
        bean.setBasename("messages");
        Locale currentLocale = LocaleContextHolder.getLocale();
        String msg = bean.getMessage(defaultMessage, null, currentLocale);
        return new MessageDTO(msg, CommonEnum.ERROR.toString());
    }
}
