package CashReport.model.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionid;
    private String permission;

    @Override
    public String toString() {
        return "Permission{" +
                "permissionid=" + permissionid +
                ", permission='" + permission + '\'' +
                '}';
    }

    public int getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(int permissionid) {
        this.permissionid = permissionid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
