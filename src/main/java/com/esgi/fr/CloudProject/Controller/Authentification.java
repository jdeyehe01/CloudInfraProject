package com.esgi.fr.CloudProject.Controller;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class Authentification{

    public static boolean authenticate(String username, String password){
        // Set up the environment for creating the initial context
        Hashtable env = new Hashtable();
        DirContext ctx = null;

        boolean state = true;
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldaps://ldap.jumpcloud.com");

// Authenticate as S. User and password (SECURITY_CREDENTIIALS)
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "uid="+username+", ou=Users, o=5bffceccfeb61115cd76f65a, dc=jumpcloud, dc=com");
        env.put(Context.SECURITY_CREDENTIALS, password);

// Create the initial context
        try{
            ctx = new InitialDirContext(env);

            if(ctx == null){
                state = false;
            }

        }catch(NamingException e){
            e.printStackTrace();
            state = false;
        }

        return state;

// ... do something useful with ctx
    }
}
