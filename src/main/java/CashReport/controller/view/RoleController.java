package CashReport.controller.view;

import CashReport.model.Role;
import CashReport.repository.RoleRepo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    RoleRepo roleRepo;

    public RoleController(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Role addRole(@RequestBody Role role) {
        return roleRepo.save(role);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteRole(@PathVariable("id") int id) {
        roleRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize(("has('ROLE_ADMIN')"))
    public Role updateRole(Role role) {
        Role role1 = new Role();
        role1.setRoleid(role.getRoleid());
        role1.setRole(role.getRole());
        role1.setPermissionid(role.getPermissionid());
        return roleRepo.save(role1);
    }
}
