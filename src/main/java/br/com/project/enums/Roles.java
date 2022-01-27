package br.com.project.enums;

public enum Roles {

    ROLE_GESTOR, ROLE_ADMIN;

    public static Roles getRoleToTypeLogin(TypeLogin typeLogin) {
        if (typeLogin.equals(TypeLogin.ADMIN)) {
            return ROLE_ADMIN;
        }
        if (typeLogin.equals(TypeLogin.GESTOR)) {
            return ROLE_GESTOR;
        }
        return null;
    }
}
