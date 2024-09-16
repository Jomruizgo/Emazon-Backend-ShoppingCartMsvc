package com.emazon.msvc_shopping_cart.domain.util;

public enum UserRole {
    ADMIN("ADMINISTRATOR"),
    CLIENT("CLIENT"),
    WAREHOUSE("WAREHOUSE_ASSISTANT");

    private final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
