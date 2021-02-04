/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.addon.ldap.core.dao;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.entity.UserRole;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static com.haulmont.addon.ldap.core.dao.CubaUserDao.NAME;

@Component(NAME)
public class CubaUserDao {
    public final static String NAME = "ldap_CubaUserDao";

    @Inject
    private Persistence persistence;

    @Inject
    private Metadata metadata;


    @Transactional(readOnly = true)
    public User getOrCreateCubaUser(String login) {
        login = StringUtils.lowerCase(login);
        TypedQuery<User> query = persistence.getEntityManager()
                .createQuery("select cu from sec$User cu where cu.loginLowerCase = :login", User.class);
        query.setParameter("login", login);
        query.setViewName("sec-user-view-with-group-roles");

        User cubaUser = query.getFirstResult();
        if (cubaUser == null) {
            cubaUser = metadata.create(User.class);
            cubaUser.setUserRoles(new ArrayList<>());
            cubaUser.setLogin(login);
        }
        return cubaUser;
    }


    private String getRoleName(UserRole ur) {
        return ur.getRole() != null ? ur.getRole().getName() : ur.getRoleName();
    }

    @Transactional(readOnly = true)
    public List<User> getCubaUsersByLogin(List<String> logins) {
        TypedQuery<User> query = persistence.getEntityManager()
                .createQuery("select cu from sec$User cu where cu.login in :logins", User.class);
        query.setParameter("logins", logins);
        query.setViewName("sec-user-view-with-group-roles");

        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public User getCubaUserByLogin(String login){
        TypedQuery<User> query = persistence.getEntityManager()
                .createQuery("select cu from sec$User cu where cu.loginLowerCase = :login", User.class);
        query.setParameter("login", login.toLowerCase());
        query.setViewName("sec-user-view-with-group-roles");

        return query.getResultList().stream()
                .filter(User::getActive)
                .findFirst().orElse(null);
    }

    private TypedQuery<String> getCubaUsersLoginsAndGroupQuery(List<String> groups, Boolean inverseGroups) {
        String queryString = "select cu.login from sec$User cu";
        TypedQuery<String> query;
        if (CollectionUtils.isNotEmpty(groups)) {
            queryString = queryString + " inner join cu.group cuGroup where cuGroup.name " +
                    (inverseGroups ? "not in" : "in") + " :groups";
            query = persistence.getEntityManager().createQuery(queryString, String.class);
            query.setParameter("groups", groups);
        } else {
            query = persistence.getEntityManager().createQuery(queryString, String.class);
        }

        return query;
    }
}
