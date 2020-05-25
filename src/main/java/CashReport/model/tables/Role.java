package CashReport.model.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleid;
    private String role;
    private int permissionid;

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", role='" + role + '\'' +
                ", permissionid=" + permissionid +
                '}';
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(int permissionid) {
        this.permissionid = permissionid;
    }
}
