package il.cshaifasweng.OCSFMediatorExample.entities;

import java.io.Serializable;

public class UpdateConfirmationMessage implements Serializable {
    private boolean success;
    private String message;

    public UpdateConfirmationMessage(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
