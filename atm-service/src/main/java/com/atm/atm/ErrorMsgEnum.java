package com.atm.atm;

public enum ErrorMsgEnum {
        WITHDRAWAL_NOT_POSSIBLE("withdrawal not possible"),
        WITHDRAWAL_IS_POSSIBLE("withdrawal is possible"),
        WITHDRAWAL_DONE("withdrawal done"),
        ERROR_IN_GET_WITHDRAWALS_COUNT("error in get withdrawals count"),
        ERROR_IN_GET_WITHDRAWALS_SUM("error in get withdrawals sum");

    private String msg;

    ErrorMsgEnum(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
