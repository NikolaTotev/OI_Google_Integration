package com.ocado.bootcamp.server.user.service;

import com.ocado.bootcamp.server.user.model.Permission;
import com.ocado.bootcamp.server.user.model.UserRole;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Map.entry;

public class UserService {
    private final Map<UserRole, Permission[]> roleToPermission = Map.ofEntries(
            entry(UserRole.DEFAULT, new Permission[]{Permission.CREATE_EVENT, Permission.VIEW_OWN_EVENTS, Permission.VIEW_APPROVED}),
            entry(UserRole.CENTRAL, new Permission[]{Permission.CREATE_EVENT, Permission.VIEW_OWN_EVENTS, Permission.VIEW_APPROVED,
                                                        Permission.APPROVE, Permission.VIEW_NOT_APPROVED}));

    private UserRole getUserRole(int userId) {
        return null;
    }

}
