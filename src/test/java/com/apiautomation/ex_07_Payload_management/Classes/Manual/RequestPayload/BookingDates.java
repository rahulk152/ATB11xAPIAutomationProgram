package com.apiautomation.ex_07_Payload_management.Classes.Manual.RequestPayload;

public class BookingDates {
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    private String checkin;
    private String checkout;
}
