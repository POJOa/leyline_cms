package org.escapar.cms.infrastructure.security;

import java.util.Arrays;
import java.util.List;

import org.escapar.leyline.framework.domain.user.LeylineUser;
import org.escapar.leyline.framework.interfaces.dto.LeylineDTO;

import lombok.Data;

@Data public class RoleDTO implements LeylineDTO {
    private String username;
    private String displayName;
    private String avatar;
    private List<String> roles;

    public static RoleDTO fromUser(LeylineUser w){
        RoleDTO r = new RoleDTO();
        r.setAvatar("");
        r.setDisplayName(w.getName());
        r.setUsername(w.getUsername());
        r.setRoles(Arrays.asList(ROLE_CONSTS.getState(w.getRole())));
        return r;
    }
    public String getUsername() {
        return username;
    }

    public RoleDTO setUsername( String username) {
        this.username = username;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public RoleDTO setDisplayName( String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public RoleDTO setAvatar( String avatar) {
        this.avatar = avatar;
        return this;
    }

    public List<String> getRoles() {
        return roles;
    }

    public RoleDTO setRoles( List<String> roles) {
        this.roles = roles;
        return this;
    }
}
