package cn.com.zzn.persist.service;

import java.util.List;

/**
 * Created by cmwin on 6/18/15.
 */
public interface AAthDao {

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
     * @param newPassword 已经加密的密码
     */
    int updatePassword(Long userId, String newPassword);

    /**
     * 给系统用户设定角色
     * @param userId 用户ID
     * @param roleIds 角色列表
     */
    void addRoles(Long userId, Long... roleIds);

    /**
     * 取消系统用户的角色
     * @param userId 用户ID
     * @param roleIds 角色列表
     */
    void removeRoles(Long userId, Long... roleIds);

    /**
     * 给系统用户设定权限
     * @param userId 用户ID
     * @param permissions 角色列表
     */
    void addPermissions(Long userId, Long... permissions);

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
    public List<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public List<String> findPermissions(String username);
}
