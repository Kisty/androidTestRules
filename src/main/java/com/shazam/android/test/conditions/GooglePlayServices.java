package com.shazam.android.test.conditions;

import android.content.pm.PackageManager;

public class GooglePlayServices {

    public static class Available implements Condition {
        @Override
        public boolean isSatisfied() {
            return hasPlayServices();
        }
    }

    public static class NotAvailable implements Condition {
        @Override
        public boolean isSatisfied() {
            return !hasPlayServices();
        }
    }

    private static boolean hasPlayServices() {
        return containsPackage("com.google.android.gms") || containsPackage("com.android.vending");
    }

    private static boolean containsPackage(String packageName) {
        try {
            Modules.packageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
