package com.nils.microservices.scoresegment.utils;

public class IdNumberUtils {

    public static boolean isValid(String idNumber) {
        boolean isValid = false;
        if (idNumber.length() == 11) {
            long aTcNo, bTcNo, tcNo;
            long n1, n2, n3, n4, n5, n6, n7, n8, n9, control1, control2;
            tcNo = Long.parseLong(idNumber);
            aTcNo = tcNo / 100;
            bTcNo = tcNo / 100;
            n1 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n2 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n3 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n4 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n5 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n6 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n7 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n8 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n9 = aTcNo % 10;
            control1 = ((10 - ((((n1 + n3 + n5 + n7 + n9) * 3) + (n2 + n4 + n6 + n8)) % 10)) % 10);
            control2 = ((10 - (((((n2 + n4 + n6 + n8) + control1) * 3) + (n1 + n3 + n5 + n7 + n9)) % 10)) % 10);
            isValid = ((bTcNo * 100) + (control1 * 10) + control2 == tcNo);
        }
        return isValid;
    }
}
