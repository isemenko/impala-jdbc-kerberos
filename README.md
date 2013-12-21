Based on https://github.com/cmconner156/hiveserver2-jdbc-kerberos

To run this, do the following:

- Edit gss-jaas.conf to have the correct principal or no principal if you
want to be promted for princ on command line.
- Edit the krb5.conf with the correct values or copy one of your own over it.
- Compile the project with Maven3
  mvn clean install
- Run "run.sh <url> <krb5.conf>".