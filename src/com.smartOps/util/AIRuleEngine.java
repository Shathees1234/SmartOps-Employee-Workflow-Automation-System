package com.smartops.util;

public class AIRuleEngine {

    public static String evaluateLeave(int leaveDays, int remainingLeave) {

        if (leaveDays <= 0)
            return "INVALID LEAVE";

        if (leaveDays > remainingLeave)
            return "REJECTED - INSUFFICIENT BALANCE";

        if (leaveDays <= 2)
            return "AUTO-APPROVED";

        if (leaveDays <= 5)
            return "MANAGER APPROVAL REQUIRED";

        return "REJECTED";
    }
}
