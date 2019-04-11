package com.rules;

import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    private int itemCount;
    private boolean valid;

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
