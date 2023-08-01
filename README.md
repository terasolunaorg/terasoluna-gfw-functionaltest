# Functional Test of TERASOLUNA Server Framework for Java (5.x) Common Library
This project provides functional tests of [TERASOLUNA Server Framework for Java (5.x) Common Library](https://github.com/terasolunaorg/terasoluna-gfw).

## How to contribute
**Contributing (bug report, pull request, any comments etc.) is welcome !!** Please see the [contributing guideline](CONTRIBUTING.md) for details.

## Test case design

Test case scenarios are managed at [wiki pages](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest/wiki).

> **Note:**
>
> Currently, support language is Japanese only. (Will translate to English as soon as possible)

## Tested environments at the time of release

Tested environments are managed at [wiki page](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest/wiki/Tested-Environment).

## How to perform functional test

**Preconditions are as follow:**

* [JDK 17](https://developers.redhat.com/products/openjdk/download) installed (`JAVA_HOME` defined as environment variable)
* [Maven](https://maven.apache.org/download.cgi) installed (Can run `mvn` command)
* Firefox([for personal](https://www.mozilla.org/en-US/firefox/all/) or [ESR](https://www.mozilla.org/en-US/firefox/organizations/all/)) installed (ESR is used on our CI environment)

### [Step 1] Create database of PostgreSQL (Optional)
If [PostgreSQL](http://www.postgresql.org/) use as database , you need to create database of PostgreSQL into local machine. (PostgreSQL can download via [here site](http://www.postgresql.org/download/)).

> **Note:**
>
> If [H2](http://www.h2database.com/) use as database, you can skip this step.

#### Download & install
By default, database owner is `postgres` user, and password of `postgres` user is `'P0stgres'`.

#### Create database
```console
$ createdb -U postgres terasoluna-gfw-functionaltest --locale=C --encoding=UTF8 --template=template0
```

### [Step 2] Clone a repository
Clone the `terasolunaorg/terasoluna-gfw-functionaltest` repository into local machine.

```console
$ git clone https://github.com/terasolunaorg/terasoluna-gfw-functionaltest.git
```

### [Step 3] Build artifacts
Build artifacts using maven commands as follows.

#### Case that use embedded H2 as database

The commands are different for XML-based configuration and Java-based configuration.

** XML-based configuration **

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web,terasoluna-gfw-functionaltest-selenium
```

** Java-based configuration **

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web,terasoluna-gfw-functionaltest-selenium -P warpack-env,warpack-jstl,java-config
```

#### Case that use PostgreSQL as database

The commands are different for XML-based configuration and Java-based configuration.

** XML-based configuration **

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web,terasoluna-gfw-functionaltest-selenium -P tomcat10-postgresql,warpack-env,warpack-jstl,travis,xml-config
```

** Java-based configuration **

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web,terasoluna-gfw-functionaltest-selenium -P tomcat10-postgresql,warpack-env,warpack-jstl,travis,java-config
```

> **Note:**
>
> If you not use default user(`postgres`) or password(`P0stgres`), you should modify settings in `terasoluna-gfw-functionaltest-env/configs/travis/ContainerConfigXML/context.xml`.

### [Step 4] Initialize database (Optional)
If PostgreSQL use as database, initialize database before run functional test.

```console
$ mvn -U sql:execute -pl terasoluna-gfw-functionaltest-initdb
```

> **Note:**
>
> If you not use default user(`postgres`) or password(`P0stgres`), you should specify `-Ddb.username={your user}` or `-Ddb.password={your password}` or both.

### [Step 5] Startup Tomcat9 and deploy war file
Startup Tomcat9 and deploy war file using [CARGO maven plugin](https://codehaus-cargo.github.io/cargo/Maven2+plugin.html).

#### Case that use embedded H2 as database

```console
$ cd {your repository directory}
$ mvn -U cargo:run -pl terasoluna-gfw-functionaltest-web
```

#### Case that use PostgreSQL as database (use Tomcat JNDI Resource)

```console
$ cd {your repository directory}
$ mvn -U cargo:run -pl terasoluna-gfw-functionaltest-web -P travis
```

> **Note:**
>
> Shutdown trigger is "Ctrl + C" on console.

### [Step 6] Run functional tests
Run tests using Selenium(`WebDriver`) on JUnit.

The commands are different for XML-based configuration and Java-based configuration.

** XML-based configuration **

```console
$ cd {your repository directory}
$ mvn -U test -pl terasoluna-gfw-functionaltest-selenium-xmlconfig -Dwdm.cachePath=/opt/geckodriver -Dwdm.geckoDriverVersion=0.32.0
```

** Java-based configuration **

```console
$ cd {your repository directory}
$ mvn -U test -pl terasoluna-gfw-functionaltest-selenium-javaconfig -Dwdm.cachePath=/opt/geckodriver -Dwdm.geckoDriverVersion=0.32.0
```

> **Note:**
>
> If functional test is failed, try again using latest Selenium(specify with `-Dselenium.version={latest version}`).
> Please also refer [tested environment](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest/wiki/Tested-Environment) for more information about our tested environment. At last, please check [selenium changelog](https://github.com/SeleniumHQ/selenium/blob/master/java/CHANGELOG) to make sure your Firefox version is supported.

> **Note:**
>
> By default, [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) will download the latest [geckodriver](https://github.com/mozilla/geckodriver/releases) to `~/.cache/selenium` automatically.
> If you want to specify the download destination directory, please specify "`-Dwdm.cachePath`" in the startup argument.
> To specify the version of geckoDriver, specify "`-Dwdm.geckoDriverVersion`" in the startup argument.
>
> See [advanced-configuration](https://bonigarcia.dev/webdrivermanager/#advanced-configuration) for details on configuration.

## Appendix

### How to use latest or any branch snapshot of Common Library

If latest or any branch snapshot of Common Library want to use, install latest or any branch snapshot before build and test.

#### Clone terasoluna-gfw repository into local machine

```console
$ git clone https://github.com/terasolunaorg/terasoluna-gfw.git
```

#### Install latest or any branch snapshot of Common Library into local machine

```console
$ cd {your repository directory of terasoluna-gfw}
$ git checkout {target branch}
$ mvn clean install
```

### Project configuration description

```
terasoluna-gfw-functionaltest
├─terasoluna-gfw-functionaltest-domain
├─terasoluna-gfw-functionaltest-env
├─terasoluna-gfw-functionaltest-initdb
├─terasoluna-gfw-functionaltest-javaconfig
├─terasoluna-gfw-functionaltest-selenium
├─terasoluna-gfw-functionaltest-selenium-javaconfig
├─terasoluna-gfw-functionaltest-selenium-xmlconfig
├─terasoluna-gfw-functionaltest-web
└─terasoluna-gfw-functionaltest-xmlconfig
```

- ** terasoluna-gfw-functionaltest-domain **

  A project that stores classes and configuration files related to the domain layer

- ** terasoluna-gfw-functionaltest-env **

  A project that stores environment-dependent files, etc.

- ** terasoluna-gfw-functionaltest-initdb **

  A project that manages the SQL file for initializing the database

- ** terasoluna-gfw-functionaltest-javaconfig **

  A project that manages Java-based configuration definitions

- ** terasoluna-gfw-functionaltest-selenium **

  A project that manages common modules used in selenium tests

- ** terasoluna-gfw-functionaltest-selenium-javaconfig **

  A project to manage selenium tests running in an Java-based configuration

- ** terasoluna-gfw-functionaltest-selenium-xmlconfig **

  A project to manage selenium tests running in an XML-based configuration

- ** terasoluna-gfw-functionaltest-web **

  A project that stores classes and configuration files related to the application layer

- ** terasoluna-gfw-functionaltest-xmlconfig **

  A project that manages XML-based configuration definitions
