package cn.com.zzn.persist.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cmwin on 6/18/15.
 */
public interface AAthMapper {
//    /**
//     * 在数据库中创建用户
//     * @param user 创建的用户
//     * @return 系统用户
//     */
//    int createUser(SysUsers user);
//
//    /**
//     * 根据用户ID，查找出系统用户情报
//     * @param id 用户ID
//     * @return 系统用户
//     */
//    SysUsers findUserById(Long id);
//
//    /**
//     * 根据用户名查找用户情报
//     * @param username 用户名称
//     * @return 系统用户
//     */
//    SysUsers findUserByName(String username);

    /**
     * 修改密码
     * @param userId 用户ID
     * @param password 已经加密的密码
     */
    int updatePassword(@Param("userId") Long userId, @Param("password") String password);

    /**
     * 给系统用户设定角色
     * @param userId 用户ID
     * @param roleId 角色列表
     */
    void addRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 取消系统用户的角色
     * @param userId 用户ID
     * @param roleIds 角色列表
     */
    void removeRoles(Long userId, Long... roleIds);

    /**
     * 给系统用户设定权限
     * @param userId 用户ID
     * @param permissionId 角色列表
     */
    void addPermission(@Param("userId") Long userId, @Param("permissionId") Long permissionId);

    /**
     * 取消系统用户的权限
     * @param userId 用户ID
     * @param permissions 角色列表
     */
    void removePermissions(Long userId, Long... permissions);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    List<String> findRoles(@Param("username") String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    List<String> findPermissions(@Param("username") String username);
}
