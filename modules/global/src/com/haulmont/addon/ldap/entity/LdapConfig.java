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

package com.haulmont.addon.ldap.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.BaseUuidEntity;

import javax.persistence.Transient;

/**
 * Configuration of the LDAP addon
 */
@MetaClass(name = "ldap$LdapPropertiesConfig")
public class LdapConfig extends BaseUuidEntity {
    private static final long serialVersionUID = 7194701707147252828L;

    @Transient
    @MetaProperty
    private String schemaBase;

    @Transient
    @MetaProperty
    protected String defaultAccessGroupName;

    @Transient
    @MetaProperty
    protected String contextSourceBase;

    @Transient
    @MetaProperty
    protected String contextSourceUserName;

    @Transient
    @MetaProperty
    protected String contextSourceUrl;

    @Transient
    @MetaProperty
    private String ldapUserObjectClasses;

    @Transient
    @MetaProperty
    private String objectClassPropertyName;

    @Transient
    @MetaProperty
    private String attributePropertyNames;

    @Transient
    @MetaProperty
    private String loginAttribute;

    @Transient
    @MetaProperty
    private String emailAttribute;

    @Transient
    @MetaProperty
    private String cnAttribute;

    @Transient
    @MetaProperty
    private String snAttribute;

    @Transient
    @MetaProperty
    protected String givenNameAttribute;

    @Transient
    @MetaProperty
    protected String middleNameAttribute;

    @Transient
    @MetaProperty
    private String memberOfAttribute;

    @Transient
    @MetaProperty
    private String accessGroupAttribute;

    @Transient
    @MetaProperty
    private String positionAttribute;

    @Transient
    @MetaProperty
    private String ouAttribute;

    @Transient
    @MetaProperty
    private String languageAttribute;

    @Transient
    @MetaProperty
    private String inactiveUserAttribute;

    @Transient
    @MetaProperty
    private String userBase;

    public void setDefaultAccessGroupName(String defaultAccessGroupName) {
        this.defaultAccessGroupName = defaultAccessGroupName;
    }

    public String getDefaultAccessGroupName() {
        return defaultAccessGroupName;
    }


    public void setGivenNameAttribute(String givenNameAttribute) {
        this.givenNameAttribute = givenNameAttribute;
    }

    public String getGivenNameAttribute() {
        return givenNameAttribute;
    }

    public void setMiddleNameAttribute(String middleNameAttribute) {
        this.middleNameAttribute = middleNameAttribute;
    }

    public String getMiddleNameAttribute() {
        return middleNameAttribute;
    }


    public void setContextSourceBase(String contextSourceBase) {
        this.contextSourceBase = contextSourceBase;
    }

    public String getContextSourceBase() {
        return contextSourceBase;
    }

    public void setContextSourceUserName(String contextSourceUserName) {
        this.contextSourceUserName = contextSourceUserName;
    }

    public String getContextSourceUserName() {
        return contextSourceUserName;
    }


    public void setContextSourceUrl(String contextSourceUrl) {
        this.contextSourceUrl = contextSourceUrl;
    }

    public String getContextSourceUrl() {
        return contextSourceUrl;
    }


    public String getInactiveUserAttribute() {
        return inactiveUserAttribute;
    }

    public void setInactiveUserAttribute(String inactiveUserAttribute) {
        this.inactiveUserAttribute = inactiveUserAttribute;
    }


    public void setSchemaBase(String schemaBase) {
        this.schemaBase = schemaBase;
    }

    public String getSchemaBase() {
        return schemaBase;
    }

    public void setLdapUserObjectClasses(String ldapUserObjectClasses) {
        this.ldapUserObjectClasses = ldapUserObjectClasses;
    }

    public String getLdapUserObjectClasses() {
        return ldapUserObjectClasses;
    }

    public void setObjectClassPropertyName(String objectClassPropertyName) {
        this.objectClassPropertyName = objectClassPropertyName;
    }

    public String getObjectClassPropertyName() {
        return objectClassPropertyName;
    }

    public void setAttributePropertyNames(String attributePropertyNames) {
        this.attributePropertyNames = attributePropertyNames;
    }

    public String getAttributePropertyNames() {
        return attributePropertyNames;
    }


    public void setLoginAttribute(String loginAttribute) {
        this.loginAttribute = loginAttribute;
    }

    public String getLoginAttribute() {
        return loginAttribute;
    }

    public void setEmailAttribute(String emailAttribute) {
        this.emailAttribute = emailAttribute;
    }

    public String getEmailAttribute() {
        return emailAttribute;
    }

    public void setCnAttribute(String cnAttribute) {
        this.cnAttribute = cnAttribute;
    }

    public String getCnAttribute() {
        return cnAttribute;
    }

    public void setSnAttribute(String snAttribute) {
        this.snAttribute = snAttribute;
    }

    public String getSnAttribute() {
        return snAttribute;
    }

    public void setMemberOfAttribute(String memberOfAttribute) {
        this.memberOfAttribute = memberOfAttribute;
    }

    public String getMemberOfAttribute() {
        return memberOfAttribute;
    }

    public void setAccessGroupAttribute(String accessGroupAttribute) {
        this.accessGroupAttribute = accessGroupAttribute;
    }

    public String getAccessGroupAttribute() {
        return accessGroupAttribute;
    }

    public void setPositionAttribute(String positionAttribute) {
        this.positionAttribute = positionAttribute;
    }

    public String getPositionAttribute() {
        return positionAttribute;
    }

    public void setOuAttribute(String ouAttribute) {
        this.ouAttribute = ouAttribute;
    }

    public String getOuAttribute() {
        return ouAttribute;
    }

    public void setLanguageAttribute(String languageAttribute) {
        this.languageAttribute = languageAttribute;
    }

    public String getLanguageAttribute() {
        return languageAttribute;
    }

    public void setUserBase(String userBase) {
        this.userBase = userBase;
    }

    public String getUserBase() {
        return userBase;
    }

}