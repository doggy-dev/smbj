/*
 * Copyright (C)2016 - SMBJ Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hierynomus.smbj.auth;

import java.util.Arrays;

public class AuthenticationContext {
    private final String username;
    private final char[] password;
    private final String domain;

    public AuthenticationContext(String username, char[] password, String domain) {
        this.username = username;
        this.password = Arrays.copyOf(password, password.length);
        this.domain = domain;
    }

    public static AuthenticationContext anonymous() {
        return new AuthenticationContext("", new char[0], null);
    }

    public static AuthenticationContext guest() {
        return new AuthenticationContext("Guest", new char[0], null);
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }

    public String getDomain() {
        return domain;
    }

    public boolean isAnonymous() {
        return username.isEmpty() && password.length == 0;
    }

    public boolean isGuest() {
        return username.equals("Guest") && password.length == 0;
    }

    @Override
    public String toString() {
        return "AuthenticationContext[" + username + '@' + domain + ']';
    }
}
