# LDAP

Friendly fork of https://github.com/cuba-platform/ldap-addon

1. The minimized version of original addon. All functionality which is not related to ldap-authentication
   was removed from addon.
2. Fix login for old-style user names like _domain\user_ 

____________________

- [Overview](#overview)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
      - [By Coordinates](#by-coordinates)
    - [Configuration](#configuration)
    - [Additional Information](#additional-information)

- [Appendix A. Application Properties](#appendix-a)
- [Release notes](https://github.com/cuba-platform/ldap-addon/releases)

# Overview

The LDAP integration CUBA component provides readily available instruments to enhance any CUBA-based application with the features of a directory server, e.g. Active Directory.
The component is available for CUBA applications of any complexity and does not require any additional third-party
frameworks or libraries.

The component provides the following functionality:

* Using LDAP credentials to log in to CUBA applications 

# Getting Started

## Prerequisites

Before enabling the add-on, configure your directory server.

## Installation

The add-on can be added to your project in one of the ways described below. Installation from the Marketplace is the simplest way. The last version of the add-on compatible with the used version of the platform will be installed.
Also, you can install the add-on by coordinates choosing the required version of the add-on from the table.

In case you want to install the add-on by manual editing or by building from sources see the complete add-ons installation guide in [CUBA Platform documentation](https://doc.cuba-platform.com/manual-latest/manual.html#app_components_usage).

## By Coordinates

1. Open your application in CUBA Studio. Check the latest version of CUBA Studio on the [CUBA Platform site](https://www.cuba-platform.com/download/previous-studio/).
2. Go to *CUBA -> Marketplace* in the main menu.
3. Click the icon in the upper-right corner.

 ![by-coordinates](img/by-coordinates.png)

4. Paste the add-on coordinates in the corresponding field as follows:

 `com.haulmont.addon.ldap:ldap-global:<add-on version>`

 where `<add-on version>` is compatible with the used version of the CUBA platform.

 | Platform Version | Add-on Version   |
|------------------|-------------------|
| 7.2.x            | 1.5.2m            |

5. Click *Install* and apply the changes. The add-on will be installed to your project.

## Configuration

Before using the add-on as a part of your application, configure initial values for connecting to the LDAP server and set up basic attribute names of the LDAP user in the `app.properties` file.
An example of how to set up these properties is given below. Learn more about the application properties in  [Aappendix A](#appendix-a).

```properties
ldap.contextSourceUrl = ldap://localhost:10389
ldap.contextSourceBase = dc=example,dc=com
ldap.contextSourceUserName = uid=admin,ou=system
ldap.contextSourcePassword = secret
cuba.web.standardAuthenticationUsers = admin,anonymous

```

**Note:** If the component is enabled, users cannot log in to the application using CUBA credentials. However, you can permit particular users (e.g. system administrators) to log in using CUBA credentials by specifying their usernames as values of the `cuba.web.standardAuthenticationUsers` property.

## Additional Information

If you want to use the component functionality in several CUBA applications, you have to enable it for each of them separately.

# Component Functionalities

## Predefined roles

- **Default LDAP role** - Default LDAP role, allows user to login with LDAP credentials


# Appendix A. Application Properties <a name='appendix-a'></a>
Before working with the component you need to configure application properties. Specify them in the `app.properties` and `web-app.properties` files of your application.

## `app.properties`

#### ldap.contextSourceUrl

* **Description:** defines a URL for reaching an LDAP server.
* **Default value:** ldap://localhost:10389

#### ldap.contextSourceBase

* **Description:** defines a base DN. If configured, all LDAP operations on contexts retrieved from this ContextSource
relate to this DN. The default value is an empty distinguished name (i.e. all operations relate to the directory root).
* **Default value:** dc=springframework,dc=org

#### ldap.contextSourceUserName

* **Description:** indicates a username (principal) used for authentication. This is normally the distinguished name
of the admin user.
* **Default value:** uid=admin,ou=system

#### ldap.contextSourcePassword

* **Description:** defines a password used for authentication.
* **Default value:** secret

#### cuba.web.standardAuthenticationUsers

* **Description:** defines users that can log in to the system using standard CUBA credentials.
* **Default value:** admin,anonymous
