package com.example.flightapi.core.context;

/**
 * DynamicContext
 *
 * @author
 */
public class DynamicContext {

    private static final ThreadLocal<DynamicContext> dynamicContextHolder = new ThreadLocal<DynamicContext>();
    private int userId;
    private String currentDate;

    public static DynamicContext getContext() {
        DynamicContext context = dynamicContextHolder.get();
        if (context == null) {
            context = new DynamicContext();
            dynamicContextHolder.set(context);
        }
        return context;
    }

    public static void remove() {
        dynamicContextHolder.remove();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
}
