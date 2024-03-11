package edu.festu.ivankuznetsov.eventsapp.security;

import org.springframework.security.core.GrantedAuthority;

import edu.festu.ivankuznetsov.eventsapp.model.Role;

public class RoleAuthority implements GrantedAuthority{

    private final Role role;
    
    public RoleAuthority(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.getRoleName();
        
    }
    
}
