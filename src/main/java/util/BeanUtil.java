package util;

import javax.faces.context.FacesContext;

public class BeanUtil {

    public static <T> T getBean(String beanName) {
        FacesContext context = FacesContext.getCurrentInstance();
        return getBean(beanName, context);
    }

    public static <T> T getBean(String beanName, FacesContext context) {
        if (context == null) {
            return null;
        }

        try {
            return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
        } catch (NullPointerException e) {
            return null;
        }
    }
}
