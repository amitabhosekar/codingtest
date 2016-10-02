package com.ctl;

/**
 * Created by aabhos on 9/30/16.
 */
public enum EmployeeType {

    DEVELOPER, QATESTER, MANAGER;


    public  static Double getAllocation(EmployeeType employeeType){
        switch (employeeType){
            case DEVELOPER:
                return 1000D;
            case QATESTER:
                return 500D;
            case MANAGER:
                return 300D;
            default:
                return null;
        }
    }


}
